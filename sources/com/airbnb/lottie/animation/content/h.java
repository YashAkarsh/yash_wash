package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h implements e, com.airbnb.lottie.animation.keyframe.a.b, k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f11620s = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final String f11621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f11623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.collection.f<LinearGradient> f11624d = new androidx.collection.f<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.collection.f<RadialGradient> f11625e = new androidx.collection.f<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f11626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f11627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f11628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<n> f11629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.model.content.f f11630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> f11631k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<Integer, Integer> f11632l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<PointF, PointF> f11633m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<PointF, PointF> f11634n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> f11635o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.p f11636p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final com.airbnb.lottie.h f11637q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f11638r;

    public h(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.d dVar) {
        Path path = new Path();
        this.f11626f = path;
        this.f11627g = new com.airbnb.lottie.animation.a(1);
        this.f11628h = new RectF();
        this.f11629i = new ArrayList();
        this.f11623c = aVar;
        this.f11621a = dVar.h();
        this.f11622b = dVar.k();
        this.f11637q = hVar;
        this.f11630j = dVar.e();
        path.setFillType(dVar.c());
        this.f11638r = (int) (hVar.t().d() / 32.0f);
        com.airbnb.lottie.animation.keyframe.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> aVarA = dVar.d().a();
        this.f11631k = aVarA;
        aVarA.a(this);
        aVar.j(aVarA);
        com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVarA2 = dVar.i().a();
        this.f11632l = aVarA2;
        aVarA2.a(this);
        aVar.j(aVarA2);
        com.airbnb.lottie.animation.keyframe.a<PointF, PointF> aVarA3 = dVar.j().a();
        this.f11633m = aVarA3;
        aVarA3.a(this);
        aVar.j(aVarA3);
        com.airbnb.lottie.animation.keyframe.a<PointF, PointF> aVarA4 = dVar.b().a();
        this.f11634n = aVarA4;
        aVarA4.a(this);
        aVar.j(aVarA4);
    }

    private int[] e(int[] iArr) {
        com.airbnb.lottie.animation.keyframe.p pVar = this.f11636p;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.h();
            int i7 = 0;
            if (iArr.length == numArr.length) {
                while (i7 < iArr.length) {
                    iArr[i7] = numArr[i7].intValue();
                    i7++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i7 < numArr.length) {
                    iArr[i7] = numArr[i7].intValue();
                    i7++;
                }
            }
        }
        return iArr;
    }

    private int i() {
        int iRound = Math.round(this.f11633m.f() * this.f11638r);
        int iRound2 = Math.round(this.f11634n.f() * this.f11638r);
        int iRound3 = Math.round(this.f11631k.f() * this.f11638r);
        int i7 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i7 = i7 * 31 * iRound2;
        }
        return iRound3 != 0 ? i7 * 31 * iRound3 : i7;
    }

    private LinearGradient j() {
        long jI = i();
        LinearGradient linearGradientM = this.f11624d.m(jI);
        if (linearGradientM != null) {
            return linearGradientM;
        }
        PointF pointFH = this.f11633m.h();
        PointF pointFH2 = this.f11634n.h();
        com.airbnb.lottie.model.content.c cVarH = this.f11631k.h();
        LinearGradient linearGradient = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, e(cVarH.a()), cVarH.b(), Shader.TileMode.CLAMP);
        this.f11624d.s(jI, linearGradient);
        return linearGradient;
    }

    private RadialGradient k() {
        long jI = i();
        RadialGradient radialGradientM = this.f11625e.m(jI);
        if (radialGradientM != null) {
            return radialGradientM;
        }
        PointF pointFH = this.f11633m.h();
        PointF pointFH2 = this.f11634n.h();
        com.airbnb.lottie.model.content.c cVarH = this.f11631k.h();
        int[] iArrE = e(cVarH.a());
        float[] fArrB = cVarH.b();
        float f8 = pointFH.x;
        float f9 = pointFH.y;
        float fHypot = (float) Math.hypot(pointFH2.x - f8, pointFH2.y - f9);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient = new RadialGradient(f8, f9, fHypot, iArrE, fArrB, Shader.TileMode.CLAMP);
        this.f11625e.s(jI, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        this.f11637q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
        for (int i7 = 0; i7 < list2.size(); i7++) {
            c cVar = list2.get(i7);
            if (cVar instanceof n) {
                this.f11629i.add((n) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.f
    public void c(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.utils.i.l(eVar, i7, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        this.f11626f.reset();
        for (int i7 = 0; i7 < this.f11629i.size(); i7++) {
            this.f11626f.addPath(this.f11629i.get(i7).g(), matrix);
        }
        this.f11626f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void f(Canvas canvas, Matrix matrix, int i7) {
        if (this.f11622b) {
            return;
        }
        com.airbnb.lottie.e.a("GradientFillContent#draw");
        this.f11626f.reset();
        for (int i8 = 0; i8 < this.f11629i.size(); i8++) {
            this.f11626f.addPath(this.f11629i.get(i8).g(), matrix);
        }
        this.f11626f.computeBounds(this.f11628h, false);
        Shader shaderJ = this.f11630j == com.airbnb.lottie.model.content.f.LINEAR ? j() : k();
        shaderJ.setLocalMatrix(matrix);
        this.f11627g.setShader(shaderJ);
        com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.f11635o;
        if (aVar != null) {
            this.f11627g.setColorFilter(aVar.h());
        }
        this.f11627g.setAlpha(com.airbnb.lottie.utils.i.c((int) ((((i7 / 255.0f) * this.f11632l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f11626f, this.f11627g);
        com.airbnb.lottie.e.b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11621a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        if (t7 == com.airbnb.lottie.m.f11884d) {
            this.f11632l.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.C) {
            com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.f11635o;
            if (aVar != null) {
                this.f11623c.D(aVar);
            }
            if (jVar == null) {
                this.f11635o = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.p pVar = new com.airbnb.lottie.animation.keyframe.p(jVar);
            this.f11635o = pVar;
            pVar.a(this);
            this.f11623c.j(this.f11635o);
            return;
        }
        if (t7 == com.airbnb.lottie.m.D) {
            com.airbnb.lottie.animation.keyframe.p pVar2 = this.f11636p;
            if (pVar2 != null) {
                this.f11623c.D(pVar2);
            }
            if (jVar == null) {
                this.f11636p = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.p pVar3 = new com.airbnb.lottie.animation.keyframe.p(jVar);
            this.f11636p = pVar3;
            pVar3.a(this);
            this.f11623c.j(this.f11636p);
        }
    }
}
