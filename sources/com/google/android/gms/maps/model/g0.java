package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g0 implements Parcelable.Creator<Tile> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Tile createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        byte[] bArrH = null;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 3) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                bArrH = e1.a.h(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new Tile(iZ, iZ2, bArrH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile[] newArray(int i7) {
        return new Tile[i7];
    }
}
