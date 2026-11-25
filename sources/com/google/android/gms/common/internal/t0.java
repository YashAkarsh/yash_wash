package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class t0 extends com.google.android.gms.internal.base.a implements IInterface {
    t0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final com.google.android.gms.dynamic.d t6(com.google.android.gms.dynamic.d dVar, zax zaxVar) throws RemoteException {
        Parcel parcelI0 = i0();
        com.google.android.gms.internal.base.c.d(parcelI0, dVar);
        com.google.android.gms.internal.base.c.c(parcelI0, zaxVar);
        Parcel parcelU0 = u0(2, parcelI0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelU0.readStrongBinder());
        parcelU0.recycle();
        return dVarU0;
    }
}
