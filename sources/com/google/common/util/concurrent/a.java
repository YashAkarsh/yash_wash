package com.google.common.util.concurrent;

import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class a<V, X extends Throwable, F, T> extends s0.a<V> implements Runnable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    l1<? extends V> f22528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Class<X> f22529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    F f22530k;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.a$a, reason: collision with other inner class name */
    private static final class C0291a<V, X extends Throwable> extends a<V, X, n<? super X, ? extends V>, l1<? extends V>> {
        C0291a(l1<? extends V> l1Var, Class<X> cls, n<? super X, ? extends V> nVar) {
            super(l1Var, cls, nVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.a
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public l1<? extends V> Q(n<? super X, ? extends V> nVar, X x7) throws Exception {
            l1<? extends V> l1VarApply = nVar.apply(x7);
            com.google.common.base.e0.V(l1VarApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", nVar);
            return l1VarApply;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.a
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public void R(l1<? extends V> l1Var) {
            C(l1Var);
        }
    }

    private static final class b<V, X extends Throwable> extends a<V, X, com.google.common.base.s<? super X, ? extends V>, V> {
        b(l1<? extends V> l1Var, Class<X> cls, com.google.common.base.s<? super X, ? extends V> sVar) {
            super(l1Var, cls, sVar);
        }

        @Override // com.google.common.util.concurrent.a
        void R(V v7) {
            A(v7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.a
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public V Q(com.google.common.base.s<? super X, ? extends V> sVar, X x7) throws Exception {
            return sVar.apply(x7);
        }
    }

    a(l1<? extends V> l1Var, Class<X> cls, F f8) {
        this.f22528i = (l1) com.google.common.base.e0.E(l1Var);
        this.f22529j = (Class) com.google.common.base.e0.E(cls);
        this.f22530k = (F) com.google.common.base.e0.E(f8);
    }

    static <V, X extends Throwable> l1<V> O(l1<? extends V> l1Var, Class<X> cls, com.google.common.base.s<? super X, ? extends V> sVar, Executor executor) {
        b bVar = new b(l1Var, cls, sVar);
        l1Var.I(bVar, v1.p(executor, bVar));
        return bVar;
    }

    static <X extends Throwable, V> l1<V> P(l1<? extends V> l1Var, Class<X> cls, n<? super X, ? extends V> nVar, Executor executor) {
        C0291a c0291a = new C0291a(l1Var, cls, nVar);
        l1Var.I(c0291a, v1.p(executor, c0291a));
        return c0291a;
    }

    @u1.g
    abstract T Q(F f8, X x7) throws Exception;

    @u1.g
    abstract void R(T t7);

    @Override // com.google.common.util.concurrent.d
    protected final void m() {
        v(this.f22528i);
        this.f22528i = null;
        this.f22529j = null;
        this.f22530k = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [F, java.lang.Class<X extends java.lang.Throwable>] */
    @Override // java.lang.Runnable
    public final void run() throws ExecutionException {
        Object objH;
        l1<? extends V> l1Var = this.f22528i;
        Class<X> cls = this.f22529j;
        F f8 = this.f22530k;
        if (((f8 == null) | (l1Var == null) | (cls == null)) || isCancelled()) {
            return;
        }
        ?? r7 = (Class<X>) null;
        this.f22528i = null;
        try {
            objH = e1.h(l1Var);
            th = null;
        } catch (ExecutionException e8) {
            th = (Throwable) com.google.common.base.e0.E(e8.getCause());
            objH = null;
        } catch (Throwable th) {
            th = th;
            objH = null;
        }
        if (th == null) {
            A(objH);
            return;
        }
        if (!x1.a(th, cls)) {
            C(l1Var);
            return;
        }
        try {
            Object objQ = Q(f8, th);
            this.f22529j = null;
            this.f22530k = null;
            R(objQ);
        } catch (Throwable th2) {
            try {
                B(th2);
            } finally {
                this.f22529j = null;
                this.f22530k = null;
            }
        }
    }

    @Override // com.google.common.util.concurrent.d
    protected String x() {
        String str;
        l1<? extends V> l1Var = this.f22528i;
        Class<X> cls = this.f22529j;
        F f8 = this.f22530k;
        String strX = super.x();
        if (l1Var != null) {
            str = "inputFuture=[" + l1Var + "], ";
        } else {
            str = "";
        }
        if (cls == null || f8 == null) {
            if (strX == null) {
                return null;
            }
            return str + strX;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + f8 + "]";
    }
}
