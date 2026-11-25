package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: androidx.core.app.unusedapprestrictions.a$a, reason: collision with other inner class name */
    public static class C0054a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.core.app.unusedapprestrictions.a
        public void q5(boolean z7, boolean z8) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f5511a = "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f5512d = 1;

        /* JADX INFO: renamed from: androidx.core.app.unusedapprestrictions.a$b$a, reason: collision with other inner class name */
        private static class C0055a implements a {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static a f5513d;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5514a;

            C0055a(IBinder iBinder) {
                this.f5514a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5514a;
            }

            public String i0() {
                return b.f5511a;
            }

            @Override // androidx.core.app.unusedapprestrictions.a
            public void q5(boolean z7, boolean z8) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f5511a);
                    parcelObtain.writeInt(z7 ? 1 : 0);
                    parcelObtain.writeInt(z8 ? 1 : 0);
                    if (this.f5514a.transact(1, parcelObtain, null, 1) || b.u0() == null) {
                        return;
                    }
                    b.u0().q5(z7, z8);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f5511a);
        }

        public static a i0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f5511a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0055a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a u0() {
            return C0055a.f5513d;
        }

        public static boolean y0(a aVar) {
            if (C0055a.f5513d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0055a.f5513d = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
            if (i7 == 1) {
                parcel.enforceInterface(f5511a);
                q5(parcel.readInt() != 0, parcel.readInt() != 0);
                return true;
            }
            if (i7 != 1598968902) {
                return super.onTransact(i7, parcel, parcel2, i8);
            }
            parcel2.writeString(f5511a);
            return true;
        }
    }

    void q5(boolean z7, boolean z8) throws RemoteException;
}
