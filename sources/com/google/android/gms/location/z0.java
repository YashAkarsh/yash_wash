package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Parcelable.Creator<LocationAvailability> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationAvailability createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 1000;
        int iZ2 = 1;
        int iZ3 = 1;
        long jC0 = 0;
        zzbo[] zzboVarArr = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                iZ3 = e1.a.Z(parcel, iX);
            } else if (iO == 3) {
                jC0 = e1.a.c0(parcel, iX);
            } else if (iO == 4) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                zzboVarArr = (zzbo[]) e1.a.K(parcel, iX, zzbo.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new LocationAvailability(iZ, iZ2, iZ3, jC0, zzboVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationAvailability[] newArray(int i7) {
        return new LocationAvailability[i7];
    }
}
