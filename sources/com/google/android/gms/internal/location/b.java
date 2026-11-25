package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator<zzaa> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaa createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        Status status = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            if (e1.a.O(iX) != 1) {
                e1.a.h0(parcel, iX);
            } else {
                status = (Status) e1.a.C(parcel, iX, Status.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzaa(status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaa[] newArray(int i7) {
        return new zzaa[i7];
    }
}
