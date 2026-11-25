package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f16064a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16065d;

    protected a(IBinder iBinder, String str) {
        this.f16064a = iBinder;
        this.f16065d = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f16064a;
    }

    protected final Parcel i0() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f16065d);
        return parcelObtain;
    }

    protected final Parcel u0(int i7, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f16064a.transact(2, parcel, parcelObtain, 0);
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
            this.f16064a.transact(i7, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    protected final void z3(int i7, Parcel parcel) throws RemoteException {
        try {
            this.f16064a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
