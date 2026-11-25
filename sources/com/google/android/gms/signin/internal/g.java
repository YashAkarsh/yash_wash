package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.Creator<zag> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zag createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        ArrayList<String> arrayListI = null;
        String strG = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                arrayListI = e1.a.I(parcel, iX);
            } else if (iO != 2) {
                e1.a.h0(parcel, iX);
            } else {
                strG = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zag(arrayListI, strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zag[] newArray(int i7) {
        return new zag[i7];
    }
}
