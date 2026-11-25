package com.google.android.gms.internal.location;

/* JADX INFO: loaded from: classes.dex */
final class o0<E> extends m0<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q0<E> f16152c;

    o0(q0<E> q0Var, int i7) {
        super(q0Var.size(), i7);
        this.f16152c = q0Var;
    }

    @Override // com.google.android.gms.internal.location.m0
    protected final E a(int i7) {
        return this.f16152c.get(i7);
    }
}
