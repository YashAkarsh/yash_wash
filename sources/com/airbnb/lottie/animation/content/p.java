package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import c.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p implements com.airbnb.lottie.animation.keyframe.a.b, k, n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f11678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.h f11679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, PointF> f11680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, PointF> f11681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11682h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11684j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f11675a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f11676b = new RectF();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f11683i = new b();

    public p(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.j jVar) {
        this.f11677c = jVar.c();
        this.f11678d = jVar.f();
        this.f11679e = hVar;
        com.airbnb.lottie.animation.keyframe.a<PointF, PointF> aVarA = jVar.d().a();
        this.f11680f = aVarA;
        com.airbnb.lottie.animation.keyframe.a<PointF, PointF> aVarA2 = jVar.e().a();
        this.f11681g = aVarA2;
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA3 = jVar.b().a();
        this.f11682h = aVarA3;
        aVar.j(aVarA);
        aVar.j(aVarA2);
        aVar.j(aVarA3);
        aVarA.a(this);
        aVarA2.a(this);
        aVarA3.a(this);
    }

    private void e() {
        this.f11684j = false;
        this.f11679e.invalidateSelf();
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
                    this.f11683i.a(tVar);
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
        if (this.f11684j) {
            return this.f11675a;
        }
        this.f11675a.reset();
        if (this.f11678d) {
            this.f11684j = true;
            return this.f11675a;
        }
        PointF pointFH = this.f11681g.h();
        float f8 = pointFH.x / 2.0f;
        float f9 = pointFH.y / 2.0f;
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar = this.f11682h;
        float fO = aVar == null ? 0.0f : ((com.airbnb.lottie.animation.keyframe.c) aVar).o();
        float fMin = Math.min(f8, f9);
        if (fO > fMin) {
            fO = fMin;
        }
        PointF pointFH2 = this.f11680f.h();
        this.f11675a.moveTo(pointFH2.x + f8, (pointFH2.y - f9) + fO);
        this.f11675a.lineTo(pointFH2.x + f8, (pointFH2.y + f9) - fO);
        if (fO > 0.0f) {
            RectF rectF = this.f11676b;
            float f10 = pointFH2.x;
            float f11 = fO * 2.0f;
            float f12 = pointFH2.y;
            rectF.set((f10 + f8) - f11, (f12 + f9) - f11, f10 + f8, f12 + f9);
            this.f11675a.arcTo(this.f11676b, 0.0f, 90.0f, false);
        }
        this.f11675a.lineTo((pointFH2.x - f8) + fO, pointFH2.y + f9);
        if (fO > 0.0f) {
            RectF rectF2 = this.f11676b;
            float f13 = pointFH2.x;
            float f14 = pointFH2.y;
            float f15 = fO * 2.0f;
            rectF2.set(f13 - f8, (f14 + f9) - f15, (f13 - f8) + f15, f14 + f9);
            this.f11675a.arcTo(this.f11676b, 90.0f, 90.0f, false);
        }
        this.f11675a.lineTo(pointFH2.x - f8, (pointFH2.y - f9) + fO);
        if (fO > 0.0f) {
            RectF rectF3 = this.f11676b;
            float f16 = pointFH2.x;
            float f17 = pointFH2.y;
            float f18 = fO * 2.0f;
            rectF3.set(f16 - f8, f17 - f9, (f16 - f8) + f18, (f17 - f9) + f18);
            this.f11675a.arcTo(this.f11676b, 180.0f, 90.0f, false);
        }
        this.f11675a.lineTo((pointFH2.x + f8) - fO, pointFH2.y - f9);
        if (fO > 0.0f) {
            RectF rectF4 = this.f11676b;
            float f19 = pointFH2.x;
            float f20 = fO * 2.0f;
            float f21 = pointFH2.y;
            rectF4.set((f19 + f8) - f20, f21 - f9, f19 + f8, (f21 - f9) + f20);
            this.f11675a.arcTo(this.f11676b, 270.0f, 90.0f, false);
        }
        this.f11675a.close();
        this.f11683i.b(this.f11675a);
        this.f11684j = true;
        return this.f11675a;
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11677c;
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        if (t7 == com.airbnb.lottie.m.f11888h) {
            this.f11681g.m(jVar);
        } else if (t7 == com.airbnb.lottie.m.f11890j) {
            this.f11680f.m(jVar);
        } else if (t7 == com.airbnb.lottie.m.f11889i) {
            this.f11682h.m(jVar);
        }
    }
}
