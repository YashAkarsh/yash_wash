package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: loaded from: classes.dex */
final class h1 extends n1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ LocationRequest f16137t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.location.l f16138u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    h1(p1 p1Var, com.google.android.gms.common.api.k kVar, LocationRequest locationRequest, com.google.android.gms.location.l lVar) {
        super(kVar);
        this.f16137t = locationRequest;
        this.f16138u = lVar;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).x0(this.f16137t, com.google.android.gms.common.api.internal.o.a(this.f16138u, h0.b(), com.google.android.gms.location.l.class.getSimpleName()), new o1(this));
    }
}
