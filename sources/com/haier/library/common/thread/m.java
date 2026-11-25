package com.haier.library.common.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int KEEP_ALIVE = 60;
    private static final int MAXIMUM_POOL_SIZE = 200;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final ConcurrentHashMap<Runnable, ScheduledFuture> SCHEDULED_TASKS;
    private static final ScheduledThreadPoolExecutor SCHEDULED_THREAD_POOL_EXECUTOR;
    private static final com.haier.library.common.thread.f THREAD_POOL_EXECUTOR;
    private static e sHandler;
    private static com.haier.library.common.thread.f sIotThreadPool;
    private final AtomicBoolean mCancelled;
    private final FutureTask<Result> mFuture;
    private f mStatus;
    private final AtomicBoolean mTaskInvoked;
    private final g<Params, Result> mWorker;

    class a extends g<Params, Result> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f26513b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i7) {
            super(null);
            this.f26513b = i7;
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            m.this.mTaskInvoked.set(true);
            Process.setThreadPriority(this.f26513b);
            m mVar = m.this;
            return (Result) mVar.e(mVar.doInBackground(this.f26523a));
        }
    }

    class b extends FutureTask<Result> {
        b(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                m.this.f(get());
            } catch (InterruptedException e8) {
                e3.a.v("get excp %s !", e8);
                Thread.currentThread().interrupt();
            } catch (CancellationException unused) {
                m.this.f(null);
            } catch (ExecutionException e9) {
                throw new RuntimeException("An error occured while executing doInBackground()", e9.getCause());
            }
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26516a;

        static {
            int[] iArr = new int[f.values().length];
            f26516a = iArr;
            try {
                iArr[f.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26516a[f.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static class d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final m f26517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Data[] f26518b;

        d(m mVar, Data... dataArr) {
            this.f26517a = mVar;
            this.f26518b = dataArr;
        }
    }

    private static class e extends Handler {
        public e() {
            super(Looper.getMainLooper());
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
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i7 = message.what;
            if (i7 == 1) {
                dVar.f26517a.b(dVar.f26518b[0]);
            } else {
                if (i7 != 2) {
                    return;
                }
                dVar.f26517a.onProgressUpdate(dVar.f26518b);
            }
        }
    }

    public enum f {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class g<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Params[] f26523a;

        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4)) * 2;
        CORE_POOL_SIZE = iMax;
        SCHEDULED_TASKS = new ConcurrentHashMap<>();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(iMax, new i.b().b("uSDKSchedule-%d").h());
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        SCHEDULED_THREAD_POOL_EXECUTOR = scheduledThreadPoolExecutor;
        com.haier.library.common.thread.f fVar = new com.haier.library.common.thread.f();
        THREAD_POOL_EXECUTOR = fVar;
        sIotThreadPool = fVar;
    }

    public m() {
        this(10);
    }

    private m<Params, Progress, Result> a(Executor executor, long j7, TimeUnit timeUnit, Params... paramsArr) {
        f fVar = this.mStatus;
        if (fVar != f.PENDING) {
            int i7 = c.f26516a[fVar.ordinal()];
            if (i7 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i7 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = f.RUNNING;
        onPreExecute();
        this.mWorker.f26523a = paramsArr;
        if (j7 <= 0 || timeUnit == null) {
            executor.execute(this.mFuture);
        } else {
            SCHEDULED_THREAD_POOL_EXECUTOR.schedule(this.mFuture, j7, timeUnit);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = f.FINISHED;
    }

    private static Handler c() {
        e eVar;
        synchronized (m.class) {
            if (sHandler == null) {
                sHandler = new e();
            }
            eVar = sHandler;
        }
        return eVar;
    }

    private static void d() {
        e3.a.d("pool1:%s-pool2:%s-logTraceAndPool %s", g(sIotThreadPool.toString()), g(SCHEDULED_THREAD_POOL_EXECUTOR.toString()), getLastStack());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result e(Result result) {
        c().obtainMessage(1, new d(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Result result) {
        if (this.mTaskInvoked.get()) {
            return;
        }
        e(result);
    }

    private static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.contains("@")) {
            return str;
        }
        try {
            return str.substring(str.indexOf("@"));
        } catch (StringIndexOutOfBoundsException e8) {
            e8.printStackTrace();
            return str;
        }
    }

    protected static String getLastStack() {
        return e3.a.l("uSDKAsyncTask", 4);
    }

    public static void scheduleWithFixedDelay(Runnable runnable, long j7, long j8, TimeUnit timeUnit) {
        ConcurrentHashMap<Runnable, ScheduledFuture> concurrentHashMap = SCHEDULED_TASKS;
        synchronized (concurrentHashMap) {
            if (concurrentHashMap.containsKey(runnable)) {
                return;
            }
            concurrentHashMap.put(runnable, scheduleWithFixedDelayToFuture(runnable, j7, j8, timeUnit));
        }
    }

    public static ScheduledFuture scheduleWithFixedDelayToFuture(Runnable runnable, long j7, long j8, TimeUnit timeUnit) {
        return SCHEDULED_THREAD_POOL_EXECUTOR.scheduleWithFixedDelay(runnable, j7, j8, timeUnit);
    }

    public static boolean stopScheduled(Runnable runnable) {
        return stopScheduled(runnable, true);
    }

    public final boolean cancel(boolean z7) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z7);
    }

    protected abstract Result doInBackground(Params... paramsArr);

    public final m<Params, Progress, Result> execute(Params... paramsArr) {
        return a(sIotThreadPool, 0L, null, paramsArr);
    }

    public final Result get() throws ExecutionException, InterruptedException {
        return this.mFuture.get();
    }

    public final f getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    protected void onCancelled() {
    }

    protected void onPostExecute(Result result) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }

    protected final void publishProgress(Progress... progressArr) {
        if (isCancelled()) {
            return;
        }
        c().obtainMessage(2, new d(this, progressArr)).sendToTarget();
    }

    public m(int i7) {
        this.mStatus = f.PENDING;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        a aVar = new a(i7);
        this.mWorker = aVar;
        this.mFuture = new b(aVar);
        d();
    }

    public static boolean stopScheduled(Runnable runnable, boolean z7) {
        ConcurrentHashMap<Runnable, ScheduledFuture> concurrentHashMap = SCHEDULED_TASKS;
        ScheduledFuture scheduledFuture = concurrentHashMap.get(runnable);
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return false;
        }
        boolean zCancel = scheduledFuture.cancel(z7);
        if (zCancel) {
            concurrentHashMap.remove(runnable);
        }
        return zCancel;
    }

    public final m<Params, Progress, Result> execute(long j7, Params... paramsArr) {
        return execute(j7, TimeUnit.SECONDS, paramsArr);
    }

    public final Result get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.mFuture.get(j7, timeUnit);
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    public final m<Params, Progress, Result> execute(long j7, TimeUnit timeUnit, Params... paramsArr) {
        return a(sIotThreadPool, j7, timeUnit, paramsArr);
    }

    public static void execute(Runnable runnable) {
        d();
        sIotThreadPool.execute(runnable);
    }

    public static <T> Future<T> execute(Callable<T> callable) {
        d();
        return sIotThreadPool.b(callable);
    }

    public static ScheduledFuture<?> execute(Runnable runnable, long j7) {
        return execute(runnable, j7, TimeUnit.SECONDS);
    }

    public static ScheduledFuture<?> execute(Runnable runnable, long j7, TimeUnit timeUnit) {
        d();
        return SCHEDULED_THREAD_POOL_EXECUTOR.schedule(runnable, j7, timeUnit);
    }
}
