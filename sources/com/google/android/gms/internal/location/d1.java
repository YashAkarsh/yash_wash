package com.google.android.gms.internal.location;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class d1 extends n1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.location.k f16133t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d1(p1 p1Var, com.google.android.gms.common.api.k kVar, com.google.android.gms.location.k kVar2) {
        super(kVar);
        this.f16133t = kVar2;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).C0(com.google.android.gms.common.api.internal.o.c(this.f16133t, com.google.android.gms.location.k.class.getSimpleName()), new o1(this));
    }
}
