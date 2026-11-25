package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Parcelable.Creator<StreetViewPanoramaOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        String strG = null;
        LatLng latLng = null;
        Integer numA0 = null;
        StreetViewSource streetViewSource = null;
        byte bR = 0;
        byte bR2 = 0;
        byte bR3 = 0;
        byte bR4 = 0;
        byte bR5 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) e1.a.C(parcel, iX, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    strG = e1.a.G(parcel, iX);
                    break;
                case 4:
                    latLng = (LatLng) e1.a.C(parcel, iX, LatLng.CREATOR);
                    break;
                case 5:
                    numA0 = e1.a.a0(parcel, iX);
                    break;
                case 6:
                    bR = e1.a.R(parcel, iX);
                    break;
                case 7:
                    bR2 = e1.a.R(parcel, iX);
                    break;
                case 8:
                    bR3 = e1.a.R(parcel, iX);
                    break;
                case 9:
                    bR4 = e1.a.R(parcel, iX);
                    break;
                case 10:
                    bR5 = e1.a.R(parcel, iX);
                    break;
                case 11:
                    streetViewSource = (StreetViewSource) e1.a.C(parcel, iX, StreetViewSource.CREATOR);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, strG, latLng, numA0, bR, bR2, bR3, bR4, bR5, streetViewSource);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOptions[] newArray(int i7) {
        return new StreetViewPanoramaOptions[i7];
    }
}
