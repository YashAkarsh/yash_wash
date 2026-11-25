package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Status createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        String strG = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                strG = e1.a.G(parcel, iX);
            } else if (iO == 3) {
                pendingIntent = (PendingIntent) e1.a.C(parcel, iX, PendingIntent.CREATOR);
            } else if (iO == 4) {
                connectionResult = (ConnectionResult) e1.a.C(parcel, iX, ConnectionResult.CREATOR);
            } else if (iO != 1000) {
                e1.a.h0(parcel, iX);
            } else {
                iZ = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new Status(iZ, iZ2, strG, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i7) {
        return new Status[i7];
    }
}
