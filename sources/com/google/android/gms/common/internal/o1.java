package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class o1 implements Parcelable.Creator<zzaj> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaj createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            if (e1.a.O(iX) != 1) {
                e1.a.h0(parcel, iX);
            } else {
                iZ = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzaj(iZ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaj[] newArray(int i7) {
        return new zzaj[i7];
    }
}
