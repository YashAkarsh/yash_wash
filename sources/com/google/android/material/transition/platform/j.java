package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f19032a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f19033b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f19034c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.shape.p f19035d = com.google.android.material.shape.p.k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.material.shape.o f19036e;

    j() {
    }

    void a(Canvas canvas) {
        canvas.clipPath(this.f19032a);
    }

    void b(float f8, com.google.android.material.shape.o oVar, com.google.android.material.shape.o oVar2, RectF rectF, RectF rectF2, RectF rectF3, l.e eVar) {
        com.google.android.material.shape.o oVarR = v.r(oVar, oVar2, rectF, rectF3, eVar.d(), eVar.c(), f8);
        this.f19036e = oVarR;
        this.f19035d.d(oVarR, 1.0f, rectF2, this.f19033b);
        this.f19035d.d(this.f19036e, 1.0f, rectF3, this.f19034c);
        this.f19032a.op(this.f19033b, this.f19034c, Path.Op.UNION);
    }

    com.google.android.material.shape.o c() {
        return this.f19036e;
    }

    Path d() {
        return this.f19032a;
    }
}
