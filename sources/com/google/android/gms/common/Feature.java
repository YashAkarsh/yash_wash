package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "FeatureCreator")
@c1.a
public class Feature extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<Feature> CREATOR = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getName", id = 1)
    private final String f15022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getOldVersion", id = 2)
    @Deprecated
    private final int f15023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "-1", getter = "getVersion", id = 3)
    private final long f15024c;

    @SafeParcelable.b
    public Feature(@SafeParcelable.e(id = 1) @c.m0 String str, @SafeParcelable.e(id = 2) int i7, @SafeParcelable.e(id = 3) long j7) {
        this.f15022a = str;
        this.f15023b = i7;
        this.f15024c = j7;
    }

    @c1.a
    @c.m0
    public String K() {
        return this.f15022a;
    }

    @c1.a
    public long Q() {
        long j7 = this.f15024c;
        return j7 == -1 ? this.f15023b : j7;
    }

    public final boolean equals(@c.o0 Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((K() != null && K().equals(feature.K())) || (K() == null && feature.K() == null)) && Q() == feature.Q()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.s.c(K(), Long.valueOf(Q()));
    }

    @c.m0
    public final String toString() {
        com.google.android.gms.common.internal.s.a aVarD = com.google.android.gms.common.internal.s.d(this);
        aVarD.a("name", K());
        aVarD.a("version", Long.valueOf(Q()));
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.Y(parcel, 1, K(), false);
        e1.b.F(parcel, 2, this.f15023b);
        e1.b.K(parcel, 3, Q());
        e1.b.b(parcel, iA);
    }

    @c1.a
    public Feature(@c.m0 String str, long j7) {
        this.f15022a = str;
        this.f15024c = j7;
        this.f15023b = -1;
    }
}
