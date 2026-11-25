package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class v0 extends com.google.android.gms.signin.internal.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<a1> f15433a;

    v0(a1 a1Var) {
        this.f15433a = new WeakReference<>(a1Var);
    }

    @Override // com.google.android.gms.signin.internal.c, com.google.android.gms.signin.internal.e
    @c.g
    public final void O1(zak zakVar) {
        a1 a1Var = this.f15433a.get();
        if (a1Var == null) {
            return;
        }
        a1Var.f15144a.s(new u0(this, a1Var, a1Var, zakVar));
    }
}
