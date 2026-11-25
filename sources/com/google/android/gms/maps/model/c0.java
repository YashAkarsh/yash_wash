package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements Parcelable.Creator<StreetViewPanoramaLink> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        String strG = null;
        float fV = 0.0f;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                strG = e1.a.G(parcel, iX);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                fV = e1.a.V(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new StreetViewPanoramaLink(strG, fV);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaLink[] newArray(int i7) {
        return new StreetViewPanoramaLink[i7];
    }
}
