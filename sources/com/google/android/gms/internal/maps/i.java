package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a implements k {
    i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    @Override // com.google.android.gms.internal.maps.k
    public final Tile G4(int i7, int i8, int i9) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        parcelU0.writeInt(i8);
        parcelU0.writeInt(i9);
        Parcel parcelI0 = i0(1, parcelU0);
        Tile tile = (Tile) m.a(parcelI0, Tile.CREATOR);
        parcelI0.recycle();
        return tile;
    }
}
