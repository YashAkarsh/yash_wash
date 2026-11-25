package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.location.zzbq;

/* JADX INFO: loaded from: classes.dex */
final class d extends e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ zzbq f16132t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d(f fVar, com.google.android.gms.common.api.k kVar, zzbq zzbqVar) {
        super(kVar);
        this.f16132t = zzbqVar;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).N0(this.f16132t, this);
    }
}
