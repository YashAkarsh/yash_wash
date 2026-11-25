package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.core.app.unusedapprestrictions.b
        public void m2(androidx.core.app.unusedapprestrictions.a aVar) throws RemoteException {
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.unusedapprestrictions.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0056b extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f5515a = "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f5516d = 1;

        /* JADX INFO: renamed from: androidx.core.app.unusedapprestrictions.b$b$a */
        private static class a implements b {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static b f5517d;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f5518a;

            a(IBinder iBinder) {
                this.f5518a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5518a;
            }

            public String i0() {
                return AbstractBinderC0056b.f5515a;
            }

            @Override // androidx.core.app.unusedapprestrictions.b
            public void m2(androidx.core.app.unusedapprestrictions.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0056b.f5515a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f5518a.transact(1, parcelObtain, null, 1) || AbstractBinderC0056b.u0() == null) {
                        return;
                    }
                    AbstractBinderC0056b.u0().m2(aVar);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0056b() {
            attachInterface(this, f5515a);
        }

        public static b i0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f5515a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b u0() {
            return a.f5517d;
        }

        public static boolean y0(b bVar) {
            if (a.f5517d != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.f5517d = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
            if (i7 == 1) {
                parcel.enforceInterface(f5515a);
                m2(androidx.core.app.unusedapprestrictions.a.b.i0(parcel.readStrongBinder()));
                return true;
            }
            if (i7 != 1598968902) {
                return super.onTransact(i7, parcel, parcel2, i8);
            }
            parcel2.writeString(f5515a);
            return true;
        }
    }

    void m2(androidx.core.app.unusedapprestrictions.a aVar) throws RemoteException;
}
