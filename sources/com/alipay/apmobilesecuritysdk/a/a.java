package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.c;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f13502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alipay.apmobilesecuritysdk.b.a f13503b = com.alipay.apmobilesecuritysdk.b.a.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13504c = 4;

    public a(Context context) {
        this.f13502a = context;
    }

    private static String b(Context context) {
        try {
            String strB = i.b();
            if (!o0.a.d(strB)) {
                return strB;
            }
            c cVarB = d.b(context);
            if (cVarB != null) {
                i.a(cVarB);
                String str = cVarB.f13512a;
                if (o0.a.g(str)) {
                    return str;
                }
            }
            b bVarB = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (bVarB == null) {
                return "";
            }
            i.a(bVarB);
            String str2 = bVarB.f13509a;
            return o0.a.g(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00bd  */
    public final int a(Map<String, String> map) {
        boolean z7;
        int i7;
        String str;
        try {
            com.alipay.apmobilesecuritysdk.c.a.a(this.f13502a, o0.a.c(map, "tid", ""), o0.a.c(map, j0.b.f34232g, ""), a(this.f13502a));
            String strC = o0.a.c(map, "appName", "");
            b();
            b(this.f13502a);
            a(this.f13502a, strC);
            i.a();
            boolean z8 = false;
            if (!a() && !com.alipay.apmobilesecuritysdk.common.a.a(this.f13502a)) {
                e.a();
                if (!(!o0.a.e(e.b(this.f13502a, map), i.c()))) {
                    String strC2 = o0.a.c(map, "tid", "");
                    String strC3 = o0.a.c(map, j0.b.f34232g, "");
                    if ((!o0.a.g(strC2) || o0.a.e(strC2, i.d())) && ((!o0.a.g(strC3) || o0.a.e(strC3, i.e())) && i.a(this.f13502a, strC) && !o0.a.d(a(this.f13502a, strC)) && !o0.a.d(b(this.f13502a)))) {
                        z7 = false;
                    }
                }
                z7 = true;
            } else if (o0.a.d(a(this.f13502a, strC)) || o0.a.d(b(this.f13502a))) {
                z7 = true;
            } else {
                z7 = false;
            }
            Context context = this.f13502a;
            com.alipay.security.mobile.module.b.c.a();
            h.b(context, String.valueOf(com.alipay.security.mobile.module.b.c.B()));
            if (z7) {
                new com.alipay.apmobilesecuritysdk.c.b();
                UmidSdkWrapper.startUmidTaskSync(this.f13502a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                s0.c cVarB = b(map);
                int iA = cVarB != null ? cVarB.a() : 2;
                if (iA == 1) {
                    h.a(this.f13502a, cVarB.b());
                    h.d(this.f13502a, cVarB.c());
                    h.e(this.f13502a, cVarB.f40307g);
                    h.a(this.f13502a, cVarB.f40308h);
                    h.f(this.f13502a, cVarB.f40309i);
                    h.g(this.f13502a, cVarB.f40311k);
                    i.c(e.b(this.f13502a, map));
                    i.a(strC, cVarB.f40304d);
                    i.b(cVarB.f40303c);
                    i.d(cVarB.f40310j);
                    String strC4 = o0.a.c(map, "tid", "");
                    if (!o0.a.g(strC4) || o0.a.e(strC4, i.d())) {
                        strC4 = i.d();
                    } else {
                        i.e(strC4);
                    }
                    i.e(strC4);
                    String strC5 = o0.a.c(map, j0.b.f34232g, "");
                    if (!o0.a.g(strC5) || o0.a.e(strC5, i.e())) {
                        strC5 = i.e();
                    } else {
                        i.f(strC5);
                    }
                    i.f(strC5);
                    i.a();
                    d.a(this.f13502a, i.g());
                    d.a();
                    com.alipay.apmobilesecuritysdk.e.a.a(this.f13502a, new b(i.b(), i.c(), i.f()));
                    com.alipay.apmobilesecuritysdk.e.a.a();
                    g.a(this.f13502a, strC, i.a(strC));
                    g.a();
                    h.a(this.f13502a, strC, System.currentTimeMillis());
                } else if (iA != 3) {
                    if (cVarB != null) {
                        str = "Server error, result:" + cVarB.f40297b;
                    } else {
                        str = "Server error, returned null";
                    }
                    com.alipay.apmobilesecuritysdk.c.a.a(str);
                    if (o0.a.d(a(this.f13502a, strC))) {
                        i7 = 4;
                    }
                } else {
                    i7 = 1;
                }
                i7 = 0;
            } else {
                i7 = 0;
            }
            this.f13504c = i7;
            t0.a aVarC = com.alipay.security.mobile.module.http.d.c(this.f13502a, this.f13503b.c());
            Context context2 = this.f13502a;
            ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                z8 = true;
            }
            if (z8 && h.c(context2)) {
                new com.alipay.security.mobile.module.d.b(context2.getFilesDir().getAbsolutePath() + "/log/ap", aVarC).b();
            }
        } catch (Exception e8) {
            com.alipay.apmobilesecuritysdk.c.a.a(e8);
        }
        return this.f13504c;
    }

    public static String a(Context context) {
        String strB = b(context);
        return o0.a.d(strB) ? h.f(context) : strB;
    }

    private s0.c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b bVarB;
        b bVarC;
        String str4 = "";
        try {
            Context context = this.f13502a;
            s0.d dVar = new s0.d();
            String strC = o0.a.c(map, "appName", "");
            String strC2 = o0.a.c(map, "sessionId", "");
            String strC3 = o0.a.c(map, "rpcVersion", "");
            String strA = a(context, strC);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String strD = h.d(context);
            if (o0.a.g(strC2)) {
                dVar.f40314c = strC2;
            } else {
                dVar.f40314c = strA;
            }
            dVar.f40315d = securityToken;
            dVar.f40316e = strD;
            dVar.f40312a = "android";
            c cVarC = d.c(context);
            if (cVarC != null) {
                str2 = cVarC.f13512a;
                str = cVarC.f13514c;
            } else {
                str = "";
                str2 = str;
            }
            if (o0.a.d(str2) && (bVarC = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = bVarC.f13509a;
                str = bVarC.f13511c;
            }
            c cVarB = d.b();
            if (cVarB != null) {
                str4 = cVarB.f13512a;
                str3 = cVarB.f13514c;
            } else {
                str3 = "";
            }
            if (o0.a.d(str4) && (bVarB = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = bVarB.f13509a;
                str3 = bVarB.f13511c;
            }
            dVar.f40319h = str2;
            dVar.f40318g = str4;
            dVar.f40321j = strC3;
            if (o0.a.d(str2)) {
                dVar.f40313b = str4;
                dVar.f40320i = str3;
            } else {
                dVar.f40313b = str2;
                dVar.f40320i = str;
            }
            dVar.f40317f = e.a(context, map);
            return com.alipay.security.mobile.module.http.d.c(this.f13502a, this.f13503b.c()).a(dVar);
        } catch (Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    public static String a(Context context, String str) {
        try {
            b();
            String strA = i.a(str);
            if (!o0.a.d(strA)) {
                return strA;
            }
            String strA2 = g.a(context, str);
            i.a(str, strA2);
            return !o0.a.d(strA2) ? strA2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i7 = 0; i7 < 5; i7++) {
                String str = strArr[i7];
                File file = new File(Environment.getExternalStorageDirectory(), ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(com.haier.library.json.a.f26647d);
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int iRandom = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i7 = 0; i7 < 3; i7++) {
            try {
                String[] strArrSplit = strArr[i7].split(" ");
                if (strArrSplit != null && strArrSplit.length == 2) {
                    Date date = new Date();
                    Date date2 = simpleDateFormat.parse(strArrSplit[0] + " 00:00:00");
                    Date date3 = simpleDateFormat.parse(strArrSplit[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(13, iRandom);
                    Date time = calendar.getTime();
                    if (date.after(date2) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
