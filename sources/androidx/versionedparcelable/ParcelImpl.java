package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f11009a;

    static class a implements Parcelable.Creator<ParcelImpl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelImpl[] newArray(int i7) {
            return new ParcelImpl[i7];
        }
    }

    public ParcelImpl(h hVar) {
        this.f11009a = hVar;
    }

    public <T extends h> T a() {
        return (T) this.f11009a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        new f(parcel).l1(this.f11009a);
    }

    protected ParcelImpl(Parcel parcel) {
        this.f11009a = new f(parcel).g0();
    }
}
