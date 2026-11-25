package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class g1 extends com.google.android.gms.internal.common.m implements o {
    public g1() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.internal.common.m
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            M3(parcel.readInt(), parcel.readStrongBinder(), (Bundle) com.google.android.gms.internal.common.n.a(parcel, Bundle.CREATOR));
        } else if (i7 == 2) {
            w2(parcel.readInt(), (Bundle) com.google.android.gms.internal.common.n.a(parcel, Bundle.CREATOR));
        } else {
            if (i7 != 3) {
                return false;
            }
            b4(parcel.readInt(), parcel.readStrongBinder(), (zzj) com.google.android.gms.internal.common.n.a(parcel, zzj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
