package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

/* JADX INFO: loaded from: classes.dex */
final class y extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.android.gms.common.api.internal.e.b<LocationSettingsResult> f16178a;

    public y(com.google.android.gms.common.api.internal.e.b<LocationSettingsResult> bVar) {
        com.google.android.gms.common.internal.u.b(bVar != null, "listener can't be null.");
        this.f16178a = bVar;
    }

    @Override // com.google.android.gms.internal.location.o
    public final void R1(LocationSettingsResult locationSettingsResult) throws RemoteException {
        this.f16178a.b(locationSettingsResult);
        this.f16178a = null;
    }
}
