package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Parcelable.Creator<LatLngBounds> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LatLngBounds createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                latLng = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                latLng2 = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new LatLngBounds(latLng, latLng2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LatLngBounds[] newArray(int i7) {
        return new LatLngBounds[i7];
    }
}
