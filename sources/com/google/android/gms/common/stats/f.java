package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        int iZ4 = 0;
        boolean zP = false;
        long jC0 = 0;
        long jC1 = 0;
        long jC2 = 0;
        String strG = null;
        ArrayList<String> arrayListI = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        String strG5 = null;
        float fV = 0.0f;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 2:
                    jC0 = e1.a.c0(parcel, iX);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    e1.a.h0(parcel, iX);
                    break;
                case 4:
                    strG = e1.a.G(parcel, iX);
                    break;
                case 5:
                    iZ3 = e1.a.Z(parcel, iX);
                    break;
                case 6:
                    arrayListI = e1.a.I(parcel, iX);
                    break;
                case 8:
                    jC1 = e1.a.c0(parcel, iX);
                    break;
                case 10:
                    strG3 = e1.a.G(parcel, iX);
                    break;
                case 11:
                    iZ2 = e1.a.Z(parcel, iX);
                    break;
                case 12:
                    strG2 = e1.a.G(parcel, iX);
                    break;
                case 13:
                    strG4 = e1.a.G(parcel, iX);
                    break;
                case 14:
                    iZ4 = e1.a.Z(parcel, iX);
                    break;
                case 15:
                    fV = e1.a.V(parcel, iX);
                    break;
                case 16:
                    jC2 = e1.a.c0(parcel, iX);
                    break;
                case 17:
                    strG5 = e1.a.G(parcel, iX);
                    break;
                case 18:
                    zP = e1.a.P(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new WakeLockEvent(iZ, jC0, iZ2, strG, iZ3, arrayListI, strG2, jC1, iZ4, strG3, strG4, fV, jC2, strG5, zP);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i7) {
        return new WakeLockEvent[i7];
    }
}
