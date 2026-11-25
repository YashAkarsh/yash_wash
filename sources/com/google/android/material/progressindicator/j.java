package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import c.m0;
import c.v;

/* JADX INFO: loaded from: classes.dex */
final class j extends g<LinearProgressIndicatorSpec> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f18099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f18100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f18101e;

    public j(@m0 LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f18099c = 300.0f;
    }

    private static void h(Canvas canvas, Paint paint, float f8, float f9, float f10, boolean z7, RectF rectF) {
        canvas.save();
        canvas.translate(f10, 0.0f);
        if (!z7) {
            canvas.rotate(180.0f);
        }
        float f11 = ((-f8) / 2.0f) + f9;
        float f12 = (f8 / 2.0f) - f9;
        canvas.drawRect(-f9, f11, 0.0f, f12, paint);
        canvas.save();
        canvas.translate(0.0f, f11);
        canvas.drawArc(rectF, 180.0f, 90.0f, true, paint);
        canvas.restore();
        canvas.translate(0.0f, f12);
        canvas.drawArc(rectF, 180.0f, -90.0f, true, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(@m0 Canvas canvas, @v(from = 0.0d, to = 1.0d) float f8) {
        Rect clipBounds = canvas.getClipBounds();
        this.f18099c = clipBounds.width();
        float f9 = ((LinearProgressIndicatorSpec) this.f18092a).f18031a;
        canvas.translate(clipBounds.left + (clipBounds.width() / 2.0f), clipBounds.top + (clipBounds.height() / 2.0f) + Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) this.f18092a).f18031a) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f18092a).f18029i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f18093b.n() && ((LinearProgressIndicatorSpec) this.f18092a).f18035e == 1) || (this.f18093b.m() && ((LinearProgressIndicatorSpec) this.f18092a).f18036f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f18093b.n() || this.f18093b.m()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.f18092a).f18031a * (f8 - 1.0f)) / 2.0f);
        }
        float f10 = this.f18099c;
        canvas.clipRect((-f10) / 2.0f, (-f9) / 2.0f, f10 / 2.0f, f9 / 2.0f);
        S s7 = this.f18092a;
        this.f18100d = ((LinearProgressIndicatorSpec) s7).f18031a * f8;
        this.f18101e = ((LinearProgressIndicatorSpec) s7).f18032b * f8;
    }

    @Override // com.google.android.material.progressindicator.g
    public void b(@m0 Canvas canvas, @m0 Paint paint, @v(from = 0.0d, to = 1.0d) float f8, @v(from = 0.0d, to = 1.0d) float f9, @c.l int i7) {
        if (f8 == f9) {
            return;
        }
        float f10 = this.f18099c;
        float f11 = this.f18101e;
        float f12 = ((-f10) / 2.0f) + f11 + ((f10 - (f11 * 2.0f)) * f8);
        float f13 = ((-f10) / 2.0f) + f11 + ((f10 - (f11 * 2.0f)) * f9);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i7);
        float f14 = this.f18100d;
        canvas.drawRect(f12, (-f14) / 2.0f, f13, f14 / 2.0f, paint);
        float f15 = this.f18101e;
        RectF rectF = new RectF(-f15, -f15, f15, f15);
        h(canvas, paint, this.f18100d, this.f18101e, f12, true, rectF);
        h(canvas, paint, this.f18100d, this.f18101e, f13, false, rectF);
    }

    @Override // com.google.android.material.progressindicator.g
    void c(@m0 Canvas canvas, @m0 Paint paint) {
        int iA = k1.a.a(((LinearProgressIndicatorSpec) this.f18092a).f18034d, this.f18093b.getAlpha());
        float f8 = ((-this.f18099c) / 2.0f) + this.f18101e;
        float f9 = -f8;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iA);
        float f10 = this.f18100d;
        canvas.drawRect(f8, (-f10) / 2.0f, f9, f10 / 2.0f, paint);
        float f11 = this.f18101e;
        RectF rectF = new RectF(-f11, -f11, f11, f11);
        h(canvas, paint, this.f18100d, this.f18101e, f8, true, rectF);
        h(canvas, paint, this.f18100d, this.f18101e, f9, false, rectF);
    }

    @Override // com.google.android.material.progressindicator.g
    public int d() {
        return ((LinearProgressIndicatorSpec) this.f18092a).f18031a;
    }

    @Override // com.google.android.material.progressindicator.g
    public int e() {
        return -1;
    }
}
