package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable.Creator<MarkerOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MarkerOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        LatLng latLng = null;
        String strG = null;
        String strG2 = null;
        IBinder iBinderY = null;
        float fV = 0.0f;
        float fV2 = 0.0f;
        float fV3 = 0.0f;
        float fV4 = 0.0f;
        float fV5 = 0.0f;
        boolean zP = false;
        boolean zP2 = false;
        boolean zP3 = false;
        float fV6 = 0.5f;
        float fV7 = 1.0f;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 2:
                    latLng = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
                    break;
                case 3:
                    strG = e1.a.G(parcel, iX);
                    break;
                case 4:
                    strG2 = e1.a.G(parcel, iX);
                    break;
                case 5:
                    iBinderY = e1.a.Y(parcel, iX);
                    break;
                case 6:
                    fV = e1.a.V(parcel, iX);
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
                    zP3 = e1.a.P(parcel, iX);
                    break;
                case 11:
                    fV3 = e1.a.V(parcel, iX);
                    break;
                case 12:
                    fV6 = e1.a.V(parcel, iX);
                    break;
                case 13:
                    fV4 = e1.a.V(parcel, iX);
                    break;
                case 14:
                    fV7 = e1.a.V(parcel, iX);
                    break;
                case 15:
                    fV5 = e1.a.V(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new MarkerOptions(latLng, strG, strG2, iBinderY, fV, fV2, zP, zP2, zP3, fV3, fV6, fV4, fV7, fV5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions[] newArray(int i7) {
        return new MarkerOptions[i7];
    }
}
