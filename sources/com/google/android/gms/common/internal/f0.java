package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Parcelable.Creator<TelemetryData> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ TelemetryData createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        ArrayList arrayListL = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 2) {
                e1.a.h0(parcel, iX);
            } else {
                arrayListL = e1.a.L(parcel, iX, MethodInvocation.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new TelemetryData(iZ, arrayListL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TelemetryData[] newArray(int i7) {
        return new TelemetryData[i7];
    }
}
