package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LocationAvailabilityCreator")
@SafeParcelable.f({1000})
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {

    @c.m0
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new z0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", id = 1)
    @Deprecated
    int f16264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", id = 2)
    @Deprecated
    int f16265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "0", id = 3)
    long f16266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationAvailability.STATUS_UNSUCCESSFUL", id = 4)
    int f16267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(id = 5)
    zzbo[] f16268e;

    @SafeParcelable.b
    LocationAvailability(@SafeParcelable.e(id = 4) int i7, @SafeParcelable.e(id = 1) int i8, @SafeParcelable.e(id = 2) int i9, @SafeParcelable.e(id = 3) long j7, @SafeParcelable.e(id = 5) zzbo[] zzboVarArr) {
        this.f16267d = i7;
        this.f16264a = i8;
        this.f16265b = i9;
        this.f16266c = j7;
        this.f16268e = zzboVarArr;
    }

    public static boolean K(@c.m0 Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    @c.m0
    public static LocationAvailability s(@c.m0 Intent intent) {
        if (!K(intent)) {
            return null;
        }
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                return (LocationAvailability) extras.getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
            }
            return null;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public boolean Q() {
        return this.f16267d < 1000;
    }

    public boolean equals(@c.m0 Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f16264a == locationAvailability.f16264a && this.f16265b == locationAvailability.f16265b && this.f16266c == locationAvailability.f16266c && this.f16267d == locationAvailability.f16267d && Arrays.equals(this.f16268e, locationAvailability.f16268e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16267d), Integer.valueOf(this.f16264a), Integer.valueOf(this.f16265b), Long.valueOf(this.f16266c), this.f16268e);
    }

    @c.m0
    public String toString() {
        boolean zQ = Q();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(zQ);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16264a);
        e1.b.F(parcel, 2, this.f16265b);
        e1.b.K(parcel, 3, this.f16266c);
        e1.b.F(parcel, 4, this.f16267d);
        e1.b.c0(parcel, 5, this.f16268e, i7, false);
        e1.b.b(parcel, iA);
    }
}
