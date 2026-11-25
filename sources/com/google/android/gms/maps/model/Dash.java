package com.google.android.gms.maps.model;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class Dash extends PatternItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f16570d;

    public Dash(float f8) {
        super(0, Float.valueOf(Math.max(f8, 0.0f)));
        this.f16570d = Math.max(f8, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    @m0
    public String toString() {
        float f8 = this.f16570d;
        StringBuilder sb = new StringBuilder(30);
        sb.append("[Dash: length=");
        sb.append(f8);
        sb.append("]");
        return sb.toString();
    }
}
