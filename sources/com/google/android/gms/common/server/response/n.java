package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class n implements Parcelable.Creator<zal> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zal createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        String strG = null;
        ArrayList arrayListL = null;
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
                arrayListL = e1.a.L(parcel, iX, zam.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zal(iZ, strG, arrayListL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zal[] newArray(int i7) {
        return new zal[i7];
    }
}
