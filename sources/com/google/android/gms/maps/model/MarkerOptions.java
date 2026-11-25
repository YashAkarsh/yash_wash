package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "MarkerOptionsCreator")
@SafeParcelable.f({1})
public final class MarkerOptions extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getPosition", id = 2)
    private LatLng f16595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getTitle", id = 3)
    private String f16596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getSnippet", id = 4)
    private String f16597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getWrappedIconDescriptorImplBinder", id = 5, type = "android.os.IBinder")
    private a f16598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getAnchorU", id = 6)
    private float f16599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "getAnchorV", id = 7)
    private float f16600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(getter = "isDraggable", id = 8)
    private boolean f16601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(getter = "isVisible", id = 9)
    private boolean f16602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(getter = "isFlat", id = 10)
    private boolean f16603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.c(getter = "getRotation", id = 11)
    private float f16604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "0.5f", getter = "getInfoWindowAnchorU", id = 12)
    private float f16605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @SafeParcelable.c(getter = "getInfoWindowAnchorV", id = 13)
    private float f16606l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "1.0f", getter = "getAlpha", id = 14)
    private float f16607m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @SafeParcelable.c(getter = "getZIndex", id = 15)
    private float f16608n;

    public MarkerOptions() {
        this.f16599e = 0.5f;
        this.f16600f = 1.0f;
        this.f16602h = true;
        this.f16603i = false;
        this.f16604j = 0.0f;
        this.f16605k = 0.5f;
        this.f16606l = 0.0f;
        this.f16607m = 1.0f;
    }

    @m0
    public MarkerOptions A1(boolean z7) {
        this.f16602h = z7;
        return this;
    }

    @m0
    public MarkerOptions B1(float f8) {
        this.f16608n = f8;
        return this;
    }

    public float G0() {
        return this.f16605k;
    }

    public float I0() {
        return this.f16606l;
    }

    @m0
    public LatLng J0() {
        return this.f16595a;
    }

    @m0
    public MarkerOptions K(float f8, float f9) {
        this.f16599e = f8;
        this.f16600f = f9;
        return this;
    }

    public float L0() {
        return this.f16604j;
    }

    @m0
    public MarkerOptions Q(boolean z7) {
        this.f16601g = z7;
        return this;
    }

    @o0
    public String Q0() {
        return this.f16597c;
    }

    @o0
    public String T0() {
        return this.f16596b;
    }

    public float V0() {
        return this.f16608n;
    }

    @m0
    public MarkerOptions Y0(@o0 a aVar) {
        this.f16598d = aVar;
        return this;
    }

    @m0
    public MarkerOptions a1(float f8, float f9) {
        this.f16605k = f8;
        this.f16606l = f9;
        return this;
    }

    public boolean d1() {
        return this.f16601g;
    }

    public boolean e1() {
        return this.f16603i;
    }

    public boolean i1() {
        return this.f16602h;
    }

    @m0
    public MarkerOptions p0(boolean z7) {
        this.f16603i = z7;
        return this;
    }

    @m0
    public MarkerOptions q1(@m0 LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        this.f16595a = latLng;
        return this;
    }

    public float r0() {
        return this.f16607m;
    }

    @m0
    public MarkerOptions s(float f8) {
        this.f16607m = f8;
        return this;
    }

    public float s0() {
        return this.f16599e;
    }

    @m0
    public MarkerOptions s1(float f8) {
        this.f16604j = f8;
        return this;
    }

    public float v0() {
        return this.f16600f;
    }

    @m0
    public MarkerOptions w1(@o0 String str) {
        this.f16597c = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 2, J0(), i7, false);
        e1.b.Y(parcel, 3, T0(), false);
        e1.b.Y(parcel, 4, Q0(), false);
        a aVar = this.f16598d;
        e1.b.B(parcel, 5, aVar == null ? null : aVar.a().asBinder(), false);
        e1.b.w(parcel, 6, s0());
        e1.b.w(parcel, 7, v0());
        e1.b.g(parcel, 8, d1());
        e1.b.g(parcel, 9, i1());
        e1.b.g(parcel, 10, e1());
        e1.b.w(parcel, 11, L0());
        e1.b.w(parcel, 12, G0());
        e1.b.w(parcel, 13, I0());
        e1.b.w(parcel, 14, r0());
        e1.b.w(parcel, 15, V0());
        e1.b.b(parcel, iA);
    }

    @o0
    public a x0() {
        return this.f16598d;
    }

    @m0
    public MarkerOptions z1(@o0 String str) {
        this.f16596b = str;
        return this;
    }

    @SafeParcelable.b
    MarkerOptions(@SafeParcelable.e(id = 2) LatLng latLng, @SafeParcelable.e(id = 3) String str, @SafeParcelable.e(id = 4) String str2, @o0 @SafeParcelable.e(id = 5) IBinder iBinder, @SafeParcelable.e(id = 6) float f8, @SafeParcelable.e(id = 7) float f9, @SafeParcelable.e(id = 8) boolean z7, @SafeParcelable.e(id = 9) boolean z8, @SafeParcelable.e(id = 10) boolean z9, @SafeParcelable.e(id = 11) float f10, @SafeParcelable.e(id = 12) float f11, @SafeParcelable.e(id = 13) float f12, @SafeParcelable.e(id = 14) float f13, @SafeParcelable.e(id = 15) float f14) {
        this.f16599e = 0.5f;
        this.f16600f = 1.0f;
        this.f16602h = true;
        this.f16603i = false;
        this.f16604j = 0.0f;
        this.f16605k = 0.5f;
        this.f16606l = 0.0f;
        this.f16607m = 1.0f;
        this.f16595a = latLng;
        this.f16596b = str;
        this.f16597c = str2;
        if (iBinder == null) {
            this.f16598d = null;
        } else {
            this.f16598d = new a(com.google.android.gms.dynamic.d.a.u0(iBinder));
        }
        this.f16599e = f8;
        this.f16600f = f9;
        this.f16601g = z7;
        this.f16602h = z8;
        this.f16603i = z9;
        this.f16604j = f10;
        this.f16605k = f11;
        this.f16606l = f12;
        this.f16607m = f13;
        this.f16608n = f14;
    }
}
