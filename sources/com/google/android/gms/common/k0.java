package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k0 implements Parcelable.Creator<zzn> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzn createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        String strG = null;
        IBinder iBinderY = null;
        boolean zP = false;
        boolean zP2 = false;
        boolean zP3 = false;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                strG = e1.a.G(parcel, iX);
            } else if (iO == 2) {
                zP = e1.a.P(parcel, iX);
            } else if (iO == 3) {
                zP2 = e1.a.P(parcel, iX);
            } else if (iO == 4) {
                iBinderY = e1.a.Y(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                zP3 = e1.a.P(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzn(strG, zP, zP2, iBinderY, zP3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzn[] newArray(int i7) {
        return new zzn[i7];
    }
}
