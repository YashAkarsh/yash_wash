package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator<GroundOverlayOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GroundOverlayOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        IBinder iBinderY = null;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        float fV = 0.0f;
        float fV2 = 0.0f;
        float fV3 = 0.0f;
        float fV4 = 0.0f;
        float fV5 = 0.0f;
        float fV6 = 0.0f;
        float fV7 = 0.0f;
        boolean zP = false;
        boolean zP2 = false;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 2:
                    iBinderY = e1.a.Y(parcel, iX);
                    break;
                case 3:
                    latLng = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
                    break;
                case 4:
                    fV = e1.a.V(parcel, iX);
                    break;
                case 5:
                    fV2 = e1.a.V(parcel, iX);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) e1.a.C(parcel, iX, LatLngBounds.CREATOR);
                    break;
                case 7:
                    fV3 = e1.a.V(parcel, iX);
                    break;
                case 8:
                    fV4 = e1.a.V(parcel, iX);
                    break;
                case 9:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 10:
                    fV5 = e1.a.V(parcel, iX);
                    break;
                case 11:
                    fV6 = e1.a.V(parcel, iX);
                    break;
                case 12:
                    fV7 = e1.a.V(parcel, iX);
                    break;
                case 13:
                    zP2 = e1.a.P(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new GroundOverlayOptions(iBinderY, latLng, fV, fV2, latLngBounds, fV3, fV4, zP, fV5, fV6, fV7, zP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GroundOverlayOptions[] newArray(int i7) {
        return new GroundOverlayOptions[i7];
    }
}
