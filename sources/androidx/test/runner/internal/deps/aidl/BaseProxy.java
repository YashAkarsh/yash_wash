package androidx.test.runner.internal.deps.aidl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProxy implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f10477a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10478d;

    protected BaseProxy(IBinder remote, String descriptor) {
        this.f10477a = remote;
        this.f10478d = descriptor;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f10477a;
    }

    protected Parcel i0() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f10478d);
        return parcelObtain;
    }

    protected Parcel u0(int code, Parcel in) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f10477a.transact(code, in, parcelObtain, 0);
                parcelObtain.readException();
                in.recycle();
                return parcelObtain;
            } catch (RuntimeException e8) {
                parcelObtain.recycle();
                throw e8;
            }
        } catch (Throwable th) {
            in.recycle();
            throw th;
        }
    }

    protected void y0(int code, Parcel in) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f10477a.transact(code, in, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            in.recycle();
            parcelObtain.recycle();
        }
    }

    protected void z3(int code, Parcel in) throws RemoteException {
        try {
            this.f10477a.transact(code, in, null, 1);
        } finally {
            in.recycle();
        }
    }
}
