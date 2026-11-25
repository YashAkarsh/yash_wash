package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ConnectionTelemetryConfigurationCreator")
@c1.a
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @c1.a
    @c.m0
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new y1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getRootTelemetryConfiguration", id = 1)
    private final RootTelemetryConfiguration f15620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMethodInvocationTelemetryEnabled", id = 2)
    private final boolean f15621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMethodTimingTelemetryEnabled", id = 3)
    private final boolean f15622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getMethodInvocationMethodKeyAllowlist", id = 4)
    private final int[] f15623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getMaxMethodInvocationsLogged", id = 5)
    private final int f15624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getMethodInvocationMethodKeyDisallowlist", id = 6)
    private final int[] f15625f;

    @SafeParcelable.b
    public ConnectionTelemetryConfiguration(@SafeParcelable.e(id = 1) @c.m0 RootTelemetryConfiguration rootTelemetryConfiguration, @SafeParcelable.e(id = 2) boolean z7, @SafeParcelable.e(id = 3) boolean z8, @c.o0 @SafeParcelable.e(id = 4) int[] iArr, @SafeParcelable.e(id = 5) int i7, @c.o0 @SafeParcelable.e(id = 6) int[] iArr2) {
        this.f15620a = rootTelemetryConfiguration;
        this.f15621b = z7;
        this.f15622c = z8;
        this.f15623d = iArr;
        this.f15624e = i7;
        this.f15625f = iArr2;
    }

    @c1.a
    public int K() {
        return this.f15624e;
    }

    @c.o0
    @c1.a
    public int[] Q() {
        return this.f15623d;
    }

    @c.o0
    @c1.a
    public int[] p0() {
        return this.f15625f;
    }

    @c1.a
    public boolean r0() {
        return this.f15621b;
    }

    @c1.a
    public boolean s0() {
        return this.f15622c;
    }

    @c.m0
    public final RootTelemetryConfiguration v0() {
        return this.f15620a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 1, this.f15620a, i7, false);
        e1.b.g(parcel, 2, r0());
        e1.b.g(parcel, 3, s0());
        e1.b.G(parcel, 4, Q(), false);
        e1.b.F(parcel, 5, K());
        e1.b.G(parcel, 6, p0(), false);
        e1.b.b(parcel, iA);
    }
}
