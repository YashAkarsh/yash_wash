package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator<PlaceReport> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceReport createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                strG = e1.a.G(parcel, iX);
            } else if (iO == 3) {
                strG2 = e1.a.G(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                strG3 = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new PlaceReport(iZ, strG, strG2, strG3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceReport[] newArray(int i7) {
        return new PlaceReport[i7];
    }
}
