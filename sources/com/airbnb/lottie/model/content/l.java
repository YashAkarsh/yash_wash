package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import c.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.airbnb.lottie.model.a> f12032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PointF f12033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12034c;

    public l(PointF pointF, boolean z7, List<com.airbnb.lottie.model.a> list) {
        this.f12033b = pointF;
        this.f12034c = z7;
        this.f12032a = new ArrayList(list);
    }

    private void e(float f8, float f9) {
        if (this.f12033b == null) {
            this.f12033b = new PointF();
        }
        this.f12033b.set(f8, f9);
    }

    public List<com.airbnb.lottie.model.a> a() {
        return this.f12032a;
    }

    public PointF b() {
        return this.f12033b;
    }

    public void c(l lVar, l lVar2, @v(from = 0.0d, to = 1.0d) float f8) {
        if (this.f12033b == null) {
            this.f12033b = new PointF();
        }
        this.f12034c = lVar.d() || lVar2.d();
        if (lVar.a().size() != lVar2.a().size()) {
            com.airbnb.lottie.utils.f.e("Curves must have the same number of control points. Shape 1: " + lVar.a().size() + "\tShape 2: " + lVar2.a().size());
        }
        int iMin = Math.min(lVar.a().size(), lVar2.a().size());
        if (this.f12032a.size() < iMin) {
            for (int size = this.f12032a.size(); size < iMin; size++) {
                this.f12032a.add(new com.airbnb.lottie.model.a());
            }
        } else if (this.f12032a.size() > iMin) {
            for (int size2 = this.f12032a.size() - 1; size2 >= iMin; size2--) {
                List<com.airbnb.lottie.model.a> list = this.f12032a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = lVar.b();
        PointF pointFB2 = lVar2.b();
        e(com.airbnb.lottie.utils.i.j(pointFB.x, pointFB2.x, f8), com.airbnb.lottie.utils.i.j(pointFB.y, pointFB2.y, f8));
        for (int size3 = this.f12032a.size() - 1; size3 >= 0; size3--) {
            com.airbnb.lottie.model.a aVar = lVar.a().get(size3);
            com.airbnb.lottie.model.a aVar2 = lVar2.a().get(size3);
            PointF pointFA = aVar.a();
            PointF pointFB3 = aVar.b();
            PointF pointFC = aVar.c();
            PointF pointFA2 = aVar2.a();
            PointF pointFB4 = aVar2.b();
            PointF pointFC2 = aVar2.c();
            this.f12032a.get(size3).d(com.airbnb.lottie.utils.i.j(pointFA.x, pointFA2.x, f8), com.airbnb.lottie.utils.i.j(pointFA.y, pointFA2.y, f8));
            this.f12032a.get(size3).e(com.airbnb.lottie.utils.i.j(pointFB3.x, pointFB4.x, f8), com.airbnb.lottie.utils.i.j(pointFB3.y, pointFB4.y, f8));
            this.f12032a.get(size3).f(com.airbnb.lottie.utils.i.j(pointFC.x, pointFC2.x, f8), com.airbnb.lottie.utils.i.j(pointFC.y, pointFC2.y, f8));
        }
    }

    public boolean d() {
        return this.f12034c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f12032a.size() + "closed=" + this.f12034c + '}';
    }

    public l() {
        this.f12032a = new ArrayList();
    }
}
