package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator<BitmapTeleporter> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ BitmapTeleporter createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) e1.a.C(parcel, iX, ParcelFileDescriptor.CREATOR);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                iZ2 = e1.a.Z(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new BitmapTeleporter(iZ, parcelFileDescriptor, iZ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BitmapTeleporter[] newArray(int i7) {
        return new BitmapTeleporter[i7];
    }
}
