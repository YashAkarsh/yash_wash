package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "StreetViewPanoramaLocationCreator")
@SafeParcelable.f({1})
public class StreetViewPanoramaLocation extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 2)
    public final StreetViewPanoramaLink[] f16646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 3)
    public final LatLng f16647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 4)
    public final String f16648c;

    @SafeParcelable.b
    public StreetViewPanoramaLocation(@SafeParcelable.e(id = 2) @m0 StreetViewPanoramaLink[] streetViewPanoramaLinkArr, @SafeParcelable.e(id = 3) @m0 LatLng latLng, @SafeParcelable.e(id = 4) @m0 String str) {
        this.f16646a = streetViewPanoramaLinkArr;
        this.f16647b = latLng;
        this.f16648c = str;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f16648c.equals(streetViewPanoramaLocation.f16648c) && this.f16647b.equals(streetViewPanoramaLocation.f16647b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(this.f16647b, this.f16648c);
    }

    @m0
    public String toString() {
        return com.google.android.gms.common.internal.s.d(this).a("panoId", this.f16648c).a("position", this.f16647b.toString()).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.c0(parcel, 2, this.f16646a, i7, false);
        e1.b.S(parcel, 3, this.f16647b, i7, false);
        e1.b.Y(parcel, 4, this.f16648c, false);
        e1.b.b(parcel, iA);
    }
}
