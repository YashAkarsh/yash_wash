package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;
import c.l;
import c.v;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class d extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f985m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f986n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f987o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f988p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f989q = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f1000k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1001l;

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public d(Context context) {
        Paint paint = new Paint();
        this.f990a = paint;
        this.f996g = new Path();
        this.f998i = false;
        this.f1001l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        p(typedArrayObtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        o(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        s(typedArrayObtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        r(Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f997h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f992c = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f991b = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f993d = typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static float k(float f8, float f9, float f10) {
        return f8 + ((f9 - f8) * f10);
    }

    public float a() {
        return this.f991b;
    }

    public float b() {
        return this.f993d;
    }

    public float c() {
        return this.f992c;
    }

    public float d() {
        return this.f990a.getStrokeWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i7 = this.f1001l;
        boolean z7 = false;
        if (i7 != 0 && (i7 == 1 || (i7 == 3 ? androidx.core.graphics.drawable.d.f(this) == 0 : androidx.core.graphics.drawable.d.f(this) == 1))) {
            z7 = true;
        }
        float f8 = this.f991b;
        float fK = k(this.f992c, (float) Math.sqrt(f8 * f8 * 2.0f), this.f999j);
        float fK2 = k(this.f992c, this.f993d, this.f999j);
        float fRound = Math.round(k(0.0f, this.f1000k, this.f999j));
        float fK3 = k(0.0f, f989q, this.f999j);
        float fK4 = k(z7 ? 0.0f : -180.0f, z7 ? 180.0f : 0.0f, this.f999j);
        double d8 = fK;
        double d9 = fK3;
        boolean z8 = z7;
        float fRound2 = Math.round(Math.cos(d9) * d8);
        float fRound3 = Math.round(d8 * Math.sin(d9));
        this.f996g.rewind();
        float fK5 = k(this.f994e + this.f990a.getStrokeWidth(), -this.f1000k, this.f999j);
        float f9 = (-fK2) / 2.0f;
        this.f996g.moveTo(f9 + fRound, 0.0f);
        this.f996g.rLineTo(fK2 - (fRound * 2.0f), 0.0f);
        this.f996g.moveTo(f9, fK5);
        this.f996g.rLineTo(fRound2, fRound3);
        this.f996g.moveTo(f9, -fK5);
        this.f996g.rLineTo(fRound2, -fRound3);
        this.f996g.close();
        canvas.save();
        float strokeWidth = this.f990a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        float f10 = this.f994e;
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (2.0f * f10))) / 4) * 2) + (strokeWidth * 1.5f) + f10);
        if (this.f995f) {
            canvas.rotate(fK4 * (this.f998i ^ z8 ? -1 : 1));
        } else if (z8) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f996g, this.f990a);
        canvas.restore();
    }

    @l
    public int e() {
        return this.f990a.getColor();
    }

    public int f() {
        return this.f1001l;
    }

    public float g() {
        return this.f994e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f997h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f997h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint h() {
        return this.f990a;
    }

    @v(from = 0.0d, to = 1.0d)
    public float i() {
        return this.f999j;
    }

    public boolean j() {
        return this.f995f;
    }

    public void l(float f8) {
        if (this.f991b != f8) {
            this.f991b = f8;
            invalidateSelf();
        }
    }

    public void m(float f8) {
        if (this.f993d != f8) {
            this.f993d = f8;
            invalidateSelf();
        }
    }

    public void n(float f8) {
        if (this.f992c != f8) {
            this.f992c = f8;
            invalidateSelf();
        }
    }

    public void o(float f8) {
        if (this.f990a.getStrokeWidth() != f8) {
            this.f990a.setStrokeWidth(f8);
            this.f1000k = (float) (((double) (f8 / 2.0f)) * Math.cos(f989q));
            invalidateSelf();
        }
    }

    public void p(@l int i7) {
        if (i7 != this.f990a.getColor()) {
            this.f990a.setColor(i7);
            invalidateSelf();
        }
    }

    public void q(int i7) {
        if (i7 != this.f1001l) {
            this.f1001l = i7;
            invalidateSelf();
        }
    }

    public void r(float f8) {
        if (f8 != this.f994e) {
            this.f994e = f8;
            invalidateSelf();
        }
    }

    public void s(boolean z7) {
        if (this.f995f != z7) {
            this.f995f = z7;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        if (i7 != this.f990a.getAlpha()) {
            this.f990a.setAlpha(i7);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f990a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(@v(from = 0.0d, to = 1.0d) float f8) {
        if (this.f999j != f8) {
            this.f999j = f8;
            invalidateSelf();
        }
    }

    public void t(boolean z7) {
        if (this.f998i != z7) {
            this.f998i = z7;
            invalidateSelf();
        }
    }
}
