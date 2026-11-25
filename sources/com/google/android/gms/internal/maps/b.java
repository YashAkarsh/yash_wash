package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {
    boolean A() throws RemoteException;

    void B() throws RemoteException;

    void C(float f8) throws RemoteException;

    boolean C0(@Nullable b bVar) throws RemoteException;

    boolean D() throws RemoteException;

    void F(int i7) throws RemoteException;

    void J3(int i7) throws RemoteException;

    void L1(@Nullable List<PatternItem> list) throws RemoteException;

    float a() throws RemoteException;

    int b() throws RemoteException;

    float c() throws RemoteException;

    int d() throws RemoteException;

    int f() throws RemoteException;

    void f1(int i7) throws RemoteException;

    void f5(List list) throws RemoteException;

    void g0(List<LatLng> list) throws RemoteException;

    int h() throws RemoteException;

    void j0(boolean z7) throws RemoteException;

    com.google.android.gms.dynamic.d l() throws RemoteException;

    void n0(boolean z7) throws RemoteException;

    List<LatLng> o() throws RemoteException;

    boolean p0() throws RemoteException;

    List<PatternItem> q() throws RemoteException;

    List r() throws RemoteException;

    String s() throws RemoteException;

    void t0(float f8) throws RemoteException;

    void u(boolean z7) throws RemoteException;

    void y2(com.google.android.gms.dynamic.d dVar) throws RemoteException;
}
