package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f14923a = 1.0d / Math.pow(10.0d, 6.0d);

    private e() {
    }

    public static double a(long j7) {
        return (b() - j7) * f14923a;
    }

    @TargetApi(17)
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
