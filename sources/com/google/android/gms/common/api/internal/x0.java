package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class x0 implements com.google.android.gms.common.api.k.b, com.google.android.gms.common.api.k.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a1 f15451a;

    /* synthetic */ x0(a1 a1Var, w0 w0Var) {
        this.f15451a = a1Var;
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void i0(int i7) {
    }

    @Override // com.google.android.gms.common.api.internal.q
    public final void u0(@c.m0 ConnectionResult connectionResult) {
        this.f15451a.f15145b.lock();
        try {
            if (this.f15451a.q(connectionResult)) {
                this.f15451a.i();
                this.f15451a.n();
            } else {
                this.f15451a.l(connectionResult);
            }
        } finally {
            this.f15451a.f15145b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void y0(@c.o0 Bundle bundle) {
        ((com.google.android.gms.signin.f) com.google.android.gms.common.internal.u.k(this.f15451a.f15154k)).q(new v0(this.f15451a));
    }
}
