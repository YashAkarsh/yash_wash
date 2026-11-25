package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class j0 extends com.google.android.gms.internal.maps.l implements k0 {
    public j0() {
        super("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        boolean zE = e();
        parcel2.writeNoException();
        com.google.android.gms.internal.maps.m.c(parcel2, zE);
        return true;
    }
}
