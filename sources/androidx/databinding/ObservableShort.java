package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableShort extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableShort> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f7166c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private short f7167b;

    static class a implements Parcelable.Creator<ObservableShort> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableShort createFromParcel(Parcel parcel) {
            return new ObservableShort((short) parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableShort[] newArray(int i7) {
            return new ObservableShort[i7];
        }
    }

    public ObservableShort(short s7) {
        this.f7167b = s7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public short g() {
        return this.f7167b;
    }

    public void h(short s7) {
        if (s7 != this.f7167b) {
            this.f7167b = s7;
            e();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f7167b);
    }

    public ObservableShort() {
    }

    public ObservableShort(s... sVarArr) {
        super(sVarArr);
    }
}
