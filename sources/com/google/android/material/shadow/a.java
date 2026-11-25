package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.content.d;
import c.m0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class a extends androidx.appcompat.graphics.drawable.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final double f18177r = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final float f18178s = 1.5f;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final float f18179t = 0.25f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final float f18180u = 0.5f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final float f18181v = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    final Paint f18182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    final Paint f18183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    final RectF f18184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f18185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Path f18186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f18187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f18188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f18189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f18190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f18192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f18193m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f18194n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f18195o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f18196p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f18197q;

    public a(Context context, Drawable drawable, float f8, float f9, float f10) {
        super(drawable);
        this.f18191k = true;
        this.f18195o = true;
        this.f18197q = false;
        this.f18192l = d.f(context, R.color.design_fab_shadow_start_color);
        this.f18193m = d.f(context, R.color.design_fab_shadow_mid_color);
        this.f18194n = d.f(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.f18182b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f18185e = Math.round(f8);
        this.f18184d = new RectF();
        Paint paint2 = new Paint(paint);
        this.f18183c = paint2;
        paint2.setAntiAlias(false);
        r(f9, f10);
    }

    private void c(@m0 Rect rect) {
        float f8 = this.f18188h;
        float f9 = f18178s * f8;
        this.f18184d.set(rect.left + f8, rect.top + f9, rect.right - f8, rect.bottom - f9);
        Drawable drawableA = a();
        RectF rectF = this.f18184d;
        drawableA.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        d();
    }

    private void d() {
        float f8 = this.f18185e;
        RectF rectF = new RectF(-f8, -f8, f8, f8);
        RectF rectF2 = new RectF(rectF);
        float f9 = this.f18189i;
        rectF2.inset(-f9, -f9);
        Path path = this.f18186f;
        if (path == null) {
            this.f18186f = new Path();
        } else {
            path.reset();
        }
        this.f18186f.setFillType(Path.FillType.EVEN_ODD);
        this.f18186f.moveTo(-this.f18185e, 0.0f);
        this.f18186f.rLineTo(-this.f18189i, 0.0f);
        this.f18186f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f18186f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f18186f.close();
        float f10 = -rectF2.top;
        if (f10 > 0.0f) {
            float f11 = this.f18185e / f10;
            this.f18182b.setShader(new RadialGradient(0.0f, 0.0f, f10, new int[]{0, this.f18192l, this.f18193m, this.f18194n}, new float[]{0.0f, f11, ((1.0f - f11) / 2.0f) + f11, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f18183c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.f18192l, this.f18193m, this.f18194n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f18183c.setAntiAlias(false);
    }

    public static float e(float f8, float f9, boolean z7) {
        return z7 ? (float) (((double) f8) + ((1.0d - f18177r) * ((double) f9))) : f8;
    }

    public static float f(float f8, float f9, boolean z7) {
        return z7 ? (float) (((double) (f8 * f18178s)) + ((1.0d - f18177r) * ((double) f9))) : f8 * f18178s;
    }

    private void g(@m0 Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(this.f18196p, this.f18184d.centerX(), this.f18184d.centerY());
        float f8 = this.f18185e;
        float f9 = (-f8) - this.f18189i;
        float f10 = f8 * 2.0f;
        boolean z7 = this.f18184d.width() - f10 > 0.0f;
        boolean z8 = this.f18184d.height() - f10 > 0.0f;
        float f11 = this.f18190j;
        float f12 = f8 / ((f11 - (0.5f * f11)) + f8);
        float f13 = f8 / ((f11 - (f18179t * f11)) + f8);
        float f14 = f8 / ((f11 - (f11 * 1.0f)) + f8);
        int iSave2 = canvas.save();
        RectF rectF = this.f18184d;
        canvas.translate(rectF.left + f8, rectF.top + f8);
        canvas.scale(f12, f13);
        canvas.drawPath(this.f18186f, this.f18182b);
        if (z7) {
            canvas.scale(1.0f / f12, 1.0f);
            canvas.drawRect(0.0f, f9, this.f18184d.width() - f10, -this.f18185e, this.f18183c);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF2 = this.f18184d;
        canvas.translate(rectF2.right - f8, rectF2.bottom - f8);
        canvas.scale(f12, f14);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f18186f, this.f18182b);
        if (z7) {
            canvas.scale(1.0f / f12, 1.0f);
            canvas.drawRect(0.0f, f9, this.f18184d.width() - f10, (-this.f18185e) + this.f18189i, this.f18183c);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF3 = this.f18184d;
        canvas.translate(rectF3.left + f8, rectF3.bottom - f8);
        canvas.scale(f12, r6);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f18186f, this.f18182b);
        if (z8) {
            canvas.scale(1.0f / f14, 1.0f);
            canvas.drawRect(0.0f, f9, this.f18184d.height() - f10, -this.f18185e, this.f18183c);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        RectF rectF4 = this.f18184d;
        canvas.translate(rectF4.right - f8, rectF4.top + f8);
        canvas.scale(f12, f13);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f18186f, this.f18182b);
        if (z8) {
            canvas.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f9, this.f18184d.height() - f10, -this.f18185e, this.f18183c);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(iSave);
    }

    private static int s(float f8) {
        int iRound = Math.round(f8);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        if (this.f18191k) {
            c(getBounds());
            this.f18191k = false;
        }
        g(canvas);
        super.draw(canvas);
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    public boolean getPadding(@m0 Rect rect) {
        int iCeil = (int) Math.ceil(f(this.f18188h, this.f18185e, this.f18195o));
        int iCeil2 = (int) Math.ceil(e(this.f18188h, this.f18185e, this.f18195o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public float h() {
        return this.f18185e;
    }

    public float i() {
        return this.f18188h;
    }

    public float j() {
        float f8 = this.f18188h;
        return (Math.max(f8, this.f18185e + ((f8 * f18178s) / 2.0f)) * 2.0f) + (this.f18188h * f18178s * 2.0f);
    }

    public float k() {
        float f8 = this.f18188h;
        return (Math.max(f8, this.f18185e + (f8 / 2.0f)) * 2.0f) + (this.f18188h * 2.0f);
    }

    public float l() {
        return this.f18190j;
    }

    public void m(boolean z7) {
        this.f18195o = z7;
        invalidateSelf();
    }

    public void n(float f8) {
        float fRound = Math.round(f8);
        if (this.f18185e == fRound) {
            return;
        }
        this.f18185e = fRound;
        this.f18191k = true;
        invalidateSelf();
    }

    public void o(float f8) {
        r(this.f18190j, f8);
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f18191k = true;
    }

    public final void p(float f8) {
        if (this.f18196p != f8) {
            this.f18196p = f8;
            invalidateSelf();
        }
    }

    public void q(float f8) {
        r(f8, this.f18188h);
    }

    public void r(float f8, float f9) {
        if (f8 < 0.0f || f9 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float fS = s(f8);
        float fS2 = s(f9);
        if (fS > fS2) {
            if (!this.f18197q) {
                this.f18197q = true;
            }
            fS = fS2;
        }
        if (this.f18190j == fS && this.f18188h == fS2) {
            return;
        }
        this.f18190j = fS;
        this.f18188h = fS2;
        this.f18189i = Math.round(fS * f18178s);
        this.f18187g = fS2;
        this.f18191k = true;
        invalidateSelf();
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        super.setAlpha(i7);
        this.f18182b.setAlpha(i7);
        this.f18183c.setAlpha(i7);
    }
}
