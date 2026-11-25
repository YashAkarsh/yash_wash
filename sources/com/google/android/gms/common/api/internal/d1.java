package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class d1 implements com.google.android.gms.common.api.k.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f15182a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ z f15183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ j1 f15184e;

    d1(j1 j1Var, AtomicReference atomicReference, z zVar) {
        this.f15184e = j1Var;
        this.f15182a = atomicReference;
        this.f15183d = zVar;
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i0(int i7) {
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void y0(@c.o0 Bundle bundle) {
        this.f15184e.T((com.google.android.gms.common.api.k) com.google.android.gms.common.internal.u.k((com.google.android.gms.common.api.k) this.f15182a.get()), this.f15183d, true);
    }
}
