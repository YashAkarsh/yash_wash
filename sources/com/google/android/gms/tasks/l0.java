package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class l0<TResult, TContinuationResult> implements h<TContinuationResult>, g, e, m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<TResult, TContinuationResult> f16805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s0<TContinuationResult> f16806c;

    public l0(@c.m0 Executor executor, @c.m0 l<TResult, TContinuationResult> lVar, @c.m0 s0<TContinuationResult> s0Var) {
        this.f16804a = executor;
        this.f16805b = lVar;
        this.f16806c = s0Var;
    }

    @Override // com.google.android.gms.tasks.e
    public final void a() {
        this.f16806c.A();
    }

    @Override // com.google.android.gms.tasks.m0
    public final void b(@c.m0 m<TResult> mVar) {
        this.f16804a.execute(new k0(this, mVar));
    }

    @Override // com.google.android.gms.tasks.g
    public final void c(@c.m0 Exception exc) {
        this.f16806c.y(exc);
    }

    @Override // com.google.android.gms.tasks.h
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f16806c.z(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.m0
    public final void t() {
        throw new UnsupportedOperationException();
    }
}
