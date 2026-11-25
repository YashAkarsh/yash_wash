package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends com.google.android.gms.internal.base.b implements e {
    public d() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.b
    protected final boolean t6(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        switch (i7) {
            case 3:
                break;
            case 4:
                break;
            case 5:
            default:
                return false;
            case 6:
                break;
            case 7:
                break;
            case 8:
                O1((zak) com.google.android.gms.internal.base.c.a(parcel, zak.CREATOR));
                break;
            case 9:
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
