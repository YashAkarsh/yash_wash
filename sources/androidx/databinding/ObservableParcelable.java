package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableParcelable<T extends Parcelable> extends v<T> implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableParcelable> CREATOR = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final long f7165d = 1;

    static class a implements Parcelable.Creator<ObservableParcelable> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableParcelable createFromParcel(Parcel parcel) {
            return new ObservableParcelable(parcel.readParcelable(a.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableParcelable[] newArray(int i7) {
            return new ObservableParcelable[i7];
        }
    }

    public ObservableParcelable(T t7) {
        super(t7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(g(), 0);
    }

    public ObservableParcelable() {
    }
}
