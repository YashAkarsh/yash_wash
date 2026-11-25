package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p1 implements Parcelable.Creator<zzbx> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbx createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        int iZ4 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO == 3) {
                iZ3 = e1.a.Z(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                iZ4 = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzbx(iZ, iZ2, iZ3, iZ4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbx[] newArray(int i7) {
        return new zzbx[i7];
    }
}
