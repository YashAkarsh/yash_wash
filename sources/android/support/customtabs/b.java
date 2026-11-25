package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f55a = "android.support.customtabs.ICustomTabsService";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f56d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f57e = 3;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f58f = 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f59g = 5;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f60h = 6;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f61i = 7;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f62j = 8;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final int f63k = 9;

        /* JADX INFO: renamed from: android.support.customtabs.b$a$a, reason: collision with other inner class name */
        private static class C0002a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f64a;

            C0002a(IBinder iBinder) {
                this.f64a = iBinder;
            }

            @Override // android.support.customtabs.b
            public Bundle B2(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f55a);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f64a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.b
            public boolean Z4(android.support.customtabs.a aVar, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f55a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f64a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f64a;
            }

            @Override // android.support.customtabs.b
            public boolean c1(android.support.customtabs.a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f55a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeTypedList(list);
                    this.f64a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String i0() {
                return a.f55a;
            }

            @Override // android.support.customtabs.b
            public boolean l1(android.support.customtabs.a aVar, int i7, Uri uri, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f55a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    parcelObtain.writeInt(i7);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f64a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.b
            public int l4(android.support.customtabs.a aVar, String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f55a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f64a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.b
            public boolean n5(android.support.customtabs.a aVar, Uri uri) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f55a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f64a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.b
            public boolean o3(long j7) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f55a);
                    parcelObtain.writeLong(j7);
                    this.f64a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.b
            public boolean y4(android.support.customtabs.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f55a);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f64a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f55a);
        }

        public static b i0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f55a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0002a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
            if (i7 == 1598968902) {
                parcel2.writeString(f55a);
                return true;
            }
            switch (i7) {
                case 2:
                    parcel.enforceInterface(f55a);
                    boolean zO3 = o3(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zO3 ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(f55a);
                    boolean zY4 = y4(android.support.customtabs.a.AbstractBinderC0000a.i0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zY4 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f55a);
                    boolean zC1 = c1(android.support.customtabs.a.AbstractBinderC0000a.i0(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.createTypedArrayList(Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zC1 ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(f55a);
                    Bundle bundleB2 = B2(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleB2 != null) {
                        parcel2.writeInt(1);
                        bundleB2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface(f55a);
                    boolean zZ4 = Z4(android.support.customtabs.a.AbstractBinderC0000a.i0(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZ4 ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(f55a);
                    boolean zN5 = n5(android.support.customtabs.a.AbstractBinderC0000a.i0(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zN5 ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(f55a);
                    int iL4 = l4(android.support.customtabs.a.AbstractBinderC0000a.i0(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(iL4);
                    return true;
                case 9:
                    parcel.enforceInterface(f55a);
                    boolean zL1 = l1(android.support.customtabs.a.AbstractBinderC0000a.i0(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zL1 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i7, parcel, parcel2, i8);
            }
        }
    }

    Bundle B2(String str, Bundle bundle) throws RemoteException;

    boolean Z4(android.support.customtabs.a aVar, Bundle bundle) throws RemoteException;

    boolean c1(android.support.customtabs.a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    boolean l1(android.support.customtabs.a aVar, int i7, Uri uri, Bundle bundle) throws RemoteException;

    int l4(android.support.customtabs.a aVar, String str, Bundle bundle) throws RemoteException;

    boolean n5(android.support.customtabs.a aVar, Uri uri) throws RemoteException;

    boolean o3(long j7) throws RemoteException;

    boolean y4(android.support.customtabs.a aVar) throws RemoteException;
}
