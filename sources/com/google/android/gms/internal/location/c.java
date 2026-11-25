package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.location.GeofencingRequest;

/* JADX INFO: loaded from: classes.dex */
final class c extends e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ GeofencingRequest f16130t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ PendingIntent f16131u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(f fVar, com.google.android.gms.common.api.k kVar, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        super(kVar);
        this.f16130t = geofencingRequest;
        this.f16131u = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).M0(this.f16130t, this.f16131u, this);
    }
}
