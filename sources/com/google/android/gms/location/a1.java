package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a1 implements Parcelable.Creator<LocationRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 102;
        long jC0 = 3600000;
        long jC1 = 600000;
        boolean zP = false;
        boolean zP2 = false;
        long jC2 = Long.MAX_VALUE;
        int iZ2 = Integer.MAX_VALUE;
        float fV = 0.0f;
        long jC3 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 2:
                    jC0 = e1.a.c0(parcel, iX);
                    break;
                case 3:
                    jC1 = e1.a.c0(parcel, iX);
                    break;
                case 4:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 5:
                    jC2 = e1.a.c0(parcel, iX);
                    break;
                case 6:
                    iZ2 = e1.a.Z(parcel, iX);
                    break;
                case 7:
                    fV = e1.a.V(parcel, iX);
                    break;
                case 8:
                    jC3 = e1.a.c0(parcel, iX);
                    break;
                case 9:
                    zP2 = e1.a.P(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new LocationRequest(iZ, jC0, jC1, zP, jC2, iZ2, fV, jC3, zP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationRequest[] newArray(int i7) {
        return new LocationRequest[i7];
    }
}
