package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class b implements e {
    b() {
    }

    private f p(d dVar) {
        return (f) dVar.g();
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f8, float f9, float f10) {
        dVar.d(new f(colorStateList, f8));
        View viewH = dVar.h();
        viewH.setClipToOutline(true);
        viewH.setElevation(f9);
        o(dVar, f10);
    }

    @Override // androidx.cardview.widget.e
    public void b(d dVar, float f8) {
        p(dVar).h(f8);
    }

    @Override // androidx.cardview.widget.e
    public float c(d dVar) {
        return dVar.h().getElevation();
    }

    @Override // androidx.cardview.widget.e
    public float d(d dVar) {
        return p(dVar).d();
    }

    @Override // androidx.cardview.widget.e
    public void e(d dVar) {
        o(dVar, g(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void f(d dVar, float f8) {
        dVar.h().setElevation(f8);
    }

    @Override // androidx.cardview.widget.e
    public float g(d dVar) {
        return p(dVar).c();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList h(d dVar) {
        return p(dVar).b();
    }

    @Override // androidx.cardview.widget.e
    public void i(d dVar) {
        if (!dVar.f()) {
            dVar.b(0, 0, 0, 0);
            return;
        }
        float fG = g(dVar);
        float fD = d(dVar);
        int iCeil = (int) Math.ceil(g.c(fG, fD, dVar.e()));
        int iCeil2 = (int) Math.ceil(g.d(fG, fD, dVar.e()));
        dVar.b(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // androidx.cardview.widget.e
    public void j() {
    }

    @Override // androidx.cardview.widget.e
    public float k(d dVar) {
        return d(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public float l(d dVar) {
        return d(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar) {
        o(dVar, g(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void n(d dVar, @o0 ColorStateList colorStateList) {
        p(dVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public void o(d dVar, float f8) {
        p(dVar).g(f8, dVar.f(), dVar.e());
        i(dVar);
    }
}
