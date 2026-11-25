package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import c.l;
import c.m0;
import c.o0;
import c.r0;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f2211h = {R.attr.colorBackground};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final e f2212i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Rect f2217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Rect f2218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f2219g;

    class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f2220a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public void b(int i7, int i8, int i9, int i10) {
            CardView.this.f2218f.set(i7, i8, i9, i10);
            CardView cardView = CardView.this;
            Rect rect = cardView.f2217e;
            CardView.super.setPadding(i7 + rect.left, i8 + rect.top, i9 + rect.right, i10 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public void c(int i7, int i8) {
            CardView cardView = CardView.this;
            if (i7 > cardView.f2215c) {
                CardView.super.setMinimumWidth(i7);
            }
            CardView cardView2 = CardView.this;
            if (i8 > cardView2.f2216d) {
                CardView.super.setMinimumHeight(i8);
            }
        }

        @Override // androidx.cardview.widget.d
        public void d(Drawable drawable) {
            this.f2220a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.d
        public boolean f() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable g() {
            return this.f2220a;
        }

        @Override // androidx.cardview.widget.d
        public View h() {
            return CardView.this;
        }
    }

    static {
        b bVar = new b();
        f2212i = bVar;
        bVar.j();
    }

    public CardView(@m0 Context context) {
        this(context, null);
    }

    @m0
    public ColorStateList getCardBackgroundColor() {
        return f2212i.h(this.f2219g);
    }

    public float getCardElevation() {
        return f2212i.c(this.f2219g);
    }

    @r0
    public int getContentPaddingBottom() {
        return this.f2217e.bottom;
    }

    @r0
    public int getContentPaddingLeft() {
        return this.f2217e.left;
    }

    @r0
    public int getContentPaddingRight() {
        return this.f2217e.right;
    }

    @r0
    public int getContentPaddingTop() {
        return this.f2217e.top;
    }

    public float getMaxCardElevation() {
        return f2212i.g(this.f2219g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2214b;
    }

    public float getRadius() {
        return f2212i.d(this.f2219g);
    }

    public boolean getUseCompatPadding() {
        return this.f2213a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        e eVar = f2212i;
        if (eVar instanceof b) {
            super.onMeasure(i7, i8);
            return;
        }
        int mode = View.MeasureSpec.getMode(i7);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i7 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.l(this.f2219g)), View.MeasureSpec.getSize(i7)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i8);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i8 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.k(this.f2219g)), View.MeasureSpec.getSize(i8)), mode2);
        }
        super.onMeasure(i7, i8);
    }

    public void setCardBackgroundColor(@l int i7) {
        f2212i.n(this.f2219g, ColorStateList.valueOf(i7));
    }

    public void setCardElevation(float f8) {
        f2212i.f(this.f2219g, f8);
    }

    public void setContentPadding(@r0 int i7, @r0 int i8, @r0 int i9, @r0 int i10) {
        this.f2217e.set(i7, i8, i9, i10);
        f2212i.i(this.f2219g);
    }

    public void setMaxCardElevation(float f8) {
        f2212i.o(this.f2219g, f8);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i7) {
        this.f2216d = i7;
        super.setMinimumHeight(i7);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i7) {
        this.f2215c = i7;
        super.setMinimumWidth(i7);
    }

    @Override // android.view.View
    public void setPadding(int i7, int i8, int i9, int i10) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i7, int i8, int i9, int i10) {
    }

    public void setPreventCornerOverlap(boolean z7) {
        if (z7 != this.f2214b) {
            this.f2214b = z7;
            f2212i.m(this.f2219g);
        }
    }

    public void setRadius(float f8) {
        f2212i.b(this.f2219g, f8);
    }

    public void setUseCompatPadding(boolean z7) {
        if (this.f2213a != z7) {
            this.f2213a = z7;
            f2212i.e(this.f2219g);
        }
    }

    public CardView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R.attr.cardViewStyle);
    }

    public void setCardBackgroundColor(@o0 ColorStateList colorStateList) {
        f2212i.n(this.f2219g, colorStateList);
    }

    public CardView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int color;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i7);
        Rect rect = new Rect();
        this.f2217e = rect;
        this.f2218f = new Rect();
        a aVar = new a();
        this.f2219g = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, i7, androidx.cardview.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(androidx.cardview.R.styleable.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(androidx.cardview.R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f2211h);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(androidx.cardview.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(androidx.cardview.R.color.cardview_dark_background);
            }
            colorStateListValueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f2213a = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.f2214b = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f8 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f2215c = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        this.f2216d = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f2212i.a(aVar, context, colorStateList, dimension, dimension2, f8);
    }
}
