package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class e1 extends com.google.android.gms.maps.internal.h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.y f16508a;

    e1(c cVar, c.y yVar) {
        this.f16508a = yVar;
    }

    @Override // com.google.android.gms.maps.internal.i1
    public final void P5(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        this.f16508a.a((Bitmap) com.google.android.gms.dynamic.f.y0(dVar));
    }

    @Override // com.google.android.gms.maps.internal.i1
    public final void u2(Bitmap bitmap) throws RemoteException {
        this.f16508a.a(bitmap);
    }
}
