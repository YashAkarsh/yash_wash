package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Parcelable.Creator<GeofencingRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GeofencingRequest createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        String strG = "";
        ArrayList arrayListL = null;
        int iZ = 0;
        String strG2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                arrayListL = e1.a.L(parcel, iX, zzbe.CREATOR);
            } else if (iO == 2) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 3) {
                strG = e1.a.G(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                strG2 = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new GeofencingRequest(arrayListL, iZ, strG, strG2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GeofencingRequest[] newArray(int i7) {
        return new GeofencingRequest[i7];
    }
}
