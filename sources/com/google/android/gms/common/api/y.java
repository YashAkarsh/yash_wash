package com.google.android.gms.common.api;

import c.m0;
import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes.dex */
public final class y extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Feature f15520a;

    @c1.a
    public y(@m0 Feature feature) {
        this.f15520a = feature;
    }

    @Override // java.lang.Throwable
    @m0
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f15520a));
    }
}
