package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface h extends IInterface {
    void I() throws RemoteException;

    boolean Y() throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d Z(@c.m0 com.google.android.gms.dynamic.d dVar, @c.m0 com.google.android.gms.dynamic.d dVar2, @c.m0 Bundle bundle) throws RemoteException;

    @c.m0
    g a0() throws RemoteException;

    void g() throws RemoteException;

    void i() throws RemoteException;

    void j() throws RemoteException;

    void k() throws RemoteException;

    void n(@c.m0 Bundle bundle) throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onStart() throws RemoteException;

    void p(@c.m0 Bundle bundle) throws RemoteException;

    void u3(@c.m0 com.google.android.gms.dynamic.d dVar, @Nullable StreetViewPanoramaOptions streetViewPanoramaOptions, @Nullable Bundle bundle) throws RemoteException;

    void w0(f1 f1Var) throws RemoteException;
}
