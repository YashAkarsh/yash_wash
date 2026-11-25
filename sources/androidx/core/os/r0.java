package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6104a = "TraceCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f6105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f6106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f6107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f6108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f6109f;

    @c.t0(18)
    static class a {
        private a() {
        }

        @c.t
        static void a(String str) {
            Trace.beginSection(str);
        }

        @c.t
        static void b() {
            Trace.endSection();
        }
    }

    @c.t0(29)
    static class b {
        private b() {
        }

        @c.t
        static void a(String str, int i7) {
            Trace.beginAsyncSection(str, i7);
        }

        @c.t
        static void b(String str, int i7) {
            Trace.endAsyncSection(str, i7);
        }

        @c.t
        static boolean c() {
            return Trace.isEnabled();
        }

        @c.t
        static void d(String str, long j7) {
            Trace.setCounter(str, j7);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f6105b = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f6106c = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f6107d = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f6108e = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f6109f = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e8) {
                Log.i(f6104a, "Unable to initialize via reflection.", e8);
            }
        }
    }

    private r0() {
    }

    public static void a(@c.m0 String str, int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.a(str, i7);
            return;
        }
        try {
            f6107d.invoke(null, Long.valueOf(f6105b), str, Integer.valueOf(i7));
        } catch (Exception unused) {
            Log.v(f6104a, "Unable to invoke asyncTraceBegin() via reflection.");
        }
    }

    public static void b(@c.m0 String str) {
        a.a(str);
    }

    public static void c(@c.m0 String str, int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.b(str, i7);
            return;
        }
        try {
            f6108e.invoke(null, Long.valueOf(f6105b), str, Integer.valueOf(i7));
        } catch (Exception unused) {
            Log.v(f6104a, "Unable to invoke endAsyncSection() via reflection.");
        }
    }

    public static void d() {
        a.b();
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT >= 29) {
            return b.c();
        }
        try {
            return ((Boolean) f6106c.invoke(null, Long.valueOf(f6105b))).booleanValue();
        } catch (Exception unused) {
            Log.v(f6104a, "Unable to invoke isTagEnabled() via reflection.");
            return false;
        }
    }

    public static void f(@c.m0 String str, int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.d(str, i7);
            return;
        }
        try {
            f6109f.invoke(null, Long.valueOf(f6105b), str, Integer.valueOf(i7));
        } catch (Exception unused) {
            Log.v(f6104a, "Unable to invoke traceCounter() via reflection.");
        }
    }
}
