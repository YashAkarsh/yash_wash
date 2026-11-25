package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.r;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.core.view.t1;
import androidx.core.view.w5;
import androidx.core.view.z1;
import androidx.customview.view.AbsSavedState;
import c.b0;
import c.g1;
import c.l;
import c.m0;
import c.o0;
import c.t0;
import c.u;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.shape.j;
import com.google.android.material.shape.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final int f16870r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final int f16871s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final int f16872t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final int f16873u = 4;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final int f16874v = 8;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f16875w = R.style.Widget_Design_AppBarLayout;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f16876x = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private w5 f16883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<c> f16884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f16887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f16888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @b0
    private int f16889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @o0
    private WeakReference<View> f16890n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private ValueAnimator f16891o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int[] f16892p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @o0
    private Drawable f16893q;

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class a extends BaseBehavior.d<AppBarLayout> {
        }

        public Behavior() {
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int G() {
            return super.G();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int H() {
            return super.H();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean I() {
            return super.I();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean J() {
            return super.J();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void L(boolean z7) {
            super.L(z7);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean M(int i7) {
            return super.M(i7);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean N(int i7) {
            return super.N(i7);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void O(boolean z7) {
            super.O(z7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: p0 */
        public /* bridge */ /* synthetic */ boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout, int i7) {
            return super.m(coordinatorLayout, appBarLayout, i7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: q0 */
        public /* bridge */ /* synthetic */ boolean n(@m0 CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout, int i7, int i8, int i9, int i10) {
            return super.n(coordinatorLayout, appBarLayout, i7, i8, i9, i10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: r0 */
        public /* bridge */ /* synthetic */ void r(CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout, View view, int i7, int i8, int[] iArr, int i9) {
            super.r(coordinatorLayout, appBarLayout, view, i7, i8, iArr, i9);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: s0 */
        public /* bridge */ /* synthetic */ void u(CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout, View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
            super.u(coordinatorLayout, appBarLayout, view, i7, i8, i9, i10, i11, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: t0 */
        public /* bridge */ /* synthetic */ void y(@m0 CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout, Parcelable parcelable) {
            super.y(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: u0 */
        public /* bridge */ /* synthetic */ Parcelable z(@m0 CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout) {
            return super.z(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: v0 */
        public /* bridge */ /* synthetic */ boolean B(@m0 CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout, @m0 View view, View view2, int i7, int i8) {
            return super.B(coordinatorLayout, appBarLayout, view, view2, i7, i8);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: w0 */
        public /* bridge */ /* synthetic */ void D(CoordinatorLayout coordinatorLayout, @m0 AppBarLayout appBarLayout, View view, int i7) {
            super.D(coordinatorLayout, appBarLayout, view, i7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void x0(@o0 BaseBehavior.d dVar) {
            super.x0(dVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int Z(@m0 AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (behaviorF instanceof BaseBehavior) {
                return ((BaseBehavior) behaviorF).U();
            }
            return 0;
        }

        private void a0(@m0 View view, @m0 View view2) {
            CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (behaviorF instanceof BaseBehavior) {
                n2.f1(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behaviorF).f16896l) + U()) - Q(view2));
            }
        }

        private void b0(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.l()) {
                    appBarLayout.w(appBarLayout.y(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int G() {
            return super.G();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int H() {
            return super.H();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean I() {
            return super.I();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean J() {
            return super.J();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void L(boolean z7) {
            super.L(z7);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean M(int i7) {
            return super.M(i7);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean N(int i7) {
            return super.N(i7);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void O(boolean z7) {
            super.O(z7);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float R(View view) {
            int i7;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iZ = Z(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iZ > downNestedPreScrollRange) && (i7 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iZ / i7) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int T(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.T(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @o0
        /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
        public AppBarLayout P(@m0 List<View> list) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = list.get(i7);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean f(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean i(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, @m0 View view2) {
            a0(view, view2);
            b0(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void j(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, @m0 View view2) {
            if (view2 instanceof AppBarLayout) {
                n2.r1(coordinatorLayout, l0.a.f6504r.b());
                n2.r1(coordinatorLayout, l0.a.f6505s.b());
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, int i7) {
            return super.m(coordinatorLayout, view, i7);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean n(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, int i7, int i8, int i9, int i10) {
            return super.n(coordinatorLayout, view, i7, i8, i9, i10);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean x(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, @m0 Rect rect, boolean z7) {
            AppBarLayout appBarLayoutP = P(coordinatorLayout.w(view));
            if (appBarLayoutP != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f16979d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutP.setExpanded(false, !z7);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            W(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class a implements z1 {
        a() {
        }

        @Override // androidx.core.view.z1
        public w5 a(View view, w5 w5Var) {
            return AppBarLayout.this.o(w5Var);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f16931a;

        b(j jVar) {
            this.f16931a = jVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            this.f16931a.m0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public interface c<T extends AppBarLayout> {
        void a(T t7, int i7);
    }

    public interface d extends c<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.c
        void a(AppBarLayout appBarLayout, int i7);
    }

    public AppBarLayout(@m0 Context context) {
        this(context, null);
    }

    private void A(@m0 j jVar, boolean z7) {
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        float f8 = z7 ? 0.0f : dimension;
        if (!z7) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f16891o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f8, dimension);
        this.f16891o = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.f16891o.setInterpolator(com.google.android.material.animation.a.f16846a);
        this.f16891o.addUpdateListener(new b(jVar));
        this.f16891o.start();
    }

    private void B() {
        setWillNotDraw(!x());
    }

    private void c() {
        WeakReference<View> weakReference = this.f16890n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f16890n = null;
    }

    @o0
    private View d(@o0 View view) {
        int i7;
        if (this.f16890n == null && (i7 = this.f16889m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i7) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f16889m);
            }
            if (viewFindViewById != null) {
                this.f16890n = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f16890n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean i() {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            if (((LayoutParams) getChildAt(i7).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void k() {
        this.f16878b = -1;
        this.f16879c = -1;
        this.f16880d = -1;
    }

    private void s(boolean z7, boolean z8, boolean z9) {
        this.f16882f = (z7 ? 1 : 2) | (z8 ? 4 : 0) | (z9 ? 8 : 0);
        requestLayout();
    }

    private boolean u(boolean z7) {
        if (this.f16886j == z7) {
            return false;
        }
        this.f16886j = z7;
        refreshDrawableState();
        return true;
    }

    private boolean x() {
        return this.f16893q != null && getTopInset() > 0;
    }

    private boolean z() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || n2.U(childAt)) ? false : true;
    }

    public void a(@o0 c cVar) {
        if (this.f16884h == null) {
            this.f16884h = new ArrayList();
        }
        if (cVar == null || this.f16884h.contains(cVar)) {
            return;
        }
        this.f16884h.add(cVar);
    }

    public void b(d dVar) {
        a(dVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@m0 Canvas canvas) {
        super.draw(canvas);
        if (x()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f16877a);
            this.f16893q.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f16893q;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @m0
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int iE0;
        int i7 = this.f16879c;
        if (i7 != -1) {
            return i7;
        }
        int i8 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i9 = layoutParams.f16928a;
            if ((i9 & 5) != 5) {
                if (i8 > 0) {
                    break;
                }
            } else {
                int i10 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i9 & 8) != 0) {
                    iE0 = n2.e0(childAt);
                } else {
                    if ((i9 & 2) != 0) {
                        iE0 = measuredHeight - n2.e0(childAt);
                    } else {
                        iMin = i10 + measuredHeight;
                    }
                    if (childCount == 0 && n2.U(childAt)) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i8 += iMin;
                }
                iMin = i10 + iE0;
                if (childCount == 0) {
                    iMin = Math.min(iMin, measuredHeight - getTopInset());
                }
                i8 += iMin;
            }
        }
        int iMax = Math.max(0, i8);
        this.f16879c = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i7 = this.f16880d;
        if (i7 != -1) {
            return i7;
        }
        int childCount = getChildCount();
        int iE0 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i9 = layoutParams.f16928a;
            if ((i9 & 1) == 0) {
                break;
            }
            iE0 += measuredHeight;
            if ((i9 & 2) != 0) {
                iE0 -= n2.e0(childAt);
                break;
            }
        }
        int iMax = Math.max(0, iE0);
        this.f16880d = iMax;
        return iMax;
    }

    @b0
    public int getLiftOnScrollTargetViewId() {
        return this.f16889m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iE0 = n2.e0(this);
        if (iE0 == 0) {
            int childCount = getChildCount();
            iE0 = childCount >= 1 ? n2.e0(getChildAt(childCount - 1)) : 0;
            if (iE0 == 0) {
                return getHeight() / 3;
            }
        }
        return (iE0 * 2) + topInset;
    }

    int getPendingAction() {
        return this.f16882f;
    }

    @o0
    public Drawable getStatusBarForeground() {
        return this.f16893q;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @g1
    final int getTopInset() {
        w5 w5Var = this.f16883g;
        if (w5Var != null) {
            return w5Var.r();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i7 = this.f16878b;
        if (i7 != -1) {
            return i7;
        }
        int childCount = getChildCount();
        int iE0 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i9 = layoutParams.f16928a;
            if ((i9 & 1) == 0) {
                break;
            }
            iE0 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i8 == 0 && n2.U(childAt)) {
                iE0 -= getTopInset();
            }
            if ((i9 & 2) != 0) {
                iE0 -= n2.e0(childAt);
                break;
            }
        }
        int iMax = Math.max(0, iE0);
        this.f16878b = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean h() {
        return this.f16881e;
    }

    boolean j() {
        return getTotalScrollRange() != 0;
    }

    public boolean l() {
        return this.f16888l;
    }

    public boolean m() {
        return this.f16887k;
    }

    void n(int i7) {
        this.f16877a = i7;
        if (!willNotDraw()) {
            n2.n1(this);
        }
        List<c> list = this.f16884h;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                c cVar = this.f16884h.get(i8);
                if (cVar != null) {
                    cVar.a(this, i7);
                }
            }
        }
    }

    w5 o(w5 w5Var) {
        w5 w5Var2 = n2.U(this) ? w5Var : null;
        if (!r.a(this.f16883g, w5Var2)) {
            this.f16883g = w5Var2;
            B();
            requestLayout();
        }
        return w5Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i7) {
        if (this.f16892p == null) {
            this.f16892p = new int[4];
        }
        int[] iArr = this.f16892p;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i7 + iArr.length);
        boolean z7 = this.f16886j;
        int i8 = R.attr.state_liftable;
        if (!z7) {
            i8 = -i8;
        }
        iArr[0] = i8;
        iArr[1] = (z7 && this.f16887k) ? R.attr.state_lifted : -R.attr.state_lifted;
        int i9 = R.attr.state_collapsible;
        if (!z7) {
            i9 = -i9;
        }
        iArr[2] = i9;
        iArr[3] = (z7 && this.f16887k) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        boolean z8 = true;
        if (n2.U(this) && z()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                n2.f1(getChildAt(childCount), topInset);
            }
        }
        k();
        this.f16881e = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            if (((LayoutParams) getChildAt(i11).getLayoutParams()).b() != null) {
                this.f16881e = true;
                break;
            }
        }
        Drawable drawable = this.f16893q;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f16885i) {
            return;
        }
        if (!this.f16888l && !i()) {
            z8 = false;
        }
        u(z8);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        int mode = View.MeasureSpec.getMode(i8);
        if (mode != 1073741824 && n2.U(this) && z()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = m.a.e(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i8));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        k();
    }

    public void p(@o0 c cVar) {
        List<c> list = this.f16884h;
        if (list == null || cVar == null) {
            return;
        }
        list.remove(cVar);
    }

    public void q(d dVar) {
        p(dVar);
    }

    void r() {
        this.f16882f = 0;
    }

    @Override // android.view.View
    @t0(21)
    public void setElevation(float f8) {
        super.setElevation(f8);
        k.d(this, f8);
    }

    public void setExpanded(boolean z7) {
        setExpanded(z7, n2.U0(this));
    }

    public void setLiftOnScroll(boolean z7) {
        this.f16888l = z7;
    }

    public void setLiftOnScrollTargetViewId(@b0 int i7) {
        this.f16889m = i7;
        c();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i7) {
        if (i7 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i7);
    }

    public void setStatusBarForeground(@o0 Drawable drawable) {
        Drawable drawable2 = this.f16893q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f16893q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f16893q.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.d.m(this.f16893q, n2.Z(this));
                this.f16893q.setVisible(getVisibility() == 0, false);
                this.f16893q.setCallback(this);
            }
            B();
            n2.n1(this);
        }
    }

    public void setStatusBarForegroundColor(@l int i7) {
        setStatusBarForeground(new ColorDrawable(i7));
    }

    public void setStatusBarForegroundResource(@u int i7) {
        setStatusBarForeground(e.a.b(getContext(), i7));
    }

    @Deprecated
    public void setTargetElevation(float f8) {
        f.b(this, f8);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z7 = i7 == 0;
        Drawable drawable = this.f16893q;
        if (drawable != null) {
            drawable.setVisible(z7, false);
        }
    }

    public boolean t(boolean z7) {
        this.f16885i = true;
        return u(z7);
    }

    public boolean v(boolean z7) {
        return w(z7);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@m0 Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f16893q;
    }

    boolean w(boolean z7) {
        if (this.f16887k == z7) {
            return false;
        }
        this.f16887k = z7;
        refreshDrawableState();
        if (!this.f16888l || !(getBackground() instanceof j)) {
            return true;
        }
        A((j) getBackground(), z7);
        return true;
    }

    boolean y(@o0 View view) {
        View viewD = d(view);
        if (viewD != null) {
            view = viewD;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final int f16894t = 600;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final int f16895u = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f16896l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f16897m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private ValueAnimator f16898n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f16899o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f16900p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private float f16901q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @o0
        private WeakReference<View> f16902r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private d f16903s;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f16907a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f16908b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f16907a = coordinatorLayout;
                this.f16908b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
                BaseBehavior.this.X(this.f16907a, this.f16908b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b implements androidx.core.view.accessibility.t0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f16910a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f16911b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f16912c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f16913d;

            b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i7) {
                this.f16910a = coordinatorLayout;
                this.f16911b = appBarLayout;
                this.f16912c = view;
                this.f16913d = i7;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.core.view.accessibility.t0
            public boolean a(@m0 View view, @o0 androidx.core.view.accessibility.t0.a aVar) {
                BaseBehavior.this.r(this.f16910a, this.f16911b, this.f16912c, 0, this.f16913d, new int[]{0, 0}, 1);
                return true;
            }
        }

        class c implements androidx.core.view.accessibility.t0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f16915a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f16916b;

            c(AppBarLayout appBarLayout, boolean z7) {
                this.f16915a = appBarLayout;
                this.f16916b = z7;
            }

            @Override // androidx.core.view.accessibility.t0
            public boolean a(@m0 View view, @o0 androidx.core.view.accessibility.t0.a aVar) {
                this.f16915a.setExpanded(this.f16916b);
                return true;
            }
        }

        public static abstract class d<T extends AppBarLayout> {
            public abstract boolean a(@m0 T t7);
        }

        public BaseBehavior() {
            this.f16899o = -1;
        }

        private void A0(CoordinatorLayout coordinatorLayout, @m0 T t7) {
            int iU = U();
            int iJ0 = j0(t7, iU);
            if (iJ0 >= 0) {
                View childAt = t7.getChildAt(iJ0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int iA = layoutParams.a();
                if ((iA & 17) == 17) {
                    int i7 = -childAt.getTop();
                    int iE0 = -childAt.getBottom();
                    if (iJ0 == t7.getChildCount() - 1) {
                        iE0 += t7.getTopInset();
                    }
                    if (g0(iA, 2)) {
                        iE0 += n2.e0(childAt);
                    } else if (g0(iA, 5)) {
                        int iE1 = n2.e0(childAt) + iE0;
                        if (iU < iE1) {
                            i7 = iE1;
                        } else {
                            iE0 = iE1;
                        }
                    }
                    if (g0(iA, 32)) {
                        i7 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        iE0 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (iU < (iE0 + i7) / 2) {
                        i7 = iE0;
                    }
                    c0(coordinatorLayout, t7, m.a.e(i7, -t7.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void B0(CoordinatorLayout coordinatorLayout, @m0 T t7) {
            n2.r1(coordinatorLayout, l0.a.f6504r.b());
            n2.r1(coordinatorLayout, l0.a.f6505s.b());
            View viewH0 = h0(coordinatorLayout);
            if (viewH0 == null || t7.getTotalScrollRange() == 0 || !(((CoordinatorLayout.f) viewH0.getLayoutParams()).f() instanceof ScrollingViewBehavior)) {
                return;
            }
            a0(coordinatorLayout, t7, viewH0);
        }

        private void C0(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7, int i7, int i8, boolean z7) {
            View viewI0 = i0(t7, i7);
            if (viewI0 != null) {
                int iA = ((LayoutParams) viewI0.getLayoutParams()).a();
                boolean zY = false;
                if ((iA & 1) != 0) {
                    int iE0 = n2.e0(viewI0);
                    if (i8 <= 0 || (iA & 12) == 0 ? !((iA & 2) == 0 || (-i7) < (viewI0.getBottom() - iE0) - t7.getTopInset()) : (-i7) >= (viewI0.getBottom() - iE0) - t7.getTopInset()) {
                        zY = true;
                    }
                }
                if (t7.l()) {
                    zY = t7.y(h0(coordinatorLayout));
                }
                boolean zW = t7.w(zY);
                if (z7 || (zW && z0(coordinatorLayout, t7))) {
                    t7.jumpDrawablesToCurrentState();
                }
            }
        }

        private void a0(CoordinatorLayout coordinatorLayout, @m0 T t7, @m0 View view) {
            if (U() != (-t7.getTotalScrollRange()) && view.canScrollVertically(1)) {
                b0(coordinatorLayout, t7, l0.a.f6504r, false);
            }
            if (U() != 0) {
                if (!view.canScrollVertically(-1)) {
                    b0(coordinatorLayout, t7, l0.a.f6505s, true);
                    return;
                }
                int i7 = -t7.getDownNestedPreScrollRange();
                if (i7 != 0) {
                    n2.u1(coordinatorLayout, l0.a.f6505s, null, new b(coordinatorLayout, t7, view, i7));
                }
            }
        }

        private void b0(CoordinatorLayout coordinatorLayout, @m0 T t7, @m0 l0.a aVar, boolean z7) {
            n2.u1(coordinatorLayout, aVar, null, new c(t7, z7));
        }

        private void c0(CoordinatorLayout coordinatorLayout, @m0 T t7, int i7, float f8) {
            int iAbs = Math.abs(U() - i7);
            float fAbs = Math.abs(f8);
            d0(coordinatorLayout, t7, i7, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t7.getHeight()) + 1.0f) * 150.0f));
        }

        private void d0(CoordinatorLayout coordinatorLayout, T t7, int i7, int i8) {
            int iU = U();
            if (iU == i7) {
                ValueAnimator valueAnimator = this.f16898n;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f16898n.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f16898n;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f16898n = valueAnimator3;
                valueAnimator3.setInterpolator(com.google.android.material.animation.a.f16850e);
                this.f16898n.addUpdateListener(new a(coordinatorLayout, t7));
            } else {
                valueAnimator2.cancel();
            }
            this.f16898n.setDuration(Math.min(i8, 600));
            this.f16898n.setIntValues(iU, i7);
            this.f16898n.start();
        }

        private boolean f0(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7, @m0 View view) {
            return t7.j() && coordinatorLayout.getHeight() - view.getHeight() <= t7.getHeight();
        }

        private static boolean g0(int i7, int i8) {
            return (i7 & i8) == i8;
        }

        @o0
        private View h0(@m0 CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = coordinatorLayout.getChildAt(i7);
                if ((childAt instanceof t1) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @o0
        private static View i0(@m0 AppBarLayout appBarLayout, int i7) {
            int iAbs = Math.abs(i7);
            int childCount = appBarLayout.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = appBarLayout.getChildAt(i8);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int j0(@m0 T t7, int i7) {
            int childCount = t7.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = t7.getChildAt(i8);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (g0(layoutParams.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i9 = -i7;
                if (top <= i9 && bottom >= i9) {
                    return i8;
                }
            }
            return -1;
        }

        private int m0(@m0 T t7, int i7) {
            int iAbs = Math.abs(i7);
            int childCount = t7.getChildCount();
            int topInset = 0;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = t7.getChildAt(i8);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolatorB = layoutParams.b();
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    if (interpolatorB == null) {
                        break;
                    }
                    int iA = layoutParams.a();
                    if ((iA & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((iA & 2) != 0) {
                            topInset -= n2.e0(childAt);
                        }
                    }
                    if (n2.U(childAt)) {
                        topInset -= t7.getTopInset();
                    }
                    if (topInset <= 0) {
                        break;
                    }
                    float f8 = topInset;
                    return Integer.signum(i7) * (childAt.getTop() + Math.round(f8 * interpolatorB.getInterpolation((iAbs - childAt.getTop()) / f8)));
                }
            }
            return i7;
        }

        private boolean z0(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7) {
            List<View> listX = coordinatorLayout.x(t7);
            int size = listX.size();
            for (int i7 = 0; i7 < size; i7++) {
                CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.f) listX.get(i7).getLayoutParams()).f();
                if (behaviorF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behaviorF).S() != 0;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int U() {
            return H() + this.f16896l;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public boolean P(T t7) {
            d dVar = this.f16903s;
            if (dVar != null) {
                return dVar.a(t7);
            }
            WeakReference<View> weakReference = this.f16902r;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
        public int S(@m0 T t7) {
            return -t7.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
        public int T(@m0 T t7) {
            return t7.getTotalScrollRange();
        }

        @g1
        boolean n0() {
            ValueAnimator valueAnimator = this.f16898n;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
        public void V(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7) {
            A0(coordinatorLayout, t7);
            if (t7.l()) {
                t7.w(t7.y(h0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
        public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7, int i7) {
            boolean zM = super.m(coordinatorLayout, t7, i7);
            int pendingAction = t7.getPendingAction();
            int i8 = this.f16899o;
            if (i8 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t7.getChildAt(i8);
                X(coordinatorLayout, t7, (-childAt.getBottom()) + (this.f16900p ? n2.e0(childAt) + t7.getTopInset() : Math.round(childAt.getHeight() * this.f16901q)));
            } else if (pendingAction != 0) {
                boolean z7 = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i9 = -t7.getUpNestedPreScrollRange();
                    if (z7) {
                        c0(coordinatorLayout, t7, i9, 0.0f);
                    } else {
                        X(coordinatorLayout, t7, i9);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z7) {
                        c0(coordinatorLayout, t7, 0, 0.0f);
                    } else {
                        X(coordinatorLayout, t7, 0);
                    }
                }
            }
            t7.r();
            this.f16899o = -1;
            N(m.a.e(H(), -t7.getTotalScrollRange(), 0));
            C0(coordinatorLayout, t7, H(), 0, true);
            t7.n(H());
            B0(coordinatorLayout, t7);
            return zM;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
        public boolean n(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7, int i7, int i8, int i9, int i10) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t7.getLayoutParams())).height != -2) {
                return super.n(coordinatorLayout, t7, i7, i8, i9, i10);
            }
            coordinatorLayout.O(t7, i7, i8, View.MeasureSpec.makeMeasureSpec(0, 0), i10);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
        public void r(CoordinatorLayout coordinatorLayout, @m0 T t7, View view, int i7, int i8, int[] iArr, int i9) {
            int i10;
            int downNestedPreScrollRange;
            if (i8 != 0) {
                if (i8 < 0) {
                    i10 = -t7.getTotalScrollRange();
                    downNestedPreScrollRange = t7.getDownNestedPreScrollRange() + i10;
                } else {
                    i10 = -t7.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i11 = i10;
                int i12 = downNestedPreScrollRange;
                if (i11 != i12) {
                    iArr[1] = W(coordinatorLayout, t7, i8, i11, i12);
                }
            }
            if (t7.l()) {
                t7.w(t7.y(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
        public void u(CoordinatorLayout coordinatorLayout, @m0 T t7, View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
            if (i10 < 0) {
                iArr[1] = W(coordinatorLayout, t7, i10, -t7.getDownNestedScrollRange(), 0);
            }
            if (i10 == 0) {
                B0(coordinatorLayout, t7);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
        public void y(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7, Parcelable parcelable) {
            if (!(parcelable instanceof SavedState)) {
                super.y(coordinatorLayout, t7, parcelable);
                this.f16899o = -1;
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.y(coordinatorLayout, t7, savedState.a());
            this.f16899o = savedState.f16904c;
            this.f16901q = savedState.f16905d;
            this.f16900p = savedState.f16906e;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
        public Parcelable z(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7) {
            Parcelable parcelableZ = super.z(coordinatorLayout, t7);
            int iH = H();
            int childCount = t7.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = t7.getChildAt(i7);
                int bottom = childAt.getBottom() + iH;
                if (childAt.getTop() + iH <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(parcelableZ);
                    savedState.f16904c = i7;
                    savedState.f16906e = bottom == n2.e0(childAt) + t7.getTopInset();
                    savedState.f16905d = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return parcelableZ;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
        public boolean B(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7, @m0 View view, View view2, int i7, int i8) {
            ValueAnimator valueAnimator;
            boolean z7 = (i7 & 2) != 0 && (t7.l() || f0(coordinatorLayout, t7, view));
            if (z7 && (valueAnimator = this.f16898n) != null) {
                valueAnimator.cancel();
            }
            this.f16902r = null;
            this.f16897m = i8;
            return z7;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
        public void D(CoordinatorLayout coordinatorLayout, @m0 T t7, View view, int i7) {
            if (this.f16897m == 0 || i7 == 1) {
                A0(coordinatorLayout, t7);
                if (t7.l()) {
                    t7.w(t7.y(view));
                }
            }
            this.f16902r = new WeakReference<>(view);
        }

        public void x0(@o0 d dVar) {
            this.f16903s = dVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
        public int Y(@m0 CoordinatorLayout coordinatorLayout, @m0 T t7, int i7, int i8, int i9) {
            int iU = U();
            int i10 = 0;
            if (i8 == 0 || iU < i8 || iU > i9) {
                this.f16896l = 0;
            } else {
                int iE = m.a.e(i7, i8, i9);
                if (iU != iE) {
                    int iM0 = t7.h() ? m0(t7, iE) : iE;
                    boolean zN = N(iM0);
                    i10 = iU - iE;
                    this.f16896l = iE - iM0;
                    if (!zN && t7.h()) {
                        coordinatorLayout.l(t7);
                    }
                    t7.n(H());
                    C0(coordinatorLayout, t7, iE, iE < iU ? -1 : 1, false);
                }
            }
            B0(coordinatorLayout, t7);
            return i10;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f16899o = -1;
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f16904c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            float f16905d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            boolean f16906e;

            static class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                @o0
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(@m0 Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @m0
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(@m0 Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @m0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i7) {
                    return new SavedState[i7];
                }
            }

            public SavedState(@m0 Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f16904c = parcel.readInt();
                this.f16905d = parcel.readFloat();
                this.f16906e = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@m0 Parcel parcel, int i7) {
                super.writeToParcel(parcel, i7);
                parcel.writeInt(this.f16904c);
                parcel.writeFloat(this.f16905d);
                parcel.writeByte(this.f16906e ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public AppBarLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public void setExpanded(boolean z7, boolean z8) {
        s(z7, z8, true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = f16875w;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f16878b = -1;
        this.f16879c = -1;
        this.f16880d = -1;
        this.f16882f = 0;
        Context context2 = getContext();
        setOrientation(1);
        int i9 = Build.VERSION.SDK_INT;
        f.a(this);
        f.c(this, attributeSet, i7, i8);
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.AppBarLayout, i7, i8, new int[0]);
        n2.I1(this, typedArrayJ.getDrawable(R.styleable.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            j jVar = new j();
            jVar.n0(ColorStateList.valueOf(colorDrawable.getColor()));
            jVar.Y(context2);
            n2.I1(this, jVar);
        }
        if (typedArrayJ.hasValue(R.styleable.AppBarLayout_expanded)) {
            s(typedArrayJ.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (typedArrayJ.hasValue(R.styleable.AppBarLayout_elevation)) {
            f.b(this, typedArrayJ.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (i9 >= 26) {
            if (typedArrayJ.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayJ.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayJ.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayJ.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.f16888l = typedArrayJ.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.f16889m = typedArrayJ.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayJ.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        typedArrayJ.recycle();
        n2.a2(this, new a());
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f16918c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f16919d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f16920e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f16921f = 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f16922g = 8;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f16923h = 16;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f16924i = 32;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f16925j = 5;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final int f16926k = 17;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final int f16927l = 10;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Interpolator f16929b;

        @x0({x0.a.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f16928a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f16928a = typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f16929b = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f16928a;
        }

        public Interpolator b() {
            return this.f16929b;
        }

        boolean c() {
            int i7 = this.f16928a;
            return (i7 & 1) == 1 && (i7 & 10) != 0;
        }

        public void d(int i7) {
            this.f16928a = i7;
        }

        public void e(Interpolator interpolator) {
            this.f16929b = interpolator;
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
            this.f16928a = 1;
        }

        public LayoutParams(int i7, int i8, float f8) {
            super(i7, i8, f8);
            this.f16928a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f16928a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f16928a = 1;
        }

        @t0(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f16928a = 1;
        }

        @t0(19)
        public LayoutParams(@m0 LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.f16928a = 1;
            this.f16928a = layoutParams.f16928a;
            this.f16929b = layoutParams.f16929b;
        }
    }
}
