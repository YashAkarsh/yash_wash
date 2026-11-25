package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.r;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.core.view.z1;
import c.b1;
import c.e0;
import c.l;
import c.m0;
import c.o0;
import c.t0;
import c.u;
import c.v;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.n;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int D = R.style.Widget_Design_CollapsingToolbar;
    private static final int E = 600;
    public static final int F = 0;
    public static final int G = 1;
    private boolean A;
    private int B;
    private boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private ViewGroup f16935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private View f16936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f16937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f16940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Rect f16942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @m0
    final com.google.android.material.internal.a f16943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @m0
    final n1.a f16944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f16945m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f16946n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private Drawable f16947o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    Drawable f16948p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f16949q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f16950r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ValueAnimator f16951s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f16952t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f16953u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AppBarLayout.d f16954v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f16955w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f16956x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @o0
    w5 f16957y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f16958z;

    class a implements z1 {
        a() {
        }

        @Override // androidx.core.view.z1
        public w5 a(View view, @m0 w5 w5Var) {
            return CollapsingToolbarLayout.this.r(w5Var);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    private class c implements AppBarLayout.d {
        c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.d, com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i7) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f16955w = i7;
            w5 w5Var = collapsingToolbarLayout.f16957y;
            int iR = w5Var != null ? w5Var.r() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i8);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                e eVarJ = CollapsingToolbarLayout.j(childAt);
                int i9 = layoutParams.f16963a;
                if (i9 == 1) {
                    eVarJ.k(m.a.e(-i7, 0, CollapsingToolbarLayout.this.h(childAt)));
                } else if (i9 == 2) {
                    eVarJ.k(Math.round((-i7) * layoutParams.f16964b));
                }
            }
            CollapsingToolbarLayout.this.x();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f16948p != null && iR > 0) {
                n2.n1(collapsingToolbarLayout2);
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int iE0 = (height - n2.e0(CollapsingToolbarLayout.this)) - iR;
            float f8 = iE0;
            CollapsingToolbarLayout.this.f16943k.w0(Math.min(1.0f, (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f8));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f16943k.k0(collapsingToolbarLayout3.f16955w + iE0);
            CollapsingToolbarLayout.this.f16943k.u0(Math.abs(i7) / f8);
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public CollapsingToolbarLayout(@m0 Context context) {
        this(context, null);
    }

    private void a(int i7) {
        c();
        ValueAnimator valueAnimator = this.f16951s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f16951s = valueAnimator2;
            valueAnimator2.setDuration(this.f16952t);
            this.f16951s.setInterpolator(i7 > this.f16949q ? com.google.android.material.animation.a.f16848c : com.google.android.material.animation.a.f16849d);
            this.f16951s.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.f16951s.cancel();
        }
        this.f16951s.setIntValues(this.f16949q, i7);
        this.f16951s.start();
    }

    private void b(AppBarLayout appBarLayout) {
        if (n()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void c() {
        if (this.f16933a) {
            ViewGroup viewGroup = null;
            this.f16935c = null;
            this.f16936d = null;
            int i7 = this.f16934b;
            if (i7 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i7);
                this.f16935c = viewGroup2;
                if (viewGroup2 != null) {
                    this.f16936d = d(viewGroup2);
                }
            }
            if (this.f16935c == null) {
                int childCount = getChildCount();
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = getChildAt(i8);
                    if (p(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                }
                this.f16935c = viewGroup;
            }
            w();
            this.f16933a = false;
        }
    }

    @m0
    private View d(@m0 View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private static int g(@m0 View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static CharSequence i(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @m0
    static e j(@m0 View view) {
        e eVar = (e) view.getTag(R.id.view_offset_helper);
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(view);
        view.setTag(R.id.view_offset_helper, eVar2);
        return eVar2;
    }

    private boolean n() {
        return this.f16956x == 1;
    }

    private static boolean p(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    private boolean q(View view) {
        View view2 = this.f16936d;
        if (view2 == null || view2 == this) {
            if (view == this.f16935c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private void s(boolean z7) {
        int titleMarginStart;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        View view = this.f16936d;
        if (view == null) {
            view = this.f16935c;
        }
        int iH = h(view);
        com.google.android.material.internal.c.a(this, this.f16937e, this.f16942j);
        ViewGroup viewGroup = this.f16935c;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            titleMarginStart = toolbar.getTitleMarginStart();
            titleMarginEnd = toolbar.getTitleMarginEnd();
            titleMarginTop = toolbar.getTitleMarginTop();
            titleMarginBottom = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            titleMarginStart = 0;
            titleMarginBottom = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
        } else {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            titleMarginStart = toolbar2.getTitleMarginStart();
            titleMarginEnd = toolbar2.getTitleMarginEnd();
            titleMarginTop = toolbar2.getTitleMarginTop();
            titleMarginBottom = toolbar2.getTitleMarginBottom();
        }
        com.google.android.material.internal.a aVar = this.f16943k;
        Rect rect = this.f16942j;
        int i7 = rect.left + (z7 ? titleMarginEnd : titleMarginStart);
        int i8 = rect.top + iH + titleMarginTop;
        int i9 = rect.right;
        if (!z7) {
            titleMarginStart = titleMarginEnd;
        }
        aVar.b0(i7, i8, i9 - titleMarginStart, (rect.bottom + iH) - titleMarginBottom);
    }

    private void t() {
        setContentDescription(getTitle());
    }

    private void u(@m0 Drawable drawable, int i7, int i8) {
        v(drawable, this.f16935c, i7, i8);
    }

    private void v(@m0 Drawable drawable, @o0 View view, int i7, int i8) {
        if (n() && view != null && this.f16945m) {
            i8 = view.getBottom();
        }
        drawable.setBounds(0, 0, i7, i8);
    }

    private void w() {
        View view;
        if (!this.f16945m && (view = this.f16937e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f16937e);
            }
        }
        if (!this.f16945m || this.f16935c == null) {
            return;
        }
        if (this.f16937e == null) {
            this.f16937e = new View(getContext());
        }
        if (this.f16937e.getParent() == null) {
            this.f16935c.addView(this.f16937e, -1, -1);
        }
    }

    private void y(int i7, int i8, int i9, int i10, boolean z7) {
        View view;
        if (!this.f16945m || (view = this.f16937e) == null) {
            return;
        }
        boolean z8 = n2.O0(view) && this.f16937e.getVisibility() == 0;
        this.f16946n = z8;
        if (z8 || z7) {
            boolean z9 = n2.Z(this) == 1;
            s(z9);
            this.f16943k.l0(z9 ? this.f16940h : this.f16938f, this.f16942j.top + this.f16939g, (i9 - i7) - (z9 ? this.f16938f : this.f16940h), (i10 - i8) - this.f16941i);
            this.f16943k.Z(z7);
        }
    }

    private void z() {
        if (this.f16935c != null && this.f16945m && TextUtils.isEmpty(this.f16943k.N())) {
            setTitle(i(this.f16935c));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@m0 Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        c();
        if (this.f16935c == null && (drawable = this.f16947o) != null && this.f16949q > 0) {
            drawable.mutate().setAlpha(this.f16949q);
            this.f16947o.draw(canvas);
        }
        if (this.f16945m && this.f16946n) {
            if (this.f16935c == null || this.f16947o == null || this.f16949q <= 0 || !n() || this.f16943k.G() >= this.f16943k.H()) {
                this.f16943k.m(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.f16947o.getBounds(), Region.Op.DIFFERENCE);
                this.f16943k.m(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.f16948p == null || this.f16949q <= 0) {
            return;
        }
        w5 w5Var = this.f16957y;
        int iR = w5Var != null ? w5Var.r() : 0;
        if (iR > 0) {
            this.f16948p.setBounds(0, -this.f16955w, getWidth(), iR - this.f16955w);
            this.f16948p.mutate().setAlpha(this.f16949q);
            this.f16948p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j7) {
        boolean z7;
        if (this.f16947o == null || this.f16949q <= 0 || !q(view)) {
            z7 = false;
        } else {
            v(this.f16947o, view, getWidth(), getHeight());
            this.f16947o.mutate().setAlpha(this.f16949q);
            this.f16947o.draw(canvas);
            z7 = true;
        }
        return super.drawChild(canvas, view, j7) || z7;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f16948p;
        boolean zE0 = false;
        if (drawable != null && drawable.isStateful()) {
            zE0 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f16947o;
        if (drawable2 != null && drawable2.isStateful()) {
            zE0 |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.a aVar = this.f16943k;
        if (aVar != null) {
            zE0 |= aVar.E0(drawableState);
        }
        if (zE0) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f16943k.r();
    }

    @m0
    public Typeface getCollapsedTitleTypeface() {
        return this.f16943k.w();
    }

    @o0
    public Drawable getContentScrim() {
        return this.f16947o;
    }

    public int getExpandedTitleGravity() {
        return this.f16943k.C();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f16941i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f16940h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f16938f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f16939g;
    }

    @m0
    public Typeface getExpandedTitleTypeface() {
        return this.f16943k.F();
    }

    @t0(23)
    @x0({x0.a.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.f16943k.I();
    }

    @x0({x0.a.LIBRARY_GROUP})
    public int getLineCount() {
        return this.f16943k.J();
    }

    @t0(23)
    @x0({x0.a.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.f16943k.K();
    }

    @t0(23)
    @x0({x0.a.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.f16943k.L();
    }

    @x0({x0.a.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.f16943k.M();
    }

    int getScrimAlpha() {
        return this.f16949q;
    }

    public long getScrimAnimationDuration() {
        return this.f16952t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i7 = this.f16953u;
        if (i7 >= 0) {
            return i7 + this.f16958z + this.B;
        }
        w5 w5Var = this.f16957y;
        int iR = w5Var != null ? w5Var.r() : 0;
        int iE0 = n2.e0(this);
        return iE0 > 0 ? Math.min((iE0 * 2) + iR, getHeight()) : getHeight() / 3;
    }

    @o0
    public Drawable getStatusBarScrim() {
        return this.f16948p;
    }

    @o0
    public CharSequence getTitle() {
        if (this.f16945m) {
            return this.f16943k.N();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.f16956x;
    }

    final int h(@m0 View view) {
        return ((getHeight() - j(view).c()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public boolean k() {
        return this.C;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public boolean l() {
        return this.A;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public boolean m() {
        return this.f16943k.T();
    }

    public boolean o() {
        return this.f16945m;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            b(appBarLayout);
            n2.O1(this, n2.U(appBarLayout));
            if (this.f16954v == null) {
                this.f16954v = new c();
            }
            appBarLayout.b(this.f16954v);
            n2.v1(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.d dVar = this.f16954v;
        if (dVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).q(dVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        w5 w5Var = this.f16957y;
        if (w5Var != null) {
            int iR = w5Var.r();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (!n2.U(childAt) && childAt.getTop() < iR) {
                    n2.f1(childAt, iR);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            j(getChildAt(i12)).h();
        }
        y(i7, i8, i9, i10, false);
        z();
        x();
        int childCount3 = getChildCount();
        for (int i13 = 0; i13 < childCount3; i13++) {
            j(getChildAt(i13)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        c();
        super.onMeasure(i7, i8);
        int mode = View.MeasureSpec.getMode(i8);
        w5 w5Var = this.f16957y;
        int iR = w5Var != null ? w5Var.r() : 0;
        if ((mode == 0 || this.A) && iR > 0) {
            this.f16958z = iR;
            super.onMeasure(i7, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iR, 1073741824));
        }
        if (this.C && this.f16943k.M() > 1) {
            z();
            y(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int iJ = this.f16943k.J();
            if (iJ > 1) {
                this.B = Math.round(this.f16943k.B()) * (iJ - 1);
                super.onMeasure(i7, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.B, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f16935c;
        if (viewGroup != null) {
            View view = this.f16936d;
            if (view == null || view == this) {
                setMinimumHeight(g(viewGroup));
            } else {
                setMinimumHeight(g(view));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        Drawable drawable = this.f16947o;
        if (drawable != null) {
            u(drawable, i7, i8);
        }
    }

    w5 r(@m0 w5 w5Var) {
        w5 w5Var2 = n2.U(this) ? w5Var : null;
        if (!r.a(this.f16957y, w5Var2)) {
            this.f16957y = w5Var2;
            requestLayout();
        }
        return w5Var.c();
    }

    public void setCollapsedTitleGravity(int i7) {
        this.f16943k.g0(i7);
    }

    public void setCollapsedTitleTextAppearance(@b1 int i7) {
        this.f16943k.d0(i7);
    }

    public void setCollapsedTitleTextColor(@l int i7) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i7));
    }

    public void setCollapsedTitleTypeface(@o0 Typeface typeface) {
        this.f16943k.i0(typeface);
    }

    public void setContentScrim(@o0 Drawable drawable) {
        Drawable drawable2 = this.f16947o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f16947o = drawableMutate;
            if (drawableMutate != null) {
                u(drawableMutate, getWidth(), getHeight());
                this.f16947o.setCallback(this);
                this.f16947o.setAlpha(this.f16949q);
            }
            n2.n1(this);
        }
    }

    public void setContentScrimColor(@l int i7) {
        setContentScrim(new ColorDrawable(i7));
    }

    public void setContentScrimResource(@u int i7) {
        setContentScrim(androidx.core.content.d.i(getContext(), i7));
    }

    public void setExpandedTitleColor(@l int i7) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i7));
    }

    public void setExpandedTitleGravity(int i7) {
        this.f16943k.q0(i7);
    }

    public void setExpandedTitleMargin(int i7, int i8, int i9, int i10) {
        this.f16938f = i7;
        this.f16939g = i8;
        this.f16940h = i9;
        this.f16941i = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i7) {
        this.f16941i = i7;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i7) {
        this.f16940h = i7;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i7) {
        this.f16938f = i7;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i7) {
        this.f16939g = i7;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@b1 int i7) {
        this.f16943k.n0(i7);
    }

    public void setExpandedTitleTextColor(@m0 ColorStateList colorStateList) {
        this.f16943k.p0(colorStateList);
    }

    public void setExpandedTitleTypeface(@o0 Typeface typeface) {
        this.f16943k.s0(typeface);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z7) {
        this.C = z7;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z7) {
        this.A = z7;
    }

    @t0(23)
    @x0({x0.a.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i7) {
        this.f16943k.x0(i7);
    }

    @t0(23)
    @x0({x0.a.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f8) {
        this.f16943k.z0(f8);
    }

    @t0(23)
    @x0({x0.a.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@v(from = 0.0d) float f8) {
        this.f16943k.A0(f8);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void setMaxLines(int i7) {
        this.f16943k.B0(i7);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z7) {
        this.f16943k.D0(z7);
    }

    void setScrimAlpha(int i7) {
        ViewGroup viewGroup;
        if (i7 != this.f16949q) {
            if (this.f16947o != null && (viewGroup = this.f16935c) != null) {
                n2.n1(viewGroup);
            }
            this.f16949q = i7;
            n2.n1(this);
        }
    }

    public void setScrimAnimationDuration(@e0(from = 0) long j7) {
        this.f16952t = j7;
    }

    public void setScrimVisibleHeightTrigger(@e0(from = 0) int i7) {
        if (this.f16953u != i7) {
            this.f16953u = i7;
            x();
        }
    }

    public void setScrimsShown(boolean z7) {
        setScrimsShown(z7, n2.U0(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@o0 Drawable drawable) {
        Drawable drawable2 = this.f16948p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f16948p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f16948p.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.d.m(this.f16948p, n2.Z(this));
                this.f16948p.setVisible(getVisibility() == 0, false);
                this.f16948p.setCallback(this);
                this.f16948p.setAlpha(this.f16949q);
            }
            n2.n1(this);
        }
    }

    public void setStatusBarScrimColor(@l int i7) {
        setStatusBarScrim(new ColorDrawable(i7));
    }

    public void setStatusBarScrimResource(@u int i7) {
        setStatusBarScrim(androidx.core.content.d.i(getContext(), i7));
    }

    public void setTitle(@o0 CharSequence charSequence) {
        this.f16943k.F0(charSequence);
        t();
    }

    public void setTitleCollapseMode(int i7) {
        this.f16956x = i7;
        boolean zN = n();
        this.f16943k.v0(zN);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            b((AppBarLayout) parent);
        }
        if (zN && this.f16947o == null) {
            setContentScrimColor(this.f16944l.g(getResources().getDimension(R.dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEnabled(boolean z7) {
        if (z7 != this.f16945m) {
            this.f16945m = z7;
            t();
            w();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z7 = i7 == 0;
        Drawable drawable = this.f16948p;
        if (drawable != null && drawable.isVisible() != z7) {
            this.f16948p.setVisible(z7, false);
        }
        Drawable drawable2 = this.f16947o;
        if (drawable2 == null || drawable2.isVisible() == z7) {
            return;
        }
        this.f16947o.setVisible(z7, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@m0 Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f16947o || drawable == this.f16948p;
    }

    final void x() {
        if (this.f16947o == null && this.f16948p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f16955w < getScrimVisibleHeightTrigger());
    }

    public CollapsingToolbarLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedTitleTextColor(@m0 ColorStateList colorStateList) {
        this.f16943k.f0(colorStateList);
    }

    public void setScrimsShown(boolean z7, boolean z8) {
        if (this.f16950r != z7) {
            if (z8) {
                a(z7 ? 255 : 0);
            } else {
                setScrimAlpha(z7 ? 255 : 0);
            }
            this.f16950r = z7;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = D;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f16933a = true;
        this.f16942j = new Rect();
        this.f16953u = -1;
        this.f16958z = 0;
        this.B = 0;
        Context context2 = getContext();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.f16943k = aVar;
        aVar.G0(com.google.android.material.animation.a.f16850e);
        aVar.D0(false);
        this.f16944l = new n1.a(context2);
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.CollapsingToolbarLayout, i7, i8, new int[0]);
        aVar.q0(typedArrayJ.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, BadgeDrawable.f16997t));
        aVar.g0(typedArrayJ.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayJ.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f16941i = dimensionPixelSize;
        this.f16940h = dimensionPixelSize;
        this.f16939g = dimensionPixelSize;
        this.f16938f = dimensionPixelSize;
        if (typedArrayJ.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f16938f = typedArrayJ.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayJ.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f16940h = typedArrayJ.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayJ.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f16939g = typedArrayJ.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayJ.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f16941i = typedArrayJ.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f16945m = typedArrayJ.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayJ.getText(R.styleable.CollapsingToolbarLayout_title));
        aVar.n0(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        aVar.d0(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayJ.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            aVar.n0(typedArrayJ.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (typedArrayJ.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            aVar.d0(typedArrayJ.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.f16953u = typedArrayJ.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (typedArrayJ.hasValue(R.styleable.CollapsingToolbarLayout_maxLines)) {
            aVar.B0(typedArrayJ.getInt(R.styleable.CollapsingToolbarLayout_maxLines, 1));
        }
        this.f16952t = typedArrayJ.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(typedArrayJ.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayJ.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(typedArrayJ.getInt(R.styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.f16934b = typedArrayJ.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.A = typedArrayJ.getBoolean(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.C = typedArrayJ.getBoolean(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayJ.recycle();
        setWillNotDraw(false);
        n2.a2(this, new a());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final float f16959c = 0.5f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f16960d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f16961e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f16962f = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f16964b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f16963a = 0;
            this.f16964b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f16963a = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            d(typedArrayObtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f16963a;
        }

        public float b() {
            return this.f16964b;
        }

        public void c(int i7) {
            this.f16963a = i7;
        }

        public void d(float f8) {
            this.f16964b = f8;
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
            this.f16963a = 0;
            this.f16964b = 0.5f;
        }

        public LayoutParams(int i7, int i8, int i9) {
            super(i7, i8, i9);
            this.f16963a = 0;
            this.f16964b = 0.5f;
        }

        public LayoutParams(@m0 ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f16963a = 0;
            this.f16964b = 0.5f;
        }

        public LayoutParams(@m0 ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f16963a = 0;
            this.f16964b = 0.5f;
        }

        @t0(19)
        public LayoutParams(@m0 FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f16963a = 0;
            this.f16964b = 0.5f;
        }
    }
}
