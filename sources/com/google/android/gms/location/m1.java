package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m1 implements Parcelable.Creator<SleepClassifyEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SleepClassifyEvent createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        int iZ4 = 0;
        int iZ5 = 0;
        int iZ6 = 0;
        int iZ7 = 0;
        boolean zP = false;
        int iZ8 = 0;
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
                    iZ4 = e1.a.Z(parcel, iX);
                    break;
                case 5:
                    iZ5 = e1.a.Z(parcel, iX);
                    break;
                case 6:
                    iZ6 = e1.a.Z(parcel, iX);
                    break;
                case 7:
                    iZ7 = e1.a.Z(parcel, iX);
                    break;
                case 8:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 9:
                    iZ8 = e1.a.Z(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new SleepClassifyEvent(iZ, iZ2, iZ3, iZ4, iZ5, iZ6, iZ7, zP, iZ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ SleepClassifyEvent[] newArray(int i7) {
        return new SleepClassifyEvent[i7];
    }
}
