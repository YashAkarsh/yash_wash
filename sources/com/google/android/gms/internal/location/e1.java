package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class e1 extends n1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ boolean f16134t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e1(p1 p1Var, com.google.android.gms.common.api.k kVar, boolean z7) {
        super(kVar);
        this.f16134t = z7;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).D0(this.f16134t);
        o(Status.f15063f);
    }
}
