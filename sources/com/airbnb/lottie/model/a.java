package com.airbnb.lottie.model;

import android.graphics.PointF;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f11918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF f11919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PointF f11920c;

    public a() {
        this.f11918a = new PointF();
        this.f11919b = new PointF();
        this.f11920c = new PointF();
    }

    public PointF a() {
        return this.f11918a;
    }

    public PointF b() {
        return this.f11919b;
    }

    public PointF c() {
        return this.f11920c;
    }

    public void d(float f8, float f9) {
        this.f11918a.set(f8, f9);
    }

    public void e(float f8, float f9) {
        this.f11919b.set(f8, f9);
    }

    public void f(float f8, float f9) {
        this.f11920c.set(f8, f9);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f11918a = pointF;
        this.f11919b = pointF2;
        this.f11920c = pointF3;
    }
}
