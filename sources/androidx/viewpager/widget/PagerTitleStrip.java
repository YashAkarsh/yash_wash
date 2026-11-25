package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.view.n2;
import androidx.core.widget.u;
import c.l;
import c.m0;
import c.o0;
import c.v;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.e
public class PagerTitleStrip extends ViewGroup {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f11062o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int[] f11063p = {R.attr.textAllCaps};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f11064q = 0.6f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f11065r = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewPager f11066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    TextView f11067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    TextView f11068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    TextView f11069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f11071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11075j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a f11076k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private WeakReference<androidx.viewpager.widget.a> f11077l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f11078m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f11079n;

    private class a extends DataSetObserver implements ViewPager.i, ViewPager.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11080a;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            PagerTitleStrip.this.a(aVar, aVar2);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void h(int i7, float f8, int i8) {
            if (f8 > 0.5f) {
                i7++;
            }
            PagerTitleStrip.this.c(i7, f8, false);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.b(pagerTitleStrip.f11066a.getCurrentItem(), PagerTitleStrip.this.f11066a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f8 = pagerTitleStrip2.f11071f;
            if (f8 < 0.0f) {
                f8 = 0.0f;
            }
            pagerTitleStrip2.c(pagerTitleStrip2.f11066a.getCurrentItem(), f8, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void t(int i7) {
            this.f11080a = i7;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void u(int i7) {
            if (this.f11080a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.b(pagerTitleStrip.f11066a.getCurrentItem(), PagerTitleStrip.this.f11066a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f8 = pagerTitleStrip2.f11071f;
                if (f8 < 0.0f) {
                    f8 = 0.0f;
                }
                pagerTitleStrip2.c(pagerTitleStrip2.f11066a.getCurrentItem(), f8, true);
            }
        }
    }

    private static class b extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Locale f11082a;

        b(Context context) {
            this.f11082a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f11082a);
            }
            return null;
        }
    }

    public PagerTitleStrip(@m0 Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    void a(androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
        if (aVar != null) {
            aVar.u(this.f11076k);
            this.f11077l = null;
        }
        if (aVar2 != null) {
            aVar2.m(this.f11076k);
            this.f11077l = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.f11066a;
        if (viewPager != null) {
            this.f11070e = -1;
            this.f11071f = -1.0f;
            b(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    void b(int i7, androidx.viewpager.widget.a aVar) {
        int iE = aVar != null ? aVar.e() : 0;
        this.f11074i = true;
        CharSequence charSequenceG = null;
        this.f11067b.setText((i7 < 1 || aVar == null) ? null : aVar.g(i7 - 1));
        this.f11068c.setText((aVar == null || i7 >= iE) ? null : aVar.g(i7));
        int i8 = i7 + 1;
        if (i8 < iE && aVar != null) {
            charSequenceG = aVar.g(i8);
        }
        this.f11069d.setText(charSequenceG);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f11067b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f11068c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f11069d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f11070e = i7;
        if (!this.f11075j) {
            c(i7, this.f11071f, false);
        }
        this.f11074i = false;
    }

    void c(int i7, float f8, boolean z7) {
        int i8;
        int i9;
        int i10;
        int i11;
        if (i7 != this.f11070e) {
            b(i7, this.f11066a.getAdapter());
        } else if (!z7 && f8 == this.f11071f) {
            return;
        }
        this.f11075j = true;
        int measuredWidth = this.f11067b.getMeasuredWidth();
        int measuredWidth2 = this.f11068c.getMeasuredWidth();
        int measuredWidth3 = this.f11069d.getMeasuredWidth();
        int i12 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i13 = paddingRight + i12;
        int i14 = (width - (paddingLeft + i12)) - i13;
        float f9 = 0.5f + f8;
        if (f9 > 1.0f) {
            f9 -= 1.0f;
        }
        int i15 = ((width - i13) - ((int) (i14 * f9))) - i12;
        int i16 = measuredWidth2 + i15;
        int baseline = this.f11067b.getBaseline();
        int baseline2 = this.f11068c.getBaseline();
        int baseline3 = this.f11069d.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i17 = iMax - baseline;
        int i18 = iMax - baseline2;
        int i19 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.f11067b.getMeasuredHeight() + i17, this.f11068c.getMeasuredHeight() + i18), this.f11069d.getMeasuredHeight() + i19);
        int i20 = this.f11073h & 112;
        if (i20 != 16) {
            if (i20 != 80) {
                i9 = i17 + paddingTop;
                i10 = i18 + paddingTop;
                i11 = paddingTop + i19;
            } else {
                i8 = (height - paddingBottom) - iMax2;
            }
            TextView textView = this.f11068c;
            textView.layout(i15, i10, i16, textView.getMeasuredHeight() + i10);
            int iMin = Math.min(paddingLeft, (i15 - this.f11072g) - measuredWidth);
            TextView textView2 = this.f11067b;
            textView2.layout(iMin, i9, measuredWidth + iMin, textView2.getMeasuredHeight() + i9);
            int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i16 + this.f11072g);
            TextView textView3 = this.f11069d;
            textView3.layout(iMax3, i11, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i11);
            this.f11071f = f8;
            this.f11075j = false;
        }
        i8 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        i9 = i17 + i8;
        i10 = i18 + i8;
        i11 = i8 + i19;
        TextView textView4 = this.f11068c;
        textView4.layout(i15, i10, i16, textView4.getMeasuredHeight() + i10);
        int iMin2 = Math.min(paddingLeft, (i15 - this.f11072g) - measuredWidth);
        TextView textView5 = this.f11067b;
        textView5.layout(iMin2, i9, measuredWidth + iMin2, textView5.getMeasuredHeight() + i9);
        int iMax4 = Math.max((width - paddingRight) - measuredWidth3, i16 + this.f11072g);
        TextView textView6 = this.f11069d;
        textView6.layout(iMax4, i11, iMax4 + measuredWidth3, textView6.getMeasuredHeight() + i11);
        this.f11071f = f8;
        this.f11075j = false;
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f11072g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        androidx.viewpager.widget.a adapter = viewPager.getAdapter();
        viewPager.U(this.f11076k);
        viewPager.b(this.f11076k);
        this.f11066a = viewPager;
        WeakReference<androidx.viewpager.widget.a> weakReference = this.f11077l;
        a(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f11066a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), null);
            this.f11066a.U(null);
            this.f11066a.N(this.f11076k);
            this.f11066a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        if (this.f11066a != null) {
            float f8 = this.f11071f;
            if (f8 < 0.0f) {
                f8 = 0.0f;
            }
            c(this.f11070e, f8, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        int iMax;
        if (View.MeasureSpec.getMode(i7) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i7);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, (int) (size * 0.2f), -2);
        this.f11067b.measure(childMeasureSpec2, childMeasureSpec);
        this.f11068c.measure(childMeasureSpec2, childMeasureSpec);
        this.f11069d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i8) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i8);
        } else {
            iMax = Math.max(getMinHeight(), this.f11068c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i8, this.f11068c.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f11074i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i7) {
        this.f11073h = i7;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@v(from = 0.0d, to = 1.0d) float f8) {
        int i7 = ((int) (f8 * 255.0f)) & 255;
        this.f11078m = i7;
        int i8 = (i7 << 24) | (this.f11079n & n2.f6742s);
        this.f11067b.setTextColor(i8);
        this.f11069d.setTextColor(i8);
    }

    public void setTextColor(@l int i7) {
        this.f11079n = i7;
        this.f11068c.setTextColor(i7);
        int i8 = (this.f11078m << 24) | (this.f11079n & n2.f6742s);
        this.f11067b.setTextColor(i8);
        this.f11069d.setTextColor(i8);
    }

    public void setTextSize(int i7, float f8) {
        this.f11067b.setTextSize(i7, f8);
        this.f11068c.setTextSize(i7, f8);
        this.f11069d.setTextSize(i7, f8);
    }

    public void setTextSpacing(int i7) {
        this.f11072g = i7;
        requestLayout();
    }

    public PagerTitleStrip(@m0 Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11070e = -1;
        this.f11071f = -1.0f;
        this.f11076k = new a();
        TextView textView = new TextView(context);
        this.f11067b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f11068c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f11069d = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f11062o);
        boolean z7 = false;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            u.E(this.f11067b, resourceId);
            u.E(this.f11068c, resourceId);
            u.E(this.f11069d, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            this.f11067b.setTextColor(color);
            this.f11068c.setTextColor(color);
            this.f11069d.setTextColor(color);
        }
        this.f11073h = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.f11079n = this.f11068c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(f11064q);
        this.f11067b.setEllipsize(TextUtils.TruncateAt.END);
        this.f11068c.setEllipsize(TextUtils.TruncateAt.END);
        this.f11069d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f11063p);
            z7 = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (z7) {
            setSingleLineAllCaps(this.f11067b);
            setSingleLineAllCaps(this.f11068c);
            setSingleLineAllCaps(this.f11069d);
        } else {
            this.f11067b.setSingleLine();
            this.f11068c.setSingleLine();
            this.f11069d.setSingleLine();
        }
        this.f11072g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
