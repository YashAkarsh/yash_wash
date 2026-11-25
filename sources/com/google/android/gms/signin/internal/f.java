package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.m;

/* JADX INFO: loaded from: classes.dex */
public final class f extends com.google.android.gms.internal.base.a implements IInterface {
    f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void t6(int i7) throws RemoteException {
        Parcel parcelI0 = i0();
        parcelI0.writeInt(i7);
        y0(7, parcelI0);
    }

    public final void u6(m mVar, int i7, boolean z7) throws RemoteException {
        Parcel parcelI0 = i0();
        com.google.android.gms.internal.base.c.d(parcelI0, mVar);
        parcelI0.writeInt(i7);
        com.google.android.gms.internal.base.c.b(parcelI0, z7);
        y0(9, parcelI0);
    }

    public final void v6(zai zaiVar, e eVar) throws RemoteException {
        Parcel parcelI0 = i0();
        com.google.android.gms.internal.base.c.c(parcelI0, zaiVar);
        com.google.android.gms.internal.base.c.d(parcelI0, eVar);
        y0(12, parcelI0);
    }
}
