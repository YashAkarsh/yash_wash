package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h1 extends com.google.android.gms.internal.maps.l implements i1 {
    public h1() {
        super("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            u2((Bitmap) com.google.android.gms.internal.maps.m.a(parcel, Bitmap.CREATOR));
        } else {
            if (i7 != 2) {
                return false;
            }
            P5(com.google.android.gms.dynamic.d.a.u0(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
