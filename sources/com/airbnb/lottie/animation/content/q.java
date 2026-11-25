package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import c.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class q implements e, n, j, com.airbnb.lottie.animation.keyframe.a.b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f11685a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f11686b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.h f11687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f11688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f11690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<Float, Float> f11691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<Float, Float> f11692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.o f11693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d f11694j;

    public q(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.f11687c = hVar;
        this.f11688d = aVar;
        this.f11689e = kVar.c();
        this.f11690f = kVar.f();
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA = kVar.b().a();
        this.f11691g = aVarA;
        aVar.j(aVarA);
        aVarA.a(this);
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA2 = kVar.d().a();
        this.f11692h = aVarA2;
        aVar.j(aVarA2);
        aVarA2.a(this);
        com.airbnb.lottie.animation.keyframe.o oVarB = kVar.e().b();
        this.f11693i = oVarB;
        oVarB.a(aVar);
        oVarB.b(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        this.f11687c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
        this.f11694j.b(list, list2);
    }

    @Override // com.airbnb.lottie.model.f
    public void c(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.utils.i.l(eVar, i7, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        this.f11694j.d(rectF, matrix, z7);
    }

    @Override // com.airbnb.lottie.animation.content.j
    public void e(ListIterator<c> listIterator) {
        if (this.f11694j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f11694j = new d(this.f11687c, this.f11688d, "Repeater", this.f11690f, arrayList, null);
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void f(Canvas canvas, Matrix matrix, int i7) {
        float fFloatValue = this.f11691g.h().floatValue();
        float fFloatValue2 = this.f11692h.h().floatValue();
        float fFloatValue3 = this.f11693i.i().h().floatValue() / 100.0f;
        float fFloatValue4 = this.f11693i.e().h().floatValue() / 100.0f;
        for (int i8 = ((int) fFloatValue) - 1; i8 >= 0; i8--) {
            this.f11685a.set(matrix);
            float f8 = i8;
            this.f11685a.preConcat(this.f11693i.g(f8 + fFloatValue2));
            this.f11694j.f(canvas, this.f11685a, (int) (i7 * com.airbnb.lottie.utils.i.j(fFloatValue3, fFloatValue4, f8 / fFloatValue)));
        }
    }

    @Override // com.airbnb.lottie.animation.content.n
    public Path g() {
        Path pathG = this.f11694j.g();
        this.f11686b.reset();
        float fFloatValue = this.f11691g.h().floatValue();
        float fFloatValue2 = this.f11692h.h().floatValue();
        for (int i7 = ((int) fFloatValue) - 1; i7 >= 0; i7--) {
            this.f11685a.set(this.f11693i.g(i7 + fFloatValue2));
            this.f11686b.addPath(pathG, this.f11685a);
        }
        return this.f11686b;
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11689e;
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        if (this.f11693i.c(t7, jVar)) {
            return;
        }
        if (t7 == com.airbnb.lottie.m.f11897q) {
            this.f11691g.m(jVar);
        } else if (t7 == com.airbnb.lottie.m.f11898r) {
            this.f11692h.m(jVar);
        }
    }
}
