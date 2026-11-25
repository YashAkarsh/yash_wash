package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        boolean zP = false;
        boolean zP2 = false;
        boolean zP3 = false;
        ArrayList arrayListL = null;
        Account account = null;
        String strG = null;
        String strG2 = null;
        ArrayList arrayListL2 = null;
        String strG3 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 2:
                    arrayListL = e1.a.L(parcel, iX, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) e1.a.C(parcel, iX, Account.CREATOR);
                    break;
                case 4:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 5:
                    zP2 = e1.a.P(parcel, iX);
                    break;
                case 6:
                    zP3 = e1.a.P(parcel, iX);
                    break;
                case 7:
                    strG = e1.a.G(parcel, iX);
                    break;
                case 8:
                    strG2 = e1.a.G(parcel, iX);
                    break;
                case 9:
                    arrayListL2 = e1.a.L(parcel, iX, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    strG3 = e1.a.G(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new GoogleSignInOptions(iZ, (ArrayList<Scope>) arrayListL, account, zP, zP2, zP3, strG, strG2, (ArrayList<GoogleSignInOptionsExtensionParcelable>) arrayListL2, strG3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i7) {
        return new GoogleSignInOptions[i7];
    }
}
