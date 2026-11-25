package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LatLngCreator")
@SafeParcelable.f({1})
public final class LatLng extends AbstractSafeParcelable implements ReflectedParcelable {

    @c1.a
    @m0
    public static final Parcelable.Creator<LatLng> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    public final double f16585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    public final double f16586b;

    @SafeParcelable.b
    public LatLng(@SafeParcelable.e(id = 2) double d8, @SafeParcelable.e(id = 3) double d9) {
        if (d9 < -180.0d || d9 >= 180.0d) {
            this.f16586b = ((((d9 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f16586b = d9;
        }
        this.f16585a = Math.max(-90.0d, Math.min(90.0d, d8));
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f16585a) == Double.doubleToLongBits(latLng.f16585a) && Double.doubleToLongBits(this.f16586b) == Double.doubleToLongBits(latLng.f16586b);
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f16585a);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f16586b);
        return ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    @m0
    public String toString() {
        double d8 = this.f16585a;
        double d9 = this.f16586b;
        StringBuilder sb = new StringBuilder(60);
        sb.append("lat/lng: (");
        sb.append(d8);
        sb.append(",");
        sb.append(d9);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.r(parcel, 2, this.f16585a);
        e1.b.r(parcel, 3, this.f16586b);
        e1.b.b(parcel, iA);
    }
}
