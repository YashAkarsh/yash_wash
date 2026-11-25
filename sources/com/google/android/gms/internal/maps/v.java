package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface v extends IInterface {
    void F(int i7) throws RemoteException;

    void G3(float f8) throws RemoteException;

    boolean K() throws RemoteException;

    boolean Q() throws RemoteException;

    void R(com.google.android.gms.dynamic.d dVar) throws RemoteException;

    double a() throws RemoteException;

    int b() throws RemoteException;

    void b2(LatLng latLng) throws RemoteException;

    float c() throws RemoteException;

    float d() throws RemoteException;

    int f() throws RemoteException;

    void g0(@Nullable List<PatternItem> list) throws RemoteException;

    int h() throws RemoteException;

    com.google.android.gms.dynamic.d l() throws RemoteException;

    List<PatternItem> o() throws RemoteException;

    void p2(int i7) throws RemoteException;

    void q() throws RemoteException;

    boolean q3(@Nullable v vVar) throws RemoteException;

    String r() throws RemoteException;

    void r5(boolean z7) throws RemoteException;

    LatLng s() throws RemoteException;

    void t0(float f8) throws RemoteException;

    void u(boolean z7) throws RemoteException;

    void w4(double d8) throws RemoteException;
}
