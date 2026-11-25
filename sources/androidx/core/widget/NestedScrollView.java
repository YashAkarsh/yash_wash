package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.accessibility.l0;
import androidx.core.view.accessibility.s0;
import androidx.core.view.i2;
import androidx.core.view.n2;
import androidx.core.view.q1;
import androidx.core.view.s1;
import androidx.core.view.u1;
import androidx.core.view.w1;
import androidx.core.view.y1;
import c.g1;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements w1, s1, i2 {
    static final int A = 250;
    static final float B = 0.5f;
    private static final String C = "NestedScrollView";
    private static final int D = 250;
    private static final int E = -1;
    private static final a F = new a();
    private static final int[] G = {R.attr.fillViewport};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f6960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OverScroller f6961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    @m0
    @g1
    public EdgeEffect f6962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    @m0
    @g1
    public EdgeEffect f6963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f6967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private VelocityTracker f6969k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6970l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6971m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6972n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f6973o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6974p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f6975q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int[] f6976r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int[] f6977s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f6978t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f6979u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SavedState f6980v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final y1 f6981w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final u1 f6982x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f6983y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private c f6984z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6985a;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @m0
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f6985a + com.alipay.sdk.util.j.f13808d;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f6985a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f6985a = parcel.readInt();
        }
    }

    static class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            s0.N(accessibilityEvent, nestedScrollView.getScrollX());
            s0.P(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.a
        public void g(View view, l0 l0Var) {
            int scrollRange;
            super.g(view, l0Var);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            l0Var.W0(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            l0Var.F1(true);
            if (nestedScrollView.getScrollY() > 0) {
                l0Var.b(l0.a.f6505s);
                l0Var.b(l0.a.D);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                l0Var.b(l0.a.f6504r);
                l0Var.b(l0.a.F);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i7, Bundle bundle) {
            if (super.j(view, i7, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i7 != 4096) {
                if (i7 == 8192 || i7 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.Y(0, iMax, true);
                    return true;
                }
                if (i7 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.Y(0, iMin, true);
            return true;
        }
    }

    @t0(21)
    static class b {
        private b() {
        }

        @c.t
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public interface c {
        void a(@m0 NestedScrollView nestedScrollView, int i7, int i8, int i9, int i10);
    }

    public NestedScrollView(@m0 Context context) {
        this(context, null);
    }

    private void A() {
        VelocityTracker velocityTracker = this.f6969k;
        if (velocityTracker == null) {
            this.f6969k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void B() {
        this.f6961c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f6972n = viewConfiguration.getScaledTouchSlop();
        this.f6973o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6974p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void C() {
        if (this.f6969k == null) {
            this.f6969k = VelocityTracker.obtain();
        }
    }

    private boolean E(View view) {
        return !H(view, 0, getHeight());
    }

    private static boolean G(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && G((View) parent, view2);
    }

    private boolean H(View view, int i7, int i8) {
        view.getDrawingRect(this.f6960b);
        offsetDescendantRectToMyCoords(view, this.f6960b);
        return this.f6960b.bottom + i7 >= getScrollY() && this.f6960b.top - i7 <= getScrollY() + i8;
    }

    private void I(int i7, int i8, @o0 int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i7);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f6982x.e(0, scrollY2, 0, i7 - scrollY2, null, i8, iArr);
    }

    private void J(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f6975q) {
            int i7 = actionIndex == 0 ? 1 : 0;
            this.f6964f = (int) motionEvent.getY(i7);
            this.f6975q = motionEvent.getPointerId(i7);
            VelocityTracker velocityTracker = this.f6969k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void M() {
        VelocityTracker velocityTracker = this.f6969k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6969k = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0060  */
    private int N(int i7, float f8) {
        float fJ;
        int iRound;
        float width = f8 / getWidth();
        float height = i7 / getHeight();
        float f9 = 0.0f;
        if (i.d(this.f6962d) == 0.0f) {
            if (i.d(this.f6963e) != 0.0f) {
                fJ = i.j(this.f6963e, height, 1.0f - width);
                if (i.d(this.f6963e) == 0.0f) {
                    this.f6963e.onRelease();
                }
            }
            iRound = Math.round(f9 * getHeight());
            if (iRound != 0) {
                invalidate();
            }
            return iRound;
        }
        fJ = -i.j(this.f6962d, -height, width);
        if (i.d(this.f6962d) == 0.0f) {
            this.f6962d.onRelease();
        }
        f9 = fJ;
        iRound = Math.round(f9 * getHeight());
        if (iRound != 0) {
            invalidate();
        }
        return iRound;
    }

    private void O(boolean z7) {
        if (z7) {
            g(2, 1);
        } else {
            h(1);
        }
        this.f6979u = getScrollY();
        n2.n1(this);
    }

    private boolean P(int i7, int i8, int i9) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = height + scrollY;
        boolean z7 = false;
        boolean z8 = i7 == 33;
        View viewW = w(z8, i8, i9);
        if (viewW == null) {
            viewW = this;
        }
        if (i8 < scrollY || i9 > i10) {
            o(z8 ? i8 - scrollY : i9 - i10);
            z7 = true;
        }
        if (viewW != findFocus()) {
            viewW.requestFocus(i7);
        }
        return z7;
    }

    private void Q(View view) {
        view.getDrawingRect(this.f6960b);
        offsetDescendantRectToMyCoords(view, this.f6960b);
        int iN = n(this.f6960b);
        if (iN != 0) {
            scrollBy(0, iN);
        }
    }

    private boolean R(Rect rect, boolean z7) {
        int iN = n(rect);
        boolean z8 = iN != 0;
        if (z8) {
            if (z7) {
                scrollBy(0, iN);
            } else {
                S(0, iN);
            }
        }
        return z8;
    }

    private void U(int i7, int i8, int i9, boolean z7) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f6959a > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f6961c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i8 + scrollY, Math.max(0, height - height2))) - scrollY, i9);
            O(z7);
        } else {
            if (!this.f6961c.isFinished()) {
                i();
            }
            scrollBy(i7, i8);
        }
        this.f6959a = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean Z(MotionEvent motionEvent) {
        boolean z7;
        if (i.d(this.f6962d) != 0.0f) {
            i.j(this.f6962d, 0.0f, motionEvent.getX() / getWidth());
            z7 = true;
        } else {
            z7 = false;
        }
        if (i.d(this.f6963e) == 0.0f) {
            return z7;
        }
        i.j(this.f6963e, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f6983y == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f6983y = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f6983y;
    }

    private void i() {
        this.f6961c.abortAnimation();
        h(1);
    }

    private boolean k() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean l() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int m(int i7, int i8, int i9) {
        if (i8 >= i9 || i7 < 0) {
            return 0;
        }
        return i8 + i7 > i9 ? i9 - i8 : i7;
    }

    private void o(int i7) {
        if (i7 != 0) {
            if (this.f6971m) {
                S(0, i7);
            } else {
                scrollBy(0, i7);
            }
        }
    }

    private boolean t(int i7) {
        if (i.d(this.f6962d) != 0.0f) {
            this.f6962d.onAbsorb(i7);
        } else {
            if (i.d(this.f6963e) == 0.0f) {
                return false;
            }
            this.f6963e.onAbsorb(-i7);
        }
        return true;
    }

    private void u() {
        this.f6968j = false;
        M();
        h(0);
        this.f6962d.onRelease();
        this.f6963e.onRelease();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004f  */
    private View w(boolean z7, int i7, int i8) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z8 = false;
        for (int i9 = 0; i9 < size; i9++) {
            View view2 = focusables.get(i9);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i7 < bottom && top < i8) {
                boolean z9 = i7 < top && bottom < i8;
                if (view == null) {
                    view = view2;
                    z8 = z9;
                } else {
                    boolean z10 = (z7 && top < view.getTop()) || (!z7 && bottom > view.getBottom());
                    if (z8) {
                        if (z9 && z10) {
                            view = view2;
                        }
                    } else if (z9) {
                        view = view2;
                        z8 = true;
                    } else if (z10) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private boolean z(int i7, int i8) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i8 >= childAt.getTop() - scrollY && i8 < childAt.getBottom() - scrollY && i7 >= childAt.getLeft() && i7 < childAt.getRight();
    }

    public boolean D() {
        return this.f6970l;
    }

    public boolean F() {
        return this.f6971m;
    }

    boolean K(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, boolean z7) {
        boolean z8;
        boolean z9;
        int overScrollMode = getOverScrollMode();
        boolean z10 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z11 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z12 = overScrollMode == 0 || (overScrollMode == 1 && z10);
        boolean z13 = overScrollMode == 0 || (overScrollMode == 1 && z11);
        int i15 = i9 + i7;
        int i16 = !z12 ? 0 : i13;
        int i17 = i10 + i8;
        int i18 = !z13 ? 0 : i14;
        int i19 = -i16;
        int i20 = i16 + i11;
        int i21 = -i18;
        int i22 = i18 + i12;
        if (i15 > i20) {
            i15 = i20;
            z8 = true;
        } else if (i15 < i19) {
            z8 = true;
            i15 = i19;
        } else {
            z8 = false;
        }
        if (i17 > i22) {
            i17 = i22;
            z9 = true;
        } else if (i17 < i21) {
            z9 = true;
            i17 = i21;
        } else {
            z9 = false;
        }
        if (z9 && !d(1)) {
            this.f6961c.springBack(i15, i17, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i15, i17, z8, z9);
        return z8 || z9;
    }

    public boolean L(int i7) {
        boolean z7 = i7 == 130;
        int height = getHeight();
        if (z7) {
            this.f6960b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f6960b;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f6960b.top = getScrollY() - height;
            Rect rect2 = this.f6960b;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f6960b;
        int i8 = rect3.top;
        int i9 = height + i8;
        rect3.bottom = i9;
        return P(i7, i8, i9);
    }

    public final void S(int i7, int i8) {
        U(i7, i8, androidx.recyclerview.widget.m.f.f9644c, false);
    }

    public final void T(int i7, int i8, int i9) {
        U(i7, i8, i9, false);
    }

    public final void V(int i7, int i8) {
        X(i7, i8, androidx.recyclerview.widget.m.f.f9644c, false);
    }

    public final void W(int i7, int i8, int i9) {
        X(i7, i8, i9, false);
    }

    void X(int i7, int i8, int i9, boolean z7) {
        U(i7 - getScrollX(), i8 - getScrollY(), i9, z7);
    }

    void Y(int i7, int i8, boolean z7) {
        X(i7, i8, androidx.recyclerview.widget.m.f.f9644c, z7);
    }

    @Override // androidx.core.view.r1
    public boolean a(int i7, int i8, int i9, int i10, @o0 int[] iArr, int i11) {
        return this.f6982x.g(i7, i8, i9, i10, iArr, i11);
    }

    @Override // android.view.ViewGroup
    public void addView(@m0 View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // androidx.core.view.r1
    public boolean b(int i7, int i8, @o0 int[] iArr, @o0 int[] iArr2, int i9) {
        return this.f6982x.d(i7, i8, iArr, iArr2, i9);
    }

    @Override // androidx.core.view.s1
    public void c(int i7, int i8, int i9, int i10, @o0 int[] iArr, int i11, @m0 int[] iArr2) {
        this.f6982x.e(i7, i8, i9, i10, iArr, i11, iArr2);
    }

    @Override // android.view.View, androidx.core.view.i2
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.i2
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.i2
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f6961c.isFinished()) {
            return;
        }
        this.f6961c.computeScrollOffset();
        int currY = this.f6961c.getCurrY();
        int i7 = currY - this.f6979u;
        this.f6979u = currY;
        int[] iArr = this.f6977s;
        boolean z7 = false;
        iArr[1] = 0;
        b(0, i7, iArr, null, 1);
        int i8 = i7 - this.f6977s[1];
        int scrollRange = getScrollRange();
        if (i8 != 0) {
            int scrollY = getScrollY();
            K(0, i8, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i9 = i8 - scrollY2;
            int[] iArr2 = this.f6977s;
            iArr2[1] = 0;
            c(0, scrollY2, 0, i9, this.f6976r, 1, iArr2);
            i8 = i9 - this.f6977s[1];
        }
        if (i8 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z7 = true;
            }
            if (z7) {
                if (i8 < 0) {
                    if (this.f6962d.isFinished()) {
                        this.f6962d.onAbsorb((int) this.f6961c.getCurrVelocity());
                    }
                } else if (this.f6963e.isFinished()) {
                    this.f6963e.onAbsorb((int) this.f6961c.getCurrVelocity());
                }
            }
            i();
        }
        if (this.f6961c.isFinished()) {
            h(1);
        } else {
            n2.n1(this);
        }
    }

    @Override // android.view.View, androidx.core.view.i2
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.i2
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.i2
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // androidx.core.view.r1
    public boolean d(int i7) {
        return this.f6982x.l(i7);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || v(keyEvent);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedFling(float f8, float f9, boolean z7) {
        return this.f6982x.a(f8, f9, z7);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedPreFling(float f8, float f9) {
        return this.f6982x.b(f8, f9);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedPreScroll(int i7, int i8, @o0 int[] iArr, @o0 int[] iArr2) {
        return b(i7, i8, iArr, iArr2, 0);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedScroll(int i7, int i8, int i9, int i10, @o0 int[] iArr) {
        return this.f6982x.f(i7, i8, i9, i10, iArr);
    }

    @Override // android.view.View
    public void draw(@m0 Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.f6962d.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft() + 0;
            } else {
                paddingLeft = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.f6962d.setSize(width, height);
            if (this.f6962d.draw(canvas)) {
                n2.n1(this);
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f6963e.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = 0 + getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f6963e.setSize(width2, height2);
        if (this.f6963e.draw(canvas)) {
            n2.n1(this);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // androidx.core.view.w1
    public void e(@m0 View view, int i7, int i8, int i9, int i10, int i11, @m0 int[] iArr) {
        I(i10, i11, iArr);
    }

    @Override // androidx.core.view.v1
    public void f(@m0 View view, int i7, int i8, int i9, int i10, int i11) {
        I(i10, i11, null);
    }

    @Override // androidx.core.view.r1
    public boolean g(int i7, int i8) {
        return this.f6982x.s(i7, i8);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.x1
    public int getNestedScrollAxes() {
        return this.f6981w.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // androidx.core.view.r1
    public void h(int i7) {
        this.f6982x.u(i7);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean hasNestedScrollingParent() {
        return d(0);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean isNestedScrollingEnabled() {
        return this.f6982x.m();
    }

    public boolean j(int i7) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i7);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !H(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i7 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i7 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i7 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            o(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.f6960b);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f6960b);
            o(n(this.f6960b));
            viewFindNextFocus.requestFocus(i7);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !E(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.ViewGroup
    protected void measureChild(@m0 View view, int i7, int i8) {
        view.measure(ViewGroup.getChildMeasureSpec(i7, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i7, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i7, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    protected int n(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i7 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i8 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i7 - verticalFadingEdgeLength : i7;
        int i9 = rect.bottom;
        if (i9 > i8 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i8) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i7);
        }
        if (rect.top >= scrollY || i9 >= i8) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i8 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6966h = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onGenericMotionEvent(@m0 MotionEvent motionEvent) {
        float axisValue;
        boolean z7;
        int i7 = 0;
        if (motionEvent.getAction() == 8 && !this.f6968j) {
            if (q1.l(motionEvent, 2)) {
                axisValue = motionEvent.getAxisValue(9);
            } else {
                axisValue = q1.l(motionEvent, 4194304) ? motionEvent.getAxisValue(26) : 0.0f;
            }
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i8 = scrollY - verticalScrollFactorCompat;
                if (i8 < 0) {
                    if (k() && !q1.l(motionEvent, 8194)) {
                        i.j(this.f6962d, (-i8) / getHeight(), 0.5f);
                        this.f6962d.onRelease();
                        invalidate();
                        z7 = 1;
                    } else {
                        z7 = 0;
                    }
                } else if (i8 > scrollRange) {
                    if (k() && !q1.l(motionEvent, 8194)) {
                        i.j(this.f6963e, (i8 - scrollRange) / getHeight(), 0.5f);
                        this.f6963e.onRelease();
                        invalidate();
                        i7 = 1;
                    }
                    z7 = i7;
                    i7 = scrollRange;
                } else {
                    z7 = 0;
                    i7 = i8;
                }
                if (i7 == scrollY) {
                    return z7;
                }
                super.scrollTo(getScrollX(), i7);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@m0 MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z7 = true;
        if (action == 2 && this.f6968j) {
            return true;
        }
        int i7 = action & 255;
        if (i7 == 0) {
            int y7 = (int) motionEvent.getY();
            if (z((int) motionEvent.getX(), y7)) {
                this.f6964f = y7;
                this.f6975q = motionEvent.getPointerId(0);
                A();
                this.f6969k.addMovement(motionEvent);
                this.f6961c.computeScrollOffset();
                if (!Z(motionEvent) && this.f6961c.isFinished()) {
                    z7 = false;
                }
                this.f6968j = z7;
                g(2, 0);
            } else {
                if (!Z(motionEvent) && this.f6961c.isFinished()) {
                    z7 = false;
                }
                this.f6968j = z7;
                M();
            }
        } else if (i7 == 1) {
            this.f6968j = false;
            this.f6975q = -1;
            M();
            if (this.f6961c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                n2.n1(this);
            }
            h(0);
        } else if (i7 == 2) {
            int i8 = this.f6975q;
            if (i8 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i8);
                if (iFindPointerIndex == -1) {
                    Log.e(C, "Invalid pointerId=" + i8 + " in onInterceptTouchEvent");
                } else {
                    int y8 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y8 - this.f6964f) > this.f6972n && (2 & getNestedScrollAxes()) == 0) {
                        this.f6968j = true;
                        this.f6964f = y8;
                        C();
                        this.f6969k.addMovement(motionEvent);
                        this.f6978t = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i7 == 3) {
            this.f6968j = false;
            this.f6975q = -1;
            M();
            if (this.f6961c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                n2.n1(this);
            }
            h(0);
        } else if (i7 == 6) {
            J(motionEvent);
        }
        return this.f6968j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        int measuredHeight = 0;
        this.f6965g = false;
        View view = this.f6967i;
        if (view != null && G(view, this)) {
            Q(this.f6967i);
        }
        this.f6967i = null;
        if (!this.f6966h) {
            if (this.f6980v != null) {
                scrollTo(getScrollX(), this.f6980v.f6985a);
                this.f6980v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i10 - i8) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iM = m(scrollY, paddingTop, measuredHeight);
            if (iM != scrollY) {
                scrollTo(getScrollX(), iM);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f6966h = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (this.f6970l && View.MeasureSpec.getMode(i8) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i7, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedFling(@m0 View view, float f8, float f9, boolean z7) {
        if (z7) {
            return false;
        }
        dispatchNestedFling(0.0f, f9, true);
        x((int) f9);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedPreFling(@m0 View view, float f8, float f9) {
        return dispatchNestedPreFling(f8, f9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedPreScroll(@m0 View view, int i7, int i8, @m0 int[] iArr) {
        s(view, i7, i8, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedScroll(@m0 View view, int i7, int i8, int i9, int i10) {
        I(i10, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedScrollAccepted(@m0 View view, @m0 View view2, int i7) {
        q(view, view2, i7, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i7, int i8, boolean z7, boolean z8) {
        super.scrollTo(i7, i8);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i7, Rect rect) {
        if (i7 == 2) {
            i7 = 130;
        } else if (i7 == 1) {
            i7 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i7) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i7);
        if (viewFindNextFocus == null || E(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i7, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f6980v = savedState;
        requestLayout();
    }

    @Override // android.view.View
    @m0
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6985a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i7, int i8, int i9, int i10) {
        super.onScrollChanged(i7, i8, i9, i10);
        c cVar = this.f6984z;
        if (cVar != null) {
            cVar.a(this, i7, i8, i9, i10);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !H(viewFindFocus, 0, i10)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f6960b);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f6960b);
        o(n(this.f6960b));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onStartNestedScroll(@m0 View view, @m0 View view2, int i7) {
        return p(view, view2, i7, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onStopNestedScroll(@m0 View view) {
        r(view, 0);
    }

    /* JADX WARN: Code duplicated, block: B:76:0x01d3  */
    @Override // android.view.View
    public boolean onTouchEvent(@m0 MotionEvent motionEvent) {
        ViewParent parent;
        C();
        int actionMasked = motionEvent.getActionMasked();
        boolean z7 = false;
        if (actionMasked == 0) {
            this.f6978t = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f6978t);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f6969k;
                velocityTracker.computeCurrentVelocity(1000, this.f6974p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f6975q);
                if (Math.abs(yVelocity) >= this.f6973o) {
                    if (!t(yVelocity)) {
                        int i7 = -yVelocity;
                        float f8 = i7;
                        if (!dispatchNestedPreFling(0.0f, f8)) {
                            dispatchNestedFling(0.0f, f8, true);
                            x(i7);
                        }
                    }
                } else if (this.f6961c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    n2.n1(this);
                }
                this.f6975q = -1;
                u();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f6975q);
                if (iFindPointerIndex == -1) {
                    Log.e(C, "Invalid pointerId=" + this.f6975q + " in onTouchEvent");
                } else {
                    int y7 = (int) motionEvent.getY(iFindPointerIndex);
                    int i8 = this.f6964f - y7;
                    int iN = i8 - N(i8, motionEvent.getX(iFindPointerIndex));
                    if (!this.f6968j && Math.abs(iN) > this.f6972n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f6968j = true;
                        iN = iN > 0 ? iN - this.f6972n : iN + this.f6972n;
                    }
                    int i9 = iN;
                    if (this.f6968j) {
                        if (b(0, i9, this.f6977s, this.f6976r, 0)) {
                            i9 -= this.f6977s[1];
                            this.f6978t += this.f6976r[1];
                        }
                        int i10 = i9;
                        this.f6964f = y7 - this.f6976r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z8 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        boolean z9 = K(0, i10, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !d(0);
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.f6977s;
                        iArr[1] = 0;
                        c(0, scrollY2, 0, i10 - scrollY2, this.f6976r, 0, iArr);
                        int i11 = this.f6964f;
                        int i12 = this.f6976r[1];
                        this.f6964f = i11 - i12;
                        this.f6978t += i12;
                        if (z8) {
                            int i13 = i10 - this.f6977s[1];
                            int i14 = scrollY + i13;
                            if (i14 < 0) {
                                i.j(this.f6962d, (-i13) / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.f6963e.isFinished()) {
                                    this.f6963e.onRelease();
                                }
                            } else if (i14 > scrollRange) {
                                i.j(this.f6963e, i13 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                if (!this.f6962d.isFinished()) {
                                    this.f6962d.onRelease();
                                }
                            }
                            if (this.f6962d.isFinished() && this.f6963e.isFinished()) {
                                z7 = z9;
                            } else {
                                n2.n1(this);
                            }
                        } else {
                            z7 = z9;
                        }
                        if (z7) {
                            this.f6969k.clear();
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f6968j && getChildCount() > 0 && this.f6961c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    n2.n1(this);
                }
                this.f6975q = -1;
                u();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f6964f = (int) motionEvent.getY(actionIndex);
                this.f6975q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                J(motionEvent);
                this.f6964f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f6975q));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f6968j && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f6961c.isFinished()) {
                i();
            }
            this.f6964f = (int) motionEvent.getY();
            this.f6975q = motionEvent.getPointerId(0);
            g(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f6969k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    @Override // androidx.core.view.v1
    public boolean p(@m0 View view, @m0 View view2, int i7, int i8) {
        return (i7 & 2) != 0;
    }

    @Override // androidx.core.view.v1
    public void q(@m0 View view, @m0 View view2, int i7, int i8) {
        this.f6981w.c(view, view2, i7, i8);
        g(2, i8);
    }

    @Override // androidx.core.view.v1
    public void r(@m0 View view, int i7) {
        this.f6981w.e(view, i7);
        h(i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f6965g) {
            this.f6967i = view2;
        } else {
            Q(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@m0 View view, Rect rect, boolean z7) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return R(rect, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        if (z7) {
            M();
        }
        super.requestDisallowInterceptTouchEvent(z7);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f6965g = true;
        super.requestLayout();
    }

    @Override // androidx.core.view.v1
    public void s(@m0 View view, int i7, int i8, @m0 int[] iArr, int i9) {
        b(i7, i8, iArr, null, i9);
    }

    @Override // android.view.View
    public void scrollTo(int i7, int i8) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iM = m(i7, width, width2);
            int iM2 = m(i8, height, height2);
            if (iM == getScrollX() && iM2 == getScrollY()) {
                return;
            }
            super.scrollTo(iM, iM2);
        }
    }

    public void setFillViewport(boolean z7) {
        if (z7 != this.f6970l) {
            this.f6970l = z7;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.view.t1
    public void setNestedScrollingEnabled(boolean z7) {
        this.f6982x.p(z7);
    }

    public void setOnScrollChangeListener(@o0 c cVar) {
        this.f6984z = cVar;
    }

    public void setSmoothScrollingEnabled(boolean z7) {
        this.f6971m = z7;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean startNestedScroll(int i7) {
        return g(i7, 0);
    }

    @Override // android.view.View, androidx.core.view.t1
    public void stopNestedScroll() {
        h(0);
    }

    public boolean v(@m0 KeyEvent keyEvent) {
        this.f6960b.setEmpty();
        if (!l()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? j(33) : y(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? j(130) : y(130);
        }
        if (keyCode != 62) {
            return false;
        }
        L(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    public void x(int i7) {
        if (getChildCount() > 0) {
            this.f6961c.fling(getScrollX(), getScrollY(), 0, i7, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            O(true);
        }
    }

    public boolean y(int i7) {
        int childCount;
        boolean z7 = i7 == 130;
        int height = getHeight();
        Rect rect = this.f6960b;
        rect.top = 0;
        rect.bottom = height;
        if (z7 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f6960b.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f6960b;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f6960b;
        return P(i7, rect3.top, rect3.bottom);
    }

    public NestedScrollView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.R.attr.nestedScrollViewStyle);
    }

    public NestedScrollView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f6960b = new Rect();
        this.f6965g = true;
        this.f6966h = false;
        this.f6967i = null;
        this.f6968j = false;
        this.f6971m = true;
        this.f6975q = -1;
        this.f6976r = new int[2];
        this.f6977s = new int[2];
        this.f6962d = i.a(context, attributeSet);
        this.f6963e = i.a(context, attributeSet);
        B();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, G, i7, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f6981w = new y1(this);
        this.f6982x = new u1(this);
        setNestedScrollingEnabled(true);
        n2.B1(this, F);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i7) {
        if (getChildCount() <= 0) {
            super.addView(view, i7);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i7, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
