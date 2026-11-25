package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface e extends IInterface {
    void E(e0 e0Var) throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d H() throws RemoteException;

    void g() throws RemoteException;

    void i() throws RemoteException;

    void j() throws RemoteException;

    void k() throws RemoteException;

    void n(@c.m0 Bundle bundle) throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onStart() throws RemoteException;

    void p(@c.m0 Bundle bundle) throws RemoteException;

    @c.m0
    b v() throws RemoteException;

    void x() throws RemoteException;

    void z(@c.m0 Bundle bundle) throws RemoteException;
}
