package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class o1 implements Parcelable.Creator<SleepSegmentRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SleepSegmentRequest createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        ArrayList arrayListL = null;
        int iZ = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                arrayListL = e1.a.L(parcel, iX, zzbx.CREATOR);
            } else if (iO != 2) {
                e1.a.h0(parcel, iX);
            } else {
                iZ = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new SleepSegmentRequest(arrayListL, iZ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SleepSegmentRequest[] newArray(int i7) {
        return new SleepSegmentRequest[i7];
    }
}
