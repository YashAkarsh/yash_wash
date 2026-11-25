package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import org.junit.runner.c;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelableDescription implements Parcelable {
    public static final Parcelable.Creator<ParcelableDescription> CREATOR = new Parcelable.Creator<ParcelableDescription>() { // from class: androidx.test.orchestrator.junit.ParcelableDescription.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableDescription createFromParcel(Parcel in) {
            return new ParcelableDescription(in);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableDescription[] newArray(int size) {
            return new ParcelableDescription[size];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10276c;

    private String e(Parcel in) {
        String string = in.readString();
        return string == null ? "" : string;
    }

    public String a() {
        return this.f10274a;
    }

    public String b() {
        return this.f10276c;
    }

    public String d() {
        return this.f10275b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.f10274a);
        out.writeString(this.f10275b);
        out.writeString(this.f10276c);
    }

    public ParcelableDescription(c description) {
        this.f10274a = description.n();
        this.f10275b = description.p();
        this.f10276c = description.o();
    }

    public ParcelableDescription(String classAndMethodName) {
        String[] strArrSplit = classAndMethodName.split("#");
        this.f10274a = strArrSplit[0];
        this.f10275b = strArrSplit.length > 1 ? strArrSplit[1] : "";
        this.f10276c = classAndMethodName;
    }

    private ParcelableDescription(Parcel in) {
        this.f10274a = e(in);
        this.f10275b = e(in);
        this.f10276c = e(in);
    }
}
