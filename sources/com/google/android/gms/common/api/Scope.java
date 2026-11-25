package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ScopeCreator")
@c1.a
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {

    @m0
    public static final Parcelable.Creator<Scope> CREATOR = new h0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getScopeUri", id = 2)
    private final String f15062b;

    @SafeParcelable.b
    Scope(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) String str) {
        com.google.android.gms.common.internal.u.h(str, "scopeUri must not be null or empty");
        this.f15061a = i7;
        this.f15062b = str;
    }

    @c1.a
    @m0
    public String K() {
        return this.f15062b;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f15062b.equals(((Scope) obj).f15062b);
        }
        return false;
    }

    public int hashCode() {
        return this.f15062b.hashCode();
    }

    @m0
    public String toString() {
        return this.f15062b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15061a);
        e1.b.Y(parcel, 2, K(), false);
        e1.b.b(parcel, iA);
    }

    public Scope(@m0 String str) {
        this(1, str);
    }
}
