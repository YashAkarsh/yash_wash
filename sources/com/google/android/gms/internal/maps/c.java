package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a implements e {
    c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
    }

    @Override // com.google.android.gms.internal.maps.e
    public final boolean A() throws RemoteException {
        Parcel parcelI0 = i0(14, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void B() throws RemoteException {
        y0(1, u0());
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void C(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(9, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final boolean D() throws RemoteException {
        Parcel parcelI0 = i0(12, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void F(int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        y0(7, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void O2(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(13, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void R3(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(11, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final boolean T4(e eVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, eVar);
        Parcel parcelI0 = i0(15, parcelU0);
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final float a() throws RemoteException {
        Parcel parcelI0 = i0(6, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final int b() throws RemoteException {
        Parcel parcelI0 = i0(24, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void b0(com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, dVar);
        y0(27, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final float c() throws RemoteException {
        Parcel parcelI0 = i0(10, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final int d() throws RemoteException {
        Parcel parcelI0 = i0(8, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void e6(List<PatternItem> list) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeTypedList(list);
        y0(25, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final com.google.android.gms.dynamic.d f() throws RemoteException {
        Parcel parcelI0 = i0(28, u0());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final int h() throws RemoteException {
        Parcel parcelI0 = i0(16, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void h3(Cap cap) throws RemoteException {
        Parcel parcelU0 = u0();
        m.d(parcelU0, cap);
        y0(21, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void j3(int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        y0(23, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final Cap l() throws RemoteException {
        Parcel parcelI0 = i0(22, u0());
        Cap cap = (Cap) m.a(parcelI0, Cap.CREATOR);
        parcelI0.recycle();
        return cap;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final List<PatternItem> o() throws RemoteException {
        Parcel parcelI0 = i0(26, u0());
        ArrayList arrayListCreateTypedArrayList = parcelI0.createTypedArrayList(PatternItem.CREATOR);
        parcelI0.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final boolean p0() throws RemoteException {
        Parcel parcelI0 = i0(18, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final List<LatLng> q() throws RemoteException {
        Parcel parcelI0 = i0(4, u0());
        ArrayList arrayListCreateTypedArrayList = parcelI0.createTypedArrayList(LatLng.CREATOR);
        parcelI0.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final String r() throws RemoteException {
        Parcel parcelI0 = i0(2, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final Cap s() throws RemoteException {
        Parcel parcelI0 = i0(20, u0());
        Cap cap = (Cap) m.a(parcelI0, Cap.CREATOR);
        parcelI0.recycle();
        return cap;
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void t4(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(5, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void u(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(17, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void u5(List<LatLng> list) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeTypedList(list);
        y0(3, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.e
    public final void v4(Cap cap) throws RemoteException {
        Parcel parcelU0 = u0();
        m.d(parcelU0, cap);
        y0(19, parcelU0);
    }
}
