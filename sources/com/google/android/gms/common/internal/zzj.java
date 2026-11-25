package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ConnectionInfoCreator")
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new x1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(id = 1)
    Bundle f15841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    Feature[] f15842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "0", id = 3)
    int f15843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(id = 4)
    ConnectionTelemetryConfiguration f15844d;

    @SafeParcelable.b
    zzj(@SafeParcelable.e(id = 1) Bundle bundle, @SafeParcelable.e(id = 2) Feature[] featureArr, @SafeParcelable.e(id = 3) int i7, @c.o0 @SafeParcelable.e(id = 4) ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f15841a = bundle;
        this.f15842b = featureArr;
        this.f15843c = i7;
        this.f15844d = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.k(parcel, 1, this.f15841a, false);
        e1.b.c0(parcel, 2, this.f15842b, i7, false);
        e1.b.F(parcel, 3, this.f15843c);
        e1.b.S(parcel, 4, this.f15844d, i7, false);
        e1.b.b(parcel, iA);
    }

    public zzj() {
    }
}
