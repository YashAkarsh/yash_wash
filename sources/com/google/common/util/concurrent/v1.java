package com.google.common.util.concurrent;

import com.google.common.collect.ib;
import com.google.common.collect.wd;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class v1 {

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockingQueue f22916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l1 f22917b;

        a(BlockingQueue blockingQueue, l1 l1Var) {
            this.f22916a = blockingQueue;
            this.f22917b = l1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22916a.add(this.f22917b);
        }
    }

    static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f22918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.p0 f22919b;

        b(Executor executor, com.google.common.base.p0 p0Var) {
            this.f22918a = executor;
            this.f22919b = p0Var;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f22918a.execute(i0.d(runnable, this.f22919b));
        }
    }

    static class c extends q2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.p0 f22920b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ExecutorService executorService, com.google.common.base.p0 p0Var) {
            super(executorService);
            this.f22920b = p0Var;
        }

        @Override // com.google.common.util.concurrent.q2
        protected Runnable a(Runnable runnable) {
            return i0.d(runnable, this.f22920b);
        }

        @Override // com.google.common.util.concurrent.q2
        protected <T> Callable<T> b(Callable<T> callable) {
            return i0.e(callable, this.f22920b);
        }
    }

    static class d extends r2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.p0 f22921c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ScheduledExecutorService scheduledExecutorService, com.google.common.base.p0 p0Var) {
            super(scheduledExecutorService);
            this.f22921c = p0Var;
        }

        @Override // com.google.common.util.concurrent.q2
        protected Runnable a(Runnable runnable) {
            return i0.d(runnable, this.f22921c);
        }

        @Override // com.google.common.util.concurrent.q2
        protected <T> Callable<T> b(Callable<T> callable) {
            return i0.e(callable, this.f22921c);
        }
    }

    static class e implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f22922a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f22923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.common.util.concurrent.d f22924c;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f22925a;

            a(Runnable runnable) {
                this.f22925a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f22922a = false;
                this.f22925a.run();
            }
        }

        e(Executor executor, com.google.common.util.concurrent.d dVar) {
            this.f22923b = executor;
            this.f22924c = dVar;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f22923b.execute(new a(runnable));
            } catch (RejectedExecutionException e8) {
                if (this.f22922a) {
                    this.f22924c.B(e8);
                }
            }
        }
    }

    @s1.c
    @s1.d
    static class f {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ExecutorService f22927a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f22928b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ TimeUnit f22929c;

            a(ExecutorService executorService, long j7, TimeUnit timeUnit) {
                this.f22927a = executorService;
                this.f22928b = j7;
                this.f22929c = timeUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f22927a.shutdown();
                    this.f22927a.awaitTermination(this.f22928b, this.f22929c);
                } catch (InterruptedException unused) {
                }
            }
        }

        f() {
        }

        final void a(ExecutorService executorService, long j7, TimeUnit timeUnit) {
            com.google.common.base.e0.E(executorService);
            com.google.common.base.e0.E(timeUnit);
            b(v1.n("DelayedShutdownHook-for-" + executorService, new a(executorService, j7, timeUnit)));
        }

        @s1.d
        void b(Thread thread) {
            Runtime.getRuntime().addShutdownHook(thread);
        }

        final ExecutorService c(ThreadPoolExecutor threadPoolExecutor) {
            return d(threadPoolExecutor, 120L, TimeUnit.SECONDS);
        }

        final ExecutorService d(ThreadPoolExecutor threadPoolExecutor, long j7, TimeUnit timeUnit) {
            v1.v(threadPoolExecutor);
            ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
            a(threadPoolExecutor, j7, timeUnit);
            return executorServiceUnconfigurableExecutorService;
        }

        final ScheduledExecutorService e(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return f(scheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
        }

        final ScheduledExecutorService f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j7, TimeUnit timeUnit) {
            v1.v(scheduledThreadPoolExecutor);
            ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
            a(scheduledThreadPoolExecutor, j7, timeUnit);
            return scheduledExecutorServiceUnconfigurableScheduledExecutorService;
        }
    }

    @s1.c
    private static class h extends com.google.common.util.concurrent.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExecutorService f22934a;

        h(ExecutorService executorService) {
            this.f22934a = (ExecutorService) com.google.common.base.e0.E(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j7, TimeUnit timeUnit) throws InterruptedException {
            return this.f22934a.awaitTermination(j7, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f22934a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f22934a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f22934a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f22934a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.f22934a.shutdownNow();
        }
    }

    @s1.c
    private static final class i extends h implements s1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ScheduledExecutorService f22935b;

        private static final class a<V> extends a1.a<V> implements n1<V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ScheduledFuture<?> f22936b;

            public a(l1<V> l1Var, ScheduledFuture<?> scheduledFuture) {
                super(l1Var);
                this.f22936b = scheduledFuture;
            }

            @Override // com.google.common.util.concurrent.z0, java.util.concurrent.Future
            public boolean cancel(boolean z7) {
                boolean zCancel = super.cancel(z7);
                if (zCancel) {
                    this.f22936b.cancel(z7);
                }
                return zCancel;
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
            public int compareTo(Delayed delayed) {
                return this.f22936b.compareTo(delayed);
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.f22936b.getDelay(timeUnit);
            }
        }

        @s1.c
        private static final class b extends com.google.common.util.concurrent.d.j<Void> implements Runnable {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final Runnable f22937i;

            public b(Runnable runnable) {
                this.f22937i = (Runnable) com.google.common.base.e0.E(runnable);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f22937i.run();
                } catch (Throwable th) {
                    B(th);
                    throw com.google.common.base.r0.q(th);
                }
            }
        }

        i(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f22935b = (ScheduledExecutorService) com.google.common.base.e0.E(scheduledExecutorService);
        }

        @Override // com.google.common.util.concurrent.s1, java.util.concurrent.ScheduledExecutorService
        public n1<?> scheduleAtFixedRate(Runnable runnable, long j7, long j8, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.f22935b.scheduleAtFixedRate(bVar, j7, j8, timeUnit));
        }

        @Override // com.google.common.util.concurrent.s1, java.util.concurrent.ScheduledExecutorService
        public n1<?> scheduleWithFixedDelay(Runnable runnable, long j7, long j8, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.f22935b.scheduleWithFixedDelay(bVar, j7, j8, timeUnit));
        }

        @Override // com.google.common.util.concurrent.s1, java.util.concurrent.ScheduledExecutorService
        public n1<?> schedule(Runnable runnable, long j7, TimeUnit timeUnit) {
            l2 l2VarP = l2.P(runnable, null);
            return new a(l2VarP, this.f22935b.schedule(l2VarP, j7, timeUnit));
        }

        @Override // com.google.common.util.concurrent.s1, java.util.concurrent.ScheduledExecutorService
        public <V> n1<V> schedule(Callable<V> callable, long j7, TimeUnit timeUnit) {
            l2 l2VarQ = l2.Q(callable);
            return new a(l2VarQ, this.f22935b.schedule(l2VarQ, j7, timeUnit));
        }
    }

    private v1() {
    }

    @s1.a
    @s1.c
    public static void b(ExecutorService executorService, long j7, TimeUnit timeUnit) {
        new f().a(executorService, j7, timeUnit);
    }

    public static Executor c() {
        return n0.INSTANCE;
    }

    @s1.a
    @s1.c
    public static ExecutorService d(ThreadPoolExecutor threadPoolExecutor) {
        return new f().c(threadPoolExecutor);
    }

    @s1.a
    @s1.c
    public static ExecutorService e(ThreadPoolExecutor threadPoolExecutor, long j7, TimeUnit timeUnit) {
        return new f().d(threadPoolExecutor, j7, timeUnit);
    }

    @s1.a
    @s1.c
    public static ScheduledExecutorService f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new f().e(scheduledThreadPoolExecutor);
    }

    @s1.a
    @s1.c
    public static ScheduledExecutorService g(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j7, TimeUnit timeUnit) {
        return new f().f(scheduledThreadPoolExecutor, j7, timeUnit);
    }

    @s1.c
    static <T> T h(q1 q1Var, Collection<? extends Callable<T>> collection, boolean z7, long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long jNanoTime;
        long jNanoTime2;
        com.google.common.base.e0.E(q1Var);
        com.google.common.base.e0.E(timeUnit);
        int size = collection.size();
        com.google.common.base.e0.d(size > 0);
        ArrayList arrayListU = ib.u(size);
        LinkedBlockingQueue linkedBlockingQueueK = wd.k();
        long nanos = timeUnit.toNanos(j7);
        if (z7) {
            try {
                jNanoTime = System.nanoTime();
            } catch (Throwable th) {
                Iterator it = arrayListU.iterator();
                while (it.hasNext()) {
                    ((Future) it.next()).cancel(true);
                }
                throw th;
            }
        } else {
            jNanoTime = 0;
        }
        Iterator<? extends Callable<T>> it2 = collection.iterator();
        arrayListU.add(u(q1Var, it2.next(), linkedBlockingQueueK));
        int i7 = size - 1;
        int i8 = 1;
        ExecutionException executionException = null;
        while (true) {
            Future future = (Future) linkedBlockingQueueK.poll();
            if (future != null) {
                jNanoTime2 = jNanoTime;
            } else {
                if (i7 > 0) {
                    i7--;
                    arrayListU.add(u(q1Var, it2.next(), linkedBlockingQueueK));
                    i8++;
                } else {
                    if (i8 == 0) {
                        if (executionException == null) {
                            throw new ExecutionException((Throwable) null);
                        }
                        throw executionException;
                    }
                    if (z7) {
                        future = (Future) linkedBlockingQueueK.poll(nanos, TimeUnit.NANOSECONDS);
                        if (future == null) {
                            throw new TimeoutException();
                        }
                        jNanoTime2 = System.nanoTime();
                        nanos -= jNanoTime2 - jNanoTime;
                    } else {
                        future = (Future) linkedBlockingQueueK.take();
                    }
                }
                jNanoTime2 = jNanoTime;
            }
            long j8 = nanos;
            int i9 = i7;
            if (future != null) {
                i8--;
                try {
                    T t7 = (T) future.get();
                    Iterator it3 = arrayListU.iterator();
                    while (it3.hasNext()) {
                        ((Future) it3.next()).cancel(true);
                    }
                    return t7;
                } catch (RuntimeException e8) {
                    executionException = new ExecutionException(e8);
                    i7 = i9;
                    nanos = j8;
                    jNanoTime = jNanoTime2;
                } catch (ExecutionException e9) {
                    executionException = e9;
                    i7 = i9;
                    nanos = j8;
                    jNanoTime = jNanoTime2;
                }
            }
            i7 = i9;
            nanos = j8;
            jNanoTime = jNanoTime2;
        }
    }

    @s1.c
    private static boolean i() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    @s1.c
    public static q1 j(ExecutorService executorService) {
        if (executorService instanceof q1) {
            return (q1) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new i((ScheduledExecutorService) executorService) : new h(executorService);
    }

    @s1.c
    public static s1 k(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof s1 ? (s1) scheduledExecutorService : new i(scheduledExecutorService);
    }

    @s1.c
    public static q1 l() {
        return new g(null);
    }

    @s1.a
    @s1.c
    public static Executor m(Executor executor) {
        return new a2(executor);
    }

    @s1.c
    static Thread n(String str, Runnable runnable) {
        com.google.common.base.e0.E(str);
        com.google.common.base.e0.E(runnable);
        Thread threadNewThread = o().newThread(runnable);
        try {
            threadNewThread.setName(str);
        } catch (SecurityException unused) {
        }
        return threadNewThread;
    }

    @s1.a
    @s1.c
    public static ThreadFactory o() {
        if (!i()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException e8) {
            e = e8;
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (IllegalAccessException e9) {
            e = e9;
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (NoSuchMethodException e10) {
            e = e10;
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (InvocationTargetException e11) {
            throw com.google.common.base.r0.q(e11.getCause());
        }
    }

    static Executor p(Executor executor, com.google.common.util.concurrent.d<?> dVar) {
        com.google.common.base.e0.E(executor);
        com.google.common.base.e0.E(dVar);
        return executor == c() ? executor : new e(executor, dVar);
    }

    @s1.c
    static Executor q(Executor executor, com.google.common.base.p0<String> p0Var) {
        com.google.common.base.e0.E(executor);
        com.google.common.base.e0.E(p0Var);
        return i() ? executor : new b(executor, p0Var);
    }

    @s1.c
    static ExecutorService r(ExecutorService executorService, com.google.common.base.p0<String> p0Var) {
        com.google.common.base.e0.E(executorService);
        com.google.common.base.e0.E(p0Var);
        return i() ? executorService : new c(executorService, p0Var);
    }

    @s1.c
    static ScheduledExecutorService s(ScheduledExecutorService scheduledExecutorService, com.google.common.base.p0<String> p0Var) {
        com.google.common.base.e0.E(scheduledExecutorService);
        com.google.common.base.e0.E(p0Var);
        return i() ? scheduledExecutorService : new d(scheduledExecutorService, p0Var);
    }

    @s1.a
    @u1.a
    @s1.c
    public static boolean t(ExecutorService executorService, long j7, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j7) / 2;
        executorService.shutdown();
        try {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (!executorService.awaitTermination(nanos, timeUnit2)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, timeUnit2);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    @s1.c
    private static <T> l1<T> u(q1 q1Var, Callable<T> callable, BlockingQueue<Future<T>> blockingQueue) {
        l1<T> l1VarSubmit = q1Var.submit((Callable) callable);
        l1VarSubmit.I(new a(blockingQueue, l1VarSubmit), c());
        return l1VarSubmit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @s1.c
    public static void v(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new i2().e(true).h(threadPoolExecutor.getThreadFactory()).b());
    }

    @s1.c
    private static final class g extends com.google.common.util.concurrent.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f22931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @v1.a("lock")
        private int f22932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @v1.a("lock")
        private boolean f22933c;

        private g() {
            this.f22931a = new Object();
            this.f22932b = 0;
            this.f22933c = false;
        }

        private void a() {
            synchronized (this.f22931a) {
                int i7 = this.f22932b - 1;
                this.f22932b = i7;
                if (i7 == 0) {
                    this.f22931a.notifyAll();
                }
            }
        }

        private void b() {
            synchronized (this.f22931a) {
                if (this.f22933c) {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
                this.f22932b++;
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j7, TimeUnit timeUnit) throws InterruptedException {
            long nanos = timeUnit.toNanos(j7);
            synchronized (this.f22931a) {
                while (true) {
                    if (this.f22933c && this.f22932b == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long jNanoTime = System.nanoTime();
                    TimeUnit.NANOSECONDS.timedWait(this.f22931a, nanos);
                    nanos -= System.nanoTime() - jNanoTime;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b();
            try {
                runnable.run();
            } finally {
                a();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            boolean z7;
            synchronized (this.f22931a) {
                z7 = this.f22933c;
            }
            return z7;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            boolean z7;
            synchronized (this.f22931a) {
                z7 = this.f22933c && this.f22932b == 0;
            }
            return z7;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            synchronized (this.f22931a) {
                this.f22933c = true;
                if (this.f22932b == 0) {
                    this.f22931a.notifyAll();
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }
}
