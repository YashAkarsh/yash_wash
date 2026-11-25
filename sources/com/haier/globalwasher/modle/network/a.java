package com.haier.globalwasher.modle.network;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.widget.TextView;
import com.google.gson.f;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.utils.f0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.m0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.mvp_api.volley.d;
import com.haier.globalwasher.mvp_api.volley.myvolley.j;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.LoginActivity;
import com.loopj.android.http.c;
import com.loopj.android.http.l;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> implements com.haier.globalwasher.mvp_api.moudle.b<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f24508d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24509e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24510f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f24511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.haier.globalwasher.modle.utils.loading.a f24512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24513c = "RequestNetWork";

    /* JADX INFO: renamed from: com.haier.globalwasher.modle.network.a$a, reason: collision with other inner class name */
    class RunnableC0319a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f24514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f24516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f24517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f24518e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f24519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f24520g;

        RunnableC0319a(Map map, String str, Context context, int i7, String str2, Class cls, int i8) {
            this.f24514a = map;
            this.f24515b = str;
            this.f24516c = context;
            this.f24517d = i7;
            this.f24518e = str2;
            this.f24519f = cls;
            this.f24520g = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Map<String, String> mapM = a.m(this.f24514a, this.f24515b);
                for (String str : mapM.keySet()) {
                    q.c("RequestNetWork", "key=" + str + "--map.get(key)=" + ((String) this.f24514a.get(str)));
                }
                a.this.k(this.f24516c, this.f24517d);
                j jVar = new j(this.f24518e, a.this, mapM, this.f24519f, this.f24520g);
                q.c("RequestNetWork_PostXCList", "" + this.f24518e);
                jVar.P(new d(30000, 0, 1.0f));
                jVar.R(false);
                com.haier.globalwasher.mvp_api.volley.myvolley.d.d().a(jVar);
            } catch (Exception e8) {
                q.c("RequestNetWork", e8.toString());
            }
        }
    }

    class b implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f24522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f24523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StringBuilder f24524c;

        b(String str, Map map, StringBuilder sb) {
            this.f24522a = str;
            this.f24523b = map;
            this.f24524c = sb;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            DataOutputStream dataOutputStream;
            BufferedReader bufferedReader = null;
            try {
                try {
                    URLConnection uRLConnectionOpenConnection = new URL(this.f24522a).openConnection();
                    uRLConnectionOpenConnection.setDoInput(true);
                    uRLConnectionOpenConnection.setDoOutput(true);
                    dataOutputStream = new DataOutputStream(uRLConnectionOpenConnection.getOutputStream());
                    try {
                        StringBuilder sb = new StringBuilder();
                        for (String str : this.f24523b.keySet()) {
                            sb.append(str + "=" + URLEncoder.encode((String) this.f24523b.get(str), "UTF-8") + m0.a.f37445e);
                        }
                        dataOutputStream.writeBytes(sb.toString());
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(uRLConnectionOpenConnection.getInputStream(), "UTF-8"));
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                this.f24524c.append(line);
                            } catch (Exception e8) {
                                e = e8;
                                bufferedReader = bufferedReader2;
                                a.this.a(e);
                                this.f24524c.append(com.paytm.pgsdk.d.f33018u);
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (dataOutputStream != null) {
                                }
                                return this.f24524c.toString();
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                throw th;
                            }
                        }
                        bufferedReader2.close();
                    } catch (Exception e9) {
                        e = e9;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e10) {
                e = e10;
                dataOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
            }
            dataOutputStream.close();
            return this.f24524c.toString();
        }
    }

    public static Map<String, String> m(Map<String, String> map, String str) throws Exception {
        JSONObject jSONObject;
        Map<String, String> map2 = map == null ? new HashMap<>() : map;
        JSONObject jSONObject2 = new JSONObject();
        Iterator<Map.Entry<String, String>> it = map2.entrySet().iterator();
        while (true) {
            Map<String, String> map3 = map2;
            JSONObject jSONObject3 = jSONObject2;
            if (!it.hasNext()) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                String str2 = simpleDateFormat.format(simpleDateFormat.parse(simpleDateFormat.format(date)));
                q.a("RequestNetWork", "" + jSONObject3.toString());
                String str3 = new String(Base64.encodeBase64(m0.c(("appId=hl7c87b100fc2143a&appSecret=759fcd66ad674c80a250753bd7fd5fcb&timestamp=" + str2).getBytes())), "UTF-8");
                byte[] bArrB = m0.b(new String(i2.a.f34108j.getBytes(), "UTF-8"), jSONObject3.toString().getBytes("UTF-8"));
                String str4 = new String(Base64.encodeBase64(bArrB), "UTF-8");
                String str5 = new String(Base64.encodeBase64(m0.d(new String(i2.a.f34111k.getBytes(), "UTF-8"), bArrB)), "UTF-8");
                map3.put("bizcontent", str4);
                map3.put("sign", str5);
                map3.put("nonce", str3);
                map3.put("tokenId", t2.a.a(MyApplication.k(), t2.a.f40354a, t2.a.f40355b));
                map3.put("timestamp", str2);
                map3.put("appId", "hl7c87b100fc2143a");
                map3.put("method", str);
                map3.put("format", "JSON");
                map3.put("charset", "UTF-8");
                map3.put("version", i2.a.f34096f);
                Configuration configuration = MyApplication.k().getResources().getConfiguration();
                map3.put("country", configuration.locale.getCountry());
                map3.put("language", configuration.locale.getLanguage());
                map3.put("timeZone", f0.c());
                return map3;
            }
            Map.Entry<String, String> next = it.next();
            Iterator<Map.Entry<String, String>> it2 = it;
            String key = next.getKey();
            if (key.equals("tokenId") || key.equals("appId") || key.equals("timestamp") || key.equals("nonce") || key.equals("method") || key.equals("format") || key.equals("charset") || key.equals("version") || key.equals("country") || key.equals("language") || key.equals("bizcontent") || key.equals("outAccess") || key.equals("sign") || key.equals("timeZone")) {
                jSONObject = jSONObject3;
            } else {
                q.c("RequestNetWork", "key=" + next.getKey() + "--map.get(key)=" + next.getValue());
                jSONObject = jSONObject3;
                jSONObject.put(next.getKey(), next.getValue());
            }
            map2 = map3;
            jSONObject2 = jSONObject;
            it = it2;
        }
    }

    private void o(String str, String str2) {
        if (!"10017".equals(str) && !"10001".equals(str)) {
            if ("00000".equals(str)) {
                return;
            }
            i0.d(this.f24511a, str2 + "");
            return;
        }
        ProfileAvatarImageBeen.getInstance().initRegisterBeen();
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40355b, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40356c, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40357d, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40359f, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40358e, "");
        if (this.f24511a != null) {
            this.f24511a.startActivity(new Intent(this.f24511a, (Class<?>) LoginActivity.class));
        }
    }

    @Override // com.haier.globalwasher.mvp_api.moudle.b
    public void a(Exception exc) {
        q.c("RequestNetWork", exc.toString());
        Context context = this.f24511a;
        if (context != null) {
            if (exc instanceof IllegalStateException) {
                i0.d(context, "App 参数解析异常：IllegalStateException");
            } else {
                String string = context.getResources().getString(R.string.signature_verification_failed);
                if (string.equals(exc.getMessage())) {
                    Context contextK = this.f24511a;
                    if (contextK == null) {
                        contextK = MyApplication.k();
                    }
                    i0.d(contextK, string);
                } else {
                    Context contextK2 = this.f24511a;
                    if (contextK2 == null) {
                        contextK2 = MyApplication.k();
                    }
                    i0.d(contextK2, MyApplication.k().getResources().getString(R.string.please_check_the_network));
                }
            }
        }
        i(exc);
        com.haier.globalwasher.modle.utils.loading.a aVar = this.f24512b;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.haier.globalwasher.mvp_api.moudle.b
    public void b(T t7) {
        try {
            if (t7 instanceof BaseData) {
                BaseData baseData = (BaseData) t7;
                o(baseData.getRetCode(), baseData.getRetInfo());
            } else if (t7 instanceof BaseListDate) {
                BaseListDate baseListDate = (BaseListDate) t7;
                o(baseListDate.getRetCode(), baseListDate.getRetInfo());
            }
            p(t7);
        } finally {
            com.haier.globalwasher.modle.utils.loading.a aVar = this.f24512b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void f(int i7, Context context, String str, l lVar, c cVar) {
        String strA = t2.a.a(MyApplication.k(), t2.a.f40354a, t2.a.f40355b);
        if (str.contains(i2.a.f34120n) && (strA == null || "".equals(strA))) {
            return;
        }
        this.f24511a = context;
        new com.loopj.android.http.a(true, 80, 443).F(str, lVar, cVar);
    }

    public void g(int i7, Context context, String str, String str2, Map<String, String> map, Class cls, int i8) {
        if (h(str, cls, i8)) {
            this.f24511a = context;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new RunnableC0319a(map, str2, context, i7, str, cls, i8));
            }
        }
    }

    public boolean h(String str, Class cls, int i7) {
        String strA = t2.a.a(MyApplication.k(), t2.a.f40354a, t2.a.f40355b);
        if (i2.a.P1.equals(str) || !str.contains(i2.a.f34120n) || (strA != null && !"".equals(strA))) {
            return true;
        }
        if (cls == null) {
            BaseData baseData = new BaseData();
            baseData.setRetCode("10001");
            baseData.setRetInfo("");
            baseData.setData(new Object());
            b(baseData);
            return false;
        }
        if (i7 == 1) {
            BaseData baseData2 = new BaseData();
            baseData2.setRetCode("10001");
            baseData2.setRetInfo("");
            b(baseData2);
            return false;
        }
        if (i7 != 2) {
            return false;
        }
        BaseListDate baseListDate = new BaseListDate();
        baseListDate.setRetCode("10001");
        baseListDate.setRetInfo("");
        baseListDate.setData(new ArrayList());
        b(baseListDate);
        return false;
    }

    public abstract void i(Exception exc);

    public com.haier.globalwasher.mvp_api.volley.myvolley.c<T> j(int i7, Context context, String str, String str2, Map<String, String> map, Class cls, int i8) {
        Map<String, String> map2;
        if (!h(str, cls, i8)) {
            return null;
        }
        Map map3 = new HashMap();
        if (context != null) {
            try {
                this.f24511a = context;
                k(context, i7);
            } catch (Exception e8) {
                q.c("RequestNetWork", e8.toString());
                return null;
            }
        }
        if (map == null) {
            map2 = new HashMap<>();
        } else {
            map3 = m(map, str2);
            map2 = map;
        }
        String str3 = str;
        int i9 = 0;
        for (String str4 : map3.keySet()) {
            if (str4.equals("tokenId") || str4.equals("appId") || str4.equals("timestamp") || str4.equals("nonce") || str4.equals("method") || str4.equals("format") || str4.equals("charset") || str4.equals("version") || str4.equals("country") || str4.equals("language") || str4.equals("bizcontent") || str4.equals("outAccess") || str4.equals("sign") || str4.equals("timeZone")) {
                i9++;
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(i9 == 1 ? "?" : m0.a.f37445e);
                str3 = sb.toString() + str4 + "=" + map2.get(str4);
                q.c("RequestNetWork", "key=" + str4 + "--map.get(key)=" + map2.get(str4));
            }
        }
        q.c("RequestNetWork_getXCList", "" + str3);
        com.haier.globalwasher.mvp_api.volley.myvolley.c<T> cVar = new com.haier.globalwasher.mvp_api.volley.myvolley.c<>(0, str3, this, cls, i8);
        cVar.P(new d(30000, 0, 1.0f));
        cVar.R(false);
        com.haier.globalwasher.mvp_api.volley.myvolley.d.d().a(cVar);
        return cVar;
    }

    public void k(Context context, int i7) {
        if (this.f24512b == null) {
            this.f24512b = new com.haier.globalwasher.modle.utils.loading.a(context, i7, false);
        }
        this.f24512b.c();
    }

    public void l(String str, TextView textView) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(Context context, int i7, String str, Map<String, String> map, T t7) {
        this.f24511a = context;
        String strA = t2.a.a(MyApplication.k(), t2.a.f40354a, t2.a.f40355b);
        if (strA == null || "".equals(strA)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        k(context, i7);
        FutureTask futureTask = new FutureTask(new b(str, map, sb));
        new Thread(futureTask).start();
        try {
            String str2 = (String) futureTask.get();
            if (str2.endsWith(com.paytm.pgsdk.d.f33018u)) {
                return;
            }
            b(new f().n(str2, t7.getClass()));
        } catch (Exception e8) {
            a(e8);
        }
    }

    public abstract void p(T t7);
}
