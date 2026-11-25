package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator<DataHolder> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DataHolder createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        String[] strArrH = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleG = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                strArrH = e1.a.H(parcel, iX);
            } else if (iO == 2) {
                cursorWindowArr = (CursorWindow[]) e1.a.K(parcel, iX, CursorWindow.CREATOR);
            } else if (iO == 3) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO == 4) {
                bundleG = e1.a.g(parcel, iX);
            } else if (iO != 1000) {
                e1.a.h0(parcel, iX);
            } else {
                iZ = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        DataHolder dataHolder = new DataHolder(iZ, strArrH, cursorWindowArr, iZ2, bundleG);
        dataHolder.V0();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i7) {
        return new DataHolder[i7];
    }
}
