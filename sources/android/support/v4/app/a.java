package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.app.a$a, reason: collision with other inner class name */
    public static class C0004a implements a {
        @Override // android.support.v4.app.a
        public void U5(String str, int i7, String str2, Notification notification) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.a
        public void h2(String str) throws RemoteException {
        }

        @Override // android.support.v4.app.a
        public void i4(String str, int i7, String str2) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f69a = "android.support.v4.app.INotificationSideChannel";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f70d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f71e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f72f = 3;

        /* JADX INFO: renamed from: android.support.v4.app.a$b$a, reason: collision with other inner class name */
        private static class C0005a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f73d;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f74a;

            C0005a(IBinder iBinder) {
                this.f74a = iBinder;
            }

            @Override // android.support.v4.app.a
            public void U5(String str, int i7, String str2, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f69a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i7);
                    parcelObtain.writeString(str2);
                    if (notification != null) {
                        parcelObtain.writeInt(1);
                        notification.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f74a.transact(1, parcelObtain, null, 1) || b.u0() == null) {
                        return;
                    }
                    b.u0().U5(str, i7, str2, notification);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f74a;
            }

            @Override // android.support.v4.app.a
            public void h2(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f69a);
                    parcelObtain.writeString(str);
                    if (this.f74a.transact(3, parcelObtain, null, 1) || b.u0() == null) {
                        return;
                    }
                    b.u0().h2(str);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String i0() {
                return b.f69a;
            }

            @Override // android.support.v4.app.a
            public void i4(String str, int i7, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f69a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i7);
                    parcelObtain.writeString(str2);
                    if (this.f74a.transact(2, parcelObtain, null, 1) || b.u0() == null) {
                        return;
                    }
                    b.u0().i4(str, i7, str2);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f69a);
        }

        public static a i0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f69a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0005a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a u0() {
            return C0005a.f73d;
        }

        public static boolean y0(a aVar) {
            if (C0005a.f73d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0005a.f73d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
            if (i7 == 1) {
                parcel.enforceInterface(f69a);
                U5(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i7 == 2) {
                parcel.enforceInterface(f69a);
                i4(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            }
            if (i7 == 3) {
                parcel.enforceInterface(f69a);
                h2(parcel.readString());
                return true;
            }
            if (i7 != 1598968902) {
                return super.onTransact(i7, parcel, parcel2, i8);
            }
            parcel2.writeString(f69a);
            return true;
        }
    }

    void U5(String str, int i7, String str2, Notification notification) throws RemoteException;

    void h2(String str) throws RemoteException;

    void i4(String str, int i7, String str2) throws RemoteException;
}
