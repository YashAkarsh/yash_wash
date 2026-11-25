package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.view.n2;
import androidx.core.view.t1;
import androidx.core.view.u1;
import androidx.core.view.x1;
import androidx.core.view.y1;
import androidx.core.widget.q;
import c.g1;
import c.l;
import c.m0;
import c.n;
import c.o0;
import c.r0;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements x1, t1 {
    private static final int A0 = -1;
    private static final float B0 = 0.5f;
    private static final float C0 = 0.8f;
    private static final int D0 = 150;
    private static final int E0 = 300;
    private static final int F0 = 200;
    private static final int G0 = 200;
    private static final int H0 = -328966;
    private static final int I0 = 64;
    private static final int[] J0 = {R.attr.enabled};
    public static final int O = 0;
    public static final int P = 1;
    public static final int Q = -1;

    @g1
    static final int R = 40;

    @g1
    static final int S = 56;
    private static final String T = "SwipeRefreshLayout";
    private static final int U = 255;
    private static final int V = 76;
    private static final float W = 2.0f;
    int A;
    androidx.swiperefreshlayout.widget.b B;
    private Animation C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    boolean H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f9817J;
    private i K;
    private Animation.AnimationListener L;
    private final Animation M;
    private final Animation N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f9818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    j f9819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f9820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f9822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f9823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final y1 f9824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final u1 f9825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f9826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f9827j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f9828k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f9830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f9831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f9832o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f9833p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9834q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f9835r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f9836s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final DecelerateInterpolator f9837t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    androidx.swiperefreshlayout.widget.a f9838u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f9839v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected int f9840w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f9841x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected int f9842y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f9843z;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f9820c) {
                swipeRefreshLayout.x();
                return;
            }
            swipeRefreshLayout.B.setAlpha(255);
            SwipeRefreshLayout.this.B.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.H && (jVar = swipeRefreshLayout2.f9819b) != null) {
                jVar.g();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.f9830m = swipeRefreshLayout3.f9838u.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f8, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f8);
        }
    }

    class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f8, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f8);
        }
    }

    class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9848b;

        d(int i7, int i8) {
            this.f9847a = i7;
            this.f9848b = i8;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f8, Transformation transformation) {
            androidx.swiperefreshlayout.widget.b bVar = SwipeRefreshLayout.this.B;
            int i7 = this.f9847a;
            bVar.setAlpha((int) (i7 + ((this.f9848b - i7) * f8)));
        }
    }

    class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f9835r) {
                return;
            }
            swipeRefreshLayout.D(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f8, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.f9817J ? swipeRefreshLayout.f9843z - Math.abs(swipeRefreshLayout.f9842y) : swipeRefreshLayout.f9843z;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i7 = swipeRefreshLayout2.f9840w;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i7 + ((int) ((iAbs - i7) * f8))) - swipeRefreshLayout2.f9838u.getTop());
            SwipeRefreshLayout.this.B.v(1.0f - f8);
        }
    }

    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f8, Transformation transformation) {
            SwipeRefreshLayout.this.v(f8);
        }
    }

    class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f8, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f9 = swipeRefreshLayout.f9841x;
            swipeRefreshLayout.setAnimationProgress(f9 + ((-f9) * f8));
            SwipeRefreshLayout.this.v(f8);
        }
    }

    public interface i {
        boolean a(@m0 SwipeRefreshLayout swipeRefreshLayout, @o0 View view);
    }

    public interface j {
        void g();
    }

    public SwipeRefreshLayout(@m0 Context context) {
        this(context, null);
    }

    private void A(float f8) {
        float f9 = this.f9832o;
        float f10 = f8 - f9;
        int i7 = this.f9821d;
        if (f10 <= i7 || this.f9833p) {
            return;
        }
        this.f9831n = f9 + i7;
        this.f9833p = true;
        this.B.setAlpha(76);
    }

    private void B() {
        this.F = z(this.B.getAlpha(), 255);
    }

    private void C() {
        this.E = z(this.B.getAlpha(), 76);
    }

    private void E(int i7, Animation.AnimationListener animationListener) {
        this.f9840w = i7;
        this.f9841x = this.f9838u.getScaleX();
        h hVar = new h();
        this.G = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f9838u.b(animationListener);
        }
        this.f9838u.clearAnimation();
        this.f9838u.startAnimation(this.G);
    }

    private void F(Animation.AnimationListener animationListener) {
        this.f9838u.setVisibility(0);
        this.B.setAlpha(255);
        b bVar = new b();
        this.C = bVar;
        bVar.setDuration(this.f9829l);
        if (animationListener != null) {
            this.f9838u.b(animationListener);
        }
        this.f9838u.clearAnimation();
        this.f9838u.startAnimation(this.C);
    }

    private void i(int i7, Animation.AnimationListener animationListener) {
        this.f9840w = i7;
        this.M.reset();
        this.M.setDuration(200L);
        this.M.setInterpolator(this.f9837t);
        if (animationListener != null) {
            this.f9838u.b(animationListener);
        }
        this.f9838u.clearAnimation();
        this.f9838u.startAnimation(this.M);
    }

    private void j(int i7, Animation.AnimationListener animationListener) {
        if (this.f9835r) {
            E(i7, animationListener);
            return;
        }
        this.f9840w = i7;
        this.N.reset();
        this.N.setDuration(200L);
        this.N.setInterpolator(this.f9837t);
        if (animationListener != null) {
            this.f9838u.b(animationListener);
        }
        this.f9838u.clearAnimation();
        this.f9838u.startAnimation(this.N);
    }

    private void l() {
        this.f9838u = new androidx.swiperefreshlayout.widget.a(getContext(), H0);
        androidx.swiperefreshlayout.widget.b bVar = new androidx.swiperefreshlayout.widget.b(getContext());
        this.B = bVar;
        bVar.F(1);
        this.f9838u.setImageDrawable(this.B);
        this.f9838u.setVisibility(8);
        addView(this.f9838u);
    }

    private void m() {
        if (this.f9818a == null) {
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (!childAt.equals(this.f9838u)) {
                    this.f9818a = childAt;
                    return;
                }
            }
        }
    }

    private void n(float f8) {
        if (f8 > this.f9822e) {
            y(true, true);
            return;
        }
        this.f9820c = false;
        this.B.C(0.0f, 0.0f);
        j(this.f9830m, !this.f9835r ? new e() : null);
        this.B.u(false);
    }

    private boolean o(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void setColorViewAlpha(int i7) {
        this.f9838u.getBackground().setAlpha(i7);
        this.B.setAlpha(i7);
    }

    private void u(float f8) {
        this.B.u(true);
        float fMin = Math.min(1.0f, Math.abs(f8 / this.f9822e));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f8) - this.f9822e;
        int i7 = this.A;
        if (i7 <= 0) {
            i7 = this.f9817J ? this.f9843z - this.f9842y : this.f9843z;
        }
        float f9 = i7;
        double dMax = Math.max(0.0f, Math.min(fAbs, f9 * W) / f9) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * W;
        int i8 = this.f9842y + ((int) ((f9 * fMin) + (f9 * fPow * W)));
        if (this.f9838u.getVisibility() != 0) {
            this.f9838u.setVisibility(0);
        }
        if (!this.f9835r) {
            this.f9838u.setScaleX(1.0f);
            this.f9838u.setScaleY(1.0f);
        }
        if (this.f9835r) {
            setAnimationProgress(Math.min(1.0f, f8 / this.f9822e));
        }
        if (f8 < this.f9822e) {
            if (this.B.getAlpha() > 76 && !o(this.E)) {
                C();
            }
        } else if (this.B.getAlpha() < 255 && !o(this.F)) {
            B();
        }
        this.B.C(0.0f, Math.min(C0, fMax * C0));
        this.B.v(Math.min(1.0f, fMax));
        this.B.z((((fMax * 0.4f) - 0.25f) + (fPow * W)) * 0.5f);
        setTargetOffsetTopAndBottom(i8 - this.f9830m);
    }

    private void w(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f9834q) {
            this.f9834q = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void y(boolean z7, boolean z8) {
        if (this.f9820c != z7) {
            this.H = z8;
            m();
            this.f9820c = z7;
            if (z7) {
                i(this.f9830m, this.L);
            } else {
                D(this.L);
            }
        }
    }

    private Animation z(int i7, int i8) {
        d dVar = new d(i7, i8);
        dVar.setDuration(300L);
        this.f9838u.b(null);
        this.f9838u.clearAnimation();
        this.f9838u.startAnimation(dVar);
        return dVar;
    }

    void D(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.D = cVar;
        cVar.setDuration(150L);
        this.f9838u.b(animationListener);
        this.f9838u.clearAnimation();
        this.f9838u.startAnimation(this.D);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedFling(float f8, float f9, boolean z7) {
        return this.f9825h.a(f8, f9, z7);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedPreFling(float f8, float f9) {
        return this.f9825h.b(f8, f9);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedPreScroll(int i7, int i8, int[] iArr, int[] iArr2) {
        return this.f9825h.c(i7, i8, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedScroll(int i7, int i8, int i9, int i10, int[] iArr) {
        return this.f9825h.f(i7, i8, i9, i10, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i7, int i8) {
        int i9 = this.f9839v;
        if (i9 < 0) {
            return i8;
        }
        if (i8 == i7 - 1) {
            return i9;
        }
        return i8 >= i9 ? i8 + 1 : i8;
    }

    @Override // android.view.ViewGroup, androidx.core.view.x1
    public int getNestedScrollAxes() {
        return this.f9824g.a();
    }

    public int getProgressCircleDiameter() {
        return this.I;
    }

    public int getProgressViewEndOffset() {
        return this.f9843z;
    }

    public int getProgressViewStartOffset() {
        return this.f9842y;
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean hasNestedScrollingParent() {
        return this.f9825h.k();
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean isNestedScrollingEnabled() {
        return this.f9825h.m();
    }

    public boolean k() {
        i iVar = this.K;
        if (iVar != null) {
            return iVar.a(this, this.f9818a);
        }
        View view = this.f9818a;
        return view instanceof ListView ? q.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f9836s && actionMasked == 0) {
            this.f9836s = false;
        }
        if (!isEnabled() || this.f9836s || k() || this.f9820c || this.f9828k) {
            return false;
        }
        if (actionMasked == 0) {
            setTargetOffsetTopAndBottom(this.f9842y - this.f9838u.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f9834q = pointerId;
            this.f9833p = false;
            int iFindPointerIndex = motionEvent.findPointerIndex(pointerId);
            if (iFindPointerIndex < 0) {
                return false;
            }
            this.f9832o = motionEvent.getY(iFindPointerIndex);
        } else if (actionMasked == 1) {
            this.f9833p = false;
            this.f9834q = -1;
        } else if (actionMasked == 2) {
            int i7 = this.f9834q;
            if (i7 == -1) {
                Log.e(T, "Got ACTION_MOVE event but don't have an active pointer id.");
                return false;
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(i7);
            if (iFindPointerIndex2 < 0) {
                return false;
            }
            A(motionEvent.getY(iFindPointerIndex2));
        } else if (actionMasked == 3) {
            this.f9833p = false;
            this.f9834q = -1;
        } else if (actionMasked == 6) {
            w(motionEvent);
        }
        return this.f9833p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f9818a == null) {
            m();
        }
        View view = this.f9818a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f9838u.getMeasuredWidth();
        int measuredHeight2 = this.f9838u.getMeasuredHeight();
        int i11 = measuredWidth / 2;
        int i12 = measuredWidth2 / 2;
        int i13 = this.f9830m;
        this.f9838u.layout(i11 - i12, i13, i11 + i12, measuredHeight2 + i13);
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (this.f9818a == null) {
            m();
        }
        View view = this.f9818a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f9838u.measure(View.MeasureSpec.makeMeasureSpec(this.I, 1073741824), View.MeasureSpec.makeMeasureSpec(this.I, 1073741824));
        this.f9839v = -1;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            if (getChildAt(i9) == this.f9838u) {
                this.f9839v = i9;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedFling(View view, float f8, float f9, boolean z7) {
        return dispatchNestedFling(f8, f9, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedPreFling(View view, float f8, float f9) {
        return dispatchNestedPreFling(f8, f9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedPreScroll(View view, int i7, int i8, int[] iArr) {
        if (i8 > 0) {
            float f8 = this.f9823f;
            if (f8 > 0.0f) {
                float f9 = i8;
                if (f9 > f8) {
                    iArr[1] = i8 - ((int) f8);
                    this.f9823f = 0.0f;
                } else {
                    this.f9823f = f8 - f9;
                    iArr[1] = i8;
                }
                u(this.f9823f);
            }
        }
        if (this.f9817J && i8 > 0 && this.f9823f == 0.0f && Math.abs(i8 - iArr[1]) > 0) {
            this.f9838u.setVisibility(8);
        }
        int[] iArr2 = this.f9826i;
        if (dispatchNestedPreScroll(i7 - iArr[0], i8 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedScroll(View view, int i7, int i8, int i9, int i10) {
        dispatchNestedScroll(i7, i8, i9, i10, this.f9827j);
        int i11 = i10 + this.f9827j[1];
        if (i11 >= 0 || k()) {
            return;
        }
        float fAbs = this.f9823f + Math.abs(i11);
        this.f9823f = fAbs;
        u(fAbs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onNestedScrollAccepted(View view, View view2, int i7) {
        this.f9824g.b(view, view2, i7);
        startNestedScroll(i7 & 2);
        this.f9823f = 0.0f;
        this.f9828k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onStartNestedScroll(View view, View view2, int i7) {
        return (!isEnabled() || this.f9836s || this.f9820c || (i7 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public void onStopNestedScroll(View view) {
        this.f9824g.d(view);
        this.f9828k = false;
        float f8 = this.f9823f;
        if (f8 > 0.0f) {
            n(f8);
            this.f9823f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f9836s && actionMasked == 0) {
            this.f9836s = false;
        }
        if (!isEnabled() || this.f9836s || k() || this.f9820c || this.f9828k) {
            return false;
        }
        if (actionMasked == 0) {
            this.f9834q = motionEvent.getPointerId(0);
            this.f9833p = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f9834q);
                if (iFindPointerIndex < 0) {
                    Log.e(T, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f9833p) {
                    float y7 = (motionEvent.getY(iFindPointerIndex) - this.f9831n) * 0.5f;
                    this.f9833p = false;
                    n(y7);
                }
                this.f9834q = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f9834q);
                if (iFindPointerIndex2 < 0) {
                    Log.e(T, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y8 = motionEvent.getY(iFindPointerIndex2);
                A(y8);
                if (this.f9833p) {
                    float f8 = (y8 - this.f9831n) * 0.5f;
                    if (f8 <= 0.0f) {
                        return false;
                    }
                    u(f8);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(T, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.f9834q = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    w(motionEvent);
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        View view = this.f9818a;
        if (view == null || n2.W0(view)) {
            super.requestDisallowInterceptTouchEvent(z7);
        }
    }

    void setAnimationProgress(float f8) {
        this.f9838u.setScaleX(f8);
        this.f9838u.setScaleY(f8);
    }

    @Deprecated
    public void setColorScheme(@n int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@l int... iArr) {
        m();
        this.B.y(iArr);
    }

    public void setColorSchemeResources(@n int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i7 = 0; i7 < iArr.length; i7++) {
            iArr2[i7] = androidx.core.content.d.f(context, iArr[i7]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i7) {
        this.f9822e = i7;
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        if (z7) {
            return;
        }
        x();
    }

    @Override // android.view.View, androidx.core.view.t1
    public void setNestedScrollingEnabled(boolean z7) {
        this.f9825h.p(z7);
    }

    public void setOnChildScrollUpCallback(@o0 i iVar) {
        this.K = iVar;
    }

    public void setOnRefreshListener(@o0 j jVar) {
        this.f9819b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i7) {
        setProgressBackgroundColorSchemeResource(i7);
    }

    public void setProgressBackgroundColorSchemeColor(@l int i7) {
        this.f9838u.setBackgroundColor(i7);
    }

    public void setProgressBackgroundColorSchemeResource(@n int i7) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.d.f(getContext(), i7));
    }

    public void setProgressViewEndTarget(boolean z7, int i7) {
        this.f9843z = i7;
        this.f9835r = z7;
        this.f9838u.invalidate();
    }

    public void setProgressViewOffset(boolean z7, int i7, int i8) {
        this.f9835r = z7;
        this.f9842y = i7;
        this.f9843z = i8;
        this.f9817J = true;
        x();
        this.f9820c = false;
    }

    public void setRefreshing(boolean z7) {
        if (!z7 || this.f9820c == z7) {
            y(z7, false);
            return;
        }
        this.f9820c = z7;
        setTargetOffsetTopAndBottom((!this.f9817J ? this.f9843z + this.f9842y : this.f9843z) - this.f9830m);
        this.H = false;
        F(this.L);
    }

    public void setSize(int i7) {
        if (i7 == 0 || i7 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i7 == 0) {
                this.I = (int) (displayMetrics.density * 56.0f);
            } else {
                this.I = (int) (displayMetrics.density * 40.0f);
            }
            this.f9838u.setImageDrawable(null);
            this.B.F(i7);
            this.f9838u.setImageDrawable(this.B);
        }
    }

    public void setSlingshotDistance(@r0 int i7) {
        this.A = i7;
    }

    void setTargetOffsetTopAndBottom(int i7) {
        this.f9838u.bringToFront();
        n2.f1(this.f9838u, i7);
        this.f9830m = this.f9838u.getTop();
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean startNestedScroll(int i7) {
        return this.f9825h.r(i7);
    }

    @Override // android.view.View, androidx.core.view.t1
    public void stopNestedScroll() {
        this.f9825h.t();
    }

    public boolean t() {
        return this.f9820c;
    }

    void v(float f8) {
        int i7 = this.f9840w;
        setTargetOffsetTopAndBottom((i7 + ((int) ((this.f9842y - i7) * f8))) - this.f9838u.getTop());
    }

    void x() {
        this.f9838u.clearAnimation();
        this.B.stop();
        this.f9838u.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f9835r) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f9842y - this.f9830m);
        }
        this.f9830m = this.f9838u.getTop();
    }

    public SwipeRefreshLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9820c = false;
        this.f9822e = -1.0f;
        this.f9826i = new int[2];
        this.f9827j = new int[2];
        this.f9834q = -1;
        this.f9839v = -1;
        this.L = new a();
        this.M = new f();
        this.N = new g();
        this.f9821d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f9829l = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f9837t = new DecelerateInterpolator(W);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.I = (int) (displayMetrics.density * 40.0f);
        l();
        setChildrenDrawingOrderEnabled(true);
        int i7 = (int) (displayMetrics.density * 64.0f);
        this.f9843z = i7;
        this.f9822e = i7;
        this.f9824g = new y1(this);
        this.f9825h = new u1(this);
        setNestedScrollingEnabled(true);
        int i8 = -this.I;
        this.f9830m = i8;
        this.f9842y = i8;
        v(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, J0);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }
}
