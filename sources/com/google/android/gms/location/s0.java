package com.google.android.gms.location;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class s0 extends com.google.android.gms.internal.location.a implements v0 {
    s0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.location.v0
    public final void A2(LocationAvailability locationAvailability) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.location.v0
    public final void o1(LocationResult locationResult) throws RemoteException {
        throw null;
    }
}
