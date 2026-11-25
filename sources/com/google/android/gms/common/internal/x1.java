package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes.dex */
public final class x1 implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        Bundle bundleG = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int iZ = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                bundleG = e1.a.g(parcel, iX);
            } else if (iO == 2) {
                featureArr = (Feature[]) e1.a.K(parcel, iX, Feature.CREATOR);
            } else if (iO == 3) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) e1.a.C(parcel, iX, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzj(bundleG, featureArr, iZ, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i7) {
        return new zzj[i7];
    }
}
