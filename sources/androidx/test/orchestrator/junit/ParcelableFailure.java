package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.junit.runner.notification.a;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelableFailure implements Parcelable {
    public static final Parcelable.Creator<ParcelableFailure> CREATOR = new Parcelable.Creator<ParcelableFailure>() { // from class: androidx.test.orchestrator.junit.ParcelableFailure.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableFailure createFromParcel(Parcel in) {
            return new ParcelableFailure(in);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableFailure[] newArray(int size) {
            return new ParcelableFailure[size];
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10277c = "ParcelableFailure";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f10278d = 16384;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParcelableDescription f10279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10280b;

    private static String d(String trace) {
        if (trace.length() <= 16384) {
            return trace.concat("\n");
        }
        Log.i(f10277c, String.format("Stack trace too long, trimmed to first %s characters.", 16384));
        return String.valueOf(trace.substring(0, 16384)).concat("\n");
    }

    public ParcelableDescription a() {
        return this.f10279a;
    }

    public String b() {
        return this.f10280b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(this.f10279a, 0);
        out.writeString(this.f10280b);
    }

    public ParcelableFailure(a failure) {
        this.f10279a = new ParcelableDescription(failure.a());
        this.f10280b = failure.e();
    }

    private ParcelableFailure(Parcel in) {
        this.f10279a = (ParcelableDescription) in.readParcelable(ParcelableDescription.class.getClassLoader());
        this.f10280b = in.readString();
    }

    public ParcelableFailure(ParcelableDescription description, Throwable t7) {
        this.f10279a = description;
        this.f10280b = d(t7.getMessage());
    }
}
