package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends a implements e0 {
    c0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    }

    @Override // com.google.android.gms.internal.maps.e0
    public final boolean I3(e0 e0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, e0Var);
        Parcel parcelI0 = i0(4, parcelU0);
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.e0
    public final int a() throws RemoteException {
        Parcel parcelI0 = i0(5, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.e0
    public final void b() throws RemoteException {
        y0(3, u0());
    }

    @Override // com.google.android.gms.internal.maps.e0
    public final String c() throws RemoteException {
        Parcel parcelI0 = i0(1, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.maps.e0
    public final String d() throws RemoteException {
        Parcel parcelI0 = i0(2, u0());
        String string = parcelI0.readString();
        parcelI0.recycle();
        return string;
    }
}
