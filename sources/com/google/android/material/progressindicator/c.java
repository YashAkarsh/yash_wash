package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import c.m0;
import c.v;

/* JADX INFO: loaded from: classes.dex */
final class c extends g<CircularProgressIndicatorSpec> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f18038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f18039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f18040f;

    public c(@m0 CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f18037c = 1;
    }

    private void h(Canvas canvas, Paint paint, float f8, float f9, float f10, boolean z7, RectF rectF) {
        float f11 = z7 ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f10);
        float f12 = f8 / 2.0f;
        float f13 = f11 * f9;
        canvas.drawRect((this.f18040f - f12) + f9, Math.min(0.0f, this.f18037c * f13), (this.f18040f + f12) - f9, Math.max(0.0f, f13 * this.f18037c), paint);
        canvas.translate((this.f18040f - f12) + f9, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f11) * 90.0f * this.f18037c, true, paint);
        canvas.translate(f8 - (f9 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f11 * 90.0f * this.f18037c, true, paint);
        canvas.restore();
    }

    private int i() {
        S s7 = this.f18092a;
        return ((CircularProgressIndicatorSpec) s7).f18022g + (((CircularProgressIndicatorSpec) s7).f18023h * 2);
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(@m0 Canvas canvas, @v(from = 0.0d, to = 1.0d) float f8) {
        S s7 = this.f18092a;
        float f9 = (((CircularProgressIndicatorSpec) s7).f18022g / 2.0f) + ((CircularProgressIndicatorSpec) s7).f18023h;
        canvas.translate(f9, f9);
        canvas.rotate(-90.0f);
        float f10 = -f9;
        canvas.clipRect(f10, f10, f9, f9);
        S s8 = this.f18092a;
        this.f18037c = ((CircularProgressIndicatorSpec) s8).f18024i == 0 ? 1 : -1;
        this.f18038d = ((CircularProgressIndicatorSpec) s8).f18031a * f8;
        this.f18039e = ((CircularProgressIndicatorSpec) s8).f18032b * f8;
        this.f18040f = (((CircularProgressIndicatorSpec) s8).f18022g - ((CircularProgressIndicatorSpec) s8).f18031a) / 2.0f;
        if ((this.f18093b.n() && ((CircularProgressIndicatorSpec) this.f18092a).f18035e == 2) || (this.f18093b.m() && ((CircularProgressIndicatorSpec) this.f18092a).f18036f == 1)) {
            this.f18040f += ((1.0f - f8) * ((CircularProgressIndicatorSpec) this.f18092a).f18031a) / 2.0f;
        } else if ((this.f18093b.n() && ((CircularProgressIndicatorSpec) this.f18092a).f18035e == 1) || (this.f18093b.m() && ((CircularProgressIndicatorSpec) this.f18092a).f18036f == 2)) {
            this.f18040f -= ((1.0f - f8) * ((CircularProgressIndicatorSpec) this.f18092a).f18031a) / 2.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.g
    void b(@m0 Canvas canvas, @m0 Paint paint, @v(from = 0.0d, to = 1.0d) float f8, @v(from = 0.0d, to = 1.0d) float f9, @c.l int i7) {
        if (f8 == f9) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i7);
        paint.setStrokeWidth(this.f18038d);
        int i8 = this.f18037c;
        float f10 = f8 * 360.0f * i8;
        float f11 = (f9 >= f8 ? f9 - f8 : (f9 + 1.0f) - f8) * 360.0f * i8;
        float f12 = this.f18040f;
        canvas.drawArc(new RectF(-f12, -f12, f12, f12), f10, f11, false, paint);
        if (this.f18039e <= 0.0f || Math.abs(f11) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        float f13 = this.f18039e;
        RectF rectF = new RectF(-f13, -f13, f13, f13);
        h(canvas, paint, this.f18038d, this.f18039e, f10, true, rectF);
        h(canvas, paint, this.f18038d, this.f18039e, f10 + f11, false, rectF);
    }

    @Override // com.google.android.material.progressindicator.g
    void c(@m0 Canvas canvas, @m0 Paint paint) {
        int iA = k1.a.a(((CircularProgressIndicatorSpec) this.f18092a).f18034d, this.f18093b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iA);
        paint.setStrokeWidth(this.f18038d);
        float f8 = this.f18040f;
        canvas.drawArc(new RectF(-f8, -f8, f8, f8), 0.0f, 360.0f, false, paint);
    }

    @Override // com.google.android.material.progressindicator.g
    public int d() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.g
    public int e() {
        return i();
    }
}
