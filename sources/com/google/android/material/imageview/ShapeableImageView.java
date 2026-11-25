package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import c.m0;
import c.n;
import c.o0;
import c.q;
import c.t0;
import com.google.android.material.R;
import com.google.android.material.resources.c;
import com.google.android.material.shape.j;
import com.google.android.material.shape.o;
import com.google.android.material.shape.p;
import com.google.android.material.shape.s;

/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements s {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f17713v = R.style.Widget_MaterialComponents_ShapeableImageView;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f17714w = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p f17715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f17716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f17717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f17718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f17719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Path f17720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private ColorStateList f17721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private j f17722k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private o f17723l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @q
    private float f17724m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Path f17725n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @q
    private int f17726o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @q
    private int f17727p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @q
    private int f17728q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @q
    private int f17729r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @q
    private int f17730s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @q
    private int f17731t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f17732u;

    @TargetApi(21)
    class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f17733a = new Rect();

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f17723l == null) {
                return;
            }
            if (ShapeableImageView.this.f17722k == null) {
                ShapeableImageView.this.f17722k = new j(ShapeableImageView.this.f17723l);
            }
            ShapeableImageView.this.f17716e.round(this.f17733a);
            ShapeableImageView.this.f17722k.setBounds(this.f17733a);
            ShapeableImageView.this.f17722k.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    private void g(Canvas canvas) {
        if (this.f17721j == null) {
            return;
        }
        this.f17718g.setStrokeWidth(this.f17724m);
        int colorForState = this.f17721j.getColorForState(getDrawableState(), this.f17721j.getDefaultColor());
        if (this.f17724m <= 0.0f || colorForState == 0) {
            return;
        }
        this.f17718g.setColor(colorForState);
        canvas.drawPath(this.f17720i, this.f17718g);
    }

    private boolean h() {
        return (this.f17730s == Integer.MIN_VALUE && this.f17731t == Integer.MIN_VALUE) ? false : true;
    }

    private boolean i() {
        return getLayoutDirection() == 1;
    }

    private void j(int i7, int i8) {
        this.f17716e.set(getPaddingLeft(), getPaddingTop(), i7 - getPaddingRight(), i8 - getPaddingBottom());
        this.f17715d.d(this.f17723l, 1.0f, this.f17716e, this.f17720i);
        this.f17725n.rewind();
        this.f17725n.addPath(this.f17720i);
        this.f17717f.set(0.0f, 0.0f, i7, i8);
        this.f17725n.addRect(this.f17717f, Path.Direction.CCW);
    }

    @q
    public int getContentPaddingBottom() {
        return this.f17729r;
    }

    @q
    public final int getContentPaddingEnd() {
        int i7 = this.f17731t;
        if (i7 != Integer.MIN_VALUE) {
            return i7;
        }
        return i() ? this.f17726o : this.f17728q;
    }

    @q
    public int getContentPaddingLeft() {
        int i7;
        int i8;
        if (h()) {
            if (i() && (i8 = this.f17731t) != Integer.MIN_VALUE) {
                return i8;
            }
            if (!i() && (i7 = this.f17730s) != Integer.MIN_VALUE) {
                return i7;
            }
        }
        return this.f17726o;
    }

    @q
    public int getContentPaddingRight() {
        int i7;
        int i8;
        if (h()) {
            if (i() && (i8 = this.f17730s) != Integer.MIN_VALUE) {
                return i8;
            }
            if (!i() && (i7 = this.f17731t) != Integer.MIN_VALUE) {
                return i7;
            }
        }
        return this.f17728q;
    }

    @q
    public final int getContentPaddingStart() {
        int i7 = this.f17730s;
        if (i7 != Integer.MIN_VALUE) {
            return i7;
        }
        return i() ? this.f17728q : this.f17726o;
    }

    @q
    public int getContentPaddingTop() {
        return this.f17727p;
    }

    @Override // android.view.View
    @q
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @q
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @q
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @q
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @q
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @q
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.s
    @m0
    public o getShapeAppearanceModel() {
        return this.f17723l;
    }

    @o0
    public ColorStateList getStrokeColor() {
        return this.f17721j;
    }

    @q
    public float getStrokeWidth() {
        return this.f17724m;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f17725n, this.f17719h);
        g(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (!this.f17732u && isLayoutDirectionResolved()) {
            this.f17732u = true;
            if (isPaddingRelative() || h()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        j(i7, i8);
    }

    public void setContentPadding(@q int i7, @q int i8, @q int i9, @q int i10) {
        this.f17730s = Integer.MIN_VALUE;
        this.f17731t = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.f17726o) + i7, (super.getPaddingTop() - this.f17727p) + i8, (super.getPaddingRight() - this.f17728q) + i9, (super.getPaddingBottom() - this.f17729r) + i10);
        this.f17726o = i7;
        this.f17727p = i8;
        this.f17728q = i9;
        this.f17729r = i10;
    }

    @t0(17)
    public void setContentPaddingRelative(@q int i7, @q int i8, @q int i9, @q int i10) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i7, (super.getPaddingTop() - this.f17727p) + i8, (super.getPaddingEnd() - getContentPaddingEnd()) + i9, (super.getPaddingBottom() - this.f17729r) + i10);
        this.f17726o = i() ? i9 : i7;
        this.f17727p = i8;
        if (!i()) {
            i7 = i9;
        }
        this.f17728q = i7;
        this.f17729r = i10;
    }

    @Override // android.view.View
    public void setPadding(@q int i7, @q int i8, @q int i9, @q int i10) {
        super.setPadding(i7 + getContentPaddingLeft(), i8 + getContentPaddingTop(), i9 + getContentPaddingRight(), i10 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(@q int i7, @q int i8, @q int i9, @q int i10) {
        super.setPaddingRelative(i7 + getContentPaddingStart(), i8 + getContentPaddingTop(), i9 + getContentPaddingEnd(), i10 + getContentPaddingBottom());
    }

    @Override // com.google.android.material.shape.s
    public void setShapeAppearanceModel(@m0 o oVar) {
        this.f17723l = oVar;
        j jVar = this.f17722k;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(oVar);
        }
        j(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@o0 ColorStateList colorStateList) {
        this.f17721j = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@n int i7) {
        setStrokeColor(e.a.a(getContext(), i7));
    }

    public void setStrokeWidth(@q float f8) {
        if (this.f17724m != f8) {
            this.f17724m = f8;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@c.p int i7) {
        setStrokeWidth(getResources().getDimensionPixelSize(i7));
    }

    public ShapeableImageView(Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = f17713v;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f17715d = p.k();
        this.f17720i = new Path();
        this.f17732u = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f17719h = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f17716e = new RectF();
        this.f17717f = new RectF();
        this.f17725n = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.ShapeableImageView, i7, i8);
        this.f17721j = c.a(context2, typedArrayObtainStyledAttributes, R.styleable.ShapeableImageView_strokeColor);
        this.f17724m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPadding, 0);
        this.f17726o = dimensionPixelSize;
        this.f17727p = dimensionPixelSize;
        this.f17728q = dimensionPixelSize;
        this.f17729r = dimensionPixelSize;
        this.f17726o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.f17727p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.f17728q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.f17729r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.f17730s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.f17731t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f17718g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f17723l = o.e(context2, attributeSet, i7, i8).m();
        setOutlineProvider(new a());
    }
}
