package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class b0<TResult, TContinuationResult> implements h<TContinuationResult>, g, e, m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<TResult, m<TContinuationResult>> f16781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s0<TContinuationResult> f16782c;

    public b0(@c.m0 Executor executor, @c.m0 c<TResult, m<TContinuationResult>> cVar, @c.m0 s0<TContinuationResult> s0Var) {
        this.f16780a = executor;
        this.f16781b = cVar;
        this.f16782c = s0Var;
    }

    @Override // com.google.android.gms.tasks.e
    public final void a() {
        this.f16782c.A();
    }

    @Override // com.google.android.gms.tasks.m0
    public final void b(@c.m0 m<TResult> mVar) {
        this.f16780a.execute(new a0(this, mVar));
    }

    @Override // com.google.android.gms.tasks.g
    public final void c(@c.m0 Exception exc) {
        this.f16782c.y(exc);
    }

    @Override // com.google.android.gms.tasks.h
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f16782c.z(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.m0
    public final void t() {
        throw new UnsupportedOperationException();
    }
}
