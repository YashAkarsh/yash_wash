package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        Uri uri = null;
        String strG5 = null;
        String strG6 = null;
        ArrayList arrayListL = null;
        String strG7 = null;
        String strG8 = null;
        long jC0 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = e1.a.X(parcel);
            switch (e1.a.O(iX)) {
                case 1:
                    iZ = e1.a.Z(parcel, iX);
                    break;
                case 2:
                    strG = e1.a.G(parcel, iX);
                    break;
                case 3:
                    strG2 = e1.a.G(parcel, iX);
                    break;
                case 4:
                    strG3 = e1.a.G(parcel, iX);
                    break;
                case 5:
                    strG4 = e1.a.G(parcel, iX);
                    break;
                case 6:
                    uri = (Uri) e1.a.C(parcel, iX, Uri.CREATOR);
                    break;
                case 7:
                    strG5 = e1.a.G(parcel, iX);
                    break;
                case 8:
                    jC0 = e1.a.c0(parcel, iX);
                    break;
                case 9:
                    strG6 = e1.a.G(parcel, iX);
                    break;
                case 10:
                    arrayListL = e1.a.L(parcel, iX, Scope.CREATOR);
                    break;
                case 11:
                    strG7 = e1.a.G(parcel, iX);
                    break;
                case 12:
                    strG8 = e1.a.G(parcel, iX);
                    break;
                default:
                    e1.a.h0(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new GoogleSignInAccount(iZ, strG, strG2, strG3, strG4, uri, strG5, jC0, strG6, arrayListL, strG7, strG8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i7) {
        return new GoogleSignInAccount[i7];
    }
}
