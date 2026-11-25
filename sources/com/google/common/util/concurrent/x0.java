package com.google.common.util.concurrent;

import com.google.common.collect.b6;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
@s1.c
public abstract class x0 extends b6 implements ExecutorService {
    protected x0() {
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j7, TimeUnit timeUnit) throws InterruptedException {
        return c0().awaitTermination(j7, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.b6
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public abstract ExecutorService c0();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c0().execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return c0().invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) c0().invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return c0().isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return c0().isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        c0().shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return c0().shutdownNow();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return c0().submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j7, TimeUnit timeUnit) throws InterruptedException {
        return c0().invokeAll(collection, j7, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) c0().invokeAny(collection, j7, timeUnit);
    }

    public Future<?> submit(Runnable runnable) {
        return c0().submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t7) {
        return c0().submit(runnable, t7);
    }
}
