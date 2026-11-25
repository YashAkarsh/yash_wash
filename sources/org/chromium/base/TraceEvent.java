package org.chromium.base;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
@x6.e
public class TraceEvent implements AutoCloseable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f38739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f38740c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f38741a;

    private static class b implements Printer {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f38742b = "Looper.dispatch: ";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f38743c = 18;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f38744d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38745a;

        private b() {
        }

        private static String c(String str) {
            int iIndexOf = str.indexOf(40, f38743c);
            int iIndexOf2 = iIndexOf == -1 ? -1 : str.indexOf(41, iIndexOf);
            return iIndexOf2 != -1 ? str.substring(iIndexOf + 1, iIndexOf2) : "";
        }

        private static String d(String str) {
            int iIndexOf = str.indexOf(125, f38743c);
            int iIndexOf2 = iIndexOf == -1 ? -1 : str.indexOf(58, iIndexOf);
            if (iIndexOf2 == -1) {
                iIndexOf2 = str.length();
            }
            return iIndexOf != -1 ? str.substring(iIndexOf + 2, iIndexOf2) : "";
        }

        private static String e(String str) {
            return f38742b + c(str) + "(" + d(str) + ")";
        }

        void a(String str) {
            boolean zK = EarlyTraceEvent.k();
            if (TraceEvent.f38739b || zK) {
                this.f38745a = e(str);
                if (TraceEvent.f38739b) {
                    TraceEvent.nativeBeginToplevel(this.f38745a);
                } else {
                    EarlyTraceEvent.b(this.f38745a);
                }
            }
        }

        void b(String str) {
            boolean zK = EarlyTraceEvent.k();
            if ((TraceEvent.f38739b || zK) && this.f38745a != null) {
                if (TraceEvent.f38739b) {
                    TraceEvent.nativeEndToplevel(this.f38745a);
                } else {
                    EarlyTraceEvent.h(this.f38745a);
                }
            }
            this.f38745a = null;
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (str.startsWith(">")) {
                a(str);
            } else {
                b(str);
            }
        }
    }

    private static final class c extends b implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f38746k = "TraceEvent.LooperMonitor";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f38747l = "Looper.queueIdle";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final long f38748m = 16;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final long f38749n = 16;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final long f38750o = 48;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f38751e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f38752f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f38753g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f38754h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f38755i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f38756j;

        private c() {
            super();
        }

        private final void f() {
            if (TraceEvent.f38739b && !this.f38756j) {
                this.f38751e = SystemClock.elapsedRealtime();
                Looper.myQueue().addIdleHandler(this);
                this.f38756j = true;
                Log.v(f38746k, "attached idle handler");
                return;
            }
            if (!this.f38756j || TraceEvent.f38739b) {
                return;
            }
            Looper.myQueue().removeIdleHandler(this);
            this.f38756j = false;
            Log.v(f38746k, "detached idle handler");
        }

        private static void g(int i7, String str) {
            TraceEvent.C("TraceEvent.LooperMonitor:IdleStats", str);
            Log.println(i7, f38746k, str);
        }

        @Override // org.chromium.base.TraceEvent.b
        final void a(String str) {
            if (this.f38755i == 0) {
                TraceEvent.r(f38747l);
            }
            this.f38752f = SystemClock.elapsedRealtime();
            f();
            super.a(str);
        }

        @Override // org.chromium.base.TraceEvent.b
        final void b(String str) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f38752f;
            if (jElapsedRealtime > 16) {
                g(5, "observed a task that took " + jElapsedRealtime + "ms: " + str);
            }
            super.b(str);
            f();
            this.f38753g++;
            this.f38755i++;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f38751e == 0) {
                this.f38751e = jElapsedRealtime;
            }
            long j7 = jElapsedRealtime - this.f38751e;
            this.f38754h++;
            TraceEvent.g(f38747l, this.f38755i + " tasks since last idle.");
            if (j7 > f38750o) {
                g(3, this.f38753g + " tasks and " + this.f38754h + " idles processed so far, " + this.f38755i + " tasks bursted and " + j7 + "ms elapsed since last idle");
            }
            this.f38751e = jElapsedRealtime;
            this.f38755i = 0;
            return true;
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f38757a;

        static {
            f38757a = CommandLine.m().q(k.f38809d) ? new c() : new b();
        }

        private d() {
        }
    }

    private TraceEvent(String str, String str2) {
        this.f38741a = str;
        g(str, str2);
    }

    public static void C(String str, String str2) {
        if (f38739b) {
            nativeInstant(str, str2);
        }
    }

    public static void E() {
        EarlyTraceEvent.m();
        if (EarlyTraceEvent.k()) {
            ThreadUtils.e().setMessageLogging(d.f38757a);
        }
    }

    public static void F() {
        nativeRegisterEnabledObserver();
    }

    public static TraceEvent G(String str) {
        return H(str, null);
    }

    public static TraceEvent H(String str, String str2) {
        if (EarlyTraceEvent.g() || q()) {
            return new TraceEvent(str, str2);
        }
        return null;
    }

    public static void K(boolean z7) {
        if (f38740c == z7) {
            return;
        }
        f38740c = z7;
        if (z7) {
            nativeStartATrace();
        } else {
            nativeStopATrace();
        }
    }

    public static void Q(String str, long j7) {
        EarlyTraceEvent.p(str, j7);
        if (f38739b) {
            nativeStartAsync(str, j7);
        }
    }

    public static void f(String str) {
        g(str, null);
    }

    public static void g(String str, String str2) {
        EarlyTraceEvent.b(str);
        if (f38739b) {
            nativeBegin(str, str2);
        }
    }

    private static native void nativeBegin(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeBeginToplevel(String str);

    private static native void nativeEnd(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeEndToplevel(String str);

    private static native void nativeFinishAsync(String str, long j7);

    private static native void nativeInstant(String str, String str2);

    private static native void nativeRegisterEnabledObserver();

    private static native void nativeStartATrace();

    private static native void nativeStartAsync(String str, long j7);

    private static native void nativeStopATrace();

    public static boolean q() {
        return f38739b;
    }

    public static void r(String str) {
        s(str, null);
    }

    public static void s(String str, String str2) {
        EarlyTraceEvent.h(str);
        if (f38739b) {
            nativeEnd(str, str2);
        }
    }

    @CalledByNative
    public static void setEnabled(boolean z7) {
        if (z7) {
            EarlyTraceEvent.c();
        }
        if (f38739b != z7) {
            f38739b = z7;
            if (f38740c) {
                return;
            }
            ThreadUtils.e().setMessageLogging(z7 ? d.f38757a : null);
        }
    }

    public static void u(String str, long j7) {
        EarlyTraceEvent.i(str, j7);
        if (f38739b) {
            nativeFinishAsync(str, j7);
        }
    }

    public static void v(String str) {
        if (f38739b) {
            nativeInstant(str, null);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        r(this.f38741a);
    }
}
