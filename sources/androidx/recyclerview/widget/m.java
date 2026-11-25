package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.n2;
import androidx.recyclerview.R;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m extends RecyclerView.n implements RecyclerView.p {
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 4;
    public static final int H = 8;
    public static final int I = 16;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f9607J = 32;
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 2;
    public static final int O = 4;
    public static final int P = 8;
    private static final String Q = "ItemTouchHelper";
    private static final boolean R = false;
    private static final int S = -1;
    static final int T = 8;
    private static final int U = 255;
    static final int V = 65280;
    static final int W = 16711680;
    private static final int X = 1000;
    private g A;
    private Rect C;
    private long D;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f9611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f9612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f9613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f9614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f9615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f9616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f9617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f9618k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @m0
    f f9620m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f9622o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9624q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    RecyclerView f9625r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    VelocityTracker f9627t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List<RecyclerView.d0> f9628u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List<Integer> f9629v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    androidx.core.view.m0 f9633z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<View> f9608a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f9609b = new float[2];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    RecyclerView.d0 f9610c = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f9619l = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9621n = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    List<h> f9623p = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final Runnable f9626s = new a();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private RecyclerView.j f9630w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    View f9631x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f9632y = -1;
    private final RecyclerView.r B = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar = m.this;
            if (mVar.f9610c == null || !mVar.E()) {
                return;
            }
            m mVar2 = m.this;
            RecyclerView.d0 d0Var = mVar2.f9610c;
            if (d0Var != null) {
                mVar2.z(d0Var);
            }
            m mVar3 = m.this;
            mVar3.f9625r.removeCallbacks(mVar3.f9626s);
            n2.p1(m.this.f9625r, this);
        }
    }

    class b implements RecyclerView.r {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void a(@m0 RecyclerView recyclerView, @m0 MotionEvent motionEvent) {
            m.this.f9633z.b(motionEvent);
            VelocityTracker velocityTracker = m.this.f9627t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (m.this.f9619l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(m.this.f9619l);
            if (iFindPointerIndex >= 0) {
                m.this.o(actionMasked, motionEvent, iFindPointerIndex);
            }
            m mVar = m.this;
            RecyclerView.d0 d0Var = mVar.f9610c;
            if (d0Var == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (iFindPointerIndex >= 0) {
                        mVar.M(motionEvent, mVar.f9622o, iFindPointerIndex);
                        m.this.z(d0Var);
                        m mVar2 = m.this;
                        mVar2.f9625r.removeCallbacks(mVar2.f9626s);
                        m.this.f9626s.run();
                        m.this.f9625r.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    m mVar3 = m.this;
                    if (pointerId == mVar3.f9619l) {
                        mVar3.f9619l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        m mVar4 = m.this;
                        mVar4.M(motionEvent, mVar4.f9622o, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = mVar.f9627t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            m.this.F(null, 0);
            m.this.f9619l = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public boolean c(@m0 RecyclerView recyclerView, @m0 MotionEvent motionEvent) {
            int iFindPointerIndex;
            h hVarS;
            m.this.f9633z.b(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                m.this.f9619l = motionEvent.getPointerId(0);
                m.this.f9611d = motionEvent.getX();
                m.this.f9612e = motionEvent.getY();
                m.this.A();
                m mVar = m.this;
                if (mVar.f9610c == null && (hVarS = mVar.s(motionEvent)) != null) {
                    m mVar2 = m.this;
                    mVar2.f9611d -= hVarS.f9662j;
                    mVar2.f9612e -= hVarS.f9663k;
                    mVar2.r(hVarS.f9657e, true);
                    if (m.this.f9608a.remove(hVarS.f9657e.f9157a)) {
                        m mVar3 = m.this;
                        mVar3.f9620m.c(mVar3.f9625r, hVarS.f9657e);
                    }
                    m.this.F(hVarS.f9657e, hVarS.f9658f);
                    m mVar4 = m.this;
                    mVar4.M(motionEvent, mVar4.f9622o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                m mVar5 = m.this;
                mVar5.f9619l = -1;
                mVar5.F(null, 0);
            } else {
                int i7 = m.this.f9619l;
                if (i7 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i7)) >= 0) {
                    m.this.o(actionMasked, motionEvent, iFindPointerIndex);
                }
            }
            VelocityTracker velocityTracker = m.this.f9627t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return m.this.f9610c != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void e(boolean z7) {
            if (z7) {
                m.this.F(null, 0);
            }
        }
    }

    class c extends h {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ int f9636o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9637p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(RecyclerView.d0 d0Var, int i7, int i8, float f8, float f9, float f10, float f11, int i9, RecyclerView.d0 d0Var2) {
            super(d0Var, i7, i8, f8, f9, f10, f11);
            this.f9636o = i9;
            this.f9637p = d0Var2;
        }

        @Override // androidx.recyclerview.widget.m.h, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f9664l) {
                return;
            }
            if (this.f9636o <= 0) {
                m mVar = m.this;
                mVar.f9620m.c(mVar.f9625r, this.f9637p);
            } else {
                m.this.f9608a.add(this.f9637p.f9157a);
                this.f9661i = true;
                int i7 = this.f9636o;
                if (i7 > 0) {
                    m.this.B(this, i7);
                }
            }
            m mVar2 = m.this;
            View view = mVar2.f9631x;
            View view2 = this.f9637p.f9157a;
            if (view == view2) {
                mVar2.D(view2);
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f9639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9640b;

        d(h hVar, int i7) {
            this.f9639a = hVar;
            this.f9640b = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = m.this.f9625r;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            h hVar = this.f9639a;
            if (hVar.f9664l || hVar.f9657e.j() == -1) {
                return;
            }
            RecyclerView.l itemAnimator = m.this.f9625r.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.r(null)) && !m.this.x()) {
                m.this.f9620m.D(this.f9639a.f9657e, this.f9640b);
            } else {
                m.this.f9625r.post(this);
            }
        }
    }

    class e implements RecyclerView.j {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public int a(int i7, int i8) {
            m mVar = m.this;
            View view = mVar.f9631x;
            if (view == null) {
                return i8;
            }
            int iIndexOfChild = mVar.f9632y;
            if (iIndexOfChild == -1) {
                iIndexOfChild = mVar.f9625r.indexOfChild(view);
                m.this.f9632y = iIndexOfChild;
            }
            if (i8 == i7 - 1) {
                return iIndexOfChild;
            }
            return i8 < iIndexOfChild ? i8 : i8 + 1;
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f9643b = 200;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f9644c = 250;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f9645d = 3158064;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f9646e = 789516;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Interpolator f9647f = new a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final Interpolator f9648g = new b();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final long f9649h = 2000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9650a = -1;

        static class a implements Interpolator {
            a() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f8) {
                return f8 * f8 * f8 * f8 * f8;
            }
        }

        static class b implements Interpolator {
            b() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f8) {
                float f9 = f8 - 1.0f;
                return (f9 * f9 * f9 * f9 * f9) + 1.0f;
            }
        }

        public static int e(int i7, int i8) {
            int i9;
            int i10 = i7 & f9646e;
            if (i10 == 0) {
                return i7;
            }
            int i11 = i7 & (~i10);
            if (i8 == 0) {
                i9 = i10 << 2;
            } else {
                int i12 = i10 << 1;
                i11 |= (-789517) & i12;
                i9 = (i12 & f9646e) << 2;
            }
            return i11 | i9;
        }

        @m0
        public static n i() {
            return o.f9670a;
        }

        private int j(RecyclerView recyclerView) {
            if (this.f9650a == -1) {
                this.f9650a = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f9650a;
        }

        public static int u(int i7, int i8) {
            return i8 << (i7 * 8);
        }

        public static int v(int i7, int i8) {
            return u(2, i7) | u(1, i8) | u(0, i8 | i7);
        }

        public abstract boolean A(@m0 RecyclerView recyclerView, @m0 RecyclerView.d0 d0Var, @m0 RecyclerView.d0 d0Var2);

        /* JADX WARN: Multi-variable type inference failed */
        public void B(@m0 RecyclerView recyclerView, @m0 RecyclerView.d0 d0Var, int i7, @m0 RecyclerView.d0 d0Var2, int i8, int i9, int i10) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof j) {
                ((j) layoutManager).b(d0Var.f9157a, d0Var2.f9157a, i9, i10);
                return;
            }
            if (layoutManager.n()) {
                if (layoutManager.Y(d0Var2.f9157a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.C1(i8);
                }
                if (layoutManager.b0(d0Var2.f9157a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.C1(i8);
                }
            }
            if (layoutManager.o()) {
                if (layoutManager.c0(d0Var2.f9157a) <= recyclerView.getPaddingTop()) {
                    recyclerView.C1(i8);
                }
                if (layoutManager.W(d0Var2.f9157a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.C1(i8);
                }
            }
        }

        public void C(@o0 RecyclerView.d0 d0Var, int i7) {
            if (d0Var != null) {
                o.f9670a.b(d0Var.f9157a);
            }
        }

        public abstract void D(@m0 RecyclerView.d0 d0Var, int i7);

        public boolean a(@m0 RecyclerView recyclerView, @m0 RecyclerView.d0 d0Var, @m0 RecyclerView.d0 d0Var2) {
            return true;
        }

        public RecyclerView.d0 b(@m0 RecyclerView.d0 d0Var, @m0 List<RecyclerView.d0> list, int i7, int i8) {
            int bottom;
            int iAbs;
            int top;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int iAbs4;
            int width = i7 + d0Var.f9157a.getWidth();
            int height = i8 + d0Var.f9157a.getHeight();
            int left2 = i7 - d0Var.f9157a.getLeft();
            int top2 = i8 - d0Var.f9157a.getTop();
            int size = list.size();
            RecyclerView.d0 d0Var2 = null;
            int i9 = -1;
            for (int i10 = 0; i10 < size; i10++) {
                RecyclerView.d0 d0Var3 = list.get(i10);
                if (left2 > 0 && (right = d0Var3.f9157a.getRight() - width) < 0 && d0Var3.f9157a.getRight() > d0Var.f9157a.getRight() && (iAbs4 = Math.abs(right)) > i9) {
                    d0Var2 = d0Var3;
                    i9 = iAbs4;
                }
                if (left2 < 0 && (left = d0Var3.f9157a.getLeft() - i7) > 0 && d0Var3.f9157a.getLeft() < d0Var.f9157a.getLeft() && (iAbs3 = Math.abs(left)) > i9) {
                    d0Var2 = d0Var3;
                    i9 = iAbs3;
                }
                if (top2 < 0 && (top = d0Var3.f9157a.getTop() - i8) > 0 && d0Var3.f9157a.getTop() < d0Var.f9157a.getTop() && (iAbs2 = Math.abs(top)) > i9) {
                    d0Var2 = d0Var3;
                    i9 = iAbs2;
                }
                if (top2 > 0 && (bottom = d0Var3.f9157a.getBottom() - height) < 0 && d0Var3.f9157a.getBottom() > d0Var.f9157a.getBottom() && (iAbs = Math.abs(bottom)) > i9) {
                    d0Var2 = d0Var3;
                    i9 = iAbs;
                }
            }
            return d0Var2;
        }

        public void c(@m0 RecyclerView recyclerView, @m0 RecyclerView.d0 d0Var) {
            o.f9670a.a(d0Var.f9157a);
        }

        public int d(int i7, int i8) {
            int i9;
            int i10 = i7 & f9645d;
            if (i10 == 0) {
                return i7;
            }
            int i11 = i7 & (~i10);
            if (i8 == 0) {
                i9 = i10 >> 2;
            } else {
                int i12 = i10 >> 1;
                i11 |= (-3158065) & i12;
                i9 = (i12 & f9645d) >> 2;
            }
            return i11 | i9;
        }

        final int f(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return d(l(recyclerView, d0Var), n2.Z(recyclerView));
        }

        public long g(@m0 RecyclerView recyclerView, int i7, float f8, float f9) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i7 == 8 ? 200L : 250L;
            }
            return i7 == 8 ? itemAnimator.o() : itemAnimator.p();
        }

        public int h() {
            return 0;
        }

        public float k(@m0 RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        public abstract int l(@m0 RecyclerView recyclerView, @m0 RecyclerView.d0 d0Var);

        public float m(float f8) {
            return f8;
        }

        public float n(@m0 RecyclerView.d0 d0Var) {
            return 0.5f;
        }

        public float o(float f8) {
            return f8;
        }

        boolean p(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (f(recyclerView, d0Var) & m.W) != 0;
        }

        boolean q(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (f(recyclerView, d0Var) & 65280) != 0;
        }

        public int r(@m0 RecyclerView recyclerView, int i7, int i8, int i9, long j7) {
            int iSignum = (int) (((int) (((int) Math.signum(i8)) * j(recyclerView) * f9648g.getInterpolation(Math.min(1.0f, (Math.abs(i8) * 1.0f) / i7)))) * f9647f.getInterpolation(j7 <= 2000 ? j7 / 2000.0f : 1.0f));
            if (iSignum == 0) {
                return i8 > 0 ? 1 : -1;
            }
            return iSignum;
        }

        public boolean s() {
            return true;
        }

        public boolean t() {
            return true;
        }

        public void w(@m0 Canvas canvas, @m0 RecyclerView recyclerView, @m0 RecyclerView.d0 d0Var, float f8, float f9, int i7, boolean z7) {
            o.f9670a.d(canvas, recyclerView, d0Var.f9157a, f8, f9, i7, z7);
        }

        public void x(@m0 Canvas canvas, @m0 RecyclerView recyclerView, RecyclerView.d0 d0Var, float f8, float f9, int i7, boolean z7) {
            o.f9670a.c(canvas, recyclerView, d0Var.f9157a, f8, f9, i7, z7);
        }

        void y(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<h> list, int i7, float f8, float f9) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                h hVar = list.get(i8);
                hVar.e();
                int iSave = canvas.save();
                w(canvas, recyclerView, hVar.f9657e, hVar.f9662j, hVar.f9663k, hVar.f9658f, false);
                canvas.restoreToCount(iSave);
            }
            if (d0Var != null) {
                int iSave2 = canvas.save();
                w(canvas, recyclerView, d0Var, f8, f9, i7, true);
                canvas.restoreToCount(iSave2);
            }
        }

        void z(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<h> list, int i7, float f8, float f9) {
            int size = list.size();
            boolean z7 = false;
            for (int i8 = 0; i8 < size; i8++) {
                h hVar = list.get(i8);
                int iSave = canvas.save();
                x(canvas, recyclerView, hVar.f9657e, hVar.f9662j, hVar.f9663k, hVar.f9658f, false);
                canvas.restoreToCount(iSave);
            }
            if (d0Var != null) {
                int iSave2 = canvas.save();
                x(canvas, recyclerView, d0Var, f8, f9, i7, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i9 = size - 1; i9 >= 0; i9--) {
                h hVar2 = list.get(i9);
                boolean z8 = hVar2.f9665m;
                if (z8 && !hVar2.f9661i) {
                    list.remove(i9);
                } else if (!z8) {
                    z7 = true;
                }
            }
            if (z7) {
                recyclerView.invalidate();
            }
        }
    }

    private class g extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9651a = true;

        g() {
        }

        void a() {
            this.f9651a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewT;
            RecyclerView.d0 d0VarS0;
            if (!this.f9651a || (viewT = m.this.t(motionEvent)) == null || (d0VarS0 = m.this.f9625r.s0(viewT)) == null) {
                return;
            }
            m mVar = m.this;
            if (mVar.f9620m.p(mVar.f9625r, d0VarS0)) {
                int pointerId = motionEvent.getPointerId(0);
                int i7 = m.this.f9619l;
                if (pointerId == i7) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i7);
                    float x7 = motionEvent.getX(iFindPointerIndex);
                    float y7 = motionEvent.getY(iFindPointerIndex);
                    m mVar2 = m.this;
                    mVar2.f9611d = x7;
                    mVar2.f9612e = y7;
                    mVar2.f9616i = 0.0f;
                    mVar2.f9615h = 0.0f;
                    if (mVar2.f9620m.t()) {
                        m.this.F(d0VarS0, 2);
                    }
                }
            }
        }
    }

    private static class h implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f9653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f9654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f9655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f9656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final RecyclerView.d0 f9657e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f9658f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ValueAnimator f9659g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f9660h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f9661i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f9662j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f9663k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f9664l = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f9665m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private float f9666n;

        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        h(RecyclerView.d0 d0Var, int i7, int i8, float f8, float f9, float f10, float f11) {
            this.f9658f = i8;
            this.f9660h = i7;
            this.f9657e = d0Var;
            this.f9653a = f8;
            this.f9654b = f9;
            this.f9655c = f10;
            this.f9656d = f11;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f9659g = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new a());
            valueAnimatorOfFloat.setTarget(d0Var.f9157a);
            valueAnimatorOfFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f9659g.cancel();
        }

        public void b(long j7) {
            this.f9659g.setDuration(j7);
        }

        public void c(float f8) {
            this.f9666n = f8;
        }

        public void d() {
            this.f9657e.H(false);
            this.f9659g.start();
        }

        public void e() {
            float f8 = this.f9653a;
            float f9 = this.f9655c;
            if (f8 == f9) {
                this.f9662j = this.f9657e.f9157a.getTranslationX();
            } else {
                this.f9662j = f8 + (this.f9666n * (f9 - f8));
            }
            float f10 = this.f9654b;
            float f11 = this.f9656d;
            if (f10 == f11) {
                this.f9663k = this.f9657e.f9157a.getTranslationY();
            } else {
                this.f9663k = f10 + (this.f9666n * (f11 - f10));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f9665m) {
                this.f9657e.H(true);
            }
            this.f9665m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static abstract class i extends f {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f9668i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f9669j;

        public i(int i7, int i8) {
            this.f9668i = i8;
            this.f9669j = i7;
        }

        public int E(@m0 RecyclerView recyclerView, @m0 RecyclerView.d0 d0Var) {
            return this.f9669j;
        }

        public int F(@m0 RecyclerView recyclerView, @m0 RecyclerView.d0 d0Var) {
            return this.f9668i;
        }

        public void G(int i7) {
            this.f9669j = i7;
        }

        public void H(int i7) {
            this.f9668i = i7;
        }

        @Override // androidx.recyclerview.widget.m.f
        public int l(@m0 RecyclerView recyclerView, @m0 RecyclerView.d0 d0Var) {
            return f.v(E(recyclerView, d0Var), F(recyclerView, d0Var));
        }
    }

    public interface j {
        void b(@m0 View view, @m0 View view2, int i7, int i8);
    }

    public m(@m0 f fVar) {
        this.f9620m = fVar;
    }

    private void C() {
        VelocityTracker velocityTracker = this.f9627t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f9627t = null;
        }
    }

    private void G() {
        this.f9624q = ViewConfiguration.get(this.f9625r.getContext()).getScaledTouchSlop();
        this.f9625r.n(this);
        this.f9625r.q(this.B);
        this.f9625r.p(this);
        I();
    }

    private void I() {
        this.A = new g();
        this.f9633z = new androidx.core.view.m0(this.f9625r.getContext(), this.A);
    }

    private void K() {
        g gVar = this.A;
        if (gVar != null) {
            gVar.a();
            this.A = null;
        }
        if (this.f9633z != null) {
            this.f9633z = null;
        }
    }

    private int L(RecyclerView.d0 d0Var) {
        if (this.f9621n == 2) {
            return 0;
        }
        int iL = this.f9620m.l(this.f9625r, d0Var);
        int iD = (this.f9620m.d(iL, n2.Z(this.f9625r)) & 65280) >> 8;
        if (iD == 0) {
            return 0;
        }
        int i7 = (iL & 65280) >> 8;
        if (Math.abs(this.f9615h) > Math.abs(this.f9616i)) {
            int iN = n(d0Var, iD);
            if (iN > 0) {
                return (i7 & iN) == 0 ? f.e(iN, n2.Z(this.f9625r)) : iN;
            }
            int iP = p(d0Var, iD);
            if (iP > 0) {
                return iP;
            }
        } else {
            int iP2 = p(d0Var, iD);
            if (iP2 > 0) {
                return iP2;
            }
            int iN2 = n(d0Var, iD);
            if (iN2 > 0) {
                return (i7 & iN2) == 0 ? f.e(iN2, n2.Z(this.f9625r)) : iN2;
            }
        }
        return 0;
    }

    private void l() {
    }

    private int n(RecyclerView.d0 d0Var, int i7) {
        if ((i7 & 12) == 0) {
            return 0;
        }
        int i8 = this.f9615h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f9627t;
        if (velocityTracker != null && this.f9619l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f9620m.o(this.f9614g));
            float xVelocity = this.f9627t.getXVelocity(this.f9619l);
            float yVelocity = this.f9627t.getYVelocity(this.f9619l);
            int i9 = xVelocity <= 0.0f ? 4 : 8;
            float fAbs = Math.abs(xVelocity);
            if ((i9 & i7) != 0 && i8 == i9 && fAbs >= this.f9620m.m(this.f9613f) && fAbs > Math.abs(yVelocity)) {
                return i9;
            }
        }
        float width = this.f9625r.getWidth() * this.f9620m.n(d0Var);
        if ((i7 & i8) == 0 || Math.abs(this.f9615h) <= width) {
            return 0;
        }
        return i8;
    }

    private int p(RecyclerView.d0 d0Var, int i7) {
        if ((i7 & 3) == 0) {
            return 0;
        }
        int i8 = this.f9616i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f9627t;
        if (velocityTracker != null && this.f9619l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f9620m.o(this.f9614g));
            float xVelocity = this.f9627t.getXVelocity(this.f9619l);
            float yVelocity = this.f9627t.getYVelocity(this.f9619l);
            int i9 = yVelocity <= 0.0f ? 1 : 2;
            float fAbs = Math.abs(yVelocity);
            if ((i9 & i7) != 0 && i9 == i8 && fAbs >= this.f9620m.m(this.f9613f) && fAbs > Math.abs(xVelocity)) {
                return i9;
            }
        }
        float height = this.f9625r.getHeight() * this.f9620m.n(d0Var);
        if ((i7 & i8) == 0 || Math.abs(this.f9616i) <= height) {
            return 0;
        }
        return i8;
    }

    private void q() {
        this.f9625r.p1(this);
        this.f9625r.s1(this.B);
        this.f9625r.r1(this);
        for (int size = this.f9623p.size() - 1; size >= 0; size--) {
            this.f9620m.c(this.f9625r, this.f9623p.get(0).f9657e);
        }
        this.f9623p.clear();
        this.f9631x = null;
        this.f9632y = -1;
        C();
        K();
    }

    private List<RecyclerView.d0> u(RecyclerView.d0 d0Var) {
        RecyclerView.d0 d0Var2 = d0Var;
        List<RecyclerView.d0> list = this.f9628u;
        if (list == null) {
            this.f9628u = new ArrayList();
            this.f9629v = new ArrayList();
        } else {
            list.clear();
            this.f9629v.clear();
        }
        int iH = this.f9620m.h();
        int iRound = Math.round(this.f9617j + this.f9615h) - iH;
        int iRound2 = Math.round(this.f9618k + this.f9616i) - iH;
        int i7 = iH * 2;
        int width = d0Var2.f9157a.getWidth() + iRound + i7;
        int height = d0Var2.f9157a.getHeight() + iRound2 + i7;
        int i8 = (iRound + width) / 2;
        int i9 = (iRound2 + height) / 2;
        RecyclerView.o layoutManager = this.f9625r.getLayoutManager();
        int iQ = layoutManager.Q();
        int i10 = 0;
        while (i10 < iQ) {
            View viewP = layoutManager.P(i10);
            if (viewP != d0Var2.f9157a && viewP.getBottom() >= iRound2 && viewP.getTop() <= height && viewP.getRight() >= iRound && viewP.getLeft() <= width) {
                RecyclerView.d0 d0VarS0 = this.f9625r.s0(viewP);
                if (this.f9620m.a(this.f9625r, this.f9610c, d0VarS0)) {
                    int iAbs = Math.abs(i8 - ((viewP.getLeft() + viewP.getRight()) / 2));
                    int iAbs2 = Math.abs(i9 - ((viewP.getTop() + viewP.getBottom()) / 2));
                    int i11 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.f9628u.size();
                    int i12 = 0;
                    for (int i13 = 0; i13 < size && i11 > this.f9629v.get(i13).intValue(); i13++) {
                        i12++;
                    }
                    this.f9628u.add(i12, d0VarS0);
                    this.f9629v.add(i12, Integer.valueOf(i11));
                }
            }
            i10++;
            d0Var2 = d0Var;
        }
        return this.f9628u;
    }

    private RecyclerView.d0 v(MotionEvent motionEvent) {
        View viewT;
        RecyclerView.o layoutManager = this.f9625r.getLayoutManager();
        int i7 = this.f9619l;
        if (i7 == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i7);
        float x7 = motionEvent.getX(iFindPointerIndex) - this.f9611d;
        float y7 = motionEvent.getY(iFindPointerIndex) - this.f9612e;
        float fAbs = Math.abs(x7);
        float fAbs2 = Math.abs(y7);
        int i8 = this.f9624q;
        if (fAbs < i8 && fAbs2 < i8) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.n()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.o()) && (viewT = t(motionEvent)) != null) {
            return this.f9625r.s0(viewT);
        }
        return null;
    }

    private void w(float[] fArr) {
        if ((this.f9622o & 12) != 0) {
            fArr[0] = (this.f9617j + this.f9615h) - this.f9610c.f9157a.getLeft();
        } else {
            fArr[0] = this.f9610c.f9157a.getTranslationX();
        }
        if ((this.f9622o & 3) != 0) {
            fArr[1] = (this.f9618k + this.f9616i) - this.f9610c.f9157a.getTop();
        } else {
            fArr[1] = this.f9610c.f9157a.getTranslationY();
        }
    }

    private static boolean y(View view, float f8, float f9, float f10, float f11) {
        return f8 >= f10 && f8 <= f10 + ((float) view.getWidth()) && f9 >= f11 && f9 <= f11 + ((float) view.getHeight());
    }

    void A() {
        VelocityTracker velocityTracker = this.f9627t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f9627t = VelocityTracker.obtain();
    }

    void B(h hVar, int i7) {
        this.f9625r.post(new d(hVar, i7));
    }

    void D(View view) {
        if (view == this.f9631x) {
            this.f9631x = null;
            if (this.f9630w != null) {
                this.f9625r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007d  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c4  */
    boolean E() {
        int iR;
        int iR2;
        int i7;
        int width;
        if (this.f9610c == null) {
            this.D = Long.MIN_VALUE;
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j7 = this.D;
        long j8 = j7 == Long.MIN_VALUE ? 0L : jCurrentTimeMillis - j7;
        RecyclerView.o layoutManager = this.f9625r.getLayoutManager();
        if (this.C == null) {
            this.C = new Rect();
        }
        layoutManager.m(this.f9610c.f9157a, this.C);
        if (layoutManager.n()) {
            int i8 = (int) (this.f9617j + this.f9615h);
            int paddingLeft = (i8 - this.C.left) - this.f9625r.getPaddingLeft();
            float f8 = this.f9615h;
            if (f8 < 0.0f && paddingLeft < 0) {
                iR = paddingLeft;
            } else if (f8 <= 0.0f || (width = ((i8 + this.f9610c.f9157a.getWidth()) + this.C.right) - (this.f9625r.getWidth() - this.f9625r.getPaddingRight())) <= 0) {
                iR = 0;
            } else {
                iR = width;
            }
        } else {
            iR = 0;
        }
        if (layoutManager.o()) {
            int i9 = (int) (this.f9618k + this.f9616i);
            int paddingTop = (i9 - this.C.top) - this.f9625r.getPaddingTop();
            float f9 = this.f9616i;
            if (f9 < 0.0f && paddingTop < 0) {
                iR2 = paddingTop;
            } else if (f9 <= 0.0f || (iR2 = ((i9 + this.f9610c.f9157a.getHeight()) + this.C.bottom) - (this.f9625r.getHeight() - this.f9625r.getPaddingBottom())) <= 0) {
                iR2 = 0;
            }
        } else {
            iR2 = 0;
        }
        if (iR != 0) {
            iR = this.f9620m.r(this.f9625r, this.f9610c.f9157a.getWidth(), iR, this.f9625r.getWidth(), j8);
        }
        int i10 = iR;
        if (iR2 != 0) {
            i7 = i10;
            iR2 = this.f9620m.r(this.f9625r, this.f9610c.f9157a.getHeight(), iR2, this.f9625r.getHeight(), j8);
        } else {
            i7 = i10;
        }
        if (i7 == 0 && iR2 == 0) {
            this.D = Long.MIN_VALUE;
            return false;
        }
        if (this.D == Long.MIN_VALUE) {
            this.D = jCurrentTimeMillis;
        }
        this.f9625r.scrollBy(i7, iR2);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0121  */
    void F(@o0 RecyclerView.d0 d0Var, int i7) {
        boolean z7;
        boolean z8;
        float fSignum;
        float fSignum2;
        int i8;
        if (d0Var == this.f9610c && i7 == this.f9621n) {
            return;
        }
        this.D = Long.MIN_VALUE;
        int i9 = this.f9621n;
        r(d0Var, true);
        this.f9621n = i7;
        if (i7 == 2) {
            if (d0Var == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.f9631x = d0Var.f9157a;
            l();
        }
        int i10 = (1 << ((i7 * 8) + 8)) - 1;
        RecyclerView.d0 d0Var2 = this.f9610c;
        if (d0Var2 != null) {
            if (d0Var2.f9157a.getParent() != null) {
                int iL = i9 == 2 ? 0 : L(d0Var2);
                C();
                if (iL == 1 || iL == 2) {
                    fSignum = 0.0f;
                    fSignum2 = Math.signum(this.f9616i) * this.f9625r.getHeight();
                } else if (iL == 4 || iL == 8 || iL == 16 || iL == 32) {
                    fSignum2 = 0.0f;
                    fSignum = Math.signum(this.f9615h) * this.f9625r.getWidth();
                } else {
                    fSignum = 0.0f;
                    fSignum2 = 0.0f;
                }
                if (i9 == 2) {
                    i8 = 8;
                } else {
                    i8 = iL > 0 ? 2 : 4;
                }
                w(this.f9609b);
                float[] fArr = this.f9609b;
                float f8 = fArr[0];
                float f9 = fArr[1];
                c cVar = new c(d0Var2, i8, i9, f8, f9, fSignum, fSignum2, iL, d0Var2);
                cVar.b(this.f9620m.g(this.f9625r, i8, fSignum - f8, fSignum2 - f9));
                this.f9623p.add(cVar);
                cVar.d();
                z7 = true;
            } else {
                D(d0Var2.f9157a);
                this.f9620m.c(this.f9625r, d0Var2);
                z7 = false;
            }
            this.f9610c = null;
        } else {
            z7 = false;
        }
        if (d0Var != null) {
            this.f9622o = (this.f9620m.f(this.f9625r, d0Var) & i10) >> (this.f9621n * 8);
            this.f9617j = d0Var.f9157a.getLeft();
            this.f9618k = d0Var.f9157a.getTop();
            this.f9610c = d0Var;
            if (i7 == 2) {
                z8 = false;
                d0Var.f9157a.performHapticFeedback(0);
            } else {
                z8 = false;
            }
        } else {
            z8 = false;
        }
        ViewParent parent = this.f9625r.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.f9610c != null ? true : z8);
        }
        if (!z7) {
            this.f9625r.getLayoutManager().O1();
        }
        this.f9620m.C(this.f9610c, this.f9621n);
        this.f9625r.invalidate();
    }

    public void H(@m0 RecyclerView.d0 d0Var) {
        if (!this.f9620m.p(this.f9625r, d0Var)) {
            Log.e(Q, "Start drag has been called but dragging is not enabled");
            return;
        }
        if (d0Var.f9157a.getParent() != this.f9625r) {
            Log.e(Q, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        A();
        this.f9616i = 0.0f;
        this.f9615h = 0.0f;
        F(d0Var, 2);
    }

    public void J(@m0 RecyclerView.d0 d0Var) {
        if (!this.f9620m.q(this.f9625r, d0Var)) {
            Log.e(Q, "Start swipe has been called but swiping is not enabled");
            return;
        }
        if (d0Var.f9157a.getParent() != this.f9625r) {
            Log.e(Q, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            return;
        }
        A();
        this.f9616i = 0.0f;
        this.f9615h = 0.0f;
        F(d0Var, 1);
    }

    void M(MotionEvent motionEvent, int i7, int i8) {
        float x7 = motionEvent.getX(i8);
        float y7 = motionEvent.getY(i8);
        float f8 = x7 - this.f9611d;
        this.f9615h = f8;
        this.f9616i = y7 - this.f9612e;
        if ((i7 & 4) == 0) {
            this.f9615h = Math.max(0.0f, f8);
        }
        if ((i7 & 8) == 0) {
            this.f9615h = Math.min(0.0f, this.f9615h);
        }
        if ((i7 & 1) == 0) {
            this.f9616i = Math.max(0.0f, this.f9616i);
        }
        if ((i7 & 2) == 0) {
            this.f9616i = Math.min(0.0f, this.f9616i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void b(@m0 View view) {
        D(view);
        RecyclerView.d0 d0VarS0 = this.f9625r.s0(view);
        if (d0VarS0 == null) {
            return;
        }
        RecyclerView.d0 d0Var = this.f9610c;
        if (d0Var != null && d0VarS0 == d0Var) {
            F(null, 0);
            return;
        }
        r(d0VarS0, false);
        if (this.f9608a.remove(d0VarS0.f9157a)) {
            this.f9620m.c(this.f9625r, d0VarS0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void d(@m0 View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f8;
        float f9;
        this.f9632y = -1;
        if (this.f9610c != null) {
            w(this.f9609b);
            float[] fArr = this.f9609b;
            float f10 = fArr[0];
            f9 = fArr[1];
            f8 = f10;
        } else {
            f8 = 0.0f;
            f9 = 0.0f;
        }
        this.f9620m.y(canvas, recyclerView, this.f9610c, this.f9623p, this.f9621n, f8, f9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f8;
        float f9;
        if (this.f9610c != null) {
            w(this.f9609b);
            float[] fArr = this.f9609b;
            float f10 = fArr[0];
            f9 = fArr[1];
            f8 = f10;
        } else {
            f8 = 0.0f;
            f9 = 0.0f;
        }
        this.f9620m.z(canvas, recyclerView, this.f9610c, this.f9623p, this.f9621n, f8, f9);
    }

    public void m(@o0 RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f9625r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            q();
        }
        this.f9625r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f9613f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            this.f9614g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            G();
        }
    }

    void o(int i7, MotionEvent motionEvent, int i8) {
        RecyclerView.d0 d0VarV;
        int iF;
        if (this.f9610c != null || i7 != 2 || this.f9621n == 2 || !this.f9620m.s() || this.f9625r.getScrollState() == 1 || (d0VarV = v(motionEvent)) == null || (iF = (this.f9620m.f(this.f9625r, d0VarV) & 65280) >> 8) == 0) {
            return;
        }
        float x7 = motionEvent.getX(i8);
        float y7 = motionEvent.getY(i8);
        float f8 = x7 - this.f9611d;
        float f9 = y7 - this.f9612e;
        float fAbs = Math.abs(f8);
        float fAbs2 = Math.abs(f9);
        int i9 = this.f9624q;
        if (fAbs >= i9 || fAbs2 >= i9) {
            if (fAbs > fAbs2) {
                if (f8 < 0.0f && (iF & 4) == 0) {
                    return;
                }
                if (f8 > 0.0f && (iF & 8) == 0) {
                    return;
                }
            } else {
                if (f9 < 0.0f && (iF & 1) == 0) {
                    return;
                }
                if (f9 > 0.0f && (iF & 2) == 0) {
                    return;
                }
            }
            this.f9616i = 0.0f;
            this.f9615h = 0.0f;
            this.f9619l = motionEvent.getPointerId(0);
            F(d0VarV, 1);
        }
    }

    void r(RecyclerView.d0 d0Var, boolean z7) {
        for (int size = this.f9623p.size() - 1; size >= 0; size--) {
            h hVar = this.f9623p.get(size);
            if (hVar.f9657e == d0Var) {
                hVar.f9664l |= z7;
                if (!hVar.f9665m) {
                    hVar.a();
                }
                this.f9623p.remove(size);
                return;
            }
        }
    }

    h s(MotionEvent motionEvent) {
        if (this.f9623p.isEmpty()) {
            return null;
        }
        View viewT = t(motionEvent);
        for (int size = this.f9623p.size() - 1; size >= 0; size--) {
            h hVar = this.f9623p.get(size);
            if (hVar.f9657e.f9157a == viewT) {
                return hVar;
            }
        }
        return null;
    }

    View t(MotionEvent motionEvent) {
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        RecyclerView.d0 d0Var = this.f9610c;
        if (d0Var != null) {
            View view = d0Var.f9157a;
            if (y(view, x7, y7, this.f9617j + this.f9615h, this.f9618k + this.f9616i)) {
                return view;
            }
        }
        for (int size = this.f9623p.size() - 1; size >= 0; size--) {
            h hVar = this.f9623p.get(size);
            View view2 = hVar.f9657e.f9157a;
            if (y(view2, x7, y7, hVar.f9662j, hVar.f9663k)) {
                return view2;
            }
        }
        return this.f9625r.Z(x7, y7);
    }

    boolean x() {
        int size = this.f9623p.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (!this.f9623p.get(i7).f9665m) {
                return true;
            }
        }
        return false;
    }

    void z(RecyclerView.d0 d0Var) {
        if (!this.f9625r.isLayoutRequested() && this.f9621n == 2) {
            float fK = this.f9620m.k(d0Var);
            int i7 = (int) (this.f9617j + this.f9615h);
            int i8 = (int) (this.f9618k + this.f9616i);
            if (Math.abs(i8 - d0Var.f9157a.getTop()) >= d0Var.f9157a.getHeight() * fK || Math.abs(i7 - d0Var.f9157a.getLeft()) >= d0Var.f9157a.getWidth() * fK) {
                List<RecyclerView.d0> listU = u(d0Var);
                if (listU.size() == 0) {
                    return;
                }
                RecyclerView.d0 d0VarB = this.f9620m.b(d0Var, listU, i7, i8);
                if (d0VarB == null) {
                    this.f9628u.clear();
                    this.f9629v.clear();
                    return;
                }
                int iJ = d0VarB.j();
                int iJ2 = d0Var.j();
                if (this.f9620m.A(this.f9625r, d0Var, d0VarB)) {
                    this.f9620m.B(this.f9625r, d0Var, iJ2, d0VarB, iJ, i7, i8);
                }
            }
        }
    }
}
