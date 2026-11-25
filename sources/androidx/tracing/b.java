package androidx.tracing;

import android.annotation.SuppressLint;
import android.os.Trace;
import android.util.Log;
import c.m0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f10535a = "Trace";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f10536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f10537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f10538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f10539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f10540f;

    private b() {
    }

    @SuppressLint({"NewApi"})
    public static void a(@m0 String str, int i7) {
        try {
            if (f10538d == null) {
                d.a(str, i7);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        b(str, i7);
    }

    private static void b(@m0 String str, int i7) {
        try {
            if (f10538d == null) {
                f10538d = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f10538d.invoke(null, Long.valueOf(f10536b), str, Integer.valueOf(i7));
        } catch (Exception e8) {
            g("asyncTraceBegin", e8);
        }
    }

    public static void c(@m0 String str) {
        c.a(str);
    }

    @SuppressLint({"NewApi"})
    public static void d(@m0 String str, int i7) {
        try {
            if (f10539e == null) {
                d.b(str, i7);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        e(str, i7);
    }

    private static void e(@m0 String str, int i7) {
        try {
            if (f10539e == null) {
                f10539e = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f10539e.invoke(null, Long.valueOf(f10536b), str, Integer.valueOf(i7));
        } catch (Exception e8) {
            g("asyncTraceEnd", e8);
        }
    }

    public static void f() {
        c.b();
    }

    private static void g(@m0 String str, @m0 Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v(f10535a, "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static boolean h() {
        try {
            if (f10537c == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return i();
    }

    private static boolean i() {
        try {
            if (f10537c == null) {
                f10536b = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f10537c = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f10537c.invoke(null, Long.valueOf(f10536b))).booleanValue();
        } catch (Exception e8) {
            g("isTagEnabled", e8);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void j(@m0 String str, int i7) {
        try {
            if (f10540f == null) {
                d.c(str, i7);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        k(str, i7);
    }

    private static void k(@m0 String str, int i7) {
        try {
            if (f10540f == null) {
                f10540f = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            f10540f.invoke(null, Long.valueOf(f10536b), str, Integer.valueOf(i7));
        } catch (Exception e8) {
            g("traceCounter", e8);
        }
    }
}
