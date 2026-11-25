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
@SafeParcelable.a(creator = "CameraPositionCreator")
@SafeParcelable.f({1})
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {

    @m0
    public static final Parcelable.Creator<CameraPosition> CREATOR = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 2)
    public final LatLng f16547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    public final float f16548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(id = 4)
    public final float f16549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(id = 5)
    public final float f16550d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLng f16551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f16552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f16553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f16554d;

        public a() {
        }

        @m0
        public a a(float f8) {
            this.f16554d = f8;
            return this;
        }

        @m0
        public CameraPosition b() {
            return new CameraPosition(this.f16551a, this.f16552b, this.f16553c, this.f16554d);
        }

        @m0
        public a c(@m0 LatLng latLng) {
            this.f16551a = (LatLng) com.google.android.gms.common.internal.u.l(latLng, "location must not be null.");
            return this;
        }

        @m0
        public a d(float f8) {
            this.f16553c = f8;
            return this;
        }

        @m0
        public a e(float f8) {
            this.f16552b = f8;
            return this;
        }

        public a(@m0 CameraPosition cameraPosition) {
            CameraPosition cameraPosition2 = (CameraPosition) com.google.android.gms.common.internal.u.l(cameraPosition, "previous must not be null.");
            this.f16551a = cameraPosition2.f16547a;
            this.f16552b = cameraPosition2.f16548b;
            this.f16553c = cameraPosition2.f16549c;
            this.f16554d = cameraPosition2.f16550d;
        }
    }

    @SafeParcelable.b
    public CameraPosition(@SafeParcelable.e(id = 2) @m0 LatLng latLng, @SafeParcelable.e(id = 3) float f8, @SafeParcelable.e(id = 4) float f9, @SafeParcelable.e(id = 5) float f10) {
        com.google.android.gms.common.internal.u.l(latLng, "camera target must not be null.");
        com.google.android.gms.common.internal.u.c(f9 >= 0.0f && f9 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f9));
        this.f16547a = latLng;
        this.f16548b = f8;
        this.f16549c = f9 + 0.0f;
        this.f16550d = (((double) f10) <= 0.0d ? (f10 % 360.0f) + 360.0f : f10) % 360.0f;
    }

    @m0
    public static a K() {
        return new a();
    }

    @m0
    public static a Q(@m0 CameraPosition cameraPosition) {
        return new a(cameraPosition);
    }

    @o0
    public static CameraPosition p0(@o0 Context context, @o0 AttributeSet attributeSet) {
        return GoogleMapOptions.h2(context, attributeSet);
    }

    @m0
    public static final CameraPosition r0(@m0 LatLng latLng, float f8) {
        return new CameraPosition(latLng, f8, 0.0f, 0.0f);
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f16547a.equals(cameraPosition.f16547a) && Float.floatToIntBits(this.f16548b) == Float.floatToIntBits(cameraPosition.f16548b) && Float.floatToIntBits(this.f16549c) == Float.floatToIntBits(cameraPosition.f16549c) && Float.floatToIntBits(this.f16550d) == Float.floatToIntBits(cameraPosition.f16550d);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(this.f16547a, Float.valueOf(this.f16548b), Float.valueOf(this.f16549c), Float.valueOf(this.f16550d));
    }

    @m0
    public String toString() {
        return com.google.android.gms.common.internal.s.d(this).a(androidx.constraintlayout.core.motion.utils.w.a.M, this.f16547a).a("zoom", Float.valueOf(this.f16548b)).a("tilt", Float.valueOf(this.f16549c)).a("bearing", Float.valueOf(this.f16550d)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 2, this.f16547a, i7, false);
        e1.b.w(parcel, 3, this.f16548b);
        e1.b.w(parcel, 4, this.f16549c);
        e1.b.w(parcel, 5, this.f16550d);
        e1.b.b(parcel, iA);
    }
}
