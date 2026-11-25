package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class f0 extends com.google.android.gms.internal.maps.l implements g0 {
    public f0() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        boolean zM = m(com.google.android.gms.internal.maps.g0.u0(parcel.readStrongBinder()));
        parcel2.writeNoException();
        com.google.android.gms.internal.maps.m.c(parcel2, zM);
        return true;
    }
}
