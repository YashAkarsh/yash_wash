package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e1 implements Parcelable.Creator<zzbj> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbj createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        String strG = "";
        String strG2 = "";
        String strG3 = strG2;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                strG2 = e1.a.G(parcel, iX);
            } else if (iO == 2) {
                strG3 = e1.a.G(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                strG = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzbj(strG, strG2, strG3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbj[] newArray(int i7) {
        return new zzbj[i7];
    }
}
