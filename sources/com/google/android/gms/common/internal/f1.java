package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class f1 extends com.google.android.gms.internal.common.a implements o {
    f1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.common.internal.o
    public final void M3(int i7, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel parcelZ3 = z3();
        parcelZ3.writeInt(i7);
        parcelZ3.writeStrongBinder(iBinder);
        com.google.android.gms.internal.common.n.c(parcelZ3, bundle);
        u0(1, parcelZ3);
    }

    @Override // com.google.android.gms.common.internal.o
    public final void b4(int i7, IBinder iBinder, zzj zzjVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.common.internal.o
    public final void w2(int i7, Bundle bundle) throws RemoteException {
        throw null;
    }
}
