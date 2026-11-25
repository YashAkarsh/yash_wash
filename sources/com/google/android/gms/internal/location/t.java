package com.google.android.gms.internal.location;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
final class t implements com.google.android.gms.common.api.internal.n.b<com.google.android.gms.location.l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Location f16164a;

    t(u uVar, Location location) {
        this.f16164a = location;
    }

    @Override // com.google.android.gms.common.api.internal.n.b
    public final /* bridge */ /* synthetic */ void a(com.google.android.gms.location.l lVar) {
        lVar.onLocationChanged(this.f16164a);
    }

    @Override // com.google.android.gms.common.api.internal.n.b
    public final void b() {
    }
}
