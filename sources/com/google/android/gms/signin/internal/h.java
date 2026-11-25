package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator<zai> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zai createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        zat zatVar = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 2) {
                e1.a.h0(parcel, iX);
            } else {
                zatVar = (zat) e1.a.C(parcel, iX, zat.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zai(iZ, zatVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zai[] newArray(int i7) {
        return new zai[i7];
    }
}
