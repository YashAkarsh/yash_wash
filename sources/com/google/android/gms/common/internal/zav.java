package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ResolveAccountResponseCreator")
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new b1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(id = 2)
    final IBinder f15832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getConnectionResult", id = 3)
    private final ConnectionResult f15833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getSaveDefaultAccount", id = 4)
    private final boolean f15834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "isFromCrossClientAuth", id = 5)
    private final boolean f15835e;

    @SafeParcelable.b
    zav(@SafeParcelable.e(id = 1) int i7, @c.o0 @SafeParcelable.e(id = 2) IBinder iBinder, @SafeParcelable.e(id = 3) ConnectionResult connectionResult, @SafeParcelable.e(id = 4) boolean z7, @SafeParcelable.e(id = 5) boolean z8) {
        this.f15831a = i7;
        this.f15832b = iBinder;
        this.f15833c = connectionResult;
        this.f15834d = z7;
        this.f15835e = z8;
    }

    public final ConnectionResult K() {
        return this.f15833c;
    }

    @c.o0
    public final m Q() {
        IBinder iBinder = this.f15832b;
        if (iBinder == null) {
            return null;
        }
        return m.a.u0(iBinder);
    }

    public final boolean equals(@c.o0 Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        return this.f15833c.equals(zavVar.f15833c) && s.b(Q(), zavVar.Q());
    }

    public final boolean p0() {
        return this.f15834d;
    }

    public final boolean r0() {
        return this.f15835e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15831a);
        e1.b.B(parcel, 2, this.f15832b, false);
        e1.b.S(parcel, 3, this.f15833c, i7, false);
        e1.b.g(parcel, 4, this.f15834d);
        e1.b.g(parcel, 5, this.f15835e);
        e1.b.b(parcel, iA);
    }
}
