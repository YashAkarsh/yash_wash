package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface k extends IInterface {
    void m1(int i7, String[] strArr) throws RemoteException;

    void p6(int i7, String[] strArr) throws RemoteException;

    void t5(int i7, PendingIntent pendingIntent) throws RemoteException;
}
