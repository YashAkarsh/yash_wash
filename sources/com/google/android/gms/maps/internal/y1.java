package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class y1 extends com.google.android.gms.internal.maps.a implements e {
    y1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapViewDelegate");
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void E(e0 e0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, e0Var);
        y0(9, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.e
    public final com.google.android.gms.dynamic.d H() throws RemoteException {
        Parcel parcelI0 = i0(8, u0());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void g() throws RemoteException {
        y0(13, u0());
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void i() throws RemoteException {
        y0(3, u0());
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void j() throws RemoteException {
        y0(4, u0());
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void k() throws RemoteException {
        y0(5, u0());
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void n(Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        Parcel parcelI0 = i0(7, parcelU0);
        if (parcelI0.readInt() != 0) {
            bundle.readFromParcel(parcelI0);
        }
        parcelI0.recycle();
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void onLowMemory() throws RemoteException {
        y0(6, u0());
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void onStart() throws RemoteException {
        y0(12, u0());
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void p(Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        y0(2, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.e
    public final b v() throws RemoteException {
        b t1Var;
        Parcel parcelI0 = i0(1, u0());
        IBinder strongBinder = parcelI0.readStrongBinder();
        if (strongBinder == null) {
            t1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            t1Var = iInterfaceQueryLocalInterface instanceof b ? (b) iInterfaceQueryLocalInterface : new t1(strongBinder);
        }
        parcelI0.recycle();
        return t1Var;
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void x() throws RemoteException {
        y0(11, u0());
    }

    @Override // com.google.android.gms.maps.internal.e
    public final void z(Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        y0(10, parcelU0);
    }
}
