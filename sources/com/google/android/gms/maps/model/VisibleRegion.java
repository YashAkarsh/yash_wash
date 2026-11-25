package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "VisibleRegionCreator")
@SafeParcelable.f({1})
public final class VisibleRegion extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new k0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 2)
    public final LatLng f16666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 3)
    public final LatLng f16667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 4)
    public final LatLng f16668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 5)
    public final LatLng f16669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 6)
    public final LatLngBounds f16670e;

    @SafeParcelable.b
    public VisibleRegion(@SafeParcelable.e(id = 2) @m0 LatLng latLng, @SafeParcelable.e(id = 3) @m0 LatLng latLng2, @SafeParcelable.e(id = 4) @m0 LatLng latLng3, @SafeParcelable.e(id = 5) @m0 LatLng latLng4, @SafeParcelable.e(id = 6) @m0 LatLngBounds latLngBounds) {
        this.f16666a = latLng;
        this.f16667b = latLng2;
        this.f16668c = latLng3;
        this.f16669d = latLng4;
        this.f16670e = latLngBounds;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f16666a.equals(visibleRegion.f16666a) && this.f16667b.equals(visibleRegion.f16667b) && this.f16668c.equals(visibleRegion.f16668c) && this.f16669d.equals(visibleRegion.f16669d) && this.f16670e.equals(visibleRegion.f16670e);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(this.f16666a, this.f16667b, this.f16668c, this.f16669d, this.f16670e);
    }

    @m0
    public String toString() {
        return com.google.android.gms.common.internal.s.d(this).a("nearLeft", this.f16666a).a("nearRight", this.f16667b).a("farLeft", this.f16668c).a("farRight", this.f16669d).a("latLngBounds", this.f16670e).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 2, this.f16666a, i7, false);
        e1.b.S(parcel, 3, this.f16667b, i7, false);
        e1.b.S(parcel, 4, this.f16668c, i7, false);
        e1.b.S(parcel, 5, this.f16669d, i7, false);
        e1.b.S(parcel, 6, this.f16670e, i7, false);
        e1.b.b(parcel, iA);
    }
}
