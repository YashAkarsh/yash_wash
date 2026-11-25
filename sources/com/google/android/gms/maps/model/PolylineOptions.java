package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "PolylineOptionsCreator")
@SafeParcelable.f({1})
public final class PolylineOptions extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new a0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getPoints", id = 2)
    private final List<LatLng> f16626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getWidth", id = 3)
    private float f16627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getColor", id = 4)
    private int f16628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getZIndex", id = 5)
    private float f16629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "isVisible", id = 6)
    private boolean f16630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "isGeodesic", id = 7)
    private boolean f16631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(getter = "isClickable", id = 8)
    private boolean f16632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStartCap", id = 9)
    private Cap f16633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(getter = "getEndCap", id = 10)
    private Cap f16634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.c(getter = "getJointType", id = 11)
    private int f16635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getPattern", id = 12)
    private List<PatternItem> f16636k;

    public PolylineOptions() {
        this.f16627b = 10.0f;
        this.f16628c = n2.f6743t;
        this.f16629d = 0.0f;
        this.f16630e = true;
        this.f16631f = false;
        this.f16632g = false;
        this.f16633h = new ButtCap();
        this.f16634i = new ButtCap();
        this.f16635j = 0;
        this.f16636k = null;
        this.f16626a = new ArrayList();
    }

    @m0
    public Cap G0() {
        return this.f16634i;
    }

    public int I0() {
        return this.f16635j;
    }

    @o0
    public List<PatternItem> J0() {
        return this.f16636k;
    }

    @m0
    public PolylineOptions K(@m0 LatLng... latLngArr) {
        com.google.android.gms.common.internal.u.l(latLngArr, "points must not be null.");
        this.f16626a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    @m0
    public List<LatLng> L0() {
        return this.f16626a;
    }

    @m0
    public PolylineOptions Q(@m0 Iterable<LatLng> iterable) {
        com.google.android.gms.common.internal.u.l(iterable, "points must not be null.");
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.f16626a.add(it.next());
        }
        return this;
    }

    @m0
    public Cap Q0() {
        return this.f16633h;
    }

    public float T0() {
        return this.f16627b;
    }

    public float V0() {
        return this.f16629d;
    }

    public boolean Y0() {
        return this.f16632g;
    }

    public boolean a1() {
        return this.f16631f;
    }

    public boolean d1() {
        return this.f16630e;
    }

    @m0
    public PolylineOptions e1(int i7) {
        this.f16635j = i7;
        return this;
    }

    @m0
    public PolylineOptions i1(@o0 List<PatternItem> list) {
        this.f16636k = list;
        return this;
    }

    @m0
    public PolylineOptions p0(boolean z7) {
        this.f16632g = z7;
        return this;
    }

    @m0
    public PolylineOptions q1(@m0 Cap cap) {
        this.f16633h = (Cap) com.google.android.gms.common.internal.u.l(cap, "startCap must not be null");
        return this;
    }

    @m0
    public PolylineOptions r0(int i7) {
        this.f16628c = i7;
        return this;
    }

    @m0
    public PolylineOptions s(@m0 LatLng latLng) {
        com.google.android.gms.common.internal.u.l(this.f16626a, "point must not be null.");
        this.f16626a.add(latLng);
        return this;
    }

    @m0
    public PolylineOptions s0(@m0 Cap cap) {
        this.f16634i = (Cap) com.google.android.gms.common.internal.u.l(cap, "endCap must not be null");
        return this;
    }

    @m0
    public PolylineOptions s1(boolean z7) {
        this.f16630e = z7;
        return this;
    }

    @m0
    public PolylineOptions v0(boolean z7) {
        this.f16631f = z7;
        return this;
    }

    @m0
    public PolylineOptions w1(float f8) {
        this.f16627b = f8;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.d0(parcel, 2, L0(), false);
        e1.b.w(parcel, 3, T0());
        e1.b.F(parcel, 4, x0());
        e1.b.w(parcel, 5, V0());
        e1.b.g(parcel, 6, d1());
        e1.b.g(parcel, 7, a1());
        e1.b.g(parcel, 8, Y0());
        e1.b.S(parcel, 9, Q0(), i7, false);
        e1.b.S(parcel, 10, G0(), i7, false);
        e1.b.F(parcel, 11, I0());
        e1.b.d0(parcel, 12, J0(), false);
        e1.b.b(parcel, iA);
    }

    public int x0() {
        return this.f16628c;
    }

    @m0
    public PolylineOptions z1(float f8) {
        this.f16629d = f8;
        return this;
    }

    @SafeParcelable.b
    PolylineOptions(@SafeParcelable.e(id = 2) List list, @SafeParcelable.e(id = 3) float f8, @SafeParcelable.e(id = 4) int i7, @SafeParcelable.e(id = 5) float f9, @SafeParcelable.e(id = 6) boolean z7, @SafeParcelable.e(id = 7) boolean z8, @SafeParcelable.e(id = 8) boolean z9, @o0 @SafeParcelable.e(id = 9) Cap cap, @o0 @SafeParcelable.e(id = 10) Cap cap2, @SafeParcelable.e(id = 11) int i8, @o0 @SafeParcelable.e(id = 12) List<PatternItem> list2) {
        this.f16627b = 10.0f;
        this.f16628c = n2.f6743t;
        this.f16629d = 0.0f;
        this.f16630e = true;
        this.f16631f = false;
        this.f16632g = false;
        this.f16633h = new ButtCap();
        this.f16634i = new ButtCap();
        this.f16626a = list;
        this.f16627b = f8;
        this.f16628c = i7;
        this.f16629d = f9;
        this.f16630e = z7;
        this.f16631f = z8;
        this.f16632g = z9;
        if (cap != null) {
            this.f16633h = cap;
        }
        if (cap2 != null) {
            this.f16634i = cap2;
        }
        this.f16635j = i8;
        this.f16636k = list2;
    }
}
