package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;

/* JADX INFO: loaded from: classes.dex */
public final class i1 extends com.google.android.gms.internal.common.a implements k1 {
    i1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.k1
    public final boolean b() throws RemoteException {
        Parcel parcelI0 = i0(7, z3());
        boolean zF = com.google.android.gms.internal.common.n.f(parcelI0);
        parcelI0.recycle();
        return zF;
    }

    @Override // com.google.android.gms.common.internal.k1
    public final boolean m3(zzs zzsVar, com.google.android.gms.dynamic.d dVar) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.c(parcelZ3, zzsVar);
        com.google.android.gms.internal.common.n.e(parcelZ3, dVar);
        Parcel parcelI0 = i0(5, parcelZ3);
        boolean zF = com.google.android.gms.internal.common.n.f(parcelI0);
        parcelI0.recycle();
        return zF;
    }

    @Override // com.google.android.gms.common.internal.k1
    public final zzq w3(zzn zznVar) throws RemoteException {
        Parcel parcelZ3 = z3();
        com.google.android.gms.internal.common.n.c(parcelZ3, zznVar);
        Parcel parcelI0 = i0(6, parcelZ3);
        zzq zzqVar = (zzq) com.google.android.gms.internal.common.n.a(parcelI0, zzq.CREATOR);
        parcelI0.recycle();
        return zzqVar;
    }
}
