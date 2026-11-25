package com.haier.globalwasher.mvp_api.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25045a = "Volley";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f25046b = Log.isLoggable("Volley", 2);

    static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final boolean f25047c = v.f25046b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f25048d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<C0327a> f25049a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f25050b = false;

        /* JADX INFO: renamed from: com.haier.globalwasher.mvp_api.volley.v$a$a, reason: collision with other inner class name */
        private static class C0327a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f25051a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f25052b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f25053c;

            public C0327a(String str, long j7, long j8) {
                this.f25051a = str;
                this.f25052b = j7;
                this.f25053c = j8;
            }
        }

        a() {
        }

        private long c() {
            if (this.f25049a.size() == 0) {
                return 0L;
            }
            long j7 = this.f25049a.get(0).f25053c;
            List<C0327a> list = this.f25049a;
            return list.get(list.size() - 1).f25053c - j7;
        }

        public synchronized void a(String str, long j7) {
            if (this.f25050b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f25049a.add(new C0327a(str, j7, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            this.f25050b = true;
            long jC = c();
            if (jC <= 0) {
                return;
            }
            long j7 = this.f25049a.get(0).f25053c;
            v.b("(%-4d ms) %s", Long.valueOf(jC), str);
            for (C0327a c0327a : this.f25049a) {
                long j8 = c0327a.f25053c;
                v.b("(+%-4d) [%2d] %s", Long.valueOf(j8 - j7), Long.valueOf(c0327a.f25052b), c0327a.f25051a);
                j7 = j8;
            }
        }

        protected void finalize() throws Throwable {
            if (this.f25050b) {
                return;
            }
            b("Request on the loose");
            v.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i7 = 2; i7 < stackTrace.length; i7++) {
            if (!stackTrace[i7].getClass().equals(v.class)) {
                String className = stackTrace[i7].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + com.alibaba.android.arouter.utils.b.f12515h + stackTrace[i7].getMethodName();
                return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
            }
        }
        str2 = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f25045a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f25045a, a(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Log.e(f25045a, a(str, objArr), th);
    }

    public static void e(String str) {
        b("Changing log tag to %s", str);
        f25045a = str;
        f25046b = Log.isLoggable(str, 2);
    }

    public static void f(String str, Object... objArr) {
        if (f25046b) {
            Log.v(f25045a, a(str, objArr));
        }
    }

    public static void g(String str, Object... objArr) {
        Log.wtf(f25045a, a(str, objArr));
    }

    public static void h(Throwable th, String str, Object... objArr) {
        Log.wtf(f25045a, a(str, objArr), th);
    }
}
