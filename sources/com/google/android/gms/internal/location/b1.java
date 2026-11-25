package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.location.zzs;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b1 implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        zzs zzsVar = zzj.f16210e;
        List<ClientIdentity> listL = zzj.f16209d;
        String strG = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                zzsVar = (zzs) e1.a.C(parcel, iX, zzs.CREATOR);
            } else if (iO == 2) {
                listL = e1.a.L(parcel, iX, ClientIdentity.CREATOR);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                strG = e1.a.G(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new zzj(zzsVar, listL, strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzj[] newArray(int i7) {
        return new zzj[i7];
    }
}
