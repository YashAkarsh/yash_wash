package com.google.android.gms.internal.maps;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class q extends a implements s {
    q(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    @Override // com.google.android.gms.internal.maps.s
    public final com.google.android.gms.dynamic.d R4(String str) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeString(str);
        Parcel parcelI0 = i0(2, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.s
    public final com.google.android.gms.dynamic.d U4(int i7) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeInt(i7);
        Parcel parcelI0 = i0(1, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.s
    public final com.google.android.gms.dynamic.d V1(Bitmap bitmap) throws RemoteException {
        Parcel parcelU0 = u0();
        m.d(parcelU0, bitmap);
        Parcel parcelI0 = i0(6, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.s
    public final com.google.android.gms.dynamic.d a() throws RemoteException {
        Parcel parcelI0 = i0(4, u0());
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.s
    public final com.google.android.gms.dynamic.d f6(String str) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeString(str);
        Parcel parcelI0 = i0(7, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.s
    public final com.google.android.gms.dynamic.d k4(String str) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeString(str);
        Parcel parcelI0 = i0(3, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    @Override // com.google.android.gms.internal.maps.s
    public final com.google.android.gms.dynamic.d r1(float f8) throws RemoteException {
        Parcel parcelU0 = u0();
        parcelU0.writeFloat(f8);
        Parcel parcelI0 = i0(5, parcelU0);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }
}
