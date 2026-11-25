package com.google.android.gms.maps.model;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class CustomCap extends Cap {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    public final a f16568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f16569f;

    public CustomCap(@m0 a aVar) {
        this(aVar, 10.0f);
    }

    @Override // com.google.android.gms.maps.model.Cap
    @m0
    public String toString() {
        String strValueOf = String.valueOf(this.f16568e);
        float f8 = this.f16569f;
        StringBuilder sb = new StringBuilder(strValueOf.length() + 55);
        sb.append("[CustomCap: bitmapDescriptor=");
        sb.append(strValueOf);
        sb.append(" refWidth=");
        sb.append(f8);
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CustomCap(@m0 a aVar, float f8) {
        a aVar2 = (a) com.google.android.gms.common.internal.u.l(aVar, "bitmapDescriptor must not be null");
        if (f8 <= 0.0f) {
            throw new IllegalArgumentException("refWidth must be positive");
        }
        super(aVar2, f8);
        this.f16568e = aVar;
        this.f16569f = f8;
    }
}
