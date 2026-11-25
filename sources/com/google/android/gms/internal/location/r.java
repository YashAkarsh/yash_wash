package com.google.android.gms.internal.location;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* JADX INFO: loaded from: classes.dex */
final class r extends com.google.android.gms.location.t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.n<com.google.android.gms.location.k> f16160a;

    r(com.google.android.gms.common.api.internal.n<com.google.android.gms.location.k> nVar) {
        this.f16160a = nVar;
    }

    @Override // com.google.android.gms.location.v0
    public final void A2(LocationAvailability locationAvailability) {
        this.f16160a.d(new q(this, locationAvailability));
    }

    @Override // com.google.android.gms.location.v0
    public final void o1(LocationResult locationResult) {
        this.f16160a.d(new p(this, locationResult));
    }

    public final synchronized void t() {
        this.f16160a.a();
    }
}
