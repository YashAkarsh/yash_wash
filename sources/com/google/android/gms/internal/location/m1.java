package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class m1 extends n1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ PendingIntent f16150t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m1(p1 p1Var, com.google.android.gms.common.api.k kVar, PendingIntent pendingIntent) {
        super(kVar);
        this.f16150t = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).B0(this.f16150t, new o1(this));
    }
}
