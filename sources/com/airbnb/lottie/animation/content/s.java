package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class s extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f11702o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f11703p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f11704q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<Integer, Integer> f11705r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> f11706s;

    public s(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.p pVar) {
        super(hVar, aVar, pVar.b().a(), pVar.e().a(), pVar.g(), pVar.i(), pVar.j(), pVar.f(), pVar.d());
        this.f11702o = aVar;
        this.f11703p = pVar.h();
        this.f11704q = pVar.k();
        com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVarA = pVar.c().a();
        this.f11705r = aVarA;
        aVarA.a(this);
        aVar.j(aVarA);
    }

    @Override // com.airbnb.lottie.animation.content.a, com.airbnb.lottie.animation.content.e
    public void f(Canvas canvas, Matrix matrix, int i7) {
        if (this.f11704q) {
            return;
        }
        this.f11581i.setColor(((com.airbnb.lottie.animation.keyframe.b) this.f11705r).o());
        com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.f11706s;
        if (aVar != null) {
            this.f11581i.setColorFilter(aVar.h());
        }
        super.f(canvas, matrix, i7);
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11703p;
    }

    @Override // com.airbnb.lottie.animation.content.a, com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        super.h(t7, jVar);
        if (t7 == com.airbnb.lottie.m.f11882b) {
            this.f11705r.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.C) {
            com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.f11706s;
            if (aVar != null) {
                this.f11702o.D(aVar);
            }
            if (jVar == null) {
                this.f11706s = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.p pVar = new com.airbnb.lottie.animation.keyframe.p(jVar);
            this.f11706s = pVar;
            pVar.a(this);
            this.f11702o.j(this.f11705r);
        }
    }
}
