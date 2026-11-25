package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "StreetViewPanoramaOrientationCreator")
@SafeParcelable.f({1})
public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    public final float f16649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    public final float f16650b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f16652b;

        public a() {
        }

        @m0
        public a a(float f8) {
            this.f16651a = f8;
            return this;
        }

        @m0
        public StreetViewPanoramaOrientation b() {
            return new StreetViewPanoramaOrientation(this.f16652b, this.f16651a);
        }

        @m0
        public a c(float f8) {
            this.f16652b = f8;
            return this;
        }

        public a(@m0 StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            com.google.android.gms.common.internal.u.l(streetViewPanoramaOrientation, "StreetViewPanoramaOrientation must not be null.");
            this.f16651a = streetViewPanoramaOrientation.f16650b;
            this.f16652b = streetViewPanoramaOrientation.f16649a;
        }
    }

    @SafeParcelable.b
    public StreetViewPanoramaOrientation(@SafeParcelable.e(id = 2) float f8, @SafeParcelable.e(id = 3) float f9) {
        boolean z7 = false;
        if (f8 >= -90.0f && f8 <= 90.0f) {
            z7 = true;
        }
        StringBuilder sb = new StringBuilder(62);
        sb.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb.append(f8);
        com.google.android.gms.common.internal.u.b(z7, sb.toString());
        this.f16649a = f8 + 0.0f;
        this.f16650b = (((double) f9) <= 0.0d ? (f9 % 360.0f) + 360.0f : f9) % 360.0f;
    }

    @m0
    public static a K() {
        return new a();
    }

    @m0
    public static a Q(@m0 StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        return new a(streetViewPanoramaOrientation);
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f16649a) == Float.floatToIntBits(streetViewPanoramaOrientation.f16649a) && Float.floatToIntBits(this.f16650b) == Float.floatToIntBits(streetViewPanoramaOrientation.f16650b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Float.valueOf(this.f16649a), Float.valueOf(this.f16650b));
    }

    @m0
    public String toString() {
        return com.google.android.gms.common.internal.s.d(this).a("tilt", Float.valueOf(this.f16649a)).a("bearing", Float.valueOf(this.f16650b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.w(parcel, 2, this.f16649a);
        e1.b.w(parcel, 3, this.f16650b);
        e1.b.b(parcel, iA);
    }
}
