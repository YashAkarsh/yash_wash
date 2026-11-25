package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableLong extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableLong> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f7163c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7164b;

    static class a implements Parcelable.Creator<ObservableLong> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableLong createFromParcel(Parcel parcel) {
            return new ObservableLong(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableLong[] newArray(int i7) {
            return new ObservableLong[i7];
        }
    }

    public ObservableLong(long j7) {
        this.f7164b = j7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long g() {
        return this.f7164b;
    }

    public void h(long j7) {
        if (j7 != this.f7164b) {
            this.f7164b = j7;
            e();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeLong(this.f7164b);
    }

    public ObservableLong() {
    }

    public ObservableLong(s... sVarArr) {
        super(sVarArr);
    }
}
