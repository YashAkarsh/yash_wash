package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableBoolean extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f7151c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7152b;

    static class a implements Parcelable.Creator<ObservableBoolean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableBoolean createFromParcel(Parcel parcel) {
            return new ObservableBoolean(parcel.readInt() == 1);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableBoolean[] newArray(int i7) {
            return new ObservableBoolean[i7];
        }
    }

    public ObservableBoolean(boolean z7) {
        this.f7152b = z7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean g() {
        return this.f7152b;
    }

    public void h(boolean z7) {
        if (z7 != this.f7152b) {
            this.f7152b = z7;
            e();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f7152b ? 1 : 0);
    }

    public ObservableBoolean() {
    }

    public ObservableBoolean(s... sVarArr) {
        super(sVarArr);
    }
}
