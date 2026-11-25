package com.google.android.gms.common.internal;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private static w f15811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final RootTelemetryConfiguration f15812c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private RootTelemetryConfiguration f15813a;

    private w() {
    }

    @c1.a
    @c.m0
    public static synchronized w b() {
        if (f15811b == null) {
            f15811b = new w();
        }
        return f15811b;
    }

    @c.o0
    @c1.a
    public RootTelemetryConfiguration a() {
        return this.f15813a;
    }

    @g1.d0
    public final synchronized void c(@c.o0 RootTelemetryConfiguration rootTelemetryConfiguration) {
        try {
            if (rootTelemetryConfiguration == null) {
                this.f15813a = f15812c;
                return;
            }
            RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f15813a;
            if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.s0() < rootTelemetryConfiguration.s0()) {
                this.f15813a = rootTelemetryConfiguration;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
