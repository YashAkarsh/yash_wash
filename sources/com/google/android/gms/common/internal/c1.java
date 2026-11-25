package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class c1 implements Parcelable.Creator<zax> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zax createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        Scope[] scopeArr = null;
        int iZ3 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                iZ3 = e1.a.Z(parcel, iX);
            } else if (iO == 3) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                scopeArr = (Scope[]) e1.a.K(parcel, iX, Scope.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zax(iZ, iZ3, iZ2, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zax[] newArray(int i7) {
        return new zax[i7];
    }
}
