package com.google.android.material.shape;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class t extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f18364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18365b;

    public t(float f8, boolean z7) {
        this.f18364a = f8;
        this.f18365b = z7;
    }

    @Override // com.google.android.material.shape.g
    public void g(float f8, float f9, float f10, @m0 q qVar) {
        qVar.n(f9 - (this.f18364a * f10), 0.0f);
        qVar.n(f9, (this.f18365b ? this.f18364a : -this.f18364a) * f10);
        qVar.n(f9 + (this.f18364a * f10), 0.0f);
        qVar.n(f8, 0.0f);
    }
}
