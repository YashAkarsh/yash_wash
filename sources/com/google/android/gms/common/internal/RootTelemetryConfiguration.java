package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "RootTelemetryConfigurationCreator")
@c1.a
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @c1.a
    @c.m0
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new n1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getVersion", id = 1)
    private final int f15651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMethodInvocationTelemetryEnabled", id = 2)
    private final boolean f15652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMethodTimingTelemetryEnabled", id = 3)
    private final boolean f15653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getBatchPeriodMillis", id = 4)
    private final int f15654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMaxMethodInvocationsInBatch", id = 5)
    private final int f15655e;

    @SafeParcelable.b
    public RootTelemetryConfiguration(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) boolean z7, @SafeParcelable.e(id = 3) boolean z8, @SafeParcelable.e(id = 4) int i8, @SafeParcelable.e(id = 5) int i9) {
        this.f15651a = i7;
        this.f15652b = z7;
        this.f15653c = z8;
        this.f15654d = i8;
        this.f15655e = i9;
    }

    @c1.a
    public int K() {
        return this.f15654d;
    }

    @c1.a
    public int Q() {
        return this.f15655e;
    }

    @c1.a
    public boolean p0() {
        return this.f15652b;
    }

    @c1.a
    public boolean r0() {
        return this.f15653c;
    }

    @c1.a
    public int s0() {
        return this.f15651a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, s0());
        e1.b.g(parcel, 2, p0());
        e1.b.g(parcel, 3, r0());
        e1.b.F(parcel, 4, K());
        e1.b.F(parcel, 5, Q());
        e1.b.b(parcel, iA);
    }
}
