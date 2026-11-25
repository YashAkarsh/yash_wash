package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface i extends IInterface {
    @c.m0
    com.google.android.gms.dynamic.d H() throws RemoteException;

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

    void w0(f1 f1Var) throws RemoteException;
}
