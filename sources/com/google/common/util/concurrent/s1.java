package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public interface s1 extends ScheduledExecutorService, q1 {
    @Override // java.util.concurrent.ScheduledExecutorService
    n1<?> schedule(Runnable runnable, long j7, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    <V> n1<V> schedule(Callable<V> callable, long j7, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j7, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j7, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    n1<?> scheduleAtFixedRate(Runnable runnable, long j7, long j8, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j7, long j8, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    n1<?> scheduleWithFixedDelay(Runnable runnable, long j7, long j8, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j7, long j8, TimeUnit timeUnit);
}
