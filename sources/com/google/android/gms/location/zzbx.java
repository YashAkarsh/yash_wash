package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "UserPreferredSleepWindowCreator")
@SafeParcelable.f({1000})
@com.google.android.gms.common.internal.y
public final class zzbx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbx> CREATOR = new p1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStartHour", id = 1)
    private final int f16441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStartMinute", id = 2)
    private final int f16442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getEndHour", id = 3)
    private final int f16443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getEndMinute", id = 4)
    private final int f16444d;

    @SafeParcelable.b
    public zzbx(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @SafeParcelable.e(id = 3) int i9, @SafeParcelable.e(id = 4) int i10) {
        com.google.android.gms.common.internal.u.r(i7 >= 0 && i7 <= 23, "Start hour must be in range [0, 23].");
        com.google.android.gms.common.internal.u.r(i8 >= 0 && i8 <= 59, "Start minute must be in range [0, 59].");
        com.google.android.gms.common.internal.u.r(i9 >= 0 && i9 <= 23, "End hour must be in range [0, 23].");
        com.google.android.gms.common.internal.u.r(i10 >= 0 && i10 <= 59, "End minute must be in range [0, 59].");
        com.google.android.gms.common.internal.u.r(((i7 + i8) + i9) + i10 > 0, "Parameters can't be all 0.");
        this.f16441a = i7;
        this.f16442b = i8;
        this.f16443c = i9;
        this.f16444d = i10;
    }

    public final boolean equals(@c.o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbx)) {
            return false;
        }
        zzbx zzbxVar = (zzbx) obj;
        return this.f16441a == zzbxVar.f16441a && this.f16442b == zzbxVar.f16442b && this.f16443c == zzbxVar.f16443c && this.f16444d == zzbxVar.f16444d;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16441a), Integer.valueOf(this.f16442b), Integer.valueOf(this.f16443c), Integer.valueOf(this.f16444d));
    }

    public final String toString() {
        int i7 = this.f16441a;
        int i8 = this.f16442b;
        int i9 = this.f16443c;
        int i10 = this.f16444d;
        StringBuilder sb = new StringBuilder(117);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(i7);
        sb.append(", startMinute=");
        sb.append(i8);
        sb.append(", endHour=");
        sb.append(i9);
        sb.append(", endMinute=");
        sb.append(i10);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        com.google.android.gms.common.internal.u.k(parcel);
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16441a);
        e1.b.F(parcel, 2, this.f16442b);
        e1.b.F(parcel, 3, this.f16443c);
        e1.b.F(parcel, 4, this.f16444d);
        e1.b.b(parcel, iA);
    }
}
