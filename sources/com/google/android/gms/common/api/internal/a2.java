package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a.d;

/* JADX INFO: loaded from: classes.dex */
public final class a2<O extends com.google.android.gms.common.api.a.d> extends k0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @d6.c
    private final com.google.android.gms.common.api.j<O> f15165f;

    public a2(com.google.android.gms.common.api.j<O> jVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f15165f = jVar;
    }

    @Override // com.google.android.gms.common.api.k
    public final void H(g3 g3Var) {
    }

    @Override // com.google.android.gms.common.api.k
    public final void I(g3 g3Var) {
    }

    @Override // com.google.android.gms.common.api.k
    public final <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.t, T extends e.a<R, A>> T l(@c.m0 T t7) {
        return (T) this.f15165f.h(t7);
    }

    @Override // com.google.android.gms.common.api.k
    public final <A extends com.google.android.gms.common.api.a.b, T extends e.a<? extends com.google.android.gms.common.api.t, A>> T m(@c.m0 T t7) {
        return (T) this.f15165f.n(t7);
    }

    @Override // com.google.android.gms.common.api.k
    public final Context q() {
        return this.f15165f.q();
    }

    @Override // com.google.android.gms.common.api.k
    public final Looper r() {
        return this.f15165f.t();
    }
}
