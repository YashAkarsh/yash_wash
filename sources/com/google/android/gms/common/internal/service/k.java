package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends com.google.android.gms.internal.base.b implements l {
    public k() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    @Override // com.google.android.gms.internal.base.b
    protected final boolean t6(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 != 1) {
            return false;
        }
        c3(parcel.readInt());
        return true;
    }
}
