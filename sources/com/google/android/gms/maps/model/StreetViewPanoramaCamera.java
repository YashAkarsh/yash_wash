package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "StreetViewPanoramaCameraCreator")
@SafeParcelable.f({1})
public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {

    @m0
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new b0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    public final float f16637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    public final float f16638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(id = 4)
    public final float f16639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreetViewPanoramaOrientation f16640d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f16642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f16643c;

        public a() {
        }

        @m0
        public a a(float f8) {
            this.f16641a = f8;
            return this;
        }

        @m0
        public StreetViewPanoramaCamera b() {
            return new StreetViewPanoramaCamera(this.f16643c, this.f16642b, this.f16641a);
        }

        @m0
        public a c(@m0 StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            com.google.android.gms.common.internal.u.l(streetViewPanoramaOrientation, "orientation must not be null.");
            this.f16642b = streetViewPanoramaOrientation.f16649a;
            this.f16641a = streetViewPanoramaOrientation.f16650b;
            return this;
        }

        @m0
        public a d(float f8) {
            this.f16642b = f8;
            return this;
        }

        @m0
        public a e(float f8) {
            this.f16643c = f8;
            return this;
        }

        public a(@m0 StreetViewPanoramaCamera streetViewPanoramaCamera) {
            com.google.android.gms.common.internal.u.l(streetViewPanoramaCamera, "StreetViewPanoramaCamera must not be null.");
            this.f16643c = streetViewPanoramaCamera.f16637a;
            this.f16641a = streetViewPanoramaCamera.f16639c;
            this.f16642b = streetViewPanoramaCamera.f16638b;
        }
    }

    @SafeParcelable.b
    public StreetViewPanoramaCamera(@SafeParcelable.e(id = 2) float f8, @SafeParcelable.e(id = 3) float f9, @SafeParcelable.e(id = 4) float f10) {
        boolean z7 = false;
        if (f9 >= -90.0f && f9 <= 90.0f) {
            z7 = true;
        }
        StringBuilder sb = new StringBuilder(62);
        sb.append("Tilt needs to be between -90 and 90 inclusive: ");
        sb.append(f9);
        com.google.android.gms.common.internal.u.b(z7, sb.toString());
        this.f16637a = ((double) f8) <= 0.0d ? 0.0f : f8;
        this.f16638b = 0.0f + f9;
        this.f16639c = (((double) f10) <= 0.0d ? (f10 % 360.0f) + 360.0f : f10) % 360.0f;
        StreetViewPanoramaOrientation.a aVar = new StreetViewPanoramaOrientation.a();
        aVar.c(f9);
        aVar.a(f10);
        this.f16640d = aVar.b();
    }

    @m0
    public static a K() {
        return new a();
    }

    @m0
    public static a Q(@m0 StreetViewPanoramaCamera streetViewPanoramaCamera) {
        return new a(streetViewPanoramaCamera);
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f16637a) == Float.floatToIntBits(streetViewPanoramaCamera.f16637a) && Float.floatToIntBits(this.f16638b) == Float.floatToIntBits(streetViewPanoramaCamera.f16638b) && Float.floatToIntBits(this.f16639c) == Float.floatToIntBits(streetViewPanoramaCamera.f16639c);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Float.valueOf(this.f16637a), Float.valueOf(this.f16638b), Float.valueOf(this.f16639c));
    }

    @m0
    public StreetViewPanoramaOrientation p0() {
        return this.f16640d;
    }

    @m0
    public String toString() {
        return com.google.android.gms.common.internal.s.d(this).a("zoom", Float.valueOf(this.f16637a)).a("tilt", Float.valueOf(this.f16638b)).a("bearing", Float.valueOf(this.f16639c)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.w(parcel, 2, this.f16637a);
        e1.b.w(parcel, 3, this.f16638b);
        e1.b.w(parcel, 4, this.f16639c);
        e1.b.b(parcel, iA);
    }
}
