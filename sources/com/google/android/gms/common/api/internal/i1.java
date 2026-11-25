package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class i1 extends b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<j1> f15268a;

    i1(j1 j1Var) {
        this.f15268a = new WeakReference<>(j1Var);
    }

    @Override // com.google.android.gms.common.api.internal.b2
    public final void a() {
        j1 j1Var = this.f15268a.get();
        if (j1Var == null) {
            return;
        }
        j1.P(j1Var);
    }
}
