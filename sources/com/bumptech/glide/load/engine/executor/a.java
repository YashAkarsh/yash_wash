package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14383c = "PriorityExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f14384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f14385b;

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14386a = 0;

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.executor.a$b$a, reason: collision with other inner class name */
        class C0168a extends Thread {
            C0168a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            C0168a c0168a = new C0168a(runnable, "fifo-pool-thread-" + this.f14386a);
            this.f14386a = this.f14386a + 1;
            return c0168a;
        }
    }

    static class c<T> extends FutureTask<T> implements Comparable<c<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14389b;

        public c(Runnable runnable, T t7, int i7) {
            super(runnable, t7);
            if (!(runnable instanceof com.bumptech.glide.load.engine.executor.b)) {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
            this.f14388a = ((com.bumptech.glide.load.engine.executor.b) runnable).a();
            this.f14389b = i7;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c<?> cVar) {
            int i7 = this.f14388a - cVar.f14388a;
            return i7 == 0 ? this.f14389b - cVar.f14389b : i7;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f14389b == cVar.f14389b && this.f14388a == cVar.f14388a;
        }

        public int hashCode() {
            return (this.f14388a * 31) + this.f14389b;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f14391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f14392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d[] f14393d;

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.executor.a$d$a, reason: collision with other inner class name */
        static enum C0169a extends d {
            C0169a(String str, int i7) {
                super(str, i7);
            }

            @Override // com.bumptech.glide.load.engine.executor.a.d
            protected void a(Throwable th) {
                if (Log.isLoggable(a.f14383c, 6)) {
                    Log.e(a.f14383c, "Request threw uncaught throwable", th);
                }
            }
        }

        static enum b extends d {
            b(String str, int i7) {
                super(str, i7);
            }

            @Override // com.bumptech.glide.load.engine.executor.a.d
            protected void a(Throwable th) {
                super.a(th);
                throw new RuntimeException(th);
            }
        }

        static {
            d dVar = new d("IGNORE", 0);
            f14390a = dVar;
            C0169a c0169a = new C0169a("LOG", 1);
            f14391b = c0169a;
            b bVar = new b("THROW", 2);
            f14392c = bVar;
            f14393d = new d[]{dVar, c0169a, bVar};
        }

        private d(String str, int i7) {
            super(str, i7);
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f14393d.clone();
        }

        protected void a(Throwable th) {
        }
    }

    public a(int i7) {
        this(i7, d.f14391b);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (!future.isDone() || future.isCancelled()) {
                return;
            }
            try {
                future.get();
            } catch (InterruptedException e8) {
                this.f14385b.a(e8);
            } catch (ExecutionException e9) {
                this.f14385b.a(e9);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t7) {
        return new c(runnable, t7, this.f14384a.getAndIncrement());
    }

    public a(int i7, d dVar) {
        this(i7, i7, 0L, TimeUnit.MILLISECONDS, new b(), dVar);
    }

    public a(int i7, int i8, long j7, TimeUnit timeUnit, ThreadFactory threadFactory, d dVar) {
        super(i7, i8, j7, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.f14384a = new AtomicInteger();
        this.f14385b = dVar;
    }
}
