package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class a1 implements Parcelable.Creator<zat> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zat createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int iZ2 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            int iO = e1.a.O(iX);
            if (iO == 1) {
                iZ = e1.a.Z(parcel, iX);
            } else if (iO == 2) {
                account = (Account) e1.a.C(parcel, iX, Account.CREATOR);
            } else if (iO == 3) {
                iZ2 = e1.a.Z(parcel, iX);
            } else if (iO != 4) {
                e1.a.h0(parcel, iX);
            } else {
                googleSignInAccount = (GoogleSignInAccount) e1.a.C(parcel, iX, GoogleSignInAccount.CREATOR);
            }
        }
        e1.a.N(parcel, iI0);
        return new zat(iZ, account, iZ2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zat[] newArray(int i7) {
        return new zat[i7];
    }
}
