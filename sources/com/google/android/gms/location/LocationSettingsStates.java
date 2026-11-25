package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LocationSettingsStatesCreator")
@SafeParcelable.f({1000})
public final class LocationSettingsStates extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new h1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "isGpsUsable", id = 1)
    private final boolean f16293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "isNetworkLocationUsable", id = 2)
    private final boolean f16294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "isBleUsable", id = 3)
    private final boolean f16295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "isGpsPresent", id = 4)
    private final boolean f16296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "isNetworkLocationPresent", id = 5)
    private final boolean f16297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "isBlePresent", id = 6)
    private final boolean f16298f;

    @SafeParcelable.b
    public LocationSettingsStates(@SafeParcelable.e(id = 1) boolean z7, @SafeParcelable.e(id = 2) boolean z8, @SafeParcelable.e(id = 3) boolean z9, @SafeParcelable.e(id = 4) boolean z10, @SafeParcelable.e(id = 5) boolean z11, @SafeParcelable.e(id = 6) boolean z12) {
        this.f16293a = z7;
        this.f16294b = z8;
        this.f16295c = z9;
        this.f16296d = z10;
        this.f16297e = z11;
        this.f16298f = z12;
    }

    @c.o0
    public static LocationSettingsStates s(@c.m0 Intent intent) {
        return (LocationSettingsStates) e1.c.b(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public boolean G0() {
        return this.f16294b;
    }

    public boolean K() {
        return this.f16298f;
    }

    public boolean Q() {
        return this.f16295c;
    }

    public boolean p0() {
        return this.f16296d;
    }

    public boolean r0() {
        return this.f16293a;
    }

    public boolean s0() {
        return this.f16296d || this.f16297e;
    }

    public boolean v0() {
        return this.f16293a || this.f16294b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.g(parcel, 1, r0());
        e1.b.g(parcel, 2, G0());
        e1.b.g(parcel, 3, Q());
        e1.b.g(parcel, 4, p0());
        e1.b.g(parcel, 5, x0());
        e1.b.g(parcel, 6, K());
        e1.b.b(parcel, iA);
    }

    public boolean x0() {
        return this.f16297e;
    }
}
