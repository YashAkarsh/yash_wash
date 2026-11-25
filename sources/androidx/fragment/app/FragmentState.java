package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f7859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f7860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f7861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f7862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f7863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f7864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f7865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f7866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f7867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Bundle f7868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f7869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final int f7870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Bundle f7871m;

    class a implements Parcelable.Creator<FragmentState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i7) {
            return new FragmentState[i7];
        }
    }

    FragmentState(Fragment fragment) {
        this.f7859a = fragment.getClass().getName();
        this.f7860b = fragment.mWho;
        this.f7861c = fragment.mFromLayout;
        this.f7862d = fragment.mFragmentId;
        this.f7863e = fragment.mContainerId;
        this.f7864f = fragment.mTag;
        this.f7865g = fragment.mRetainInstance;
        this.f7866h = fragment.mRemoving;
        this.f7867i = fragment.mDetached;
        this.f7868j = fragment.mArguments;
        this.f7869k = fragment.mHidden;
        this.f7870l = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @m0
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f7859a);
        sb.append(" (");
        sb.append(this.f7860b);
        sb.append(")}:");
        if (this.f7861c) {
            sb.append(" fromLayout");
        }
        if (this.f7863e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f7863e));
        }
        String str = this.f7864f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f7864f);
        }
        if (this.f7865g) {
            sb.append(" retainInstance");
        }
        if (this.f7866h) {
            sb.append(" removing");
        }
        if (this.f7867i) {
            sb.append(" detached");
        }
        if (this.f7869k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f7859a);
        parcel.writeString(this.f7860b);
        parcel.writeInt(this.f7861c ? 1 : 0);
        parcel.writeInt(this.f7862d);
        parcel.writeInt(this.f7863e);
        parcel.writeString(this.f7864f);
        parcel.writeInt(this.f7865g ? 1 : 0);
        parcel.writeInt(this.f7866h ? 1 : 0);
        parcel.writeInt(this.f7867i ? 1 : 0);
        parcel.writeBundle(this.f7868j);
        parcel.writeInt(this.f7869k ? 1 : 0);
        parcel.writeBundle(this.f7871m);
        parcel.writeInt(this.f7870l);
    }

    FragmentState(Parcel parcel) {
        this.f7859a = parcel.readString();
        this.f7860b = parcel.readString();
        this.f7861c = parcel.readInt() != 0;
        this.f7862d = parcel.readInt();
        this.f7863e = parcel.readInt();
        this.f7864f = parcel.readString();
        this.f7865g = parcel.readInt() != 0;
        this.f7866h = parcel.readInt() != 0;
        this.f7867i = parcel.readInt() != 0;
        this.f7868j = parcel.readBundle();
        this.f7869k = parcel.readInt() != 0;
        this.f7871m = parcel.readBundle();
        this.f7870l = parcel.readInt();
    }
}
