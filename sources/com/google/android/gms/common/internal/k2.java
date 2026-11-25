package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class k2 extends com.google.android.gms.internal.common.a implements m2 {
    k2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.m2
    public final com.google.android.gms.dynamic.d a() throws RemoteException {
        Parcel parcelI0 = i0(1, z3());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.common.internal.m2
    public final int t() throws RemoteException {
        Parcel parcelI0 = i0(2, z3());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }
}
