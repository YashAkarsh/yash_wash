package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import c.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f implements n, com.airbnb.lottie.animation.keyframe.a.b, k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f11601i = 0.55228f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.h f11604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, PointF> f11605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, PointF> f11606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.model.content.a f11607f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11609h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f11602a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f11608g = new b();

    public f(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        this.f11603b = aVar2.b();
        this.f11604c = hVar;
        com.airbnb.lottie.animation.keyframe.a<PointF, PointF> aVarA = aVar2.d().a();
        this.f11605d = aVarA;
        com.airbnb.lottie.animation.keyframe.a<PointF, PointF> aVarA2 = aVar2.c().a();
        this.f11606e = aVarA2;
        this.f11607f = aVar2;
        aVar.j(aVarA);
        aVar.j(aVarA2);
        aVarA.a(this);
        aVarA2.a(this);
    }

    private void e() {
        this.f11609h = false;
        this.f11604c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        e();
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            c cVar = list.get(i7);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.j() == com.airbnb.lottie.model.content.q.a.SIMULTANEOUSLY) {
                    this.f11608g.a(tVar);
                    tVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.f
    public void c(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.utils.i.l(eVar, i7, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.animation.content.n
    public Path g() {
        if (this.f11609h) {
            return this.f11602a;
        }
        this.f11602a.reset();
        if (this.f11607f.e()) {
            this.f11609h = true;
            return this.f11602a;
        }
        PointF pointFH = this.f11605d.h();
        float f8 = pointFH.x / 2.0f;
        float f9 = pointFH.y / 2.0f;
        float f10 = f8 * f11601i;
        float f11 = f11601i * f9;
        this.f11602a.reset();
        if (this.f11607f.f()) {
            float f12 = -f9;
            this.f11602a.moveTo(0.0f, f12);
            float f13 = 0.0f - f10;
            float f14 = -f8;
            float f15 = 0.0f - f11;
            this.f11602a.cubicTo(f13, f12, f14, f15, f14, 0.0f);
            float f16 = f11 + 0.0f;
            this.f11602a.cubicTo(f14, f16, f13, f9, 0.0f, f9);
            float f17 = f10 + 0.0f;
            this.f11602a.cubicTo(f17, f9, f8, f16, f8, 0.0f);
            this.f11602a.cubicTo(f8, f15, f17, f12, 0.0f, f12);
        } else {
            float f18 = -f9;
            this.f11602a.moveTo(0.0f, f18);
            float f19 = f10 + 0.0f;
            float f20 = 0.0f - f11;
            this.f11602a.cubicTo(f19, f18, f8, f20, f8, 0.0f);
            float f21 = f11 + 0.0f;
            this.f11602a.cubicTo(f8, f21, f19, f9, 0.0f, f9);
            float f22 = 0.0f - f10;
            float f23 = -f8;
            this.f11602a.cubicTo(f22, f9, f23, f21, f23, 0.0f);
            this.f11602a.cubicTo(f23, f20, f22, f18, 0.0f, f18);
        }
        PointF pointFH2 = this.f11606e.h();
        this.f11602a.offset(pointFH2.x, pointFH2.y);
        this.f11602a.close();
        this.f11608g.b(this.f11602a);
        this.f11609h = true;
        return this.f11602a;
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11603b;
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        if (t7 == com.airbnb.lottie.m.f11887g) {
            this.f11605d.m(jVar);
        } else if (t7 == com.airbnb.lottie.m.f11890j) {
            this.f11606e.m(jVar);
        }
    }
}
