package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class z0 implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.maps.internal.w f16740a;

    z0(g1 g1Var, com.google.android.gms.maps.internal.w wVar) {
        this.f16740a = wVar;
    }

    @Override // com.google.android.gms.maps.d.a
    public final void onLocationChanged(Location location) {
        try {
            this.f16740a.M(location);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }
}
