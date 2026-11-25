package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes.dex */
final class a3 extends a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ a0.a f15166d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    a3(a0.a aVar, Feature[] featureArr, boolean z7, int i7) {
        super(featureArr, z7, i7);
        this.f15166d = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.a0
    protected final void b(com.google.android.gms.common.api.a.b bVar, com.google.android.gms.tasks.n nVar) throws RemoteException {
        this.f15166d.f15140a.accept(bVar, nVar);
    }
}
