package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b2 extends com.google.android.gms.internal.maps.l implements c2 {
    public b2() {
        super("com.google.android.gms.maps.internal.IOnCameraIdleListener");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        e();
        parcel2.writeNoException();
        return true;
    }
}
