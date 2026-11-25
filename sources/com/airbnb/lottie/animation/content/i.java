package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class i extends a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f11639z = 32;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f11640o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f11641p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final androidx.collection.f<LinearGradient> f11642q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final androidx.collection.f<RadialGradient> f11643r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final RectF f11644s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final com.airbnb.lottie.model.content.f f11645t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f11646u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> f11647v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<PointF, PointF> f11648w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<PointF, PointF> f11649x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.p f11650y;

    public i(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.e eVar) {
        super(hVar, aVar, eVar.b().a(), eVar.g().a(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.f11642q = new androidx.collection.f<>();
        this.f11643r = new androidx.collection.f<>();
        this.f11644s = new RectF();
        this.f11640o = eVar.j();
        this.f11645t = eVar.f();
        this.f11641p = eVar.n();
        this.f11646u = (int) (hVar.t().d() / 32.0f);
        com.airbnb.lottie.animation.keyframe.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> aVarA = eVar.e().a();
        this.f11647v = aVarA;
        aVarA.a(this);
        aVar.j(aVarA);
        com.airbnb.lottie.animation.keyframe.a<PointF, PointF> aVarA2 = eVar.l().a();
        this.f11648w = aVarA2;
        aVarA2.a(this);
        aVar.j(aVarA2);
        com.airbnb.lottie.animation.keyframe.a<PointF, PointF> aVarA3 = eVar.d().a();
        this.f11649x = aVarA3;
        aVarA3.a(this);
        aVar.j(aVarA3);
    }

    private int[] j(int[] iArr) {
        com.airbnb.lottie.animation.keyframe.p pVar = this.f11650y;
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

    private int k() {
        int iRound = Math.round(this.f11648w.f() * this.f11646u);
        int iRound2 = Math.round(this.f11649x.f() * this.f11646u);
        int iRound3 = Math.round(this.f11647v.f() * this.f11646u);
        int i7 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i7 = i7 * 31 * iRound2;
        }
        return iRound3 != 0 ? i7 * 31 * iRound3 : i7;
    }

    private LinearGradient l() {
        long jK = k();
        LinearGradient linearGradientM = this.f11642q.m(jK);
        if (linearGradientM != null) {
            return linearGradientM;
        }
        PointF pointFH = this.f11648w.h();
        PointF pointFH2 = this.f11649x.h();
        com.airbnb.lottie.model.content.c cVarH = this.f11647v.h();
        LinearGradient linearGradient = new LinearGradient(pointFH.x, pointFH.y, pointFH2.x, pointFH2.y, j(cVarH.a()), cVarH.b(), Shader.TileMode.CLAMP);
        this.f11642q.s(jK, linearGradient);
        return linearGradient;
    }

    private RadialGradient m() {
        long jK = k();
        RadialGradient radialGradientM = this.f11643r.m(jK);
        if (radialGradientM != null) {
            return radialGradientM;
        }
        PointF pointFH = this.f11648w.h();
        PointF pointFH2 = this.f11649x.h();
        com.airbnb.lottie.model.content.c cVarH = this.f11647v.h();
        int[] iArrJ = j(cVarH.a());
        float[] fArrB = cVarH.b();
        float f8 = pointFH.x;
        float f9 = pointFH.y;
        RadialGradient radialGradient = new RadialGradient(f8, f9, (float) Math.hypot(pointFH2.x - f8, pointFH2.y - f9), iArrJ, fArrB, Shader.TileMode.CLAMP);
        this.f11643r.s(jK, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.animation.content.a, com.airbnb.lottie.animation.content.e
    public void f(Canvas canvas, Matrix matrix, int i7) {
        if (this.f11641p) {
            return;
        }
        d(this.f11644s, matrix, false);
        Shader shaderL = this.f11645t == com.airbnb.lottie.model.content.f.LINEAR ? l() : m();
        shaderL.setLocalMatrix(matrix);
        this.f11581i.setShader(shaderL);
        super.f(canvas, matrix, i7);
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11640o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.a, com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        super.h(t7, jVar);
        if (t7 == com.airbnb.lottie.m.D) {
            com.airbnb.lottie.animation.keyframe.p pVar = this.f11650y;
            if (pVar != null) {
                this.f11578f.D(pVar);
            }
            if (jVar == null) {
                this.f11650y = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.p pVar2 = new com.airbnb.lottie.animation.keyframe.p(jVar);
            this.f11650y = pVar2;
            pVar2.a(this);
            this.f11578f.j(this.f11650y);
        }
    }
}
