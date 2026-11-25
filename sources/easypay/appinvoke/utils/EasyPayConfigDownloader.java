package easypay.appinvoke.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.app.JobIntentService;
import c.m0;
import c.o0;
import com.haier.uhome.account.api.Const;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.PaytmAssist;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EasyPayConfigDownloader extends JobIntentService {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f33843p = 2321;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    SharedPreferences f33844l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private SharedPreferences f33845m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f33846n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f33847o;

    public interface a {
        void a(String str);

        void b(String str);
    }

    public EasyPayConfigDownloader() {
    }

    public static void n(Context context, Intent intent) {
        JobIntentService.d(context, EasyPayConfigDownloader.class, f33843p, intent);
    }

    @Override // androidx.core.app.JobIntentService
    protected void h(@m0 Intent intent) {
        this.f33845m = getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0);
        this.f33844l = getSharedPreferences(Constants.EASY_PAY_ETAG_PREF, 0);
        this.f33847o = intent.getStringExtra(Constants.EXTRA_BANK_REQ_JSON);
        l();
    }

    public void l() {
        try {
            if (System.currentTimeMillis() - this.f33845m.getLong("easypay_configuration_load_timestamp", 0L) > this.f33845m.getLong("easypay_configuration_ttl", 0L)) {
                String configUrlToHit = PaytmAssist.getAssistInstance().getConfigUrlToHit();
                b.a("EasyPay Config requestURL:" + configUrlToHit, this);
                if (TextUtils.isEmpty(configUrlToHit) || !m(configUrlToHit)) {
                    return;
                }
                SharedPreferences.Editor editorEdit = this.f33845m.edit();
                editorEdit.putLong("easypay_configuration_load_timestamp", System.currentTimeMillis());
                editorEdit.apply();
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            b.a("EXCEPTION", e8);
        }
    }

    public boolean m(String str) {
        try {
            URL url = new URL(str);
            b.a("url:" + url.toString(), this);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(com.haier.uhome.usdk.base.a.ba);
            httpURLConnection.setConnectTimeout(13000);
            httpURLConnection.setRequestMethod(Const.HTTP_REQUEST_TYPE_POST);
            JSONObject jSONObject = new JSONObject(this.f33847o);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bankName", jSONObject.getString(Constants.EXTRA_BANK_CODE));
            jSONObject2.put("payMode", jSONObject.getString("payType"));
            if (jSONObject.getString("payType").equals(Constants.EASYPAY_PAYTYPE_NETBANKING)) {
                jSONObject2.put(Constants.EXTRA_BANK_SCHEME, (Object) null);
            } else {
                jSONObject2.put(Constants.EXTRA_BANK_SCHEME, jSONObject.getString(Constants.EXTRA_BANK_SCHEME));
            }
            jSONObject2.put("orderId", PaytmAssist.getAssistInstance().getOrderId());
            jSONObject2.put("mid", PaytmAssist.getAssistInstance().getMid());
            jSONObject2.put("deviceType", "ANDROID");
            b.a("resquestBody:" + jSONObject2.toString(), this);
            String strA = d.a(this, jSONObject.getString(Constants.EXTRA_BANK_CODE), jSONObject.getString("payType"), jSONObject.getString(Constants.EXTRA_BANK_SCHEME));
            if (strA == null) {
                strA = "";
            }
            httpURLConnection.setRequestProperty(com.google.common.net.c.f22182z, strA);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(jSONObject2.toString().getBytes());
            outputStream.close();
            b.a("EasyPay Config requestbody:" + jSONObject2.toString(), this);
            String headerField = httpURLConnection.getHeaderField(com.google.common.net.c.f22149i0);
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5120);
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedInputStream.close();
                    b.a("unique Assist Config response" + sb.toString(), this);
                    d.b(this, sb.toString(), headerField);
                    Intent intent = new Intent();
                    intent.setAction(Constants.EASYPAY_ACTION_FILE_DOWNLOADED);
                    sendBroadcast(intent);
                    return true;
                }
                sb.append(line);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public void o(a aVar) {
        this.f33846n = aVar;
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onStart(@o0 Intent intent, int i7) {
        super.onStart(intent, i7);
    }

    public EasyPayConfigDownloader(a aVar, Context context, Intent intent) {
        o(aVar);
        n(context, intent);
    }
}
