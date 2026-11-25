package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class PayResultActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13557a = "{\"isLogin\":\"false\"}";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Object> f13558b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13559c = "hk.alipay.wallet";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13560d = "phonecashier.pay.hash";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13561e = "orderSuffix";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13562f = "externalPkgName";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13563g = "phonecashier.pay.result";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13564h = "phonecashier.pay.resultOrderHash";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f13565i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static volatile String f13566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static volatile String f13567b;
    }

    private static void a(Activity activity, int i7) {
        new Handler().postDelayed(new g(activity), i7);
    }

    private static void b(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage(f13559c);
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e8) {
            e8.printStackTrace();
            com.alipay.sdk.util.d.f("msp", "PayTask:payReuslt: UnsupportedEncodingException:" + e8);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable unused) {
                activity.finish();
            }
        }
    }

    private static void c(String str) {
        a.f13567b = k.f();
        e(f13558b, str);
    }

    private static void d(String str, String str2) {
        a.f13567b = str;
        e(f13558b, str2);
    }

    private static boolean e(HashMap<String, Object> map, String str) {
        Object obj;
        if (map == null || str == null || (obj = map.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra(f13561e))) {
                a.f13566a = intent.getStringExtra(f13560d);
                b(this, a.f13566a, intent.getStringExtra(f13561e), intent.getStringExtra(f13562f));
                a(this, 300);
                return;
            }
            String stringExtra = intent.getStringExtra(f13563g);
            int intExtra = intent.getIntExtra(f13564h, 0);
            if (intExtra != 0 && TextUtils.equals(a.f13566a, String.valueOf(intExtra))) {
                if (TextUtils.isEmpty(stringExtra)) {
                    c(a.f13566a);
                } else {
                    d(stringExtra, a.f13566a);
                }
                a.f13566a = "";
                a(this, 300);
                return;
            }
            com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.f13627b0, "Expected " + a.f13566a + ", got " + intExtra);
            c(a.f13566a);
            a(this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }
}
