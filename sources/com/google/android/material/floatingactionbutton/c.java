package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.v1;
import c.e0;
import c.l;
import c.m0;
import c.o0;
import c.q;
import c.x0;
import com.google.android.material.shape.o;
import com.google.android.material.shape.p;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
class c extends Drawable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f17649q = 1.3333f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Paint f17651b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @q
    float f17657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    private int f17658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    private int f17659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    private int f17660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @l
    private int f17661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @l
    private int f17662m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private o f17664o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private ColorStateList f17665p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f17650a = p.k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f17652c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f17653d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f17654e = new RectF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f17655f = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f17656g = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17663n = true;

    private class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @m0
        public Drawable newDrawable() {
            return c.this;
        }
    }

    c(o oVar) {
        this.f17664o = oVar;
        Paint paint = new Paint(1);
        this.f17651b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @m0
    private Shader a() {
        Rect rect = this.f17653d;
        copyBounds(rect);
        float fHeight = this.f17657h / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{v1.t(this.f17658i, this.f17662m), v1.t(this.f17659j, this.f17662m), v1.t(v1.B(this.f17659j, 0), this.f17662m), v1.t(v1.B(this.f17661l, 0), this.f17662m), v1.t(this.f17661l, this.f17662m), v1.t(this.f17660k, this.f17662m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    @m0
    protected RectF b() {
        this.f17655f.set(getBounds());
        return this.f17655f;
    }

    public o c() {
        return this.f17664o;
    }

    void d(@o0 ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f17662m = colorStateList.getColorForState(getState(), this.f17662m);
        }
        this.f17665p = colorStateList;
        this.f17663n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        if (this.f17663n) {
            this.f17651b.setShader(a());
            this.f17663n = false;
        }
        float strokeWidth = this.f17651b.getStrokeWidth() / 2.0f;
        copyBounds(this.f17653d);
        this.f17654e.set(this.f17653d);
        float fMin = Math.min(this.f17664o.r().a(b()), this.f17654e.width() / 2.0f);
        if (this.f17664o.u(b())) {
            this.f17654e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f17654e, fMin, fMin, this.f17651b);
        }
    }

    public void e(@q float f8) {
        if (this.f17657h != f8) {
            this.f17657h = f8;
            this.f17651b.setStrokeWidth(f8 * f17649q);
            this.f17663n = true;
            invalidateSelf();
        }
    }

    void f(@l int i7, @l int i8, @l int i9, @l int i10) {
        this.f17658i = i7;
        this.f17659j = i8;
        this.f17660k = i9;
        this.f17661l = i10;
    }

    public void g(o oVar) {
        this.f17664o = oVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @o0
    public Drawable.ConstantState getConstantState() {
        return this.f17656g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f17657h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@m0 Outline outline) {
        if (this.f17664o.u(b())) {
            outline.setRoundRect(getBounds(), this.f17664o.r().a(b()));
            return;
        }
        copyBounds(this.f17653d);
        this.f17654e.set(this.f17653d);
        this.f17650a.d(this.f17664o, 1.0f, this.f17654e, this.f17652c);
        if (this.f17652c.isConvex()) {
            outline.setConvexPath(this.f17652c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@m0 Rect rect) {
        if (!this.f17664o.u(b())) {
            return true;
        }
        int iRound = Math.round(this.f17657h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f17665p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f17663n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f17665p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f17662m)) != this.f17662m) {
            this.f17663n = true;
            this.f17662m = colorForState;
        }
        if (this.f17663n) {
            invalidateSelf();
        }
        return this.f17663n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@e0(from = 0, to = 255) int i7) {
        this.f17651b.setAlpha(i7);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@o0 ColorFilter colorFilter) {
        this.f17651b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
