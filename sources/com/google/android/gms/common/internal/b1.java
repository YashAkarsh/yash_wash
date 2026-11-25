package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class b1 implements Parcelable.Creator<zav> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zav createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        boolean zP = false;
        boolean zP2 = false;
        IBinder iBinderY = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                iBinderY = e1.a.Y(parcel, iX);
            } else if (iO == 3) {
                connectionResult = (ConnectionResult) e1.a.C(parcel, iX, ConnectionResult.CREATOR);
            } else if (iO == 4) {
                zP = e1.a.P(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                zP2 = e1.a.P(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zav(iZ, iBinderY, connectionResult, zP, zP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zav[] newArray(int i7) {
        return new zav[i7];
    }
}
