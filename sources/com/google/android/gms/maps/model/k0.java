package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k0 implements Parcelable.Creator<VisibleRegion> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ VisibleRegion createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                latLng = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
            } else if (iO == 3) {
                latLng2 = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
            } else if (iO == 4) {
                latLng3 = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
            } else if (iO == 5) {
                latLng4 = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
            } else if (iO != 6) {
                e1.a.h0(parcel, iX);
            } else {
                latLngBounds = (LatLngBounds) e1.a.C(parcel, iX, LatLngBounds.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new VisibleRegion(latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ VisibleRegion[] newArray(int i7) {
        return new VisibleRegion[i7];
    }
}
