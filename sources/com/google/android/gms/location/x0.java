package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class x0 extends com.google.android.gms.internal.location.a0 implements y0 {
    public x0() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static y0 u0(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return iInterfaceQueryLocalInterface instanceof y0 ? (y0) iInterfaceQueryLocalInterface : new w0(iBinder);
    }

    @Override // com.google.android.gms.internal.location.a0
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        M((Location) com.google.android.gms.internal.location.u0.b(parcel, Location.CREATOR));
        return true;
    }
}
