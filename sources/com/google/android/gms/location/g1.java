package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class g1 implements Parcelable.Creator<LocationSettingsResult> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationSettingsResult createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                status = (Status) e1.a.C(parcel, iX, Status.CREATOR);
            } else if (iO != 2) {
                e1.a.h0(parcel, iX);
            } else {
                locationSettingsStates = (LocationSettingsStates) e1.a.C(parcel, iX, LocationSettingsStates.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationSettingsResult[] newArray(int i7) {
        return new LocationSettingsResult[i7];
    }
}
