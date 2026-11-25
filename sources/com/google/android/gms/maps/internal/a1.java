package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* JADX INFO: loaded from: classes.dex */
public abstract class a1 extends com.google.android.gms.internal.maps.l implements b1 {
    public a1() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        S((StreetViewPanoramaOrientation) com.google.android.gms.internal.maps.m.a(parcel, StreetViewPanoramaOrientation.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
