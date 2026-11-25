package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class v0 extends x0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ long f16173t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ PendingIntent f16174u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v0(y0 y0Var, com.google.android.gms.common.api.k kVar, long j7, PendingIntent pendingIntent) {
        super(kVar);
        this.f16173t = j7;
        this.f16174u = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.e.a
    protected final /* bridge */ /* synthetic */ void w(com.google.android.gms.common.api.a.b bVar) throws RemoteException {
        ((z) bVar).H0(this.f16173t, this.f16174u);
        o(Status.f15063f);
    }
}
