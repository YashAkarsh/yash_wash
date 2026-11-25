package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f16128a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16129d;

    protected a(IBinder iBinder, String str) {
        this.f16128a = iBinder;
        this.f16129d = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f16128a;
    }

    protected final Parcel i0() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f16129d);
        return parcelObtain;
    }

    protected final Parcel u0(int i7, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f16128a.transact(i7, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e8) {
                parcelObtain.recycle();
                throw e8;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    protected final void y0(int i7, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f16128a.transact(i7, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
