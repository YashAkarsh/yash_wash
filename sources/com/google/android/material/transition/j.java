package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f18939a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f18940b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f18941c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.shape.p f18942d = com.google.android.material.shape.p.k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.material.shape.o f18943e;

    j() {
    }

    void a(Canvas canvas) {
        canvas.clipPath(this.f18939a);
    }

    void b(float f8, com.google.android.material.shape.o oVar, com.google.android.material.shape.o oVar2, RectF rectF, RectF rectF2, RectF rectF3, l.e eVar) {
        com.google.android.material.shape.o oVarR = u.r(oVar, oVar2, rectF, rectF3, eVar.d(), eVar.c(), f8);
        this.f18943e = oVarR;
        this.f18942d.d(oVarR, 1.0f, rectF2, this.f18940b);
        this.f18942d.d(this.f18943e, 1.0f, rectF3, this.f18941c);
        this.f18939a.op(this.f18940b, this.f18941c, Path.Op.UNION);
    }

    com.google.android.material.shape.o c() {
        return this.f18943e;
    }

    Path d() {
        return this.f18939a;
    }
}
