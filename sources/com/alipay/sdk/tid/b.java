package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static a a(Context context, d dVar) {
        if (dVar == null || dVar.j()) {
            return null;
        }
        return new a(dVar.b(), dVar.f(), dVar.n().longValue());
    }

    private static void b(Context context) {
        if (context == null) {
            return;
        }
        m0.b.a().b(context, com.alipay.sdk.data.c.g());
    }

    private static a c(Context context) throws Exception {
        try {
            com.alipay.sdk.packet.b bVarA = new com.alipay.sdk.packet.impl.c().a(context);
            if (bVarA != null) {
                JSONObject jSONObject = new JSONObject(bVarA.b());
                d dVarA = d.a(context);
                String strOptString = jSONObject.optString("tid");
                String string = jSONObject.getString(d.f13753k);
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(string)) {
                    dVarA.c(strOptString, string);
                }
                return a(context, dVarA);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void d(Context context) {
        d.a(context).l();
    }

    public static String e(Context context) {
        b(context);
        return com.alipay.sdk.util.b.a(context).e();
    }

    public static String f(Context context) {
        b(context);
        return com.alipay.sdk.util.b.a(context).b();
    }

    public static synchronized String g(Context context) {
        a aVarK;
        aVarK = k(context);
        return a.d(aVarK) ? "" : aVarK.a();
    }

    public static String h(Context context) {
        b(context);
        return com.alipay.sdk.data.c.g().j();
    }

    public static String i(Context context) {
        b(context);
        return com.alipay.sdk.data.c.g().l();
    }

    public static a j(Context context) {
        d dVarA = d.a(context);
        if (dVarA.m()) {
            return null;
        }
        return new a(dVarA.b(), dVarA.f(), dVarA.n().longValue());
    }

    public static synchronized a k(Context context) {
        com.alipay.sdk.util.d.f("TidHelper", "TidHelper.loadOrCreateTID");
        if (context == null) {
            com.alipay.sdk.app.statistic.a.c(context, "tid", com.alipay.sdk.app.statistic.c.f13637k0, "");
        }
        b(context);
        a aVarL = l(context);
        if (a.d(aVarL)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return null;
            }
            try {
                aVarL = c(context);
            } catch (Throwable unused) {
            }
        }
        return aVarL;
    }

    public static a l(Context context) {
        b(context);
        a aVarA = a(context, d.a(context));
        if (aVarA == null) {
            com.alipay.sdk.util.d.f("TidHelper.loadTID", "TidHelper:::loadTID > null");
        } else {
            com.alipay.sdk.util.d.f("TidHelper.loadTID", "TidHelper:::loadTID > " + aVarA.toString());
        }
        return aVarA;
    }

    public static boolean m(Context context) throws Exception {
        a aVarC;
        com.alipay.sdk.util.d.f("TidHelper.resetTID", "resetTID");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Exception("不能在主线程中调用此方法");
        }
        b(context);
        d(context);
        try {
            aVarC = c(context);
        } catch (Throwable unused) {
            aVarC = null;
        }
        return !a.d(aVarC);
    }
}
