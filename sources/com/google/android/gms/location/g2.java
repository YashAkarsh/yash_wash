package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g2 implements Parcelable.Creator<zzs> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        boolean zP = true;
        long jC0 = 50;
        float fV = 0.0f;
        long jC1 = Long.MAX_VALUE;
        int iZ = Integer.MAX_VALUE;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                zP = e1.a.P(parcel, iX);
            } else if (iO == 2) {
                jC0 = e1.a.c0(parcel, iX);
            } else if (iO == 3) {
                fV = e1.a.V(parcel, iX);
            } else if (iO == 4) {
                jC1 = e1.a.c0(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                iZ = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzs(zP, jC0, fV, jC1, iZ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs[] newArray(int i7) {
        return new zzs[i7];
    }
}
