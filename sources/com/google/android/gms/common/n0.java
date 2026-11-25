package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Parcelable.Creator<zzs> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        String strG = null;
        boolean zP = false;
        boolean zP2 = false;
        IBinder iBinderY = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                strG = e1.a.G(parcel, iX);
            } else if (iO == 2) {
                iBinderY = e1.a.Y(parcel, iX);
            } else if (iO == 3) {
                zP = e1.a.P(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                zP2 = e1.a.P(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzs(strG, iBinderY, zP, zP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzs[] newArray(int i7) {
        return new zzs[i7];
    }
}
