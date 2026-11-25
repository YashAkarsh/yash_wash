package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class m extends com.google.android.gms.internal.base.a implements IInterface {
    m(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void t6(l lVar) throws RemoteException {
        Parcel parcelI0 = i0();
        com.google.android.gms.internal.base.c.d(parcelI0, lVar);
        z3(1, parcelI0);
    }
}
