package com.google.android.material.shape;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class l extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f18278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f18279b;

    public l(@m0 g gVar, float f8) {
        this.f18278a = gVar;
        this.f18279b = f8;
    }

    @Override // com.google.android.material.shape.g
    boolean e() {
        return this.f18278a.e();
    }

    @Override // com.google.android.material.shape.g
    public void g(float f8, float f9, float f10, @m0 q qVar) {
        this.f18278a.g(f8, f9 - this.f18279b, f10, qVar);
    }
}
