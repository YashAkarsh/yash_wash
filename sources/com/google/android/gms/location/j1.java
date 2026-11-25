package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class j1 implements Parcelable.Creator<zzbq> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbq createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        String strG = "";
        ArrayList<String> arrayListI = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                arrayListI = e1.a.I(parcel, iX);
            } else if (iO == 2) {
                pendingIntent = (PendingIntent) e1.a.C(parcel, iX, PendingIntent.CREATOR);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                strG = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzbq(arrayListI, pendingIntent, strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbq[] newArray(int i7) {
        return new zzbq[i7];
    }
}
