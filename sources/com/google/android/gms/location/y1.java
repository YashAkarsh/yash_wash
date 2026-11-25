package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class y1 implements Parcelable.Creator<ActivityRecognitionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ActivityRecognitionResult createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        ArrayList arrayListL = null;
        Bundle bundleG = null;
        long jC0 = 0;
        long jC1 = 0;
        int iZ = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                arrayListL = e1.a.L(parcel, iX, DetectedActivity.CREATOR);
            } else if (iO == 2) {
                jC0 = e1.a.c0(parcel, iX);
            } else if (iO == 3) {
                jC1 = e1.a.c0(parcel, iX);
            } else if (iO == 4) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO != 5) {
                e1.a.h0(parcel, iX);
            } else {
                bundleG = e1.a.g(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new ActivityRecognitionResult(arrayListL, jC0, jC1, iZ, bundleG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ActivityRecognitionResult[] newArray(int i7) {
        return new ActivityRecognitionResult[i7];
    }
}
