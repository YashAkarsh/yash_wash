package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {
    boolean A() throws RemoteException;

    void B() throws RemoteException;

    void C(float f8) throws RemoteException;

    boolean D() throws RemoteException;

    void F(int i7) throws RemoteException;

    void O2(boolean z7) throws RemoteException;

    void R3(boolean z7) throws RemoteException;

    boolean T4(@Nullable e eVar) throws RemoteException;

    float a() throws RemoteException;

    int b() throws RemoteException;

    void b0(com.google.android.gms.dynamic.d dVar) throws RemoteException;

    float c() throws RemoteException;

    int d() throws RemoteException;

    void e6(@Nullable List<PatternItem> list) throws RemoteException;

    com.google.android.gms.dynamic.d f() throws RemoteException;

    int h() throws RemoteException;

    void h3(Cap cap) throws RemoteException;

    void j3(int i7) throws RemoteException;

    Cap l() throws RemoteException;

    List<PatternItem> o() throws RemoteException;

    boolean p0() throws RemoteException;

    List<LatLng> q() throws RemoteException;

    String r() throws RemoteException;

    Cap s() throws RemoteException;

    void t4(float f8) throws RemoteException;

    void u(boolean z7) throws RemoteException;

    void u5(List<LatLng> list) throws RemoteException;

    void v4(Cap cap) throws RemoteException;
}
