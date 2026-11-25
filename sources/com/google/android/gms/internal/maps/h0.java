package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface h0 extends IInterface {
    boolean A() throws RemoteException;

    void C(float f8) throws RemoteException;

    boolean D() throws RemoteException;

    boolean E3(h0 h0Var) throws RemoteException;

    void K2(@Nullable String str) throws RemoteException;

    boolean O0() throws RemoteException;

    void R5(float f8, float f9) throws RemoteException;

    boolean T1() throws RemoteException;

    void T5(LatLng latLng) throws RemoteException;

    float a() throws RemoteException;

    int b() throws RemoteException;

    void b0(com.google.android.gms.dynamic.d dVar) throws RemoteException;

    float c() throws RemoteException;

    float d() throws RemoteException;

    void d0(@Nullable com.google.android.gms.dynamic.d dVar) throws RemoteException;

    void e3(float f8, float f9) throws RemoteException;

    LatLng f() throws RemoteException;

    com.google.android.gms.dynamic.d h() throws RemoteException;

    void h0() throws RemoteException;

    void j0(boolean z7) throws RemoteException;

    String l() throws RemoteException;

    void n0(boolean z7) throws RemoteException;

    void o() throws RemoteException;

    void p4(boolean z7) throws RemoteException;

    void q() throws RemoteException;

    String r() throws RemoteException;

    void r0(float f8) throws RemoteException;

    String s() throws RemoteException;

    void s1(float f8) throws RemoteException;

    void s4(@Nullable String str) throws RemoteException;
}
