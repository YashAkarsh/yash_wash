package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public final class w extends a implements y {
    w(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    }

    @Override // com.google.android.gms.internal.maps.y
    public final boolean K() throws RemoteException {
        Parcel parcelI0 = i0(23, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void L0(LatLngBounds latLngBounds) throws RemoteException {
        Parcel parcelU0 = u0();
        m.d(parcelU0, latLngBounds);
        y0(9, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void R(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, dVar);
        y0(24, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void W3(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(5, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void W5(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(15, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final float a() throws RemoteException {
        Parcel parcelI0 = i0(12, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void a2(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(17, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void a6(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(13, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final float b() throws RemoteException {
        Parcel parcelI0 = i0(7, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final float c() throws RemoteException {
        Parcel parcelI0 = i0(8, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final float d() throws RemoteException {
        Parcel parcelI0 = i0(18, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void d0(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, dVar);
        y0(21, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void d4(LatLng latLng) throws RemoteException {
        Parcel parcelU0 = u0();
        m.d(parcelU0, latLng);
        y0(3, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final int f() throws RemoteException {
        Parcel parcelI0 = i0(20, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final float h() throws RemoteException {
        Parcel parcelI0 = i0(14, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final boolean h0() throws RemoteException {
        Parcel parcelI0 = i0(16, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final com.google.android.gms.dynamic.d l() throws RemoteException {
        Parcel parcelI0 = i0(25, u0());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final String o() throws RemoteException {
        Parcel parcelI0 = i0(2, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void q() throws RemoteException {
        y0(1, u0());
    }

    @Override // com.google.android.gms.internal.maps.y
    public final LatLngBounds r() throws RemoteException {
        Parcel parcelI0 = i0(10, u0());
        LatLngBounds latLngBounds = (LatLngBounds) m.a(parcelI0, LatLngBounds.CREATOR);
        parcelI0.recycle();
        return latLngBounds;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void r0(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(11, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final LatLng s() throws RemoteException {
        Parcel parcelI0 = i0(4, u0());
        LatLng latLng = (LatLng) m.a(parcelI0, LatLng.CREATOR);
        parcelI0.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void u(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(22, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.y
    public final boolean x5(y yVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, yVar);
        Parcel parcelI0 = i0(19, parcelU0);
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.y
    public final void z4(float f8, float f9) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        parcelU0.writeFloat(f9);
        y0(6, parcelU0);
    }
}
