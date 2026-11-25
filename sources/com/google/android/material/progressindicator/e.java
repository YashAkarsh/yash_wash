package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import c.m0;
import c.o0;
import com.google.android.material.progressindicator.b;

/* JADX INFO: loaded from: classes.dex */
public final class e<S extends b> extends f {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f18065w = 10000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final float f18066x = 50.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final androidx.dynamicanimation.animation.g<e> f18067y = new a("indicatorLevel");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private g<S> f18068r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final androidx.dynamicanimation.animation.k f18069s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final androidx.dynamicanimation.animation.j f18070t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f18071u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f18072v;

    static class a extends androidx.dynamicanimation.animation.g<e> {
        a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(e eVar) {
            return eVar.C() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(e eVar, float f8) {
            eVar.E(f8 / 10000.0f);
        }
    }

    e(@m0 Context context, @m0 b bVar, @m0 g<S> gVar) {
        super(context, bVar);
        this.f18072v = false;
        D(gVar);
        androidx.dynamicanimation.animation.k kVar = new androidx.dynamicanimation.animation.k();
        this.f18069s = kVar;
        kVar.g(1.0f);
        kVar.i(50.0f);
        androidx.dynamicanimation.animation.j jVar = new androidx.dynamicanimation.animation.j(this, f18067y);
        this.f18070t = jVar;
        jVar.D(kVar);
        p(1.0f);
    }

    @m0
    public static e<LinearProgressIndicatorSpec> A(@m0 Context context, @m0 LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new e<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float C() {
        return this.f18071u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(float f8) {
        this.f18071u = f8;
        invalidateSelf();
    }

    @m0
    public static e<CircularProgressIndicatorSpec> z(@m0 Context context, @m0 CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new e<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec));
    }

    @m0
    g<S> B() {
        return this.f18068r;
    }

    void D(@m0 g<S> gVar) {
        this.f18068r = gVar;
        gVar.f(this);
    }

    void F(float f8) {
        setLevel((int) (f8 * 10000.0f));
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
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f18068r.g(canvas, j());
            this.f18068r.c(canvas, this.f18088m);
            this.f18068r.b(canvas, this.f18088m, 0.0f, C(), k1.a.a(this.f18077b.f18033c[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f18068r.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f18068r.e();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f18070t.d();
        E(getLevel() / 10000.0f);
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

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i7) {
        if (this.f18072v) {
            this.f18070t.d();
            E(i7 / 10000.0f);
            return true;
        }
        this.f18070t.t(C() * 10000.0f);
        this.f18070t.z(i7);
        return true;
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
        float fA = this.f18078c.a(this.f18076a.getContentResolver());
        if (fA == 0.0f) {
            this.f18072v = true;
        } else {
            this.f18072v = false;
            this.f18069s.i(50.0f / fA);
        }
        return zW;
    }
}
