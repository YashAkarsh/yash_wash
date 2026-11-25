package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.e.b<Status> f15800a;

    public e(com.google.android.gms.common.api.internal.e.b<Status> bVar) {
        this.f15800a = bVar;
    }

    @Override // com.google.android.gms.common.internal.service.b, com.google.android.gms.common.internal.service.l
    public final void c3(int i7) throws RemoteException {
        this.f15800a.b(new Status(i7));
    }
}
