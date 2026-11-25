package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class i2 extends com.google.android.gms.internal.common.a implements m {
    i2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.m
    public final Account e() throws RemoteException {
        Parcel parcelI0 = i0(2, z3());
        Account account = (Account) com.google.android.gms.internal.common.n.a(parcelI0, Account.CREATOR);
        parcelI0.recycle();
        return account;
    }
}
