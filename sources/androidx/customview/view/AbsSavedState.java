package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Parcelable f7097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbsSavedState f7096b = new AbsSavedState() { // from class: androidx.customview.view.AbsSavedState.1
    };
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new a();

    class a implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f7096b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AbsSavedState[] newArray(int i7) {
            return new AbsSavedState[i7];
        }
    }

    @o0
    public final Parcelable a() {
        return this.f7097a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(this.f7097a, i7);
    }

    private AbsSavedState() {
        this.f7097a = null;
    }

    protected AbsSavedState(@m0 Parcelable parcelable) {
        if (parcelable != null) {
            this.f7097a = parcelable == f7096b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(@m0 Parcel parcel) {
        this(parcel, null);
    }

    protected AbsSavedState(@m0 Parcel parcel, @o0 ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f7097a = parcelable == null ? f7096b : parcelable;
    }
}
