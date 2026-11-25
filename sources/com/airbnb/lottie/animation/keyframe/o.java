package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import c.m0;
import c.o0;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f11745a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix f11746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f11747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Matrix f11748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f11749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m0
    private a<PointF, PointF> f11750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @m0
    private a<?, PointF> f11751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @m0
    private a<com.airbnb.lottie.value.k, com.airbnb.lottie.value.k> f11752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @m0
    private a<Float, Float> f11753i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @m0
    private a<Integer, Integer> f11754j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private c f11755k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private c f11756l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private a<?, Float> f11757m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @o0
    private a<?, Float> f11758n;

    public o(com.airbnb.lottie.model.animatable.l lVar) {
        this.f11750f = lVar.c() == null ? null : lVar.c().a();
        this.f11751g = lVar.f() == null ? null : lVar.f().a();
        this.f11752h = lVar.h() == null ? null : lVar.h().a();
        this.f11753i = lVar.g() == null ? null : lVar.g().a();
        c cVar = lVar.i() == null ? null : (c) lVar.i().a();
        this.f11755k = cVar;
        if (cVar != null) {
            this.f11746b = new Matrix();
            this.f11747c = new Matrix();
            this.f11748d = new Matrix();
            this.f11749e = new float[9];
        } else {
            this.f11746b = null;
            this.f11747c = null;
            this.f11748d = null;
            this.f11749e = null;
        }
        this.f11756l = lVar.j() == null ? null : (c) lVar.j().a();
        if (lVar.e() != null) {
            this.f11754j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.f11757m = lVar.k().a();
        } else {
            this.f11757m = null;
        }
        if (lVar.d() != null) {
            this.f11758n = lVar.d().a();
        } else {
            this.f11758n = null;
        }
    }

    private void d() {
        for (int i7 = 0; i7 < 9; i7++) {
            this.f11749e[i7] = 0.0f;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.j(this.f11754j);
        aVar.j(this.f11757m);
        aVar.j(this.f11758n);
        aVar.j(this.f11750f);
        aVar.j(this.f11751g);
        aVar.j(this.f11752h);
        aVar.j(this.f11753i);
        aVar.j(this.f11755k);
        aVar.j(this.f11756l);
    }

    public void b(a.b bVar) {
        a<Integer, Integer> aVar = this.f11754j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.f11757m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.f11758n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f11750f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f11751g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<com.airbnb.lottie.value.k, com.airbnb.lottie.value.k> aVar6 = this.f11752h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f11753i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        c cVar = this.f11755k;
        if (cVar != null) {
            cVar.a(bVar);
        }
        c cVar2 = this.f11756l;
        if (cVar2 != null) {
            cVar2.a(bVar);
        }
    }

    public <T> boolean c(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        c cVar;
        c cVar2;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t7 == com.airbnb.lottie.m.f11885e) {
            a<PointF, PointF> aVar3 = this.f11750f;
            if (aVar3 == null) {
                this.f11750f = new p(jVar, new PointF());
                return true;
            }
            aVar3.m(jVar);
            return true;
        }
        if (t7 == com.airbnb.lottie.m.f11886f) {
            a<?, PointF> aVar4 = this.f11751g;
            if (aVar4 == null) {
                this.f11751g = new p(jVar, new PointF());
                return true;
            }
            aVar4.m(jVar);
            return true;
        }
        if (t7 == com.airbnb.lottie.m.f11891k) {
            a<com.airbnb.lottie.value.k, com.airbnb.lottie.value.k> aVar5 = this.f11752h;
            if (aVar5 == null) {
                this.f11752h = new p(jVar, new com.airbnb.lottie.value.k());
                return true;
            }
            aVar5.m(jVar);
            return true;
        }
        if (t7 == com.airbnb.lottie.m.f11892l) {
            a<Float, Float> aVar6 = this.f11753i;
            if (aVar6 == null) {
                this.f11753i = new p(jVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.m(jVar);
            return true;
        }
        if (t7 == com.airbnb.lottie.m.f11883c) {
            a<Integer, Integer> aVar7 = this.f11754j;
            if (aVar7 == null) {
                this.f11754j = new p(jVar, 100);
                return true;
            }
            aVar7.m(jVar);
            return true;
        }
        if (t7 == com.airbnb.lottie.m.f11905y && (aVar2 = this.f11757m) != null) {
            if (aVar2 == null) {
                this.f11757m = new p(jVar, 100);
                return true;
            }
            aVar2.m(jVar);
            return true;
        }
        if (t7 == com.airbnb.lottie.m.f11906z && (aVar = this.f11758n) != null) {
            if (aVar == null) {
                this.f11758n = new p(jVar, 100);
                return true;
            }
            aVar.m(jVar);
            return true;
        }
        if (t7 == com.airbnb.lottie.m.f11893m && (cVar2 = this.f11755k) != null) {
            if (cVar2 == null) {
                this.f11755k = new c(Collections.singletonList(new com.airbnb.lottie.value.a(Float.valueOf(0.0f))));
            }
            this.f11755k.m(jVar);
            return true;
        }
        if (t7 != com.airbnb.lottie.m.f11894n || (cVar = this.f11756l) == null) {
            return false;
        }
        if (cVar == null) {
            this.f11756l = new c(Collections.singletonList(new com.airbnb.lottie.value.a(Float.valueOf(0.0f))));
        }
        this.f11756l.m(jVar);
        return true;
    }

    @o0
    public a<?, Float> e() {
        return this.f11758n;
    }

    public Matrix f() {
        this.f11745a.reset();
        a<?, PointF> aVar = this.f11751g;
        if (aVar != null) {
            PointF pointFH = aVar.h();
            float f8 = pointFH.x;
            if (f8 != 0.0f || pointFH.y != 0.0f) {
                this.f11745a.preTranslate(f8, pointFH.y);
            }
        }
        a<Float, Float> aVar2 = this.f11753i;
        if (aVar2 != null) {
            float fFloatValue = aVar2 instanceof p ? aVar2.h().floatValue() : ((c) aVar2).o();
            if (fFloatValue != 0.0f) {
                this.f11745a.preRotate(fFloatValue);
            }
        }
        if (this.f11755k != null) {
            c cVar = this.f11756l;
            float fCos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((-cVar.o()) + 90.0f));
            c cVar2 = this.f11756l;
            float fSin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-cVar2.o()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f11755k.o()));
            d();
            float[] fArr = this.f11749e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f9 = -fSin;
            fArr[3] = f9;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f11746b.setValues(fArr);
            d();
            float[] fArr2 = this.f11749e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f11747c.setValues(fArr2);
            d();
            float[] fArr3 = this.f11749e;
            fArr3[0] = fCos;
            fArr3[1] = f9;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f11748d.setValues(fArr3);
            this.f11747c.preConcat(this.f11746b);
            this.f11748d.preConcat(this.f11747c);
            this.f11745a.preConcat(this.f11748d);
        }
        a<com.airbnb.lottie.value.k, com.airbnb.lottie.value.k> aVar3 = this.f11752h;
        if (aVar3 != null) {
            com.airbnb.lottie.value.k kVarH = aVar3.h();
            if (kVarH.b() != 1.0f || kVarH.c() != 1.0f) {
                this.f11745a.preScale(kVarH.b(), kVarH.c());
            }
        }
        a<PointF, PointF> aVar4 = this.f11750f;
        if (aVar4 != null) {
            PointF pointFH2 = aVar4.h();
            float f10 = pointFH2.x;
            if (f10 != 0.0f || pointFH2.y != 0.0f) {
                this.f11745a.preTranslate(-f10, -pointFH2.y);
            }
        }
        return this.f11745a;
    }

    public Matrix g(float f8) {
        a<?, PointF> aVar = this.f11751g;
        PointF pointFH = aVar == null ? null : aVar.h();
        a<com.airbnb.lottie.value.k, com.airbnb.lottie.value.k> aVar2 = this.f11752h;
        com.airbnb.lottie.value.k kVarH = aVar2 == null ? null : aVar2.h();
        this.f11745a.reset();
        if (pointFH != null) {
            this.f11745a.preTranslate(pointFH.x * f8, pointFH.y * f8);
        }
        if (kVarH != null) {
            double d8 = f8;
            this.f11745a.preScale((float) Math.pow(kVarH.b(), d8), (float) Math.pow(kVarH.c(), d8));
        }
        a<Float, Float> aVar3 = this.f11753i;
        if (aVar3 != null) {
            float fFloatValue = aVar3.h().floatValue();
            a<PointF, PointF> aVar4 = this.f11750f;
            PointF pointFH2 = aVar4 != null ? aVar4.h() : null;
            this.f11745a.preRotate(fFloatValue * f8, pointFH2 == null ? 0.0f : pointFH2.x, pointFH2 != null ? pointFH2.y : 0.0f);
        }
        return this.f11745a;
    }

    @o0
    public a<?, Integer> h() {
        return this.f11754j;
    }

    @o0
    public a<?, Float> i() {
        return this.f11757m;
    }

    public void j(float f8) {
        a<Integer, Integer> aVar = this.f11754j;
        if (aVar != null) {
            aVar.l(f8);
        }
        a<?, Float> aVar2 = this.f11757m;
        if (aVar2 != null) {
            aVar2.l(f8);
        }
        a<?, Float> aVar3 = this.f11758n;
        if (aVar3 != null) {
            aVar3.l(f8);
        }
        a<PointF, PointF> aVar4 = this.f11750f;
        if (aVar4 != null) {
            aVar4.l(f8);
        }
        a<?, PointF> aVar5 = this.f11751g;
        if (aVar5 != null) {
            aVar5.l(f8);
        }
        a<com.airbnb.lottie.value.k, com.airbnb.lottie.value.k> aVar6 = this.f11752h;
        if (aVar6 != null) {
            aVar6.l(f8);
        }
        a<Float, Float> aVar7 = this.f11753i;
        if (aVar7 != null) {
            aVar7.l(f8);
        }
        c cVar = this.f11755k;
        if (cVar != null) {
            cVar.l(f8);
        }
        c cVar2 = this.f11756l;
        if (cVar2 != null) {
            cVar2.l(f8);
        }
    }
}
