package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b1 implements Parcelable.Creator<LocationResult> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationResult createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        List<Location> listL = LocationResult.f16282b;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            if (e1.a.O(iX) != 1) {
                e1.a.h0(parcel, iX);
            } else {
                listL = e1.a.L(parcel, iX, Location.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new LocationResult(listL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationResult[] newArray(int i7) {
        return new LocationResult[i7];
    }
}
