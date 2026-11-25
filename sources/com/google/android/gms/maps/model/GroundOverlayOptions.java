package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GroundOverlayOptionsCreator")
@SafeParcelable.f({1})
public final class GroundOverlayOptions extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new r();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f16572m = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getWrappedImageDescriptorImplBinder", id = 2, type = "android.os.IBinder")
    private a f16573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getLocation", id = 3)
    private LatLng f16574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getWidth", id = 4)
    private float f16575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getHeight", id = 5)
    private float f16576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getBounds", id = 6)
    private LatLngBounds f16577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "getBearing", id = 7)
    private float f16578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(getter = "getZIndex", id = 8)
    private float f16579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(getter = "isVisible", id = 9)
    private boolean f16580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTransparency", id = 10)
    private float f16581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.c(getter = "getAnchorU", id = 11)
    private float f16582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.c(getter = "getAnchorV", id = 12)
    private float f16583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @SafeParcelable.c(getter = "isClickable", id = 13)
    private boolean f16584l;

    public GroundOverlayOptions() {
        this.f16580h = true;
        this.f16581i = 0.0f;
        this.f16582j = 0.5f;
        this.f16583k = 0.5f;
        this.f16584l = false;
    }

    private final GroundOverlayOptions w1(LatLng latLng, float f8, float f9) {
        this.f16574b = latLng;
        this.f16575c = f8;
        this.f16576d = f9;
        return this;
    }

    @m0
    public a G0() {
        return this.f16573a;
    }

    @o0
    public LatLng I0() {
        return this.f16574b;
    }

    public float J0() {
        return this.f16581i;
    }

    @m0
    public GroundOverlayOptions K(float f8) {
        this.f16578f = ((f8 % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public float L0() {
        return this.f16575c;
    }

    @m0
    public GroundOverlayOptions Q(boolean z7) {
        this.f16584l = z7;
        return this;
    }

    public float Q0() {
        return this.f16579g;
    }

    @m0
    public GroundOverlayOptions T0(@m0 a aVar) {
        com.google.android.gms.common.internal.u.l(aVar, "imageDescriptor must not be null");
        this.f16573a = aVar;
        return this;
    }

    public boolean V0() {
        return this.f16584l;
    }

    public boolean Y0() {
        return this.f16580h;
    }

    @m0
    public GroundOverlayOptions a1(@m0 LatLng latLng, float f8) {
        com.google.android.gms.common.internal.u.r(this.f16577e == null, "Position has already been set using positionFromBounds");
        com.google.android.gms.common.internal.u.b(latLng != null, "Location must be specified");
        com.google.android.gms.common.internal.u.b(f8 >= 0.0f, "Width must be non-negative");
        w1(latLng, f8, -1.0f);
        return this;
    }

    @m0
    public GroundOverlayOptions d1(@m0 LatLng latLng, float f8, float f9) {
        com.google.android.gms.common.internal.u.r(this.f16577e == null, "Position has already been set using positionFromBounds");
        com.google.android.gms.common.internal.u.b(latLng != null, "Location must be specified");
        com.google.android.gms.common.internal.u.b(f8 >= 0.0f, "Width must be non-negative");
        com.google.android.gms.common.internal.u.b(f9 >= 0.0f, "Height must be non-negative");
        w1(latLng, f8, f9);
        return this;
    }

    @m0
    public GroundOverlayOptions e1(@m0 LatLngBounds latLngBounds) {
        LatLng latLng = this.f16574b;
        com.google.android.gms.common.internal.u.r(latLng == null, "Position has already been set using position: ".concat(String.valueOf(latLng)));
        this.f16577e = latLngBounds;
        return this;
    }

    @m0
    public GroundOverlayOptions i1(float f8) {
        boolean z7 = false;
        if (f8 >= 0.0f && f8 <= 1.0f) {
            z7 = true;
        }
        com.google.android.gms.common.internal.u.b(z7, "Transparency must be in the range [0..1]");
        this.f16581i = f8;
        return this;
    }

    public float p0() {
        return this.f16582j;
    }

    @m0
    public GroundOverlayOptions q1(boolean z7) {
        this.f16580h = z7;
        return this;
    }

    public float r0() {
        return this.f16583k;
    }

    @m0
    public GroundOverlayOptions s(float f8, float f9) {
        this.f16582j = f8;
        this.f16583k = f9;
        return this;
    }

    public float s0() {
        return this.f16578f;
    }

    @m0
    public GroundOverlayOptions s1(float f8) {
        this.f16579g = f8;
        return this;
    }

    @o0
    public LatLngBounds v0() {
        return this.f16577e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.B(parcel, 2, this.f16573a.a().asBinder(), false);
        e1.b.S(parcel, 3, I0(), i7, false);
        e1.b.w(parcel, 4, L0());
        e1.b.w(parcel, 5, x0());
        e1.b.S(parcel, 6, v0(), i7, false);
        e1.b.w(parcel, 7, s0());
        e1.b.w(parcel, 8, Q0());
        e1.b.g(parcel, 9, Y0());
        e1.b.w(parcel, 10, J0());
        e1.b.w(parcel, 11, p0());
        e1.b.w(parcel, 12, r0());
        e1.b.g(parcel, 13, V0());
        e1.b.b(parcel, iA);
    }

    public float x0() {
        return this.f16576d;
    }

    @SafeParcelable.b
    GroundOverlayOptions(@SafeParcelable.e(id = 2) IBinder iBinder, @SafeParcelable.e(id = 3) LatLng latLng, @SafeParcelable.e(id = 4) float f8, @SafeParcelable.e(id = 5) float f9, @SafeParcelable.e(id = 6) LatLngBounds latLngBounds, @SafeParcelable.e(id = 7) float f10, @SafeParcelable.e(id = 8) float f11, @SafeParcelable.e(id = 9) boolean z7, @SafeParcelable.e(id = 10) float f12, @SafeParcelable.e(id = 11) float f13, @SafeParcelable.e(id = 12) float f14, @SafeParcelable.e(id = 13) boolean z8) {
        this.f16580h = true;
        this.f16581i = 0.0f;
        this.f16582j = 0.5f;
        this.f16583k = 0.5f;
        this.f16584l = false;
        this.f16573a = new a(com.google.android.gms.dynamic.d.a.u0(iBinder));
        this.f16574b = latLng;
        this.f16575c = f8;
        this.f16576d = f9;
        this.f16577e = latLngBounds;
        this.f16578f = f10;
        this.f16579g = f11;
        this.f16580h = z7;
        this.f16581i = f12;
        this.f16582j = f13;
        this.f16583k = f14;
        this.f16584l = z8;
    }
}
