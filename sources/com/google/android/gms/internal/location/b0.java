package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Parcelable.Creator<zzba> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzba createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        List<ClientIdentity> listL = zzba.f16182l;
        LocationRequest locationRequest = null;
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        boolean zP = false;
        boolean zP2 = false;
        boolean zP3 = false;
        boolean zP4 = false;
        boolean zP5 = false;
        long jC0 = Long.MAX_VALUE;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO != 1) {
                switch (iO) {
                    case 5:
                        listL = e1.a.L(parcel, iX, ClientIdentity.CREATOR);
                        break;
                    case 6:
                        strG = e1.a.G(parcel, iX);
                        break;
                    case 7:
                        zP = e1.a.P(parcel, iX);
                        break;
                    case 8:
                        zP2 = e1.a.P(parcel, iX);
                        break;
                    case 9:
                        zP3 = e1.a.P(parcel, iX);
                        break;
                    case 10:
                        strG2 = e1.a.G(parcel, iX);
                        break;
                    case 11:
                        zP4 = e1.a.P(parcel, iX);
                        break;
                    case 12:
                        zP5 = e1.a.P(parcel, iX);
                        break;
                    case 13:
                        strG3 = e1.a.G(parcel, iX);
                        break;
                    case 14:
                        jC0 = e1.a.c0(parcel, iX);
                        break;
                    default:
                        e1.a.h0(parcel, iX);
                        break;
                }
            } else {
                locationRequest = (LocationRequest) e1.a.C(parcel, iX, LocationRequest.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzba(locationRequest, listL, strG, zP, zP2, zP3, strG2, zP4, zP5, strG3, jC0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzba[] newArray(int i7) {
        return new zzba[i7];
    }
}
