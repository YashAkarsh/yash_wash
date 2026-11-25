package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.j;
import org.junit.runner.notification.a;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelableResult implements Parcelable {
    public static final Parcelable.Creator<ParcelableResult> CREATOR = new Parcelable.Creator<ParcelableResult>() { // from class: androidx.test.orchestrator.junit.ParcelableResult.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableResult createFromParcel(Parcel in) {
            return new ParcelableResult(in);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableResult[] newArray(int size) {
            return new ParcelableResult[size];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ParcelableFailure> f10281a;

    public int a() {
        return this.f10281a.size();
    }

    public List<ParcelableFailure> b() {
        return this.f10281a;
    }

    public boolean d() {
        return this.f10281a.isEmpty();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeArray(this.f10281a.toArray());
    }

    public ParcelableResult(j result) {
        this.f10281a = new ArrayList();
        Iterator<a> it = result.h().iterator();
        while (it.hasNext()) {
            this.f10281a.add(new ParcelableFailure(it.next()));
        }
    }

    private ParcelableResult(Parcel in) {
        this.f10281a = new ArrayList();
        for (Object obj : in.readArray(ParcelableFailure[].class.getClassLoader())) {
            this.f10281a.add((ParcelableFailure) obj);
        }
    }
}
