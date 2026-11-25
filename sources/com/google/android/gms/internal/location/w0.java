package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class w0 extends x0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ PendingIntent f16176t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    w0(y0 y0Var, com.google.android.gms.common.api.k kVar, PendingIntent pendingIntent) {
        super(kVar);
        this.f16176t = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).K0(this.f16176t);
        o(Status.f15063f);
    }
}
