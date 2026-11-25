package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

/* JADX INFO: loaded from: classes.dex */
public final class r1 extends com.google.android.gms.internal.maps.a implements s1 {
    r1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    @Override // com.google.android.gms.maps.internal.s1
    public final e D4(com.google.android.gms.dynamic.d dVar, GoogleMapOptions googleMapOptions) throws RemoteException {
        e y1Var;
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        com.google.android.gms.internal.maps.m.d(parcelU0, googleMapOptions);
        Parcel parcelI0 = i0(3, parcelU0);
        IBinder strongBinder = parcelI0.readStrongBinder();
        if (strongBinder == null) {
            y1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            y1Var = iInterfaceQueryLocalInterface instanceof e ? (e) iInterfaceQueryLocalInterface : new y1(strongBinder);
        }
        parcelI0.recycle();
        return y1Var;
    }

    @Override // com.google.android.gms.maps.internal.s1
    public final d J0(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        d x1Var;
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        Parcel parcelI0 = i0(2, parcelU0);
        IBinder strongBinder = parcelI0.readStrongBinder();
        if (strongBinder == null) {
            x1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            x1Var = iInterfaceQueryLocalInterface instanceof d ? (d) iInterfaceQueryLocalInterface : new x1(strongBinder);
        }
        parcelI0.recycle();
        return x1Var;
    }

    @Override // com.google.android.gms.maps.internal.s1
    public final void Q1(com.google.android.gms.dynamic.d dVar, int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        parcelU0.writeInt(i7);
        y0(10, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.s1
    public final int a() throws RemoteException {
        Parcel parcelI0 = i0(9, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.maps.internal.s1
    public final a c() throws RemoteException {
        a n0Var;
        Parcel parcelI0 = i0(4, u0());
        IBinder strongBinder = parcelI0.readStrongBinder();
        if (strongBinder == null) {
            n0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            n0Var = iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new n0(strongBinder);
        }
        parcelI0.recycle();
        return n0Var;
    }

    @Override // com.google.android.gms.maps.internal.s1
    public final void i1(com.google.android.gms.dynamic.d dVar, int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        parcelU0.writeInt(i7);
        y0(6, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.s1
    public final com.google.android.gms.internal.maps.s l() throws RemoteException {
        Parcel parcelI0 = i0(5, u0());
        com.google.android.gms.internal.maps.s sVarU0 = com.google.android.gms.internal.maps.r.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return sVarU0;
    }

    @Override // com.google.android.gms.maps.internal.s1
    public final h q2(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        h k1Var;
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        Parcel parcelI0 = i0(8, parcelU0);
        IBinder strongBinder = parcelI0.readStrongBinder();
        if (strongBinder == null) {
            k1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
            k1Var = iInterfaceQueryLocalInterface instanceof h ? (h) iInterfaceQueryLocalInterface : new k1(strongBinder);
        }
        parcelI0.recycle();
        return k1Var;
    }

    @Override // com.google.android.gms.maps.internal.s1
    public final i r4(com.google.android.gms.dynamic.d dVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
        i l1Var;
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        com.google.android.gms.internal.maps.m.d(parcelU0, streetViewPanoramaOptions);
        Parcel parcelI0 = i0(7, parcelU0);
        IBinder strongBinder = parcelI0.readStrongBinder();
        if (strongBinder == null) {
            l1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
            l1Var = iInterfaceQueryLocalInterface instanceof i ? (i) iInterfaceQueryLocalInterface : new l1(strongBinder);
        }
        parcelI0.recycle();
        return l1Var;
    }
}
