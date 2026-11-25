package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class x implements Parcelable.Creator<PatternItem> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ PatternItem createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        Float fW = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                fW = e1.a.W(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new PatternItem(iZ, fW);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PatternItem[] newArray(int i7) {
        return new PatternItem[i7];
    }
}
