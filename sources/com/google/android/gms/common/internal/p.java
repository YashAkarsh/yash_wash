package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface p extends IInterface {

    public static abstract class a extends Binder implements p {
        public a() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @c1.a
        @c.m0
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:61:0x00d2  */
        /* JADX WARN: Code duplicated, block: B:63:0x00de  */
        /* JADX WARN: Code duplicated, block: B:64:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:66:0x00ed  */
        @Override // android.os.Binder
        public final boolean onTransact(int i7, @c.m0 Parcel parcel, @c.o0 Parcel parcel2, int i8) throws RemoteException {
            o f1Var;
            if (i7 > 16777215) {
                return super.onTransact(i7, parcel, parcel2, i8);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                f1Var = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                f1Var = iInterfaceQueryLocalInterface instanceof o ? (o) iInterfaceQueryLocalInterface : new f1(strongBinder);
            }
            if (i7 == 46) {
                K1(f1Var, parcel.readInt() != 0 ? GetServiceRequest.CREATOR.createFromParcel(parcel) : null);
                u.k(parcel2);
                parcel2.writeNoException();
                return true;
            }
            if (i7 == 47) {
                if (parcel.readInt() != 0) {
                    zzaj.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            }
            parcel.readInt();
            if (i7 != 4) {
                parcel.readString();
                if (i7 == 1) {
                    parcel.readString();
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                    }
                } else if (i7 == 2 || i7 == 23 || i7 == 25 || i7 == 27) {
                    if (parcel.readInt() != 0) {
                    }
                } else if (i7 == 30) {
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                    }
                } else if (i7 == 34) {
                    parcel.readString();
                } else if (i7 != 41 && i7 != 43 && i7 != 37 && i7 != 38) {
                    switch (i7) {
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                            if (parcel.readInt() != 0) {
                            }
                            break;
                        case 9:
                            parcel.readString();
                            parcel.createStringArray();
                            parcel.readString();
                            parcel.readStrongBinder();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                            }
                            break;
                        case 10:
                            parcel.readString();
                            parcel.createStringArray();
                            break;
                        case 19:
                            parcel.readStrongBinder();
                            if (parcel.readInt() != 0) {
                            }
                            break;
                        case 20:
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                            }
                            break;
                    }
                } else if (parcel.readInt() != 0) {
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    @c1.a
    void K1(@c.m0 o oVar, @c.o0 GetServiceRequest getServiceRequest) throws RemoteException;
}
