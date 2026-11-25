package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class y1 implements Parcelable.Creator<ConnectionTelemetryConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ConnectionTelemetryConfiguration createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrU = null;
        int[] iArrU2 = null;
        boolean zP = false;
        boolean zP2 = false;
        int iZ = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) e1.a.C(parcel, iX, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 3:
                    zP2 = e1.a.P(parcel, iX);
                    break;
                case 4:
                    iArrU = e1.a.u(parcel, iX);
                    break;
                case 5:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 6:
                    iArrU2 = e1.a.u(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zP, zP2, iArrU, iZ, iArrU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionTelemetryConfiguration[] newArray(int i7) {
        return new ConnectionTelemetryConfiguration[i7];
    }
}
