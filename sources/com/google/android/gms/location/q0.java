package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class q0 extends com.google.android.gms.internal.location.a0 implements r0 {
    public static r0 u0(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return iInterfaceQueryLocalInterface instanceof r0 ? (r0) iInterfaceQueryLocalInterface : new p0(iBinder);
    }

    @Override // com.google.android.gms.internal.location.a0
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        throw null;
    }
}
