package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator<GoogleMapOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GoogleMapOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        byte bR = -1;
        byte bR2 = -1;
        byte bR3 = -1;
        byte bR4 = -1;
        byte bR5 = -1;
        byte bR6 = -1;
        byte bR7 = -1;
        byte bR8 = -1;
        byte bR9 = -1;
        byte bR10 = -1;
        byte bR11 = -1;
        byte bR12 = -1;
        int iZ = 0;
        CameraPosition cameraPosition = null;
        Float fW = null;
        Float fW2 = null;
        LatLngBounds latLngBounds = null;
        Integer numA0 = null;
        String strG = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 2:
                    bR = e1.a.R(parcel, iX);
                    break;
                case 3:
                    bR2 = e1.a.R(parcel, iX);
                    break;
                case 4:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) e1.a.C(parcel, iX, CameraPosition.CREATOR);
                    break;
                case 6:
                    bR3 = e1.a.R(parcel, iX);
                    break;
                case 7:
                    bR4 = e1.a.R(parcel, iX);
                    break;
                case 8:
                    bR5 = e1.a.R(parcel, iX);
                    break;
                case 9:
                    bR6 = e1.a.R(parcel, iX);
                    break;
                case 10:
                    bR7 = e1.a.R(parcel, iX);
                    break;
                case 11:
                    bR8 = e1.a.R(parcel, iX);
                    break;
                case 12:
                    bR9 = e1.a.R(parcel, iX);
                    break;
                case 13:
                default:
                    e1.a.h0(parcel, iX);
                    break;
                case 14:
                    bR10 = e1.a.R(parcel, iX);
                    break;
                case 15:
                    bR11 = e1.a.R(parcel, iX);
                    break;
                case 16:
                    fW = e1.a.W(parcel, iX);
                    break;
                case 17:
                    fW2 = e1.a.W(parcel, iX);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) e1.a.C(parcel, iX, LatLngBounds.CREATOR);
                    break;
                case 19:
                    bR12 = e1.a.R(parcel, iX);
                    break;
                case 20:
                    numA0 = e1.a.a0(parcel, iX);
                    break;
                case 21:
                    strG = e1.a.G(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new GoogleMapOptions(bR, bR2, iZ, cameraPosition, bR3, bR4, bR5, bR6, bR7, bR8, bR9, bR10, bR11, fW, fW2, latLngBounds, bR12, numA0, strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleMapOptions[] newArray(int i7) {
        return new GoogleMapOptions[i7];
    }
}
