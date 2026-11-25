package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RectF f2223a = new RectF();

    class a implements g.a {
        a() {
        }

        @Override // androidx.cardview.widget.g.a
        public void a(Canvas canvas, RectF rectF, float f8, Paint paint) {
            float f9 = 2.0f * f8;
            float fWidth = (rectF.width() - f9) - 1.0f;
            float fHeight = (rectF.height() - f9) - 1.0f;
            if (f8 >= 1.0f) {
                float f10 = f8 + 0.5f;
                float f11 = -f10;
                c.this.f2223a.set(f11, f11, f10, f10);
                int iSave = canvas.save();
                canvas.translate(rectF.left + f10, rectF.top + f10);
                canvas.drawArc(c.this.f2223a, 180.0f, 90.0f, true, paint);
                canvas.translate(fWidth, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f2223a, 180.0f, 90.0f, true, paint);
                canvas.translate(fHeight, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f2223a, 180.0f, 90.0f, true, paint);
                canvas.translate(fWidth, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f2223a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(iSave);
                float f12 = (rectF.left + f10) - 1.0f;
                float f13 = rectF.top;
                canvas.drawRect(f12, f13, (rectF.right - f10) + 1.0f, f13 + f10, paint);
                float f14 = (rectF.left + f10) - 1.0f;
                float f15 = rectF.bottom;
                canvas.drawRect(f14, f15 - f10, (rectF.right - f10) + 1.0f, f15, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f8, rectF.right, rectF.bottom - f8, paint);
        }
    }

    c() {
    }

    private g p(Context context, ColorStateList colorStateList, float f8, float f9, float f10) {
        return new g(context.getResources(), colorStateList, f8, f9, f10);
    }

    private g q(d dVar) {
        return (g) dVar.g();
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f8, float f9, float f10) {
        g gVarP = p(context, colorStateList, f8, f9, f10);
        gVarP.m(dVar.e());
        dVar.d(gVarP);
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void b(d dVar, float f8) {
        q(dVar).p(f8);
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public float c(d dVar) {
        return q(dVar).l();
    }

    @Override // androidx.cardview.widget.e
    public float d(d dVar) {
        return q(dVar).g();
    }

    @Override // androidx.cardview.widget.e
    public void e(d dVar) {
    }

    @Override // androidx.cardview.widget.e
    public void f(d dVar, float f8) {
        q(dVar).r(f8);
    }

    @Override // androidx.cardview.widget.e
    public float g(d dVar) {
        return q(dVar).i();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList h(d dVar) {
        return q(dVar).f();
    }

    @Override // androidx.cardview.widget.e
    public void i(d dVar) {
        Rect rect = new Rect();
        q(dVar).h(rect);
        dVar.c((int) Math.ceil(l(dVar)), (int) Math.ceil(k(dVar)));
        dVar.b(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.widget.e
    public void j() {
        g.f2238s = new a();
    }

    @Override // androidx.cardview.widget.e
    public float k(d dVar) {
        return q(dVar).j();
    }

    @Override // androidx.cardview.widget.e
    public float l(d dVar) {
        return q(dVar).k();
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar) {
        q(dVar).m(dVar.e());
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void n(d dVar, @o0 ColorStateList colorStateList) {
        q(dVar).o(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public void o(d dVar, float f8) {
        q(dVar).q(f8);
        i(dVar);
    }
}
