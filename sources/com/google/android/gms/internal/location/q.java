package com.google.android.gms.internal.location;

import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: loaded from: classes.dex */
final class q implements com.google.android.gms.common.api.internal.n.b<com.google.android.gms.location.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LocationAvailability f16158a;

    q(r rVar, LocationAvailability locationAvailability) {
        this.f16158a = locationAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.n.b
    public final /* bridge */ /* synthetic */ void a(com.google.android.gms.location.k kVar) {
        kVar.a(this.f16158a);
    }

    @Override // com.google.android.gms.common.api.internal.n.b
    public final void b() {
    }
}
