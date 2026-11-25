package androidx.test.runner.internal.deps.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseStub extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TransactionInterceptor f10479a;

    protected BaseStub(String descriptor) {
        attachInterface(this, descriptor);
    }

    static synchronized void u0(TransactionInterceptor interceptor) {
        try {
            if (interceptor == null) {
                throw new IllegalArgumentException("null interceptor");
            }
            if (f10479a != null) {
                throw new IllegalStateException("Duplicate TransactionInterceptor installation.");
            }
            f10479a = interceptor;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    protected boolean i0(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if (y0(code, data, reply, flags)) {
            return true;
        }
        TransactionInterceptor transactionInterceptor = f10479a;
        return transactionInterceptor == null ? i0(code, data, reply, flags) : transactionInterceptor.a(this, code, data, reply, flags);
    }

    protected boolean y0(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if (code > 16777215) {
            return super.onTransact(code, data, reply, flags);
        }
        data.enforceInterface(getInterfaceDescriptor());
        return false;
    }
}
