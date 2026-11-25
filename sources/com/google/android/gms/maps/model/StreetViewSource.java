package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "StreetViewSourceCreator")
@SafeParcelable.f({1})
public final class StreetViewSource extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new f0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    public static final StreetViewSource f16653b = new StreetViewSource(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    public static final StreetViewSource f16654c = new StreetViewSource(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f16655d = "StreetViewSource";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getType", id = 2)
    private final int f16656a;

    @SafeParcelable.b
    public StreetViewSource(@SafeParcelable.e(id = 2) int i7) {
        this.f16656a = i7;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.f16656a == ((StreetViewSource) obj).f16656a;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16656a));
    }

    @m0
    public String toString() {
        String str;
        int i7 = this.f16656a;
        if (i7 != 0) {
            str = i7 != 1 ? String.format("UNKNOWN(%s)", Integer.valueOf(i7)) : "OUTDOOR";
        } else {
            str = MessengerShareContentUtility.PREVIEW_DEFAULT;
        }
        return String.format("StreetViewSource:%s", str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 2, this.f16656a);
        e1.b.b(parcel, iA);
    }
}
