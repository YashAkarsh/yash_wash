package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "CircleOptionsCreator")
@SafeParcelable.f({1})
public final class CircleOptions extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<CircleOptions> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getCenter", id = 2)
    private LatLng f16559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getRadius", id = 3)
    private double f16560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStrokeWidth", id = 4)
    private float f16561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStrokeColor", id = 5)
    private int f16562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getFillColor", id = 6)
    private int f16563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "getZIndex", id = 7)
    private float f16564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(getter = "isVisible", id = 8)
    private boolean f16565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(getter = "isClickable", id = 9)
    private boolean f16566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getStrokePattern", id = 10)
    private List<PatternItem> f16567i;

    public CircleOptions() {
        this.f16559a = null;
        this.f16560b = 0.0d;
        this.f16561c = 10.0f;
        this.f16562d = n2.f6743t;
        this.f16563e = 0;
        this.f16564f = 0.0f;
        this.f16565g = true;
        this.f16566h = false;
        this.f16567i = null;
    }

    public float G0() {
        return this.f16561c;
    }

    public float I0() {
        return this.f16564f;
    }

    public boolean J0() {
        return this.f16566h;
    }

    @m0
    public CircleOptions K(boolean z7) {
        this.f16566h = z7;
        return this;
    }

    public boolean L0() {
        return this.f16565g;
    }

    @m0
    public CircleOptions Q(int i7) {
        this.f16563e = i7;
        return this;
    }

    @m0
    public CircleOptions Q0(double d8) {
        this.f16560b = d8;
        return this;
    }

    @m0
    public CircleOptions T0(int i7) {
        this.f16562d = i7;
        return this;
    }

    @m0
    public CircleOptions V0(@o0 List<PatternItem> list) {
        this.f16567i = list;
        return this;
    }

    @m0
    public CircleOptions Y0(float f8) {
        this.f16561c = f8;
        return this;
    }

    @m0
    public CircleOptions a1(boolean z7) {
        this.f16565g = z7;
        return this;
    }

    @m0
    public CircleOptions d1(float f8) {
        this.f16564f = f8;
        return this;
    }

    @o0
    public LatLng p0() {
        return this.f16559a;
    }

    public int r0() {
        return this.f16563e;
    }

    @m0
    public CircleOptions s(@m0 LatLng latLng) {
        com.google.android.gms.common.internal.u.l(latLng, "center must not be null.");
        this.f16559a = latLng;
        return this;
    }

    public double s0() {
        return this.f16560b;
    }

    public int v0() {
        return this.f16562d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 2, p0(), i7, false);
        e1.b.r(parcel, 3, s0());
        e1.b.w(parcel, 4, G0());
        e1.b.F(parcel, 5, v0());
        e1.b.F(parcel, 6, r0());
        e1.b.w(parcel, 7, I0());
        e1.b.g(parcel, 8, L0());
        e1.b.g(parcel, 9, J0());
        e1.b.d0(parcel, 10, x0(), false);
        e1.b.b(parcel, iA);
    }

    @o0
    public List<PatternItem> x0() {
        return this.f16567i;
    }

    @SafeParcelable.b
    CircleOptions(@SafeParcelable.e(id = 2) LatLng latLng, @SafeParcelable.e(id = 3) double d8, @SafeParcelable.e(id = 4) float f8, @SafeParcelable.e(id = 5) int i7, @SafeParcelable.e(id = 6) int i8, @SafeParcelable.e(id = 7) float f9, @SafeParcelable.e(id = 8) boolean z7, @SafeParcelable.e(id = 9) boolean z8, @o0 @SafeParcelable.e(id = 10) List<PatternItem> list) {
        this.f16559a = latLng;
        this.f16560b = d8;
        this.f16561c = f8;
        this.f16562d = i7;
        this.f16563e = i8;
        this.f16564f = f9;
        this.f16565g = z7;
        this.f16566h = z8;
        this.f16567i = list;
    }
}
