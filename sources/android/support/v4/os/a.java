package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.os.a$a, reason: collision with other inner class name */
    public static class C0016a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.os.a
        public void n6(int i7, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f538a = "android.support.v4.os.IResultReceiver";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f539d = 1;

        /* JADX INFO: renamed from: android.support.v4.os.a$b$a, reason: collision with other inner class name */
        private static class C0017a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f540d;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f541a;

            C0017a(IBinder iBinder) {
                this.f541a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f541a;
            }

            public String i0() {
                return b.f538a;
            }

            @Override // android.support.v4.os.a
            public void n6(int i7, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f538a);
                    parcelObtain.writeInt(i7);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f541a.transact(1, parcelObtain, null, 1) || b.u0() == null) {
                        return;
                    }
                    b.u0().n6(i7, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f538a);
        }

        public static a i0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f538a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0017a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a u0() {
            return C0017a.f540d;
        }

        public static boolean y0(a aVar) {
            if (C0017a.f540d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0017a.f540d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
            if (i7 == 1) {
                parcel.enforceInterface(f538a);
                n6(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i7 != 1598968902) {
                return super.onTransact(i7, parcel, parcel2, i8);
            }
            parcel2.writeString(f538a);
            return true;
        }
    }

    void n6(int i7, Bundle bundle) throws RemoteException;
}
