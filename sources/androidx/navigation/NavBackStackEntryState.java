package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f8753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f8755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bundle f8756d;

    class a implements Parcelable.Creator<NavBackStackEntryState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavBackStackEntryState[] newArray(int i7) {
            return new NavBackStackEntryState[i7];
        }
    }

    NavBackStackEntryState(g gVar) {
        this.f8753a = gVar.f8838f;
        this.f8754b = gVar.b().m();
        this.f8755c = gVar.a();
        Bundle bundle = new Bundle();
        this.f8756d = bundle;
        gVar.h(bundle);
    }

    @o0
    Bundle a() {
        return this.f8755c;
    }

    int b() {
        return this.f8754b;
    }

    @m0
    Bundle d() {
        return this.f8756d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @m0
    UUID e() {
        return this.f8753a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        parcel.writeString(this.f8753a.toString());
        parcel.writeInt(this.f8754b);
        parcel.writeBundle(this.f8755c);
        parcel.writeBundle(this.f8756d);
    }

    NavBackStackEntryState(Parcel parcel) {
        this.f8753a = UUID.fromString(parcel.readString());
        this.f8754b = parcel.readInt();
        this.f8755c = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.f8756d = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }
}
