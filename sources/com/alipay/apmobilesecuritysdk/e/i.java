package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13523a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f13524b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f13525c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f13526d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f13527e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, String> f13528f = new HashMap();

    public static synchronized String a(String str) {
        String str2 = "apdidTokenCache" + str;
        if (f13528f.containsKey(str2)) {
            String str3 = f13528f.get(str2);
            if (o0.a.g(str3)) {
                return str3;
            }
        }
        return "";
    }

    public static synchronized String b() {
        return f13523a;
    }

    public static synchronized String c() {
        return f13524b;
    }

    public static synchronized String d() {
        return f13526d;
    }

    public static synchronized String e() {
        return f13527e;
    }

    public static synchronized String f() {
        return f13525c;
    }

    public static synchronized c g() {
        return new c(f13523a, f13524b, f13525c, f13526d, f13527e);
    }

    public static void h() {
        f13528f.clear();
        f13523a = "";
        f13524b = "";
        f13526d = "";
        f13527e = "";
        f13525c = "";
    }

    public static synchronized void a() {
    }

    public static void b(String str) {
        f13523a = str;
    }

    public static void c(String str) {
        f13524b = str;
    }

    public static void d(String str) {
        f13525c = str;
    }

    public static void e(String str) {
        f13526d = str;
    }

    public static void f(String str) {
        f13527e = str;
    }

    public static synchronized void a(b bVar) {
        if (bVar != null) {
            f13523a = bVar.f13509a;
            f13524b = bVar.f13510b;
            f13525c = bVar.f13511c;
        }
    }

    public static synchronized void a(c cVar) {
        if (cVar != null) {
            f13523a = cVar.f13512a;
            f13524b = cVar.f13513b;
            f13526d = cVar.f13515d;
            f13527e = cVar.f13516e;
            f13525c = cVar.f13514c;
        }
    }

    public static synchronized void a(String str, String str2) {
        String str3 = "apdidTokenCache" + str;
        if (f13528f.containsKey(str3)) {
            f13528f.remove(str3);
        }
        f13528f.put(str3, str2);
    }

    public static synchronized boolean a(Context context, String str) {
        long j7 = DateUtils.MILLIS_PER_DAY;
        long jA = h.a(context);
        if (jA >= 0) {
            j7 = jA;
        }
        try {
            if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j7) {
                return true;
            }
        } catch (Throwable th) {
            com.alipay.apmobilesecuritysdk.c.a.a(th);
        }
        return false;
    }
}
