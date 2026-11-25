package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: loaded from: classes.dex */
final class i1 extends n1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ LocationRequest f16139t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.location.l f16140u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ Looper f16141v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    i1(p1 p1Var, com.google.android.gms.common.api.k kVar, LocationRequest locationRequest, com.google.android.gms.location.l lVar, Looper looper) {
        super(kVar);
        this.f16139t = locationRequest;
        this.f16140u = lVar;
        this.f16141v = looper;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).x0(this.f16139t, com.google.android.gms.common.api.internal.o.a(this.f16140u, h0.a(this.f16141v), com.google.android.gms.location.l.class.getSimpleName()), new o1(this));
    }
}
