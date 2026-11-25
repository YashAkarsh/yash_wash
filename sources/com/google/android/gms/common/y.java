package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Parcelable.Creator<ConnectionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ConnectionResult createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        PendingIntent pendingIntent = null;
        String strG = null;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO == 3) {
                pendingIntent = (PendingIntent) e1.a.C(parcel, iX, PendingIntent.CREATOR);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                strG = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new ConnectionResult(iZ, iZ2, pendingIntent, strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionResult[] newArray(int i7) {
        return new ConnectionResult[i7];
    }
}
