package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
@SuppressLint({"BanParcelableUsage"})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Handler f532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.support.v4.os.a f533c;

    class a implements Parcelable.Creator<ResultReceiver> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i7) {
            return new ResultReceiver[i7];
        }
    }

    class b extends android.support.v4.os.a.b {
        b() {
        }

        @Override // android.support.v4.os.a
        public void n6(int i7, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f532b;
            if (handler != null) {
                handler.post(resultReceiver.new c(i7, bundle));
            } else {
                resultReceiver.a(i7, bundle);
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f536b;

        c(int i7, Bundle bundle) {
            this.f535a = i7;
            this.f536b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.f535a, this.f536b);
        }
    }

    public ResultReceiver(Handler handler) {
        this.f531a = true;
        this.f532b = handler;
    }

    protected void a(int i7, Bundle bundle) {
    }

    public void b(int i7, Bundle bundle) {
        if (this.f531a) {
            Handler handler = this.f532b;
            if (handler != null) {
                handler.post(new c(i7, bundle));
                return;
            } else {
                a(i7, bundle);
                return;
            }
        }
        android.support.v4.os.a aVar = this.f533c;
        if (aVar != null) {
            try {
                aVar.n6(i7, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        synchronized (this) {
            if (this.f533c == null) {
                this.f533c = new b();
            }
            parcel.writeStrongBinder(this.f533c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f531a = false;
        this.f532b = null;
        this.f533c = android.support.v4.os.a.b.i0(parcel.readStrongBinder());
    }
}
