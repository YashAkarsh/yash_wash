package org.junit.internal.runners.statements;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.j;
import org.junit.runners.model.l;

/* JADX INFO: loaded from: classes3.dex */
public class c extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f39895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeUnit f39896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f39897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f39898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile ThreadGroup f39899e;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f39900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f39901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TimeUnit f39902c;

        public c d(j jVar) {
            if (jVar != null) {
                return new c(this, jVar);
            }
            throw new NullPointerException("statement cannot be null");
        }

        public b e(boolean z7) {
            this.f39900a = z7;
            return this;
        }

        public b f(long j7, TimeUnit timeUnit) {
            if (j7 < 0) {
                throw new IllegalArgumentException("timeout must be non-negative");
            }
            if (timeUnit == null) {
                throw new NullPointerException("TimeUnit cannot be null");
            }
            this.f39901b = j7;
            this.f39902c = timeUnit;
            return this;
        }

        private b() {
            this.f39900a = false;
            this.f39901b = 0L;
            this.f39902c = TimeUnit.SECONDS;
        }
    }

    /* JADX INFO: renamed from: org.junit.internal.runners.statements.c$c, reason: collision with other inner class name */
    private class CallableC0538c implements Callable<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CountDownLatch f39903a;

        private CallableC0538c() {
            this.f39903a = new CountDownLatch(1);
        }

        public void a() throws InterruptedException {
            this.f39903a.await();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Throwable call() throws Exception {
            try {
                this.f39903a.countDown();
                c.this.f39895a.a();
                return null;
            } catch (Exception e8) {
                throw e8;
            } catch (Throwable th) {
                return th;
            }
        }
    }

    public static b c() {
        return new b();
    }

    private Thread[] d(Thread[] threadArr, int i7) {
        int iMin = Math.min(i7, threadArr.length);
        Thread[] threadArr2 = new Thread[iMin];
        for (int i8 = 0; i8 < iMin; i8++) {
            threadArr2[i8] = threadArr[i8];
        }
        return threadArr2;
    }

    private long e(Thread thread) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        if (!threadMXBean.isThreadCpuTimeSupported()) {
            return 0L;
        }
        try {
            return threadMXBean.getThreadCpuTime(thread.getId());
        } catch (UnsupportedOperationException unused) {
            return 0L;
        }
    }

    private Exception f(Thread thread) {
        StackTraceElement[] stackTrace = thread.getStackTrace();
        Thread threadI = this.f39898d ? i(thread) : null;
        l lVar = new l(this.f39897c, this.f39896b);
        if (stackTrace != null) {
            lVar.setStackTrace(stackTrace);
            thread.interrupt();
        }
        if (threadI == null) {
            return lVar;
        }
        Exception exc = new Exception("Appears to be stuck in thread " + threadI.getName());
        exc.setStackTrace(h(threadI));
        return new org.junit.runners.model.f(Arrays.asList(lVar, exc));
    }

    private Throwable g(FutureTask<Throwable> futureTask, Thread thread) {
        try {
            long j7 = this.f39897c;
            return j7 > 0 ? futureTask.get(j7, this.f39896b) : futureTask.get();
        } catch (InterruptedException e8) {
            return e8;
        } catch (ExecutionException e9) {
            return e9.getCause();
        } catch (TimeoutException unused) {
            return f(thread);
        }
    }

    private StackTraceElement[] h(Thread thread) {
        try {
            return thread.getStackTrace();
        } catch (SecurityException unused) {
            return new StackTraceElement[0];
        }
    }

    private Thread i(Thread thread) {
        Thread[] threadArrJ;
        if (this.f39899e == null || (threadArrJ = j(this.f39899e)) == null) {
            return null;
        }
        long j7 = 0;
        Thread thread2 = null;
        for (Thread thread3 : threadArrJ) {
            if (thread3.getState() == Thread.State.RUNNABLE) {
                long jE = e(thread3);
                if (thread2 == null || jE > j7) {
                    thread2 = thread3;
                    j7 = jE;
                }
            }
        }
        if (thread2 == thread) {
            return null;
        }
        return thread2;
    }

    private Thread[] j(ThreadGroup threadGroup) {
        int iMax = Math.max(threadGroup.activeCount() * 2, 100);
        int i7 = 0;
        do {
            Thread[] threadArr = new Thread[iMax];
            int iEnumerate = threadGroup.enumerate(threadArr);
            if (iEnumerate < iMax) {
                return d(threadArr, iEnumerate);
            }
            iMax += 100;
            i7++;
        } while (i7 < 5);
        return null;
    }

    @Override // org.junit.runners.model.j
    public void a() throws Throwable {
        CallableC0538c callableC0538c = new CallableC0538c();
        FutureTask<Throwable> futureTask = new FutureTask<>(callableC0538c);
        this.f39899e = new ThreadGroup("FailOnTimeoutGroup");
        Thread thread = new Thread(this.f39899e, futureTask, "Time-limited test");
        thread.setDaemon(true);
        thread.start();
        callableC0538c.a();
        Throwable thG = g(futureTask, thread);
        if (thG != null) {
            throw thG;
        }
    }

    @Deprecated
    public c(j jVar, long j7) {
        this(c().f(j7, TimeUnit.MILLISECONDS), jVar);
    }

    private c(b bVar, j jVar) {
        this.f39899e = null;
        this.f39895a = jVar;
        this.f39897c = bVar.f39901b;
        this.f39896b = bVar.f39902c;
        this.f39898d = bVar.f39900a;
    }
}
