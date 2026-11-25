package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator<zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zaa createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 2) {
                e1.a.h0(parcel, iX);
            } else {
                stringToIntConverter = (StringToIntConverter) e1.a.C(parcel, iX, StringToIntConverter.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zaa(iZ, stringToIntConverter);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa[] newArray(int i7) {
        return new zaa[i7];
    }
}
