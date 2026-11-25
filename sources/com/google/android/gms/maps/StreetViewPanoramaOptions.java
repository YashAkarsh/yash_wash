package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "StreetViewPanoramaOptionsCreator")
@SafeParcelable.f({1})
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {

    @c.m0
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new f0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getStreetViewPanoramaCamera", id = 2)
    private StreetViewPanoramaCamera f16470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getPanoramaId", id = 3)
    private String f16471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getPosition", id = 4)
    private LatLng f16472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getRadius", id = 5)
    private Integer f16473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getUserNavigationEnabledForParcel", id = 6, type = "byte")
    private Boolean f16474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getZoomGesturesEnabledForParcel", id = 7, type = "byte")
    private Boolean f16475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getPanningGesturesEnabledForParcel", id = 8, type = "byte")
    private Boolean f16476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getStreetNamesEnabledForParcel", id = 9, type = "byte")
    private Boolean f16477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getUseViewLifecycleInFragmentForParcel", id = 10, type = "byte")
    private Boolean f16478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.c(getter = "getSource", id = 11)
    private StreetViewSource f16479j;

    public StreetViewPanoramaOptions() {
        Boolean bool = Boolean.TRUE;
        this.f16474e = bool;
        this.f16475f = bool;
        this.f16476g = bool;
        this.f16477h = bool;
        this.f16479j = StreetViewSource.f16653b;
    }

    @c.o0
    public Boolean G0() {
        return this.f16478i;
    }

    @c.o0
    public Boolean I0() {
        return this.f16474e;
    }

    @c.o0
    public Boolean J0() {
        return this.f16475f;
    }

    @c.o0
    public Boolean K() {
        return this.f16476g;
    }

    @c.m0
    public StreetViewPanoramaOptions L0(boolean z7) {
        this.f16476g = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public String Q() {
        return this.f16471b;
    }

    @c.m0
    public StreetViewPanoramaOptions Q0(@c.o0 StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f16470a = streetViewPanoramaCamera;
        return this;
    }

    @c.m0
    public StreetViewPanoramaOptions T0(@c.o0 String str) {
        this.f16471b = str;
        return this;
    }

    @c.m0
    public StreetViewPanoramaOptions V0(@c.o0 LatLng latLng) {
        this.f16472c = latLng;
        return this;
    }

    @c.m0
    public StreetViewPanoramaOptions Y0(@c.o0 LatLng latLng, @c.m0 StreetViewSource streetViewSource) {
        this.f16472c = latLng;
        this.f16479j = streetViewSource;
        return this;
    }

    @c.m0
    public StreetViewPanoramaOptions a1(@c.o0 LatLng latLng, @c.o0 Integer num) {
        this.f16472c = latLng;
        this.f16473d = num;
        return this;
    }

    @c.m0
    public StreetViewPanoramaOptions d1(@c.o0 LatLng latLng, @c.o0 Integer num, @c.m0 StreetViewSource streetViewSource) {
        this.f16472c = latLng;
        this.f16473d = num;
        this.f16479j = streetViewSource;
        return this;
    }

    @c.m0
    public StreetViewPanoramaOptions e1(boolean z7) {
        this.f16477h = Boolean.valueOf(z7);
        return this;
    }

    @c.m0
    public StreetViewPanoramaOptions i1(boolean z7) {
        this.f16478i = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public LatLng p0() {
        return this.f16472c;
    }

    @c.m0
    public StreetViewPanoramaOptions q1(boolean z7) {
        this.f16474e = Boolean.valueOf(z7);
        return this;
    }

    @c.o0
    public Integer r0() {
        return this.f16473d;
    }

    @c.m0
    public StreetViewSource s0() {
        return this.f16479j;
    }

    @c.m0
    public StreetViewPanoramaOptions s1(boolean z7) {
        this.f16475f = Boolean.valueOf(z7);
        return this;
    }

    @c.m0
    public String toString() {
        return com.google.android.gms.common.internal.s.d(this).a("PanoramaId", this.f16471b).a("Position", this.f16472c).a("Radius", this.f16473d).a("Source", this.f16479j).a("StreetViewPanoramaCamera", this.f16470a).a("UserNavigationEnabled", this.f16474e).a("ZoomGesturesEnabled", this.f16475f).a("PanningGesturesEnabled", this.f16476g).a("StreetNamesEnabled", this.f16477h).a("UseViewLifecycleInFragment", this.f16478i).toString();
    }

    @c.o0
    public Boolean v0() {
        return this.f16477h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 2, x0(), i7, false);
        e1.b.Y(parcel, 3, Q(), false);
        e1.b.S(parcel, 4, p0(), i7, false);
        e1.b.I(parcel, 5, r0(), false);
        e1.b.l(parcel, 6, com.google.android.gms.maps.internal.m.a(this.f16474e));
        e1.b.l(parcel, 7, com.google.android.gms.maps.internal.m.a(this.f16475f));
        e1.b.l(parcel, 8, com.google.android.gms.maps.internal.m.a(this.f16476g));
        e1.b.l(parcel, 9, com.google.android.gms.maps.internal.m.a(this.f16477h));
        e1.b.l(parcel, 10, com.google.android.gms.maps.internal.m.a(this.f16478i));
        e1.b.S(parcel, 11, s0(), i7, false);
        e1.b.b(parcel, iA);
    }

    @c.o0
    public StreetViewPanoramaCamera x0() {
        return this.f16470a;
    }

    @SafeParcelable.b
    StreetViewPanoramaOptions(@c.o0 @SafeParcelable.e(id = 2) StreetViewPanoramaCamera streetViewPanoramaCamera, @c.o0 @SafeParcelable.e(id = 3) String str, @c.o0 @SafeParcelable.e(id = 4) LatLng latLng, @c.o0 @SafeParcelable.e(id = 5) Integer num, @SafeParcelable.e(id = 6) byte b8, @SafeParcelable.e(id = 7) byte b9, @SafeParcelable.e(id = 8) byte b10, @SafeParcelable.e(id = 9) byte b11, @SafeParcelable.e(id = 10) byte b12, @SafeParcelable.e(id = 11) StreetViewSource streetViewSource) {
        Boolean bool = Boolean.TRUE;
        this.f16474e = bool;
        this.f16475f = bool;
        this.f16476g = bool;
        this.f16477h = bool;
        this.f16479j = StreetViewSource.f16653b;
        this.f16470a = streetViewPanoramaCamera;
        this.f16472c = latLng;
        this.f16473d = num;
        this.f16471b = str;
        this.f16474e = com.google.android.gms.maps.internal.m.b(b8);
        this.f16475f = com.google.android.gms.maps.internal.m.b(b9);
        this.f16476g = com.google.android.gms.maps.internal.m.b(b10);
        this.f16477h = com.google.android.gms.maps.internal.m.b(b11);
        this.f16478i = com.google.android.gms.maps.internal.m.b(b12);
        this.f16479j = streetViewSource;
    }
}
