package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import c.o0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g implements e, com.airbnb.lottie.animation.keyframe.a.b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f11610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f11611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f11612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f11614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<n> f11615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<Integer, Integer> f11616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<Integer, Integer> f11617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> f11618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.h f11619j;

    public g(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.m mVar) {
        Path path = new Path();
        this.f11610a = path;
        this.f11611b = new com.airbnb.lottie.animation.a(1);
        this.f11615f = new ArrayList();
        this.f11612c = aVar;
        this.f11613d = mVar.d();
        this.f11614e = mVar.f();
        this.f11619j = hVar;
        if (mVar.b() == null || mVar.e() == null) {
            this.f11616g = null;
            this.f11617h = null;
            return;
        }
        path.setFillType(mVar.c());
        com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVarA = mVar.b().a();
        this.f11616g = aVarA;
        aVarA.a(this);
        aVar.j(aVarA);
        com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVarA2 = mVar.e().a();
        this.f11617h = aVarA2;
        aVarA2.a(this);
        aVar.j(aVarA2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        this.f11619j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
        for (int i7 = 0; i7 < list2.size(); i7++) {
            c cVar = list2.get(i7);
            if (cVar instanceof n) {
                this.f11615f.add((n) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.f
    public void c(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.utils.i.l(eVar, i7, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        this.f11610a.reset();
        for (int i7 = 0; i7 < this.f11615f.size(); i7++) {
            this.f11610a.addPath(this.f11615f.get(i7).g(), matrix);
        }
        this.f11610a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void f(Canvas canvas, Matrix matrix, int i7) {
        if (this.f11614e) {
            return;
        }
        com.airbnb.lottie.e.a("FillContent#draw");
        this.f11611b.setColor(((com.airbnb.lottie.animation.keyframe.b) this.f11616g).o());
        this.f11611b.setAlpha(com.airbnb.lottie.utils.i.c((int) ((((i7 / 255.0f) * this.f11617h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.f11618i;
        if (aVar != null) {
            this.f11611b.setColorFilter(aVar.h());
        }
        this.f11610a.reset();
        for (int i8 = 0; i8 < this.f11615f.size(); i8++) {
            this.f11610a.addPath(this.f11615f.get(i8).g(), matrix);
        }
        canvas.drawPath(this.f11610a, this.f11611b);
        com.airbnb.lottie.e.b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11613d;
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        if (t7 == com.airbnb.lottie.m.f11881a) {
            this.f11616g.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.f11884d) {
            this.f11617h.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.C) {
            com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.f11618i;
            if (aVar != null) {
                this.f11612c.D(aVar);
            }
            if (jVar == null) {
                this.f11618i = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.p pVar = new com.airbnb.lottie.animation.keyframe.p(jVar);
            this.f11618i = pVar;
            pVar.a(this);
            this.f11612c.j(this.f11618i);
        }
    }
}
