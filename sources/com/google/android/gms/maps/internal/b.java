package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {
    void A0(boolean z7) throws RemoteException;

    void D3(boolean z7) throws RemoteException;

    void E(e0 e0Var) throws RemoteException;

    float E5() throws RemoteException;

    void F3(float f8) throws RemoteException;

    void F5(@Nullable a2 a2Var) throws RemoteException;

    boolean G2(@Nullable MapStyleOptions mapStyleOptions) throws RemoteException;

    void H5(boolean z7) throws RemoteException;

    void J2(com.google.android.gms.dynamic.d dVar, int i7, @Nullable q1 q1Var) throws RemoteException;

    float K0() throws RemoteException;

    boolean K4() throws RemoteException;

    void M4(@Nullable g0 g0Var) throws RemoteException;

    boolean M5() throws RemoteException;

    void N0(com.google.android.gms.dynamic.d dVar, @Nullable q1 q1Var) throws RemoteException;

    void O3(int i7) throws RemoteException;

    void O4(@Nullable m2 m2Var) throws RemoteException;

    void O5(@Nullable v0 v0Var) throws RemoteException;

    void P2(@Nullable i2 i2Var) throws RemoteException;

    void Q0(@Nullable q qVar) throws RemoteException;

    boolean S1() throws RemoteException;

    void S3(@Nullable k2 k2Var) throws RemoteException;

    void U1(int i7, int i8, int i9, int i10) throws RemoteException;

    void V0(i1 i1Var, @Nullable com.google.android.gms.dynamic.d dVar) throws RemoteException;

    boolean V3() throws RemoteException;

    void X1(@Nullable c cVar) throws RemoteException;

    void X3(@Nullable r0 r0Var) throws RemoteException;

    void Y1(@Nullable p0 p0Var) throws RemoteException;

    void Y4(boolean z7) throws RemoteException;

    com.google.android.gms.internal.maps.h Y5(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    void Z3() throws RemoteException;

    com.google.android.gms.internal.maps.b0 Z5() throws RemoteException;

    void a1(i1 i1Var) throws RemoteException;

    @c.m0
    f b5() throws RemoteException;

    void c2(@Nullable i0 i0Var) throws RemoteException;

    void clear() throws RemoteException;

    void d2(@Nullable t0 t0Var) throws RemoteException;

    void d5(@Nullable m0 m0Var) throws RemoteException;

    com.google.android.gms.internal.maps.h0 d6(MarkerOptions markerOptions) throws RemoteException;

    int e1() throws RemoteException;

    com.google.android.gms.internal.maps.b e4(PolygonOptions polygonOptions) throws RemoteException;

    void f2(@Nullable v1 v1Var) throws RemoteException;

    void g() throws RemoteException;

    boolean h1(boolean z7) throws RemoteException;

    void i() throws RemoteException;

    void i3(@Nullable y yVar) throws RemoteException;

    void j() throws RemoteException;

    void j4(@Nullable u uVar) throws RemoteException;

    @c.m0
    Location j6() throws RemoteException;

    void k() throws RemoteException;

    void l6(@Nullable String str) throws RemoteException;

    void m6(@Nullable a0 a0Var) throws RemoteException;

    void n(@c.m0 Bundle bundle) throws RemoteException;

    void n1(@Nullable s sVar) throws RemoteException;

    com.google.android.gms.internal.maps.y n3(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    void o5(@c.m0 com.google.android.gms.dynamic.d dVar) throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onStart() throws RemoteException;

    void p(@c.m0 Bundle bundle) throws RemoteException;

    boolean p3() throws RemoteException;

    void r2(@Nullable c2 c2Var) throws RemoteException;

    void s2(@c.m0 com.google.android.gms.dynamic.d dVar) throws RemoteException;

    void s3(float f8) throws RemoteException;

    void s5() throws RemoteException;

    void t1(@Nullable e2 e2Var) throws RemoteException;

    @c.m0
    CameraPosition t2() throws RemoteException;

    void t3(@Nullable g2 g2Var) throws RemoteException;

    void u1(@Nullable LatLngBounds latLngBounds) throws RemoteException;

    void v1(@Nullable o oVar) throws RemoteException;

    void x() throws RemoteException;

    @c.m0
    j x4() throws RemoteException;

    void y1(@Nullable k0 k0Var) throws RemoteException;

    com.google.android.gms.internal.maps.e y5(PolylineOptions polylineOptions) throws RemoteException;

    void z(@c.m0 Bundle bundle) throws RemoteException;

    com.google.android.gms.internal.maps.v z1(CircleOptions circleOptions) throws RemoteException;

    void z5(@Nullable c0 c0Var) throws RemoteException;
}
