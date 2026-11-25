package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends l implements k {
    public j() {
        super("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public static k u0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        return iInterfaceQueryLocalInterface instanceof k ? (k) iInterfaceQueryLocalInterface : new i(iBinder);
    }

    @Override // com.google.android.gms.internal.maps.l
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        Tile tileG4 = G4(parcel.readInt(), parcel.readInt(), parcel.readInt());
        parcel2.writeNoException();
        m.e(parcel2, tileG4);
        return true;
    }
}
