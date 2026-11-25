package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "NetworkLocationStatusCreator")
@com.google.android.gms.common.internal.y
public final class zzbo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbo> CREATOR = new i1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", id = 1)
    public final int f16434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", id = 2)
    public final int f16435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "NetworkLocationStatus.STATUS_INVALID_TIMESTAMP", id = 3)
    public final long f16436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "NetworkLocationStatus.STATUS_INVALID_TIMESTAMP", id = 4)
    public final long f16437d;

    @SafeParcelable.b
    zzbo(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @SafeParcelable.e(id = 3) long j7, @SafeParcelable.e(id = 4) long j8) {
        this.f16434a = i7;
        this.f16435b = i8;
        this.f16436c = j7;
        this.f16437d = j8;
    }

    public final boolean equals(@c.o0 Object obj) {
        if (obj instanceof zzbo) {
            zzbo zzboVar = (zzbo) obj;
            if (this.f16434a == zzboVar.f16434a && this.f16435b == zzboVar.f16435b && this.f16436c == zzboVar.f16436c && this.f16437d == zzboVar.f16437d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16435b), Integer.valueOf(this.f16434a), Long.valueOf(this.f16437d), Long.valueOf(this.f16436c));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f16434a + " Cell status: " + this.f16435b + " elapsed time NS: " + this.f16437d + " system time ms: " + this.f16436c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16434a);
        e1.b.F(parcel, 2, this.f16435b);
        e1.b.K(parcel, 3, this.f16436c);
        e1.b.K(parcel, 4, this.f16437d);
        e1.b.b(parcel, iA);
    }
}
