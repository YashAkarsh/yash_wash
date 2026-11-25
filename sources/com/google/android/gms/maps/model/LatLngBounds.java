package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.GoogleMapOptions;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LatLngBoundsCreator")
@SafeParcelable.f({1})
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {

    @c1.a
    @m0
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 2)
    public final LatLng f16587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 3)
    public final LatLng f16588b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f16589a = Double.POSITIVE_INFINITY;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f16590b = Double.NEGATIVE_INFINITY;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private double f16591c = Double.NaN;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private double f16592d = Double.NaN;

        @m0
        public LatLngBounds a() {
            com.google.android.gms.common.internal.u.r(!Double.isNaN(this.f16591c), "no included points");
            return new LatLngBounds(new LatLng(this.f16589a, this.f16591c), new LatLng(this.f16590b, this.f16592d));
        }

        @m0
        public a b(@m0 LatLng latLng) {
            com.google.android.gms.common.internal.u.l(latLng, "point must not be null");
            this.f16589a = Math.min(this.f16589a, latLng.f16585a);
            this.f16590b = Math.max(this.f16590b, latLng.f16585a);
            double d8 = latLng.f16586b;
            if (Double.isNaN(this.f16591c)) {
                this.f16591c = d8;
                this.f16592d = d8;
            } else {
                double d9 = this.f16591c;
                double d10 = this.f16592d;
                if (d9 > d10 ? !(d9 <= d8 || d8 <= d10) : !(d9 <= d8 && d8 <= d10)) {
                    Parcelable.Creator<LatLngBounds> creator = LatLngBounds.CREATOR;
                    if (((d9 - d8) + 360.0d) % 360.0d < ((d8 - d10) + 360.0d) % 360.0d) {
                        this.f16591c = d8;
                    } else {
                        this.f16592d = d8;
                    }
                }
            }
            return this;
        }
    }

    @SafeParcelable.b
    public LatLngBounds(@SafeParcelable.e(id = 2) @m0 LatLng latLng, @SafeParcelable.e(id = 3) @m0 LatLng latLng2) {
        com.google.android.gms.common.internal.u.l(latLng, "southwest must not be null.");
        com.google.android.gms.common.internal.u.l(latLng2, "northeast must not be null.");
        double d8 = latLng2.f16585a;
        double d9 = latLng.f16585a;
        com.google.android.gms.common.internal.u.c(d8 >= d9, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d9), Double.valueOf(latLng2.f16585a));
        this.f16587a = latLng;
        this.f16588b = latLng2;
    }

    @m0
    public static a K() {
        return new a();
    }

    @o0
    public static LatLngBounds p0(@o0 Context context, @o0 AttributeSet attributeSet) {
        return GoogleMapOptions.i2(context, attributeSet);
    }

    private final boolean v0(double d8) {
        double d9 = this.f16587a.f16586b;
        double d10 = this.f16588b.f16586b;
        if (d9 <= d10) {
            return d9 <= d8 && d8 <= d10;
        }
        return d9 <= d8 || d8 <= d10;
    }

    public boolean Q(@m0 LatLng latLng) {
        LatLng latLng2 = (LatLng) com.google.android.gms.common.internal.u.l(latLng, "point must not be null.");
        double d8 = latLng2.f16585a;
        return this.f16587a.f16585a <= d8 && d8 <= this.f16588b.f16585a && v0(latLng2.f16586b);
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f16587a.equals(latLngBounds.f16587a) && this.f16588b.equals(latLngBounds.f16588b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(this.f16587a, this.f16588b);
    }

    @m0
    public LatLng r0() {
        LatLng latLng = this.f16587a;
        double d8 = latLng.f16585a;
        LatLng latLng2 = this.f16588b;
        double d9 = (d8 + latLng2.f16585a) / 2.0d;
        double d10 = latLng2.f16586b;
        double d11 = latLng.f16586b;
        if (d11 > d10) {
            d10 += 360.0d;
        }
        return new LatLng(d9, (d10 + d11) / 2.0d);
    }

    @m0
    public LatLngBounds s0(@m0 LatLng latLng) {
        LatLng latLng2 = (LatLng) com.google.android.gms.common.internal.u.l(latLng, "point must not be null.");
        double dMin = Math.min(this.f16587a.f16585a, latLng2.f16585a);
        double dMax = Math.max(this.f16588b.f16585a, latLng2.f16585a);
        double d8 = this.f16588b.f16586b;
        double d9 = this.f16587a.f16586b;
        double d10 = latLng2.f16586b;
        if (!v0(d10)) {
            if (((d9 - d10) + 360.0d) % 360.0d < ((d10 - d8) + 360.0d) % 360.0d) {
                d9 = d10;
            } else {
                d8 = d10;
            }
        }
        return new LatLngBounds(new LatLng(dMin, d9), new LatLng(dMax, d8));
    }

    @m0
    public String toString() {
        return com.google.android.gms.common.internal.s.d(this).a("southwest", this.f16587a).a("northeast", this.f16588b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 2, this.f16587a, i7, false);
        e1.b.S(parcel, 3, this.f16588b, i7, false);
        e1.b.b(parcel, iA);
    }
}
