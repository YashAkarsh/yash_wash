package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.media.session.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0012a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f483a = "android.support.v4.media.session.IMediaControllerCallback";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f484d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f485e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f486f = 3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f487g = 4;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f488h = 5;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f489i = 6;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f490j = 7;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final int f491k = 8;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final int f492l = 9;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        static final int f493m = 10;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        static final int f494n = 11;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final int f495o = 12;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final int f496p = 13;

        /* JADX INFO: renamed from: android.support.v4.media.session.a$a$a, reason: collision with other inner class name */
        private static class C0013a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f497a;

            C0013a(IBinder iBinder) {
                this.f497a = iBinder;
            }

            @Override // android.support.v4.media.session.a
            public void A4(int i7) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    parcelObtain.writeInt(i7);
                    this.f497a.transact(9, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void P1() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    this.f497a.transact(13, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void Q3(boolean z7) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    parcelObtain.writeInt(z7 ? 1 : 0);
                    this.f497a.transact(10, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void T(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f497a.transact(7, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void W(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    parcelObtain.writeTypedList(list);
                    this.f497a.transact(5, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void W4(int i7) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    parcelObtain.writeInt(i7);
                    this.f497a.transact(12, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f497a;
            }

            @Override // android.support.v4.media.session.a
            public void c0(CharSequence charSequence) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    if (charSequence != null) {
                        parcelObtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f497a.transact(6, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void e0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    this.f497a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void g6(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    if (playbackStateCompat != null) {
                        parcelObtain.writeInt(1);
                        playbackStateCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f497a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void h4(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    if (mediaMetadataCompat != null) {
                        parcelObtain.writeInt(1);
                        mediaMetadataCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f497a.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void h6(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f497a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String i0() {
                return AbstractBinderC0012a.f483a;
            }

            @Override // android.support.v4.media.session.a
            public void l3(boolean z7) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    parcelObtain.writeInt(z7 ? 1 : 0);
                    this.f497a.transact(11, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void r6(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0012a.f483a);
                    if (parcelableVolumeInfo != null) {
                        parcelObtain.writeInt(1);
                        parcelableVolumeInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f497a.transact(8, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0012a() {
            attachInterface(this, f483a);
        }

        public static a i0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f483a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0013a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
            if (i7 == 1598968902) {
                parcel2.writeString(f483a);
                return true;
            }
            switch (i7) {
                case 1:
                    parcel.enforceInterface(f483a);
                    h6(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface(f483a);
                    e0();
                    return true;
                case 3:
                    parcel.enforceInterface(f483a);
                    g6(parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 4:
                    parcel.enforceInterface(f483a);
                    h4(parcel.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface(f483a);
                    W(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                    return true;
                case 6:
                    parcel.enforceInterface(f483a);
                    c0(parcel.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 7:
                    parcel.enforceInterface(f483a);
                    T(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 8:
                    parcel.enforceInterface(f483a);
                    r6(parcel.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 9:
                    parcel.enforceInterface(f483a);
                    A4(parcel.readInt());
                    return true;
                case 10:
                    parcel.enforceInterface(f483a);
                    Q3(parcel.readInt() != 0);
                    return true;
                case 11:
                    parcel.enforceInterface(f483a);
                    l3(parcel.readInt() != 0);
                    return true;
                case 12:
                    parcel.enforceInterface(f483a);
                    W4(parcel.readInt());
                    return true;
                case 13:
                    parcel.enforceInterface(f483a);
                    P1();
                    return true;
                default:
                    return super.onTransact(i7, parcel, parcel2, i8);
            }
        }
    }

    void A4(int i7) throws RemoteException;

    void P1() throws RemoteException;

    void Q3(boolean z7) throws RemoteException;

    void T(Bundle bundle) throws RemoteException;

    void W(List<MediaSessionCompat.QueueItem> list) throws RemoteException;

    void W4(int i7) throws RemoteException;

    void c0(CharSequence charSequence) throws RemoteException;

    void e0() throws RemoteException;

    void g6(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void h4(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void h6(String str, Bundle bundle) throws RemoteException;

    void l3(boolean z7) throws RemoteException;

    void r6(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;
}
