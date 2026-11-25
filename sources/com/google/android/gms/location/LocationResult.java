package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LocationResultCreator")
@SafeParcelable.f({1000})
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationResult.DEFAULT_LOCATIONS", getter = "getLocations", id = 1)
    private final List<Location> f16283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final List<Location> f16282b = Collections.emptyList();

    @c.m0
    public static final Parcelable.Creator<LocationResult> CREATOR = new b1();

    @SafeParcelable.b
    LocationResult(@SafeParcelable.e(id = 1) List<Location> list) {
        this.f16283a = list;
    }

    @c.m0
    public static LocationResult K(@c.m0 Intent intent) {
        if (r0(intent)) {
            return (LocationResult) intent.getParcelableExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
        }
        return null;
    }

    public static boolean r0(@c.m0 Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    @c.m0
    public static LocationResult s(@c.m0 List<Location> list) {
        if (list == null) {
            list = f16282b;
        }
        return new LocationResult(list);
    }

    @c.m0
    public Location Q() {
        int size = this.f16283a.size();
        if (size == 0) {
            return null;
        }
        return this.f16283a.get(size - 1);
    }

    public boolean equals(@c.m0 Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f16283a.size() != this.f16283a.size()) {
            return false;
        }
        Iterator<Location> it = locationResult.f16283a.iterator();
        Iterator<Location> it2 = this.f16283a.iterator();
        while (it.hasNext()) {
            if (it2.next().getTime() != it.next().getTime()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator<Location> it = this.f16283a.iterator();
        int i7 = 17;
        while (it.hasNext()) {
            long time = it.next().getTime();
            i7 = (i7 * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i7;
    }

    @c.m0
    public List<Location> p0() {
        return this.f16283a;
    }

    @c.m0
    public String toString() {
        String strValueOf = String.valueOf(this.f16283a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.d0(parcel, 1, p0(), false);
        e1.b.b(parcel, iA);
    }
}
