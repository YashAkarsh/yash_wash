package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import c.v;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f16846a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f16847b = new androidx.interpolator.view.animation.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f16848c = new androidx.interpolator.view.animation.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f16849d = new androidx.interpolator.view.animation.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f16850e = new DecelerateInterpolator();

    public static float a(float f8, float f9, float f10) {
        return f8 + (f10 * (f9 - f8));
    }

    public static float b(float f8, float f9, @v(from = 0.0d, to = 1.0d) float f10, @v(from = 0.0d, to = 1.0d) float f11, @v(from = 0.0d, to = 1.0d) float f12) {
        if (f12 < f10) {
            return f8;
        }
        return f12 > f11 ? f9 : a(f8, f9, (f12 - f10) / (f11 - f10));
    }

    public static int c(int i7, int i8, float f8) {
        return i7 + Math.round(f8 * (i8 - i7));
    }
}
