package org.chromium.base;

import android.annotation.SuppressLint;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
@x6.e
public class EarlyTraceEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38651a = "/data/local/chrome-trace-config.json";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s0
    static final int f38652b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @s0
    static final int f38653c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @s0
    static final int f38654d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @s0
    static final int f38655e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f38656f = "bg_startup_tracing";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f38657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f38658h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @s0
    static volatile int f38659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @GuardedBy("sLock")
    @s0
    static List<b> f38660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("sLock")
    @s0
    static Map<String, b> f38661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy("sLock")
    @s0
    static List<a> f38662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @GuardedBy("sLock")
    @s0
    static List<String> f38663m;

    @s0
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f38664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f38665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f38666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f38667d = b.a();

        a(String str, long j7, boolean z7) {
            this.f38665b = str;
            this.f38666c = j7;
            this.f38664a = z7;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final /* synthetic */ boolean f38668g = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f38669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f38670b = Process.myTid();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f38671c = a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f38672d = SystemClock.currentThreadTimeMillis();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f38673e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f38674f;

        public b(String str) {
            this.f38669a = str;
        }

        @SuppressLint({"NewApi"})
        @s0
        static long a() {
            return SystemClock.elapsedRealtimeNanos();
        }

        public void b() {
            this.f38673e = a();
            this.f38674f = SystemClock.currentThreadTimeMillis();
        }
    }

    public static void a(b bVar) {
        if (g()) {
            synchronized (f38658h) {
                if (g()) {
                    f38660j.add(bVar);
                }
            }
        }
    }

    public static void b(String str) {
        if (g()) {
            b bVar = new b(str);
            synchronized (f38658h) {
                if (g()) {
                    b bVarPut = f38661k.put(l(str), bVar);
                    if (bVarPut == null) {
                        return;
                    }
                    throw new IllegalArgumentException("Multiple pending trace events can't have the same name: " + str);
                }
            }
        }
    }

    static void c() {
        synchronized (f38658h) {
            if (g()) {
                f38659i = 2;
                n();
            }
        }
    }

    private static void d(List<a> list) {
        long j7 = j();
        for (a aVar : list) {
            if (aVar.f38664a) {
                nativeRecordEarlyStartAsyncEvent(aVar.f38665b, aVar.f38666c, aVar.f38667d + j7);
            } else {
                nativeRecordEarlyFinishAsyncEvent(aVar.f38665b, aVar.f38666c, aVar.f38667d + j7);
            }
        }
    }

    private static void e(List<b> list) {
        long j7 = j();
        for (b bVar : list) {
            nativeRecordEarlyEvent(bVar.f38669a, bVar.f38671c + j7, bVar.f38673e + j7, bVar.f38670b, bVar.f38674f - bVar.f38672d);
        }
    }

    @s0
    static void f() {
        synchronized (f38658h) {
            if (f38659i != 0) {
                return;
            }
            f38660j = new ArrayList();
            f38661k = new HashMap();
            f38662l = new ArrayList();
            f38663m = new ArrayList();
            f38659i = 1;
        }
    }

    static boolean g() {
        return f38659i == 1;
    }

    @CalledByNative
    public static boolean getBackgroundStartupTracingFlag() {
        return f38657g;
    }

    public static void h(String str) {
        if (k()) {
            synchronized (f38658h) {
                if (k()) {
                    b bVarRemove = f38661k.remove(l(str));
                    if (bVarRemove == null) {
                        return;
                    }
                    bVarRemove.b();
                    f38660j.add(bVarRemove);
                    if (f38659i == 2) {
                        n();
                    }
                }
            }
        }
    }

    public static void i(String str, long j7) {
        if (k()) {
            a aVar = new a(str, j7, false);
            synchronized (f38658h) {
                if (k()) {
                    if (f38663m.remove(str)) {
                        f38662l.add(aVar);
                        if (f38659i == 2) {
                            n();
                        }
                    }
                }
            }
        }
    }

    private static long j() {
        return (TimeUtils.nativeGetTimeTicksNowUs() * 1000) - b.a();
    }

    static boolean k() {
        int i7 = f38659i;
        return i7 == 1 || i7 == 2;
    }

    @s0
    static String l(String str) {
        return str + "@" + Process.myTid();
    }

    static void m() {
        boolean zExists;
        ThreadUtils.b();
        if (f38659i != 0) {
            return;
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            boolean z7 = true;
            if (CommandLine.m().q("trace-startup")) {
                zExists = true;
            } else {
                try {
                    zExists = new File(f38651a).exists();
                } catch (SecurityException unused) {
                    zExists = false;
                }
            }
            if (!o.c().getBoolean(f38656f, false)) {
                z7 = zExists;
            } else if (zExists) {
                setBackgroundStartupTracingFlag(false);
                f38657g = false;
                z7 = zExists;
            } else {
                f38657g = true;
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            if (z7) {
                f();
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    @GuardedBy("sLock")
    private static void n() {
        if (!f38660j.isEmpty()) {
            e(f38660j);
            f38660j.clear();
        }
        if (!f38662l.isEmpty()) {
            d(f38662l);
            f38662l.clear();
        }
        if (f38661k.isEmpty() && f38663m.isEmpty()) {
            f38659i = 3;
            f38661k = null;
            f38660j = null;
            f38663m = null;
            f38662l = null;
        }
    }

    private static native void nativeRecordEarlyEvent(String str, long j7, long j8, int i7, long j9);

    private static native void nativeRecordEarlyFinishAsyncEvent(String str, long j7, long j8);

    private static native void nativeRecordEarlyStartAsyncEvent(String str, long j7, long j8);

    @s0
    static void o() {
        synchronized (f38658h) {
            f38659i = 0;
            f38660j = null;
            f38661k = null;
            f38662l = null;
            f38663m = null;
        }
    }

    public static void p(String str, long j7) {
        if (g()) {
            a aVar = new a(str, j7, true);
            synchronized (f38658h) {
                if (g()) {
                    f38662l.add(aVar);
                    f38663m.add(str);
                }
            }
        }
    }

    @CalledByNative
    static void setBackgroundStartupTracingFlag(boolean z7) {
        o.c().edit().putBoolean(f38656f, z7).apply();
    }
}
