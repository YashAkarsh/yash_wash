package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator<CircleOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ CircleOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        LatLng latLng = null;
        ArrayList arrayListL = null;
        double dT = 0.0d;
        float fV = 0.0f;
        float fV2 = 0.0f;
        int iZ = 0;
        int iZ2 = 0;
        boolean zP = false;
        boolean zP2 = false;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 2:
                    latLng = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
                    break;
                case 3:
                    dT = e1.a.T(parcel, iX);
                    break;
                case 4:
                    fV = e1.a.V(parcel, iX);
                    break;
                case 5:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 6:
                    iZ2 = e1.a.Z(parcel, iX);
                    break;
                case 7:
                    fV2 = e1.a.V(parcel, iX);
                    break;
                case 8:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 9:
                    zP2 = e1.a.P(parcel, iX);
                    break;
                case 10:
                    arrayListL = e1.a.L(parcel, iX, PatternItem.CREATOR);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new CircleOptions(latLng, dT, fV, iZ, iZ2, fV2, zP, zP2, arrayListL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CircleOptions[] newArray(int i7) {
        return new CircleOptions[i7];
    }
}
