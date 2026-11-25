package com.google.android.material.shape;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class i extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f18226a;

    public i(float f8) {
        this.f18226a = f8 - 0.001f;
    }

    @Override // com.google.android.material.shape.g
    boolean e() {
        return true;
    }

    @Override // com.google.android.material.shape.g
    public void g(float f8, float f9, float f10, @m0 q qVar) {
        float fSqrt = (float) ((((double) this.f18226a) * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.f18226a, 2.0d) - Math.pow(fSqrt, 2.0d));
        qVar.p(f9 - fSqrt, ((float) (-((((double) this.f18226a) * Math.sqrt(2.0d)) - ((double) this.f18226a)))) + fSqrt2);
        qVar.n(f9, (float) (-((((double) this.f18226a) * Math.sqrt(2.0d)) - ((double) this.f18226a))));
        qVar.n(f9 + fSqrt, ((float) (-((((double) this.f18226a) * Math.sqrt(2.0d)) - ((double) this.f18226a)))) + fSqrt2);
    }
}
