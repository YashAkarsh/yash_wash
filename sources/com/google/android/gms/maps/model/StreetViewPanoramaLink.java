package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "StreetViewPanoramaLinkCreator")
@SafeParcelable.f({1})
public class StreetViewPanoramaLink extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new c0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 2)
    public final String f16644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    public final float f16645b;

    @SafeParcelable.b
    public StreetViewPanoramaLink(@SafeParcelable.e(id = 2) @m0 String str, @SafeParcelable.e(id = 3) float f8) {
        this.f16644a = str;
        this.f16645b = (((double) f8) <= 0.0d ? (f8 % 360.0f) + 360.0f : f8) % 360.0f;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f16644a.equals(streetViewPanoramaLink.f16644a) && Float.floatToIntBits(this.f16645b) == Float.floatToIntBits(streetViewPanoramaLink.f16645b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(this.f16644a, Float.valueOf(this.f16645b));
    }

    @m0
    public String toString() {
        return com.google.android.gms.common.internal.s.d(this).a("panoId", this.f16644a).a("bearing", Float.valueOf(this.f16645b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.Y(parcel, 2, this.f16644a, false);
        e1.b.w(parcel, 3, this.f16645b);
        e1.b.b(parcel, iA);
    }
}
