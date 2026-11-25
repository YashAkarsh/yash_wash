package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b(emulated = true)
public abstract class s0<V> extends g1<V> {

    static abstract class a<V> extends s0<V> implements d.i<V> {
        a() {
        }

        @Override // com.google.common.util.concurrent.d, com.google.common.util.concurrent.l1
        public final void I(Runnable runnable, Executor executor) {
            super.I(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        @u1.a
        public final boolean cancel(boolean z7) {
            return super.cancel(z7);
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        @u1.a
        public final V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        @u1.a
        public final V get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j7, timeUnit);
        }
    }

    s0() {
    }

    public static <V> s0<V> K(l1<V> l1Var) {
        return l1Var instanceof s0 ? (s0) l1Var : new y0(l1Var);
    }

    public final void F(d1<? super V> d1Var, Executor executor) {
        e1.a(this, d1Var, executor);
    }

    @w1.a("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> s0<V> G(Class<X> cls, com.google.common.base.s<? super X, ? extends V> sVar, Executor executor) {
        return (s0) e1.d(this, cls, sVar, executor);
    }

    @w1.a("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> s0<V> H(Class<X> cls, n<? super X, ? extends V> nVar, Executor executor) {
        return (s0) e1.e(this, cls, nVar, executor);
    }

    public final <T> s0<T> L(com.google.common.base.s<? super V, T> sVar, Executor executor) {
        return (s0) e1.w(this, sVar, executor);
    }

    public final <T> s0<T> M(n<? super V, T> nVar, Executor executor) {
        return (s0) e1.x(this, nVar, executor);
    }

    @s1.c
    public final s0<V> N(long j7, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (s0) e1.C(this, j7, timeUnit, scheduledExecutorService);
    }
}
