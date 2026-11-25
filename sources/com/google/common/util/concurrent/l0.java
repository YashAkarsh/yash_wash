package com.google.common.util.concurrent;

import com.google.common.collect.x6;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class l0<V> extends k<Object, V> {

    private final class a extends l0<V>.c<l1<V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final m<V> f22818f;

        public a(m<V> mVar, Executor executor) {
            super(executor);
            this.f22818f = (m) com.google.common.base.e0.E(mVar);
        }

        @Override // com.google.common.util.concurrent.j1
        String e() {
            return this.f22818f.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.j1
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public l1<V> d() throws Exception {
            this.f22823d = false;
            return (l1) com.google.common.base.e0.V(this.f22818f.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.f22818f);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.l0.c
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(l1<V> l1Var) {
            l0.this.C(l1Var);
        }
    }

    private final class b extends l0<V>.c<V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Callable<V> f22820f;

        public b(Callable<V> callable, Executor executor) {
            super(executor);
            this.f22820f = (Callable) com.google.common.base.e0.E(callable);
        }

        @Override // com.google.common.util.concurrent.j1
        V d() throws Exception {
            this.f22823d = false;
            return this.f22820f.call();
        }

        @Override // com.google.common.util.concurrent.j1
        String e() {
            return this.f22820f.toString();
        }

        @Override // com.google.common.util.concurrent.l0.c
        void g(V v7) {
            l0.this.A(v7);
        }
    }

    private abstract class c<T> extends j1<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Executor f22822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22823d = true;

        public c(Executor executor) {
            this.f22822c = (Executor) com.google.common.base.e0.E(executor);
        }

        @Override // com.google.common.util.concurrent.j1
        final void a(T t7, Throwable th) {
            if (th == null) {
                g(t7);
                return;
            }
            if (th instanceof ExecutionException) {
                l0.this.B(th.getCause());
            } else if (th instanceof CancellationException) {
                l0.this.cancel(false);
            } else {
                l0.this.B(th);
            }
        }

        @Override // com.google.common.util.concurrent.j1
        final boolean c() {
            return l0.this.isDone();
        }

        final void f() {
            try {
                this.f22822c.execute(this);
            } catch (RejectedExecutionException e8) {
                if (this.f22823d) {
                    l0.this.B(e8);
                }
            }
        }

        abstract void g(T t7);
    }

    private final class d extends k<Object, V>.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private c f22825i;

        d(x6<? extends l1<?>> x6Var, boolean z7, c cVar) {
            super(x6Var, z7, false);
            this.f22825i = cVar;
        }

        @Override // com.google.common.util.concurrent.k.a
        void l(boolean z7, int i7, Object obj) {
        }

        @Override // com.google.common.util.concurrent.k.a
        void n() {
            c cVar = this.f22825i;
            if (cVar != null) {
                cVar.f();
            } else {
                com.google.common.base.e0.g0(l0.this.isDone());
            }
        }

        @Override // com.google.common.util.concurrent.k.a
        void r() {
            c cVar = this.f22825i;
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // com.google.common.util.concurrent.k.a
        void t() {
            super.t();
            this.f22825i = null;
        }
    }

    l0(x6<? extends l1<?>> x6Var, boolean z7, Executor executor, m<V> mVar) {
        L(new d(x6Var, z7, new a(mVar, executor)));
    }

    l0(x6<? extends l1<?>> x6Var, boolean z7, Executor executor, Callable<V> callable) {
        L(new d(x6Var, z7, new b(callable, executor)));
    }
}
