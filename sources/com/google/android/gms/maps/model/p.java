package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable.Creator<Cap> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Cap createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        IBinder iBinderY = null;
        Float fW = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 3) {
                iBinderY = e1.a.Y(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                fW = e1.a.W(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new Cap(iZ, iBinderY, fW);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Cap[] newArray(int i7) {
        return new Cap[i7];
    }
}
