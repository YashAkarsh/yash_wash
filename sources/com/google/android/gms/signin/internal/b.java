package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator<zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zaa createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        Intent intent = null;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                intent = (Intent) e1.a.C(parcel, iX, Intent.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zaa(iZ, iZ2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa[] newArray(int i7) {
        return new zaa[i7];
    }
}
