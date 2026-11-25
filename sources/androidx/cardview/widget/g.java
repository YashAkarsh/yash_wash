package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
class g extends Drawable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final double f2236q = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final float f2237r = 1.5f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static a f2238s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2239a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f2241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f2242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f2243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Path f2245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f2246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f2247i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f2248j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f2249k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f2251m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f2252n;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2250l = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2253o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f2254p = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f2240b = new Paint(5);

    interface a {
        void a(Canvas canvas, RectF rectF, float f8, Paint paint);
    }

    g(Resources resources, ColorStateList colorStateList, float f8, float f9, float f10) {
        this.f2251m = resources.getColor(R.color.cardview_shadow_start_color);
        this.f2252n = resources.getColor(R.color.cardview_shadow_end_color);
        this.f2239a = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f2241c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2244f = (int) (f8 + 0.5f);
        this.f2243e = new RectF();
        Paint paint2 = new Paint(this.f2241c);
        this.f2242d = paint2;
        paint2.setAntiAlias(false);
        s(f9, f10);
    }

    private void a(Rect rect) {
        float f8 = this.f2246h;
        float f9 = f2237r * f8;
        this.f2243e.set(rect.left + f8, rect.top + f9, rect.right - f8, rect.bottom - f9);
        b();
    }

    private void b() {
        float f8 = this.f2244f;
        RectF rectF = new RectF(-f8, -f8, f8, f8);
        RectF rectF2 = new RectF(rectF);
        float f9 = this.f2247i;
        rectF2.inset(-f9, -f9);
        Path path = this.f2245g;
        if (path == null) {
            this.f2245g = new Path();
        } else {
            path.reset();
        }
        this.f2245g.setFillType(Path.FillType.EVEN_ODD);
        this.f2245g.moveTo(-this.f2244f, 0.0f);
        this.f2245g.rLineTo(-this.f2247i, 0.0f);
        this.f2245g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f2245g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f2245g.close();
        float f10 = this.f2244f;
        float f11 = f10 / (this.f2247i + f10);
        Paint paint = this.f2241c;
        float f12 = this.f2244f + this.f2247i;
        int i7 = this.f2251m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f12, new int[]{i7, i7, this.f2252n}, new float[]{0.0f, f11, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f2242d;
        float f13 = this.f2244f;
        float f14 = this.f2247i;
        int i8 = this.f2251m;
        paint2.setShader(new LinearGradient(0.0f, (-f13) + f14, 0.0f, (-f13) - f14, new int[]{i8, i8, this.f2252n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f2242d.setAntiAlias(false);
    }

    static float c(float f8, float f9, boolean z7) {
        return z7 ? (float) (((double) f8) + ((1.0d - f2236q) * ((double) f9))) : f8;
    }

    static float d(float f8, float f9, boolean z7) {
        return z7 ? (float) (((double) (f8 * f2237r)) + ((1.0d - f2236q) * ((double) f9))) : f8 * f2237r;
    }

    private void e(Canvas canvas) {
        float f8 = this.f2244f;
        float f9 = (-f8) - this.f2247i;
        float f10 = f8 + this.f2239a + (this.f2248j / 2.0f);
        float f11 = f10 * 2.0f;
        boolean z7 = this.f2243e.width() - f11 > 0.0f;
        boolean z8 = this.f2243e.height() - f11 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f2243e;
        canvas.translate(rectF.left + f10, rectF.top + f10);
        canvas.drawPath(this.f2245g, this.f2241c);
        if (z7) {
            canvas.drawRect(0.0f, f9, this.f2243e.width() - f11, -this.f2244f, this.f2242d);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.f2243e;
        canvas.translate(rectF2.right - f10, rectF2.bottom - f10);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f2245g, this.f2241c);
        if (z7) {
            canvas.drawRect(0.0f, f9, this.f2243e.width() - f11, (-this.f2244f) + this.f2247i, this.f2242d);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.f2243e;
        canvas.translate(rectF3.left + f10, rectF3.bottom - f10);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f2245g, this.f2241c);
        if (z8) {
            canvas.drawRect(0.0f, f9, this.f2243e.height() - f11, -this.f2244f, this.f2242d);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.f2243e;
        canvas.translate(rectF4.right - f10, rectF4.top + f10);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f2245g, this.f2241c);
        if (z8) {
            canvas.drawRect(0.0f, f9, this.f2243e.height() - f11, -this.f2244f, this.f2242d);
        }
        canvas.restoreToCount(iSave4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2249k = colorStateList;
        this.f2240b.setColor(colorStateList.getColorForState(getState(), this.f2249k.getDefaultColor()));
    }

    private void s(float f8, float f9) {
        if (f8 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f8 + ". Must be >= 0");
        }
        if (f9 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f9 + ". Must be >= 0");
        }
        float fT = t(f8);
        float fT2 = t(f9);
        if (fT > fT2) {
            if (!this.f2254p) {
                this.f2254p = true;
            }
            fT = fT2;
        }
        if (this.f2248j == fT && this.f2246h == fT2) {
            return;
        }
        this.f2248j = fT;
        this.f2246h = fT2;
        this.f2247i = (int) ((fT * f2237r) + this.f2239a + 0.5f);
        this.f2250l = true;
        invalidateSelf();
    }

    private int t(float f8) {
        int i7 = (int) (f8 + 0.5f);
        return i7 % 2 == 1 ? i7 - 1 : i7;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2250l) {
            a(getBounds());
            this.f2250l = false;
        }
        canvas.translate(0.0f, this.f2248j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f2248j) / 2.0f);
        f2238s.a(canvas, this.f2243e, this.f2244f, this.f2240b);
    }

    ColorStateList f() {
        return this.f2249k;
    }

    float g() {
        return this.f2244f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.f2246h, this.f2244f, this.f2253o));
        int iCeil2 = (int) Math.ceil(c(this.f2246h, this.f2244f, this.f2253o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    void h(Rect rect) {
        getPadding(rect);
    }

    float i() {
        return this.f2246h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f2249k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    float j() {
        float f8 = this.f2246h;
        return (Math.max(f8, this.f2244f + this.f2239a + ((f8 * f2237r) / 2.0f)) * 2.0f) + (((this.f2246h * f2237r) + this.f2239a) * 2.0f);
    }

    float k() {
        float f8 = this.f2246h;
        return (Math.max(f8, this.f2244f + this.f2239a + (f8 / 2.0f)) * 2.0f) + ((this.f2246h + this.f2239a) * 2.0f);
    }

    float l() {
        return this.f2248j;
    }

    void m(boolean z7) {
        this.f2253o = z7;
        invalidateSelf();
    }

    void o(@o0 ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2250l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f2249k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f2240b.getColor() == colorForState) {
            return false;
        }
        this.f2240b.setColor(colorForState);
        this.f2250l = true;
        invalidateSelf();
        return true;
    }

    void p(float f8) {
        if (f8 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f8 + ". Must be >= 0");
        }
        float f9 = (int) (f8 + 0.5f);
        if (this.f2244f == f9) {
            return;
        }
        this.f2244f = f9;
        this.f2250l = true;
        invalidateSelf();
    }

    void q(float f8) {
        s(this.f2248j, f8);
    }

    void r(float f8) {
        s(f8, this.f2246h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f2240b.setAlpha(i7);
        this.f2241c.setAlpha(i7);
        this.f2242d.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2240b.setColorFilter(colorFilter);
    }
}
