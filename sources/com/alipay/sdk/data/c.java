package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.app.j;
import com.alipay.sdk.util.o;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f13695d = "virtualImeiAndImsi";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f13696e = "virtual_imei";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f13697f = "virtual_imsi";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static c f13698g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13700b = "sdk-and-lite";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13701c;

    private c() {
        String strA = j.a();
        if (j.c()) {
            return;
        }
        this.f13700b += '_' + strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Context context, HashMap<String, String> map) {
        String strGetApdid;
        try {
            strGetApdid = SecurityClientMobile.GetApdid(context, map);
        } catch (Throwable th) {
            com.alipay.sdk.util.d.d(th);
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13644o, com.alipay.sdk.app.statistic.c.f13647r, th);
            strGetApdid = "";
        }
        if (TextUtils.isEmpty(strGetApdid)) {
            com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13644o, com.alipay.sdk.app.statistic.c.f13648s, "apdid == null");
        }
        com.alipay.sdk.util.d.h("msp", "apdid:" + strGetApdid);
        return strGetApdid;
    }

    public static synchronized c g() {
        if (f13698g == null) {
            f13698g = new c();
        }
        return f13698g;
    }

    private String h(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    private String i(Context context, HashMap<String, String> map) {
        try {
            return (String) Executors.newFixedThreadPool(2).submit(new d(this, context, map)).get(3000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13644o, com.alipay.sdk.app.statistic.c.f13649t, th);
            return "";
        }
    }

    private String k(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "-1";
    }

    private String m(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "00";
    }

    private String n() {
        return "1";
    }

    private String o() {
        return "-1;-1";
    }

    private String p() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public String a() {
        return this.f13701c;
    }

    public String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append("(");
            sb.append(packageName);
            sb.append(com.alipay.sdk.util.j.f13806b);
            sb.append(packageInfo.versionCode);
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public String e(com.alipay.sdk.tid.d dVar) {
        Context contextC = m0.b.a().c();
        com.alipay.sdk.util.b bVarA = com.alipay.sdk.util.b.a(contextC);
        if (TextUtils.isEmpty(this.f13699a)) {
            this.f13699a = "Msp/15.6.8 (" + o.n() + com.alipay.sdk.util.j.f13806b + o.t() + com.alipay.sdk.util.j.f13806b + o.y(contextC) + com.alipay.sdk.util.j.f13806b + o.C(contextC) + com.alipay.sdk.util.j.f13806b + o.A(contextC) + com.alipay.sdk.util.j.f13806b + h(contextC);
        }
        String strC = com.alipay.sdk.util.b.d(contextC).c();
        String strE = o.E(contextC);
        String strN = n();
        String strB = bVarA.b();
        String strE2 = bVarA.e();
        String strL = l();
        String strJ = j();
        if (dVar != null) {
            this.f13701c = dVar.f();
        }
        String strReplace = Build.MANUFACTURER.replace(com.alipay.sdk.util.j.f13806b, " ");
        String strReplace2 = Build.MODEL.replace(com.alipay.sdk.util.j.f13806b, " ");
        boolean zE = m0.b.e();
        String strI = bVarA.i();
        String strK = k(contextC);
        String strM = m(contextC);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13699a);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strC);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strE);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strN);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strB);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strE2);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(this.f13701c);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strReplace);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strReplace2);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(zE);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strI);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(o());
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(this.f13700b);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strL);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strJ);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strK);
        sb.append(com.alipay.sdk.util.j.f13806b);
        sb.append(strM);
        if (dVar != null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("tid", com.alipay.sdk.tid.d.a(contextC).b());
            map.put(j0.b.f34232g, m0.b.a().f());
            String strI2 = i(contextC, map);
            if (!TextUtils.isEmpty(strI2)) {
                sb.append(com.alipay.sdk.util.j.f13806b);
                sb.append(strI2);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public synchronized void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(m0.b.a().c()).edit().putString(j0.b.f34234i, str).commit();
        j0.a.f34207c = str;
    }

    public String j() {
        Context contextC = m0.b.a().c();
        SharedPreferences sharedPreferences = contextC.getSharedPreferences(f13695d, 0);
        String string = sharedPreferences.getString(f13696e, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strP = TextUtils.isEmpty(com.alipay.sdk.tid.d.a(contextC).b()) ? p() : com.alipay.sdk.util.b.a(contextC).e();
        sharedPreferences.edit().putString(f13696e, strP).commit();
        return strP;
    }

    public String l() {
        String strB;
        Context contextC = m0.b.a().c();
        SharedPreferences sharedPreferences = contextC.getSharedPreferences(f13695d, 0);
        String string = sharedPreferences.getString(f13697f, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.tid.d.a(contextC).b())) {
            String strF = m0.b.a().f();
            strB = TextUtils.isEmpty(strF) ? p() : strF.substring(3, 18);
        } else {
            strB = com.alipay.sdk.util.b.a(contextC).b();
        }
        String str = strB;
        sharedPreferences.edit().putString(f13697f, str).commit();
        return str;
    }
}
