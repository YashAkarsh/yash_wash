package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class o0 extends com.google.android.gms.internal.maps.l implements p0 {
    public o0() {
        super("com.google.android.gms.maps.internal.IOnMyLocationClickListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        F2((Location) com.google.android.gms.internal.maps.m.a(parcel, Location.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
