package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
class l2<V> extends s0.a<V> implements RunnableFuture<V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile j1<?> f22827i;

    private final class a extends j1<l1<V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final m<V> f22828c;

        a(m<V> mVar) {
            this.f22828c = (m) com.google.common.base.e0.E(mVar);
        }

        @Override // com.google.common.util.concurrent.j1
        final boolean c() {
            return l2.this.isDone();
        }

        @Override // com.google.common.util.concurrent.j1
        String e() {
            return this.f22828c.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.j1
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(l1<V> l1Var, Throwable th) {
            if (th == null) {
                l2.this.C(l1Var);
            } else {
                l2.this.B(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.j1
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public l1<V> d() throws Exception {
            return (l1) com.google.common.base.e0.V(this.f22828c.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.f22828c);
        }
    }

    private final class b extends j1<V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Callable<V> f22830c;

        b(Callable<V> callable) {
            this.f22830c = (Callable) com.google.common.base.e0.E(callable);
        }

        @Override // com.google.common.util.concurrent.j1
        void a(V v7, Throwable th) {
            if (th == null) {
                l2.this.A(v7);
            } else {
                l2.this.B(th);
            }
        }

        @Override // com.google.common.util.concurrent.j1
        final boolean c() {
            return l2.this.isDone();
        }

        @Override // com.google.common.util.concurrent.j1
        V d() throws Exception {
            return this.f22830c.call();
        }

        @Override // com.google.common.util.concurrent.j1
        String e() {
            return this.f22830c.toString();
        }
    }

    l2(Callable<V> callable) {
        this.f22827i = new b(callable);
    }

    static <V> l2<V> O(m<V> mVar) {
        return new l2<>(mVar);
    }

    static <V> l2<V> P(Runnable runnable, V v7) {
        return new l2<>(Executors.callable(runnable, v7));
    }

    static <V> l2<V> Q(Callable<V> callable) {
        return new l2<>(callable);
    }

    @Override // com.google.common.util.concurrent.d
    protected void m() {
        j1<?> j1Var;
        super.m();
        if (E() && (j1Var = this.f22827i) != null) {
            j1Var.b();
        }
        this.f22827i = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        j1<?> j1Var = this.f22827i;
        if (j1Var != null) {
            j1Var.run();
        }
        this.f22827i = null;
    }

    @Override // com.google.common.util.concurrent.d
    protected String x() {
        j1<?> j1Var = this.f22827i;
        if (j1Var == null) {
            return super.x();
        }
        return "task=[" + j1Var + "]";
    }

    l2(m<V> mVar) {
        this.f22827i = new a(mVar);
    }
}
