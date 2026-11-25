package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import c.o0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d implements e, n, com.airbnb.lottie.animation.keyframe.a.b, com.airbnb.lottie.model.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f11590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RectF f11591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f11592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Path f11593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f11594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f11595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<c> f11597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.h f11598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private List<n> f11599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.o f11600k;

    public d(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.n nVar) {
        this(hVar, aVar, nVar.c(), nVar.d(), e(hVar, aVar, nVar.b()), i(nVar.b()));
    }

    private static List<c> e(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, List<com.airbnb.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i7 = 0; i7 < list.size(); i7++) {
            c cVarA = list.get(i7).a(hVar, aVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }

    @o0
    static com.airbnb.lottie.model.animatable.l i(List<com.airbnb.lottie.model.content.b> list) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            com.airbnb.lottie.model.content.b bVar = list.get(i7);
            if (bVar instanceof com.airbnb.lottie.model.animatable.l) {
                return (com.airbnb.lottie.model.animatable.l) bVar;
            }
        }
        return null;
    }

    private boolean l() {
        int i7 = 0;
        for (int i8 = 0; i8 < this.f11597h.size(); i8++) {
            if ((this.f11597h.get(i8) instanceof e) && (i7 = i7 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        this.f11598i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f11597h.size());
        arrayList.addAll(list);
        for (int size = this.f11597h.size() - 1; size >= 0; size--) {
            c cVar = this.f11597h.get(size);
            cVar.b(arrayList, this.f11597h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // com.airbnb.lottie.model.f
    public void c(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i7)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.c(getName(), i7)) {
                    list.add(eVar2.j(this));
                }
            }
            if (eVar.i(getName(), i7)) {
                int iE = i7 + eVar.e(getName(), i7);
                for (int i8 = 0; i8 < this.f11597h.size(); i8++) {
                    c cVar = this.f11597h.get(i8);
                    if (cVar instanceof com.airbnb.lottie.model.f) {
                        ((com.airbnb.lottie.model.f) cVar).c(eVar, iE, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        this.f11592c.set(matrix);
        com.airbnb.lottie.animation.keyframe.o oVar = this.f11600k;
        if (oVar != null) {
            this.f11592c.preConcat(oVar.f());
        }
        this.f11594e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f11597h.size() - 1; size >= 0; size--) {
            c cVar = this.f11597h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).d(this.f11594e, this.f11592c, z7);
                rectF.union(this.f11594e);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void f(Canvas canvas, Matrix matrix, int i7) {
        if (this.f11596g) {
            return;
        }
        this.f11592c.set(matrix);
        com.airbnb.lottie.animation.keyframe.o oVar = this.f11600k;
        if (oVar != null) {
            this.f11592c.preConcat(oVar.f());
            i7 = (int) (((((this.f11600k.h() == null ? 100 : this.f11600k.h().h().intValue()) / 100.0f) * i7) / 255.0f) * 255.0f);
        }
        boolean z7 = this.f11598i.O() && l() && i7 != 255;
        if (z7) {
            this.f11591b.set(0.0f, 0.0f, 0.0f, 0.0f);
            d(this.f11591b, this.f11592c, true);
            this.f11590a.setAlpha(i7);
            com.airbnb.lottie.utils.j.n(canvas, this.f11591b, this.f11590a);
        }
        if (z7) {
            i7 = 255;
        }
        for (int size = this.f11597h.size() - 1; size >= 0; size--) {
            c cVar = this.f11597h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).f(canvas, this.f11592c, i7);
            }
        }
        if (z7) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.animation.content.n
    public Path g() {
        this.f11592c.reset();
        com.airbnb.lottie.animation.keyframe.o oVar = this.f11600k;
        if (oVar != null) {
            this.f11592c.set(oVar.f());
        }
        this.f11593d.reset();
        if (this.f11596g) {
            return this.f11593d;
        }
        for (int size = this.f11597h.size() - 1; size >= 0; size--) {
            c cVar = this.f11597h.get(size);
            if (cVar instanceof n) {
                this.f11593d.addPath(((n) cVar).g(), this.f11592c);
            }
        }
        return this.f11593d;
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11595f;
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        com.airbnb.lottie.animation.keyframe.o oVar = this.f11600k;
        if (oVar != null) {
            oVar.c(t7, jVar);
        }
    }

    List<n> j() {
        if (this.f11599j == null) {
            this.f11599j = new ArrayList();
            for (int i7 = 0; i7 < this.f11597h.size(); i7++) {
                c cVar = this.f11597h.get(i7);
                if (cVar instanceof n) {
                    this.f11599j.add((n) cVar);
                }
            }
        }
        return this.f11599j;
    }

    Matrix k() {
        com.airbnb.lottie.animation.keyframe.o oVar = this.f11600k;
        if (oVar != null) {
            return oVar.f();
        }
        this.f11592c.reset();
        return this.f11592c;
    }

    d(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, String str, boolean z7, List<c> list, @o0 com.airbnb.lottie.model.animatable.l lVar) {
        this.f11590a = new com.airbnb.lottie.animation.a();
        this.f11591b = new RectF();
        this.f11592c = new Matrix();
        this.f11593d = new Path();
        this.f11594e = new RectF();
        this.f11595f = str;
        this.f11598i = hVar;
        this.f11596g = z7;
        this.f11597h = list;
        if (lVar != null) {
            com.airbnb.lottie.animation.keyframe.o oVarB = lVar.b();
            this.f11600k = oVarB;
            oVarB.a(aVar);
            this.f11600k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).e(list.listIterator(list.size()));
        }
    }
}
