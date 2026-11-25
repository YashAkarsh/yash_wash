package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends a implements h0 {
    f0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final boolean A() throws RemoteException {
        Parcel parcelI0 = i0(10, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void C(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(27, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final boolean D() throws RemoteException {
        Parcel parcelI0 = i0(21, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final boolean E3(h0 h0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, h0Var);
        Parcel parcelI0 = i0(16, parcelU0);
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void K2(String str) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeString(str);
        y0(7, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final boolean O0() throws RemoteException {
        Parcel parcelI0 = i0(13, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void R5(float f8, float f9) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        parcelU0.writeFloat(f9);
        y0(19, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final boolean T1() throws RemoteException {
        Parcel parcelI0 = i0(15, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void T5(LatLng latLng) throws RemoteException {
        Parcel parcelU0 = u0();
        m.d(parcelU0, latLng);
        y0(3, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final float a() throws RemoteException {
        Parcel parcelI0 = i0(26, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final int b() throws RemoteException {
        Parcel parcelI0 = i0(17, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void b0(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, dVar);
        y0(29, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final float c() throws RemoteException {
        Parcel parcelI0 = i0(23, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final float d() throws RemoteException {
        Parcel parcelI0 = i0(28, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void d0(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, dVar);
        y0(18, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void e3(float f8, float f9) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        parcelU0.writeFloat(f9);
        y0(24, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final LatLng f() throws RemoteException {
        Parcel parcelI0 = i0(4, u0());
        LatLng latLng = (LatLng) m.a(parcelI0, LatLng.CREATOR);
        parcelI0.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final com.google.android.gms.dynamic.d h() throws RemoteException {
        Parcel parcelI0 = i0(30, u0());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void h0() throws RemoteException {
        y0(11, u0());
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void j0(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(14, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final String l() throws RemoteException {
        Parcel parcelI0 = i0(2, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void n0(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(20, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void o() throws RemoteException {
        y0(12, u0());
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void p4(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(9, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void q() throws RemoteException {
        y0(1, u0());
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final String r() throws RemoteException {
        Parcel parcelI0 = i0(6, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void r0(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(25, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final String s() throws RemoteException {
        Parcel parcelI0 = i0(8, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void s1(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(22, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h0
    public final void s4(String str) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeString(str);
        y0(5, parcelU0);
    }
}
