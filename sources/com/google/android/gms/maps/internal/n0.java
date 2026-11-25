package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public final class n0 extends com.google.android.gms.internal.maps.a implements a {
    n0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d A3(float f8, int i7, int i8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        parcelU0.writeInt(i7);
        parcelU0.writeInt(i8);
        Parcel parcelI0 = i0(6, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d B0(LatLngBounds latLngBounds, int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLngBounds);
        parcelU0.writeInt(i7);
        Parcel parcelI0 = i0(10, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d F4(CameraPosition cameraPosition) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, cameraPosition);
        Parcel parcelI0 = i0(7, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d I0(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        Parcel parcelI0 = i0(5, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d L5(LatLng latLng, float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLng);
        parcelU0.writeFloat(f8);
        Parcel parcelI0 = i0(9, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d M2() throws RemoteException {
        Parcel parcelI0 = i0(1, u0());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d N5(float f8, float f9) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        parcelU0.writeFloat(f9);
        Parcel parcelI0 = i0(3, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d e2(LatLng latLng) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLng);
        Parcel parcelI0 = i0(8, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d e5() throws RemoteException {
        Parcel parcelI0 = i0(2, u0());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d o4(LatLngBounds latLngBounds, int i7, int i8, int i9) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLngBounds);
        parcelU0.writeInt(i7);
        parcelU0.writeInt(i8);
        parcelU0.writeInt(i9);
        Parcel parcelI0 = i0(11, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.a
    public final com.google.android.gms.dynamic.d w5(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        Parcel parcelI0 = i0(4, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }
}
