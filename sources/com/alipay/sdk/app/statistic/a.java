package com.alipay.sdk.app.statistic;

import android.content.Context;
import com.alipay.sdk.util.d;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f13621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13622b = "alipay_cashier_statistic_record";

    public static void a(Context context) {
        if (f13621a != null) {
            return;
        }
        f13621a = new c(context);
    }

    public static void b(Context context, String str) {
        new Thread(new b(context, str)).start();
    }

    public static void c(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            c cVar = new c(context);
            cVar.d(str, str2, str3);
            b(context, cVar.b(""));
        } catch (Throwable th) {
            d.d(th);
        }
    }

    public static void d(String str, String str2, String str3) {
        c cVar = f13621a;
        if (cVar == null) {
            return;
        }
        cVar.d(str, str2, str3);
    }

    public static void e(String str, String str2, Throwable th) {
        c cVar = f13621a;
        if (cVar == null) {
            return;
        }
        cVar.f(str, str2, th);
    }

    public static void f(String str, String str2, Throwable th, String str3) {
        c cVar = f13621a;
        if (cVar == null) {
            return;
        }
        cVar.g(str, str2, th, str3);
    }

    public static void g(String str, Throwable th) {
        if (f13621a == null || th == null) {
            return;
        }
        f13621a.f(str, th.getClass().getSimpleName(), th);
    }

    public static synchronized void h(Context context, String str) {
        c cVar = f13621a;
        if (cVar == null) {
            return;
        }
        b(context, cVar.b(str));
        f13621a = null;
    }
}
