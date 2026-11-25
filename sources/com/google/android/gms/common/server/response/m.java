package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator<zan> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zan createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        ArrayList arrayListL = null;
        String strG = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                arrayListL = e1.a.L(parcel, iX, zal.CREATOR);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                strG = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zan(iZ, arrayListL, strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zan[] newArray(int i7) {
        return new zan[i7];
    }
}
