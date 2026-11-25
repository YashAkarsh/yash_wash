package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class t extends a implements v {
    t(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void F(int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        y0(11, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void G3(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(7, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.v
    public final boolean K() throws RemoteException {
        Parcel parcelI0 = i0(16, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final boolean Q() throws RemoteException {
        Parcel parcelI0 = i0(20, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void R(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, dVar);
        y0(23, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.v
    public final double a() throws RemoteException {
        Parcel parcelI0 = i0(6, u0());
        double d8 = parcelI0.readDouble();
        parcelI0.recycle();
        return d8;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final int b() throws RemoteException {
        Parcel parcelI0 = i0(12, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void b2(LatLng latLng) throws RemoteException {
        Parcel parcelU0 = u0();
        m.d(parcelU0, latLng);
        y0(3, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.v
    public final float c() throws RemoteException {
        Parcel parcelI0 = i0(8, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final float d() throws RemoteException {
        Parcel parcelI0 = i0(14, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final int f() throws RemoteException {
        Parcel parcelI0 = i0(18, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void g0(List<PatternItem> list) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeTypedList(list);
        y0(21, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.v
    public final int h() throws RemoteException {
        Parcel parcelI0 = i0(10, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final com.google.android.gms.dynamic.d l() throws RemoteException {
        Parcel parcelI0 = i0(24, u0());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final List<PatternItem> o() throws RemoteException {
        Parcel parcelI0 = i0(22, u0());
        ArrayList arrayListCreateTypedArrayList = parcelI0.createTypedArrayList(PatternItem.CREATOR);
        parcelI0.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void p2(int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        y0(9, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void q() throws RemoteException {
        y0(1, u0());
    }

    @Override // com.google.android.gms.internal.maps.v
    public final boolean q3(v vVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, vVar);
        Parcel parcelI0 = i0(17, parcelU0);
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final String r() throws RemoteException {
        Parcel parcelI0 = i0(2, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void r5(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(15, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.v
    public final LatLng s() throws RemoteException {
        Parcel parcelI0 = i0(4, u0());
        LatLng latLng = (LatLng) m.a(parcelI0, LatLng.CREATOR);
        parcelI0.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void t0(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(13, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void u(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(19, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.v
    public final void w4(double d8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeDouble(d8);
        y0(5, parcelU0);
    }
}
