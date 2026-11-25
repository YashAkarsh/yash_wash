package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class z1 implements Parcelable.Creator<GetServiceRequest> {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, getServiceRequest.f15628a);
        e1.b.F(parcel, 2, getServiceRequest.f15629b);
        e1.b.F(parcel, 3, getServiceRequest.f15630c);
        e1.b.Y(parcel, 4, getServiceRequest.f15631d, false);
        e1.b.B(parcel, 5, getServiceRequest.f15632e, false);
        e1.b.c0(parcel, 6, getServiceRequest.f15633f, i7, false);
        e1.b.k(parcel, 7, getServiceRequest.f15634g, false);
        e1.b.S(parcel, 8, getServiceRequest.f15635h, i7, false);
        e1.b.c0(parcel, 10, getServiceRequest.f15636i, i7, false);
        e1.b.c0(parcel, 11, getServiceRequest.f15637j, i7, false);
        e1.b.g(parcel, 12, getServiceRequest.f15638k);
        e1.b.F(parcel, 13, getServiceRequest.f15639l);
        e1.b.g(parcel, 14, getServiceRequest.f15640m);
        e1.b.Y(parcel, 15, getServiceRequest.Q(), false);
        e1.b.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int iI0 = e1.a.i0(parcel);
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        boolean zP = false;
        int iZ4 = 0;
        boolean zP2 = false;
        String strG = null;
        IBinder iBinderY = null;
        Scope[] scopeArr = null;
        Bundle bundleG = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        String strG2 = null;
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
                    strG = e1.a.G(parcel, iX);
                    break;
                case 5:
                    iBinderY = e1.a.Y(parcel, iX);
                    break;
                case 6:
                    scopeArr = (Scope[]) e1.a.K(parcel, iX, Scope.CREATOR);
                    break;
                case 7:
                    bundleG = e1.a.g(parcel, iX);
                    break;
                case 8:
                    account = (Account) e1.a.C(parcel, iX, Account.CREATOR);
                    break;
                case 9:
                default:
                    e1.a.h0(parcel, iX);
                    break;
                case 10:
                    featureArr = (Feature[]) e1.a.K(parcel, iX, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) e1.a.K(parcel, iX, Feature.CREATOR);
                    break;
                case 12:
                    zP = e1.a.P(parcel, iX);
                    break;
                case 13:
                    iZ4 = e1.a.Z(parcel, iX);
                    break;
                case 14:
                    zP2 = e1.a.P(parcel, iX);
                    break;
                case 15:
                    strG2 = e1.a.G(parcel, iX);
                    break;
            }
        }
        e1.a.N(parcel, iI0);
        return new GetServiceRequest(iZ, iZ2, iZ3, strG, iBinderY, scopeArr, bundleG, account, featureArr, featureArr2, zP, iZ4, zP2, strG2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i7) {
        return new GetServiceRequest[i7];
    }
}
