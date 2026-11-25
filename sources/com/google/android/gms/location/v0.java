package com.google.android.gms.location;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface v0 extends IInterface {
    void A2(LocationAvailability locationAvailability) throws RemoteException;

    void o1(LocationResult locationResult) throws RemoteException;
}
