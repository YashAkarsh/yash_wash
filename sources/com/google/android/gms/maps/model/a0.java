package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a0 implements Parcelable.Creator<PolylineOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ PolylineOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        ArrayList arrayListL = null;
        Cap cap = null;
        Cap cap2 = null;
        ArrayList arrayListL2 = null;
        float fV = 0.0f;
        float fV2 = 0.0f;
        int iZ = 0;
        boolean zP = false;
        boolean zP2 = false;
        boolean zP3 = false;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 2:
                    arrayListL = e1.a.L(parcel, iX, LatLng.CREATOR);
                    break;
                case 3:
                    fV = e1.a.V(parcel, iX);
                    break;
                case 4:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 5:
                    fV2 = e1.a.V(parcel, iX);
                    break;
                case 6:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 7:
                    zP2 = e1.a.P(parcel, iX);
                    break;
                case 8:
                    zP3 = e1.a.P(parcel, iX);
                    break;
                case 9:
                    cap = (Cap) e1.a.C(parcel, iX, Cap.CREATOR);
                    break;
                case 10:
                    cap2 = (Cap) e1.a.C(parcel, iX, Cap.CREATOR);
                    break;
                case 11:
                    iZ2 = e1.a.Z(parcel, iX);
                    break;
                case 12:
                    arrayListL2 = e1.a.L(parcel, iX, PatternItem.CREATOR);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new PolylineOptions(arrayListL, fV, iZ, fV2, zP, zP2, zP3, cap, cap2, iZ2, arrayListL2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolylineOptions[] newArray(int i7) {
        return new PolylineOptions[i7];
    }
}
