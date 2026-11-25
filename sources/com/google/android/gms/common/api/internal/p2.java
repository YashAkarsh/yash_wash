package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes.dex */
final class p2 extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ u.a f15383e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    p2(u.a aVar, n nVar, Feature[] featureArr, boolean z7, int i7) {
        super(nVar, featureArr, z7, i7);
        this.f15383e = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.t
    protected final void d(com.google.android.gms.common.api.a.b bVar, com.google.android.gms.tasks.n<Void> nVar) throws RemoteException {
        this.f15383e.f15418a.accept(bVar, nVar);
    }
}
