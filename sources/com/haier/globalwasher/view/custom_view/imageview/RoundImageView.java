package com.haier.globalwasher.view.custom_view.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public class RoundImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f25843t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f25844u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f25845v = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f25848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f25849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f25850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f25851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f25852j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f25853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Paint f25854l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Paint f25855m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f25856n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Matrix f25857o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BitmapShader f25858p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f25859q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private RectF f25860r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Path f25861s;

    public RoundImageView(Context context) {
        this(context, null);
    }

    private int b(int i7) {
        return (int) TypedValue.applyDimension(1, i7, getResources().getDisplayMetrics());
    }

    private Bitmap d(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void e() {
        this.f25861s = new Path();
        this.f25857o = new Matrix();
        Paint paint = new Paint();
        this.f25854l = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f25855m = paint2;
        paint2.setAntiAlias(true);
        this.f25855m.setStyle(Paint.Style.STROKE);
    }

    private void m() {
        this.f25861s.reset();
        float f8 = this.f25850h;
        if (f8 == 0.0f && this.f25852j == 0.0f && this.f25851i == 0.0f && this.f25853k == 0.0f) {
            Path path = this.f25861s;
            RectF rectF = this.f25860r;
            float f9 = this.f25849g;
            path.addRoundRect(rectF, new float[]{f9, f9, f9, f9, f9, f9, f9, f9}, Path.Direction.CW);
            return;
        }
        Path path2 = this.f25861s;
        RectF rectF2 = this.f25860r;
        float f10 = this.f25851i;
        float f11 = this.f25853k;
        float f12 = this.f25852j;
        path2.addRoundRect(rectF2, new float[]{f8, f8, f10, f10, f11, f11, f12, f12}, Path.Direction.CW);
    }

    private void o() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Bitmap bitmapD = d(drawable);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f25858p = new BitmapShader(bitmapD, tileMode, tileMode);
        int i7 = this.f25846d;
        float fMax = 1.0f;
        if (i7 == 0) {
            fMax = (this.f25859q * 1.0f) / Math.min(bitmapD.getWidth(), bitmapD.getHeight());
            this.f25857o.setTranslate(-(((bitmapD.getWidth() * fMax) - this.f25859q) / 2.0f), -(((bitmapD.getHeight() * fMax) - this.f25859q) / 2.0f));
        } else if ((i7 == 1 || i7 == 2) && (bitmapD.getWidth() != getWidth() || bitmapD.getHeight() != getHeight())) {
            fMax = Math.max((getWidth() * 1.0f) / bitmapD.getWidth(), (getHeight() * 1.0f) / bitmapD.getHeight());
            this.f25857o.setTranslate(-(((bitmapD.getWidth() * fMax) - getWidth()) / 2.0f), -(((bitmapD.getHeight() * fMax) - getHeight()) / 2.0f));
        }
        this.f25857o.preScale(fMax, fMax);
        this.f25858p.setLocalMatrix(this.f25857o);
        this.f25858p.setLocalMatrix(this.f25857o);
        this.f25854l.setShader(this.f25858p);
    }

    public RoundImageView f(int i7) {
        if (this.f25847e != i7) {
            this.f25847e = i7;
            invalidate();
        }
        return this;
    }

    public RoundImageView g(int i7) {
        float fB = b(i7);
        if (this.f25848f != fB) {
            this.f25848f = fB;
            invalidate();
        }
        return this;
    }

    public RoundImageView h(int i7) {
        float fB = b(i7);
        if (this.f25849g != fB) {
            this.f25849g = fB;
            invalidate();
        }
        return this;
    }

    public RoundImageView i(int i7) {
        float fB = b(i7);
        if (this.f25852j != fB) {
            this.f25852j = fB;
            invalidate();
        }
        return this;
    }

    public RoundImageView j(int i7) {
        float fB = b(i7);
        if (this.f25850h != fB) {
            this.f25850h = fB;
            invalidate();
        }
        return this;
    }

    public RoundImageView k(int i7) {
        float fB = b(i7);
        if (this.f25853k != fB) {
            this.f25853k = fB;
            invalidate();
        }
        return this;
    }

    public RoundImageView l(int i7) {
        float fB = b(i7);
        if (this.f25851i != fB) {
            this.f25851i = fB;
            invalidate();
        }
        return this;
    }

    public RoundImageView n(int i7) {
        if (this.f25846d != i7) {
            this.f25846d = i7;
            if (i7 != 1 && i7 != 0 && i7 != 2) {
                this.f25846d = 2;
            }
            requestLayout();
        }
        return this;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f25855m.setColor(this.f25847e);
        this.f25855m.setStrokeWidth(this.f25848f);
        if (getDrawable() == null) {
            return;
        }
        o();
        int i7 = this.f25846d;
        if (i7 == 1) {
            m();
            canvas.drawPath(this.f25861s, this.f25854l);
            canvas.drawPath(this.f25861s, this.f25855m);
        } else {
            if (i7 != 0) {
                canvas.drawOval(this.f25860r, this.f25854l);
                canvas.drawOval(this.f25860r, this.f25855m);
                return;
            }
            float f8 = this.f25856n;
            float f9 = this.f25848f;
            canvas.drawCircle((f9 / 2.0f) + f8, (f9 / 2.0f) + f8, f8, this.f25854l);
            float f10 = this.f25856n;
            float f11 = this.f25848f;
            canvas.drawCircle((f11 / 2.0f) + f10, (f11 / 2.0f) + f10, f10, this.f25855m);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (this.f25846d == 0) {
            int iMin = Math.min(View.MeasureSpec.getSize(i7), View.MeasureSpec.getSize(i8));
            this.f25859q = iMin;
            this.f25856n = (iMin / 2) - (this.f25848f / 2.0f);
            setMeasuredDimension(iMin, iMin);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        int i11 = this.f25846d;
        if (i11 == 1 || i11 == 2) {
            float f8 = this.f25848f;
            this.f25860r = new RectF(f8 / 2.0f, f8 / 2.0f, i7 - (f8 / 2.0f), i8 - (f8 / 2.0f));
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundImageView_View, i7, 0);
        this.f25846d = typedArrayObtainStyledAttributes.getInt(R.styleable.RoundImageView_View_radius_type, 2);
        this.f25847e = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundImageView_View_border_color, -1);
        this.f25848f = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundImageView_View_border_width, 0.0f);
        this.f25849g = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundImageView_View_corner_radius, b(10));
        this.f25850h = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundImageView_View_leftTop_corner_radius, 0.0f);
        this.f25852j = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundImageView_View_leftBottom_corner_radius, 0.0f);
        this.f25851i = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundImageView_View_rightTop_corner_radius, 0.0f);
        this.f25853k = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundImageView_View_rightBottom_corner_radius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        e();
    }
}
