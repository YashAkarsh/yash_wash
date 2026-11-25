package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class z1 implements Parcelable.Creator<ActivityTransition> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ActivityTransition createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 2) {
                e1.a.h0(parcel, iX);
            } else {
                iZ2 = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new ActivityTransition(iZ, iZ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ActivityTransition[] newArray(int i7) {
        return new ActivityTransition[i7];
    }
}
