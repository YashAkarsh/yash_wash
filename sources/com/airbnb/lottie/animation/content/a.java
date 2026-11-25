package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import c.o0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.airbnb.lottie.animation.keyframe.a.b, k, e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.h f11577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final com.airbnb.lottie.model.layer.a f11578f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f11580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Paint f11581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Integer> f11583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<com.airbnb.lottie.animation.keyframe.a<?, Float>> f11584l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11585m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> f11586n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PathMeasure f11573a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f11574b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f11575c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f11576d = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<b> f11579g = new ArrayList();

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<n> f11587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        private final t f11588b;

        private b(@o0 t tVar) {
            this.f11587a = new ArrayList();
            this.f11588b = tVar;
        }
    }

    a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f8, com.airbnb.lottie.model.animatable.d dVar, com.airbnb.lottie.model.animatable.b bVar, List<com.airbnb.lottie.model.animatable.b> list, com.airbnb.lottie.model.animatable.b bVar2) {
        com.airbnb.lottie.animation.a aVar2 = new com.airbnb.lottie.animation.a(1);
        this.f11581i = aVar2;
        this.f11577e = hVar;
        this.f11578f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f8);
        this.f11583k = dVar.a();
        this.f11582j = bVar.a();
        if (bVar2 == null) {
            this.f11585m = null;
        } else {
            this.f11585m = bVar2.a();
        }
        this.f11584l = new ArrayList(list.size());
        this.f11580h = new float[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            this.f11584l.add(list.get(i7).a());
        }
        aVar.j(this.f11583k);
        aVar.j(this.f11582j);
        for (int i8 = 0; i8 < this.f11584l.size(); i8++) {
            aVar.j(this.f11584l.get(i8));
        }
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar3 = this.f11585m;
        if (aVar3 != null) {
            aVar.j(aVar3);
        }
        this.f11583k.a(this);
        this.f11582j.a(this);
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.f11584l.get(i9).a(this);
        }
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar4 = this.f11585m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
    }

    private void e(Matrix matrix) {
        com.airbnb.lottie.e.a("StrokeContent#applyDashPattern");
        if (this.f11584l.isEmpty()) {
            com.airbnb.lottie.e.b("StrokeContent#applyDashPattern");
            return;
        }
        float fG = com.airbnb.lottie.utils.j.g(matrix);
        for (int i7 = 0; i7 < this.f11584l.size(); i7++) {
            this.f11580h[i7] = this.f11584l.get(i7).h().floatValue();
            if (i7 % 2 == 0) {
                float[] fArr = this.f11580h;
                if (fArr[i7] < 1.0f) {
                    fArr[i7] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f11580h;
                if (fArr2[i7] < 0.1f) {
                    fArr2[i7] = 0.1f;
                }
            }
            float[] fArr3 = this.f11580h;
            fArr3[i7] = fArr3[i7] * fG;
        }
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar = this.f11585m;
        this.f11581i.setPathEffect(new DashPathEffect(this.f11580h, aVar == null ? 0.0f : fG * aVar.h().floatValue()));
        com.airbnb.lottie.e.b("StrokeContent#applyDashPattern");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00f6  */
    private void i(Canvas canvas, b bVar, Matrix matrix) {
        float f8;
        com.airbnb.lottie.e.a("StrokeContent#applyTrimPath");
        if (bVar.f11588b == null) {
            com.airbnb.lottie.e.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f11574b.reset();
        for (int size = bVar.f11587a.size() - 1; size >= 0; size--) {
            this.f11574b.addPath(((n) bVar.f11587a.get(size)).g(), matrix);
        }
        this.f11573a.setPath(this.f11574b, false);
        float length = this.f11573a.getLength();
        while (this.f11573a.nextContour()) {
            length += this.f11573a.getLength();
        }
        float fFloatValue = (bVar.f11588b.h().h().floatValue() * length) / 360.0f;
        float fFloatValue2 = ((bVar.f11588b.i().h().floatValue() * length) / 100.0f) + fFloatValue;
        float fFloatValue3 = ((bVar.f11588b.e().h().floatValue() * length) / 100.0f) + fFloatValue;
        float f9 = 0.0f;
        for (int size2 = bVar.f11587a.size() - 1; size2 >= 0; size2--) {
            this.f11575c.set(((n) bVar.f11587a.get(size2)).g());
            this.f11575c.transform(matrix);
            this.f11573a.setPath(this.f11575c, false);
            float length2 = this.f11573a.getLength();
            if (fFloatValue3 > length) {
                float f10 = fFloatValue3 - length;
                if (f10 >= f9 + length2 || f9 >= f10) {
                    f8 = f9 + length2;
                    if (f8 < fFloatValue2 && f9 <= fFloatValue3) {
                        if (f8 > fFloatValue3 || fFloatValue2 >= f9) {
                            com.airbnb.lottie.utils.j.a(this.f11575c, fFloatValue2 < f9 ? 0.0f : (fFloatValue2 - f9) / length2, fFloatValue3 <= f8 ? (fFloatValue3 - f9) / length2 : 1.0f, 0.0f);
                            canvas.drawPath(this.f11575c, this.f11581i);
                        } else {
                            canvas.drawPath(this.f11575c, this.f11581i);
                        }
                    }
                } else {
                    com.airbnb.lottie.utils.j.a(this.f11575c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f10 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f11575c, this.f11581i);
                }
            } else {
                f8 = f9 + length2;
                if (f8 < fFloatValue2) {
                }
            }
            f9 += length2;
        }
        com.airbnb.lottie.e.b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        this.f11577e.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
        t tVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof t) {
                t tVar2 = (t) cVar;
                if (tVar2.j() == com.airbnb.lottie.model.content.q.a.INDIVIDUALLY) {
                    tVar = tVar2;
                }
            }
        }
        if (tVar != null) {
            tVar.c(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof t) {
                t tVar3 = (t) cVar2;
                if (tVar3.j() == com.airbnb.lottie.model.content.q.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f11579g.add(bVar);
                    }
                    bVar = new b(tVar3);
                    tVar3.c(this);
                } else if (!(cVar2 instanceof n)) {
                    if (bVar == null) {
                        bVar = new b(tVar);
                    }
                    bVar.f11587a.add((n) cVar2);
                }
            } else if (!(cVar2 instanceof n)) {
                if (bVar == null) {
                    bVar = new b(tVar);
                }
                bVar.f11587a.add((n) cVar2);
            }
        }
        if (bVar != null) {
            this.f11579g.add(bVar);
        }
    }

    @Override // com.airbnb.lottie.model.f
    public void c(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.utils.i.l(eVar, i7, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        com.airbnb.lottie.e.a("StrokeContent#getBounds");
        this.f11574b.reset();
        for (int i7 = 0; i7 < this.f11579g.size(); i7++) {
            b bVar = this.f11579g.get(i7);
            for (int i8 = 0; i8 < bVar.f11587a.size(); i8++) {
                this.f11574b.addPath(((n) bVar.f11587a.get(i8)).g(), matrix);
            }
        }
        this.f11574b.computeBounds(this.f11576d, false);
        float fO = ((com.airbnb.lottie.animation.keyframe.c) this.f11582j).o();
        RectF rectF2 = this.f11576d;
        float f8 = fO / 2.0f;
        rectF2.set(rectF2.left - f8, rectF2.top - f8, rectF2.right + f8, rectF2.bottom + f8);
        rectF.set(this.f11576d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.e.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void f(Canvas canvas, Matrix matrix, int i7) {
        com.airbnb.lottie.e.a("StrokeContent#draw");
        if (com.airbnb.lottie.utils.j.h(matrix)) {
            com.airbnb.lottie.e.b("StrokeContent#draw");
            return;
        }
        this.f11581i.setAlpha(com.airbnb.lottie.utils.i.c((int) ((((i7 / 255.0f) * ((com.airbnb.lottie.animation.keyframe.e) this.f11583k).o()) / 100.0f) * 255.0f), 0, 255));
        this.f11581i.setStrokeWidth(((com.airbnb.lottie.animation.keyframe.c) this.f11582j).o() * com.airbnb.lottie.utils.j.g(matrix));
        if (this.f11581i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.e.b("StrokeContent#draw");
            return;
        }
        e(matrix);
        com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.f11586n;
        if (aVar != null) {
            this.f11581i.setColorFilter(aVar.h());
        }
        for (int i8 = 0; i8 < this.f11579g.size(); i8++) {
            b bVar = this.f11579g.get(i8);
            if (bVar.f11588b != null) {
                i(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.e.a("StrokeContent#buildPath");
                this.f11574b.reset();
                for (int size = bVar.f11587a.size() - 1; size >= 0; size--) {
                    this.f11574b.addPath(((n) bVar.f11587a.get(size)).g(), matrix);
                }
                com.airbnb.lottie.e.b("StrokeContent#buildPath");
                com.airbnb.lottie.e.a("StrokeContent#drawPath");
                canvas.drawPath(this.f11574b, this.f11581i);
                com.airbnb.lottie.e.b("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.e.b("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.model.f
    @c.i
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        if (t7 == com.airbnb.lottie.m.f11884d) {
            this.f11583k.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.f11895o) {
            this.f11582j.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.C) {
            com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.f11586n;
            if (aVar != null) {
                this.f11578f.D(aVar);
            }
            if (jVar == null) {
                this.f11586n = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.p pVar = new com.airbnb.lottie.animation.keyframe.p(jVar);
            this.f11586n = pVar;
            pVar.a(this);
            this.f11578f.j(this.f11586n);
        }
    }
}
