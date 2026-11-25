package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: loaded from: classes.dex */
public abstract class b0 extends com.google.android.gms.internal.maps.l implements c0 {
    public b0() {
        super("com.google.android.gms.maps.internal.IOnMapLongClickListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        k0((LatLng) com.google.android.gms.internal.maps.m.a(parcel, LatLng.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
