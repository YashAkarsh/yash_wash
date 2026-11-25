package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* JADX INFO: loaded from: classes.dex */
public final class k1 extends com.google.android.gms.internal.maps.a implements h {
    k1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void I() throws RemoteException {
        y0(7, u0());
    }

    @Override // com.google.android.gms.maps.internal.h
    public final boolean Y() throws RemoteException {
        Parcel parcelI0 = i0(11, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.h
    public final com.google.android.gms.dynamic.d Z(com.google.android.gms.dynamic.d dVar, com.google.android.gms.dynamic.d dVar2, Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar2);
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        Parcel parcelI0 = i0(4, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.h
    public final g a0() throws RemoteException {
        g j1Var;
        Parcel parcelI0 = i0(1, u0());
        IBinder strongBinder = parcelI0.readStrongBinder();
        if (strongBinder == null) {
            j1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            j1Var = iInterfaceQueryLocalInterface instanceof g ? (g) iInterfaceQueryLocalInterface : new j1(strongBinder);
        }
        parcelI0.recycle();
        return j1Var;
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void g() throws RemoteException {
        y0(14, u0());
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void i() throws RemoteException {
        y0(5, u0());
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void j() throws RemoteException {
        y0(6, u0());
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void k() throws RemoteException {
        y0(8, u0());
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void n(Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        Parcel parcelI0 = i0(10, parcelU0);
        if (parcelI0.readInt() != 0) {
            bundle.readFromParcel(parcelI0);
        }
        parcelI0.recycle();
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void onLowMemory() throws RemoteException {
        y0(9, u0());
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void onStart() throws RemoteException {
        y0(13, u0());
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void p(Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        y0(3, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void u3(com.google.android.gms.dynamic.d dVar, StreetViewPanoramaOptions streetViewPanoramaOptions, Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        com.google.android.gms.internal.maps.m.d(parcelU0, streetViewPanoramaOptions);
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        y0(2, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.h
    public final void w0(f1 f1Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, f1Var);
        y0(12, parcelU0);
    }
}
