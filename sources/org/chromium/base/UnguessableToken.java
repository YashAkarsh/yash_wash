package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f38758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f38759b;

    class a implements Parcelable.Creator<UnguessableToken> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnguessableToken createFromParcel(Parcel parcel) {
            long j7 = parcel.readLong();
            long j8 = parcel.readLong();
            if (j7 == 0 || j8 == 0) {
                return null;
            }
            return new UnguessableToken(j7, j8, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnguessableToken[] newArray(int i7) {
            return new UnguessableToken[i7];
        }
    }

    /* synthetic */ UnguessableToken(long j7, long j8, a aVar) {
        this(j7, j8);
    }

    @CalledByNative
    private static UnguessableToken create(long j7, long j8) {
        return new UnguessableToken(j7, j8);
    }

    @CalledByNative
    private UnguessableToken parcelAndUnparcelForTesting() {
        Parcel parcelObtain = Parcel.obtain();
        writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        UnguessableToken unguessableTokenCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return unguessableTokenCreateFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @CalledByNative
    public long getHighForSerialization() {
        return this.f38758a;
    }

    @CalledByNative
    public long getLowForSerialization() {
        return this.f38759b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeLong(this.f38758a);
        parcel.writeLong(this.f38759b);
    }

    private UnguessableToken(long j7, long j8) {
        this.f38758a = j7;
        this.f38759b = j8;
    }
}
