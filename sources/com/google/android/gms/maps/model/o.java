package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Parcelable.Creator<CameraPosition> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ CameraPosition createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        LatLng latLng = null;
        float fV = 0.0f;
        float fV2 = 0.0f;
        float fV3 = 0.0f;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                latLng = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
            } else if (iO == 3) {
                fV = e1.a.V(parcel, iX);
            } else if (iO == 4) {
                fV2 = e1.a.V(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                fV3 = e1.a.V(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new CameraPosition(latLng, fV, fV2, fV3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition[] newArray(int i7) {
        return new CameraPosition[i7];
    }
}
