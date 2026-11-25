package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class u1 extends com.google.android.gms.internal.maps.l implements v1 {
    public u1() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            com.google.android.gms.dynamic.d dVarU = U(com.google.android.gms.internal.maps.g0.u0(parcel.readStrongBinder()));
            parcel2.writeNoException();
            com.google.android.gms.internal.maps.m.f(parcel2, dVarU);
        } else {
            if (i7 != 2) {
                return false;
            }
            com.google.android.gms.dynamic.d dVarM = m(com.google.android.gms.internal.maps.g0.u0(parcel.readStrongBinder()));
            parcel2.writeNoException();
            com.google.android.gms.internal.maps.m.f(parcel2, dVarM);
        }
        return true;
    }
}
