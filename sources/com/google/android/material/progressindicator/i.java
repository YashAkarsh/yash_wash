package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import c.m0;
import c.o0;
import com.google.android.material.progressindicator.b;

/* JADX INFO: loaded from: classes.dex */
public final class i<S extends b> extends f {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private g<S> f18097r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private h<ObjectAnimator> f18098s;

    i(@m0 Context context, @m0 b bVar, @m0 g<S> gVar, @m0 h<ObjectAnimator> hVar) {
        super(context, bVar);
        C(gVar);
        B(hVar);
    }

    @m0
    public static i<CircularProgressIndicatorSpec> x(@m0 Context context, @m0 CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new i<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec), new d(circularProgressIndicatorSpec));
    }

    @m0
    public static i<LinearProgressIndicatorSpec> y(@m0 Context context, @m0 LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new i<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec), linearProgressIndicatorSpec.f18027g == 0 ? new k(linearProgressIndicatorSpec) : new l(context, linearProgressIndicatorSpec));
    }

    @m0
    g<S> A() {
        return this.f18097r;
    }

    void B(@m0 h<ObjectAnimator> hVar) {
        this.f18098s = hVar;
        hVar.e(this);
    }

    void C(@m0 g<S> gVar) {
        this.f18097r = gVar;
        gVar.f(this);
    }

    @Override // com.google.android.material.progressindicator.f, androidx.vectordrawable.graphics.drawable.b
    public /* bridge */ /* synthetic */ void b(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        super.b(aVar);
    }

    @Override // com.google.android.material.progressindicator.f, androidx.vectordrawable.graphics.drawable.b
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.material.progressindicator.f, androidx.vectordrawable.graphics.drawable.b
    public /* bridge */ /* synthetic */ boolean d(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        return super.d(aVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        this.f18097r.g(canvas, j());
        this.f18097r.c(canvas, this.f18088m);
        int i7 = 0;
        while (true) {
            h<ObjectAnimator> hVar = this.f18098s;
            int[] iArr = hVar.f18096c;
            if (i7 >= iArr.length) {
                canvas.restore();
                return;
            }
            g<S> gVar = this.f18097r;
            Paint paint = this.f18088m;
            float[] fArr = hVar.f18095b;
            int i8 = i7 * 2;
            gVar.b(canvas, paint, fArr[i8], fArr[i8 + 1], iArr[i7]);
            i7++;
        }
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f18097r.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f18097r.e();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean n() {
        return super.n();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i7) {
        super.setAlpha(i7);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@o0 ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z7, boolean z8) {
        return super.setVisible(z7, z8);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean v(boolean z7, boolean z8, boolean z9) {
        return super.v(z7, z8, z9);
    }

    @Override // com.google.android.material.progressindicator.f
    boolean w(boolean z7, boolean z8, boolean z9) {
        boolean zW = super.w(z7, z8, z9);
        if (!isRunning()) {
            this.f18098s.a();
        }
        this.f18078c.a(this.f18076a.getContentResolver());
        if (z7 && z9) {
            this.f18098s.g();
        }
        return zW;
    }

    @m0
    h<ObjectAnimator> z() {
        return this.f18098s;
    }
}
