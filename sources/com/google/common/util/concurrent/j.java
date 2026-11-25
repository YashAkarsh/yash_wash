package com.google.common.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class j<I, O, F, T> extends s0.a<O> implements Runnable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    l1<? extends I> f22786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    F f22787j;

    private static final class a<I, O> extends j<I, O, n<? super I, ? extends O>, l1<? extends O>> {
        a(l1<? extends I> l1Var, n<? super I, ? extends O> nVar) {
            super(l1Var, nVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.j
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public l1<? extends O> Q(n<? super I, ? extends O> nVar, I i7) throws Exception {
            l1<? extends O> l1VarApply = nVar.apply(i7);
            com.google.common.base.e0.V(l1VarApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", nVar);
            return l1VarApply;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.j
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public void R(l1<? extends O> l1Var) {
            C(l1Var);
        }
    }

    private static final class b<I, O> extends j<I, O, com.google.common.base.s<? super I, ? extends O>, O> {
        b(l1<? extends I> l1Var, com.google.common.base.s<? super I, ? extends O> sVar) {
            super(l1Var, sVar);
        }

        @Override // com.google.common.util.concurrent.j
        void R(O o7) {
            A(o7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.j
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public O Q(com.google.common.base.s<? super I, ? extends O> sVar, I i7) {
            return sVar.apply(i7);
        }
    }

    j(l1<? extends I> l1Var, F f8) {
        this.f22786i = (l1) com.google.common.base.e0.E(l1Var);
        this.f22787j = (F) com.google.common.base.e0.E(f8);
    }

    static <I, O> l1<O> O(l1<I> l1Var, com.google.common.base.s<? super I, ? extends O> sVar, Executor executor) {
        com.google.common.base.e0.E(sVar);
        b bVar = new b(l1Var, sVar);
        l1Var.I(bVar, v1.p(executor, bVar));
        return bVar;
    }

    static <I, O> l1<O> P(l1<I> l1Var, n<? super I, ? extends O> nVar, Executor executor) {
        com.google.common.base.e0.E(executor);
        a aVar = new a(l1Var, nVar);
        l1Var.I(aVar, v1.p(executor, aVar));
        return aVar;
    }

    @u1.g
    abstract T Q(F f8, I i7) throws Exception;

    @u1.g
    abstract void R(T t7);

    @Override // com.google.common.util.concurrent.d
    protected final void m() {
        v(this.f22786i);
        this.f22786i = null;
        this.f22787j = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        l1<? extends I> l1Var = this.f22786i;
        F f8 = this.f22787j;
        if ((isCancelled() | (l1Var == null)) || (f8 == null)) {
            return;
        }
        this.f22786i = null;
        if (l1Var.isCancelled()) {
            C(l1Var);
            return;
        }
        try {
            try {
                Object objQ = Q(f8, e1.h(l1Var));
                this.f22787j = null;
                R(objQ);
            } catch (Throwable th) {
                try {
                    B(th);
                } finally {
                    this.f22787j = null;
                }
            }
        } catch (Error e8) {
            B(e8);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e9) {
            B(e9);
        } catch (ExecutionException e10) {
            B(e10.getCause());
        }
    }

    @Override // com.google.common.util.concurrent.d
    protected String x() {
        String str;
        l1<? extends I> l1Var = this.f22786i;
        F f8 = this.f22787j;
        String strX = super.x();
        if (l1Var != null) {
            str = "inputFuture=[" + l1Var + "], ";
        } else {
            str = "";
        }
        if (f8 != null) {
            return str + "function=[" + f8 + "]";
        }
        if (strX == null) {
            return null;
        }
        return str + strX;
    }
}
