package com.google.common.util.concurrent;

import com.google.common.collect.b6;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
@u1.a
public abstract class z0<V> extends b6 implements Future<V> {

    public static abstract class a<V> extends z0<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Future<V> f22944a;

        protected a(Future<V> future) {
            this.f22944a = (Future) com.google.common.base.e0.E(future);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.z0, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public final Future<V> c0() {
            return this.f22944a;
        }
    }

    protected z0() {
    }

    public boolean cancel(boolean z7) {
        return c0().cancel(z7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public abstract Future<? extends V> c0();

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return c0().get();
    }

    public boolean isCancelled() {
        return c0().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return c0().isDone();
    }

    @Override // java.util.concurrent.Future
    public V get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return c0().get(j7, timeUnit);
    }
}
