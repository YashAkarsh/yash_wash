package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.motion.widget.c;
import androidx.constraintlayout.motion.widget.e;
import androidx.constraintlayout.widget.R;
import androidx.core.view.n0;
import c.o0;
import c.t0;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: classes.dex */
public class MotionLabel extends View implements e {
    private static final int A0 = 1;
    private static final int B0 = 2;
    private static final int C0 = 3;
    static String W = "MotionLabel";
    private boolean A;
    private float B;
    private float C;
    private float D;
    private Drawable E;
    Matrix F;
    private Bitmap G;
    private BitmapShader H;
    private Matrix I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f4433J;
    private float K;
    private float L;
    private float M;
    Paint N;
    private int O;
    Rect P;
    Paint Q;
    float R;
    float S;
    float T;
    float U;
    float V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextPaint f4434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Path f4435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f4439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f4440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ViewOutlineProvider f4441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    RectF f4442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f4443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f4444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f4446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f4447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f4448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f4449p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Rect f4450q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f4451r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4452s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4453t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4454u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4455v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f4456w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Layout f4457x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4458y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f4459z;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = MotionLabel.this.getWidth();
            int height = MotionLabel.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionLabel.this.f4439f) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.f4440g);
        }
    }

    public MotionLabel(Context context) {
        super(context);
        this.f4434a = new TextPaint();
        this.f4435b = new Path();
        this.f4436c = 65535;
        this.f4437d = 65535;
        this.f4438e = false;
        this.f4439f = 0.0f;
        this.f4440g = Float.NaN;
        this.f4443j = 48.0f;
        this.f4444k = Float.NaN;
        this.f4447n = 0.0f;
        this.f4448o = "Hello World";
        this.f4449p = true;
        this.f4450q = new Rect();
        this.f4452s = 1;
        this.f4453t = 1;
        this.f4454u = 1;
        this.f4455v = 1;
        this.f4458y = BadgeDrawable.f16995r;
        this.f4459z = 0;
        this.A = false;
        this.f4433J = Float.NaN;
        this.K = Float.NaN;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = new Paint();
        this.O = 0;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        this.V = Float.NaN;
        g(context, null);
    }

    private void d(float l7, float t7, float r7, float b8) {
        if (this.I == null) {
            return;
        }
        this.C = r7 - l7;
        this.D = b8 - t7;
        l();
    }

    private void g(Context context, AttributeSet attrs) {
        i(context, attrs);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MotionLabel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(typedArrayObtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.f4456w = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.f4444k = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f4444k);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.f4443j = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f4443j);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.f4445l = typedArrayObtainStyledAttributes.getInt(index, this.f4445l);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.f4446m = typedArrayObtainStyledAttributes.getInt(index, this.f4446m);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.f4436c = typedArrayObtainStyledAttributes.getColor(index, this.f4436c);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = typedArrayObtainStyledAttributes.getDimension(index, this.f4440g);
                    this.f4440g = dimension;
                    setRound(dimension);
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f8 = typedArrayObtainStyledAttributes.getFloat(index, this.f4439f);
                    this.f4439f = f8;
                    setRoundPercent(f8);
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.f4459z = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.f4437d = typedArrayObtainStyledAttributes.getInt(index, this.f4437d);
                    this.f4438e = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.f4447n = typedArrayObtainStyledAttributes.getDimension(index, this.f4447n);
                    this.f4438e = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.E = typedArrayObtainStyledAttributes.getDrawable(index);
                    this.f4438e = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.S = typedArrayObtainStyledAttributes.getFloat(index, this.S);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.T = typedArrayObtainStyledAttributes.getFloat(index, this.T);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.L = typedArrayObtainStyledAttributes.getFloat(index, this.L);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.M = typedArrayObtainStyledAttributes.getFloat(index, this.M);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.U = typedArrayObtainStyledAttributes.getFloat(index, this.U);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.f4433J = typedArrayObtainStyledAttributes.getDimension(index, this.f4433J);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.K = typedArrayObtainStyledAttributes.getDimension(index, this.K);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.O = typedArrayObtainStyledAttributes.getInt(index, this.O);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        k();
        j();
    }

    private float getHorizontalOffset() {
        float f8 = Float.isNaN(this.f4444k) ? 1.0f : this.f4443j / this.f4444k;
        TextPaint textPaint = this.f4434a;
        String str = this.f4448o;
        return (((((Float.isNaN(this.C) ? getMeasuredWidth() : this.C) - getPaddingLeft()) - getPaddingRight()) - (f8 * textPaint.measureText(str, 0, str.length()))) * (this.L + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f8 = Float.isNaN(this.f4444k) ? 1.0f : this.f4443j / this.f4444k;
        Paint.FontMetrics fontMetrics = this.f4434a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.D) ? getMeasuredHeight() : this.D) - getPaddingTop()) - getPaddingBottom();
        float f9 = fontMetrics.descent;
        float f10 = fontMetrics.ascent;
        return (((measuredHeight - ((f9 - f10) * f8)) * (1.0f - this.M)) / 2.0f) - (f8 * f10);
    }

    private void h(String familyName, int typefaceIndex, int styleIndex) {
        Typeface typefaceCreate;
        if (familyName != null) {
            typefaceCreate = Typeface.create(familyName, styleIndex);
            if (typefaceCreate != null) {
                setTypeface(typefaceCreate);
                return;
            }
        } else {
            typefaceCreate = null;
        }
        if (typefaceIndex == 1) {
            typefaceCreate = Typeface.SANS_SERIF;
        } else if (typefaceIndex == 2) {
            typefaceCreate = Typeface.SERIF;
        } else if (typefaceIndex == 3) {
            typefaceCreate = Typeface.MONOSPACE;
        }
        if (styleIndex <= 0) {
            this.f4434a.setFakeBoldText(false);
            this.f4434a.setTextSkewX(0.0f);
            setTypeface(typefaceCreate);
        } else {
            Typeface typefaceDefaultFromStyle = typefaceCreate == null ? Typeface.defaultFromStyle(styleIndex) : Typeface.create(typefaceCreate, styleIndex);
            setTypeface(typefaceDefaultFromStyle);
            int i7 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & styleIndex;
            this.f4434a.setFakeBoldText((i7 & 1) != 0);
            this.f4434a.setTextSkewX((i7 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    private void i(Context context, @o0 AttributeSet attrs) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f4434a;
        int i7 = typedValue.data;
        this.f4436c = i7;
        textPaint.setColor(i7);
    }

    private void k() {
        if (this.E != null) {
            this.I = new Matrix();
            int intrinsicWidth = this.E.getIntrinsicWidth();
            int intrinsicHeight = this.E.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.K) ? 128 : (int) this.K;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.f4433J) ? 128 : (int) this.f4433J;
            }
            if (this.O != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.G = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.G);
            this.E.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.E.setFilterBitmap(true);
            this.E.draw(canvas);
            if (this.O != 0) {
                this.G = e(this.G, 4);
            }
            Bitmap bitmap = this.G;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.H = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void l() {
        float f8 = Float.isNaN(this.S) ? 0.0f : this.S;
        float f9 = Float.isNaN(this.T) ? 0.0f : this.T;
        float f10 = Float.isNaN(this.U) ? 1.0f : this.U;
        float f11 = Float.isNaN(this.V) ? 0.0f : this.V;
        this.I.reset();
        float width = this.G.getWidth();
        float height = this.G.getHeight();
        float f12 = Float.isNaN(this.K) ? this.C : this.K;
        float f13 = Float.isNaN(this.f4433J) ? this.D : this.f4433J;
        float f14 = f10 * (width * f13 < height * f12 ? f12 / width : f13 / height);
        this.I.postScale(f14, f14);
        float f15 = width * f14;
        float f16 = f12 - f15;
        float f17 = f14 * height;
        float f18 = f13 - f17;
        if (!Float.isNaN(this.f4433J)) {
            f18 = this.f4433J / 2.0f;
        }
        if (!Float.isNaN(this.K)) {
            f16 = this.K / 2.0f;
        }
        this.I.postTranslate((((f8 * f16) + f12) - f15) * 0.5f, (((f9 * f18) + f13) - f17) * 0.5f);
        this.I.postRotate(f11, f12 / 2.0f, f13 / 2.0f);
        this.H.setLocalMatrix(this.I);
    }

    @Override // androidx.constraintlayout.motion.widget.e
    public void a(float l7, float t7, float r7, float b8) {
        int i7 = (int) (l7 + 0.5f);
        this.B = l7 - i7;
        int i8 = (int) (r7 + 0.5f);
        int i9 = i8 - i7;
        int i10 = (int) (b8 + 0.5f);
        int i11 = (int) (0.5f + t7);
        int i12 = i10 - i11;
        float f8 = r7 - l7;
        this.C = f8;
        float f9 = b8 - t7;
        this.D = f9;
        d(l7, t7, r7, b8);
        if (getMeasuredHeight() == i12 && getMeasuredWidth() == i9) {
            super.layout(i7, i11, i8, i10);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
            super.layout(i7, i11, i8, i10);
        }
        if (this.A) {
            if (this.P == null) {
                this.Q = new Paint();
                this.P = new Rect();
                this.Q.set(this.f4434a);
                this.R = this.Q.getTextSize();
            }
            this.C = f8;
            this.D = f9;
            Paint paint = this.Q;
            String str = this.f4448o;
            paint.getTextBounds(str, 0, str.length(), this.P);
            int iWidth = this.P.width();
            float fHeight = this.P.height() * 1.3f;
            float f10 = (f8 - this.f4453t) - this.f4452s;
            float f11 = (f9 - this.f4455v) - this.f4454u;
            float f12 = iWidth;
            if (f12 * f11 > fHeight * f10) {
                this.f4434a.setTextSize((this.R * f10) / f12);
            } else {
                this.f4434a.setTextSize((this.R * f11) / fHeight);
            }
            if (this.f4438e || !Float.isNaN(this.f4444k)) {
                f(Float.isNaN(this.f4444k) ? 1.0f : this.f4443j / this.f4444k);
            }
        }
    }

    Bitmap e(Bitmap bitmapOriginal, int factor) {
        System.nanoTime();
        int width = bitmapOriginal.getWidth() / 2;
        int height = bitmapOriginal.getHeight() / 2;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapOriginal, width, height, true);
        for (int i7 = 0; i7 < factor && width >= 32 && height >= 32; i7++) {
            width /= 2;
            height /= 2;
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, width, height, true);
        }
        return bitmapCreateScaledBitmap;
    }

    void f(float scale) {
        if (this.f4438e || scale != 1.0f) {
            this.f4435b.reset();
            String str = this.f4448o;
            int length = str.length();
            this.f4434a.getTextBounds(str, 0, length, this.f4450q);
            this.f4434a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f4435b);
            if (scale != 1.0f) {
                Log.v(W, c.f() + " scale " + scale);
                Matrix matrix = new Matrix();
                matrix.postScale(scale, scale);
                this.f4435b.transform(matrix);
            }
            Rect rect = this.f4450q;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.f4449p = false;
        }
    }

    public float getRound() {
        return this.f4440g;
    }

    public float getRoundPercent() {
        return this.f4439f;
    }

    public float getScaleFromTextSize() {
        return this.f4444k;
    }

    public float getTextBackgroundPanX() {
        return this.S;
    }

    public float getTextBackgroundPanY() {
        return this.T;
    }

    public float getTextBackgroundRotate() {
        return this.V;
    }

    public float getTextBackgroundZoom() {
        return this.U;
    }

    public int getTextOutlineColor() {
        return this.f4437d;
    }

    public float getTextPanX() {
        return this.L;
    }

    public float getTextPanY() {
        return this.M;
    }

    public float getTextureHeight() {
        return this.f4433J;
    }

    public float getTextureWidth() {
        return this.K;
    }

    public Typeface getTypeface() {
        return this.f4434a.getTypeface();
    }

    void j() {
        this.f4452s = getPaddingLeft();
        this.f4453t = getPaddingRight();
        this.f4454u = getPaddingTop();
        this.f4455v = getPaddingBottom();
        h(this.f4456w, this.f4446m, this.f4445l);
        this.f4434a.setColor(this.f4436c);
        this.f4434a.setStrokeWidth(this.f4447n);
        this.f4434a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f4434a.setFlags(128);
        setTextSize(this.f4443j);
        this.f4434a.setAntiAlias(true);
    }

    @Override // android.view.View
    public void layout(int l7, int t7, int r7, int b8) {
        super.layout(l7, t7, r7, b8);
        boolean zIsNaN = Float.isNaN(this.f4444k);
        float f8 = zIsNaN ? 1.0f : this.f4443j / this.f4444k;
        this.C = r7 - l7;
        this.D = b8 - t7;
        if (this.A) {
            if (this.P == null) {
                this.Q = new Paint();
                this.P = new Rect();
                this.Q.set(this.f4434a);
                this.R = this.Q.getTextSize();
            }
            Paint paint = this.Q;
            String str = this.f4448o;
            paint.getTextBounds(str, 0, str.length(), this.P);
            int iWidth = this.P.width();
            int iHeight = (int) (this.P.height() * 1.3f);
            float f9 = (this.C - this.f4453t) - this.f4452s;
            float f10 = (this.D - this.f4455v) - this.f4454u;
            if (zIsNaN) {
                float f11 = iWidth;
                float f12 = iHeight;
                if (f11 * f10 > f12 * f9) {
                    this.f4434a.setTextSize((this.R * f9) / f11);
                } else {
                    this.f4434a.setTextSize((this.R * f10) / f12);
                }
            } else {
                float f13 = iWidth;
                float f14 = iHeight;
                f8 = f13 * f10 > f14 * f9 ? f9 / f13 : f10 / f14;
            }
        }
        if (this.f4438e || !zIsNaN) {
            d(l7, t7, r7, b8);
            f(f8);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f8 = Float.isNaN(this.f4444k) ? 1.0f : this.f4443j / this.f4444k;
        super.onDraw(canvas);
        if (!this.f4438e && f8 == 1.0f) {
            canvas.drawText(this.f4448o, this.B + this.f4452s + getHorizontalOffset(), this.f4454u + getVerticalOffset(), this.f4434a);
            return;
        }
        if (this.f4449p) {
            f(f8);
        }
        if (this.F == null) {
            this.F = new Matrix();
        }
        if (!this.f4438e) {
            float horizontalOffset = this.f4452s + getHorizontalOffset();
            float verticalOffset = this.f4454u + getVerticalOffset();
            this.F.reset();
            this.F.preTranslate(horizontalOffset, verticalOffset);
            this.f4435b.transform(this.F);
            this.f4434a.setColor(this.f4436c);
            this.f4434a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f4434a.setStrokeWidth(this.f4447n);
            canvas.drawPath(this.f4435b, this.f4434a);
            this.F.reset();
            this.F.preTranslate(-horizontalOffset, -verticalOffset);
            this.f4435b.transform(this.F);
            return;
        }
        this.N.set(this.f4434a);
        this.F.reset();
        float horizontalOffset2 = this.f4452s + getHorizontalOffset();
        float verticalOffset2 = this.f4454u + getVerticalOffset();
        this.F.postTranslate(horizontalOffset2, verticalOffset2);
        this.F.preScale(f8, f8);
        this.f4435b.transform(this.F);
        if (this.H != null) {
            this.f4434a.setFilterBitmap(true);
            this.f4434a.setShader(this.H);
        } else {
            this.f4434a.setColor(this.f4436c);
        }
        this.f4434a.setStyle(Paint.Style.FILL);
        this.f4434a.setStrokeWidth(this.f4447n);
        canvas.drawPath(this.f4435b, this.f4434a);
        if (this.H != null) {
            this.f4434a.setShader(null);
        }
        this.f4434a.setColor(this.f4437d);
        this.f4434a.setStyle(Paint.Style.STROKE);
        this.f4434a.setStrokeWidth(this.f4447n);
        canvas.drawPath(this.f4435b, this.f4434a);
        this.F.reset();
        this.F.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f4435b.transform(this.F);
        this.f4434a.set(this.N);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        this.A = false;
        this.f4452s = getPaddingLeft();
        this.f4453t = getPaddingRight();
        this.f4454u = getPaddingTop();
        this.f4455v = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f4434a;
            String str = this.f4448o;
            textPaint.getTextBounds(str, 0, str.length(), this.f4450q);
            if (mode != 1073741824) {
                size = (int) (this.f4450q.width() + 0.99999f);
            }
            size += this.f4452s + this.f4453t;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.f4434a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f4454u + this.f4455v + fontMetricsInt;
            }
        } else if (this.f4459z != 0) {
            this.A = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int gravity) {
        if ((gravity & n0.f6719d) == 0) {
            gravity |= n0.f6717b;
        }
        if ((gravity & 112) == 0) {
            gravity |= 48;
        }
        if (gravity != this.f4458y) {
            invalidate();
        }
        this.f4458y = gravity;
        int i7 = gravity & 112;
        if (i7 == 48) {
            this.M = -1.0f;
        } else if (i7 != 80) {
            this.M = 0.0f;
        } else {
            this.M = 1.0f;
        }
        int i8 = gravity & n0.f6719d;
        if (i8 != 3) {
            if (i8 != 5) {
                if (i8 != 8388611) {
                    if (i8 != 8388613) {
                        this.L = 0.0f;
                        return;
                    }
                }
            }
            this.L = 1.0f;
            return;
        }
        this.L = -1.0f;
    }

    @t0(21)
    public void setRound(float round) {
        if (Float.isNaN(round)) {
            this.f4440g = round;
            float f8 = this.f4439f;
            this.f4439f = -1.0f;
            setRoundPercent(f8);
            return;
        }
        boolean z7 = this.f4440g != round;
        this.f4440g = round;
        if (round != 0.0f) {
            if (this.f4435b == null) {
                this.f4435b = new Path();
            }
            if (this.f4442i == null) {
                this.f4442i = new RectF();
            }
            if (this.f4441h == null) {
                b bVar = new b();
                this.f4441h = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f4442i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f4435b.reset();
            Path path = this.f4435b;
            RectF rectF = this.f4442i;
            float f9 = this.f4440g;
            path.addRoundRect(rectF, f9, f9, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    @t0(21)
    public void setRoundPercent(float round) {
        boolean z7 = this.f4439f != round;
        this.f4439f = round;
        if (round != 0.0f) {
            if (this.f4435b == null) {
                this.f4435b = new Path();
            }
            if (this.f4442i == null) {
                this.f4442i = new RectF();
            }
            if (this.f4441h == null) {
                a aVar = new a();
                this.f4441h = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f4439f) / 2.0f;
            this.f4442i.set(0.0f, 0.0f, width, height);
            this.f4435b.reset();
            this.f4435b.addRoundRect(this.f4442i, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float size) {
        this.f4444k = size;
    }

    public void setText(CharSequence text) {
        this.f4448o = text.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float pan) {
        this.S = pan;
        l();
        invalidate();
    }

    public void setTextBackgroundPanY(float pan) {
        this.T = pan;
        l();
        invalidate();
    }

    public void setTextBackgroundRotate(float rotation) {
        this.V = rotation;
        l();
        invalidate();
    }

    public void setTextBackgroundZoom(float zoom) {
        this.U = zoom;
        l();
        invalidate();
    }

    public void setTextFillColor(int color) {
        this.f4436c = color;
        invalidate();
    }

    public void setTextOutlineColor(int color) {
        this.f4437d = color;
        this.f4438e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float width) {
        this.f4447n = width;
        this.f4438e = true;
        if (Float.isNaN(width)) {
            this.f4447n = 1.0f;
            this.f4438e = false;
        }
        invalidate();
    }

    public void setTextPanX(float textPanX) {
        this.L = textPanX;
        invalidate();
    }

    public void setTextPanY(float textPanY) {
        this.M = textPanY;
        invalidate();
    }

    public void setTextSize(float size) {
        this.f4443j = size;
        Log.v(W, c.f() + "  " + size + " / " + this.f4444k);
        TextPaint textPaint = this.f4434a;
        if (!Float.isNaN(this.f4444k)) {
            size = this.f4444k;
        }
        textPaint.setTextSize(size);
        f(Float.isNaN(this.f4444k) ? 1.0f : this.f4443j / this.f4444k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float mTextureHeight) {
        this.f4433J = mTextureHeight;
        l();
        invalidate();
    }

    public void setTextureWidth(float mTextureWidth) {
        this.K = mTextureWidth;
        l();
        invalidate();
    }

    public void setTypeface(Typeface tf) {
        if (this.f4434a.getTypeface() != tf) {
            this.f4434a.setTypeface(tf);
            if (this.f4457x != null) {
                this.f4457x = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public MotionLabel(Context context, @o0 AttributeSet attrs) {
        super(context, attrs);
        this.f4434a = new TextPaint();
        this.f4435b = new Path();
        this.f4436c = 65535;
        this.f4437d = 65535;
        this.f4438e = false;
        this.f4439f = 0.0f;
        this.f4440g = Float.NaN;
        this.f4443j = 48.0f;
        this.f4444k = Float.NaN;
        this.f4447n = 0.0f;
        this.f4448o = "Hello World";
        this.f4449p = true;
        this.f4450q = new Rect();
        this.f4452s = 1;
        this.f4453t = 1;
        this.f4454u = 1;
        this.f4455v = 1;
        this.f4458y = BadgeDrawable.f16995r;
        this.f4459z = 0;
        this.A = false;
        this.f4433J = Float.NaN;
        this.K = Float.NaN;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = new Paint();
        this.O = 0;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        this.V = Float.NaN;
        g(context, attrs);
    }

    public MotionLabel(Context context, @o0 AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4434a = new TextPaint();
        this.f4435b = new Path();
        this.f4436c = 65535;
        this.f4437d = 65535;
        this.f4438e = false;
        this.f4439f = 0.0f;
        this.f4440g = Float.NaN;
        this.f4443j = 48.0f;
        this.f4444k = Float.NaN;
        this.f4447n = 0.0f;
        this.f4448o = "Hello World";
        this.f4449p = true;
        this.f4450q = new Rect();
        this.f4452s = 1;
        this.f4453t = 1;
        this.f4454u = 1;
        this.f4455v = 1;
        this.f4458y = BadgeDrawable.f16995r;
        this.f4459z = 0;
        this.A = false;
        this.f4433J = Float.NaN;
        this.K = Float.NaN;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = new Paint();
        this.O = 0;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        this.V = Float.NaN;
        g(context, attrs);
    }
}
