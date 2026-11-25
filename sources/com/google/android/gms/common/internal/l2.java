package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class l2 extends com.google.android.gms.internal.common.m implements m2 {
    public l2() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static m2 u0(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterfaceQueryLocalInterface instanceof m2 ? (m2) iInterfaceQueryLocalInterface : new k2(iBinder);
    }

    @Override // com.google.android.gms.internal.common.m
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            com.google.android.gms.dynamic.d dVarA = a();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.n.e(parcel2, dVarA);
        } else {
            if (i7 != 2) {
                return false;
            }
            int iT = t();
            parcel2.writeNoException();
            parcel2.writeInt(iT);
        }
        return true;
    }
}
