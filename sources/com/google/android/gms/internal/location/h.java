package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends a0 implements i {
    public h() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.a0
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            Q5((zzaa) u0.b(parcel, zzaa.CREATOR));
        } else {
            if (i7 != 2) {
                return false;
            }
            t();
        }
        return true;
    }
}
