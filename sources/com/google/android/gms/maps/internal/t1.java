package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class t1 extends com.google.android.gms.internal.maps.a implements b {
    t1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void A0(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.c(parcelU0, z7);
        y0(41, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void D3(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.c(parcelU0, z7);
        y0(18, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void E(e0 e0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, e0Var);
        y0(53, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final float E5() throws RemoteException {
        Parcel parcelI0 = i0(2, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void F3(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(92, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void F5(a2 a2Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, a2Var);
        y0(27, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final boolean G2(MapStyleOptions mapStyleOptions) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, mapStyleOptions);
        Parcel parcelI0 = i0(91, parcelU0);
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void H5(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.c(parcelU0, z7);
        y0(22, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void J2(com.google.android.gms.dynamic.d dVar, int i7, q1 q1Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        parcelU0.writeInt(i7);
        com.google.android.gms.internal.maps.m.f(parcelU0, q1Var);
        y0(7, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final float K0() throws RemoteException {
        Parcel parcelI0 = i0(3, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final boolean K4() throws RemoteException {
        Parcel parcelI0 = i0(40, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void M4(g0 g0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, g0Var);
        y0(30, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final boolean M5() throws RemoteException {
        Parcel parcelI0 = i0(59, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void N0(com.google.android.gms.dynamic.d dVar, q1 q1Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        com.google.android.gms.internal.maps.m.f(parcelU0, q1Var);
        y0(6, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void O3(int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        y0(16, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void O4(m2 m2Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, m2Var);
        y0(83, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void O5(v0 v0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, v0Var);
        y0(87, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void P2(i2 i2Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, i2Var);
        y0(96, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void Q0(q qVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, qVar);
        y0(32, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final boolean S1() throws RemoteException {
        Parcel parcelI0 = i0(21, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void S3(k2 k2Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, k2Var);
        y0(89, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void U1(int i7, int i8, int i9, int i10) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        parcelU0.writeInt(i8);
        parcelU0.writeInt(i9);
        parcelU0.writeInt(i10);
        y0(39, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void V0(i1 i1Var, com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, i1Var);
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        y0(38, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final boolean V3() throws RemoteException {
        Parcel parcelI0 = i0(19, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void X1(c cVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, cVar);
        y0(24, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void X3(r0 r0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, r0Var);
        y0(80, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void Y1(p0 p0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, p0Var);
        y0(Constants.OTP_FILLER_WEB_SUCCESS, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void Y4(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.c(parcelU0, z7);
        y0(51, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final com.google.android.gms.internal.maps.h Y5(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, tileOverlayOptions);
        Parcel parcelI0 = i0(13, parcelU0);
        com.google.android.gms.internal.maps.h hVarU0 = com.google.android.gms.internal.maps.g.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return hVarU0;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void Z3() throws RemoteException {
        y0(94, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final com.google.android.gms.internal.maps.b0 Z5() throws RemoteException {
        Parcel parcelI0 = i0(44, u0());
        com.google.android.gms.internal.maps.b0 b0VarU0 = com.google.android.gms.internal.maps.a0.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return b0VarU0;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void a1(i1 i1Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, i1Var);
        y0(71, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final f b5() throws RemoteException {
        f g1Var;
        Parcel parcelI0 = i0(26, u0());
        IBinder strongBinder = parcelI0.readStrongBinder();
        if (strongBinder == null) {
            g1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            g1Var = iInterfaceQueryLocalInterface instanceof f ? (f) iInterfaceQueryLocalInterface : new g1(strongBinder);
        }
        parcelI0.recycle();
        return g1Var;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void c2(i0 i0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, i0Var);
        y0(31, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void clear() throws RemoteException {
        y0(14, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void d2(t0 t0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, t0Var);
        y0(85, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void d5(m0 m0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, m0Var);
        y0(36, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final com.google.android.gms.internal.maps.h0 d6(MarkerOptions markerOptions) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, markerOptions);
        Parcel parcelI0 = i0(11, parcelU0);
        com.google.android.gms.internal.maps.h0 h0VarU0 = com.google.android.gms.internal.maps.g0.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return h0VarU0;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final int e1() throws RemoteException {
        Parcel parcelI0 = i0(15, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final com.google.android.gms.internal.maps.b e4(PolygonOptions polygonOptions) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, polygonOptions);
        Parcel parcelI0 = i0(10, parcelU0);
        com.google.android.gms.internal.maps.b bVarU0 = com.google.android.gms.internal.maps.j0.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return bVarU0;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void f2(v1 v1Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, v1Var);
        y0(33, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void g() throws RemoteException {
        y0(102, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final boolean h1(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.c(parcelU0, z7);
        Parcel parcelI0 = i0(20, parcelU0);
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void i() throws RemoteException {
        y0(55, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void i3(y yVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, yVar);
        y0(28, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void j() throws RemoteException {
        y0(56, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void j4(u uVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, uVar);
        y0(84, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final Location j6() throws RemoteException {
        Parcel parcelI0 = i0(23, u0());
        Location location = (Location) com.google.android.gms.internal.maps.m.a(parcelI0, Location.CREATOR);
        parcelI0.recycle();
        return location;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void k() throws RemoteException {
        y0(57, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void l6(String str) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeString(str);
        y0(61, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void m6(a0 a0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, a0Var);
        y0(42, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void n(Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        Parcel parcelI0 = i0(60, parcelU0);
        if (parcelI0.readInt() != 0) {
            bundle.readFromParcel(parcelI0);
        }
        parcelI0.recycle();
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void n1(s sVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, sVar);
        y0(86, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final com.google.android.gms.internal.maps.y n3(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, groundOverlayOptions);
        Parcel parcelI0 = i0(12, parcelU0);
        com.google.android.gms.internal.maps.y yVarU0 = com.google.android.gms.internal.maps.x.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return yVarU0;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void o5(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        y0(5, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void onLowMemory() throws RemoteException {
        y0(58, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void onStart() throws RemoteException {
        y0(101, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void p(Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        y0(54, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final boolean p3() throws RemoteException {
        Parcel parcelI0 = i0(17, u0());
        boolean zG = com.google.android.gms.internal.maps.m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void r2(c2 c2Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, c2Var);
        y0(99, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void s2(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        y0(4, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void s3(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(93, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void s5() throws RemoteException {
        y0(8, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void t1(e2 e2Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, e2Var);
        y0(98, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final CameraPosition t2() throws RemoteException {
        Parcel parcelI0 = i0(1, u0());
        CameraPosition cameraPosition = (CameraPosition) com.google.android.gms.internal.maps.m.a(parcelI0, CameraPosition.CREATOR);
        parcelI0.recycle();
        return cameraPosition;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void t3(g2 g2Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, g2Var);
        y0(97, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void u1(LatLngBounds latLngBounds) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLngBounds);
        y0(95, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void v1(o oVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, oVar);
        y0(45, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void x() throws RemoteException {
        y0(82, u0());
    }

    @Override // com.google.android.gms.maps.internal.b
    public final j x4() throws RemoteException {
        j m1Var;
        Parcel parcelI0 = i0(25, u0());
        IBinder strongBinder = parcelI0.readStrongBinder();
        if (strongBinder == null) {
            m1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            m1Var = iInterfaceQueryLocalInterface instanceof j ? (j) iInterfaceQueryLocalInterface : new m1(strongBinder);
        }
        parcelI0.recycle();
        return m1Var;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void y1(k0 k0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, k0Var);
        y0(37, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final com.google.android.gms.internal.maps.e y5(PolylineOptions polylineOptions) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, polylineOptions);
        Parcel parcelI0 = i0(9, parcelU0);
        com.google.android.gms.internal.maps.e eVarU0 = com.google.android.gms.internal.maps.d.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return eVarU0;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void z(Bundle bundle) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, bundle);
        y0(81, parcelU0);
    }

    @Override // com.google.android.gms.maps.internal.b
    public final com.google.android.gms.internal.maps.v z1(CircleOptions circleOptions) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, circleOptions);
        Parcel parcelI0 = i0(35, parcelU0);
        com.google.android.gms.internal.maps.v vVarU0 = com.google.android.gms.internal.maps.u.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return vVarU0;
    }

    @Override // com.google.android.gms.maps.internal.b
    public final void z5(c0 c0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, c0Var);
        y0(29, parcelU0);
    }
}
