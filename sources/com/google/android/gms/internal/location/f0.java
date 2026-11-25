package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

/* JADX INFO: loaded from: classes.dex */
final class f0 extends com.google.android.gms.location.d1<LocationSettingsResult> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ LocationSettingsRequest f16135t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f0(g0 g0Var, com.google.android.gms.common.api.k kVar, LocationSettingsRequest locationSettingsRequest, String str) {
        super(kVar);
        this.f16135t = locationSettingsRequest;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.api.t k(Status status) {
        return new LocationSettingsResult(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).G0(this.f16135t, this, null);
    }
}
