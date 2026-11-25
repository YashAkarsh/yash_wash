package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<FragmentState> f7851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<String> f7852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    BackStackState[] f7853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f7854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f7855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<String> f7856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList<Bundle> f7857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayList<FragmentManager.LaunchedFragmentInfo> f7858h;

    class a implements Parcelable.Creator<FragmentManagerState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i7) {
            return new FragmentManagerState[i7];
        }
    }

    public FragmentManagerState() {
        this.f7855e = null;
        this.f7856f = new ArrayList<>();
        this.f7857g = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeTypedList(this.f7851a);
        parcel.writeStringList(this.f7852b);
        parcel.writeTypedArray(this.f7853c, i7);
        parcel.writeInt(this.f7854d);
        parcel.writeString(this.f7855e);
        parcel.writeStringList(this.f7856f);
        parcel.writeTypedList(this.f7857g);
        parcel.writeTypedList(this.f7858h);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f7855e = null;
        this.f7856f = new ArrayList<>();
        this.f7857g = new ArrayList<>();
        this.f7851a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f7852b = parcel.createStringArrayList();
        this.f7853c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f7854d = parcel.readInt();
        this.f7855e = parcel.readString();
        this.f7856f = parcel.createStringArrayList();
        this.f7857g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f7858h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
