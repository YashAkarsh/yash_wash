package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class h1 implements Parcelable.Creator<LocationSettingsStates> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationSettingsStates createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        boolean zP = false;
        boolean zP2 = false;
        boolean zP3 = false;
        boolean zP4 = false;
        boolean zP5 = false;
        boolean zP6 = false;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 2:
                    zP2 = e1.a.P(parcel, iX);
                    break;
                case 3:
                    zP3 = e1.a.P(parcel, iX);
                    break;
                case 4:
                    zP4 = e1.a.P(parcel, iX);
                    break;
                case 5:
                    zP5 = e1.a.P(parcel, iX);
                    break;
                case 6:
                    zP6 = e1.a.P(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new LocationSettingsStates(zP, zP2, zP3, zP4, zP5, zP6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationSettingsStates[] newArray(int i7) {
        return new LocationSettingsStates[i7];
    }
}
