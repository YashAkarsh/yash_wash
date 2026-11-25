package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public interface y extends IInterface {
    boolean K() throws RemoteException;

    void L0(LatLngBounds latLngBounds) throws RemoteException;

    void R(com.google.android.gms.dynamic.d dVar) throws RemoteException;

    void W3(float f8) throws RemoteException;

    void W5(boolean z7) throws RemoteException;

    float a() throws RemoteException;

    void a2(float f8) throws RemoteException;

    void a6(float f8) throws RemoteException;

    float b() throws RemoteException;

    float c() throws RemoteException;

    float d() throws RemoteException;

    void d0(com.google.android.gms.dynamic.d dVar) throws RemoteException;

    void d4(LatLng latLng) throws RemoteException;

    int f() throws RemoteException;

    float h() throws RemoteException;

    boolean h0() throws RemoteException;

    com.google.android.gms.dynamic.d l() throws RemoteException;

    String o() throws RemoteException;

    void q() throws RemoteException;

    LatLngBounds r() throws RemoteException;

    void r0(float f8) throws RemoteException;

    LatLng s() throws RemoteException;

    void u(boolean z7) throws RemoteException;

    boolean x5(y yVar) throws RemoteException;

    void z4(float f8, float f9) throws RemoteException;
}
