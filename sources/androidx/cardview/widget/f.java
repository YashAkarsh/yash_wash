package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f2225a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f2227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f2228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2229e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f2232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f2233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f2234j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2230f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2231g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f2235k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f2226b = new Paint(5);

    f(ColorStateList colorStateList, float f8) {
        this.f2225a = f8;
        e(colorStateList);
        this.f2227c = new RectF();
        this.f2228d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2232h = colorStateList;
        this.f2226b.setColor(colorStateList.getColorForState(getState(), this.f2232h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2227c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f2228d.set(rect);
        if (this.f2230f) {
            this.f2228d.inset((int) Math.ceil(g.c(this.f2229e, this.f2225a, this.f2231g)), (int) Math.ceil(g.d(this.f2229e, this.f2225a, this.f2231g)));
            this.f2227c.set(this.f2228d);
        }
    }

    public ColorStateList b() {
        return this.f2232h;
    }

    float c() {
        return this.f2229e;
    }

    public float d() {
        return this.f2225a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z7;
        Paint paint = this.f2226b;
        if (this.f2233i == null || paint.getColorFilter() != null) {
            z7 = false;
        } else {
            paint.setColorFilter(this.f2233i);
            z7 = true;
        }
        RectF rectF = this.f2227c;
        float f8 = this.f2225a;
        canvas.drawRoundRect(rectF, f8, f8, paint);
        if (z7) {
            paint.setColorFilter(null);
        }
    }

    public void f(@o0 ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f8, boolean z7, boolean z8) {
        if (f8 == this.f2229e && this.f2230f == z7 && this.f2231g == z8) {
            return;
        }
        this.f2229e = f8;
        this.f2230f = z7;
        this.f2231g = z8;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2228d, this.f2225a);
    }

    void h(float f8) {
        if (f8 == this.f2225a) {
            return;
        }
        this.f2225a = f8;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f2234j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f2232h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f2232h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z7 = colorForState != this.f2226b.getColor();
        if (z7) {
            this.f2226b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f2234j;
        if (colorStateList2 == null || (mode = this.f2235k) == null) {
            return z7;
        }
        this.f2233i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f2226b.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2226b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2234j = colorStateList;
        this.f2233i = a(colorStateList, this.f2235k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2235k = mode;
        this.f2233i = a(this.f2234j, mode);
        invalidateSelf();
    }
}
