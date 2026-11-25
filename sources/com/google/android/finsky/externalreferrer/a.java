package com.google.android.finsky.externalreferrer;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.google.android.finsky.externalreferrer.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0175a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f14939a = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f14940d = 1;

        /* JADX INFO: renamed from: com.google.android.finsky.externalreferrer.a$a$a, reason: collision with other inner class name */
        private static class C0176a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f14941a;

            C0176a(IBinder iBinder) {
                this.f14941a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14941a;
            }

            @Override // com.google.android.finsky.externalreferrer.a
            public Bundle d3(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0175a.f14939a);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f14941a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String i0() {
                return AbstractBinderC0175a.f14939a;
            }
        }

        public AbstractBinderC0175a() {
            attachInterface(this, f14939a);
        }

        public static a i0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f14939a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0176a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
            if (i7 != 1) {
                if (i7 != 1598968902) {
                    return super.onTransact(i7, parcel, parcel2, i8);
                }
                parcel2.writeString(f14939a);
                return true;
            }
            parcel.enforceInterface(f14939a);
            Bundle bundleD3 = d3(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (bundleD3 != null) {
                parcel2.writeInt(1);
                bundleD3.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    Bundle d3(Bundle bundle) throws RemoteException;
}
