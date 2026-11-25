package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Parcelable.Creator<zzbe> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbe createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        String strG = null;
        int iZ = 0;
        short sF0 = 0;
        int iZ2 = 0;
        double dT = 0.0d;
        double dT2 = 0.0d;
        float fV = 0.0f;
        long jC0 = 0;
        int iZ3 = -1;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    strG = e1.a.G(parcel, iX);
                    break;
                case 2:
                    jC0 = e1.a.c0(parcel, iX);
                    break;
                case 3:
                    sF0 = e1.a.f0(parcel, iX);
                    break;
                case 4:
                    dT = e1.a.T(parcel, iX);
                    break;
                case 5:
                    dT2 = e1.a.T(parcel, iX);
                    break;
                case 6:
                    fV = e1.a.V(parcel, iX);
                    break;
                case 7:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 8:
                    iZ2 = e1.a.Z(parcel, iX);
                    break;
                case 9:
                    iZ3 = e1.a.Z(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new zzbe(strG, iZ, sF0, dT, dT2, fV, jC0, iZ2, iZ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzbe[] newArray(int i7) {
        return new zzbe[i7];
    }
}
