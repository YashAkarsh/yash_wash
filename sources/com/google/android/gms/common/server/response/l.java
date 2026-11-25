package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Parcelable.Creator<zam> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zam createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        String strG = null;
        FastJsonResponse.Field field = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                strG = e1.a.G(parcel, iX);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                field = (FastJsonResponse.Field) e1.a.C(parcel, iX, FastJsonResponse.Field.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zam(iZ, strG, field);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam[] newArray(int i7) {
        return new zam[i7];
    }
}
