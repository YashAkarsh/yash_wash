package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
@s1.c
abstract class r2 extends q2 implements ScheduledExecutorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ScheduledExecutorService f22905b;

    protected r2(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f22905b = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(Runnable runnable, long j7, TimeUnit timeUnit) {
        return this.f22905b.schedule(a(runnable), j7, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j7, long j8, TimeUnit timeUnit) {
        return this.f22905b.scheduleAtFixedRate(a(runnable), j7, j8, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j7, long j8, TimeUnit timeUnit) {
        return this.f22905b.scheduleWithFixedDelay(a(runnable), j7, j8, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(Callable<V> callable, long j7, TimeUnit timeUnit) {
        return this.f22905b.schedule(b(callable), j7, timeUnit);
    }
}
