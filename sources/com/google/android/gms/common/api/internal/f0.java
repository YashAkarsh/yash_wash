package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class f0 implements com.google.android.gms.common.api.n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BasePendingResult f15206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h0 f15207b;

    f0(h0 h0Var, BasePendingResult basePendingResult) {
        this.f15207b = h0Var;
        this.f15206a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.n.a
    public final void a(Status status) {
        this.f15207b.f15237a.remove(this.f15206a);
    }
}
