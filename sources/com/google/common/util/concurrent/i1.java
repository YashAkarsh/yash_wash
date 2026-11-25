package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
abstract class i1<V> implements l1<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f22770a = Logger.getLogger(i1.class.getName());

    static final class a<V> extends com.google.common.util.concurrent.d.j<V> {
        a() {
            cancel(false);
        }
    }

    @s1.c
    static class b<V, X extends Exception> extends i1<V> implements j0<V, X> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final X f22771b;

        b(X x7) {
            this.f22771b = x7;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Exception */
        @Override // com.google.common.util.concurrent.j0
        public V J(long j7, TimeUnit timeUnit) throws Exception {
            com.google.common.base.e0.E(timeUnit);
            throw this.f22771b;
        }

        @Override // com.google.common.util.concurrent.i1, java.util.concurrent.Future
        public V get() throws ExecutionException {
            throw new ExecutionException(this.f22771b);
        }

        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.f22771b + "]]";
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Exception */
        @Override // com.google.common.util.concurrent.j0
        public V w() throws Exception {
            throw this.f22771b;
        }
    }

    static final class c<V> extends com.google.common.util.concurrent.d.j<V> {
        c(Throwable th) {
            B(th);
        }
    }

    @s1.c
    static class d<V, X extends Exception> extends i1<V> implements j0<V, X> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f22772b;

        d(V v7) {
            this.f22772b = v7;
        }

        @Override // com.google.common.util.concurrent.j0
        public V J(long j7, TimeUnit timeUnit) {
            com.google.common.base.e0.E(timeUnit);
            return this.f22772b;
        }

        @Override // com.google.common.util.concurrent.i1, java.util.concurrent.Future
        public V get() {
            return this.f22772b;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.f22772b + "]]";
        }

        @Override // com.google.common.util.concurrent.j0
        public V w() {
            return this.f22772b;
        }
    }

    static class e<V> extends i1<V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final e<Object> f22773c = new e<>(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f22774b;

        e(V v7) {
            this.f22774b = v7;
        }

        @Override // com.google.common.util.concurrent.i1, java.util.concurrent.Future
        public V get() {
            return this.f22774b;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.f22774b + "]]";
        }
    }

    i1() {
    }

    @Override // com.google.common.util.concurrent.l1
    public void I(Runnable runnable, Executor executor) {
        com.google.common.base.e0.F(runnable, "Runnable was null.");
        com.google.common.base.e0.F(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e8) {
            f22770a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e8);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j7, TimeUnit timeUnit) throws ExecutionException {
        com.google.common.base.e0.E(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
