package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements Parcelable.Creator<zzbc> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbc createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 1;
        zzba zzbaVar = null;
        IBinder iBinderY = null;
        PendingIntent pendingIntent = null;
        IBinder iBinderY2 = null;
        IBinder iBinderY3 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 2:
                    zzbaVar = (zzba) e1.a.C(parcel, iX, zzba.CREATOR);
                    break;
                case 3:
                    iBinderY = e1.a.Y(parcel, iX);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) e1.a.C(parcel, iX, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinderY2 = e1.a.Y(parcel, iX);
                    break;
                case 6:
                    iBinderY3 = e1.a.Y(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new zzbc(iZ, zzbaVar, iBinderY, pendingIntent, iBinderY2, iBinderY3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbc[] newArray(int i7) {
        return new zzbc[i7];
    }
}
