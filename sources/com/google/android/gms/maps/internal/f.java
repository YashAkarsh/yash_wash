package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* JADX INFO: loaded from: classes.dex */
public interface f extends IInterface {
    @c.m0
    VisibleRegion a3() throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d k2(@c.m0 LatLng latLng) throws RemoteException;

    @c.m0
    LatLng p5(@c.m0 com.google.android.gms.dynamic.d dVar) throws RemoteException;
}
