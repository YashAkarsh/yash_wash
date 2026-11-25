package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class f extends a implements h {
    f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    }

    @Override // com.google.android.gms.internal.maps.h
    public final boolean B() throws RemoteException {
        Parcel parcelI0 = i0(11, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.h
    public final boolean D1(h hVar) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, hVar);
        Parcel parcelI0 = i0(8, parcelU0);
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.h
    public final boolean F0() throws RemoteException {
        Parcel parcelI0 = i0(7, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.h
    public final void L(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(6, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h
    public final void M0(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(4, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h
    public final float a() throws RemoteException {
        Parcel parcelI0 = i0(13, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.h
    public final String b() throws RemoteException {
        Parcel parcelI0 = i0(3, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.h
    public final float c() throws RemoteException {
        Parcel parcelI0 = i0(5, u0());
        float f8 = parcelI0.readFloat();
        parcelI0.recycle();
        return f8;
    }

    @Override // com.google.android.gms.internal.maps.h
    public final int d() throws RemoteException {
        Parcel parcelI0 = i0(9, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.h
    public final void f() throws RemoteException {
        y0(1, u0());
    }

    @Override // com.google.android.gms.internal.maps.h
    public final void g2(boolean z7) throws RemoteException {
        Parcel parcelU0 = u0();
        m.c(parcelU0, z7);
        y0(10, parcelU0);
    }

    @Override // com.google.android.gms.internal.maps.h
    public final void h() throws RemoteException {
        y0(2, u0());
    }

    @Override // com.google.android.gms.internal.maps.h
    public final void v2(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        y0(12, parcelU0);
    }
}
