package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class e1 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<d0> f15203a;

    @c.g1(otherwise = 2)
    e1(d0 d0Var) {
        this.f15203a = new WeakReference<>(d0Var);
    }

    @Override // com.google.android.gms.common.api.internal.a
    public final a b(Runnable runnable) {
        d0 d0Var = this.f15203a.get();
        if (d0Var == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        d0Var.o(runnable);
        return this;
    }
}
