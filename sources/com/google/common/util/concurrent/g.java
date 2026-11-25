package com.google.common.util.concurrent;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.a
@s1.c
public abstract class g extends AbstractExecutorService implements q1 {
    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t7) {
        return l2.P(runnable, t7);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return l2.Q(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.q1
    public l1<?> submit(Runnable runnable) {
        return (l1) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.q1
    public <T> l1<T> submit(Runnable runnable, T t7) {
        return (l1) super.submit(runnable, (Object) t7);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.google.common.util.concurrent.q1
    public <T> l1<T> submit(Callable<T> callable) {
        return (l1) super.submit((Callable) callable);
    }
}
