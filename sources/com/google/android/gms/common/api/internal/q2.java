package com.google.android.gms.common.api.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class q2 extends c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ u.a f15388b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q2(u.a aVar, n.a aVar2) {
        super(aVar2);
        this.f15388b = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.c0
    protected final void b(com.google.android.gms.common.api.a.b bVar, com.google.android.gms.tasks.n<Boolean> nVar) throws RemoteException {
        this.f15388b.f15419b.accept(bVar, nVar);
    }
}
