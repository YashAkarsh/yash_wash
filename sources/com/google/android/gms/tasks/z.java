package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class z<TResult, TContinuationResult> implements m0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<TResult, TContinuationResult> f16844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s0<TContinuationResult> f16845c;

    public z(@c.m0 Executor executor, @c.m0 c<TResult, TContinuationResult> cVar, @c.m0 s0<TContinuationResult> s0Var) {
        this.f16843a = executor;
        this.f16844b = cVar;
        this.f16845c = s0Var;
    }

    @Override // com.google.android.gms.tasks.m0
    public final void b(@c.m0 m<TResult> mVar) {
        this.f16843a.execute(new y(this, mVar));
    }

    @Override // com.google.android.gms.tasks.m0
    public final void t() {
        throw new UnsupportedOperationException();
    }
}
