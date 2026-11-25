package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.model.PointOfInterest;

/* JADX INFO: loaded from: classes.dex */
final class f1 extends com.google.android.gms.maps.internal.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.v f16515a;

    f1(c cVar, c.v vVar) {
        this.f16515a = vVar;
    }

    @Override // com.google.android.gms.maps.internal.r0
    public final void Z0(PointOfInterest pointOfInterest) throws RemoteException {
        this.f16515a.a(pointOfInterest);
    }
}
