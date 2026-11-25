package com.google.android.material.shape;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class n extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f18281a;

    public n() {
        this.f18281a = -1.0f;
    }

    @Override // com.google.android.material.shape.e
    public void b(@m0 q qVar, float f8, float f9, float f10) {
        qVar.q(0.0f, f10 * f9, 180.0f, 180.0f - f8);
        float f11 = f10 * 2.0f * f9;
        qVar.a(0.0f, 0.0f, f11, f11, 180.0f, f8);
    }

    @Deprecated
    public n(float f8) {
        this.f18281a = f8;
    }
}
