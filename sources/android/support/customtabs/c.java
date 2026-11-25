package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f65a = "android.support.customtabs.IPostMessageService";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f66d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f67e = 3;

        /* JADX INFO: renamed from: android.support.customtabs.c$a$a, reason: collision with other inner class name */
        private static class C0003a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f68a;

            C0003a(IBinder iBinder) {
                this.f68a = iBinder;
            }

            @Override // android.support.customtabs.c
            public void L3(android.support.customtabs.a aVar, String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f65a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f68a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.c
            public void Z2(android.support.customtabs.a aVar, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f65a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f68a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f68a;
            }

            public String i0() {
                return a.f65a;
            }
        }

        public a() {
            attachInterface(this, f65a);
        }

        public static c i0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f65a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0003a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
            if (i7 == 2) {
                parcel.enforceInterface(f65a);
                Z2(android.support.customtabs.a.AbstractBinderC0000a.i0(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i7 != 3) {
                if (i7 != 1598968902) {
                    return super.onTransact(i7, parcel, parcel2, i8);
                }
                parcel2.writeString(f65a);
                return true;
            }
            parcel.enforceInterface(f65a);
            L3(android.support.customtabs.a.AbstractBinderC0000a.i0(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void L3(android.support.customtabs.a aVar, String str, Bundle bundle) throws RemoteException;

    void Z2(android.support.customtabs.a aVar, Bundle bundle) throws RemoteException;
}
