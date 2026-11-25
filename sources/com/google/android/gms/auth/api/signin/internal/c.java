package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GoogleSignInOptionsExtensionParcelable createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        Bundle bundleG = null;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO != 3) {
                e1.a.h0(parcel, iX);
            } else {
                bundleG = e1.a.g(parcel, iX);
            }
        }
        e1.a.N(parcel, iI0);
        return new GoogleSignInOptionsExtensionParcelable(iZ, iZ2, bundleG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptionsExtensionParcelable[] newArray(int i7) {
        return new GoogleSignInOptionsExtensionParcelable[i7];
    }
}
