package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 extends com.google.android.gms.internal.maps.l implements i0 {
    public h0() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            S2(com.google.android.gms.internal.maps.g0.u0(parcel.readStrongBinder()));
        } else if (i7 == 2) {
            m(com.google.android.gms.internal.maps.g0.u0(parcel.readStrongBinder()));
        } else {
            if (i7 != 3) {
                return false;
            }
            U(com.google.android.gms.internal.maps.g0.u0(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
