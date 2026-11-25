package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LocationSettingsResultCreator")
@SafeParcelable.f({1000})
public final class LocationSettingsResult extends AbstractSafeParcelable implements com.google.android.gms.common.api.t {

    @c.m0
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new g1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStatus", id = 1)
    private final Status f16291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getLocationSettingsStates", id = 2)
    private final LocationSettingsStates f16292b;

    @SafeParcelable.b
    public LocationSettingsResult(@SafeParcelable.e(id = 1) @c.m0 Status status, @c.o0 @SafeParcelable.e(id = 2) LocationSettingsStates locationSettingsStates) {
        this.f16291a = status;
        this.f16292b = locationSettingsStates;
    }

    @Override // com.google.android.gms.common.api.t
    @c.m0
    public Status G() {
        return this.f16291a;
    }

    @c.o0
    public LocationSettingsStates K() {
        return this.f16292b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 1, G(), i7, false);
        e1.b.S(parcel, 2, K(), i7, false);
        e1.b.b(parcel, iA);
    }
}
