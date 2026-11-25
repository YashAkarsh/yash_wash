package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class f1 extends n1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ Location f16136t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f1(p1 p1Var, com.google.android.gms.common.api.k kVar, Location location) {
        super(kVar);
        this.f16136t = location;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).E0(this.f16136t);
        o(Status.f15063f);
    }
}
