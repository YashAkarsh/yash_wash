package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import c.x0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
abstract class d<Params, Progress, Result> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8416f = "AsyncTask";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8417g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8418h = 128;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f8419i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ThreadFactory f8420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f8421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Executor f8422l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f8423m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f8424n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static f f8425o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static volatile Executor f8426p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h<Params, Result> f8427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FutureTask<Result> f8428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile g f8429c = g.PENDING;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicBoolean f8430d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final AtomicBoolean f8431e = new AtomicBoolean();

    static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f8432a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f8432a.getAndIncrement());
        }
    }

    class b extends h<Params, Result> {
        b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            d.this.f8431e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) d.this.b(this.f8442a);
                Binder.flushPendingCommands();
                d.this.q(result);
                return result;
            } catch (Throwable th) {
                try {
                    d.this.f8430d.set(true);
                    throw th;
                } catch (Throwable th2) {
                    d.this.q(result);
                    throw th2;
                }
            }
        }
    }

    class c extends FutureTask<Result> {
        c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                d.this.r(get());
            } catch (InterruptedException e8) {
                Log.w(d.f8416f, e8);
            } catch (CancellationException unused) {
                d.this.r(null);
            } catch (ExecutionException e9) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e9.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.loader.content.d$d, reason: collision with other inner class name */
    static /* synthetic */ class C0107d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8435a;

        static {
            int[] iArr = new int[g.values().length];
            f8435a = iArr;
            try {
                iArr[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8435a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static class e<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f8436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Data[] f8437b;

        e(d dVar, Data... dataArr) {
            this.f8436a = dVar;
            this.f8437b = dataArr;
        }
    }

    private static class f extends Handler {
        f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i7 = message.what;
            if (i7 == 1) {
                eVar.f8436a.f(eVar.f8437b[0]);
            } else {
                if (i7 != 2) {
                    return;
                }
                eVar.f8436a.p(eVar.f8437b);
            }
        }
    }

    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class h<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Params[] f8442a;

        h() {
        }
    }

    static {
        a aVar = new a();
        f8420j = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f8421k = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f8422l = threadPoolExecutor;
        f8426p = threadPoolExecutor;
    }

    d() {
        b bVar = new b();
        this.f8427a = bVar;
        this.f8428b = new c(bVar);
    }

    public static void d(Runnable runnable) {
        f8426p.execute(runnable);
    }

    private static Handler i() {
        f fVar;
        synchronized (d.class) {
            if (f8425o == null) {
                f8425o = new f();
            }
            fVar = f8425o;
        }
        return fVar;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public static void t(Executor executor) {
        f8426p = executor;
    }

    public final boolean a(boolean z7) {
        this.f8430d.set(true);
        return this.f8428b.cancel(z7);
    }

    protected abstract Result b(Params... paramsArr);

    public final d<Params, Progress, Result> c(Params... paramsArr) {
        return e(f8426p, paramsArr);
    }

    public final d<Params, Progress, Result> e(Executor executor, Params... paramsArr) {
        if (this.f8429c == g.PENDING) {
            this.f8429c = g.RUNNING;
            o();
            this.f8427a.f8442a = paramsArr;
            executor.execute(this.f8428b);
            return this;
        }
        int i7 = C0107d.f8435a[this.f8429c.ordinal()];
        if (i7 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i7 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    void f(Result result) {
        if (k()) {
            m(result);
        } else {
            n(result);
        }
        this.f8429c = g.FINISHED;
    }

    public final Result g() throws ExecutionException, InterruptedException {
        return this.f8428b.get();
    }

    public final Result h(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f8428b.get(j7, timeUnit);
    }

    public final g j() {
        return this.f8429c;
    }

    public final boolean k() {
        return this.f8430d.get();
    }

    protected void l() {
    }

    protected void m(Result result) {
        l();
    }

    protected void n(Result result) {
    }

    protected void o() {
    }

    protected void p(Progress... progressArr) {
    }

    Result q(Result result) {
        i().obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    void r(Result result) {
        if (this.f8431e.get()) {
            return;
        }
        q(result);
    }

    protected final void s(Progress... progressArr) {
        if (k()) {
            return;
        }
        i().obtainMessage(2, new e(this, progressArr)).sendToTarget();
    }
}
