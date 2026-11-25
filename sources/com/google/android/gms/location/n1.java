package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class n1 implements Parcelable.Creator<SleepSegmentEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SleepSegmentEvent createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        long jC0 = 0;
        long jC1 = 0;
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                jC0 = e1.a.c0(parcel, iX);
            } else if (iO == 2) {
                jC1 = e1.a.c0(parcel, iX);
            } else if (iO == 3) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 4) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                iZ3 = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new SleepSegmentEvent(jC0, jC1, iZ, iZ2, iZ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SleepSegmentEvent[] newArray(int i7) {
        return new SleepSegmentEvent[i7];
    }
}
