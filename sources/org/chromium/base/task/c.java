package org.chromium.base.task;

import android.os.AsyncTask;
import android.os.Binder;
import c.h1;
import c.j0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.ClassUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;
import org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c<Result> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f38897f = "AsyncTask";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Executor f38898g = new Executor() { // from class: org.chromium.base.task.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.r(runnable);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Executor f38899h = new m();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final d f38900i = new d(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Callable<Result> f38901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FutureTask<Result> f38902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f38903c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f38904d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f38905e = new AtomicBoolean();

    class a implements Callable<Result> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            c.this.f38905e.set(true);
            Result result = null;
            try {
                result = (Result) c.this.h();
                Binder.flushPendingCommands();
                c.this.w(result);
                return result;
            } catch (Throwable th) {
                try {
                    c.this.f38904d.set(true);
                    throw th;
                } catch (Throwable th2) {
                    c.this.w(result);
                    throw th2;
                }
            }
        }
    }

    class b extends FutureTask<Result> {
        b(Callable<Result> callable) {
            super(callable);
        }

        Class a() {
            return c.this.getClass();
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                c.this.x(get());
            } catch (InterruptedException e8) {
                org.chromium.base.t.B(c.f38897f, e8.toString(), new Object[0]);
            } catch (CancellationException unused) {
                c.this.x(null);
            } catch (ExecutionException e9) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e9.getCause());
            }
        }
    }

    /* JADX INFO: renamed from: org.chromium.base.task.c$c, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0520c {

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public static final int f38908o0 = 0;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public static final int f38909p0 = 1;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public static final int f38910q0 = 2;
    }

    private static class d implements RejectedExecutionHandler {
        private d() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            c.f38898g.execute(runnable);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    public c() {
        a aVar = new a();
        this.f38901a = aVar;
        this.f38902b = new b(aVar);
    }

    private void l() {
        if (this.f38903c != 0) {
            int i7 = this.f38903c;
            if (i7 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i7 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f38903c = 1;
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void q(Result result) {
        if (p()) {
            t(result);
        } else {
            u(result);
        }
        this.f38903c = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(Runnable runnable) {
        PostTask.h(u.f38952l, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final Result result) {
        if (this instanceof org.chromium.base.task.d) {
            this.f38903c = 2;
        } else {
            ThreadUtils.g(new Runnable() { // from class: org.chromium.base.task.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f38895a.q(result);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Result result) {
        if (this.f38905e.get()) {
            return;
        }
        w(result);
    }

    public static void y() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR;
        threadPoolExecutor.setRejectedExecutionHandler(f38900i);
        threadPoolExecutor.shutdown();
    }

    public final boolean g(boolean z7) {
        this.f38904d.set(true);
        return this.f38902b.cancel(z7);
    }

    @h1
    protected abstract Result h();

    @j0
    public final c<Result> i(Executor executor) {
        l();
        executor.execute(this.f38902b);
        return this;
    }

    @j0
    public final c<Result> j(r rVar) {
        l();
        rVar.c(this.f38902b);
        return this;
    }

    @j0
    public final c<Result> k(u uVar) {
        l();
        PostTask.h(uVar, this.f38902b);
        return this;
    }

    @DoNotInline
    public final Result n() throws ExecutionException, InterruptedException {
        String str;
        if (o() == 2 || !ThreadUtils.o()) {
            return this.f38902b.get();
        }
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        if (stackTrace.length > 1) {
            str = stackTrace[1].getClassName() + ClassUtils.PACKAGE_SEPARATOR_CHAR + stackTrace[1].getMethodName() + ClassUtils.PACKAGE_SEPARATOR_CHAR;
        } else {
            str = "";
        }
        TraceEvent traceEventG = TraceEvent.G(str + "AsyncTask.get");
        try {
            Result result = this.f38902b.get();
            if (traceEventG == null) {
                return result;
            }
            traceEventG.close();
            return result;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (traceEventG != null) {
                    try {
                        traceEventG.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public final int o() {
        return this.f38903c;
    }

    public final boolean p() {
        return this.f38904d.get();
    }

    @j0
    protected void s() {
    }

    @j0
    protected void t(Result result) {
        s();
    }

    @j0
    protected abstract void u(Result result);

    @j0
    protected void v() {
    }
}
