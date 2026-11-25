package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class n1 implements Parcelable.Creator<RootTelemetryConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ RootTelemetryConfiguration createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        boolean zP = false;
        boolean zP2 = false;
        int iZ2 = 0;
        int iZ3 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                zP = e1.a.P(parcel, iX);
            } else if (iO == 3) {
                zP2 = e1.a.P(parcel, iX);
            } else if (iO == 4) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                iZ3 = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new RootTelemetryConfiguration(iZ, zP, zP2, iZ2, iZ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RootTelemetryConfiguration[] newArray(int i7) {
        return new RootTelemetryConfiguration[i7];
    }
}
