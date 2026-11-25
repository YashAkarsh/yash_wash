package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class b2 extends a2 implements f1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final Executor f35526c;

    public b2(@a7.d Executor executor) {
        this.f35526c = executor;
        kotlinx.coroutines.internal.f.c(e1());
    }

    private final void i1(kotlin.coroutines.g gVar, RejectedExecutionException rejectedExecutionException) {
        s2.f(gVar, z1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> q1(ScheduledExecutorService scheduledExecutorService, Runnable runnable, kotlin.coroutines.g gVar, long j7) {
        try {
            return scheduledExecutorService.schedule(runnable, j7, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e8) {
            i1(gVar, e8);
            return null;
        }
    }

    @Override // kotlinx.coroutines.o0
    public void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        Runnable runnableI;
        try {
            Executor executorE1 = e1();
            b bVarB = c.b();
            if (bVarB == null || (runnableI = bVarB.i(runnable)) == null) {
                runnableI = runnable;
            }
            executorE1.execute(runnableI);
        } catch (RejectedExecutionException e8) {
            b bVarB2 = c.b();
            if (bVarB2 != null) {
                bVarB2.f();
            }
            i1(gVar, e8);
            n1.c().T0(gVar, runnable);
        }
    }

    @Override // kotlinx.coroutines.a2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorE1 = e1();
        ExecutorService executorService = executorE1 instanceof ExecutorService ? (ExecutorService) executorE1 : null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }

    @Override // kotlinx.coroutines.a2
    @a7.d
    public Executor e1() {
        return this.f35526c;
    }

    public boolean equals(@a7.e Object obj) {
        return (obj instanceof b2) && ((b2) obj).e1() == e1();
    }

    public int hashCode() {
        return System.identityHashCode(e1());
    }

    @Override // kotlinx.coroutines.f1
    @a7.d
    public q1 p0(long j7, @a7.d Runnable runnable, @a7.d kotlin.coroutines.g gVar) {
        Executor executorE1 = e1();
        ScheduledExecutorService scheduledExecutorService = executorE1 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorE1 : null;
        ScheduledFuture<?> scheduledFutureQ1 = scheduledExecutorService != null ? q1(scheduledExecutorService, runnable, gVar, j7) : null;
        return scheduledFutureQ1 != null ? new p1(scheduledFutureQ1) : b1.f35517g.p0(j7, runnable, gVar);
    }

    @Override // kotlinx.coroutines.f1
    public void s(long j7, @a7.d q<? super kotlin.l2> qVar) {
        Executor executorE1 = e1();
        ScheduledExecutorService scheduledExecutorService = executorE1 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorE1 : null;
        ScheduledFuture<?> scheduledFutureQ1 = scheduledExecutorService != null ? q1(scheduledExecutorService, new k3(this, qVar), qVar.d(), j7) : null;
        if (scheduledFutureQ1 != null) {
            s2.w(qVar, scheduledFutureQ1);
        } else {
            b1.f35517g.s(j7, qVar);
        }
    }

    @Override // kotlinx.coroutines.f1
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @a7.e
    public Object s0(long j7, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        return f1.a.a(this, j7, dVar);
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    public String toString() {
        return e1().toString();
    }
}
