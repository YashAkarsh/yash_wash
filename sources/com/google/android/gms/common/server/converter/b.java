package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator<StringToIntConverter> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ StringToIntConverter createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        ArrayList arrayListL = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 2) {
                e1.a.h0(parcel, iX);
            } else {
                arrayListL = e1.a.L(parcel, iX, zac.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new StringToIntConverter(iZ, arrayListL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter[] newArray(int i7) {
        return new StringToIntConverter[i7];
    }
}
