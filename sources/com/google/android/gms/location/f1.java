package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f1 implements Parcelable.Creator<LocationSettingsRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationSettingsRequest createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        ArrayList arrayListL = null;
        boolean zP = false;
        boolean zP2 = false;
        zzbj zzbjVar = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                arrayListL = e1.a.L(parcel, iX, LocationRequest.CREATOR);
            } else if (iO == 2) {
                zP = e1.a.P(parcel, iX);
            } else if (iO == 3) {
                zP2 = e1.a.P(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                zzbjVar = (zzbj) e1.a.C(parcel, iX, zzbj.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new LocationSettingsRequest(arrayListL, zP, zP2, zzbjVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationSettingsRequest[] newArray(int i7) {
        return new LocationSettingsRequest[i7];
    }
}
