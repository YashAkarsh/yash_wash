package com.haier.library.common.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f26486e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f26487f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f26488g = 60;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f26489h = 128;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f26490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f26491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f26492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ThreadFactory f26493d;

    class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f26494a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "LinearTask #" + this.f26494a.getAndIncrement());
        }
    }

    public h(int i7, int i8) {
        this.f26493d = new a();
        this.f26491b = i7;
        this.f26492c = i8;
    }

    private ThreadPoolExecutor d() {
        ThreadPoolExecutor threadPoolExecutor = this.f26490a;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, this.f26491b, TimeUnit.SECONDS, new LinkedBlockingQueue(this.f26492c + 2), this.f26493d);
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        this.f26490a = threadPoolExecutor2;
        return threadPoolExecutor2;
    }

    public void a() {
        ThreadPoolExecutor threadPoolExecutor = this.f26490a;
        if (threadPoolExecutor == null) {
            return;
        }
        e3.a.e("LinearTask shutdown", new Object[0]);
        threadPoolExecutor.shutdown();
        this.f26490a = null;
    }

    public void b(Runnable runnable) throws IllegalStateException {
        ThreadPoolExecutor threadPoolExecutorD = d();
        if (threadPoolExecutorD.getQueue().size() > this.f26492c) {
            throw new IllegalStateException("Queue full");
        }
        threadPoolExecutorD.submit(runnable);
    }

    public void c() {
        ThreadPoolExecutor threadPoolExecutor = this.f26490a;
        if (threadPoolExecutor == null) {
            return;
        }
        e3.a.e("LinearTask shutdownNow", new Object[0]);
        threadPoolExecutor.shutdownNow();
        this.f26490a = null;
    }

    public h() {
        this(60, 128);
    }
}
