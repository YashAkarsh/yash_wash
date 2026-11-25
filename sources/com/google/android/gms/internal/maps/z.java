package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z extends a implements b0 {
    z(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
    }

    @Override // com.google.android.gms.internal.maps.b0
    public final boolean W0(b0 b0Var) throws RemoteException {
        Parcel parcelU0 = u0();
        m.f(parcelU0, b0Var);
        Parcel parcelI0 = i0(5, parcelU0);
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }

    @Override // com.google.android.gms.internal.maps.b0
    public final int a() throws RemoteException {
        Parcel parcelI0 = i0(1, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.b0
    public final List<IBinder> b() throws RemoteException {
        Parcel parcelI0 = i0(3, u0());
        ArrayList<IBinder> arrayListCreateBinderArrayList = parcelI0.createBinderArrayList();
        parcelI0.recycle();
        return arrayListCreateBinderArrayList;
    }

    @Override // com.google.android.gms.internal.maps.b0
    public final int c() throws RemoteException {
        Parcel parcelI0 = i0(2, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.b0
    public final int d() throws RemoteException {
        Parcel parcelI0 = i0(6, u0());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    @Override // com.google.android.gms.internal.maps.b0
    public final boolean f() throws RemoteException {
        Parcel parcelI0 = i0(4, u0());
        boolean zG = m.g(parcelI0);
        parcelI0.recycle();
        return zG;
    }
}
