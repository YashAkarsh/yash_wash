package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class i1 implements Parcelable.Creator<zzbo> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbo createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 1;
        int iZ2 = 1;
        long jC0 = -1;
        long jC1 = -1;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO == 3) {
                jC0 = e1.a.c0(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                jC1 = e1.a.c0(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzbo(iZ, iZ2, jC0, jC1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbo[] newArray(int i7) {
        return new zzbo[i7];
    }
}
