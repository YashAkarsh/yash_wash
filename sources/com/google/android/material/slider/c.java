package com.google.android.material.slider;

import c.m0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class c implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f18409d = 1000000000000L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f18410e = 1000000000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f18411f = 1000000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f18412g = 1000;

    @Override // com.google.android.material.slider.d
    @m0
    public String a(float f8) {
        if (f8 >= 1.0E12f) {
            return String.format(Locale.US, "%.1fT", Float.valueOf(f8 / 1.0E12f));
        }
        if (f8 >= 1.0E9f) {
            return String.format(Locale.US, "%.1fB", Float.valueOf(f8 / 1.0E9f));
        }
        if (f8 >= 1000000.0f) {
            return String.format(Locale.US, "%.1fM", Float.valueOf(f8 / 1000000.0f));
        }
        return f8 >= 1000.0f ? String.format(Locale.US, "%.1fK", Float.valueOf(f8 / 1000.0f)) : String.format(Locale.US, "%.0f", Float.valueOf(f8));
    }
}
