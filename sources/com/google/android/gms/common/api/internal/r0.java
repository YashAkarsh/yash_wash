package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class r0 extends l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.common.internal.e.c f15395b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    r0(s0 s0Var, k1 k1Var, com.google.android.gms.common.internal.e.c cVar) {
        super(k1Var);
        this.f15395b = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.l1
    @GuardedBy("mLock")
    public final void a() {
        this.f15395b.a(new ConnectionResult(16, null));
    }
}
