package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: loaded from: classes.dex */
public final class j1 extends com.google.android.gms.internal.maps.a implements g {
    j1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
    }

    @Override // com.google.android.gms.maps.internal.g
    public final boolean B1() throws RemoteException {
        Parcel parcelI0 = i0(8, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void C1(LatLng latLng) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLng);
        y0(12, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void C2(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.c(parcelU0, z7);
        y0(1, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void E1(String str) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeString(str);
        y0(11, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void H4(LatLng latLng, int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLng);
        parcelU0.writeInt(i7);
        y0(13, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final com.google.android.gms.dynamic.d I5(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, streetViewPanoramaOrientation);
        Parcel parcelI0 = i0(19, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void J1(LatLng latLng, StreetViewSource streetViewSource) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLng);
        com.google.android.gms.internal.maps.m.d(parcelU0, streetViewSource);
        y0(21, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void K3(x0 x0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, x0Var);
        y0(16, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void N2(b1 b1Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, b1Var);
        y0(17, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final boolean P0() throws RemoteException {
        Parcel parcelI0 = i0(7, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void P4(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.c(parcelU0, z7);
        y0(3, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final StreetViewPanoramaOrientation S4(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        Parcel parcelI0 = i0(18, parcelU0);
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) com.google.android.gms.internal.maps.m.a(parcelI0, StreetViewPanoramaOrientation.CREATOR);
        parcelI0.recycle();
        return streetViewPanoramaOrientation;
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void T2(d1 d1Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, d1Var);
        y0(20, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void U3(StreetViewPanoramaCamera streetViewPanoramaCamera, long j7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, streetViewPanoramaCamera);
        parcelU0.writeLong(j7);
        y0(9, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final boolean V() throws RemoteException {
        Parcel parcelI0 = i0(5, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void g3(LatLng latLng, int i7, StreetViewSource streetViewSource) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLng);
        parcelU0.writeInt(i7);
        com.google.android.gms.internal.maps.m.d(parcelU0, streetViewSource);
        y0(22, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void k6(z0 z0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, z0Var);
        y0(15, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final StreetViewPanoramaCamera m5() throws RemoteException {
        Parcel parcelI0 = i0(10, u0());
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) com.google.android.gms.internal.maps.m.a(parcelI0, StreetViewPanoramaCamera.CREATOR);
        parcelI0.recycle();
        return streetViewPanoramaCamera;
    }

    @Override // com.google.android.gms.maps.internal.g
    public final StreetViewPanoramaLocation n2() throws RemoteException {
        Parcel parcelI0 = i0(14, u0());
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) com.google.android.gms.internal.maps.m.a(parcelI0, StreetViewPanoramaLocation.CREATOR);
        parcelI0.recycle();
        return streetViewPanoramaLocation;
    }

    @Override // com.google.android.gms.maps.internal.g
    public final boolean q6() throws RemoteException {
        Parcel parcelI0 = i0(6, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void u4(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.c(parcelU0, z7);
        y0(4, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.g
    public final void w1(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.c(parcelU0, z7);
        y0(2, parcelU0);
    }
}
