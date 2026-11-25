package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class s extends com.google.android.gms.internal.common.a implements IInterface {
    s(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int c() throws RemoteException {
        Parcel parcelI0 = i0(6, z3());
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    public final int t6(com.google.android.gms.dynamic.d dVar, String str, boolean z7) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar);
        parcelZ3.writeString(str);
        com.google.android.gms.internal.common.n.b(parcelZ3, z7);
        Parcel parcelI0 = i0(3, parcelZ3);
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    public final int u6(com.google.android.gms.dynamic.d dVar, String str, boolean z7) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar);
        parcelZ3.writeString(str);
        com.google.android.gms.internal.common.n.b(parcelZ3, z7);
        Parcel parcelI0 = i0(5, parcelZ3);
        int i7 = parcelI0.readInt();
        parcelI0.recycle();
        return i7;
    }

    public final com.google.android.gms.dynamic.d v6(com.google.android.gms.dynamic.d dVar, String str, int i7) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar);
        parcelZ3.writeString(str);
        parcelZ3.writeInt(i7);
        Parcel parcelI0 = i0(2, parcelZ3);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    public final com.google.android.gms.dynamic.d w6(com.google.android.gms.dynamic.d dVar, String str, int i7, com.google.android.gms.dynamic.d dVar2) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar);
        parcelZ3.writeString(str);
        parcelZ3.writeInt(i7);
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar2);
        Parcel parcelI0 = i0(8, parcelZ3);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    public final com.google.android.gms.dynamic.d x6(com.google.android.gms.dynamic.d dVar, String str, int i7) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar);
        parcelZ3.writeString(str);
        parcelZ3.writeInt(i7);
        Parcel parcelI0 = i0(4, parcelZ3);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }

    public final com.google.android.gms.dynamic.d y6(com.google.android.gms.dynamic.d dVar, String str, boolean z7, long j7) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar);
        parcelZ3.writeString(str);
        com.google.android.gms.internal.common.n.b(parcelZ3, z7);
        parcelZ3.writeLong(j7);
        Parcel parcelI0 = i0(7, parcelZ3);
        com.google.android.gms.dynamic.d dVarU0 = com.google.android.gms.dynamic.d.a.u0(parcelI0.readStrongBinder());
        parcelI0.recycle();
        return dVarU0;
    }
}
