package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class z implements Parcelable.Creator<PolygonOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ PolygonOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayListL = null;
        float fV = 0.0f;
        int iZ = 0;
        int iZ2 = 0;
        boolean zP = false;
        boolean zP2 = false;
        boolean zP3 = false;
        int iZ3 = 0;
        float fV2 = 0.0f;
        ArrayList arrayListL2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 2:
                    arrayListL2 = e1.a.L(parcel, iX, LatLng.CREATOR);
                    break;
                case 3:
                    e1.a.b0(parcel, iX, arrayList, z.class.getClassLoader());
                    break;
                case 4:
                    fV2 = e1.a.V(parcel, iX);
                    break;
                case 5:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 6:
                    iZ2 = e1.a.Z(parcel, iX);
                    break;
                case 7:
                    fV = e1.a.V(parcel, iX);
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
                    iZ3 = e1.a.Z(parcel, iX);
                    break;
                case 12:
                    arrayListL = e1.a.L(parcel, iX, PatternItem.CREATOR);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new PolygonOptions(arrayListL2, arrayList, fV2, iZ, iZ2, fV, zP, zP2, zP3, iZ3, arrayListL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PolygonOptions[] newArray(int i7) {
        return new PolygonOptions[i7];
    }
}
