package com.google.android.gms.location;

/* JADX INFO: loaded from: classes.dex */
public final class g extends com.google.android.gms.common.api.h {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f16352t = 1000;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f16353u = 1001;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f16354v = 1002;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f16355w = 1004;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f16356x = 1005;

    private g() {
    }

    @c.m0
    public static String a(int i7) {
        switch (i7) {
            case 1000:
                return "GEOFENCE_NOT_AVAILABLE";
            case 1001:
                return "GEOFENCE_TOO_MANY_GEOFENCES";
            case 1002:
                return "GEOFENCE_TOO_MANY_PENDING_INTENTS";
            case 1003:
            default:
                return com.google.android.gms.common.api.h.a(i7);
            case 1004:
                return "GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION";
        }
    }
}
