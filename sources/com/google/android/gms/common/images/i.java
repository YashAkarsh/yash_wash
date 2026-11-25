package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator<WebImage> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ WebImage createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        Uri uri = null;
        int iZ3 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                uri = (Uri) e1.a.C(parcel, iX, Uri.CREATOR);
            } else if (iO == 3) {
                iZ3 = e1.a.Z(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                iZ2 = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new WebImage(iZ, uri, iZ3, iZ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage[] newArray(int i7) {
        return new WebImage[i7];
    }
}
