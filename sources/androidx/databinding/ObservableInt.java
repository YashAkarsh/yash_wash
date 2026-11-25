package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableInt extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f7161c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7162b;

    static class a implements Parcelable.Creator<ObservableInt> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableInt createFromParcel(Parcel parcel) {
            return new ObservableInt(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableInt[] newArray(int i7) {
            return new ObservableInt[i7];
        }
    }

    public ObservableInt(int i7) {
        this.f7162b = i7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int g() {
        return this.f7162b;
    }

    public void h(int i7) {
        if (i7 != this.f7162b) {
            this.f7162b = i7;
            e();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f7162b);
    }

    public ObservableInt() {
    }

    public ObservableInt(s... sVarArr) {
        super(sVarArr);
    }
}
