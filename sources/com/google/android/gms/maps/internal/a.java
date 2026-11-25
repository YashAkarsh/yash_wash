package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    @c.m0
    com.google.android.gms.dynamic.d A3(float f8, int i7, int i8) throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d B0(@c.m0 LatLngBounds latLngBounds, int i7) throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d F4(@c.m0 CameraPosition cameraPosition) throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d I0(float f8) throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d L5(@c.m0 LatLng latLng, float f8) throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d M2() throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d N5(float f8, float f9) throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d e2(@c.m0 LatLng latLng) throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d e5() throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d o4(@c.m0 LatLngBounds latLngBounds, int i7, int i8, int i9) throws RemoteException;

    @c.m0
    com.google.android.gms.dynamic.d w5(float f8) throws RemoteException;
}
