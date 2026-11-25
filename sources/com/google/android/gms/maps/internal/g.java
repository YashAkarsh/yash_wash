package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface g extends IInterface {
    boolean B1() throws RemoteException;

    void C1(@c.m0 LatLng latLng) throws RemoteException;

    void C2(boolean z7) throws RemoteException;

    void E1(@c.m0 String str) throws RemoteException;

    void H4(@c.m0 LatLng latLng, int i7) throws RemoteException;

    @c.o0
    com.google.android.gms.dynamic.d I5(@c.m0 StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    void J1(@c.m0 LatLng latLng, @Nullable StreetViewSource streetViewSource) throws RemoteException;

    void K3(@Nullable x0 x0Var) throws RemoteException;

    void N2(@Nullable b1 b1Var) throws RemoteException;

    boolean P0() throws RemoteException;

    void P4(boolean z7) throws RemoteException;

    @c.m0
    StreetViewPanoramaOrientation S4(@c.m0 com.google.android.gms.dynamic.d dVar) throws RemoteException;

    void T2(@Nullable d1 d1Var) throws RemoteException;

    void U3(@c.m0 StreetViewPanoramaCamera streetViewPanoramaCamera, long j7) throws RemoteException;

    boolean V() throws RemoteException;

    void g3(@c.m0 LatLng latLng, int i7, @Nullable StreetViewSource streetViewSource) throws RemoteException;

    void k6(@Nullable z0 z0Var) throws RemoteException;

    @c.m0
    StreetViewPanoramaCamera m5() throws RemoteException;

    @c.m0
    StreetViewPanoramaLocation n2() throws RemoteException;

    boolean q6() throws RemoteException;

    void u4(boolean z7) throws RemoteException;

    void w1(boolean z7) throws RemoteException;
}
