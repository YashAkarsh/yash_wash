package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zaa;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator<FastJsonResponse.Field> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        boolean zP = false;
        int iZ3 = 0;
        boolean zP2 = false;
        int iZ4 = 0;
        String strG = null;
        String strG2 = null;
        zaa zaaVar = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 2:
                    iZ2 = e1.a.Z(parcel, iX);
                    break;
                case 3:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 4:
                    iZ3 = e1.a.Z(parcel, iX);
                    break;
                case 5:
                    zP2 = e1.a.P(parcel, iX);
                    break;
                case 6:
                    strG = e1.a.G(parcel, iX);
                    break;
                case 7:
                    iZ4 = e1.a.Z(parcel, iX);
                    break;
                case 8:
                    strG2 = e1.a.G(parcel, iX);
                    break;
                case 9:
                    zaaVar = (zaa) e1.a.C(parcel, iX, zaa.CREATOR);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new FastJsonResponse.Field(iZ, iZ2, zP, iZ3, zP2, strG, iZ4, strG2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field[] newArray(int i7) {
        return new FastJsonResponse.Field[i7];
    }
}
