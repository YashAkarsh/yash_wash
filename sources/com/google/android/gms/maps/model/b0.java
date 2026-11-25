package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Parcelable.Creator<StreetViewPanoramaCamera> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        float fV = 0.0f;
        float fV2 = 0.0f;
        float fV3 = 0.0f;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                fV = e1.a.V(parcel, iX);
            } else if (iO == 3) {
                fV2 = e1.a.V(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                fV3 = e1.a.V(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new StreetViewPanoramaCamera(fV, fV2, fV3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaCamera[] newArray(int i7) {
        return new StreetViewPanoramaCamera[i7];
    }
}
