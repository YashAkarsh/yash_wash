package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {

    @m0
    public static final Parcelable.Creator<ActivityResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final Intent f582b;

    class a implements Parcelable.Creator<ActivityResult> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResult createFromParcel(@m0 Parcel parcel) {
            return new ActivityResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResult[] newArray(int i7) {
            return new ActivityResult[i7];
        }
    }

    public ActivityResult(int i7, @o0 Intent intent) {
        this.f581a = i7;
        this.f582b = intent;
    }

    @m0
    public static String d(int i7) {
        if (i7 != -1) {
            return i7 != 0 ? String.valueOf(i7) : "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    @o0
    public Intent a() {
        return this.f582b;
    }

    public int b() {
        return this.f581a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + d(this.f581a) + ", data=" + this.f582b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        parcel.writeInt(this.f581a);
        parcel.writeInt(this.f582b == null ? 0 : 1);
        Intent intent = this.f582b;
        if (intent != null) {
            intent.writeToParcel(parcel, i7);
        }
    }

    ActivityResult(Parcel parcel) {
        this.f581a = parcel.readInt();
        this.f582b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
