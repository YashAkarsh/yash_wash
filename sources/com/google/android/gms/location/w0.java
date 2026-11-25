package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class w0 extends com.google.android.gms.internal.location.a implements y0 {
    w0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    @Override // com.google.android.gms.location.y0
    public final void M(Location location) throws RemoteException {
        throw null;
    }
}
