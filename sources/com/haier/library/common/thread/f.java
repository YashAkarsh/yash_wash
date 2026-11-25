package com.haier.library.common.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f26466c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f26467d = 300;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f26468e = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f26469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f26470b;

    private static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadGroup f26471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f26472b = new AtomicInteger(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f26473c;

        a(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f26471a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f26473c = str == null ? "" : str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f26471a, runnable, this.f26473c + this.f26472b.getAndIncrement(), 0L);
            e3.a.e("IotThreadPoolExecutor create new Thread<%s>", thread.getName());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static class b implements RejectedExecutionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ThreadPoolExecutor f26474a;

        b(ThreadPoolExecutor threadPoolExecutor) {
            this.f26474a = threadPoolExecutor;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            e3.a.e("IotThreadPoolExecutor runnable r = %d rejected, executor = %s", Integer.valueOf(runnable.hashCode()), threadPoolExecutor.toString());
            ThreadPoolExecutor threadPoolExecutor2 = this.f26474a;
            if (threadPoolExecutor2 != null) {
                threadPoolExecutor2.execute(runnable);
            }
        }
    }

    f() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 300, 60L, timeUnit, new LinkedBlockingQueue(64), new a("uSDK2Task-"), new b(null));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f26469a = threadPoolExecutor;
        this.f26470b = new ThreadPoolExecutor(4, 4, 60L, timeUnit, new LinkedBlockingQueue(1), new a("uSDK1Task-"), new b(this.f26469a));
    }

    private String a(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return "";
        }
        return "pool size:" + threadPoolExecutor.getPoolSize() + ", active threads:" + threadPoolExecutor.getActiveCount() + ", queued task:" + threadPoolExecutor.getQueue().size() + ", completed tasks:" + threadPoolExecutor.getCompletedTaskCount();
    }

    public <T> Future<T> b(Callable<T> callable) {
        return this.f26470b.getActiveCount() < 4 ? this.f26470b.submit(callable) : this.f26469a.submit(callable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.f26470b.getActiveCount() < 4) {
            this.f26470b.execute(runnable);
        } else {
            this.f26469a.execute(runnable);
        }
    }

    public String toString() {
        return String.format("IotThreadPoolExecutor first-%s;second-%s", a(this.f26470b), a(this.f26469a));
    }
}
