package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface m extends IInterface {

    public static abstract class a extends com.google.android.gms.internal.common.m implements m {
        public a() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        @c.m0
        public static m u0(@c.m0 IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof m ? (m) iInterfaceQueryLocalInterface : new i2(iBinder);
        }

        @Override // com.google.android.gms.internal.common.m
        protected final boolean i0(int i7, @c.m0 Parcel parcel, @c.m0 Parcel parcel2, int i8) throws RemoteException {
            if (i7 != 2) {
                return false;
            }
            Account accountE = e();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.n.d(parcel2, accountE);
            return true;
        }
    }

    @c.m0
    Account e() throws RemoteException;
}
