package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class u0 implements Parcelable.Creator<MethodInvocation> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ MethodInvocation createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        int iZ4 = 0;
        long jC0 = 0;
        long jC1 = 0;
        String strG = null;
        String strG2 = null;
        int iZ5 = -1;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 2:
                    iZ2 = e1.a.Z(parcel, iX);
                    break;
                case 3:
                    iZ3 = e1.a.Z(parcel, iX);
                    break;
                case 4:
                    jC0 = e1.a.c0(parcel, iX);
                    break;
                case 5:
                    jC1 = e1.a.c0(parcel, iX);
                    break;
                case 6:
                    strG = e1.a.G(parcel, iX);
                    break;
                case 7:
                    strG2 = e1.a.G(parcel, iX);
                    break;
                case 8:
                    iZ4 = e1.a.Z(parcel, iX);
                    break;
                case 9:
                    iZ5 = e1.a.Z(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new MethodInvocation(iZ, iZ2, iZ3, jC0, jC1, strG, strG2, iZ4, iZ5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MethodInvocation[] newArray(int i7) {
        return new MethodInvocation[i7];
    }
}
