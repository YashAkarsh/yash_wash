package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b1 implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c
    private final n1 f15168a;

    public b1(n1 n1Var) {
        this.f15168a = n1Var;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void a(@c.o0 Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void b() {
        this.f15168a.d();
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, boolean z7) {
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void d(int i7) {
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final void e() {
        Iterator<com.google.android.gms.common.api.a.f> it = this.f15168a.f15345h.values().iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        this.f15168a.f15353p.f15303s = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.t, T extends e.a<R, A>> T f(T t7) {
        this.f15168a.f15353p.f15295k.add(t7);
        return t7;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final boolean g() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.k1
    public final <A extends com.google.android.gms.common.api.a.b, T extends e.a<? extends com.google.android.gms.common.api.t, A>> T h(T t7) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
