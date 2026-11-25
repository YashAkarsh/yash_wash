package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Parcelable.Creator<StreetViewPanoramaLocation> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        LatLng latLng = null;
        String strG = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) e1.a.K(parcel, iX, StreetViewPanoramaLink.CREATOR);
            } else if (iO == 3) {
                latLng = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                strG = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new StreetViewPanoramaLocation(streetViewPanoramaLinkArr, latLng, strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaLocation[] newArray(int i7) {
        return new StreetViewPanoramaLocation[i7];
    }
}
