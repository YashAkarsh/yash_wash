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
@SafeParcelable.a(creator = "PolygonOptionsCreator")
@SafeParcelable.f({1})
public final class PolygonOptions extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getPoints", id = 2)
    private final List<LatLng> f16615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getHolesForParcel", id = 3, type = "java.util.List")
    private final List<List<LatLng>> f16616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStrokeWidth", id = 4)
    private float f16617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStrokeColor", id = 5)
    private int f16618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getFillColor", id = 6)
    private int f16619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "getZIndex", id = 7)
    private float f16620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(getter = "isVisible", id = 8)
    private boolean f16621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(getter = "isGeodesic", id = 9)
    private boolean f16622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(getter = "isClickable", id = 10)
    private boolean f16623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStrokeJointType", id = 11)
    private int f16624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getStrokePattern", id = 12)
    private List<PatternItem> f16625k;

    public PolygonOptions() {
        this.f16617c = 10.0f;
        this.f16618d = n2.f6743t;
        this.f16619e = 0;
        this.f16620f = 0.0f;
        this.f16621g = true;
        this.f16622h = false;
        this.f16623i = false;
        this.f16624j = 0;
        this.f16625k = null;
        this.f16615a = new ArrayList();
        this.f16616b = new ArrayList();
    }

    @m0
    public List<List<LatLng>> G0() {
        return this.f16616b;
    }

    @m0
    public List<LatLng> I0() {
        return this.f16615a;
    }

    public int J0() {
        return this.f16618d;
    }

    @m0
    public PolygonOptions K(@m0 LatLng... latLngArr) {
        com.google.android.gms.common.internal.u.l(latLngArr, "points must not be null.");
        this.f16615a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public int L0() {
        return this.f16624j;
    }

    @m0
    public PolygonOptions Q(@m0 Iterable<LatLng> iterable) {
        com.google.android.gms.common.internal.u.l(iterable, "points must not be null.");
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.f16615a.add(it.next());
        }
        return this;
    }

    @o0
    public List<PatternItem> Q0() {
        return this.f16625k;
    }

    public float T0() {
        return this.f16617c;
    }

    public float V0() {
        return this.f16620f;
    }

    public boolean Y0() {
        return this.f16623i;
    }

    public boolean a1() {
        return this.f16622h;
    }

    public boolean d1() {
        return this.f16621g;
    }

    @m0
    public PolygonOptions e1(int i7) {
        this.f16618d = i7;
        return this;
    }

    @m0
    public PolygonOptions i1(int i7) {
        this.f16624j = i7;
        return this;
    }

    @m0
    public PolygonOptions p0(@m0 Iterable<LatLng> iterable) {
        com.google.android.gms.common.internal.u.l(iterable, "points must not be null.");
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.f16616b.add(arrayList);
        return this;
    }

    @m0
    public PolygonOptions q1(@o0 List<PatternItem> list) {
        this.f16625k = list;
        return this;
    }

    @m0
    public PolygonOptions r0(boolean z7) {
        this.f16623i = z7;
        return this;
    }

    @m0
    public PolygonOptions s(@m0 LatLng latLng) {
        com.google.android.gms.common.internal.u.l(latLng, "point must not be null.");
        this.f16615a.add(latLng);
        return this;
    }

    @m0
    public PolygonOptions s0(int i7) {
        this.f16619e = i7;
        return this;
    }

    @m0
    public PolygonOptions s1(float f8) {
        this.f16617c = f8;
        return this;
    }

    @m0
    public PolygonOptions v0(boolean z7) {
        this.f16622h = z7;
        return this;
    }

    @m0
    public PolygonOptions w1(boolean z7) {
        this.f16621g = z7;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.d0(parcel, 2, I0(), false);
        e1.b.J(parcel, 3, this.f16616b, false);
        e1.b.w(parcel, 4, T0());
        e1.b.F(parcel, 5, J0());
        e1.b.F(parcel, 6, x0());
        e1.b.w(parcel, 7, V0());
        e1.b.g(parcel, 8, d1());
        e1.b.g(parcel, 9, a1());
        e1.b.g(parcel, 10, Y0());
        e1.b.F(parcel, 11, L0());
        e1.b.d0(parcel, 12, Q0(), false);
        e1.b.b(parcel, iA);
    }

    public int x0() {
        return this.f16619e;
    }

    @m0
    public PolygonOptions z1(float f8) {
        this.f16620f = f8;
        return this;
    }

    @SafeParcelable.b
    PolygonOptions(@SafeParcelable.e(id = 2) List<LatLng> list, @SafeParcelable.e(id = 3) List list2, @SafeParcelable.e(id = 4) float f8, @SafeParcelable.e(id = 5) int i7, @SafeParcelable.e(id = 6) int i8, @SafeParcelable.e(id = 7) float f9, @SafeParcelable.e(id = 8) boolean z7, @SafeParcelable.e(id = 9) boolean z8, @SafeParcelable.e(id = 10) boolean z9, @SafeParcelable.e(id = 11) int i9, @o0 @SafeParcelable.e(id = 12) List<PatternItem> list3) {
        this.f16615a = list;
        this.f16616b = list2;
        this.f16617c = f8;
        this.f16618d = i7;
        this.f16619e = i8;
        this.f16620f = f9;
        this.f16621g = z7;
        this.f16622h = z8;
        this.f16623i = z9;
        this.f16624j = i9;
        this.f16625k = list3;
    }
}
