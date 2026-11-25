package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import e1.b;
import g1.d0;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "PlaceReportCreator")
public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    private final int f16399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getPlaceId", id = 2)
    private final String f16400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTag", id = 3)
    private final String f16401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getSource", id = 4)
    private final String f16402d;

    @SafeParcelable.b
    PlaceReport(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) String str2, @SafeParcelable.e(id = 4) String str3) {
        this.f16399a = i7;
        this.f16400b = str;
        this.f16401c = str2;
        this.f16402d = str3;
    }

    @d0
    public static PlaceReport s(String str, String str2) {
        u.k(str);
        u.g(str2);
        u.g("unknown");
        u.b(true, "Invalid source");
        return new PlaceReport(1, str, str2, "unknown");
    }

    public String K() {
        return this.f16400b;
    }

    public String Q() {
        return this.f16401c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return s.b(this.f16400b, placeReport.f16400b) && s.b(this.f16401c, placeReport.f16401c) && s.b(this.f16402d, placeReport.f16402d);
    }

    public int hashCode() {
        return s.c(this.f16400b, this.f16401c, this.f16402d);
    }

    public String toString() {
        s.a aVarD = s.d(this);
        aVarD.a("placeId", this.f16400b);
        aVarD.a(ViewHierarchyConstants.TAG_KEY, this.f16401c);
        if (!"unknown".equals(this.f16402d)) {
            aVarD.a(ShareConstants.FEED_SOURCE_PARAM, this.f16402d);
        }
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = b.a(parcel);
        b.F(parcel, 1, this.f16399a);
        b.Y(parcel, 2, K(), false);
        b.Y(parcel, 3, Q(), false);
        b.Y(parcel, 4, this.f16402d, false);
        b.b(parcel, iA);
    }
}
