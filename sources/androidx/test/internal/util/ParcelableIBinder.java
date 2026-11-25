package androidx.test.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableIBinder implements Parcelable {
    public static final Parcelable.Creator<ParcelableIBinder> CREATOR = new Parcelable.Creator<ParcelableIBinder>() { // from class: androidx.test.internal.util.ParcelableIBinder.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableIBinder createFromParcel(Parcel in) {
            return new ParcelableIBinder(in);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableIBinder[] newArray(int size) {
            return new ParcelableIBinder[size];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f10244a;

    public ParcelableIBinder(IBinder iBinder) {
        this.f10244a = (IBinder) Checks.f(iBinder);
    }

    public IBinder a() {
        return this.f10244a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.f10244a);
    }

    protected ParcelableIBinder(Parcel in) {
        this.f10244a = in.readStrongBinder();
    }
}
