package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import c.m0;
import c.v;
import com.google.android.material.progressindicator.b;

/* JADX INFO: loaded from: classes.dex */
abstract class g<S extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    S f18092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected f f18093b;

    public g(S s7) {
        this.f18092a = s7;
    }

    abstract void a(@m0 Canvas canvas, @v(from = 0.0d, to = 1.0d) float f8);

    abstract void b(@m0 Canvas canvas, @m0 Paint paint, @v(from = 0.0d, to = 1.0d) float f8, @v(from = 0.0d, to = 1.0d) float f9, @c.l int i7);

    abstract void c(@m0 Canvas canvas, @m0 Paint paint);

    abstract int d();

    abstract int e();

    protected void f(@m0 f fVar) {
        this.f18093b = fVar;
    }

    void g(@m0 Canvas canvas, @v(from = 0.0d, to = 1.0d) float f8) {
        this.f18092a.e();
        a(canvas, f8);
    }
}
