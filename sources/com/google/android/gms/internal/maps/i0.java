package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends a implements b {
    i0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
    }

    @Override // com.google.android.gms.internal.maps.b
    public final boolean A() throws RemoteException {
        Parcel parcelI0 = i0(18, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void B() throws RemoteException {
        y0(1, u0());
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void C(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(13, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final boolean C0(b bVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, bVar);
        Parcel parcelI0 = i0(19, parcelU0);
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final boolean D() throws RemoteException {
        Parcel parcelI0 = i0(16, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void F(int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        y0(11, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void J3(int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        y0(9, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void L1(List<PatternItem> list) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeTypedList(list);
        y0(25, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final float a() throws RemoteException {
        Parcel parcelI0 = i0(8, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final int b() throws RemoteException {
        Parcel parcelI0 = i0(10, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final float c() throws RemoteException {
        Parcel parcelI0 = i0(14, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final int d() throws RemoteException {
        Parcel parcelI0 = i0(12, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final int f() throws RemoteException {
        Parcel parcelI0 = i0(20, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void f1(int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        y0(23, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void f5(List list) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeList(list);
        y0(5, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void g0(List<LatLng> list) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeTypedList(list);
        y0(3, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final int h() throws RemoteException {
        Parcel parcelI0 = i0(24, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void j0(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(15, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final com.google.android.gms.dynamic.d l() throws RemoteException {
        Parcel parcelI0 = i0(28, u0());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void n0(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(17, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final List<LatLng> o() throws RemoteException {
        Parcel parcelI0 = i0(4, u0());
        ArrayList arrayListCreateTypedArrayList = parcelI0.createTypedArrayList(LatLng.CREATOR);
        parcelI0.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final boolean p0() throws RemoteException {
        Parcel parcelI0 = i0(22, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final List<PatternItem> q() throws RemoteException {
        Parcel parcelI0 = i0(26, u0());
        ArrayList arrayListCreateTypedArrayList = parcelI0.createTypedArrayList(PatternItem.CREATOR);
        parcelI0.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final List r() throws RemoteException {
        Parcel parcelI0 = i0(6, u0());
        ArrayList arrayListB = m.b(parcelI0);
        parcelI0.recycle();
        return arrayListB;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final String s() throws RemoteException {
        Parcel parcelI0 = i0(2, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void t0(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(7, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void u(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(21, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.b
    public final void y2(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, dVar);
        y0(27, parcelU0);
    }
}
