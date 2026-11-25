package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public interface k extends IInterface {

    public static abstract class a extends com.google.android.gms.internal.base.b implements k {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @c.m0
        public static k u6(@c.m0 IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return iInterfaceQueryLocalInterface instanceof k ? (k) iInterfaceQueryLocalInterface : new c2(iBinder);
        }

        @Override // com.google.android.gms.internal.base.b
        protected final boolean t6(int i7, @c.m0 Parcel parcel, @c.m0 Parcel parcel2, int i8) throws RemoteException {
            if (i7 != 1) {
                return false;
            }
            o2((Status) com.google.android.gms.internal.base.c.a(parcel, Status.CREATOR));
            return true;
        }
    }

    void o2(@c.m0 Status status) throws RemoteException;
}
