package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class n extends com.google.android.gms.internal.maps.l implements o {
    public n() {
        super("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            e();
        } else {
            if (i7 != 2) {
                return false;
            }
            a4(com.google.android.gms.internal.maps.a0.u0(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
