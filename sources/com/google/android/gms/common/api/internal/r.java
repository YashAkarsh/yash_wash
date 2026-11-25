package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.t;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class r<R extends com.google.android.gms.common.api.t> extends com.google.android.gms.common.api.m<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BasePendingResult<R> f15394a;

    public r(@c.m0 com.google.android.gms.common.api.n<R> nVar) {
        this.f15394a = (BasePendingResult) nVar;
    }

    @Override // com.google.android.gms.common.api.n
    public final void c(@c.m0 com.google.android.gms.common.api.n.a aVar) {
        this.f15394a.c(aVar);
    }

    @Override // com.google.android.gms.common.api.n
    @c.m0
    public final R d() {
        return (R) this.f15394a.d();
    }

    @Override // com.google.android.gms.common.api.n
    @c.m0
    public final R e(long j7, @c.m0 TimeUnit timeUnit) {
        return (R) this.f15394a.e(j7, timeUnit);
    }

    @Override // com.google.android.gms.common.api.n
    public final void f() {
        this.f15394a.f();
    }

    @Override // com.google.android.gms.common.api.n
    public final boolean g() {
        return this.f15394a.g();
    }

    @Override // com.google.android.gms.common.api.n
    public final void h(@c.m0 com.google.android.gms.common.api.u<? super R> uVar) {
        this.f15394a.h(uVar);
    }

    @Override // com.google.android.gms.common.api.n
    public final void i(@c.m0 com.google.android.gms.common.api.u<? super R> uVar, long j7, @c.m0 TimeUnit timeUnit) {
        this.f15394a.i(uVar, j7, timeUnit);
    }

    @Override // com.google.android.gms.common.api.n
    @c.m0
    public final <S extends com.google.android.gms.common.api.t> com.google.android.gms.common.api.x<S> j(@c.m0 com.google.android.gms.common.api.w<? super R, ? extends S> wVar) {
        return this.f15394a.j(wVar);
    }

    @Override // com.google.android.gms.common.api.m
    @c.m0
    public final R k() {
        if (!this.f15394a.m()) {
            throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
        }
        return (R) this.f15394a.e(0L, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.common.api.m
    public final boolean l() {
        return this.f15394a.m();
    }
}
