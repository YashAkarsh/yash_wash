package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class y3 implements com.google.android.gms.common.api.k.b, com.google.android.gms.common.api.k.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.common.api.a<?> f15465a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f15466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    private z3 f15467e;

    public y3(com.google.android.gms.common.api.a<?> aVar, boolean z7) {
        this.f15465a = aVar;
        this.f15466d = z7;
    }

    private final z3 b() {
        com.google.android.gms.common.internal.u.l(this.f15467e, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.f15467e;
    }

    public final void a(z3 z3Var) {
        this.f15467e = z3Var;
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i0(int i7) {
        b().i0(i7);
    }

    @Override // com.google.android.gms.common.api.internal.q
    public final void u0(@c.m0 ConnectionResult connectionResult) {
        b().z3(connectionResult, this.f15465a, this.f15466d);
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void y0(@c.o0 Bundle bundle) {
        b().y0(bundle);
    }
}
