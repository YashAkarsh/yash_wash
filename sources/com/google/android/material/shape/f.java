package com.google.android.material.shape;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f18218a;

    public f() {
        this.f18218a = -1.0f;
    }

    @Override // com.google.android.material.shape.e
    public void b(@m0 q qVar, float f8, float f9, float f10) {
        qVar.q(0.0f, f10 * f9, 180.0f, 180.0f - f8);
        double d8 = f10;
        double d9 = f9;
        qVar.n((float) (Math.sin(Math.toRadians(f8)) * d8 * d9), (float) (Math.sin(Math.toRadians(90.0f - f8)) * d8 * d9));
    }

    @Deprecated
    public f(float f8) {
        this.f18218a = f8;
    }
}
