package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class q0 extends l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ConnectionResult f15385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ s0 f15386c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q0(s0 s0Var, k1 k1Var, ConnectionResult connectionResult) {
        super(k1Var);
        this.f15386c = s0Var;
        this.f15385b = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.l1
    @GuardedBy("mLock")
    public final void a() {
        this.f15386c.f15400c.l(this.f15385b);
    }
}
