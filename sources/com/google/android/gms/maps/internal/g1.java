package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* JADX INFO: loaded from: classes.dex */
public final class g1 extends com.google.android.gms.internal.maps.a implements f {
    g1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IProjectionDelegate");
    }

    @Override // com.google.android.gms.maps.internal.f
    public final VisibleRegion a3() throws RemoteException {
        Parcel parcelI0 = i0(3, u0());
        VisibleRegion visibleRegion = (VisibleRegion) com.google.android.gms.internal.maps.m.a(parcelI0, VisibleRegion.CREATOR);
        parcelI0.recycle();
        return visibleRegion;
    }

    @Override // com.google.android.gms.maps.internal.f
    public final com.google.android.gms.dynamic.d k2(LatLng latLng) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.d(parcelU0, latLng);
        Parcel parcelI0 = i0(2, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.maps.internal.f
    public final LatLng p5(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        com.google.android.gms.internal.maps.m.f(parcelU0, dVar);
        Parcel parcelI0 = i0(1, parcelU0);
        LatLng latLng = (LatLng) com.google.android.gms.internal.maps.m.a(parcelI0, LatLng.CREATOR);
        parcelI0.recycle();
        return latLng;
    }
}
