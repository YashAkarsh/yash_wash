package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d2 implements Parcelable.Creator<ActivityTransitionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ActivityTransitionResult createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        ArrayList arrayListL = null;
        Bundle bundleG = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                arrayListL = e1.a.L(parcel, iX, ActivityTransitionEvent.CREATOR);
            } else if (iO != 2) {
                e1.a.h0(parcel, iX);
            } else {
                bundleG = e1.a.g(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new ActivityTransitionResult(arrayListL, bundleG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ActivityTransitionResult[] newArray(int i7) {
        return new ActivityTransitionResult[i7];
    }
}
