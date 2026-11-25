package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.AlipayResultActivity;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13791i = "failed";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13792j = "scheme_failed";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f13793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IAlixPay f13794b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f13797e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f13795c = IAlixPay.class;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ServiceConnection f13798f = new g(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13799g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IRemoteServiceCallback f13800h = new i(this);

    public interface a {
        void a();

        void b();
    }

    public f(Activity activity, a aVar) {
        this.f13793a = activity;
        this.f13797e = aVar;
    }

    private String e(String str, String str2) {
        Activity activity;
        String strF;
        Activity activity2;
        Activity activity3;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(o.g(str2));
        String strF2 = o.f(this.f13793a, str2);
        try {
            if (!this.f13793a.getApplicationContext().bindService(intent, this.f13798f, 1)) {
                throw new Throwable("bindService fail");
            }
            synchronized (this.f13795c) {
                if (this.f13794b == null) {
                    try {
                        this.f13795c.wait(com.alipay.sdk.data.a.m().a());
                    } catch (InterruptedException e8) {
                        com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.N, e8);
                    }
                }
            }
            try {
                if (this.f13794b == null) {
                    com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.H, strF2 + "|" + o.f(this.f13793a, str2));
                    try {
                        this.f13794b.unregisterCallback(this.f13800h);
                    } catch (Throwable th) {
                        d.d(th);
                    }
                    try {
                        this.f13793a.getApplicationContext().unbindService(this.f13798f);
                    } catch (Throwable th2) {
                        d.d(th2);
                    }
                    this.f13797e = null;
                    this.f13800h = null;
                    this.f13798f = null;
                    this.f13794b = null;
                    if (this.f13796d && (activity3 = this.f13793a) != null) {
                        activity3.setRequestedOrientation(0);
                        this.f13796d = false;
                    }
                    return f13791i;
                }
                a aVar = this.f13797e;
                if (aVar != null) {
                    aVar.a();
                }
                if (this.f13793a.getRequestedOrientation() == 0) {
                    this.f13793a.setRequestedOrientation(1);
                    this.f13796d = true;
                }
                this.f13794b.registerCallback(this.f13800h);
                strF = this.f13794b.Pay(str);
                try {
                    this.f13794b.unregisterCallback(this.f13800h);
                } catch (Throwable th3) {
                    d.d(th3);
                }
                try {
                    this.f13793a.getApplicationContext().unbindService(this.f13798f);
                } catch (Throwable th4) {
                    d.d(th4);
                }
                this.f13797e = null;
                this.f13800h = null;
                this.f13798f = null;
                this.f13794b = null;
                if (this.f13796d && (activity2 = this.f13793a) != null) {
                    activity2.setRequestedOrientation(0);
                }
                return strF;
            } catch (Throwable th5) {
                try {
                    com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.K, th5);
                    strF = com.alipay.sdk.app.k.f();
                    try {
                        this.f13794b.unregisterCallback(this.f13800h);
                    } catch (Throwable th6) {
                        d.d(th6);
                    }
                    try {
                        this.f13793a.getApplicationContext().unbindService(this.f13798f);
                    } catch (Throwable th7) {
                        d.d(th7);
                    }
                    this.f13797e = null;
                    this.f13800h = null;
                    this.f13798f = null;
                    this.f13794b = null;
                    if (this.f13796d && activity != null) {
                    }
                } finally {
                    try {
                        this.f13794b.unregisterCallback(this.f13800h);
                    } catch (Throwable th8) {
                        d.d(th8);
                    }
                    try {
                        this.f13793a.getApplicationContext().unbindService(this.f13798f);
                    } catch (Throwable th9) {
                        d.d(th9);
                    }
                    this.f13797e = null;
                    this.f13800h = null;
                    this.f13798f = null;
                    this.f13794b = null;
                    if (this.f13796d && (activity = this.f13793a) != null) {
                        activity.setRequestedOrientation(0);
                        this.f13796d = false;
                    }
                }
            }
        } catch (Throwable th10) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.M, th10);
            return f13791i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private String f(String str, String str2, int i7) {
        String strReplace;
        String str3;
        String str4;
        String strSubstring;
        String strSubstring2;
        JSONObject jSONObject;
        String strE = e(str, str2);
        boolean zH = com.alipay.sdk.data.a.m().h();
        if (f13791i.equals(strE) && "com.eg.android.AlipayGphone".equals(str2) && i7 > 125 && !zH) {
            com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, "BSPNotStartByConfig", "");
        }
        if (!f13791i.equals(strE) || !"com.eg.android.AlipayGphone".equals(str2) || i7 <= 125 || !zH) {
            return strE;
        }
        Activity activity = this.f13793a;
        if (activity == null || !i(str2, activity)) {
            return f13792j;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String strE2 = o.e(32);
        com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, "BSPStart", strE2);
        AlipayResultActivity.f13546a.put(strE2, new h(this, countDownLatch));
        try {
            try {
                String[] strArrSplit = str.split(m0.a.f37445e, -1);
                int length = strArrSplit.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        str4 = null;
                        strSubstring = "";
                        strSubstring2 = strSubstring;
                        jSONObject = null;
                        break;
                    }
                    str4 = strArrSplit[i8];
                    if (str4.startsWith(m0.a.f37447g)) {
                        String strSubstring3 = str4.substring(str4.indexOf("{"), str4.lastIndexOf(j.f13808d) + 1);
                        int iIndexOf = str4.indexOf(strSubstring3);
                        strSubstring2 = str4.substring(0, iIndexOf);
                        strSubstring = str4.substring(iIndexOf + strSubstring3.length());
                        jSONObject = new JSONObject(strSubstring3);
                        if (!jSONObject.optString("sc").equals("h5tonative")) {
                            jSONObject.put("sc", "h5tonative_sdkscheme");
                            break;
                        }
                        jSONObject.put("sc", "h5tonative_scheme");
                        break;
                    }
                    i8++;
                }
                if (TextUtils.isEmpty(str4)) {
                    throw new RuntimeException("empty ctx_args");
                }
                if (str.indexOf(str4) != str.lastIndexOf(str4)) {
                    throw new RuntimeException("multi ctx_args");
                }
                strReplace = str.replace(str4, strSubstring2 + jSONObject.toString() + strSubstring);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sourcePid", Binder.getCallingPid());
                jSONObject2.put(j0.b.f34229d, strReplace);
                jSONObject2.put("pkgName", this.f13793a.getPackageName());
                jSONObject2.put("session", strE2);
                String str5 = "alipays://platformapi/startapp?appId=20000125&mqpSchemePay=" + Uri.encode(Base64.encodeToString(jSONObject2.toString().getBytes("UTF-8"), 2));
                Intent intent = new Intent();
                intent.setPackage(str2);
                intent.addFlags(268435456);
                intent.setData(Uri.parse(str5));
                this.f13793a.startActivity(intent);
                com.alipay.sdk.data.a.m().b(this.f13793a.getApplicationContext());
                countDownLatch.await();
                String str6 = this.f13799g;
                try {
                    str3 = m.c(str6).get(m.f13816a);
                    if (str3 == null) {
                        str3 = "null";
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, "BSPStatEx", th);
                    str3 = "unknown";
                }
                com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, "BSPDone-" + str3, "");
                if (!TextUtils.isEmpty(str6)) {
                    return str6;
                }
                com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, "BSPEmpty", "");
                return f13792j;
            } catch (Throwable th2) {
                com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, "BSPEx", th2);
                return f13792j;
            }
        } catch (Exception e8) {
            try {
                com.alipay.sdk.app.statistic.a.f(com.alipay.sdk.app.statistic.c.f13638l, "BSPSCReplaceEx", e8, Base64.encodeToString(str.getBytes(), 2));
                strReplace = str;
            } catch (InterruptedException e9) {
                com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, "BSPWaiting", e9);
                com.alipay.sdk.app.l lVar = com.alipay.sdk.app.l.PAY_WAITTING;
                return com.alipay.sdk.app.k.b(lVar.a(), lVar.e(), "");
            }
        }
    }

    private void h(o.a aVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (aVar == null || (packageInfo = aVar.f13826a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f13793a.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.T, th);
        }
        Thread.sleep(200L);
    }

    private static boolean i(String str, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.app.statistic.a.d(com.alipay.sdk.app.statistic.c.f13638l, "BSPDetectFail", "");
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, "BSPDetectFail", th);
            return false;
        }
    }

    public String d(String str) {
        String strD = "";
        int i7 = 0;
        try {
            List<com.alipay.sdk.data.a.C0156a> listL = com.alipay.sdk.data.a.m().l();
            if (!com.alipay.sdk.data.a.m().f13688f || listL == null) {
                listL = com.alipay.sdk.app.j.f13608d;
            }
            o.a aVarB = o.b(this.f13793a, listL);
            if (aVarB == null || aVarB.a() || aVarB.b() || o.k(aVarB.f13826a)) {
                return f13791i;
            }
            PackageInfo packageInfo = aVarB.f13826a;
            strD = (packageInfo == null || "com.eg.android.AlipayGphone".equals(packageInfo.packageName)) ? o.d() : aVarB.f13826a.packageName;
            PackageInfo packageInfo2 = aVarB.f13826a;
            i7 = packageInfo2 != null ? packageInfo2.versionCode : 0;
            h(aVarB);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.e(com.alipay.sdk.app.statistic.c.f13638l, com.alipay.sdk.app.statistic.c.P, th);
        }
        return f(str, strD, i7);
    }

    public void g() {
        this.f13793a = null;
    }
}
