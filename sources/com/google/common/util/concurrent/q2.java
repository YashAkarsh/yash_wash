package com.google.common.util.concurrent;

import com.google.common.collect.d7;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
@s1.c
abstract class q2 implements ExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f22902a;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callable f22903a;

        a(Callable callable) {
            this.f22903a = callable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f22903a.call();
            } catch (Exception e8) {
                com.google.common.base.r0.w(e8);
                throw new RuntimeException(e8);
            }
        }
    }

    protected q2(ExecutorService executorService) {
        this.f22902a = (ExecutorService) com.google.common.base.e0.E(executorService);
    }

    private <T> d7<Callable<T>> c(Collection<? extends Callable<T>> collection) {
        d7.b bVarM = d7.m();
        Iterator<? extends Callable<T>> it = collection.iterator();
        while (it.hasNext()) {
            bVarM.a(b(it.next()));
        }
        return bVarM.e();
    }

    protected Runnable a(Runnable runnable) {
        return new a(b(Executors.callable(runnable, null)));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j7, TimeUnit timeUnit) throws InterruptedException {
        return this.f22902a.awaitTermination(j7, timeUnit);
    }

    protected abstract <T> Callable<T> b(Callable<T> callable);

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f22902a.execute(a(runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f22902a.invokeAll(c(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f22902a.invokeAny(c(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f22902a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f22902a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f22902a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.f22902a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> callable) {
        return this.f22902a.submit(b((Callable) com.google.common.base.e0.E(callable)));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j7, TimeUnit timeUnit) throws InterruptedException {
        return this.f22902a.invokeAll(c(collection), j7, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f22902a.invokeAny(c(collection), j7, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable runnable) {
        return this.f22902a.submit(a(runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable runnable, T t7) {
        return this.f22902a.submit(a(runnable), t7);
    }
}
