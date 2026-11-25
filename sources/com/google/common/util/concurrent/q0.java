package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<l1<Object>> f22883a = new AtomicReference<>(e1.n(null));

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callable f22884a;

        a(Callable callable) {
            this.f22884a = callable;
        }

        @Override // com.google.common.util.concurrent.m
        public l1<T> call() throws Exception {
            return e1.n(this.f22884a.call());
        }

        public String toString() {
            return this.f22884a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f22886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f22887b;

        b(AtomicReference atomicReference, m mVar) {
            this.f22886a = atomicReference;
            this.f22887b = mVar;
        }

        @Override // com.google.common.util.concurrent.m
        public l1<T> call() throws Exception {
            return !com.facebook.internal.a.a(this.f22886a, e.NOT_RUN, e.STARTED) ? e1.j() : this.f22887b.call();
        }

        public String toString() {
            return this.f22887b.toString();
        }
    }

    class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l1 f22889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f22890b;

        c(l1 l1Var, Executor executor) {
            this.f22889a = l1Var;
            this.f22890b = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f22889a.I(runnable, this.f22890b);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l1 f22892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l1 f22893b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicReference f22894c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d2 f22895d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ l1 f22896e;

        d(l1 l1Var, l1 l1Var2, AtomicReference atomicReference, d2 d2Var, l1 l1Var3) {
            this.f22892a = l1Var;
            this.f22893b = l1Var2;
            this.f22894c = atomicReference;
            this.f22895d = d2Var;
            this.f22896e = l1Var3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f22892a.isDone() || (this.f22893b.isCancelled() && com.facebook.internal.a.a(this.f22894c, e.NOT_RUN, e.CANCELLED))) {
                this.f22895d.C(this.f22896e);
            }
        }
    }

    enum e {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private q0() {
    }

    public static q0 a() {
        return new q0();
    }

    public <T> l1<T> b(Callable<T> callable, Executor executor) {
        com.google.common.base.e0.E(callable);
        return c(new a(callable), executor);
    }

    public <T> l1<T> c(m<T> mVar, Executor executor) {
        com.google.common.base.e0.E(mVar);
        AtomicReference atomicReference = new AtomicReference(e.NOT_RUN);
        b bVar = new b(atomicReference, mVar);
        d2 d2VarF = d2.F();
        l1<Object> andSet = this.f22883a.getAndSet(d2VarF);
        l1 l1VarT = e1.t(bVar, new c(andSet, executor));
        l1<T> l1VarR = e1.r(l1VarT);
        d dVar = new d(l1VarT, l1VarR, atomicReference, d2VarF, andSet);
        l1VarR.I(dVar, v1.c());
        l1VarT.I(dVar, v1.c());
        return l1VarR;
    }
}
