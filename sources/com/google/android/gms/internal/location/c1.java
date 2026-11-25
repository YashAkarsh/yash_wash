package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c1 implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzl createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        zzj zzjVar = null;
        int iZ = 1;
        IBinder iBinderY = null;
        IBinder iBinderY2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                zzjVar = (zzj) e1.a.C(parcel, iX, zzj.CREATOR);
            } else if (iO == 3) {
                iBinderY = e1.a.Y(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                iBinderY2 = e1.a.Y(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzl(iZ, zzjVar, iBinderY, iBinderY2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzl[] newArray(int i7) {
        return new zzl[i7];
    }
}
