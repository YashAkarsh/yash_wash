package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableByte extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f7153c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte f7154b;

    static class a implements Parcelable.Creator<ObservableByte> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableByte createFromParcel(Parcel parcel) {
            return new ObservableByte(parcel.readByte());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableByte[] newArray(int i7) {
            return new ObservableByte[i7];
        }
    }

    public ObservableByte(byte b8) {
        this.f7154b = b8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte g() {
        return this.f7154b;
    }

    public void h(byte b8) {
        if (b8 != this.f7154b) {
            this.f7154b = b8;
            e();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeByte(this.f7154b);
    }

    public ObservableByte() {
    }

    public ObservableByte(s... sVarArr) {
        super(sVarArr);
    }
}
