package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Parcelable.Creator<PointOfInterest> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ PointOfInterest createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        LatLng latLng = null;
        String strG = null;
        String strG2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                latLng = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
            } else if (iO == 3) {
                strG = e1.a.G(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                strG2 = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new PointOfInterest(latLng, strG, strG2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PointOfInterest[] newArray(int i7) {
        return new PointOfInterest[i7];
    }
}
