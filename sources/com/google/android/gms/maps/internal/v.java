package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class v extends com.google.android.gms.internal.maps.a implements w {
    v(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IOnLocationChangeListener");
    }

    @Override // com.google.android.gms.maps.internal.w
    public final void M(Location location) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, location);
        y0(2, parcelU0);
    }
}
