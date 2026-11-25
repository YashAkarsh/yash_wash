package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class t extends com.google.android.gms.internal.common.a implements IInterface {
    t(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final com.google.android.gms.dynamic.d t6(com.google.android.gms.dynamic.d dVar, String str, int i7, com.google.android.gms.dynamic.d dVar2) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar);
        parcelZ3.writeString(str);
        parcelZ3.writeInt(i7);
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar2);
        Parcel parcelI0 = i0(2, parcelZ3);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    public final com.google.android.gms.dynamic.d u6(com.google.android.gms.dynamic.d dVar, String str, int i7, com.google.android.gms.dynamic.d dVar2) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar);
        parcelZ3.writeString(str);
        parcelZ3.writeInt(i7);
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar2);
        Parcel parcelI0 = i0(3, parcelZ3);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }
}
