package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: loaded from: classes.dex */
final class k1 extends n1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ LocationRequest f16145t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ PendingIntent f16146u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k1(p1 p1Var, com.google.android.gms.common.api.k kVar, LocationRequest locationRequest, PendingIntent pendingIntent) {
        super(kVar);
        this.f16145t = locationRequest;
        this.f16146u = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).z0(this.f16145t, this.f16146u, new o1(this));
    }
}
