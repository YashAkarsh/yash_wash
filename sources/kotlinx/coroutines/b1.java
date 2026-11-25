package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 extends v1 implements Runnable {

    @a7.e
    private static volatile Thread _thread = null;
    private static volatile int debugStatus = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    public static final b1 f35517g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    public static final String f35518h = "kotlinx.coroutines.DefaultExecutor";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f35519i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f35520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f35521k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f35522l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f35523m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f35524n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f35525o = 4;

    static {
        Long l7;
        b1 b1Var = new b1();
        f35517g = b1Var;
        u1.A1(b1Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l7 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l7 = 1000L;
        }
        f35520j = timeUnit.toNanos(l7.longValue());
    }

    private b1() {
    }

    private final synchronized void o2() {
        if (t2()) {
            debugStatus = 3;
            i2();
            notifyAll();
        }
    }

    private final synchronized Thread p2() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, f35518h);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private static /* synthetic */ void r2() {
    }

    private final boolean s2() {
        return debugStatus == 4;
    }

    private final boolean t2() {
        int i7 = debugStatus;
        return i7 == 2 || i7 == 3;
    }

    private final synchronized boolean v2() {
        if (t2()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void w2() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.w1
    @a7.d
    protected Thread Z1() {
        Thread thread = _thread;
        return thread == null ? p2() : thread;
    }

    @Override // kotlinx.coroutines.w1
    protected void a2(long j7, @a7.d v1.c cVar) {
        w2();
    }

    @Override // kotlinx.coroutines.v1
    public void f2(@a7.d Runnable runnable) {
        if (s2()) {
            w2();
        }
        super.f2(runnable);
    }

    @Override // kotlinx.coroutines.v1, kotlinx.coroutines.f1
    @a7.d
    public q1 p0(long j7, @a7.d Runnable runnable, @a7.d kotlin.coroutines.g gVar) {
        return l2(j7, runnable);
    }

    public final synchronized void q2() {
        debugStatus = 0;
        p2();
        while (debugStatus == 0) {
            wait();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zB1;
        kotlin.l2 l2Var;
        v3.f37337a.d(this);
        b bVarB = c.b();
        if (bVarB != null) {
            bVarB.d();
        }
        try {
            if (!v2()) {
                if (zB1) {
                    return;
                } else {
                    return;
                }
            }
            long j7 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jW1 = W1();
                if (jW1 == Long.MAX_VALUE) {
                    b bVarB2 = c.b();
                    Long lValueOf = bVarB2 == null ? null : Long.valueOf(bVarB2.b());
                    long jNanoTime = lValueOf == null ? System.nanoTime() : lValueOf.longValue();
                    if (j7 == Long.MAX_VALUE) {
                        j7 = f35520j + jNanoTime;
                    }
                    long j8 = j7 - jNanoTime;
                    if (j8 <= 0) {
                        if (zB1) {
                            return;
                        } else {
                            return;
                        }
                    }
                    jW1 = kotlin.ranges.q.v(jW1, j8);
                } else {
                    j7 = Long.MAX_VALUE;
                }
                if (jW1 > 0) {
                    if (t2()) {
                        if (zB1) {
                            return;
                        } else {
                            return;
                        }
                    }
                    b bVarB3 = c.b();
                    if (bVarB3 == null) {
                        l2Var = null;
                    } else {
                        bVarB3.c(this, jW1);
                        l2Var = kotlin.l2.f34958a;
                    }
                    if (l2Var == null) {
                        LockSupport.parkNanos(this, jW1);
                    }
                }
            }
        } finally {
            _thread = null;
            o2();
            b bVarB4 = c.b();
            if (bVarB4 != null) {
                bVarB4.h();
            }
            if (!B1()) {
                Z1();
            }
        }
    }

    @Override // kotlinx.coroutines.v1, kotlinx.coroutines.u1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public final boolean u2() {
        return _thread != null;
    }

    public final synchronized void x2(long j7) {
        kotlin.l2 l2Var;
        long jCurrentTimeMillis = System.currentTimeMillis() + j7;
        if (!t2()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            Thread thread = _thread;
            if (thread != null) {
                b bVarB = c.b();
                if (bVarB == null) {
                    l2Var = null;
                } else {
                    bVarB.g(thread);
                    l2Var = kotlin.l2.f34958a;
                }
                if (l2Var == null) {
                    LockSupport.unpark(thread);
                }
            }
            if (jCurrentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            } else {
                wait(j7);
            }
        }
        debugStatus = 0;
    }
}
