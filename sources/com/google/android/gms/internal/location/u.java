package com.google.android.gms.internal.location;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
final class u extends com.google.android.gms.location.x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.n<com.google.android.gms.location.l> f16165a;

    u(com.google.android.gms.common.api.internal.n<com.google.android.gms.location.l> nVar) {
        this.f16165a = nVar;
    }

    @Override // com.google.android.gms.location.y0
    public final synchronized void M(Location location) {
        this.f16165a.d(new t(this, location));
    }

    public final synchronized void t() {
        this.f16165a.a();
    }
}
