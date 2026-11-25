package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "PointOfInterestCreator")
@SafeParcelable.f({1})
public final class PointOfInterest extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 2)
    public final LatLng f16612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 3)
    public final String f16613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 4)
    public final String f16614c;

    @SafeParcelable.b
    public PointOfInterest(@SafeParcelable.e(id = 2) @m0 LatLng latLng, @SafeParcelable.e(id = 3) @m0 String str, @SafeParcelable.e(id = 4) @m0 String str2) {
        this.f16612a = latLng;
        this.f16613b = str;
        this.f16614c = str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 2, this.f16612a, i7, false);
        e1.b.Y(parcel, 3, this.f16613b, false);
        e1.b.Y(parcel, 4, this.f16614c, false);
        e1.b.b(parcel, iA);
    }
}
