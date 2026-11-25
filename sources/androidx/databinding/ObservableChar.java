package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableChar extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableChar> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f7155c = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private char f7156b;

    static class a implements Parcelable.Creator<ObservableChar> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableChar createFromParcel(Parcel parcel) {
            return new ObservableChar((char) parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableChar[] newArray(int i7) {
            return new ObservableChar[i7];
        }
    }

    public ObservableChar(char c8) {
        this.f7156b = c8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public char g() {
        return this.f7156b;
    }

    public void h(char c8) {
        if (c8 != this.f7156b) {
            this.f7156b = c8;
            e();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f7156b);
    }

    public ObservableChar() {
    }

    public ObservableChar(s... sVarArr) {
        super(sVarArr);
    }
}
