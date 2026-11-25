package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableDouble extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableDouble> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f7157c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f7158b;

    static class a implements Parcelable.Creator<ObservableDouble> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableDouble createFromParcel(Parcel parcel) {
            return new ObservableDouble(parcel.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableDouble[] newArray(int i7) {
            return new ObservableDouble[i7];
        }
    }

    public ObservableDouble(double d8) {
        this.f7158b = d8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double g() {
        return this.f7158b;
    }

    public void h(double d8) {
        if (d8 != this.f7158b) {
            this.f7158b = d8;
            e();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeDouble(this.f7158b);
    }

    public ObservableDouble() {
    }

    public ObservableDouble(s... sVarArr) {
        super(sVarArr);
    }
}
