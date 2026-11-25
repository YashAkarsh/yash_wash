package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class y0<V> extends s0<V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final l1<V> f22940i;

    y0(l1<V> l1Var) {
        this.f22940i = (l1) com.google.common.base.e0.E(l1Var);
    }

    @Override // com.google.common.util.concurrent.d, com.google.common.util.concurrent.l1
    public void I(Runnable runnable, Executor executor) {
        this.f22940i.I(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        return this.f22940i.cancel(z7);
    }

    @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return this.f22940i.get();
    }

    @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f22940i.isCancelled();
    }

    @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
    public boolean isDone() {
        return this.f22940i.isDone();
    }

    @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
    public V get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f22940i.get(j7, timeUnit);
    }
}
