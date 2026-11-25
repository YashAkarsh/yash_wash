package com.google.android.gms.maps.model;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class Gap extends PatternItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f16571d;

    public Gap(float f8) {
        super(2, Float.valueOf(Math.max(f8, 0.0f)));
        this.f16571d = Math.max(f8, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    @m0
    public String toString() {
        float f8 = this.f16571d;
        StringBuilder sb = new StringBuilder(29);
        sb.append("[Gap: length=");
        sb.append(f8);
        sb.append("]");
        return sb.toString();
    }
}
