package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Parcelable.Creator<TileOverlayOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ TileOverlayOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        IBinder iBinderY = null;
        boolean zP = false;
        float fV = 0.0f;
        float fV2 = 0.0f;
        boolean zP2 = true;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 2) {
                iBinderY = e1.a.Y(parcel, iX);
            } else if (iO == 3) {
                zP = e1.a.P(parcel, iX);
            } else if (iO == 4) {
                fV = e1.a.V(parcel, iX);
            } else if (iO == 5) {
                zP2 = e1.a.P(parcel, iX);
            } else if (iO != 6) {
                e1.a.h0(parcel, iX);
            } else {
                fV2 = e1.a.V(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new TileOverlayOptions(iBinderY, zP, fV, zP2, fV2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TileOverlayOptions[] newArray(int i7) {
        return new TileOverlayOptions[i7];
    }
}
