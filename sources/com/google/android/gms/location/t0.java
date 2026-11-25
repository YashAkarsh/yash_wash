package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class t0 extends com.google.android.gms.internal.location.a0 implements v0 {
    public t0() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static v0 u0(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterfaceQueryLocalInterface instanceof v0 ? (v0) iInterfaceQueryLocalInterface : new s0(iBinder);
    }

    @Override // com.google.android.gms.internal.location.a0
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            o1((LocationResult) com.google.android.gms.internal.location.u0.b(parcel, LocationResult.CREATOR));
        } else {
            if (i7 != 2) {
                return false;
            }
            A2((LocationAvailability) com.google.android.gms.internal.location.u0.b(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
