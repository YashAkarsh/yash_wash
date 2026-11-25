package com.google.android.gms.location;

/* JADX INFO: loaded from: classes.dex */
final class d0 extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.tasks.n f16332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f16333b;

    d0(e eVar, com.google.android.gms.tasks.n nVar) {
        this.f16333b = eVar;
        this.f16332a = nVar;
    }

    @Override // com.google.android.gms.location.k
    public final void a(LocationAvailability locationAvailability) {
    }

    @Override // com.google.android.gms.location.k
    public final void b(LocationResult locationResult) {
        this.f16332a.e(locationResult.Q());
        this.f16333b.F(this);
    }
}
