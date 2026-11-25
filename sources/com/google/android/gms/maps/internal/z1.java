package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: loaded from: classes.dex */
public abstract class z1 extends com.google.android.gms.internal.maps.l implements a2 {
    public z1() {
        super("com.google.android.gms.maps.internal.IOnCameraChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        Q4((CameraPosition) com.google.android.gms.internal.maps.m.a(parcel, CameraPosition.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
