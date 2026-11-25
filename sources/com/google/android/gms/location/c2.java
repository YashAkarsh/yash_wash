package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c2 implements Parcelable.Creator<ActivityTransitionRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ActivityTransitionRequest createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        ArrayList arrayListL = null;
        String strG = null;
        ArrayList arrayListL2 = null;
        String strG2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                arrayListL = e1.a.L(parcel, iX, ActivityTransition.CREATOR);
            } else if (iO == 2) {
                strG = e1.a.G(parcel, iX);
            } else if (iO == 3) {
                arrayListL2 = e1.a.L(parcel, iX, ClientIdentity.CREATOR);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                strG2 = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new ActivityTransitionRequest(arrayListL, strG, arrayListL2, strG2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ActivityTransitionRequest[] newArray(int i7) {
        return new ActivityTransitionRequest[i7];
    }
}
