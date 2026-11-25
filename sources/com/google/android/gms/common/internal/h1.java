package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class h1 implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f15741a;

    h1(IBinder iBinder) {
        this.f15741a = iBinder;
    }

    @Override // com.google.android.gms.common.internal.p
    public final void K1(o oVar, @c.o0 GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            if (getServiceRequest != null) {
                parcelObtain.writeInt(1);
                z1.a(getServiceRequest, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f15741a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f15741a;
    }
}
