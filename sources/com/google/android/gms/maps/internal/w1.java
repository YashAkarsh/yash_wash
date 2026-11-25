package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class w1 extends com.google.android.gms.internal.maps.l implements c {
    public w1() {
        super("com.google.android.gms.maps.internal.ILocationSourceDelegate");
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        w vVar;
        if (i7 == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                vVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                vVar = iInterfaceQueryLocalInterface instanceof w ? (w) iInterfaceQueryLocalInterface : new v(strongBinder);
            }
            d1(vVar);
        } else {
            if (i7 != 2) {
                return false;
            }
            deactivate();
        }
        parcel2.writeNoException();
        return true;
    }
}
