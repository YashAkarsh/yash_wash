package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Parcelable.Creator<MapStyleOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MapStyleOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        String strG = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            if (e1.a.O(iX) != 2) {
                e1.a.h0(parcel, iX);
            } else {
                strG = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new MapStyleOptions(strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MapStyleOptions[] newArray(int i7) {
        return new MapStyleOptions[i7];
    }
}
