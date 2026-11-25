package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableFloat extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f7159c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7160b;

    static class a implements Parcelable.Creator<ObservableFloat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableFloat createFromParcel(Parcel parcel) {
            return new ObservableFloat(parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableFloat[] newArray(int i7) {
            return new ObservableFloat[i7];
        }
    }

    public ObservableFloat(float f8) {
        this.f7160b = f8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float g() {
        return this.f7160b;
    }

    public void h(float f8) {
        if (f8 != this.f7160b) {
            this.f7160b = f8;
            e();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeFloat(this.f7160b);
    }

    public ObservableFloat() {
    }

    public ObservableFloat(s... sVarArr) {
        super(sVarArr);
    }
}
