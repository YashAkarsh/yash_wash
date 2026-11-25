package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.PointOfInterest;

/* JADX INFO: loaded from: classes.dex */
public abstract class q0 extends com.google.android.gms.internal.maps.l implements r0 {
    public q0() {
        super("com.google.android.gms.maps.internal.IOnPoiClickListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        Z0((PointOfInterest) com.google.android.gms.internal.maps.m.a(parcel, PointOfInterest.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
