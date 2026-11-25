package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public abstract class p extends Drawable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f5815n = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Bitmap f5816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5817b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BitmapShader f5820e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f5822g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f5827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f5828m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5818c = 119;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Paint f5819d = new Paint(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Matrix f5821f = new Matrix();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Rect f5823h = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f5824i = new RectF();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f5825j = true;

    p(Resources resources, Bitmap bitmap) {
        this.f5817b = 160;
        if (resources != null) {
            this.f5817b = resources.getDisplayMetrics().densityDpi;
        }
        this.f5816a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f5820e = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.f5828m = -1;
            this.f5827l = -1;
            this.f5820e = null;
        }
    }

    private void a() {
        this.f5827l = this.f5816a.getScaledWidth(this.f5817b);
        this.f5828m = this.f5816a.getScaledHeight(this.f5817b);
    }

    private static boolean j(float f8) {
        return f8 > 0.05f;
    }

    private void s() {
        this.f5822g = Math.min(this.f5828m, this.f5827l) / 2;
    }

    @o0
    public final Bitmap b() {
        return this.f5816a;
    }

    public float c() {
        return this.f5822g;
    }

    public int d() {
        return this.f5818c;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        Bitmap bitmap = this.f5816a;
        if (bitmap == null) {
            return;
        }
        t();
        if (this.f5819d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f5823h, this.f5819d);
            return;
        }
        RectF rectF = this.f5824i;
        float f8 = this.f5822g;
        canvas.drawRoundRect(rectF, f8, f8, this.f5819d);
    }

    @m0
    public final Paint e() {
        return this.f5819d;
    }

    void f(int i7, int i8, int i9, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public boolean g() {
        return this.f5819d.isAntiAlias();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5819d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f5819d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5828m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5827l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f5818c != 119 || this.f5826k || (bitmap = this.f5816a) == null || bitmap.hasAlpha() || this.f5819d.getAlpha() < 255 || j(this.f5822g)) ? -3 : -1;
    }

    public boolean h() {
        throw new UnsupportedOperationException();
    }

    public boolean i() {
        return this.f5826k;
    }

    public void k(boolean z7) {
        this.f5819d.setAntiAlias(z7);
        invalidateSelf();
    }

    public void l(boolean z7) {
        this.f5826k = z7;
        this.f5825j = true;
        if (!z7) {
            m(0.0f);
            return;
        }
        s();
        this.f5819d.setShader(this.f5820e);
        invalidateSelf();
    }

    public void m(float f8) {
        if (this.f5822g == f8) {
            return;
        }
        this.f5826k = false;
        if (j(f8)) {
            this.f5819d.setShader(this.f5820e);
        } else {
            this.f5819d.setShader(null);
        }
        this.f5822g = f8;
        invalidateSelf();
    }

    public void n(int i7) {
        if (this.f5818c != i7) {
            this.f5818c = i7;
            this.f5825j = true;
            invalidateSelf();
        }
    }

    public void o(boolean z7) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@m0 Rect rect) {
        super.onBoundsChange(rect);
        if (this.f5826k) {
            s();
        }
        this.f5825j = true;
    }

    public void p(int i7) {
        if (this.f5817b != i7) {
            if (i7 == 0) {
                i7 = 160;
            }
            this.f5817b = i7;
            if (this.f5816a != null) {
                a();
            }
            invalidateSelf();
        }
    }

    public void q(@m0 Canvas canvas) {
        p(canvas.getDensity());
    }

    public void r(@m0 DisplayMetrics displayMetrics) {
        p(displayMetrics.densityDpi);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        if (i7 != this.f5819d.getAlpha()) {
            this.f5819d.setAlpha(i7);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5819d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z7) {
        this.f5819d.setDither(z7);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z7) {
        this.f5819d.setFilterBitmap(z7);
        invalidateSelf();
    }

    void t() {
        if (this.f5825j) {
            if (this.f5826k) {
                int iMin = Math.min(this.f5827l, this.f5828m);
                f(this.f5818c, iMin, iMin, getBounds(), this.f5823h);
                int iMin2 = Math.min(this.f5823h.width(), this.f5823h.height());
                this.f5823h.inset(Math.max(0, (this.f5823h.width() - iMin2) / 2), Math.max(0, (this.f5823h.height() - iMin2) / 2));
                this.f5822g = iMin2 * 0.5f;
            } else {
                f(this.f5818c, this.f5827l, this.f5828m, getBounds(), this.f5823h);
            }
            this.f5824i.set(this.f5823h);
            if (this.f5820e != null) {
                Matrix matrix = this.f5821f;
                RectF rectF = this.f5824i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f5821f.preScale(this.f5824i.width() / this.f5816a.getWidth(), this.f5824i.height() / this.f5816a.getHeight());
                this.f5820e.setLocalMatrix(this.f5821f);
                this.f5819d.setShader(this.f5820e);
            }
            this.f5825j = false;
        }
    }
}
