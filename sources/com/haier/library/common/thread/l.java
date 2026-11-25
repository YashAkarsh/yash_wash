package com.haier.library.common.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledExecutorService f26512a;

    public <T> Future<T> a(Callable<T> callable) {
        if (this.f26512a == null) {
            this.f26512a = Executors.newSingleThreadScheduledExecutor();
        }
        return this.f26512a.submit(callable);
    }

    public ScheduledFuture<?> b(Runnable runnable, long j7, long j8, TimeUnit timeUnit) {
        if (this.f26512a == null) {
            this.f26512a = Executors.newSingleThreadScheduledExecutor();
        }
        return this.f26512a.scheduleWithFixedDelay(runnable, j7, j8, timeUnit);
    }

    public <T> ScheduledFuture<T> c(Callable<T> callable, long j7, TimeUnit timeUnit) {
        if (this.f26512a == null) {
            this.f26512a = Executors.newSingleThreadScheduledExecutor();
        }
        return this.f26512a.schedule(callable, j7, timeUnit);
    }

    public void d() {
        ScheduledExecutorService scheduledExecutorService = this.f26512a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.f26512a = null;
        }
    }

    public void e(Runnable runnable) {
        if (this.f26512a == null) {
            this.f26512a = Executors.newSingleThreadScheduledExecutor();
        }
        this.f26512a.submit(runnable);
    }

    public ScheduledFuture<?> f(Runnable runnable) {
        if (this.f26512a == null) {
            this.f26512a = Executors.newSingleThreadScheduledExecutor();
        }
        return this.f26512a.schedule(runnable, 10L, TimeUnit.MILLISECONDS);
    }
}
