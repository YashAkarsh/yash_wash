package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.core.graphics.b2;
import androidx.core.view.n2;
import androidx.core.view.v1;
import androidx.core.view.w1;
import androidx.core.view.w5;
import androidx.core.view.x1;
import androidx.core.view.y1;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements e0, x1, v1, w1 {
    private static final String F = "ActionBarOverlayLayout";
    private static final int G = 600;
    static final int[] H = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    ViewPropertyAnimator A;
    final AnimatorListenerAdapter B;
    private final Runnable C;
    private final Runnable D;
    private final y1 E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ContentFrameLayout f1314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ActionBarContainer f1315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f0 f1316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f1317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f1322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1323l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1324m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Rect f1325n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Rect f1326o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Rect f1327p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Rect f1328q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Rect f1329r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f1330s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Rect f1331t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @c.m0
    private w5 f1332u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @c.m0
    private w5 f1333v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @c.m0
    private w5 f1334w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @c.m0
    private w5 f1335x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private d f1336y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private OverScroller f1337z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f1322k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f1322k = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.w();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f1315d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.w();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f1315d.animate().translationY(-ActionBarOverlayLayout.this.f1315d.getHeight()).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    public interface d {
        void a();

        void b();

        void c(boolean z7);

        void d();

        void e();

        void f(int i7);
    }

    public ActionBarOverlayLayout(@c.m0 Context context) {
        this(context, null);
    }

    private void A() {
        w();
        postDelayed(this.D, 600L);
    }

    private void B() {
        w();
        postDelayed(this.C, 600L);
    }

    private void D() {
        w();
        this.C.run();
    }

    private boolean E(float f8) {
        this.f1337z.fling(0, 0, 0, (int) f8, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1337z.getFinalY() > this.f1315d.getHeight();
    }

    private void a() {
        w();
        this.D.run();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    private boolean d(@c.m0 View view, @c.m0 Rect rect, boolean z7, boolean z8, boolean z9, boolean z10) {
        boolean z11;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z7) {
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int i8 = rect.left;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i8;
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        if (z8) {
            int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int i10 = rect.top;
            if (i9 != i10) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i10;
                z11 = true;
            }
        }
        if (z10) {
            int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int i12 = rect.right;
            if (i11 != i12) {
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i12;
                z11 = true;
            }
        }
        if (z9) {
            int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int i14 = rect.bottom;
            if (i13 != i14) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i14;
                return true;
            }
        }
        return z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private f0 v(View view) {
        if (view instanceof f0) {
            return (f0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void x(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(H);
        this.f1312a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f1317f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f1318g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f1337z = new OverScroller(context);
    }

    void C() {
        if (this.f1314c == null) {
            this.f1314c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f1315d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.f1316e = v(findViewById(R.id.action_bar));
        }
    }

    @Override // androidx.appcompat.widget.e0
    public boolean b() {
        C();
        return this.f1316e.b();
    }

    @Override // androidx.appcompat.widget.e0
    public boolean c() {
        C();
        return this.f1316e.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1317f == null || this.f1318g) {
            return;
        }
        int bottom = this.f1315d.getVisibility() == 0 ? (int) (this.f1315d.getBottom() + this.f1315d.getTranslationY() + 0.5f) : 0;
        this.f1317f.setBounds(0, bottom, getWidth(), this.f1317f.getIntrinsicHeight() + bottom);
        this.f1317f.draw(canvas);
    }

    @Override // androidx.core.view.w1
    public void e(View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        f(view, i7, i8, i9, i10, i11);
    }

    @Override // androidx.core.view.v1
    public void f(View view, int i7, int i8, int i9, int i10, int i11) {
        if (i11 == 0) {
            onNestedScroll(view, i7, i8, i9, i10);
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.e0
    public boolean g() {
        C();
        return this.f1316e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1315d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup, androidx.core.view.x1
    public int getNestedScrollAxes() {
        return this.E.a();
    }

    @Override // androidx.appcompat.widget.e0
    public CharSequence getTitle() {
        C();
        return this.f1316e.getTitle();
    }

    @Override // androidx.appcompat.widget.e0
    public boolean h() {
        C();
        return this.f1316e.h();
    }

    @Override // androidx.appcompat.widget.e0
    public boolean i() {
        C();
        return this.f1316e.i();
    }

    @Override // androidx.appcompat.widget.e0
    public boolean j() {
        C();
        return this.f1316e.j();
    }

    @Override // androidx.appcompat.widget.e0
    public boolean k() {
        C();
        return this.f1316e.k();
    }

    @Override // androidx.appcompat.widget.e0
    public void l(SparseArray<Parcelable> sparseArray) {
        C();
        this.f1316e.w(sparseArray);
    }

    @Override // androidx.appcompat.widget.e0
    public void m(int i7) {
        C();
        if (i7 == 2) {
            this.f1316e.P();
        } else if (i7 == 5) {
            this.f1316e.R();
        } else {
            if (i7 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void n() {
        C();
        this.f1316e.m();
    }

    @Override // androidx.appcompat.widget.e0
    public void o(SparseArray<Parcelable> sparseArray) {
        C();
        this.f1316e.J(sparseArray);
    }

    @Override // android.view.View
    @c.t0(21)
    public WindowInsets onApplyWindowInsets(@c.m0 WindowInsets windowInsets) {
        C();
        w5 w5VarL = w5.L(windowInsets, this);
        boolean zD = d(this.f1315d, new Rect(w5VarL.p(), w5VarL.r(), w5VarL.q(), w5VarL.o()), true, true, false, true);
        n2.o(this, w5VarL, this.f1325n);
        Rect rect = this.f1325n;
        w5 w5VarX = w5VarL.x(rect.left, rect.top, rect.right, rect.bottom);
        this.f1332u = w5VarX;
        boolean z7 = true;
        if (!this.f1333v.equals(w5VarX)) {
            this.f1333v = this.f1332u;
            zD = true;
        }
        if (this.f1326o.equals(this.f1325n)) {
            z7 = zD;
        } else {
            this.f1326o.set(this.f1325n);
        }
        if (z7) {
            requestLayout();
        }
        return w5VarL.a().c().b().J();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x(getContext());
        n2.v1(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i12, i13, measuredWidth + i12, measuredHeight + i13);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        int measuredHeight;
        C();
        measureChildWithMargins(this.f1315d, i7, 0, i8, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1315d.getLayoutParams();
        int iMax = Math.max(0, this.f1315d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int iMax2 = Math.max(0, this.f1315d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1315d.getMeasuredState());
        boolean z7 = (n2.C0(this) & 256) != 0;
        if (z7) {
            measuredHeight = this.f1312a;
            if (this.f1320i && this.f1315d.getTabContainer() != null) {
                measuredHeight += this.f1312a;
            }
        } else {
            measuredHeight = this.f1315d.getVisibility() != 8 ? this.f1315d.getMeasuredHeight() : 0;
        }
        this.f1327p.set(this.f1325n);
        w5 w5Var = this.f1332u;
        this.f1334w = w5Var;
        if (this.f1319h || z7) {
            this.f1334w = new w5.b(this.f1334w).h(b2.d(w5Var.p(), this.f1334w.r() + measuredHeight, this.f1334w.q(), this.f1334w.o() + 0)).a();
        } else {
            Rect rect = this.f1327p;
            rect.top += measuredHeight;
            rect.bottom += 0;
            this.f1334w = w5Var.x(0, measuredHeight, 0, 0);
        }
        d(this.f1314c, this.f1327p, true, true, true, true);
        if (!this.f1335x.equals(this.f1334w)) {
            w5 w5Var2 = this.f1334w;
            this.f1335x = w5Var2;
            n2.p(this.f1314c, w5Var2);
        }
        measureChildWithMargins(this.f1314c, i7, 0, i8, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f1314c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1314c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f1314c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1314c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i7, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i8, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedFling(View view, float f8, float f9, boolean z7) {
        if (!this.f1321j || !z7) {
            return false;
        }
        if (E(f9)) {
            a();
        } else {
            D();
        }
        this.f1322k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedPreFling(View view, float f8, float f9) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedPreScroll(View view, int i7, int i8, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedScroll(View view, int i7, int i8, int i9, int i10) {
        int i11 = this.f1323l + i8;
        this.f1323l = i11;
        setActionBarHideOffset(i11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedScrollAccepted(View view, View view2, int i7) {
        this.E.b(view, view2, i7);
        this.f1323l = getActionBarHideOffset();
        w();
        d dVar = this.f1336y;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onStartNestedScroll(View view, View view2, int i7) {
        if ((i7 & 2) == 0 || this.f1315d.getVisibility() != 0) {
            return false;
        }
        return this.f1321j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onStopNestedScroll(View view) {
        if (this.f1321j && !this.f1322k) {
            if (this.f1323l <= this.f1315d.getHeight()) {
                B();
            } else {
                A();
            }
        }
        d dVar = this.f1336y;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i7) {
        super.onWindowSystemUiVisibilityChanged(i7);
        C();
        int i8 = this.f1324m ^ i7;
        this.f1324m = i7;
        boolean z7 = (i7 & 4) == 0;
        boolean z8 = (i7 & 256) != 0;
        d dVar = this.f1336y;
        if (dVar != null) {
            dVar.c(!z8);
            if (z7 || !z8) {
                this.f1336y.a();
            } else {
                this.f1336y.d();
            }
        }
        if ((i8 & 256) == 0 || this.f1336y == null) {
            return;
        }
        n2.v1(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i7) {
        super.onWindowVisibilityChanged(i7);
        this.f1313b = i7;
        d dVar = this.f1336y;
        if (dVar != null) {
            dVar.f(i7);
        }
    }

    @Override // androidx.core.view.v1
    public boolean p(View view, View view2, int i7, int i8) {
        return i8 == 0 && onStartNestedScroll(view, view2, i7);
    }

    @Override // androidx.core.view.v1
    public void q(View view, View view2, int i7, int i8) {
        if (i8 == 0) {
            onNestedScrollAccepted(view, view2, i7);
        }
    }

    @Override // androidx.core.view.v1
    public void r(View view, int i7) {
        if (i7 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.v1
    public void s(View view, int i7, int i8, int[] iArr, int i9) {
        if (i9 == 0) {
            onNestedPreScroll(view, i7, i8, iArr);
        }
    }

    public void setActionBarHideOffset(int i7) {
        w();
        this.f1315d.setTranslationY(-Math.max(0, Math.min(i7, this.f1315d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f1336y = dVar;
        if (getWindowToken() != null) {
            this.f1336y.f(this.f1313b);
            int i7 = this.f1324m;
            if (i7 != 0) {
                onWindowSystemUiVisibilityChanged(i7);
                n2.v1(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z7) {
        this.f1320i = z7;
    }

    public void setHideOnContentScrollEnabled(boolean z7) {
        if (z7 != this.f1321j) {
            this.f1321j = z7;
            if (z7) {
                return;
            }
            w();
            setActionBarHideOffset(0);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void setIcon(int i7) {
        C();
        this.f1316e.setIcon(i7);
    }

    @Override // androidx.appcompat.widget.e0
    public void setLogo(int i7) {
        C();
        this.f1316e.setLogo(i7);
    }

    @Override // androidx.appcompat.widget.e0
    public void setMenu(Menu menu, androidx.appcompat.view.menu.n.a aVar) {
        C();
        this.f1316e.setMenu(menu, aVar);
    }

    @Override // androidx.appcompat.widget.e0
    public void setMenuPrepared() {
        C();
        this.f1316e.setMenuPrepared();
    }

    public void setOverlayMode(boolean z7) {
        this.f1319h = z7;
        this.f1318g = z7 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z7) {
    }

    @Override // androidx.appcompat.widget.e0
    public void setUiOptions(int i7) {
    }

    @Override // androidx.appcompat.widget.e0
    public void setWindowCallback(Window.Callback callback) {
        C();
        this.f1316e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.e0
    public void setWindowTitle(CharSequence charSequence) {
        C();
        this.f1316e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    void w() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean y() {
        return this.f1321j;
    }

    public boolean z() {
        return this.f1319h;
    }

    public ActionBarOverlayLayout(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1313b = 0;
        this.f1325n = new Rect();
        this.f1326o = new Rect();
        this.f1327p = new Rect();
        this.f1328q = new Rect();
        this.f1329r = new Rect();
        this.f1330s = new Rect();
        this.f1331t = new Rect();
        w5 w5Var = w5.f6889c;
        this.f1332u = w5Var;
        this.f1333v = w5Var;
        this.f1334w = w5Var;
        this.f1335x = w5Var;
        this.B = new a();
        this.C = new b();
        this.D = new c();
        x(context);
        this.E = new y1(this);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.widget.e0
    public void setIcon(Drawable drawable) {
        C();
        this.f1316e.setIcon(drawable);
    }
}
