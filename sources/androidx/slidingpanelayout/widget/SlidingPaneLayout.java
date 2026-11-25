package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.customview.view.AbsSavedState;
import c.l;
import c.m0;
import c.o0;
import c.r0;
import c.u;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    private static final int A = 400;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f9772x = "SlidingPaneLayout";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f9773y = 32;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f9774z = -858993460;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f9777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f9778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f9781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f9782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f9783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f9784j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f9785k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9786l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f9787m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f9788n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private d f9789o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final androidx.customview.widget.d f9790p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f9791q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f9792r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f9793s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final ArrayList<b> f9794t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Method f9795u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Field f9796v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f9797w;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f9803c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f9803c ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9803c = parcel.readInt() != 0;
        }
    }

    class a extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f9804d = new Rect();

        a() {
        }

        private void n(l0 l0Var, l0 l0Var2) {
            Rect rect = this.f9804d;
            l0Var2.s(rect);
            l0Var.R0(rect);
            l0Var2.t(rect);
            l0Var.S0(rect);
            l0Var.V1(l0Var2.B0());
            l0Var.x1(l0Var2.N());
            l0Var.W0(l0Var2.w());
            l0Var.a1(l0Var2.A());
            l0Var.g1(l0Var2.o0());
            l0Var.X0(l0Var2.j0());
            l0Var.i1(l0Var2.p0());
            l0Var.j1(l0Var2.q0());
            l0Var.O0(l0Var2.g0());
            l0Var.G1(l0Var2.y0());
            l0Var.t1(l0Var2.t0());
            l0Var.a(l0Var2.p());
            l0Var.v1(l0Var2.L());
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.a
        public void g(View view, l0 l0Var) {
            l0 l0VarF0 = l0.F0(l0Var);
            super.g(view, l0VarF0);
            n(l0Var, l0VarF0);
            l0VarF0.I0();
            l0Var.W0(SlidingPaneLayout.class.getName());
            l0Var.I1(view);
            Object objL0 = n2.l0(view);
            if (objL0 instanceof View) {
                l0Var.z1((View) objL0);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i7);
                if (!o(childAt) && childAt.getVisibility() == 0) {
                    n2.R1(childAt, 1);
                    l0Var.c(childAt);
                }
            }
        }

        @Override // androidx.core.view.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (o(view)) {
                return false;
            }
            return super.i(viewGroup, view, accessibilityEvent);
        }

        public boolean o(View view) {
            return SlidingPaneLayout.this.j(view);
        }
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f9806a;

        b(View view) {
            this.f9806a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9806a.getParent() == SlidingPaneLayout.this) {
                this.f9806a.setLayerType(0, null);
                SlidingPaneLayout.this.i(this.f9806a);
            }
            SlidingPaneLayout.this.f9794t.remove(this);
        }
    }

    private class c extends androidx.customview.widget.d.c {
        c() {
        }

        @Override // androidx.customview.widget.d.c
        public int a(View view, int i7, int i8) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f9781g.getLayoutParams();
            if (SlidingPaneLayout.this.k()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + SlidingPaneLayout.this.f9781g.getWidth());
                return Math.max(Math.min(i7, width), width - SlidingPaneLayout.this.f9784j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            return Math.min(Math.max(i7, paddingLeft), SlidingPaneLayout.this.f9784j + paddingLeft);
        }

        @Override // androidx.customview.widget.d.c
        public int b(View view, int i7, int i8) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.d.c
        public int d(View view) {
            return SlidingPaneLayout.this.f9784j;
        }

        @Override // androidx.customview.widget.d.c
        public void f(int i7, int i8) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f9790p.d(slidingPaneLayout.f9781g, i8);
        }

        @Override // androidx.customview.widget.d.c
        public void i(View view, int i7) {
            SlidingPaneLayout.this.r();
        }

        @Override // androidx.customview.widget.d.c
        public void j(int i7) {
            if (SlidingPaneLayout.this.f9790p.F() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f9782h != 0.0f) {
                    slidingPaneLayout.g(slidingPaneLayout.f9781g);
                    SlidingPaneLayout.this.f9791q = true;
                } else {
                    slidingPaneLayout.v(slidingPaneLayout.f9781g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.f(slidingPaneLayout2.f9781g);
                    SlidingPaneLayout.this.f9791q = false;
                }
            }
        }

        @Override // androidx.customview.widget.d.c
        public void k(View view, int i7, int i8, int i9, int i10) {
            SlidingPaneLayout.this.n(i7);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.d.c
        public void l(View view, float f8, float f9) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.k()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f8 < 0.0f || (f8 == 0.0f && SlidingPaneLayout.this.f9782h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f9784j;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f9781g.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f8 > 0.0f || (f8 == 0.0f && SlidingPaneLayout.this.f9782h > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f9784j;
                }
            }
            SlidingPaneLayout.this.f9790p.V(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.d.c
        public boolean m(View view, int i7) {
            if (SlidingPaneLayout.this.f9785k) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f9800b;
        }
    }

    public interface d {
        void a(@m0 View view, float f8);

        void b(@m0 View view);

        void c(@m0 View view);
    }

    public static class e implements d {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.d
        public void a(View view, float f8) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.d
        public void b(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.d
        public void c(View view) {
        }
    }

    public SlidingPaneLayout(@m0 Context context) {
        this(context, null);
    }

    private boolean d(View view, int i7) {
        if (!this.f9792r && !u(0.0f, i7)) {
            return false;
        }
        this.f9791q = false;
        return true;
    }

    private void e(View view, float f8, int i7) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f8 > 0.0f && i7 != 0) {
            int i8 = (((int) ((((-16777216) & i7) >>> 24) * f8)) << 24) | (i7 & n2.f6742s);
            if (layoutParams.f9802d == null) {
                layoutParams.f9802d = new Paint();
            }
            layoutParams.f9802d.setColorFilter(new PorterDuffColorFilter(i8, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f9802d);
            }
            i(view);
            return;
        }
        if (view.getLayerType() != 0) {
            Paint paint = layoutParams.f9802d;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            b bVar = new b(view);
            this.f9794t.add(bVar);
            n2.p1(this, bVar);
        }
    }

    private boolean p(View view, int i7) {
        if (!this.f9792r && !u(1.0f, i7)) {
            return false;
        }
        this.f9791q = true;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private void q(float f8) {
        boolean z7;
        boolean zK = k();
        LayoutParams layoutParams = (LayoutParams) this.f9781g.getLayoutParams();
        if (!layoutParams.f9801c) {
            z7 = false;
        } else if ((zK ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) <= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != this.f9781g) {
                float f9 = 1.0f - this.f9783i;
                int i8 = this.f9786l;
                this.f9783i = f8;
                int i9 = ((int) (f9 * i8)) - ((int) ((1.0f - f8) * i8));
                if (zK) {
                    i9 = -i9;
                }
                childAt.offsetLeftAndRight(i9);
                if (z7) {
                    float f10 = this.f9783i;
                    e(childAt, zK ? f10 - 1.0f : 1.0f - f10, this.f9776b);
                }
            }
        }
    }

    private static boolean w(View view) {
        return view.isOpaque();
    }

    protected boolean a(View view, boolean z7, int i7, int i8, int i9) {
        int i10;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i11 = i8 + scrollX;
                if (i11 >= childAt.getLeft() && i11 < childAt.getRight() && (i10 = i9 + scrollY) >= childAt.getTop() && i10 < childAt.getBottom() && a(childAt, true, i7, i11 - childAt.getLeft(), i10 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z7) {
            if (view.canScrollHorizontally(k() ? i7 : -i7)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean b() {
        return this.f9780f;
    }

    public boolean c() {
        return d(this.f9781g, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f9790p.o(true)) {
            if (this.f9780f) {
                n2.n1(this);
            } else {
                this.f9790p.a();
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i7;
        int right;
        super.draw(canvas);
        Drawable drawable = k() ? this.f9778d : this.f9777c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (k()) {
            right = childAt.getRight();
            i7 = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i8 = left - intrinsicWidth;
            i7 = left;
            right = i8;
        }
        drawable.setBounds(right, top, i7, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j7) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.f9780f && !layoutParams.f9800b && this.f9781g != null) {
            canvas.getClipBounds(this.f9793s);
            if (k()) {
                Rect rect = this.f9793s;
                rect.left = Math.max(rect.left, this.f9781g.getRight());
            } else {
                Rect rect2 = this.f9793s;
                rect2.right = Math.min(rect2.right, this.f9781g.getLeft());
            }
            canvas.clipRect(this.f9793s);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j7);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    void f(View view) {
        d dVar = this.f9789o;
        if (dVar != null) {
            dVar.c(view);
        }
        sendAccessibilityEvent(32);
    }

    void g(View view) {
        d dVar = this.f9789o;
        if (dVar != null) {
            dVar.b(view);
        }
        sendAccessibilityEvent(32);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @l
    public int getCoveredFadeColor() {
        return this.f9776b;
    }

    @r0
    public int getParallaxDistance() {
        return this.f9786l;
    }

    @l
    public int getSliderFadeColor() {
        return this.f9775a;
    }

    void h(View view) {
        d dVar = this.f9789o;
        if (dVar != null) {
            dVar.a(view, this.f9782h);
        }
    }

    void i(View view) {
        n2.V1(view, ((LayoutParams) view.getLayoutParams()).f9802d);
    }

    boolean j(View view) {
        if (view == null) {
            return false;
        }
        return this.f9780f && ((LayoutParams) view.getLayoutParams()).f9801c && this.f9782h > 0.0f;
    }

    boolean k() {
        return n2.Z(this) == 1;
    }

    public boolean l() {
        return !this.f9780f || this.f9782h == 1.0f;
    }

    public boolean m() {
        return this.f9780f;
    }

    void n(int i7) {
        if (this.f9781g == null) {
            this.f9782h = 0.0f;
            return;
        }
        boolean zK = k();
        LayoutParams layoutParams = (LayoutParams) this.f9781g.getLayoutParams();
        int width = this.f9781g.getWidth();
        if (zK) {
            i7 = (getWidth() - i7) - width;
        }
        float paddingRight = (i7 - ((zK ? getPaddingRight() : getPaddingLeft()) + (zK ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin))) / this.f9784j;
        this.f9782h = paddingRight;
        if (this.f9786l != 0) {
            q(paddingRight);
        }
        if (layoutParams.f9801c) {
            e(this.f9781g, this.f9782h, this.f9775a);
        }
        h(this.f9781g);
    }

    public boolean o() {
        return p(this.f9781g, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9792r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9792r = true;
        int size = this.f9794t.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f9794t.get(i7).run();
        }
        this.f9794t.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f9780f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f9791q = !this.f9790p.L(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f9780f || (this.f9785k && actionMasked != 0)) {
            this.f9790p.c();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.f9790p.c();
            return false;
        }
        if (actionMasked == 0) {
            this.f9785k = false;
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            this.f9787m = x7;
            this.f9788n = y7;
            if (this.f9790p.L(this.f9781g, (int) x7, (int) y7) && j(this.f9781g)) {
                z7 = true;
            }
            return this.f9790p.W(motionEvent) || z7;
        }
        if (actionMasked == 2) {
            float x8 = motionEvent.getX();
            float y8 = motionEvent.getY();
            float fAbs = Math.abs(x8 - this.f9787m);
            float fAbs2 = Math.abs(y8 - this.f9788n);
            if (fAbs > this.f9790p.E() && fAbs2 > fAbs) {
                this.f9790p.c();
                this.f9785k = true;
                return false;
            }
        }
        z7 = false;
        if (this.f9790p.W(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        boolean zK = k();
        if (zK) {
            this.f9790p.T(2);
        } else {
            this.f9790p.T(1);
        }
        int i15 = i9 - i7;
        int paddingRight = zK ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zK ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f9792r) {
            this.f9782h = (this.f9780f && this.f9791q) ? 1.0f : 0.0f;
        }
        int i16 = paddingRight;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f9800b) {
                    int i18 = i15 - paddingLeft;
                    int iMin = (Math.min(paddingRight, i18 - this.f9779e) - i16) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.f9784j = iMin;
                    int i19 = zK ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    layoutParams.f9801c = ((i16 + i19) + iMin) + (measuredWidth / 2) > i18;
                    int i20 = (int) (iMin * this.f9782h);
                    i16 += i19 + i20;
                    this.f9782h = i20 / iMin;
                    i11 = 0;
                } else if (!this.f9780f || (i12 = this.f9786l) == 0) {
                    i16 = paddingRight;
                    i11 = 0;
                } else {
                    i11 = (int) ((1.0f - this.f9782h) * i12);
                    i16 = paddingRight;
                }
                if (zK) {
                    i14 = (i15 - i16) + i11;
                    i13 = i14 - measuredWidth;
                } else {
                    i13 = i16 - i11;
                    i14 = i13 + measuredWidth;
                }
                childAt.layout(i13, paddingTop, i14, childAt.getMeasuredHeight() + paddingTop);
                paddingRight += childAt.getWidth();
            }
        }
        if (this.f9792r) {
            if (this.f9780f) {
                if (this.f9786l != 0) {
                    q(this.f9782h);
                }
                if (((LayoutParams) this.f9781g.getLayoutParams()).f9801c) {
                    e(this.f9781g, this.f9782h, this.f9775a);
                }
            } else {
                for (int i21 = 0; i21 < childCount; i21++) {
                    e(getChildAt(i21), 0.0f, this.f9775a);
                }
            }
            v(this.f9781g);
        }
        this.f9792r = false;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ad A[PHI: r13
      0x00ad: PHI (r13v2 float) = (r13v1 float), (r13v8 float) binds: [B:36:0x00a4, B:38:0x00a9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:58:0x0103 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:62:0x010c  */
    /* JADX WARN: Code duplicated, block: B:63:0x010f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0115  */
    /* JADX WARN: Code duplicated, block: B:76:0x013a  */
    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        int paddingTop;
        int iMin;
        int i9;
        int iMakeMeasureSpec;
        int i10;
        int i11;
        int iMakeMeasureSpec2;
        int i12;
        int i13;
        float f8;
        int i14;
        int iMakeMeasureSpec3;
        int iMakeMeasureSpec4;
        int i15;
        int iMakeMeasureSpec5;
        int iMakeMeasureSpec6;
        int measuredHeight;
        boolean z7;
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            if (mode2 == 0) {
                size2 = 300;
                mode2 = Integer.MIN_VALUE;
            }
        }
        boolean z8 = false;
        if (mode2 != Integer.MIN_VALUE) {
            iMin = mode2 != 1073741824 ? 0 : (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = iMin;
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            iMin = 0;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e(f9772x, "onMeasure: More than two child views are not supported.");
        }
        this.f9781g = null;
        int i16 = 0;
        boolean z9 = false;
        int i17 = paddingLeft;
        float f9 = 0.0f;
        while (true) {
            i9 = 8;
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f9801c = z8;
            } else {
                float f10 = layoutParams.f9799a;
                if (f10 > 0.0f) {
                    f9 += f10;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width != 0) {
                        i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        i13 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                        if (i13 == -2) {
                            iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, Integer.MIN_VALUE);
                            f8 = f9;
                            i14 = Integer.MIN_VALUE;
                        } else {
                            f8 = f9;
                            i14 = Integer.MIN_VALUE;
                            if (i13 == -1) {
                                iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, 1073741824);
                            } else {
                                iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                            }
                            i15 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                            if (i15 == -2) {
                                iMakeMeasureSpec6 = View.MeasureSpec.makeMeasureSpec(paddingTop, i14);
                            } else {
                                if (i15 == -1) {
                                    iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                                }
                                iMakeMeasureSpec6 = iMakeMeasureSpec5;
                            }
                            childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec6);
                            int measuredWidth = childAt.getMeasuredWidth();
                            measuredHeight = childAt.getMeasuredHeight();
                            if (mode2 == i14 && measuredHeight > iMin) {
                                iMin = Math.min(measuredHeight, paddingTop);
                            }
                            i17 -= measuredWidth;
                            if (i17 < 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            layoutParams.f9800b = z7;
                            z9 |= z7;
                            if (z7) {
                                this.f9781g = childAt;
                            }
                            f9 = f8;
                        }
                        iMakeMeasureSpec3 = iMakeMeasureSpec4;
                        i15 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        if (i15 == -2) {
                            iMakeMeasureSpec6 = View.MeasureSpec.makeMeasureSpec(paddingTop, i14);
                        } else {
                            if (i15 == -1) {
                                iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                            } else {
                                iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                            }
                            iMakeMeasureSpec6 = iMakeMeasureSpec5;
                        }
                        childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec6);
                        int measuredWidth2 = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                        if (mode2 == i14) {
                            iMin = Math.min(measuredHeight, paddingTop);
                        }
                        i17 -= measuredWidth2;
                        if (i17 < 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        layoutParams.f9800b = z7;
                        z9 |= z7;
                        if (z7) {
                            this.f9781g = childAt;
                        }
                        f9 = f8;
                    }
                } else {
                    i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    i13 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    if (i13 == -2) {
                        iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, Integer.MIN_VALUE);
                        f8 = f9;
                        i14 = Integer.MIN_VALUE;
                    } else {
                        f8 = f9;
                        i14 = Integer.MIN_VALUE;
                        if (i13 == -1) {
                            iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i12, 1073741824);
                        } else {
                            iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                        }
                        i15 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                        if (i15 == -2) {
                            iMakeMeasureSpec6 = View.MeasureSpec.makeMeasureSpec(paddingTop, i14);
                        } else {
                            if (i15 == -1) {
                                iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                            } else {
                                iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                            }
                            iMakeMeasureSpec6 = iMakeMeasureSpec5;
                        }
                        childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec6);
                        int measuredWidth3 = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                        if (mode2 == i14) {
                            iMin = Math.min(measuredHeight, paddingTop);
                        }
                        i17 -= measuredWidth3;
                        if (i17 < 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        layoutParams.f9800b = z7;
                        z9 |= z7;
                        if (z7) {
                            this.f9781g = childAt;
                        }
                        f9 = f8;
                    }
                    iMakeMeasureSpec3 = iMakeMeasureSpec4;
                    i15 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    if (i15 == -2) {
                        iMakeMeasureSpec6 = View.MeasureSpec.makeMeasureSpec(paddingTop, i14);
                    } else {
                        if (i15 == -1) {
                            iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                        } else {
                            iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                        }
                        iMakeMeasureSpec6 = iMakeMeasureSpec5;
                    }
                    childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec6);
                    int measuredWidth4 = childAt.getMeasuredWidth();
                    measuredHeight = childAt.getMeasuredHeight();
                    if (mode2 == i14) {
                        iMin = Math.min(measuredHeight, paddingTop);
                    }
                    i17 -= measuredWidth4;
                    if (i17 < 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    layoutParams.f9800b = z7;
                    z9 |= z7;
                    if (z7) {
                        this.f9781g = childAt;
                    }
                    f9 = f8;
                }
            }
            i16++;
            z8 = false;
        }
        if (z9 || f9 > 0.0f) {
            int i18 = paddingLeft - this.f9779e;
            int i19 = 0;
            while (i19 < childCount) {
                View childAt2 = getChildAt(i19);
                if (childAt2.getVisibility() == i9) {
                    i10 = i18;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i9) {
                        boolean z10 = ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.f9799a > 0.0f;
                        int measuredWidth5 = z10 ? 0 : childAt2.getMeasuredWidth();
                        if (!z9 || childAt2 == this.f9781g) {
                            if (layoutParams2.f9799a > 0.0f) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                    int i20 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i20 == -2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    } else {
                                        iMakeMeasureSpec = i20 == -1 ? View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824) : View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                                    }
                                } else {
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z9) {
                                    int i21 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                    i10 = i18;
                                    int iMakeMeasureSpec7 = View.MeasureSpec.makeMeasureSpec(i21, 1073741824);
                                    if (measuredWidth5 != i21) {
                                        childAt2.measure(iMakeMeasureSpec7, iMakeMeasureSpec);
                                    }
                                } else {
                                    i10 = i18;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth5 + ((int) ((layoutParams2.f9799a * Math.max(0, i17)) / f9)), 1073741824), iMakeMeasureSpec);
                                }
                            }
                        } else if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth5 > i18 || layoutParams2.f9799a > 0.0f)) {
                            if (z10) {
                                int i22 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                if (i22 == -2) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    i11 = 1073741824;
                                } else if (i22 == -1) {
                                    i11 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    i11 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i22, 1073741824);
                                }
                            } else {
                                i11 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i18, i11), iMakeMeasureSpec2);
                        }
                        i10 = i18;
                    } else {
                        i10 = i18;
                    }
                }
                i19++;
                i18 = i10;
                i9 = 8;
            }
        }
        setMeasuredDimension(size, iMin + getPaddingTop() + getPaddingBottom());
        this.f9780f = z9;
        if (this.f9790p.F() == 0 || z9) {
            return;
        }
        this.f9790p.a();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.f9803c) {
            o();
        } else {
            c();
        }
        this.f9791q = savedState.f9803c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f9803c = m() ? l() : this.f9791q;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        if (i7 != i9) {
            this.f9792r = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f9780f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f9790p.M(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            this.f9787m = x7;
            this.f9788n = y7;
        } else if (actionMasked == 1 && j(this.f9781g)) {
            float x8 = motionEvent.getX();
            float y8 = motionEvent.getY();
            float f8 = x8 - this.f9787m;
            float f9 = y8 - this.f9788n;
            int iE = this.f9790p.E();
            if ((f8 * f8) + (f9 * f9) < iE * iE && this.f9790p.L(this.f9781g, (int) x8, (int) y8)) {
                d(this.f9781g, 0);
            }
        }
        return true;
    }

    void r() {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.f9780f) {
            return;
        }
        this.f9791q = view == this.f9781g;
    }

    @Deprecated
    public void s() {
        c();
    }

    public void setCoveredFadeColor(@l int i7) {
        this.f9776b = i7;
    }

    public void setPanelSlideListener(@o0 d dVar) {
        this.f9789o = dVar;
    }

    public void setParallaxDistance(@r0 int i7) {
        this.f9786l = i7;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@o0 Drawable drawable) {
        this.f9777c = drawable;
    }

    public void setShadowDrawableRight(@o0 Drawable drawable) {
        this.f9778d = drawable;
    }

    @Deprecated
    public void setShadowResource(@u int i7) {
        setShadowDrawable(getResources().getDrawable(i7));
    }

    public void setShadowResourceLeft(int i7) {
        setShadowDrawableLeft(androidx.core.content.d.i(getContext(), i7));
    }

    public void setShadowResourceRight(int i7) {
        setShadowDrawableRight(androidx.core.content.d.i(getContext(), i7));
    }

    public void setSliderFadeColor(@l int i7) {
        this.f9775a = i7;
    }

    @Deprecated
    public void t() {
        o();
    }

    boolean u(float f8, int i7) {
        int paddingLeft;
        if (!this.f9780f) {
            return false;
        }
        boolean zK = k();
        LayoutParams layoutParams = (LayoutParams) this.f9781g.getLayoutParams();
        if (zK) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (f8 * this.f9784j)) + this.f9781g.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (f8 * this.f9784j));
        }
        androidx.customview.widget.d dVar = this.f9790p;
        View view = this.f9781g;
        if (!dVar.X(view, paddingLeft, view.getTop())) {
            return false;
        }
        r();
        n2.n1(this);
        return true;
    }

    void v(View view) {
        int left;
        int right;
        int top;
        int bottom;
        View childAt;
        View view2 = view;
        boolean zK = k();
        int width = zK ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zK ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !w(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount && (childAt = getChildAt(i7)) != view2) {
            if (childAt.getVisibility() != 8) {
                childAt.setVisibility((Math.max(zK ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zK ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i7++;
            view2 = view;
            zK = zK;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int[] f9798e = {R.attr.layout_weight};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f9799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f9800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f9801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Paint f9802d;

        public LayoutParams() {
            super(-1, -1);
            this.f9799a = 0.0f;
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
            this.f9799a = 0.0f;
        }

        public LayoutParams(@m0 ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9799a = 0.0f;
        }

        public LayoutParams(@m0 ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f9799a = 0.0f;
        }

        public LayoutParams(@m0 LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f9799a = 0.0f;
            this.f9799a = layoutParams.f9799a;
        }

        public LayoutParams(@m0 Context context, @o0 AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9799a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f9798e);
            this.f9799a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f9775a = f9774z;
        this.f9792r = true;
        this.f9793s = new Rect();
        this.f9794t = new ArrayList<>();
        float f8 = context.getResources().getDisplayMetrics().density;
        this.f9779e = (int) ((32.0f * f8) + 0.5f);
        setWillNotDraw(false);
        n2.B1(this, new a());
        n2.R1(this, 1);
        androidx.customview.widget.d dVarP = androidx.customview.widget.d.p(this, 0.5f, new c());
        this.f9790p = dVarP;
        dVarP.U(f8 * 400.0f);
    }
}
