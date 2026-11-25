package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator<zak> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zak createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        ConnectionResult connectionResult = null;
        zav zavVar = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                connectionResult = (ConnectionResult) e1.a.C(parcel, iX, ConnectionResult.CREATOR);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                zavVar = (zav) e1.a.C(parcel, iX, zav.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zak(iZ, connectionResult, zavVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak[] newArray(int i7) {
        return new zak[i7];
    }
}
