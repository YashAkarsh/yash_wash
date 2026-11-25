package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface s1 extends IInterface {
    e D4(com.google.android.gms.dynamic.d dVar, @Nullable GoogleMapOptions googleMapOptions) throws RemoteException;

    d J0(com.google.android.gms.dynamic.d dVar) throws RemoteException;

    void Q1(com.google.android.gms.dynamic.d dVar, int i7) throws RemoteException;

    int a() throws RemoteException;

    a c() throws RemoteException;

    void i1(com.google.android.gms.dynamic.d dVar, int i7) throws RemoteException;

    com.google.android.gms.internal.maps.s l() throws RemoteException;

    h q2(com.google.android.gms.dynamic.d dVar) throws RemoteException;

    i r4(com.google.android.gms.dynamic.d dVar, @Nullable StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;
}
