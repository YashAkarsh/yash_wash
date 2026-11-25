package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: loaded from: classes.dex */
final class j1 extends n1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ LocationRequest f16142t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.location.k f16143u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ Looper f16144v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j1(p1 p1Var, com.google.android.gms.common.api.k kVar, LocationRequest locationRequest, com.google.android.gms.location.k kVar2, Looper looper) {
        super(kVar);
        this.f16142t = locationRequest;
        this.f16143u = kVar2;
        this.f16144v = looper;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).w0(zzba.s(null, this.f16142t), com.google.android.gms.common.api.internal.o.a(this.f16143u, h0.a(this.f16144v), com.google.android.gms.location.k.class.getSimpleName()), new o1(this));
    }
}
