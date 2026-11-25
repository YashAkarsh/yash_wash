package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class l2 extends com.google.android.gms.internal.maps.l implements m2 {
    public l2() {
        super("com.google.android.gms.maps.internal.IOnGroundOverlayClickListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        z0(com.google.android.gms.internal.maps.x.u0(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
