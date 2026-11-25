package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class o1 extends com.google.android.gms.internal.maps.l implements q1 {
    public o1() {
        super("com.google.android.gms.maps.internal.ICancelableCallback");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            t();
        } else {
            if (i7 != 2) {
                return false;
            }
            e();
        }
        parcel2.writeNoException();
        return true;
    }
}
