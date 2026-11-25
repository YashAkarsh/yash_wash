package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class u1 extends e1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ e f15809g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @c.g
    public u1(e eVar, @c.o0 int i7, Bundle bundle) {
        super(eVar, i7, null);
        this.f15809g = eVar;
    }

    @Override // com.google.android.gms.common.internal.e1
    protected final void f(ConnectionResult connectionResult) {
        if (this.f15809g.B() && e.p0(this.f15809g)) {
            e.l0(this.f15809g, 16);
        } else {
            this.f15809g.f15694p.a(connectionResult);
            this.f15809g.U(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.e1
    protected final boolean g() {
        this.f15809g.f15694p.a(ConnectionResult.D);
        return true;
    }
}
