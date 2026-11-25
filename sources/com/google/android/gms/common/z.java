package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class z implements Parcelable.Creator<Feature> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Feature createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        String strG = null;
        int iZ = 0;
        long jC0 = -1;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                strG = e1.a.G(parcel, iX);
            } else if (iO == 2) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                jC0 = e1.a.c0(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new Feature(strG, iZ, jC0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature[] newArray(int i7) {
        return new Feature[i7];
    }
}
