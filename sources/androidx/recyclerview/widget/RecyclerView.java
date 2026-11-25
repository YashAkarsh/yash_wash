package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.r0;
import androidx.core.view.accessibility.l0;
import androidx.core.view.f4;
import androidx.core.view.i2;
import androidx.core.view.n2;
import androidx.core.view.q1;
import androidx.core.view.r1;
import androidx.core.view.s1;
import androidx.core.view.u1;
import androidx.customview.view.AbsSavedState;
import c.g1;
import c.m0;
import c.o0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements i2, r1, s1 {
    static final String A1 = "RV CreateView";
    private static final Class<?>[] B1;
    private static final int C1 = -1;
    public static final int D1 = 0;
    public static final int E1 = 1;
    public static final int F1 = 2;
    static final long G1 = Long.MAX_VALUE;
    static final Interpolator H1;
    static final String Y0 = "RecyclerView";
    static final boolean Z0 = false;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    static final boolean f9061a1 = false;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private static final int[] f9062b1 = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    static final boolean f9063c1 = false;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    static final boolean f9064d1 = true;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    static final boolean f9065e1 = true;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    static final boolean f9066f1 = true;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private static final boolean f9067g1 = false;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private static final boolean f9068h1 = false;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    static final boolean f9069i1 = false;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final int f9070j1 = 0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f9071k1 = 1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    static final int f9072l1 = 1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final int f9073m1 = -1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final long f9074n1 = -1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final int f9075o1 = -1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final int f9076p1 = 0;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final int f9077q1 = 1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final int f9078r1 = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    static final int f9079s1 = 2000;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    static final String f9080t1 = "RV Scroll";

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private static final String f9081u1 = "RV OnLayout";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private static final String f9082v1 = "RV FullInvalidate";

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private static final String f9083w1 = "RV PartialInvalidate";

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    static final String f9084x1 = "RV OnBindView";

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    static final String f9085y1 = "RV Prefetch";

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    static final String f9086z1 = "RV Nested Prefetch";
    boolean A;
    private final int A0;
    private final AccessibilityManager B;
    private float B0;
    private List<p> C;
    private float C0;
    boolean D;
    private boolean D0;
    boolean E;
    final c0 E0;
    private int F;
    androidx.recyclerview.widget.l F0;
    private int G;
    androidx.recyclerview.widget.l.b G0;

    @m0
    private k H;
    final a0 H0;
    private EdgeEffect I;
    private s I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private EdgeEffect f9087J;
    private List<s> J0;
    private EdgeEffect K;
    boolean K0;
    private EdgeEffect L;
    boolean L0;
    l M;
    private l.c M0;
    private int N;
    boolean N0;
    private int O;
    androidx.recyclerview.widget.y O0;
    private VelocityTracker P;
    private j P0;
    private int Q;
    private final int[] Q0;
    private int R;
    private u1 R0;
    private int S;
    private final int[] S0;
    private int T;
    private final int[] T0;
    private int U;
    final int[] U0;
    private q V;

    @g1
    final List<d0> V0;
    private final int W;
    private Runnable W0;
    private final h0.b X0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f9088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final v f9089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SavedState f9090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    androidx.recyclerview.widget.a f9091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    androidx.recyclerview.widget.g f9092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h0 f9093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f9094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Runnable f9095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Rect f9096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Rect f9097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final RectF f9098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    g f9099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g1
    o f9100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    w f9101n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final ArrayList<n> f9102o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ArrayList<r> f9103p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private r f9104q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f9105r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f9106s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f9107t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @g1
    boolean f9108u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f9109v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f9110w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f9111x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f9112y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f9113z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f9108u || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f9105r) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f9111x) {
                recyclerView2.f9110w = true;
            } else {
                recyclerView2.E();
            }
        }
    }

    public static class a0 {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final int f9120r = 1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        static final int f9121s = 2;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        static final int f9122t = 4;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseArray<Object> f9124b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f9135m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f9136n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f9137o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f9138p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f9139q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9123a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9125c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f9126d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f9127e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9128f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f9129g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f9130h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f9131i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f9132j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f9133k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f9134l = false;

        void a(int i7) {
            if ((this.f9127e & i7) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i7) + " but it is " + Integer.toBinaryString(this.f9127e));
        }

        public boolean b() {
            return this.f9129g;
        }

        public <T> T c(int i7) {
            SparseArray<Object> sparseArray = this.f9124b;
            if (sparseArray == null) {
                return null;
            }
            return (T) sparseArray.get(i7);
        }

        public int d() {
            return this.f9130h ? this.f9125c - this.f9126d : this.f9128f;
        }

        public int e() {
            return this.f9138p;
        }

        public int f() {
            return this.f9139q;
        }

        public int g() {
            return this.f9123a;
        }

        public boolean h() {
            return this.f9123a != -1;
        }

        public boolean i() {
            return this.f9132j;
        }

        public boolean j() {
            return this.f9130h;
        }

        void k(g gVar) {
            this.f9127e = 1;
            this.f9128f = gVar.e();
            this.f9130h = false;
            this.f9131i = false;
            this.f9132j = false;
        }

        public void l(int i7, Object obj) {
            if (this.f9124b == null) {
                this.f9124b = new SparseArray<>();
            }
            this.f9124b.put(i7, obj);
        }

        public void m(int i7) {
            SparseArray<Object> sparseArray = this.f9124b;
            if (sparseArray == null) {
                return;
            }
            sparseArray.remove(i7);
        }

        public boolean n() {
            return this.f9134l;
        }

        public boolean o() {
            return this.f9133k;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f9123a + ", mData=" + this.f9124b + ", mItemCount=" + this.f9128f + ", mIsMeasuring=" + this.f9132j + ", mPreviousLayoutItemCount=" + this.f9125c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f9126d + ", mStructureChanged=" + this.f9129g + ", mInPreLayout=" + this.f9130h + ", mRunSimpleAnimations=" + this.f9133k + ", mRunPredictiveAnimations=" + this.f9134l + '}';
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.M;
            if (lVar != null) {
                lVar.x();
            }
            RecyclerView.this.N0 = false;
        }
    }

    public static abstract class b0 {
        @o0
        public abstract View a(@m0 v vVar, int i7, int i8);
    }

    static class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f8) {
            float f9 = f8 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    }

    class c0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        OverScroller f9143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Interpolator f9144d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f9145e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f9146f;

        c0() {
            Interpolator interpolator = RecyclerView.H1;
            this.f9144d = interpolator;
            this.f9145e = false;
            this.f9146f = false;
            this.f9143c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i7, int i8, int i9, int i10) {
            int iRound;
            int iAbs = Math.abs(i7);
            int iAbs2 = Math.abs(i8);
            boolean z7 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i9 * i9) + (i10 * i10));
            int iSqrt2 = (int) Math.sqrt((i7 * i7) + (i8 * i8));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z7 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i11 = width / 2;
            float f8 = width;
            float f9 = i11;
            float fB = f9 + (b(Math.min(1.0f, (iSqrt2 * 1.0f) / f8)) * f9);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fB / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z7) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f8) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, RecyclerView.f9079s1);
        }

        private float b(float f8) {
            return (float) Math.sin((f8 - 0.5f) * 0.47123894f);
        }

        private void d() {
            RecyclerView.this.removeCallbacks(this);
            n2.p1(RecyclerView.this, this);
        }

        public void c(int i7, int i8) {
            RecyclerView.this.setScrollState(2);
            this.f9142b = 0;
            this.f9141a = 0;
            Interpolator interpolator = this.f9144d;
            Interpolator interpolator2 = RecyclerView.H1;
            if (interpolator != interpolator2) {
                this.f9144d = interpolator2;
                this.f9143c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f9143c.fling(0, 0, i7, i8, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        void e() {
            if (this.f9145e) {
                this.f9146f = true;
            } else {
                d();
            }
        }

        public void f(int i7, int i8, int i9, @o0 Interpolator interpolator) {
            if (i9 == Integer.MIN_VALUE) {
                i9 = a(i7, i8, 0, 0);
            }
            int i10 = i9;
            if (interpolator == null) {
                interpolator = RecyclerView.H1;
            }
            if (this.f9144d != interpolator) {
                this.f9144d = interpolator;
                this.f9143c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f9142b = 0;
            this.f9141a = 0;
            RecyclerView.this.setScrollState(2);
            this.f9143c.startScroll(0, 0, i7, i8, i10);
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f9143c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i7;
            int i8;
            int i9;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f9100m == null) {
                g();
                return;
            }
            this.f9146f = false;
            this.f9145e = true;
            recyclerView.E();
            OverScroller overScroller = this.f9143c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i10 = currX - this.f9141a;
                int i11 = currY - this.f9142b;
                this.f9141a = currX;
                this.f9142b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.U0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.b(i10, i11, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.U0;
                    i10 -= iArr2[0];
                    i11 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.D(i10, i11);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f9099l != null) {
                    int[] iArr3 = recyclerView3.U0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.B1(i10, i11, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.U0;
                    i8 = iArr4[0];
                    i7 = iArr4[1];
                    i10 -= i8;
                    i11 -= i7;
                    z zVar = recyclerView4.f9100m.f9206g;
                    if (zVar != null && !zVar.h() && zVar.i()) {
                        int iD = RecyclerView.this.H0.d();
                        if (iD == 0) {
                            zVar.s();
                        } else if (zVar.f() >= iD) {
                            zVar.q(iD - 1);
                            zVar.k(i8, i7);
                        } else {
                            zVar.k(i8, i7);
                        }
                    }
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                if (!RecyclerView.this.f9102o.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.U0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.c(i8, i7, i10, i11, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.U0;
                int i12 = i10 - iArr6[0];
                int i13 = i11 - iArr6[1];
                if (i8 != 0 || i7 != 0) {
                    recyclerView6.Q(i8, i7);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z7 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i12 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i13 != 0));
                z zVar2 = RecyclerView.this.f9100m.f9206g;
                if ((zVar2 != null && zVar2.h()) || !z7) {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.l lVar = recyclerView7.F0;
                    if (lVar != null) {
                        lVar.f(recyclerView7, i8, i7);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i12 < 0) {
                            i9 = -currVelocity;
                        } else {
                            i9 = i12 > 0 ? currVelocity : 0;
                        }
                        if (i13 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i13 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.f(i9, currVelocity);
                    }
                    if (RecyclerView.f9066f1) {
                        RecyclerView.this.G0.b();
                    }
                }
            }
            z zVar3 = RecyclerView.this.f9100m.f9206g;
            if (zVar3 != null && zVar3.h()) {
                zVar3.k(0, 0);
            }
            this.f9145e = false;
            if (this.f9146f) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.h(1);
            }
        }
    }

    class d implements h0.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.h0.b
        public void a(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f9100m.F1(d0Var.f9157a, recyclerView.f9089b);
        }

        @Override // androidx.recyclerview.widget.h0.b
        public void b(d0 d0Var, l.d dVar, l.d dVar2) {
            RecyclerView.this.s(d0Var, dVar, dVar2);
        }

        @Override // androidx.recyclerview.widget.h0.b
        public void c(d0 d0Var, @m0 l.d dVar, @o0 l.d dVar2) {
            RecyclerView.this.f9089b.K(d0Var);
            RecyclerView.this.u(d0Var, dVar, dVar2);
        }

        @Override // androidx.recyclerview.widget.h0.b
        public void d(d0 d0Var, @m0 l.d dVar, @m0 l.d dVar2) {
            d0Var.H(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.D) {
                if (recyclerView.M.b(d0Var, d0Var, dVar, dVar2)) {
                    RecyclerView.this.f1();
                }
            } else if (recyclerView.M.d(d0Var, dVar, dVar2)) {
                RecyclerView.this.f1();
            }
        }
    }

    public static abstract class d0 {
        static final int A = 512;
        static final int B = 1024;
        static final int C = 2048;
        static final int D = 4096;
        static final int E = -1;
        static final int F = 8192;
        private static final List<Object> G = Collections.emptyList();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        static final int f9149s = 1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        static final int f9150t = 2;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        static final int f9151u = 4;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        static final int f9152v = 8;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        static final int f9153w = 16;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        static final int f9154x = 32;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        static final int f9155y = 128;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        static final int f9156z = 256;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        public final View f9157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        WeakReference<RecyclerView> f9158b;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f9166j;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        RecyclerView f9174r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9159c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f9160d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f9161e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9162f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f9163g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        d0 f9164h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        d0 f9165i = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        List<Object> f9167k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        List<Object> f9168l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f9169m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        v f9170n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f9171o = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f9172p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @g1
        int f9173q = -1;

        public d0(@m0 View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f9157a = view;
        }

        private void g() {
            if (this.f9167k == null) {
                ArrayList arrayList = new ArrayList();
                this.f9167k = arrayList;
                this.f9168l = Collections.unmodifiableList(arrayList);
            }
        }

        boolean A() {
            return (this.f9166j & 2) != 0;
        }

        void B(int i7, boolean z7) {
            if (this.f9160d == -1) {
                this.f9160d = this.f9159c;
            }
            if (this.f9163g == -1) {
                this.f9163g = this.f9159c;
            }
            if (z7) {
                this.f9163g += i7;
            }
            this.f9159c += i7;
            if (this.f9157a.getLayoutParams() != null) {
                ((LayoutParams) this.f9157a.getLayoutParams()).f9116c = true;
            }
        }

        void C(RecyclerView recyclerView) {
            int i7 = this.f9173q;
            if (i7 != -1) {
                this.f9172p = i7;
            } else {
                this.f9172p = n2.V(this.f9157a);
            }
            recyclerView.E1(this, 4);
        }

        void D(RecyclerView recyclerView) {
            recyclerView.E1(this, this.f9172p);
            this.f9172p = 0;
        }

        void E() {
            this.f9166j = 0;
            this.f9159c = -1;
            this.f9160d = -1;
            this.f9161e = -1L;
            this.f9163g = -1;
            this.f9169m = 0;
            this.f9164h = null;
            this.f9165i = null;
            d();
            this.f9172p = 0;
            this.f9173q = -1;
            RecyclerView.z(this);
        }

        void F() {
            if (this.f9160d == -1) {
                this.f9160d = this.f9159c;
            }
        }

        void G(int i7, int i8) {
            this.f9166j = (i7 & i8) | (this.f9166j & (~i8));
        }

        public final void H(boolean z7) {
            int i7 = this.f9169m;
            int i8 = z7 ? i7 - 1 : i7 + 1;
            this.f9169m = i8;
            if (i8 < 0) {
                this.f9169m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z7 && i8 == 1) {
                this.f9166j |= 16;
            } else if (z7 && i8 == 0) {
                this.f9166j &= -17;
            }
        }

        void I(v vVar, boolean z7) {
            this.f9170n = vVar;
            this.f9171o = z7;
        }

        boolean J() {
            return (this.f9166j & 16) != 0;
        }

        boolean K() {
            return (this.f9166j & 128) != 0;
        }

        void L() {
            this.f9166j &= org.chromium.net.v.L2;
        }

        void M() {
            this.f9170n.K(this);
        }

        boolean N() {
            return (this.f9166j & 32) != 0;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f9166j) == 0) {
                g();
                this.f9167k.add(obj);
            }
        }

        void b(int i7) {
            this.f9166j = i7 | this.f9166j;
        }

        void c() {
            this.f9160d = -1;
            this.f9163g = -1;
        }

        void d() {
            List<Object> list = this.f9167k;
            if (list != null) {
                list.clear();
            }
            this.f9166j &= -1025;
        }

        void e() {
            this.f9166j &= -33;
        }

        void f() {
            this.f9166j &= -257;
        }

        boolean h() {
            return (this.f9166j & 16) == 0 && n2.M0(this.f9157a);
        }

        void i(int i7, int i8, boolean z7) {
            b(8);
            B(i8, z7);
            this.f9159c = i7;
        }

        public final int j() {
            RecyclerView recyclerView = this.f9174r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.m0(this);
        }

        public final long k() {
            return this.f9161e;
        }

        public final int l() {
            return this.f9162f;
        }

        public final int m() {
            int i7 = this.f9163g;
            return i7 == -1 ? this.f9159c : i7;
        }

        public final int n() {
            return this.f9160d;
        }

        @Deprecated
        public final int o() {
            int i7 = this.f9163g;
            return i7 == -1 ? this.f9159c : i7;
        }

        List<Object> p() {
            if ((this.f9166j & 1024) != 0) {
                return G;
            }
            List<Object> list = this.f9167k;
            return (list == null || list.size() == 0) ? G : this.f9168l;
        }

        boolean q(int i7) {
            return (i7 & this.f9166j) != 0;
        }

        boolean r() {
            return (this.f9166j & 512) != 0 || u();
        }

        boolean s() {
            return (this.f9157a.getParent() == null || this.f9157a.getParent() == this.f9174r) ? false : true;
        }

        boolean t() {
            return (this.f9166j & 1) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f9159c + " id=" + this.f9161e + ", oldPos=" + this.f9160d + ", pLpos:" + this.f9163g);
            if (x()) {
                sb.append(" scrap ");
                sb.append(this.f9171o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (u()) {
                sb.append(" invalid");
            }
            if (!t()) {
                sb.append(" unbound");
            }
            if (A()) {
                sb.append(" update");
            }
            if (w()) {
                sb.append(" removed");
            }
            if (K()) {
                sb.append(" ignored");
            }
            if (y()) {
                sb.append(" tmpDetached");
            }
            if (!v()) {
                sb.append(" not recyclable(" + this.f9169m + ")");
            }
            if (r()) {
                sb.append(" undefined adapter position");
            }
            if (this.f9157a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append(com.alipay.sdk.util.j.f13808d);
            return sb.toString();
        }

        boolean u() {
            return (this.f9166j & 4) != 0;
        }

        public final boolean v() {
            return (this.f9166j & 16) == 0 && !n2.M0(this.f9157a);
        }

        boolean w() {
            return (this.f9166j & 8) != 0;
        }

        boolean x() {
            return this.f9170n != null;
        }

        boolean y() {
            return (this.f9166j & 256) != 0;
        }

        boolean z() {
            return (this.f9166j & 2) != 0;
        }
    }

    class e implements androidx.recyclerview.widget.g.b {
        e() {
        }

        @Override // androidx.recyclerview.widget.g.b
        public View a(int i7) {
            return RecyclerView.this.getChildAt(i7);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void b(View view) {
            d0 d0VarT0 = RecyclerView.t0(view);
            if (d0VarT0 != null) {
                d0VarT0.C(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.g.b
        public int c() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.g.b
        public void d() {
            int iC = c();
            for (int i7 = 0; i7 < iC; i7++) {
                View viewA = a(i7);
                RecyclerView.this.J(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.g.b
        public int e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.g.b
        public d0 f(View view) {
            return RecyclerView.t0(view);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void g(int i7) {
            d0 d0VarT0;
            View viewA = a(i7);
            if (viewA != null && (d0VarT0 = RecyclerView.t0(viewA)) != null) {
                if (d0VarT0.y() && !d0VarT0.K()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + d0VarT0 + RecyclerView.this.X());
                }
                d0VarT0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i7);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void h(View view) {
            d0 d0VarT0 = RecyclerView.t0(view);
            if (d0VarT0 != null) {
                d0VarT0.D(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.g.b
        public void i(View view, int i7) {
            RecyclerView.this.addView(view, i7);
            RecyclerView.this.I(view);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void j(int i7) {
            View childAt = RecyclerView.this.getChildAt(i7);
            if (childAt != null) {
                RecyclerView.this.J(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i7);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void k(View view, int i7, ViewGroup.LayoutParams layoutParams) {
            d0 d0VarT0 = RecyclerView.t0(view);
            if (d0VarT0 != null) {
                if (!d0VarT0.y() && !d0VarT0.K()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + d0VarT0 + RecyclerView.this.X());
                }
                d0VarT0.f();
            }
            RecyclerView.this.attachViewToParent(view, i7, layoutParams);
        }
    }

    class f implements androidx.recyclerview.widget.a.InterfaceC0121a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0121a
        public void a(int i7, int i8) {
            RecyclerView.this.V0(i7, i8);
            RecyclerView.this.K0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0121a
        public void b(androidx.recyclerview.widget.a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0121a
        public void c(int i7, int i8, Object obj) {
            RecyclerView.this.Q1(i7, i8, obj);
            RecyclerView.this.L0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0121a
        public void d(androidx.recyclerview.widget.a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0121a
        public d0 e(int i7) {
            d0 d0VarK0 = RecyclerView.this.k0(i7, true);
            if (d0VarK0 == null || RecyclerView.this.f9092e.n(d0VarK0.f9157a)) {
                return null;
            }
            return d0VarK0;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0121a
        public void f(int i7, int i8) {
            RecyclerView.this.W0(i7, i8, false);
            RecyclerView.this.K0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0121a
        public void g(int i7, int i8) {
            RecyclerView.this.U0(i7, i8);
            RecyclerView.this.K0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0121a
        public void h(int i7, int i8) {
            RecyclerView.this.W0(i7, i8, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.K0 = true;
            recyclerView.H0.f9126d += i8;
        }

        void i(androidx.recyclerview.widget.a.b bVar) {
            int i7 = bVar.f9319a;
            if (i7 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f9100m.i1(recyclerView, bVar.f9320b, bVar.f9322d);
                return;
            }
            if (i7 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f9100m.l1(recyclerView2, bVar.f9320b, bVar.f9322d);
            } else if (i7 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f9100m.n1(recyclerView3, bVar.f9320b, bVar.f9322d, bVar.f9321c);
            } else {
                if (i7 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f9100m.k1(recyclerView4, bVar.f9320b, bVar.f9322d, 1);
            }
        }
    }

    public static abstract class g<VH extends d0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f9177a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9178b = false;

        public void A(@m0 VH vh) {
        }

        public void B(@m0 VH vh) {
        }

        public void C(@m0 i iVar) {
            this.f9177a.registerObserver(iVar);
        }

        public void D(boolean z7) {
            if (h()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f9178b = z7;
        }

        public void E(@m0 i iVar) {
            this.f9177a.unregisterObserver(iVar);
        }

        public final void c(@m0 VH vh, int i7) {
            vh.f9159c = i7;
            if (i()) {
                vh.f9161e = f(i7);
            }
            vh.G(1, 519);
            r0.b(RecyclerView.f9084x1);
            v(vh, i7, vh.p());
            vh.d();
            ViewGroup.LayoutParams layoutParams = vh.f9157a.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f9116c = true;
            }
            r0.d();
        }

        @m0
        public final VH d(@m0 ViewGroup viewGroup, int i7) {
            try {
                r0.b(RecyclerView.A1);
                VH vh = (VH) w(viewGroup, i7);
                if (vh.f9157a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.f9162f = i7;
                r0.d();
                return vh;
            } catch (Throwable th) {
                r0.d();
                throw th;
            }
        }

        public abstract int e();

        public long f(int i7) {
            return -1L;
        }

        public int g(int i7) {
            return 0;
        }

        public final boolean h() {
            return this.f9177a.a();
        }

        public final boolean i() {
            return this.f9178b;
        }

        public final void j() {
            this.f9177a.b();
        }

        public final void k(int i7) {
            this.f9177a.d(i7, 1);
        }

        public final void l(int i7, @o0 Object obj) {
            this.f9177a.e(i7, 1, obj);
        }

        public final void m(int i7) {
            this.f9177a.f(i7, 1);
        }

        public final void n(int i7, int i8) {
            this.f9177a.c(i7, i8);
        }

        public final void o(int i7, int i8) {
            this.f9177a.d(i7, i8);
        }

        public final void p(int i7, int i8, @o0 Object obj) {
            this.f9177a.e(i7, i8, obj);
        }

        public final void q(int i7, int i8) {
            this.f9177a.f(i7, i8);
        }

        public final void r(int i7, int i8) {
            this.f9177a.g(i7, i8);
        }

        public final void s(int i7) {
            this.f9177a.g(i7, 1);
        }

        public void t(@m0 RecyclerView recyclerView) {
        }

        public abstract void u(@m0 VH vh, int i7);

        public void v(@m0 VH vh, int i7, @m0 List<Object> list) {
            u(vh, i7);
        }

        @m0
        public abstract VH w(@m0 ViewGroup viewGroup, int i7);

        public void x(@m0 RecyclerView recyclerView) {
        }

        public boolean y(@m0 VH vh) {
            return false;
        }

        public void z(@m0 VH vh) {
        }
    }

    static class h extends Observable<i> {
        h() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i7, int i8) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).e(i7, i8, 1);
            }
        }

        public void d(int i7, int i8) {
            e(i7, i8, null);
        }

        public void e(int i7, int i8, @o0 Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i7, i8, obj);
            }
        }

        public void f(int i7, int i8) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).d(i7, i8);
            }
        }

        public void g(int i7, int i8) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).f(i7, i8);
            }
        }
    }

    public static abstract class i {
        public void a() {
        }

        public void b(int i7, int i8) {
        }

        public void c(int i7, int i8, @o0 Object obj) {
            b(i7, i8);
        }

        public void d(int i7, int i8) {
        }

        public void e(int i7, int i8, int i9) {
        }

        public void f(int i7, int i8) {
        }
    }

    public interface j {
        int a(int i7, int i8);
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f9179a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f9180b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f9181c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f9182d = 3;

        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        @m0
        protected EdgeEffect a(@m0 RecyclerView recyclerView, int i7) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f9183g = 2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f9184h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f9185i = 4;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f9186j = 2048;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f9187k = 4096;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f9188a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<b> f9189b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f9190c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f9191d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f9192e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f9193f = 250;

        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public interface b {
            void a();
        }

        interface c {
            void a(@m0 d0 d0Var);
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f9194a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f9195b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f9196c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f9197d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f9198e;

            @m0
            public d a(@m0 d0 d0Var) {
                return b(d0Var, 0);
            }

            @m0
            public d b(@m0 d0 d0Var, int i7) {
                View view = d0Var.f9157a;
                this.f9194a = view.getLeft();
                this.f9195b = view.getTop();
                this.f9196c = view.getRight();
                this.f9197d = view.getBottom();
                return this;
            }
        }

        static int e(d0 d0Var) {
            int i7 = d0Var.f9166j & 14;
            if (d0Var.u()) {
                return 4;
            }
            if ((i7 & 4) != 0) {
                return i7;
            }
            int iN = d0Var.n();
            int iJ = d0Var.j();
            return (iN == -1 || iJ == -1 || iN == iJ) ? i7 : i7 | 2048;
        }

        void A(c cVar) {
            this.f9188a = cVar;
        }

        public void B(long j7) {
            this.f9192e = j7;
        }

        public void C(long j7) {
            this.f9191d = j7;
        }

        public abstract boolean a(@m0 d0 d0Var, @o0 d dVar, @m0 d dVar2);

        public abstract boolean b(@m0 d0 d0Var, @m0 d0 d0Var2, @m0 d dVar, @m0 d dVar2);

        public abstract boolean c(@m0 d0 d0Var, @m0 d dVar, @o0 d dVar2);

        public abstract boolean d(@m0 d0 d0Var, @m0 d dVar, @m0 d dVar2);

        public boolean f(@m0 d0 d0Var) {
            return true;
        }

        public boolean g(@m0 d0 d0Var, @m0 List<Object> list) {
            return f(d0Var);
        }

        public final void h(@m0 d0 d0Var) {
            t(d0Var);
            c cVar = this.f9188a;
            if (cVar != null) {
                cVar.a(d0Var);
            }
        }

        public final void i(@m0 d0 d0Var) {
            u(d0Var);
        }

        public final void j() {
            int size = this.f9189b.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f9189b.get(i7).a();
            }
            this.f9189b.clear();
        }

        public abstract void k(@m0 d0 d0Var);

        public abstract void l();

        public long m() {
            return this.f9190c;
        }

        public long n() {
            return this.f9193f;
        }

        public long o() {
            return this.f9192e;
        }

        public long p() {
            return this.f9191d;
        }

        public abstract boolean q();

        public final boolean r(@o0 b bVar) {
            boolean zQ = q();
            if (bVar != null) {
                if (zQ) {
                    this.f9189b.add(bVar);
                } else {
                    bVar.a();
                }
            }
            return zQ;
        }

        @m0
        public d s() {
            return new d();
        }

        public void t(@m0 d0 d0Var) {
        }

        public void u(@m0 d0 d0Var) {
        }

        @m0
        public d v(@m0 a0 a0Var, @m0 d0 d0Var) {
            return s().a(d0Var);
        }

        @m0
        public d w(@m0 a0 a0Var, @m0 d0 d0Var, int i7, @m0 List<Object> list) {
            return s().a(d0Var);
        }

        public abstract void x();

        public void y(long j7) {
            this.f9190c = j7;
        }

        public void z(long j7) {
            this.f9193f = j7;
        }
    }

    private class m implements l.c {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.c
        public void a(d0 d0Var) {
            d0Var.H(true);
            if (d0Var.f9164h != null && d0Var.f9165i == null) {
                d0Var.f9164h = null;
            }
            d0Var.f9165i = null;
            if (d0Var.J() || RecyclerView.this.o1(d0Var.f9157a) || !d0Var.y()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d0Var.f9157a, false);
        }
    }

    public static abstract class n {
        @Deprecated
        public void f(@m0 Rect rect, int i7, @m0 RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(@m0 Rect rect, @m0 View view, @m0 RecyclerView recyclerView, @m0 a0 a0Var) {
            f(rect, ((LayoutParams) view.getLayoutParams()).b(), recyclerView);
        }

        @Deprecated
        public void h(@m0 Canvas canvas, @m0 RecyclerView recyclerView) {
        }

        public void i(@m0 Canvas canvas, @m0 RecyclerView recyclerView, @m0 a0 a0Var) {
            h(canvas, recyclerView);
        }

        @Deprecated
        public void j(@m0 Canvas canvas, @m0 RecyclerView recyclerView) {
        }

        public void k(@m0 Canvas canvas, @m0 RecyclerView recyclerView, @m0 a0 a0Var) {
            j(canvas, recyclerView);
        }
    }

    public static abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.recyclerview.widget.g f9200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView f9201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final g0.b f9202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final g0.b f9203d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        g0 f9204e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        g0 f9205f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @o0
        z f9206g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f9207h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f9208i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f9209j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f9210k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f9211l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f9212m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f9213n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f9214o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f9215p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f9216q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f9217r;

        class a implements g0.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.g0.b
            public View a(int i7) {
                return o.this.P(i7);
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int b(View view) {
                return o.this.Y(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int c() {
                return o.this.o0();
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int d() {
                return o.this.z0() - o.this.p0();
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int e(View view) {
                return o.this.b0(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
            }
        }

        class b implements g0.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.g0.b
            public View a(int i7) {
                return o.this.P(i7);
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int b(View view) {
                return o.this.c0(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int c() {
                return o.this.r0();
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int d() {
                return o.this.e0() - o.this.m0();
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int e(View view) {
                return o.this.W(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
            }
        }

        public interface c {
            void a(int i7, int i8);
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f9220a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f9221b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f9222c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f9223d;
        }

        public o() {
            a aVar = new a();
            this.f9202c = aVar;
            b bVar = new b();
            this.f9203d = bVar;
            this.f9204e = new g0(aVar);
            this.f9205f = new g0(bVar);
            this.f9207h = false;
            this.f9208i = false;
            this.f9209j = false;
            this.f9210k = true;
            this.f9211l = true;
        }

        private void E(int i7, @m0 View view) {
            this.f9200a.d(i7);
        }

        private boolean H0(RecyclerView recyclerView, int i7, int i8) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iO0 = o0();
            int iR0 = r0();
            int iZ0 = z0() - p0();
            int iE0 = e0() - m0();
            Rect rect = this.f9201b.f9096i;
            X(focusedChild, rect);
            return rect.left - i7 < iZ0 && rect.right - i7 > iO0 && rect.top - i8 < iE0 && rect.bottom - i8 > iR0;
        }

        private static boolean L0(int i7, int i8, int i9) {
            int mode = View.MeasureSpec.getMode(i8);
            int size = View.MeasureSpec.getSize(i8);
            if (i9 > 0 && i7 != i9) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i7;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i7;
            }
            return true;
        }

        private void P1(v vVar, int i7, View view) {
            d0 d0VarT0 = RecyclerView.t0(view);
            if (d0VarT0.K()) {
                return;
            }
            if (d0VarT0.u() && !d0VarT0.w() && !this.f9201b.f9099l.i()) {
                K1(i7);
                vVar.D(d0VarT0);
            } else {
                D(i7);
                vVar.E(view);
                this.f9201b.f9093f.k(d0VarT0);
            }
        }

        /* JADX WARN: Code duplicated, block: B:12:0x001c  */
        /* JADX WARN: Code duplicated, block: B:14:0x0020  */
        /* JADX WARN: Code duplicated, block: B:21:0x002f  */
        public static int R(int i7, int i8, int i9, int i10, boolean z7) {
            int iMax = Math.max(0, i7 - i9);
            if (z7) {
                if (i10 >= 0) {
                    i8 = 1073741824;
                } else if (i10 != -1 || (i8 != Integer.MIN_VALUE && (i8 == 0 || i8 != 1073741824))) {
                    i8 = 0;
                    i10 = 0;
                } else {
                    i10 = iMax;
                }
            } else if (i10 >= 0) {
                i8 = 1073741824;
            } else if (i10 == -1) {
                i10 = iMax;
            } else if (i10 != -2) {
                i8 = 0;
                i10 = 0;
            } else if (i8 == Integer.MIN_VALUE || i8 == 1073741824) {
                i10 = iMax;
                i8 = Integer.MIN_VALUE;
            } else {
                i10 = iMax;
                i8 = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(i10, i8);
        }

        /* JADX WARN: Code duplicated, block: B:6:0x000d  */
        /* JADX WARN: Code duplicated, block: B:8:0x0011 A[PHI: r3
          0x0011: PHI (r3v3 int) = (r3v0 int), (r3v2 int), (r3v0 int) binds: [B:7:0x000f, B:11:0x0016, B:4:0x000a] A[DONT_GENERATE, DONT_INLINE]] */
        @Deprecated
        public static int S(int i7, int i8, int i9, boolean z7) {
            int i10 = i7 - i8;
            int i11 = 0;
            int iMax = Math.max(0, i10);
            if (z7) {
                if (i9 >= 0) {
                    i11 = 1073741824;
                } else {
                    i9 = 0;
                }
            } else if (i9 >= 0) {
                i11 = 1073741824;
            } else if (i9 == -1) {
                i9 = iMax;
                i11 = 1073741824;
            } else if (i9 == -2) {
                i11 = Integer.MIN_VALUE;
                i9 = iMax;
            } else {
                i9 = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(i9, i11);
        }

        private int[] T(View view, Rect rect) {
            int[] iArr = new int[2];
            int iO0 = o0();
            int iR0 = r0();
            int iZ0 = z0() - p0();
            int iE0 = e0() - m0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i7 = left - iO0;
            int iMin = Math.min(0, i7);
            int i8 = top - iR0;
            int iMin2 = Math.min(0, i8);
            int i9 = iWidth - iZ0;
            int iMax = Math.max(0, i9);
            int iMax2 = Math.max(0, iHeight - iE0);
            if (i0() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i7, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i9);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i8, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        private void g(View view, int i7, boolean z7) {
            d0 d0VarT0 = RecyclerView.t0(view);
            if (z7 || d0VarT0.w()) {
                this.f9201b.f9093f.b(d0VarT0);
            } else {
                this.f9201b.f9093f.p(d0VarT0);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (d0VarT0.N() || d0VarT0.x()) {
                if (d0VarT0.x()) {
                    d0VarT0.M();
                } else {
                    d0VarT0.e();
                }
                this.f9200a.c(view, i7, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f9201b) {
                int iM = this.f9200a.m(view);
                if (i7 == -1) {
                    i7 = this.f9200a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f9201b.indexOfChild(view) + this.f9201b.X());
                }
                if (iM != i7) {
                    this.f9201b.f9100m.S0(iM, i7);
                }
            } else {
                this.f9200a.a(view, i7, false);
                layoutParams.f9116c = true;
                z zVar = this.f9206g;
                if (zVar != null && zVar.i()) {
                    this.f9206g.l(view);
                }
            }
            if (layoutParams.f9117d) {
                d0VarT0.f9157a.invalidate();
                layoutParams.f9117d = false;
            }
        }

        public static int q(int i7, int i8, int i9) {
            int mode = View.MeasureSpec.getMode(i7);
            int size = View.MeasureSpec.getSize(i7);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i8, i9) : size;
            }
            return Math.min(size, Math.max(i8, i9));
        }

        public static d t0(@m0 Context context, @o0 AttributeSet attributeSet, int i7, int i8) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i7, i8);
            dVar.f9220a = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            dVar.f9221b = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            dVar.f9222c = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            dVar.f9223d = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public void A(@m0 View view, @m0 v vVar) {
            P1(vVar, this.f9200a.m(view), view);
        }

        public int A0() {
            return this.f9214o;
        }

        public boolean A1(@m0 v vVar, @m0 a0 a0Var, @m0 View view, int i7, @o0 Bundle bundle) {
            return false;
        }

        public void B(int i7, @m0 v vVar) {
            P1(vVar, i7, P(i7));
        }

        boolean B0() {
            int iQ = Q();
            for (int i7 = 0; i7 < iQ; i7++) {
                ViewGroup.LayoutParams layoutParams = P(i7).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void B1(Runnable runnable) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                n2.p1(recyclerView, runnable);
            }
        }

        public void C(@m0 View view) {
            int iM = this.f9200a.m(view);
            if (iM >= 0) {
                E(iM, view);
            }
        }

        public boolean C0() {
            RecyclerView recyclerView = this.f9201b;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void C1() {
            for (int iQ = Q() - 1; iQ >= 0; iQ--) {
                this.f9200a.q(iQ);
            }
        }

        public void D(int i7) {
            E(i7, P(i7));
        }

        public void D0(@m0 View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.f9201b;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.f9201b.X());
            }
            d0 d0VarT0 = RecyclerView.t0(view);
            d0VarT0.b(128);
            this.f9201b.f9093f.q(d0VarT0);
        }

        public void D1(@m0 v vVar) {
            for (int iQ = Q() - 1; iQ >= 0; iQ--) {
                if (!RecyclerView.t0(P(iQ)).K()) {
                    G1(iQ, vVar);
                }
            }
        }

        public boolean E0() {
            return this.f9208i;
        }

        void E1(v vVar) {
            int iK = vVar.k();
            for (int i7 = iK - 1; i7 >= 0; i7--) {
                View viewO = vVar.o(i7);
                d0 d0VarT0 = RecyclerView.t0(viewO);
                if (!d0VarT0.K()) {
                    d0VarT0.H(false);
                    if (d0VarT0.y()) {
                        this.f9201b.removeDetachedView(viewO, false);
                    }
                    l lVar = this.f9201b.M;
                    if (lVar != null) {
                        lVar.k(d0VarT0);
                    }
                    d0VarT0.H(true);
                    vVar.z(viewO);
                }
            }
            vVar.f();
            if (iK > 0) {
                this.f9201b.invalidate();
            }
        }

        void F(RecyclerView recyclerView) {
            this.f9208i = true;
            X0(recyclerView);
        }

        public boolean F0() {
            return this.f9209j;
        }

        public void F1(@m0 View view, @m0 v vVar) {
            J1(view);
            vVar.C(view);
        }

        void G(RecyclerView recyclerView, v vVar) {
            this.f9208i = false;
            Z0(recyclerView, vVar);
        }

        public boolean G0() {
            RecyclerView recyclerView = this.f9201b;
            return recyclerView != null && recyclerView.isFocused();
        }

        public void G1(int i7, @m0 v vVar) {
            View viewP = P(i7);
            K1(i7);
            vVar.C(viewP);
        }

        public void H(View view) {
            l lVar = this.f9201b.M;
            if (lVar != null) {
                lVar.k(RecyclerView.t0(view));
            }
        }

        public boolean H1(Runnable runnable) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        @o0
        public View I(@m0 View view) {
            View viewA0;
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView == null || (viewA0 = recyclerView.a0(view)) == null || this.f9200a.n(viewA0)) {
                return null;
            }
            return viewA0;
        }

        public final boolean I0() {
            return this.f9211l;
        }

        public void I1(@m0 View view) {
            this.f9201b.removeDetachedView(view, false);
        }

        @o0
        public View J(int i7) {
            int iQ = Q();
            for (int i8 = 0; i8 < iQ; i8++) {
                View viewP = P(i8);
                d0 d0VarT0 = RecyclerView.t0(viewP);
                if (d0VarT0 != null && d0VarT0.m() == i7 && !d0VarT0.K() && (this.f9201b.H0.j() || !d0VarT0.w())) {
                    return viewP;
                }
            }
            return null;
        }

        public boolean J0(@m0 v vVar, @m0 a0 a0Var) {
            return false;
        }

        public void J1(View view) {
            this.f9200a.p(view);
        }

        public abstract LayoutParams K();

        public boolean K0() {
            return this.f9210k;
        }

        public void K1(int i7) {
            if (P(i7) != null) {
                this.f9200a.q(i7);
            }
        }

        public LayoutParams L(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public boolean L1(@m0 RecyclerView recyclerView, @m0 View view, @m0 Rect rect, boolean z7) {
            return M1(recyclerView, view, rect, z7, false);
        }

        public LayoutParams M(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public boolean M0() {
            z zVar = this.f9206g;
            return zVar != null && zVar.i();
        }

        public boolean M1(@m0 RecyclerView recyclerView, @m0 View view, @m0 Rect rect, boolean z7, boolean z8) {
            int[] iArrT = T(view, rect);
            int i7 = iArrT[0];
            int i8 = iArrT[1];
            if ((z8 && !H0(recyclerView, i7, i8)) || (i7 == 0 && i8 == 0)) {
                return false;
            }
            if (z7) {
                recyclerView.scrollBy(i7, i8);
            } else {
                recyclerView.G1(i7, i8);
            }
            return true;
        }

        public int N() {
            return -1;
        }

        public boolean N0(@m0 View view, boolean z7, boolean z8) {
            boolean z9 = this.f9204e.b(view, 24579) && this.f9205f.b(view, 24579);
            return z7 ? z9 : !z9;
        }

        public void N1() {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int O(@m0 View view) {
            return ((LayoutParams) view.getLayoutParams()).f9115b.bottom;
        }

        public void O0(@m0 View view, int i7, int i8, int i9, int i10) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f9115b;
            view.layout(i7 + rect.left, i8 + rect.top, i9 - rect.right, i10 - rect.bottom);
        }

        public void O1() {
            this.f9207h = true;
        }

        @o0
        public View P(int i7) {
            androidx.recyclerview.widget.g gVar = this.f9200a;
            if (gVar != null) {
                return gVar.f(i7);
            }
            return null;
        }

        public void P0(@m0 View view, int i7, int i8, int i9, int i10) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f9115b;
            view.layout(i7 + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i8 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i9 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i10 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public int Q() {
            androidx.recyclerview.widget.g gVar = this.f9200a;
            if (gVar != null) {
                return gVar.g();
            }
            return 0;
        }

        public void Q0(@m0 View view, int i7, int i8) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rectY0 = this.f9201b.y0(view);
            int i9 = i7 + rectY0.left + rectY0.right;
            int i10 = i8 + rectY0.top + rectY0.bottom;
            int iR = R(z0(), A0(), o0() + p0() + i9, ((ViewGroup.MarginLayoutParams) layoutParams).width, n());
            int iR2 = R(e0(), f0(), r0() + m0() + i10, ((ViewGroup.MarginLayoutParams) layoutParams).height, o());
            if (c2(view, iR, iR2, layoutParams)) {
                view.measure(iR, iR2);
            }
        }

        public int Q1(int i7, v vVar, a0 a0Var) {
            return 0;
        }

        public void R0(@m0 View view, int i7, int i8) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rectY0 = this.f9201b.y0(view);
            int i9 = i7 + rectY0.left + rectY0.right;
            int i10 = i8 + rectY0.top + rectY0.bottom;
            int iR = R(z0(), A0(), o0() + p0() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i9, ((ViewGroup.MarginLayoutParams) layoutParams).width, n());
            int iR2 = R(e0(), f0(), r0() + m0() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i10, ((ViewGroup.MarginLayoutParams) layoutParams).height, o());
            if (c2(view, iR, iR2, layoutParams)) {
                view.measure(iR, iR2);
            }
        }

        public void R1(int i7) {
        }

        public void S0(int i7, int i8) {
            View viewP = P(i7);
            if (viewP != null) {
                D(i7);
                k(viewP, i8);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i7 + this.f9201b.toString());
            }
        }

        public int S1(int i7, v vVar, a0 a0Var) {
            return 0;
        }

        public void T0(@c.r0 int i7) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                recyclerView.S0(i7);
            }
        }

        @Deprecated
        public void T1(boolean z7) {
            this.f9209j = z7;
        }

        public boolean U() {
            RecyclerView recyclerView = this.f9201b;
            return recyclerView != null && recyclerView.f9094g;
        }

        public void U0(@c.r0 int i7) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                recyclerView.T0(i7);
            }
        }

        void U1(RecyclerView recyclerView) {
            W1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int V(@m0 v vVar, @m0 a0 a0Var) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView == null || recyclerView.f9099l == null || !n()) {
                return 1;
            }
            return this.f9201b.f9099l.e();
        }

        public void V0(@o0 g gVar, @o0 g gVar2) {
        }

        public final void V1(boolean z7) {
            if (z7 != this.f9211l) {
                this.f9211l = z7;
                this.f9212m = 0;
                RecyclerView recyclerView = this.f9201b;
                if (recyclerView != null) {
                    recyclerView.f9089b.L();
                }
            }
        }

        public int W(@m0 View view) {
            return view.getBottom() + O(view);
        }

        public boolean W0(@m0 RecyclerView recyclerView, @m0 ArrayList<View> arrayList, int i7, int i8) {
            return false;
        }

        void W1(int i7, int i8) {
            this.f9216q = View.MeasureSpec.getSize(i7);
            int mode = View.MeasureSpec.getMode(i7);
            this.f9214o = mode;
            if (mode == 0 && !RecyclerView.f9064d1) {
                this.f9216q = 0;
            }
            this.f9217r = View.MeasureSpec.getSize(i8);
            int mode2 = View.MeasureSpec.getMode(i8);
            this.f9215p = mode2;
            if (mode2 != 0 || RecyclerView.f9064d1) {
                return;
            }
            this.f9217r = 0;
        }

        public void X(@m0 View view, @m0 Rect rect) {
            RecyclerView.v0(view, rect);
        }

        @c.i
        public void X0(RecyclerView recyclerView) {
        }

        public void X1(int i7, int i8) {
            this.f9201b.setMeasuredDimension(i7, i8);
        }

        public int Y(@m0 View view) {
            return view.getLeft() - j0(view);
        }

        @Deprecated
        public void Y0(RecyclerView recyclerView) {
        }

        public void Y1(Rect rect, int i7, int i8) {
            X1(q(i7, rect.width() + o0() + p0(), l0()), q(i8, rect.height() + r0() + m0(), k0()));
        }

        public int Z(@m0 View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f9115b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        @c.i
        public void Z0(RecyclerView recyclerView, v vVar) {
            Y0(recyclerView);
        }

        void Z1(int i7, int i8) {
            int iQ = Q();
            if (iQ == 0) {
                this.f9201b.G(i7, i8);
                return;
            }
            int i9 = Integer.MIN_VALUE;
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MIN_VALUE;
            int i12 = Integer.MAX_VALUE;
            for (int i13 = 0; i13 < iQ; i13++) {
                View viewP = P(i13);
                Rect rect = this.f9201b.f9096i;
                X(viewP, rect);
                int i14 = rect.left;
                if (i14 < i12) {
                    i12 = i14;
                }
                int i15 = rect.right;
                if (i15 > i9) {
                    i9 = i15;
                }
                int i16 = rect.top;
                if (i16 < i10) {
                    i10 = i16;
                }
                int i17 = rect.bottom;
                if (i17 > i11) {
                    i11 = i17;
                }
            }
            this.f9201b.f9096i.set(i12, i10, i9, i11);
            Y1(this.f9201b.f9096i, i7, i8);
        }

        public int a0(@m0 View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f9115b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        @o0
        public View a1(@m0 View view, int i7, @m0 v vVar, @m0 a0 a0Var) {
            return null;
        }

        public void a2(boolean z7) {
            this.f9210k = z7;
        }

        public int b0(@m0 View view) {
            return view.getRight() + u0(view);
        }

        public void b1(@m0 AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f9201b;
            c1(recyclerView.f9089b, recyclerView.H0, accessibilityEvent);
        }

        void b2(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f9201b = null;
                this.f9200a = null;
                this.f9216q = 0;
                this.f9217r = 0;
            } else {
                this.f9201b = recyclerView;
                this.f9200a = recyclerView.f9092e;
                this.f9216q = recyclerView.getWidth();
                this.f9217r = recyclerView.getHeight();
            }
            this.f9214o = 1073741824;
            this.f9215p = 1073741824;
        }

        public void c(View view) {
            d(view, -1);
        }

        public int c0(@m0 View view) {
            return view.getTop() - x0(view);
        }

        public void c1(@m0 v vVar, @m0 a0 a0Var, @m0 AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z7 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f9201b.canScrollVertically(-1) && !this.f9201b.canScrollHorizontally(-1) && !this.f9201b.canScrollHorizontally(1)) {
                z7 = false;
            }
            accessibilityEvent.setScrollable(z7);
            g gVar = this.f9201b.f9099l;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.e());
            }
        }

        boolean c2(View view, int i7, int i8, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.f9210k && L0(view.getWidth(), i7, ((ViewGroup.MarginLayoutParams) layoutParams).width) && L0(view.getHeight(), i8, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public void d(View view, int i7) {
            g(view, i7, true);
        }

        @o0
        public View d0() {
            View focusedChild;
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f9200a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        void d1(l0 l0Var) {
            RecyclerView recyclerView = this.f9201b;
            e1(recyclerView.f9089b, recyclerView.H0, l0Var);
        }

        boolean d2() {
            return false;
        }

        public void e(View view) {
            f(view, -1);
        }

        @c.r0
        public int e0() {
            return this.f9217r;
        }

        public void e1(@m0 v vVar, @m0 a0 a0Var, @m0 l0 l0Var) {
            if (this.f9201b.canScrollVertically(-1) || this.f9201b.canScrollHorizontally(-1)) {
                l0Var.a(8192);
                l0Var.F1(true);
            }
            if (this.f9201b.canScrollVertically(1) || this.f9201b.canScrollHorizontally(1)) {
                l0Var.a(4096);
                l0Var.F1(true);
            }
            l0Var.Y0(l0.b.f(v0(vVar, a0Var), V(vVar, a0Var), J0(vVar, a0Var), w0(vVar, a0Var)));
        }

        boolean e2(View view, int i7, int i8, LayoutParams layoutParams) {
            return (this.f9210k && L0(view.getMeasuredWidth(), i7, ((ViewGroup.MarginLayoutParams) layoutParams).width) && L0(view.getMeasuredHeight(), i8, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public void f(View view, int i7) {
            g(view, i7, false);
        }

        public int f0() {
            return this.f9215p;
        }

        void f1(View view, l0 l0Var) {
            d0 d0VarT0 = RecyclerView.t0(view);
            if (d0VarT0 == null || d0VarT0.w() || this.f9200a.n(d0VarT0.f9157a)) {
                return;
            }
            RecyclerView recyclerView = this.f9201b;
            g1(recyclerView.f9089b, recyclerView.H0, view, l0Var);
        }

        public void f2(RecyclerView recyclerView, a0 a0Var, int i7) {
            Log.e(RecyclerView.Y0, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int g0() {
            RecyclerView recyclerView = this.f9201b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.e();
            }
            return 0;
        }

        public void g1(@m0 v vVar, @m0 a0 a0Var, @m0 View view, @m0 l0 l0Var) {
            l0Var.Z0(l0.c.h(o() ? s0(view) : 0, 1, n() ? s0(view) : 0, 1, false, false));
        }

        public void g2(z zVar) {
            z zVar2 = this.f9206g;
            if (zVar2 != null && zVar != zVar2 && zVar2.i()) {
                this.f9206g.s();
            }
            this.f9206g = zVar;
            zVar.r(this.f9201b, this);
        }

        public void h(String str) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                recyclerView.v(str);
            }
        }

        public int h0(@m0 View view) {
            return RecyclerView.t0(view).l();
        }

        @o0
        public View h1(@m0 View view, int i7) {
            return null;
        }

        public void h2(@m0 View view) {
            d0 d0VarT0 = RecyclerView.t0(view);
            d0VarT0.L();
            d0VarT0.E();
            d0VarT0.b(4);
        }

        public void i(String str) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                recyclerView.w(str);
            }
        }

        public int i0() {
            return n2.Z(this.f9201b);
        }

        public void i1(@m0 RecyclerView recyclerView, int i7, int i8) {
        }

        void i2() {
            z zVar = this.f9206g;
            if (zVar != null) {
                zVar.s();
            }
        }

        public void j(@m0 View view) {
            k(view, -1);
        }

        public int j0(@m0 View view) {
            return ((LayoutParams) view.getLayoutParams()).f9115b.left;
        }

        public void j1(@m0 RecyclerView recyclerView) {
        }

        public boolean j2() {
            return false;
        }

        public void k(@m0 View view, int i7) {
            l(view, i7, (LayoutParams) view.getLayoutParams());
        }

        @c.r0
        public int k0() {
            return n2.e0(this.f9201b);
        }

        public void k1(@m0 RecyclerView recyclerView, int i7, int i8, int i9) {
        }

        public void l(@m0 View view, int i7, LayoutParams layoutParams) {
            d0 d0VarT0 = RecyclerView.t0(view);
            if (d0VarT0.w()) {
                this.f9201b.f9093f.b(d0VarT0);
            } else {
                this.f9201b.f9093f.p(d0VarT0);
            }
            this.f9200a.c(view, i7, layoutParams, d0VarT0.w());
        }

        @c.r0
        public int l0() {
            return n2.f0(this.f9201b);
        }

        public void l1(@m0 RecyclerView recyclerView, int i7, int i8) {
        }

        public void m(@m0 View view, @m0 Rect rect) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.y0(view));
            }
        }

        @c.r0
        public int m0() {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public void m1(@m0 RecyclerView recyclerView, int i7, int i8) {
        }

        public boolean n() {
            return false;
        }

        @c.r0
        public int n0() {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                return n2.j0(recyclerView);
            }
            return 0;
        }

        public void n1(@m0 RecyclerView recyclerView, int i7, int i8, @o0 Object obj) {
            m1(recyclerView, i7, i8);
        }

        public boolean o() {
            return false;
        }

        @c.r0
        public int o0() {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void o1(v vVar, a0 a0Var) {
            Log.e(RecyclerView.Y0, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public boolean p(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        @c.r0
        public int p0() {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void p1(a0 a0Var) {
        }

        @c.r0
        public int q0() {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                return n2.k0(recyclerView);
            }
            return 0;
        }

        public void q1(@m0 v vVar, @m0 a0 a0Var, int i7, int i8) {
            this.f9201b.G(i7, i8);
        }

        public void r(int i7, int i8, a0 a0Var, c cVar) {
        }

        @c.r0
        public int r0() {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        @Deprecated
        public boolean r1(@m0 RecyclerView recyclerView, @m0 View view, @o0 View view2) {
            return M0() || recyclerView.M0();
        }

        public void s(int i7, c cVar) {
        }

        public int s0(@m0 View view) {
            return ((LayoutParams) view.getLayoutParams()).b();
        }

        public boolean s1(@m0 RecyclerView recyclerView, @m0 a0 a0Var, @m0 View view, @o0 View view2) {
            return r1(recyclerView, view, view2);
        }

        public int t(@m0 a0 a0Var) {
            return 0;
        }

        public void t1(Parcelable parcelable) {
        }

        public int u(@m0 a0 a0Var) {
            return 0;
        }

        public int u0(@m0 View view) {
            return ((LayoutParams) view.getLayoutParams()).f9115b.right;
        }

        @o0
        public Parcelable u1() {
            return null;
        }

        public int v(@m0 a0 a0Var) {
            return 0;
        }

        public int v0(@m0 v vVar, @m0 a0 a0Var) {
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView == null || recyclerView.f9099l == null || !o()) {
                return 1;
            }
            return this.f9201b.f9099l.e();
        }

        public void v1(int i7) {
        }

        public int w(@m0 a0 a0Var) {
            return 0;
        }

        public int w0(@m0 v vVar, @m0 a0 a0Var) {
            return 0;
        }

        void w1(z zVar) {
            if (this.f9206g == zVar) {
                this.f9206g = null;
            }
        }

        public int x(@m0 a0 a0Var) {
            return 0;
        }

        public int x0(@m0 View view) {
            return ((LayoutParams) view.getLayoutParams()).f9115b.top;
        }

        boolean x1(int i7, @o0 Bundle bundle) {
            RecyclerView recyclerView = this.f9201b;
            return y1(recyclerView.f9089b, recyclerView.H0, i7, bundle);
        }

        public int y(@m0 a0 a0Var) {
            return 0;
        }

        public void y0(@m0 View view, boolean z7, @m0 Rect rect) {
            Matrix matrix;
            if (z7) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f9115b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f9201b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f9201b.f9098k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0071 A[PHI: r8
          0x0071: PHI (r8v8 int) = (r8v4 int), (r8v12 int) binds: [B:22:0x005e, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        public boolean y1(@m0 v vVar, @m0 a0 a0Var, int i7, @o0 Bundle bundle) {
            int iE0;
            int iZ0;
            int i8;
            int i9;
            RecyclerView recyclerView = this.f9201b;
            if (recyclerView == null) {
                return false;
            }
            if (i7 == 4096) {
                iE0 = recyclerView.canScrollVertically(1) ? (e0() - r0()) - m0() : 0;
                if (this.f9201b.canScrollHorizontally(1)) {
                    iZ0 = (z0() - o0()) - p0();
                    i8 = iE0;
                    i9 = iZ0;
                } else {
                    i8 = iE0;
                    i9 = 0;
                }
            } else if (i7 != 8192) {
                i9 = 0;
                i8 = 0;
            } else {
                iE0 = recyclerView.canScrollVertically(-1) ? -((e0() - r0()) - m0()) : 0;
                if (this.f9201b.canScrollHorizontally(-1)) {
                    iZ0 = -((z0() - o0()) - p0());
                    i8 = iE0;
                    i9 = iZ0;
                } else {
                    i8 = iE0;
                    i9 = 0;
                }
            }
            if (i8 == 0 && i9 == 0) {
                return false;
            }
            this.f9201b.J1(i9, i8, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void z(@m0 v vVar) {
            for (int iQ = Q() - 1; iQ >= 0; iQ--) {
                P1(vVar, iQ, P(iQ));
            }
        }

        @c.r0
        public int z0() {
            return this.f9216q;
        }

        boolean z1(@m0 View view, int i7, @o0 Bundle bundle) {
            RecyclerView recyclerView = this.f9201b;
            return A1(recyclerView.f9089b, recyclerView.H0, view, i7, bundle);
        }
    }

    public interface p {
        void b(@m0 View view);

        void d(@m0 View view);
    }

    public static abstract class q {
        public abstract boolean a(int i7, int i8);
    }

    public interface r {
        void a(@m0 RecyclerView recyclerView, @m0 MotionEvent motionEvent);

        boolean c(@m0 RecyclerView recyclerView, @m0 MotionEvent motionEvent);

        void e(boolean z7);
    }

    public static abstract class s {
        public void a(@m0 RecyclerView recyclerView, int i7) {
        }

        public void b(@m0 RecyclerView recyclerView, int i7, int i8) {
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface t {
    }

    public static class u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f9224c = 5;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<a> f9225a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9226b = 0;

        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ArrayList<d0> f9227a = new ArrayList<>();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f9228b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f9229c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f9230d = 0;

            a() {
            }
        }

        private a h(int i7) {
            a aVar = this.f9225a.get(i7);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f9225a.put(i7, aVar2);
            return aVar2;
        }

        void a() {
            this.f9226b++;
        }

        public void b() {
            for (int i7 = 0; i7 < this.f9225a.size(); i7++) {
                this.f9225a.valueAt(i7).f9227a.clear();
            }
        }

        void c() {
            this.f9226b--;
        }

        void d(int i7, long j7) {
            a aVarH = h(i7);
            aVarH.f9230d = k(aVarH.f9230d, j7);
        }

        void e(int i7, long j7) {
            a aVarH = h(i7);
            aVarH.f9229c = k(aVarH.f9229c, j7);
        }

        @o0
        public d0 f(int i7) {
            a aVar = this.f9225a.get(i7);
            if (aVar == null || aVar.f9227a.isEmpty()) {
                return null;
            }
            ArrayList<d0> arrayList = aVar.f9227a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).s()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public int g(int i7) {
            return h(i7).f9227a.size();
        }

        void i(g gVar, g gVar2, boolean z7) {
            if (gVar != null) {
                c();
            }
            if (!z7 && this.f9226b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void j(d0 d0Var) {
            int iL = d0Var.l();
            ArrayList<d0> arrayList = h(iL).f9227a;
            if (this.f9225a.get(iL).f9228b <= arrayList.size()) {
                return;
            }
            d0Var.E();
            arrayList.add(d0Var);
        }

        long k(long j7, long j8) {
            return j7 == 0 ? j8 : ((j7 / 4) * 3) + (j8 / 4);
        }

        public void l(int i7, int i8) {
            a aVarH = h(i7);
            aVarH.f9228b = i8;
            ArrayList<d0> arrayList = aVarH.f9227a;
            while (arrayList.size() > i8) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        int m() {
            int size = 0;
            for (int i7 = 0; i7 < this.f9225a.size(); i7++) {
                ArrayList<d0> arrayList = this.f9225a.valueAt(i7).f9227a;
                if (arrayList != null) {
                    size += arrayList.size();
                }
            }
            return size;
        }

        boolean n(int i7, long j7, long j8) {
            long j9 = h(i7).f9230d;
            return j9 == 0 || j7 + j9 < j8;
        }

        boolean o(int i7, long j7, long j8) {
            long j9 = h(i7).f9229c;
            return j9 == 0 || j7 + j9 < j8;
        }
    }

    public final class v {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f9231j = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList<d0> f9232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<d0> f9233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList<d0> f9234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<d0> f9235d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f9236e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9237f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        u f9238g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private b0 f9239h;

        public v() {
            ArrayList<d0> arrayList = new ArrayList<>();
            this.f9232a = arrayList;
            this.f9233b = null;
            this.f9234c = new ArrayList<>();
            this.f9235d = Collections.unmodifiableList(arrayList);
            this.f9236e = 2;
            this.f9237f = 2;
        }

        private boolean I(@m0 d0 d0Var, int i7, int i8, long j7) {
            d0Var.f9174r = RecyclerView.this;
            int iL = d0Var.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j7 != Long.MAX_VALUE && !this.f9238g.n(iL, nanoTime, j7)) {
                return false;
            }
            RecyclerView.this.f9099l.c(d0Var, i7);
            this.f9238g.d(d0Var.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d0Var);
            if (!RecyclerView.this.H0.j()) {
                return true;
            }
            d0Var.f9163g = i8;
            return true;
        }

        private void b(d0 d0Var) {
            if (RecyclerView.this.K0()) {
                View view = d0Var.f9157a;
                if (n2.V(view) == 0) {
                    n2.R1(view, 1);
                }
                androidx.recyclerview.widget.y yVar = RecyclerView.this.O0;
                if (yVar == null) {
                    return;
                }
                androidx.core.view.a aVarN = yVar.n();
                if (aVarN instanceof androidx.recyclerview.widget.y.a) {
                    ((androidx.recyclerview.widget.y.a) aVarN).o(view);
                }
                n2.B1(view, aVarN);
            }
        }

        private void r(ViewGroup viewGroup, boolean z7) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    r((ViewGroup) childAt, true);
                }
            }
            if (z7) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void s(d0 d0Var) {
            View view = d0Var.f9157a;
            if (view instanceof ViewGroup) {
                r((ViewGroup) view, false);
            }
        }

        void A() {
            for (int size = this.f9234c.size() - 1; size >= 0; size--) {
                B(size);
            }
            this.f9234c.clear();
            if (RecyclerView.f9066f1) {
                RecyclerView.this.G0.b();
            }
        }

        void B(int i7) {
            a(this.f9234c.get(i7), true);
            this.f9234c.remove(i7);
        }

        public void C(@m0 View view) {
            d0 d0VarT0 = RecyclerView.t0(view);
            if (d0VarT0.y()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (d0VarT0.x()) {
                d0VarT0.M();
            } else if (d0VarT0.N()) {
                d0VarT0.e();
            }
            D(d0VarT0);
            if (RecyclerView.this.M == null || d0VarT0.v()) {
                return;
            }
            RecyclerView.this.M.k(d0VarT0);
        }

        void D(d0 d0Var) {
            boolean z7;
            boolean z8 = false;
            boolean z9 = true;
            if (d0Var.x() || d0Var.f9157a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d0Var.x());
                sb.append(" isAttached:");
                sb.append(d0Var.f9157a.getParent() != null);
                sb.append(RecyclerView.this.X());
                throw new IllegalArgumentException(sb.toString());
            }
            if (d0Var.y()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.X());
            }
            if (d0Var.K()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.X());
            }
            boolean zH = d0Var.h();
            g gVar = RecyclerView.this.f9099l;
            if ((gVar != null && zH && gVar.y(d0Var)) || d0Var.v()) {
                if (this.f9237f <= 0 || d0Var.q(526)) {
                    z7 = false;
                } else {
                    int size = this.f9234c.size();
                    if (size >= this.f9237f && size > 0) {
                        B(0);
                        size--;
                    }
                    if (RecyclerView.f9066f1 && size > 0 && !RecyclerView.this.G0.d(d0Var.f9159c)) {
                        int i7 = size - 1;
                        while (i7 >= 0) {
                            if (!RecyclerView.this.G0.d(this.f9234c.get(i7).f9159c)) {
                                break;
                            } else {
                                i7--;
                            }
                        }
                        size = i7 + 1;
                    }
                    this.f9234c.add(size, d0Var);
                    z7 = true;
                }
                if (z7) {
                    z9 = false;
                } else {
                    a(d0Var, true);
                }
                z8 = z7;
            } else {
                z9 = false;
            }
            RecyclerView.this.f9093f.q(d0Var);
            if (z8 || z9 || !zH) {
                return;
            }
            d0Var.f9174r = null;
        }

        void E(View view) {
            d0 d0VarT0 = RecyclerView.t0(view);
            if (!d0VarT0.q(12) && d0VarT0.z() && !RecyclerView.this.x(d0VarT0)) {
                if (this.f9233b == null) {
                    this.f9233b = new ArrayList<>();
                }
                d0VarT0.I(this, true);
                this.f9233b.add(d0VarT0);
                return;
            }
            if (!d0VarT0.u() || d0VarT0.w() || RecyclerView.this.f9099l.i()) {
                d0VarT0.I(this, false);
                this.f9232a.add(d0VarT0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.X());
            }
        }

        void F(u uVar) {
            u uVar2 = this.f9238g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f9238g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f9238g.a();
        }

        void G(b0 b0Var) {
            this.f9239h = b0Var;
        }

        public void H(int i7) {
            this.f9236e = i7;
            L();
        }

        /* JADX WARN: Code duplicated, block: B:100:0x020c  */
        /* JADX WARN: Code duplicated, block: B:102:0x0214  */
        /* JADX WARN: Code duplicated, block: B:103:0x0222  */
        /* JADX WARN: Code duplicated, block: B:106:0x0228 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:108:0x022b  */
        /* JADX WARN: Code duplicated, block: B:18:0x0037 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:19:0x0039  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:22:0x004e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0054  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x005f  */
        /* JADX WARN: Code duplicated, block: B:73:0x0181 A[PHI: r1 r4
          0x0181: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$d0) = (r1v11 androidx.recyclerview.widget.RecyclerView$d0), (r1v31 androidx.recyclerview.widget.RecyclerView$d0) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]
          0x0181: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:82:0x01a2  */
        /* JADX WARN: Code duplicated, block: B:88:0x01ce  */
        /* JADX WARN: Code duplicated, block: B:90:0x01d4  */
        /* JADX WARN: Code duplicated, block: B:99:0x01fe  */
        @o0
        d0 J(int i7, boolean z7, long j7) {
            d0 d0VarS0;
            boolean z8;
            d0 d0Var;
            boolean z9;
            boolean zI;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            int iN;
            RecyclerView recyclerViewE0;
            b0 b0Var;
            View viewA;
            if (i7 < 0 || i7 >= RecyclerView.this.H0.d()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i7 + "(" + i7 + "). Item count:" + RecyclerView.this.H0.d() + RecyclerView.this.X());
            }
            if (RecyclerView.this.H0.j()) {
                d0VarS0 = i(i7);
                if (d0VarS0 != null) {
                    z8 = true;
                }
                if (d0VarS0 == null && (d0VarS0 = n(i7, z7)) != null) {
                    if (M(d0VarS0)) {
                        z8 = true;
                    } else {
                        if (!z7) {
                            d0VarS0.b(4);
                            if (d0VarS0.x()) {
                                RecyclerView.this.removeDetachedView(d0VarS0.f9157a, false);
                                d0VarS0.M();
                            } else if (d0VarS0.N()) {
                                d0VarS0.e();
                            }
                            D(d0VarS0);
                        }
                        d0VarS0 = null;
                    }
                }
                if (d0VarS0 == null) {
                    d0Var = d0VarS0;
                } else {
                    iN = RecyclerView.this.f9091d.n(i7);
                    if (iN >= 0 || iN >= RecyclerView.this.f9099l.e()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i7 + "(offset:" + iN + ").state:" + RecyclerView.this.H0.d() + RecyclerView.this.X());
                    }
                    int iG = RecyclerView.this.f9099l.g(iN);
                    if (RecyclerView.this.f9099l.i() && (d0VarS0 = m(RecyclerView.this.f9099l.f(iN), iG, z7)) != null) {
                        d0VarS0.f9159c = iN;
                        z8 = true;
                    }
                    if (d0VarS0 == null && (b0Var = this.f9239h) != null && (viewA = b0Var.a(this, i7, iG)) != null) {
                        d0VarS0 = RecyclerView.this.s0(viewA);
                        if (d0VarS0 == null) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.X());
                        }
                        if (d0VarS0.K()) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.X());
                        }
                    }
                    if (d0VarS0 == null) {
                        d0 d0VarF = j().f(iG);
                        if (d0VarF != null) {
                            d0VarF.E();
                            if (RecyclerView.f9063c1) {
                                s(d0VarF);
                            }
                        }
                        d0VarS0 = d0VarF;
                    }
                    if (d0VarS0 == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j7 != Long.MAX_VALUE && !this.f9238g.o(iG, nanoTime, j7)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        d0 d0VarD = recyclerView.f9099l.d(recyclerView, iG);
                        if (RecyclerView.f9066f1 && (recyclerViewE0 = RecyclerView.e0(d0VarD.f9157a)) != null) {
                            d0VarD.f9158b = new WeakReference<>(recyclerViewE0);
                        }
                        this.f9238g.e(iG, RecyclerView.this.getNanoTime() - nanoTime);
                        d0Var = d0VarD;
                    } else {
                        d0Var = d0VarS0;
                    }
                }
                z9 = z8;
                if (z9 && !RecyclerView.this.H0.j() && d0Var.q(8192)) {
                    d0Var.G(0, 8192);
                    if (RecyclerView.this.H0.f9133k) {
                        int iE = l.e(d0Var) | 4096;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.k1(d0Var, recyclerView2.M.w(recyclerView2.H0, d0Var, iE, d0Var.p()));
                    }
                }
                if (RecyclerView.this.H0.j() || !d0Var.t()) {
                    if (d0Var.t() || d0Var.A() || d0Var.u()) {
                        zI = I(d0Var, RecyclerView.this.f9091d.n(i7), i7, j7);
                    }
                    layoutParams = d0Var.f9157a.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                        d0Var.f9157a.setLayoutParams(layoutParams2);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        layoutParams2 = (LayoutParams) layoutParams;
                    } else {
                        layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                        d0Var.f9157a.setLayoutParams(layoutParams2);
                    }
                    layoutParams2.f9114a = d0Var;
                    layoutParams2.f9117d = !z9 && zI;
                    return d0Var;
                }
                d0Var.f9163g = i7;
                zI = false;
                layoutParams = d0Var.f9157a.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                    d0Var.f9157a.setLayoutParams(layoutParams2);
                } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                    layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                    d0Var.f9157a.setLayoutParams(layoutParams2);
                } else {
                    layoutParams2 = (LayoutParams) layoutParams;
                }
                layoutParams2.f9114a = d0Var;
                layoutParams2.f9117d = !z9 && zI;
                return d0Var;
            }
            d0VarS0 = null;
            z8 = false;
            if (d0VarS0 == null) {
                if (M(d0VarS0)) {
                    if (!z7) {
                        d0VarS0.b(4);
                        if (d0VarS0.x()) {
                            RecyclerView.this.removeDetachedView(d0VarS0.f9157a, false);
                            d0VarS0.M();
                        } else if (d0VarS0.N()) {
                            d0VarS0.e();
                        }
                        D(d0VarS0);
                    }
                    d0VarS0 = null;
                } else {
                    z8 = true;
                }
            }
            if (d0VarS0 == null) {
                iN = RecyclerView.this.f9091d.n(i7);
                if (iN >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i7 + "(offset:" + iN + ").state:" + RecyclerView.this.H0.d() + RecyclerView.this.X());
            }
            d0Var = d0VarS0;
            z9 = z8;
            if (z9) {
                d0Var.G(0, 8192);
                if (RecyclerView.this.H0.f9133k) {
                    int iE2 = l.e(d0Var) | 4096;
                    RecyclerView recyclerView3 = RecyclerView.this;
                    RecyclerView.this.k1(d0Var, recyclerView3.M.w(recyclerView3.H0, d0Var, iE2, d0Var.p()));
                }
            }
            if (RecyclerView.this.H0.j()) {
                if (d0Var.t()) {
                }
                zI = I(d0Var, RecyclerView.this.f9091d.n(i7), i7, j7);
            } else {
                if (d0Var.t()) {
                }
                zI = I(d0Var, RecyclerView.this.f9091d.n(i7), i7, j7);
            }
            layoutParams = d0Var.f9157a.getLayoutParams();
            if (layoutParams == null) {
                layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                d0Var.f9157a.setLayoutParams(layoutParams2);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                d0Var.f9157a.setLayoutParams(layoutParams2);
            } else {
                layoutParams2 = (LayoutParams) layoutParams;
            }
            layoutParams2.f9114a = d0Var;
            layoutParams2.f9117d = !z9 && zI;
            return d0Var;
        }

        void K(d0 d0Var) {
            if (d0Var.f9171o) {
                this.f9233b.remove(d0Var);
            } else {
                this.f9232a.remove(d0Var);
            }
            d0Var.f9170n = null;
            d0Var.f9171o = false;
            d0Var.e();
        }

        void L() {
            o oVar = RecyclerView.this.f9100m;
            this.f9237f = this.f9236e + (oVar != null ? oVar.f9212m : 0);
            for (int size = this.f9234c.size() - 1; size >= 0 && this.f9234c.size() > this.f9237f; size--) {
                B(size);
            }
        }

        boolean M(d0 d0Var) {
            if (d0Var.w()) {
                return RecyclerView.this.H0.j();
            }
            int i7 = d0Var.f9159c;
            if (i7 >= 0 && i7 < RecyclerView.this.f9099l.e()) {
                if (RecyclerView.this.H0.j() || RecyclerView.this.f9099l.g(d0Var.f9159c) == d0Var.l()) {
                    return !RecyclerView.this.f9099l.i() || d0Var.k() == RecyclerView.this.f9099l.f(d0Var.f9159c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.X());
        }

        void N(int i7, int i8) {
            int i9;
            int i10 = i8 + i7;
            for (int size = this.f9234c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f9234c.get(size);
                if (d0Var != null && (i9 = d0Var.f9159c) >= i7 && i9 < i10) {
                    d0Var.b(2);
                    B(size);
                }
            }
        }

        void a(@m0 d0 d0Var, boolean z7) {
            RecyclerView.z(d0Var);
            View view = d0Var.f9157a;
            androidx.recyclerview.widget.y yVar = RecyclerView.this.O0;
            if (yVar != null) {
                androidx.core.view.a aVarN = yVar.n();
                n2.B1(view, aVarN instanceof androidx.recyclerview.widget.y.a ? ((androidx.recyclerview.widget.y.a) aVarN).n(view) : null);
            }
            if (z7) {
                h(d0Var);
            }
            d0Var.f9174r = null;
            j().j(d0Var);
        }

        public void c(@m0 View view, int i7) {
            LayoutParams layoutParams;
            d0 d0VarT0 = RecyclerView.t0(view);
            if (d0VarT0 == null) {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.X());
            }
            int iN = RecyclerView.this.f9091d.n(i7);
            if (iN < 0 || iN >= RecyclerView.this.f9099l.e()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i7 + "(offset:" + iN + ").state:" + RecyclerView.this.H0.d() + RecyclerView.this.X());
            }
            I(d0VarT0, iN, i7, Long.MAX_VALUE);
            ViewGroup.LayoutParams layoutParams2 = d0VarT0.f9157a.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                d0VarT0.f9157a.setLayoutParams(layoutParams);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) layoutParams2;
            } else {
                layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                d0VarT0.f9157a.setLayoutParams(layoutParams);
            }
            layoutParams.f9116c = true;
            layoutParams.f9114a = d0VarT0;
            layoutParams.f9117d = d0VarT0.f9157a.getParent() == null;
        }

        public void d() {
            this.f9232a.clear();
            A();
        }

        void e() {
            int size = this.f9234c.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f9234c.get(i7).c();
            }
            int size2 = this.f9232a.size();
            for (int i8 = 0; i8 < size2; i8++) {
                this.f9232a.get(i8).c();
            }
            ArrayList<d0> arrayList = this.f9233b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i9 = 0; i9 < size3; i9++) {
                    this.f9233b.get(i9).c();
                }
            }
        }

        void f() {
            this.f9232a.clear();
            ArrayList<d0> arrayList = this.f9233b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int g(int i7) {
            if (i7 >= 0 && i7 < RecyclerView.this.H0.d()) {
                return !RecyclerView.this.H0.j() ? i7 : RecyclerView.this.f9091d.n(i7);
            }
            throw new IndexOutOfBoundsException("invalid position " + i7 + ". State item count is " + RecyclerView.this.H0.d() + RecyclerView.this.X());
        }

        void h(@m0 d0 d0Var) {
            w wVar = RecyclerView.this.f9101n;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            g gVar = RecyclerView.this.f9099l;
            if (gVar != null) {
                gVar.B(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.H0 != null) {
                recyclerView.f9093f.q(d0Var);
            }
        }

        d0 i(int i7) {
            int size;
            int iN;
            ArrayList<d0> arrayList = this.f9233b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i8 = 0; i8 < size; i8++) {
                    d0 d0Var = this.f9233b.get(i8);
                    if (!d0Var.N() && d0Var.m() == i7) {
                        d0Var.b(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.f9099l.i() && (iN = RecyclerView.this.f9091d.n(i7)) > 0 && iN < RecyclerView.this.f9099l.e()) {
                    long jF = RecyclerView.this.f9099l.f(iN);
                    for (int i9 = 0; i9 < size; i9++) {
                        d0 d0Var2 = this.f9233b.get(i9);
                        if (!d0Var2.N() && d0Var2.k() == jF) {
                            d0Var2.b(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        u j() {
            if (this.f9238g == null) {
                this.f9238g = new u();
            }
            return this.f9238g;
        }

        int k() {
            return this.f9232a.size();
        }

        @m0
        public List<d0> l() {
            return this.f9235d;
        }

        d0 m(long j7, int i7, boolean z7) {
            for (int size = this.f9232a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f9232a.get(size);
                if (d0Var.k() == j7 && !d0Var.N()) {
                    if (i7 == d0Var.l()) {
                        d0Var.b(32);
                        if (d0Var.w() && !RecyclerView.this.H0.j()) {
                            d0Var.G(2, 14);
                        }
                        return d0Var;
                    }
                    if (!z7) {
                        this.f9232a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f9157a, false);
                        z(d0Var.f9157a);
                    }
                }
            }
            int size2 = this.f9234c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.f9234c.get(size2);
                if (d0Var2.k() == j7 && !d0Var2.s()) {
                    if (i7 == d0Var2.l()) {
                        if (!z7) {
                            this.f9234c.remove(size2);
                        }
                        return d0Var2;
                    }
                    if (!z7) {
                        B(size2);
                        return null;
                    }
                }
            }
        }

        d0 n(int i7, boolean z7) {
            View viewE;
            int size = this.f9232a.size();
            for (int i8 = 0; i8 < size; i8++) {
                d0 d0Var = this.f9232a.get(i8);
                if (!d0Var.N() && d0Var.m() == i7 && !d0Var.u() && (RecyclerView.this.H0.f9130h || !d0Var.w())) {
                    d0Var.b(32);
                    return d0Var;
                }
            }
            if (z7 || (viewE = RecyclerView.this.f9092e.e(i7)) == null) {
                int size2 = this.f9234c.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    d0 d0Var2 = this.f9234c.get(i9);
                    if (!d0Var2.u() && d0Var2.m() == i7 && !d0Var2.s()) {
                        if (!z7) {
                            this.f9234c.remove(i9);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 d0VarT0 = RecyclerView.t0(viewE);
            RecyclerView.this.f9092e.s(viewE);
            int iM = RecyclerView.this.f9092e.m(viewE);
            if (iM != -1) {
                RecyclerView.this.f9092e.d(iM);
                E(viewE);
                d0VarT0.b(8224);
                return d0VarT0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + d0VarT0 + RecyclerView.this.X());
        }

        View o(int i7) {
            return this.f9232a.get(i7).f9157a;
        }

        @m0
        public View p(int i7) {
            return q(i7, false);
        }

        View q(int i7, boolean z7) {
            return J(i7, z7, Long.MAX_VALUE).f9157a;
        }

        void t() {
            int size = this.f9234c.size();
            for (int i7 = 0; i7 < size; i7++) {
                LayoutParams layoutParams = (LayoutParams) this.f9234c.get(i7).f9157a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f9116c = true;
                }
            }
        }

        void u() {
            int size = this.f9234c.size();
            for (int i7 = 0; i7 < size; i7++) {
                d0 d0Var = this.f9234c.get(i7);
                if (d0Var != null) {
                    d0Var.b(6);
                    d0Var.a(null);
                }
            }
            g gVar = RecyclerView.this.f9099l;
            if (gVar == null || !gVar.i()) {
                A();
            }
        }

        void v(int i7, int i8) {
            int size = this.f9234c.size();
            for (int i9 = 0; i9 < size; i9++) {
                d0 d0Var = this.f9234c.get(i9);
                if (d0Var != null && d0Var.f9159c >= i7) {
                    d0Var.B(i8, true);
                }
            }
        }

        void w(int i7, int i8) {
            int i9;
            int i10;
            int i11;
            int i12;
            if (i7 < i8) {
                i9 = -1;
                i11 = i7;
                i10 = i8;
            } else {
                i9 = 1;
                i10 = i7;
                i11 = i8;
            }
            int size = this.f9234c.size();
            for (int i13 = 0; i13 < size; i13++) {
                d0 d0Var = this.f9234c.get(i13);
                if (d0Var != null && (i12 = d0Var.f9159c) >= i11 && i12 <= i10) {
                    if (i12 == i7) {
                        d0Var.B(i8 - i7, false);
                    } else {
                        d0Var.B(i9, false);
                    }
                }
            }
        }

        void x(int i7, int i8, boolean z7) {
            int i9 = i7 + i8;
            for (int size = this.f9234c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f9234c.get(size);
                if (d0Var != null) {
                    int i10 = d0Var.f9159c;
                    if (i10 >= i9) {
                        d0Var.B(-i8, z7);
                    } else if (i10 >= i7) {
                        d0Var.b(8);
                        B(size);
                    }
                }
            }
        }

        void y(g gVar, g gVar2, boolean z7) {
            d();
            j().i(gVar, gVar2, z7);
        }

        void z(View view) {
            d0 d0VarT0 = RecyclerView.t0(view);
            d0VarT0.f9170n = null;
            d0VarT0.f9171o = false;
            d0VarT0.e();
            D(d0VarT0);
        }
    }

    public interface w {
        void a(@m0 d0 d0Var);
    }

    private class x extends i {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.w(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.H0.f9129g = true;
            recyclerView.i1(true);
            if (RecyclerView.this.f9091d.q()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i7, int i8, Object obj) {
            RecyclerView.this.w(null);
            if (RecyclerView.this.f9091d.s(i7, i8, obj)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i7, int i8) {
            RecyclerView.this.w(null);
            if (RecyclerView.this.f9091d.t(i7, i8)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i7, int i8, int i9) {
            RecyclerView.this.w(null);
            if (RecyclerView.this.f9091d.u(i7, i8, i9)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i7, int i8) {
            RecyclerView.this.w(null);
            if (RecyclerView.this.f9091d.v(i7, i8)) {
                g();
            }
        }

        void g() {
            if (RecyclerView.f9065e1) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f9106s && recyclerView.f9105r) {
                    n2.p1(recyclerView, recyclerView.f9095h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.A = true;
            recyclerView2.requestLayout();
        }
    }

    public static class y implements r {
        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void a(@m0 RecyclerView recyclerView, @m0 MotionEvent motionEvent) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public boolean c(@m0 RecyclerView recyclerView, @m0 MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void e(boolean z7) {
        }
    }

    public static abstract class z {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView f9243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private o f9244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f9246e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f9247f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f9249h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9242a = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a f9248g = new a(0, 0);

        public static class a {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f9250h = Integer.MIN_VALUE;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f9251a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f9252b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f9253c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f9254d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Interpolator f9255e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f9256f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f9257g;

            public a(@c.r0 int i7, @c.r0 int i8) {
                this(i7, i8, Integer.MIN_VALUE, null);
            }

            private void m() {
                if (this.f9255e != null && this.f9253c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f9253c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public int a() {
                return this.f9253c;
            }

            @c.r0
            public int b() {
                return this.f9251a;
            }

            @c.r0
            public int c() {
                return this.f9252b;
            }

            @o0
            public Interpolator d() {
                return this.f9255e;
            }

            boolean e() {
                return this.f9254d >= 0;
            }

            public void f(int i7) {
                this.f9254d = i7;
            }

            void g(RecyclerView recyclerView) {
                int i7 = this.f9254d;
                if (i7 >= 0) {
                    this.f9254d = -1;
                    recyclerView.P0(i7);
                    this.f9256f = false;
                } else {
                    if (!this.f9256f) {
                        this.f9257g = 0;
                        return;
                    }
                    m();
                    recyclerView.E0.f(this.f9251a, this.f9252b, this.f9253c, this.f9255e);
                    int i8 = this.f9257g + 1;
                    this.f9257g = i8;
                    if (i8 > 10) {
                        Log.e(RecyclerView.Y0, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f9256f = false;
                }
            }

            public void h(int i7) {
                this.f9256f = true;
                this.f9253c = i7;
            }

            public void i(@c.r0 int i7) {
                this.f9256f = true;
                this.f9251a = i7;
            }

            public void j(@c.r0 int i7) {
                this.f9256f = true;
                this.f9252b = i7;
            }

            public void k(@o0 Interpolator interpolator) {
                this.f9256f = true;
                this.f9255e = interpolator;
            }

            public void l(@c.r0 int i7, @c.r0 int i8, int i9, @o0 Interpolator interpolator) {
                this.f9251a = i7;
                this.f9252b = i8;
                this.f9253c = i9;
                this.f9255e = interpolator;
                this.f9256f = true;
            }

            public a(@c.r0 int i7, @c.r0 int i8, int i9) {
                this(i7, i8, i9, null);
            }

            public a(@c.r0 int i7, @c.r0 int i8, int i9, @o0 Interpolator interpolator) {
                this.f9254d = -1;
                this.f9256f = false;
                this.f9257g = 0;
                this.f9251a = i7;
                this.f9252b = i8;
                this.f9253c = i9;
                this.f9255e = interpolator;
            }
        }

        public interface b {
            @o0
            PointF a(int i7);
        }

        @o0
        public PointF a(int i7) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).a(i7);
            }
            Log.w(RecyclerView.Y0, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i7) {
            return this.f9243b.f9100m.J(i7);
        }

        public int c() {
            return this.f9243b.f9100m.Q();
        }

        public int d(View view) {
            return this.f9243b.q0(view);
        }

        @o0
        public o e() {
            return this.f9244c;
        }

        public int f() {
            return this.f9242a;
        }

        @Deprecated
        public void g(int i7) {
            this.f9243b.C1(i7);
        }

        public boolean h() {
            return this.f9245d;
        }

        public boolean i() {
            return this.f9246e;
        }

        protected void j(@m0 PointF pointF) {
            float f8 = pointF.x;
            float f9 = pointF.y;
            float fSqrt = (float) Math.sqrt((f8 * f8) + (f9 * f9));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        void k(int i7, int i8) {
            PointF pointFA;
            RecyclerView recyclerView = this.f9243b;
            if (this.f9242a == -1 || recyclerView == null) {
                s();
            }
            if (this.f9245d && this.f9247f == null && this.f9244c != null && (pointFA = a(this.f9242a)) != null) {
                float f8 = pointFA.x;
                if (f8 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.B1((int) Math.signum(f8), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f9245d = false;
            View view = this.f9247f;
            if (view != null) {
                if (d(view) == this.f9242a) {
                    p(this.f9247f, recyclerView.H0, this.f9248g);
                    this.f9248g.g(recyclerView);
                    s();
                } else {
                    Log.e(RecyclerView.Y0, "Passed over target position while smooth scrolling.");
                    this.f9247f = null;
                }
            }
            if (this.f9246e) {
                m(i7, i8, recyclerView.H0, this.f9248g);
                boolean zE = this.f9248g.e();
                this.f9248g.g(recyclerView);
                if (zE && this.f9246e) {
                    this.f9245d = true;
                    recyclerView.E0.e();
                }
            }
        }

        protected void l(View view) {
            if (d(view) == f()) {
                this.f9247f = view;
            }
        }

        protected abstract void m(@c.r0 int i7, @c.r0 int i8, @m0 a0 a0Var, @m0 a aVar);

        protected abstract void n();

        protected abstract void o();

        protected abstract void p(@m0 View view, @m0 a0 a0Var, @m0 a aVar);

        public void q(int i7) {
            this.f9242a = i7;
        }

        void r(RecyclerView recyclerView, o oVar) {
            recyclerView.E0.g();
            if (this.f9249h) {
                Log.w(RecyclerView.Y0, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f9243b = recyclerView;
            this.f9244c = oVar;
            int i7 = this.f9242a;
            if (i7 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.H0.f9123a = i7;
            this.f9246e = true;
            this.f9245d = true;
            this.f9247f = b(f());
            n();
            this.f9243b.E0.e();
            this.f9249h = true;
        }

        protected final void s() {
            if (this.f9246e) {
                this.f9246e = false;
                o();
                this.f9243b.H0.f9123a = -1;
                this.f9247f = null;
                this.f9242a = -1;
                this.f9245d = false;
                this.f9244c.w1(this);
                this.f9244c = null;
                this.f9243b = null;
            }
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        B1 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        H1 = new c();
    }

    public RecyclerView(@m0 Context context) {
        this(context, null);
    }

    private void A0(long j7, d0 d0Var, d0 d0Var2) {
        int iG = this.f9092e.g();
        for (int i7 = 0; i7 < iG; i7++) {
            d0 d0VarT0 = t0(this.f9092e.f(i7));
            if (d0VarT0 != d0Var && n0(d0VarT0) == j7) {
                g gVar = this.f9099l;
                if (gVar == null || !gVar.i()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + d0VarT0 + " \n View Holder 2:" + d0Var + X());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + d0VarT0 + " \n View Holder 2:" + d0Var + X());
            }
        }
        Log.e(Y0, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + X());
    }

    private boolean D0() {
        int iG = this.f9092e.g();
        for (int i7 = 0; i7 < iG; i7++) {
            d0 d0VarT0 = t0(this.f9092e.f(i7));
            if (d0VarT0 != null && !d0VarT0.K() && d0VarT0.z()) {
                return true;
            }
        }
        return false;
    }

    private void D1(@o0 g gVar, boolean z7, boolean z8) {
        g gVar2 = this.f9099l;
        if (gVar2 != null) {
            gVar2.E(this.f9088a);
            this.f9099l.x(this);
        }
        if (!z7 || z8) {
            n1();
        }
        this.f9091d.z();
        g gVar3 = this.f9099l;
        this.f9099l = gVar;
        if (gVar != null) {
            gVar.C(this.f9088a);
            gVar.t(this);
        }
        o oVar = this.f9100m;
        if (oVar != null) {
            oVar.V0(gVar3, this.f9099l);
        }
        this.f9089b.y(gVar3, this.f9099l, z7);
        this.H0.f9129g = true;
    }

    private void F(Context context, String str, AttributeSet attributeSet, int i7, int i8) {
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strX0 = x0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strX0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                try {
                    constructor = clsAsSubclass.getConstructor(B1);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i7), Integer.valueOf(i8)};
                } catch (NoSuchMethodException e8) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    } catch (NoSuchMethodException e9) {
                        e9.initCause(e8);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strX0, e9);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e10) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strX0, e10);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strX0, e11);
            } catch (IllegalAccessException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strX0, e12);
            } catch (InstantiationException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strX0, e13);
            } catch (InvocationTargetException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strX0, e14);
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    private void F0() {
        if (n2.W(this) == 0) {
            n2.S1(this, 8);
        }
    }

    private void G0() {
        this.f9092e = new androidx.recyclerview.widget.g(new e());
    }

    private boolean H(int i7, int i8) {
        d0(this.Q0);
        int[] iArr = this.Q0;
        return (iArr[0] == i7 && iArr[1] == i8) ? false : true;
    }

    private void K() {
        int i7 = this.f9113z;
        this.f9113z = 0;
        if (i7 == 0 || !K0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        androidx.core.view.accessibility.b.i(accessibilityEventObtain, i7);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void M() {
        this.H0.a(1);
        Y(this.H0);
        this.H0.f9132j = false;
        L1();
        this.f9093f.f();
        Z0();
        h1();
        y1();
        a0 a0Var = this.H0;
        a0Var.f9131i = a0Var.f9133k && this.L0;
        this.L0 = false;
        this.K0 = false;
        a0Var.f9130h = a0Var.f9134l;
        a0Var.f9128f = this.f9099l.e();
        d0(this.Q0);
        if (this.H0.f9133k) {
            int iG = this.f9092e.g();
            for (int i7 = 0; i7 < iG; i7++) {
                d0 d0VarT0 = t0(this.f9092e.f(i7));
                if (!d0VarT0.K() && (!d0VarT0.u() || this.f9099l.i())) {
                    this.f9093f.e(d0VarT0, this.M.w(this.H0, d0VarT0, l.e(d0VarT0), d0VarT0.p()));
                    if (this.H0.f9131i && d0VarT0.z() && !d0VarT0.w() && !d0VarT0.K() && !d0VarT0.u()) {
                        this.f9093f.c(n0(d0VarT0), d0VarT0);
                    }
                }
            }
        }
        if (this.H0.f9134l) {
            z1();
            a0 a0Var2 = this.H0;
            boolean z7 = a0Var2.f9129g;
            a0Var2.f9129g = false;
            this.f9100m.o1(this.f9089b, a0Var2);
            this.H0.f9129g = z7;
            for (int i8 = 0; i8 < this.f9092e.g(); i8++) {
                d0 d0VarT1 = t0(this.f9092e.f(i8));
                if (!d0VarT1.K() && !this.f9093f.i(d0VarT1)) {
                    int iE = l.e(d0VarT1);
                    boolean zQ = d0VarT1.q(8192);
                    if (!zQ) {
                        iE |= 4096;
                    }
                    l.d dVarW = this.M.w(this.H0, d0VarT1, iE, d0VarT1.p());
                    if (zQ) {
                        k1(d0VarT1, dVarW);
                    } else {
                        this.f9093f.a(d0VarT1, dVarW);
                    }
                }
            }
            A();
        } else {
            A();
        }
        a1();
        M1(false);
        this.H0.f9127e = 2;
    }

    private void N() {
        L1();
        Z0();
        this.H0.a(6);
        this.f9091d.k();
        this.H0.f9128f = this.f9099l.e();
        a0 a0Var = this.H0;
        a0Var.f9126d = 0;
        a0Var.f9130h = false;
        this.f9100m.o1(this.f9089b, a0Var);
        a0 a0Var2 = this.H0;
        a0Var2.f9129g = false;
        this.f9090c = null;
        a0Var2.f9133k = a0Var2.f9133k && this.M != null;
        a0Var2.f9127e = 4;
        a1();
        M1(false);
    }

    private void O() {
        this.H0.a(4);
        L1();
        Z0();
        a0 a0Var = this.H0;
        a0Var.f9127e = 1;
        if (a0Var.f9133k) {
            for (int iG = this.f9092e.g() - 1; iG >= 0; iG--) {
                d0 d0VarT0 = t0(this.f9092e.f(iG));
                if (!d0VarT0.K()) {
                    long jN0 = n0(d0VarT0);
                    l.d dVarV = this.M.v(this.H0, d0VarT0);
                    d0 d0VarG = this.f9093f.g(jN0);
                    if (d0VarG == null || d0VarG.K()) {
                        this.f9093f.d(d0VarT0, dVarV);
                    } else {
                        boolean zH = this.f9093f.h(d0VarG);
                        boolean zH2 = this.f9093f.h(d0VarT0);
                        if (zH && d0VarG == d0VarT0) {
                            this.f9093f.d(d0VarT0, dVarV);
                        } else {
                            l.d dVarN = this.f9093f.n(d0VarG);
                            this.f9093f.d(d0VarT0, dVarV);
                            l.d dVarM = this.f9093f.m(d0VarT0);
                            if (dVarN == null) {
                                A0(jN0, d0VarT0, d0VarG);
                            } else {
                                t(d0VarG, d0VarT0, dVarN, dVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            this.f9093f.o(this.X0);
        }
        this.f9100m.E1(this.f9089b);
        a0 a0Var2 = this.H0;
        a0Var2.f9125c = a0Var2.f9128f;
        this.D = false;
        this.E = false;
        a0Var2.f9133k = false;
        a0Var2.f9134l = false;
        this.f9100m.f9207h = false;
        ArrayList<d0> arrayList = this.f9089b.f9233b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.f9100m;
        if (oVar.f9213n) {
            oVar.f9212m = 0;
            oVar.f9213n = false;
            this.f9089b.L();
        }
        this.f9100m.p1(this.H0);
        a1();
        M1(false);
        this.f9093f.f();
        int[] iArr = this.Q0;
        if (H(iArr[0], iArr[1])) {
            Q(0, 0);
        }
        l1();
        w1();
    }

    private boolean O0(View view, View view2, int i7) {
        int i8;
        if (view2 == null || view2 == this || a0(view2) == null) {
            return false;
        }
        if (view == null || a0(view) == null) {
            return true;
        }
        this.f9096i.set(0, 0, view.getWidth(), view.getHeight());
        this.f9097j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f9096i);
        offsetDescendantRectToMyCoords(view2, this.f9097j);
        byte b8 = -1;
        int i9 = this.f9100m.i0() == 1 ? -1 : 1;
        Rect rect = this.f9096i;
        int i10 = rect.left;
        Rect rect2 = this.f9097j;
        int i11 = rect2.left;
        if ((i10 < i11 || rect.right <= i11) && rect.right < rect2.right) {
            i8 = 1;
        } else {
            int i12 = rect.right;
            int i13 = rect2.right;
            i8 = ((i12 > i13 || i10 >= i13) && i10 > i11) ? -1 : 0;
        }
        int i14 = rect.top;
        int i15 = rect2.top;
        if ((i14 < i15 || rect.bottom <= i15) && rect.bottom < rect2.bottom) {
            b8 = 1;
        } else {
            int i16 = rect.bottom;
            int i17 = rect2.bottom;
            if ((i16 <= i17 && i14 < i17) || i14 <= i15) {
                b8 = 0;
            }
        }
        if (i7 == 1) {
            return b8 < 0 || (b8 == 0 && i8 * i9 <= 0);
        }
        if (i7 == 2) {
            return b8 > 0 || (b8 == 0 && i8 * i9 >= 0);
        }
        if (i7 == 17) {
            return i8 < 0;
        }
        if (i7 == 33) {
            return b8 < 0;
        }
        if (i7 == 66) {
            return i8 > 0;
        }
        if (i7 == 130) {
            return b8 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i7 + X());
    }

    private void O1() {
        this.E0.g();
        o oVar = this.f9100m;
        if (oVar != null) {
            oVar.i2();
        }
    }

    private boolean S(MotionEvent motionEvent) {
        r rVar = this.f9104q;
        if (rVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return c0(motionEvent);
        }
        rVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f9104q = null;
        }
        return true;
    }

    private boolean c0(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f9103p.size();
        for (int i7 = 0; i7 < size; i7++) {
            r rVar = this.f9103p.get(i7);
            if (rVar.c(this, motionEvent) && action != 3) {
                this.f9104q = rVar;
                return true;
            }
        }
        return false;
    }

    private void c1(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.O) {
            int i7 = actionIndex == 0 ? 1 : 0;
            this.O = motionEvent.getPointerId(i7);
            int x7 = (int) (motionEvent.getX(i7) + 0.5f);
            this.S = x7;
            this.Q = x7;
            int y7 = (int) (motionEvent.getY(i7) + 0.5f);
            this.T = y7;
            this.R = y7;
        }
    }

    private void d0(int[] iArr) {
        int iG = this.f9092e.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i7 = Integer.MAX_VALUE;
        int i8 = Integer.MIN_VALUE;
        for (int i9 = 0; i9 < iG; i9++) {
            d0 d0VarT0 = t0(this.f9092e.f(i9));
            if (!d0VarT0.K()) {
                int iM = d0VarT0.m();
                if (iM < i7) {
                    i7 = iM;
                }
                if (iM > i8) {
                    i8 = iM;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
    }

    @o0
    static RecyclerView e0(@m0 View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            RecyclerView recyclerViewE0 = e0(viewGroup.getChildAt(i7));
            if (recyclerViewE0 != null) {
                return recyclerViewE0;
            }
        }
        return null;
    }

    @o0
    private View f0() {
        d0 d0VarG0;
        a0 a0Var = this.H0;
        int i7 = a0Var.f9135m;
        if (i7 == -1) {
            i7 = 0;
        }
        int iD = a0Var.d();
        for (int i8 = i7; i8 < iD; i8++) {
            d0 d0VarG1 = g0(i8);
            if (d0VarG1 == null) {
                break;
            }
            if (d0VarG1.f9157a.hasFocusable()) {
                return d0VarG1.f9157a;
            }
        }
        int iMin = Math.min(iD, i7);
        do {
            iMin--;
            if (iMin < 0 || (d0VarG0 = g0(iMin)) == null) {
                return null;
            }
        } while (!d0VarG0.f9157a.hasFocusable());
        return d0VarG0.f9157a;
    }

    private boolean g1() {
        return this.M != null && this.f9100m.j2();
    }

    private u1 getScrollingChildHelper() {
        if (this.R0 == null) {
            this.R0 = new u1(this);
        }
        return this.R0;
    }

    private void h1() {
        boolean z7;
        if (this.D) {
            this.f9091d.z();
            if (this.E) {
                this.f9100m.j1(this);
            }
        }
        if (g1()) {
            this.f9091d.x();
        } else {
            this.f9091d.k();
        }
        boolean z8 = false;
        boolean z9 = this.K0 || this.L0;
        this.H0.f9133k = this.f9108u && this.M != null && ((z7 = this.D) || z9 || this.f9100m.f9207h) && (!z7 || this.f9099l.i());
        a0 a0Var = this.H0;
        if (a0Var.f9133k && z9 && !this.D && g1()) {
            z8 = true;
        }
        a0Var.f9134l = z8;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    /* JADX WARN: Code duplicated, block: B:13:0x0056  */
    /* JADX WARN: Code duplicated, block: B:15:0x005a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    private void j1(float f8, float f9, float f10, float f11) {
        boolean z7;
        boolean z8 = true;
        if (f9 >= 0.0f) {
            if (f9 > 0.0f) {
                V();
                androidx.core.widget.i.g(this.K, f9 / getWidth(), f10 / getHeight());
            } else {
                z7 = false;
            }
            if (f11 < 0.0f) {
                W();
                androidx.core.widget.i.g(this.f9087J, (-f11) / getHeight(), f8 / getWidth());
            } else if (f11 > 0.0f) {
                T();
                androidx.core.widget.i.g(this.L, f11 / getHeight(), 1.0f - (f8 / getWidth()));
            } else {
                z8 = z7;
            }
            if (z8 && f9 == 0.0f && f11 == 0.0f) {
                return;
            }
            n2.n1(this);
        }
        U();
        androidx.core.widget.i.g(this.I, (-f9) / getWidth(), 1.0f - (f10 / getHeight()));
        z7 = true;
        if (f11 < 0.0f) {
            W();
            androidx.core.widget.i.g(this.f9087J, (-f11) / getHeight(), f8 / getWidth());
        } else if (f11 > 0.0f) {
            T();
            androidx.core.widget.i.g(this.L, f11 / getHeight(), 1.0f - (f8 / getWidth()));
        } else {
            z8 = z7;
        }
        if (z8) {
        }
        n2.n1(this);
    }

    private void l1() {
        View viewFindViewById;
        if (!this.D0 || this.f9099l == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!f9068h1 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f9092e.n(focusedChild)) {
                    return;
                }
            } else if (this.f9092e.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewF0 = null;
        d0 d0VarH0 = (this.H0.f9136n == -1 || !this.f9099l.i()) ? null : h0(this.H0.f9136n);
        if (d0VarH0 != null && !this.f9092e.n(d0VarH0.f9157a) && d0VarH0.f9157a.hasFocusable()) {
            viewF0 = d0VarH0.f9157a;
        } else if (this.f9092e.g() > 0) {
            viewF0 = f0();
        }
        if (viewF0 != null) {
            int i7 = this.H0.f9137o;
            if (i7 != -1 && (viewFindViewById = viewF0.findViewById(i7)) != null && viewFindViewById.isFocusable()) {
                viewF0 = viewFindViewById;
            }
            viewF0.requestFocus();
        }
    }

    private void m(d0 d0Var) {
        View view = d0Var.f9157a;
        boolean z7 = view.getParent() == this;
        this.f9089b.K(s0(view));
        if (d0Var.y()) {
            this.f9092e.c(view, -1, view.getLayoutParams(), true);
        } else if (z7) {
            this.f9092e.k(view);
        } else {
            this.f9092e.b(view, true);
        }
    }

    private void m1() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.I.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f9087J;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f9087J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.L.isFinished();
        }
        if (zIsFinished) {
            n2.n1(this);
        }
    }

    private void t(@m0 d0 d0Var, @m0 d0 d0Var2, @m0 l.d dVar, @m0 l.d dVar2, boolean z7, boolean z8) {
        d0Var.H(false);
        if (z7) {
            m(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z8) {
                m(d0Var2);
            }
            d0Var.f9164h = d0Var2;
            m(d0Var);
            this.f9089b.K(d0Var);
            d0Var2.H(false);
            d0Var2.f9165i = d0Var;
        }
        if (this.M.b(d0Var, d0Var2, dVar, dVar2)) {
            f1();
        }
    }

    static d0 t0(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f9114a;
    }

    static void v0(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f9115b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private void v1(@m0 View view, @o0 View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f9096i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f9116c) {
                Rect rect = layoutParams2.f9115b;
                Rect rect2 = this.f9096i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f9096i);
            offsetRectIntoDescendantCoords(view, this.f9096i);
        }
        this.f9100m.M1(this, view, this.f9096i, !this.f9108u, view2 == null);
    }

    private int w0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private void w1() {
        a0 a0Var = this.H0;
        a0Var.f9136n = -1L;
        a0Var.f9135m = -1;
        a0Var.f9137o = -1;
    }

    private String x0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(com.alibaba.android.arouter.utils.b.f12515h)) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + ClassUtils.PACKAGE_SEPARATOR_CHAR + str;
    }

    private void x1() {
        VelocityTracker velocityTracker = this.P;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        h(0);
        m1();
    }

    private void y() {
        x1();
        setScrollState(0);
    }

    private void y1() {
        int iJ;
        View focusedChild = (this.D0 && hasFocus() && this.f9099l != null) ? getFocusedChild() : null;
        d0 d0VarB0 = focusedChild != null ? b0(focusedChild) : null;
        if (d0VarB0 == null) {
            w1();
            return;
        }
        this.H0.f9136n = this.f9099l.i() ? d0VarB0.k() : -1L;
        a0 a0Var = this.H0;
        if (this.D) {
            iJ = -1;
        } else {
            iJ = d0VarB0.w() ? d0VarB0.f9160d : d0VarB0.j();
        }
        a0Var.f9135m = iJ;
        this.H0.f9137o = w0(d0VarB0.f9157a);
    }

    static void z(@m0 d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f9158b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == d0Var.f9157a) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            d0Var.f9158b = null;
        }
    }

    void A() {
        int iJ = this.f9092e.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            d0 d0VarT0 = t0(this.f9092e.i(i7));
            if (!d0VarT0.K()) {
                d0VarT0.c();
            }
        }
        this.f9089b.e();
    }

    boolean A1(int i7, int i8, MotionEvent motionEvent) {
        int i9;
        int i10;
        int i11;
        int i12;
        E();
        if (this.f9099l != null) {
            int[] iArr = this.U0;
            iArr[0] = 0;
            iArr[1] = 0;
            B1(i7, i8, iArr);
            int[] iArr2 = this.U0;
            int i13 = iArr2[0];
            int i14 = iArr2[1];
            i9 = i14;
            i10 = i13;
            i11 = i7 - i13;
            i12 = i8 - i14;
        } else {
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
        }
        if (!this.f9102o.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.U0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        c(i10, i9, i11, i12, this.S0, 0, iArr3);
        int[] iArr4 = this.U0;
        int i15 = iArr4[0];
        int i16 = i11 - i15;
        int i17 = iArr4[1];
        int i18 = i12 - i17;
        boolean z7 = (i15 == 0 && i17 == 0) ? false : true;
        int i19 = this.S;
        int[] iArr5 = this.S0;
        int i20 = iArr5[0];
        this.S = i19 - i20;
        int i21 = this.T;
        int i22 = iArr5[1];
        this.T = i21 - i22;
        int[] iArr6 = this.T0;
        iArr6[0] = iArr6[0] + i20;
        iArr6[1] = iArr6[1] + i22;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !q1.l(motionEvent, 8194)) {
                j1(motionEvent.getX(), i16, motionEvent.getY(), i18);
            }
            D(i7, i8);
        }
        if (i10 != 0 || i9 != 0) {
            Q(i10, i9);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z7 && i10 == 0 && i9 == 0) ? false : true;
    }

    public void B() {
        List<p> list = this.C;
        if (list != null) {
            list.clear();
        }
    }

    public boolean B0() {
        return this.f9106s;
    }

    void B1(int i7, int i8, @o0 int[] iArr) {
        L1();
        Z0();
        r0.b(f9080t1);
        Y(this.H0);
        int iQ1 = i7 != 0 ? this.f9100m.Q1(i7, this.f9089b, this.H0) : 0;
        int iS1 = i8 != 0 ? this.f9100m.S1(i8, this.f9089b, this.H0) : 0;
        r0.d();
        u1();
        a1();
        M1(false);
        if (iArr != null) {
            iArr[0] = iQ1;
            iArr[1] = iS1;
        }
    }

    public void C() {
        List<s> list = this.J0;
        if (list != null) {
            list.clear();
        }
    }

    public boolean C0() {
        return !this.f9108u || this.D || this.f9091d.q();
    }

    public void C1(int i7) {
        if (this.f9111x) {
            return;
        }
        N1();
        o oVar = this.f9100m;
        if (oVar == null) {
            Log.e(Y0, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.R1(i7);
            awakenScrollBars();
        }
    }

    void D(int i7, int i8) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect == null || edgeEffect.isFinished() || i7 <= 0) {
            zIsFinished = false;
        } else {
            this.I.onRelease();
            zIsFinished = this.I.isFinished();
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i7 < 0) {
            this.K.onRelease();
            zIsFinished |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f9087J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i8 > 0) {
            this.f9087J.onRelease();
            zIsFinished |= this.f9087J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i8 < 0) {
            this.L.onRelease();
            zIsFinished |= this.L.isFinished();
        }
        if (zIsFinished) {
            n2.n1(this);
        }
    }

    void E() {
        if (!this.f9108u || this.D) {
            r0.b(f9082v1);
            L();
            r0.d();
            return;
        }
        if (this.f9091d.q()) {
            if (!this.f9091d.p(4) || this.f9091d.p(11)) {
                if (this.f9091d.q()) {
                    r0.b(f9082v1);
                    L();
                    r0.d();
                    return;
                }
                return;
            }
            r0.b(f9083w1);
            L1();
            Z0();
            this.f9091d.x();
            if (!this.f9110w) {
                if (D0()) {
                    L();
                } else {
                    this.f9091d.j();
                }
            }
            M1(true);
            a1();
            r0.d();
        }
    }

    void E0() {
        this.f9091d = new androidx.recyclerview.widget.a(new f());
    }

    @g1
    boolean E1(d0 d0Var, int i7) {
        if (!M0()) {
            n2.R1(d0Var.f9157a, i7);
            return true;
        }
        d0Var.f9173q = i7;
        this.V0.add(d0Var);
        return false;
    }

    boolean F1(AccessibilityEvent accessibilityEvent) {
        if (!M0()) {
            return false;
        }
        int iD = accessibilityEvent != null ? androidx.core.view.accessibility.b.d(accessibilityEvent) : 0;
        this.f9113z |= iD != 0 ? iD : 0;
        return true;
    }

    void G(int i7, int i8) {
        setMeasuredDimension(o.q(i7, getPaddingLeft() + getPaddingRight(), n2.f0(this)), o.q(i8, getPaddingTop() + getPaddingBottom(), n2.e0(this)));
    }

    public void G1(@c.r0 int i7, @c.r0 int i8) {
        H1(i7, i8, null);
    }

    @g1
    void H0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.k(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + X());
        }
    }

    public void H1(@c.r0 int i7, @c.r0 int i8, @o0 Interpolator interpolator) {
        I1(i7, i8, interpolator, Integer.MIN_VALUE);
    }

    void I(View view) {
        d0 d0VarT0 = t0(view);
        X0(view);
        g gVar = this.f9099l;
        if (gVar != null && d0VarT0 != null) {
            gVar.z(d0VarT0);
        }
        List<p> list = this.C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.C.get(size).d(view);
            }
        }
    }

    void I0() {
        this.L = null;
        this.f9087J = null;
        this.K = null;
        this.I = null;
    }

    public void I1(@c.r0 int i7, @c.r0 int i8, @o0 Interpolator interpolator, int i9) {
        J1(i7, i8, interpolator, i9, false);
    }

    void J(View view) {
        d0 d0VarT0 = t0(view);
        Y0(view);
        g gVar = this.f9099l;
        if (gVar != null && d0VarT0 != null) {
            gVar.A(d0VarT0);
        }
        List<p> list = this.C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.C.get(size).b(view);
            }
        }
    }

    public void J0() {
        if (this.f9102o.size() == 0) {
            return;
        }
        o oVar = this.f9100m;
        if (oVar != null) {
            oVar.i("Cannot invalidate item decorations during a scroll or layout");
        }
        Q0();
        requestLayout();
    }

    void J1(@c.r0 int i7, @c.r0 int i8, @o0 Interpolator interpolator, int i9, boolean z7) {
        o oVar = this.f9100m;
        if (oVar == null) {
            Log.e(Y0, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f9111x) {
            return;
        }
        if (!oVar.n()) {
            i7 = 0;
        }
        if (!this.f9100m.o()) {
            i8 = 0;
        }
        if (i7 == 0 && i8 == 0) {
            return;
        }
        if (!(i9 == Integer.MIN_VALUE || i9 > 0)) {
            scrollBy(i7, i8);
            return;
        }
        if (z7) {
            int i10 = i7 != 0 ? 1 : 0;
            if (i8 != 0) {
                i10 |= 2;
            }
            g(i10, 1);
        }
        this.E0.f(i7, i8, i9, interpolator);
    }

    boolean K0() {
        AccessibilityManager accessibilityManager = this.B;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void K1(int i7) {
        if (this.f9111x) {
            return;
        }
        o oVar = this.f9100m;
        if (oVar == null) {
            Log.e(Y0, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.f2(this, this.H0, i7);
        }
    }

    void L() {
        if (this.f9099l == null) {
            Log.e(Y0, "No adapter attached; skipping layout");
            return;
        }
        if (this.f9100m == null) {
            Log.e(Y0, "No layout manager attached; skipping layout");
            return;
        }
        a0 a0Var = this.H0;
        a0Var.f9132j = false;
        if (a0Var.f9127e == 1) {
            M();
            this.f9100m.U1(this);
            N();
        } else if (!this.f9091d.r() && this.f9100m.z0() == getWidth() && this.f9100m.e0() == getHeight()) {
            this.f9100m.U1(this);
        } else {
            this.f9100m.U1(this);
            N();
        }
        O();
    }

    public boolean L0() {
        l lVar = this.M;
        return lVar != null && lVar.q();
    }

    void L1() {
        int i7 = this.f9109v + 1;
        this.f9109v = i7;
        if (i7 != 1 || this.f9111x) {
            return;
        }
        this.f9110w = false;
    }

    public boolean M0() {
        return this.F > 0;
    }

    void M1(boolean z7) {
        if (this.f9109v < 1) {
            this.f9109v = 1;
        }
        if (!z7 && !this.f9111x) {
            this.f9110w = false;
        }
        if (this.f9109v == 1) {
            if (z7 && this.f9110w && !this.f9111x && this.f9100m != null && this.f9099l != null) {
                L();
            }
            if (!this.f9111x) {
                this.f9110w = false;
            }
        }
        this.f9109v--;
    }

    @Deprecated
    public boolean N0() {
        return isLayoutSuppressed();
    }

    public void N1() {
        setScrollState(0);
        O1();
    }

    void P(int i7) {
        o oVar = this.f9100m;
        if (oVar != null) {
            oVar.v1(i7);
        }
        d1(i7);
        s sVar = this.I0;
        if (sVar != null) {
            sVar.a(this, i7);
        }
        List<s> list = this.J0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.J0.get(size).a(this, i7);
            }
        }
    }

    void P0(int i7) {
        if (this.f9100m == null) {
            return;
        }
        setScrollState(2);
        this.f9100m.R1(i7);
        awakenScrollBars();
    }

    public void P1(@o0 g gVar, boolean z7) {
        setLayoutFrozen(false);
        D1(gVar, true, z7);
        i1(true);
        requestLayout();
    }

    void Q(int i7, int i8) {
        this.G++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i7, scrollY - i8);
        e1(i7, i8);
        s sVar = this.I0;
        if (sVar != null) {
            sVar.b(this, i7, i8);
        }
        List<s> list = this.J0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.J0.get(size).b(this, i7, i8);
            }
        }
        this.G--;
    }

    void Q0() {
        int iJ = this.f9092e.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            ((LayoutParams) this.f9092e.i(i7).getLayoutParams()).f9116c = true;
        }
        this.f9089b.t();
    }

    void Q1(int i7, int i8, Object obj) {
        int i9;
        int iJ = this.f9092e.j();
        int i10 = i7 + i8;
        for (int i11 = 0; i11 < iJ; i11++) {
            View viewI = this.f9092e.i(i11);
            d0 d0VarT0 = t0(viewI);
            if (d0VarT0 != null && !d0VarT0.K() && (i9 = d0VarT0.f9159c) >= i7 && i9 < i10) {
                d0VarT0.b(2);
                d0VarT0.a(obj);
                ((LayoutParams) viewI.getLayoutParams()).f9116c = true;
            }
        }
        this.f9089b.N(i7, i8);
    }

    void R() {
        int i7;
        for (int size = this.V0.size() - 1; size >= 0; size--) {
            d0 d0Var = this.V0.get(size);
            if (d0Var.f9157a.getParent() == this && !d0Var.K() && (i7 = d0Var.f9173q) != -1) {
                n2.R1(d0Var.f9157a, i7);
                d0Var.f9173q = -1;
            }
        }
        this.V0.clear();
    }

    void R0() {
        int iJ = this.f9092e.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            d0 d0VarT0 = t0(this.f9092e.i(i7));
            if (d0VarT0 != null && !d0VarT0.K()) {
                d0VarT0.b(6);
            }
        }
        Q0();
        this.f9089b.u();
    }

    public void S0(@c.r0 int i7) {
        int iG = this.f9092e.g();
        for (int i8 = 0; i8 < iG; i8++) {
            this.f9092e.f(i8).offsetLeftAndRight(i7);
        }
    }

    void T() {
        if (this.L != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.H.a(this, 3);
        this.L = edgeEffectA;
        if (this.f9094g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void T0(@c.r0 int i7) {
        int iG = this.f9092e.g();
        for (int i8 = 0; i8 < iG; i8++) {
            this.f9092e.f(i8).offsetTopAndBottom(i7);
        }
    }

    void U() {
        if (this.I != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.H.a(this, 0);
        this.I = edgeEffectA;
        if (this.f9094g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void U0(int i7, int i8) {
        int iJ = this.f9092e.j();
        for (int i9 = 0; i9 < iJ; i9++) {
            d0 d0VarT0 = t0(this.f9092e.i(i9));
            if (d0VarT0 != null && !d0VarT0.K() && d0VarT0.f9159c >= i7) {
                d0VarT0.B(i8, false);
                this.H0.f9129g = true;
            }
        }
        this.f9089b.v(i7, i8);
        requestLayout();
    }

    void V() {
        if (this.K != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.H.a(this, 2);
        this.K = edgeEffectA;
        if (this.f9094g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void V0(int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int iJ = this.f9092e.j();
        if (i7 < i8) {
            i11 = -1;
            i10 = i7;
            i9 = i8;
        } else {
            i9 = i7;
            i10 = i8;
            i11 = 1;
        }
        for (int i13 = 0; i13 < iJ; i13++) {
            d0 d0VarT0 = t0(this.f9092e.i(i13));
            if (d0VarT0 != null && (i12 = d0VarT0.f9159c) >= i10 && i12 <= i9) {
                if (i12 == i7) {
                    d0VarT0.B(i8 - i7, false);
                } else {
                    d0VarT0.B(i11, false);
                }
                this.H0.f9129g = true;
            }
        }
        this.f9089b.w(i7, i8);
        requestLayout();
    }

    void W() {
        if (this.f9087J != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.H.a(this, 1);
        this.f9087J = edgeEffectA;
        if (this.f9094g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void W0(int i7, int i8, boolean z7) {
        int i9 = i7 + i8;
        int iJ = this.f9092e.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            d0 d0VarT0 = t0(this.f9092e.i(i10));
            if (d0VarT0 != null && !d0VarT0.K()) {
                int i11 = d0VarT0.f9159c;
                if (i11 >= i9) {
                    d0VarT0.B(-i8, z7);
                    this.H0.f9129g = true;
                } else if (i11 >= i7) {
                    d0VarT0.i(i7 - 1, -i8, z7);
                    this.H0.f9129g = true;
                }
            }
        }
        this.f9089b.x(i7, i8, z7);
        requestLayout();
    }

    String X() {
        return " " + super.toString() + ", adapter:" + this.f9099l + ", layout:" + this.f9100m + ", context:" + getContext();
    }

    public void X0(@m0 View view) {
    }

    final void Y(a0 a0Var) {
        if (getScrollState() != 2) {
            a0Var.f9138p = 0;
            a0Var.f9139q = 0;
        } else {
            OverScroller overScroller = this.E0.f9143c;
            a0Var.f9138p = overScroller.getFinalX() - overScroller.getCurrX();
            a0Var.f9139q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public void Y0(@m0 View view) {
    }

    @o0
    public View Z(float f8, float f9) {
        for (int iG = this.f9092e.g() - 1; iG >= 0; iG--) {
            View viewF = this.f9092e.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (f8 >= viewF.getLeft() + translationX && f8 <= viewF.getRight() + translationX && f9 >= viewF.getTop() + translationY && f9 <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    void Z0() {
        this.F++;
    }

    @Override // androidx.core.view.r1
    public boolean a(int i7, int i8, int i9, int i10, int[] iArr, int i11) {
        return getScrollingChildHelper().g(i7, i8, i9, i10, iArr, i11);
    }

    @o0
    public View a0(@m0 View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    void a1() {
        b1(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i7, int i8) {
        o oVar = this.f9100m;
        if (oVar == null || !oVar.W0(this, arrayList, i7, i8)) {
            super.addFocusables(arrayList, i7, i8);
        }
    }

    @Override // androidx.core.view.r1
    public boolean b(int i7, int i8, int[] iArr, int[] iArr2, int i9) {
        return getScrollingChildHelper().d(i7, i8, iArr, iArr2, i9);
    }

    @o0
    public d0 b0(@m0 View view) {
        View viewA0 = a0(view);
        if (viewA0 == null) {
            return null;
        }
        return s0(viewA0);
    }

    void b1(boolean z7) {
        int i7 = this.F - 1;
        this.F = i7;
        if (i7 < 1) {
            this.F = 0;
            if (z7) {
                K();
                R();
            }
        }
    }

    @Override // androidx.core.view.s1
    public final void c(int i7, int i8, int i9, int i10, int[] iArr, int i11, @m0 int[] iArr2) {
        getScrollingChildHelper().e(i7, i8, i9, i10, iArr, i11, iArr2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f9100m.p((LayoutParams) layoutParams);
    }

    @Override // android.view.View, androidx.core.view.i2
    public int computeHorizontalScrollExtent() {
        o oVar = this.f9100m;
        if (oVar != null && oVar.n()) {
            return this.f9100m.t(this.H0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.i2
    public int computeHorizontalScrollOffset() {
        o oVar = this.f9100m;
        if (oVar != null && oVar.n()) {
            return this.f9100m.u(this.H0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.i2
    public int computeHorizontalScrollRange() {
        o oVar = this.f9100m;
        if (oVar != null && oVar.n()) {
            return this.f9100m.v(this.H0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.i2
    public int computeVerticalScrollExtent() {
        o oVar = this.f9100m;
        if (oVar != null && oVar.o()) {
            return this.f9100m.w(this.H0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.i2
    public int computeVerticalScrollOffset() {
        o oVar = this.f9100m;
        if (oVar != null && oVar.o()) {
            return this.f9100m.x(this.H0);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.i2
    public int computeVerticalScrollRange() {
        o oVar = this.f9100m;
        if (oVar != null && oVar.o()) {
            return this.f9100m.y(this.H0);
        }
        return 0;
    }

    @Override // androidx.core.view.r1
    public boolean d(int i7) {
        return getScrollingChildHelper().l(i7);
    }

    public void d1(int i7) {
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedFling(float f8, float f9, boolean z7) {
        return getScrollingChildHelper().a(f8, f9, z7);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedPreFling(float f8, float f9) {
        return getScrollingChildHelper().b(f8, f9);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedPreScroll(int i7, int i8, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i7, i8, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean dispatchNestedScroll(int i7, int i8, int i9, int i10, int[] iArr) {
        return getScrollingChildHelper().f(i7, i8, i9, i10, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z7;
        super.draw(canvas);
        int size = this.f9102o.size();
        boolean z8 = false;
        for (int i7 = 0; i7 < size; i7++) {
            this.f9102o.get(i7).k(canvas, this, this.H0);
        }
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z7 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f9094g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.I;
            z7 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f9087J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f9094g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f9087J;
            z7 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.K;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f9094g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.K;
            z7 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.L;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f9094g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.L;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z8 = true;
            }
            z7 |= z8;
            canvas.restoreToCount(iSave4);
        }
        if ((z7 || this.M == null || this.f9102o.size() <= 0 || !this.M.q()) ? z7 : true) {
            n2.n1(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j7) {
        return super.drawChild(canvas, view, j7);
    }

    public void e1(@c.r0 int i7, @c.r0 int i8) {
    }

    void f(int i7, int i8) {
        if (i7 < 0) {
            U();
            if (this.I.isFinished()) {
                this.I.onAbsorb(-i7);
            }
        } else if (i7 > 0) {
            V();
            if (this.K.isFinished()) {
                this.K.onAbsorb(i7);
            }
        }
        if (i8 < 0) {
            W();
            if (this.f9087J.isFinished()) {
                this.f9087J.onAbsorb(-i8);
            }
        } else if (i8 > 0) {
            T();
            if (this.L.isFinished()) {
                this.L.onAbsorb(i8);
            }
        }
        if (i7 == 0 && i8 == 0) {
            return;
        }
        n2.n1(this);
    }

    void f1() {
        if (this.N0 || !this.f9105r) {
            return;
        }
        n2.p1(this, this.W0);
        this.N0 = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i7) {
        View viewA1;
        boolean z7;
        View viewH1 = this.f9100m.h1(view, i7);
        if (viewH1 != null) {
            return viewH1;
        }
        boolean z8 = (this.f9099l == null || this.f9100m == null || M0() || this.f9111x) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z8 && (i7 == 2 || i7 == 1)) {
            if (this.f9100m.o()) {
                int i8 = i7 == 2 ? 130 : 33;
                z7 = focusFinder.findNextFocus(this, view, i8) == null;
                if (f9067g1) {
                    i7 = i8;
                }
            } else {
                z7 = false;
            }
            if (!z7 && this.f9100m.n()) {
                int i9 = (this.f9100m.i0() == 1) ^ (i7 == 2) ? 66 : 17;
                boolean z9 = focusFinder.findNextFocus(this, view, i9) == null;
                if (f9067g1) {
                    i7 = i9;
                }
                z7 = z9;
            }
            if (z7) {
                E();
                if (a0(view) == null) {
                    return null;
                }
                L1();
                this.f9100m.a1(view, i7, this.f9089b, this.H0);
                M1(false);
            }
            viewA1 = focusFinder.findNextFocus(this, view, i7);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i7);
            if (viewFindNextFocus == null && z8) {
                E();
                if (a0(view) == null) {
                    return null;
                }
                L1();
                viewA1 = this.f9100m.a1(view, i7, this.f9089b, this.H0);
                M1(false);
            } else {
                viewA1 = viewFindNextFocus;
            }
        }
        if (viewA1 == null || viewA1.hasFocusable()) {
            return O0(view, viewA1, i7) ? viewA1 : super.focusSearch(view, i7);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i7);
        }
        v1(viewA1, null);
        return view;
    }

    @Override // androidx.core.view.r1
    public boolean g(int i7, int i8) {
        return getScrollingChildHelper().s(i7, i8);
    }

    @o0
    public d0 g0(int i7) {
        d0 d0Var = null;
        if (this.D) {
            return null;
        }
        int iJ = this.f9092e.j();
        for (int i8 = 0; i8 < iJ; i8++) {
            d0 d0VarT0 = t0(this.f9092e.i(i8));
            if (d0VarT0 != null && !d0VarT0.w() && m0(d0VarT0) == i7) {
                if (!this.f9092e.n(d0VarT0.f9157a)) {
                    return d0VarT0;
                }
                d0Var = d0VarT0;
            }
        }
        return d0Var;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f9100m;
        if (oVar != null) {
            return oVar.K();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + X());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f9100m;
        if (oVar != null) {
            return oVar.L(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + X());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @o0
    public g getAdapter() {
        return this.f9099l;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f9100m;
        return oVar != null ? oVar.N() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i7, int i8) {
        j jVar = this.P0;
        return jVar == null ? super.getChildDrawingOrder(i7, i8) : jVar.a(i7, i8);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f9094g;
    }

    @o0
    public androidx.recyclerview.widget.y getCompatAccessibilityDelegate() {
        return this.O0;
    }

    @m0
    public k getEdgeEffectFactory() {
        return this.H;
    }

    @o0
    public l getItemAnimator() {
        return this.M;
    }

    public int getItemDecorationCount() {
        return this.f9102o.size();
    }

    @o0
    public o getLayoutManager() {
        return this.f9100m;
    }

    public int getMaxFlingVelocity() {
        return this.A0;
    }

    public int getMinFlingVelocity() {
        return this.W;
    }

    long getNanoTime() {
        if (f9066f1) {
            return System.nanoTime();
        }
        return 0L;
    }

    @o0
    public q getOnFlingListener() {
        return this.V;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.D0;
    }

    @m0
    public u getRecycledViewPool() {
        return this.f9089b.j();
    }

    public int getScrollState() {
        return this.N;
    }

    @Override // androidx.core.view.r1
    public void h(int i7) {
        getScrollingChildHelper().u(i7);
    }

    public d0 h0(long j7) {
        g gVar = this.f9099l;
        d0 d0Var = null;
        if (gVar != null && gVar.i()) {
            int iJ = this.f9092e.j();
            for (int i7 = 0; i7 < iJ; i7++) {
                d0 d0VarT0 = t0(this.f9092e.i(i7));
                if (d0VarT0 != null && !d0VarT0.w() && d0VarT0.k() == j7) {
                    if (!this.f9092e.n(d0VarT0.f9157a)) {
                        return d0VarT0;
                    }
                    d0Var = d0VarT0;
                }
            }
        }
        return d0Var;
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    @o0
    public d0 i0(int i7) {
        return k0(i7, false);
    }

    void i1(boolean z7) {
        this.E = z7 | this.E;
        this.D = true;
        R0();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f9105r;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f9111x;
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    @o0
    @Deprecated
    public d0 j0(int i7) {
        return k0(i7, false);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x0036 A[SYNTHETIC] */
    @o0
    d0 k0(int i7, boolean z7) {
        int iJ = this.f9092e.j();
        d0 d0Var = null;
        for (int i8 = 0; i8 < iJ; i8++) {
            d0 d0VarT0 = t0(this.f9092e.i(i8));
            if (d0VarT0 != null && !d0VarT0.w()) {
                if (z7) {
                    if (d0VarT0.f9159c != i7) {
                        continue;
                    } else {
                        if (this.f9092e.n(d0VarT0.f9157a)) {
                            return d0VarT0;
                        }
                        d0Var = d0VarT0;
                    }
                } else if (d0VarT0.m() != i7) {
                    continue;
                } else {
                    if (this.f9092e.n(d0VarT0.f9157a)) {
                        return d0VarT0;
                    }
                    d0Var = d0VarT0;
                }
            }
        }
        return d0Var;
    }

    void k1(d0 d0Var, l.d dVar) {
        d0Var.G(0, 8192);
        if (this.H0.f9131i && d0Var.z() && !d0Var.w() && !d0Var.K()) {
            this.f9093f.c(n0(d0Var), d0Var);
        }
        this.f9093f.e(d0Var, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean l0(int i7, int i8) {
        o oVar = this.f9100m;
        if (oVar == null) {
            Log.e(Y0, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f9111x) {
            return false;
        }
        int iN = oVar.n();
        boolean zO = this.f9100m.o();
        if (iN == 0 || Math.abs(i7) < this.W) {
            i7 = 0;
        }
        if (!zO || Math.abs(i8) < this.W) {
            i8 = 0;
        }
        if (i7 == 0 && i8 == 0) {
            return false;
        }
        float f8 = i7;
        float f9 = i8;
        if (!dispatchNestedPreFling(f8, f9)) {
            boolean z7 = iN != 0 || zO;
            dispatchNestedFling(f8, f9, z7);
            q qVar = this.V;
            if (qVar != null && qVar.a(i7, i8)) {
                return true;
            }
            if (z7) {
                if (zO) {
                    iN = (iN == true ? 1 : 0) | 2;
                }
                g(iN, 1);
                int i9 = this.A0;
                int iMax = Math.max(-i9, Math.min(i7, i9));
                int i10 = this.A0;
                this.E0.c(iMax, Math.max(-i10, Math.min(i8, i10)));
                return true;
            }
        }
        return false;
    }

    int m0(d0 d0Var) {
        if (d0Var.q(524) || !d0Var.t()) {
            return -1;
        }
        return this.f9091d.f(d0Var.f9159c);
    }

    public void n(@m0 n nVar) {
        o(nVar, -1);
    }

    long n0(d0 d0Var) {
        return this.f9099l.i() ? d0Var.k() : d0Var.f9159c;
    }

    void n1() {
        l lVar = this.M;
        if (lVar != null) {
            lVar.l();
        }
        o oVar = this.f9100m;
        if (oVar != null) {
            oVar.D1(this.f9089b);
            this.f9100m.E1(this.f9089b);
        }
        this.f9089b.d();
    }

    public void o(@m0 n nVar, int i7) {
        o oVar = this.f9100m;
        if (oVar != null) {
            oVar.i("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f9102o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i7 < 0) {
            this.f9102o.add(nVar);
        } else {
            this.f9102o.add(i7, nVar);
        }
        Q0();
        requestLayout();
    }

    public int o0(@m0 View view) {
        d0 d0VarT0 = t0(view);
        if (d0VarT0 != null) {
            return d0VarT0.j();
        }
        return -1;
    }

    boolean o1(View view) {
        L1();
        boolean zR = this.f9092e.r(view);
        if (zR) {
            d0 d0VarT0 = t0(view);
            this.f9089b.K(d0VarT0);
            this.f9089b.D(d0VarT0);
        }
        M1(!zR);
        return zR;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.F = 0;
        this.f9105r = true;
        this.f9108u = this.f9108u && !isLayoutRequested();
        o oVar = this.f9100m;
        if (oVar != null) {
            oVar.F(this);
        }
        this.N0 = false;
        if (f9066f1) {
            ThreadLocal<androidx.recyclerview.widget.l> threadLocal = androidx.recyclerview.widget.l.f9592e;
            androidx.recyclerview.widget.l lVar = threadLocal.get();
            this.F0 = lVar;
            if (lVar == null) {
                this.F0 = new androidx.recyclerview.widget.l();
                Display displayQ = n2.Q(this);
                if (isInEditMode() || displayQ == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = displayQ.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                androidx.recyclerview.widget.l lVar2 = this.F0;
                lVar2.f9596c = (long) (1.0E9f / refreshRate);
                threadLocal.set(lVar2);
            }
            this.F0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.l lVar;
        super.onDetachedFromWindow();
        l lVar2 = this.M;
        if (lVar2 != null) {
            lVar2.l();
        }
        N1();
        this.f9105r = false;
        o oVar = this.f9100m;
        if (oVar != null) {
            oVar.G(this, this.f9089b);
        }
        this.V0.clear();
        removeCallbacks(this.W0);
        this.f9093f.j();
        if (!f9066f1 || (lVar = this.F0) == null) {
            return;
        }
        lVar.j(this);
        this.F0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f9102o.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f9102o.get(i7).i(canvas, this, this.H0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f8;
        float axisValue;
        if (this.f9100m != null && !this.f9111x && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f8 = this.f9100m.o() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.f9100m.n() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.f9100m.o()) {
                    f8 = -axisValue2;
                } else if (this.f9100m.n()) {
                    axisValue = axisValue2;
                    f8 = 0.0f;
                } else {
                    f8 = 0.0f;
                    axisValue = 0.0f;
                }
            } else {
                f8 = 0.0f;
                axisValue = 0.0f;
            }
            if (f8 != 0.0f || axisValue != 0.0f) {
                A1((int) (axisValue * this.B0), (int) (f8 * this.C0), motionEvent);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        if (this.f9111x) {
            return false;
        }
        this.f9104q = null;
        if (c0(motionEvent)) {
            y();
            return true;
        }
        o oVar = this.f9100m;
        if (oVar == null) {
            return false;
        }
        boolean zN = oVar.n();
        boolean zO = this.f9100m.o();
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        this.P.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f9112y) {
                this.f9112y = false;
            }
            this.O = motionEvent.getPointerId(0);
            int x7 = (int) (motionEvent.getX() + 0.5f);
            this.S = x7;
            this.Q = x7;
            int y7 = (int) (motionEvent.getY() + 0.5f);
            this.T = y7;
            this.R = y7;
            if (this.N == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                h(1);
            }
            int[] iArr = this.T0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i7 = zN;
            if (zO) {
                i7 = (zN ? 1 : 0) | 2;
            }
            g(i7, 0);
        } else if (actionMasked == 1) {
            this.P.clear();
            h(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.O);
            if (iFindPointerIndex < 0) {
                Log.e(Y0, "Error processing scroll; pointer index for id " + this.O + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x8 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y8 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.N != 1) {
                int i8 = x8 - this.Q;
                int i9 = y8 - this.R;
                if (!zN || Math.abs(i8) <= this.U) {
                    z7 = false;
                } else {
                    this.S = x8;
                    z7 = true;
                }
                if (zO && Math.abs(i9) > this.U) {
                    this.T = y8;
                    z7 = true;
                }
                if (z7) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.O = motionEvent.getPointerId(actionIndex);
            int x9 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.S = x9;
            this.Q = x9;
            int y9 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.T = y9;
            this.R = y9;
        } else if (actionMasked == 6) {
            c1(motionEvent);
        }
        return this.N == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        r0.b(f9081u1);
        L();
        r0.d();
        this.f9108u = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        o oVar = this.f9100m;
        if (oVar == null) {
            G(i7, i8);
            return;
        }
        boolean z7 = false;
        if (oVar.F0()) {
            int mode = View.MeasureSpec.getMode(i7);
            int mode2 = View.MeasureSpec.getMode(i8);
            this.f9100m.q1(this.f9089b, this.H0, i7, i8);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z7 = true;
            }
            if (z7 || this.f9099l == null) {
                return;
            }
            if (this.H0.f9127e == 1) {
                M();
            }
            this.f9100m.W1(i7, i8);
            this.H0.f9132j = true;
            N();
            this.f9100m.Z1(i7, i8);
            if (this.f9100m.d2()) {
                this.f9100m.W1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.H0.f9132j = true;
                N();
                this.f9100m.Z1(i7, i8);
                return;
            }
            return;
        }
        if (this.f9106s) {
            this.f9100m.q1(this.f9089b, this.H0, i7, i8);
            return;
        }
        if (this.A) {
            L1();
            Z0();
            h1();
            a1();
            a0 a0Var = this.H0;
            if (a0Var.f9134l) {
                a0Var.f9130h = true;
            } else {
                this.f9091d.k();
                this.H0.f9130h = false;
            }
            this.A = false;
            M1(false);
        } else if (this.H0.f9134l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.f9099l;
        if (gVar != null) {
            this.H0.f9128f = gVar.e();
        } else {
            this.H0.f9128f = 0;
        }
        L1();
        this.f9100m.q1(this.f9089b, this.H0, i7, i8);
        M1(false);
        this.H0.f9130h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i7, Rect rect) {
        if (M0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i7, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f9090c = savedState;
        super.onRestoreInstanceState(savedState.a());
        o oVar = this.f9100m;
        if (oVar == null || (parcelable2 = this.f9090c.f9118c) == null) {
            return;
        }
        oVar.t1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f9090c;
        if (savedState2 != null) {
            savedState.b(savedState2);
        } else {
            o oVar = this.f9100m;
            if (oVar != null) {
                savedState.f9118c = oVar.u1();
            } else {
                savedState.f9118c = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        if (i7 == i9 && i8 == i10) {
            return;
        }
        I0();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00df A[PHI: r0
      0x00df: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i7;
        boolean z7;
        boolean z8 = false;
        if (this.f9111x || this.f9112y) {
            return false;
        }
        if (S(motionEvent)) {
            y();
            return true;
        }
        o oVar = this.f9100m;
        if (oVar == null) {
            return false;
        }
        boolean zN = oVar.n();
        boolean zO = this.f9100m.o();
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.T0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.T0;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.O = motionEvent.getPointerId(0);
            int x7 = (int) (motionEvent.getX() + 0.5f);
            this.S = x7;
            this.Q = x7;
            int y7 = (int) (motionEvent.getY() + 0.5f);
            this.T = y7;
            this.R = y7;
            if (zO) {
                i7 = zN;
                i7 = (zN ? 1 : 0) | 2;
            }
            i7 = zN;
            g(i7, 0);
        } else if (actionMasked == 1) {
            this.P.addMovement(motionEventObtain);
            this.P.computeCurrentVelocity(1000, this.A0);
            float f8 = zN ? -this.P.getXVelocity(this.O) : 0.0f;
            float f9 = zO ? -this.P.getYVelocity(this.O) : 0.0f;
            if ((f8 == 0.0f && f9 == 0.0f) || !l0((int) f8, (int) f9)) {
                setScrollState(0);
            }
            x1();
            z8 = true;
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.O);
            if (iFindPointerIndex < 0) {
                Log.e(Y0, "Error processing scroll; pointer index for id " + this.O + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x8 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y8 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int iMax = this.S - x8;
            int iMax2 = this.T - y8;
            if (this.N != 1) {
                if (zN) {
                    iMax = iMax > 0 ? Math.max(0, iMax - this.U) : Math.min(0, iMax + this.U);
                    if (iMax != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } else {
                    z7 = false;
                }
                if (zO) {
                    iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.U) : Math.min(0, iMax2 + this.U);
                    if (iMax2 != 0) {
                        z7 = true;
                    }
                }
                if (z7) {
                    setScrollState(1);
                }
            }
            int i8 = iMax;
            int i9 = iMax2;
            if (this.N == 1) {
                int[] iArr3 = this.U0;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (b(zN ? i8 : 0, zO ? i9 : 0, iArr3, this.S0, 0)) {
                    int[] iArr4 = this.U0;
                    i8 -= iArr4[0];
                    i9 -= iArr4[1];
                    int[] iArr5 = this.T0;
                    int i10 = iArr5[0];
                    int[] iArr6 = this.S0;
                    iArr5[0] = i10 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int i11 = i9;
                int[] iArr7 = this.S0;
                this.S = x8 - iArr7[0];
                this.T = y8 - iArr7[1];
                if (A1(zN ? i8 : 0, zO ? i11 : 0, motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                androidx.recyclerview.widget.l lVar = this.F0;
                if (lVar != null && (i8 != 0 || i11 != 0)) {
                    lVar.f(this, i8, i11);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.O = motionEvent.getPointerId(actionIndex);
            int x9 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.S = x9;
            this.Q = x9;
            int y9 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.T = y9;
            this.R = y9;
        } else if (actionMasked == 6) {
            c1(motionEvent);
        }
        if (!z8) {
            this.P.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public void p(@m0 p pVar) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(pVar);
    }

    public long p0(@m0 View view) {
        d0 d0VarT0;
        g gVar = this.f9099l;
        if (gVar == null || !gVar.i() || (d0VarT0 = t0(view)) == null) {
            return -1L;
        }
        return d0VarT0.k();
    }

    public void p1(@m0 n nVar) {
        o oVar = this.f9100m;
        if (oVar != null) {
            oVar.i("Cannot remove item decoration during a scroll  or layout");
        }
        this.f9102o.remove(nVar);
        if (this.f9102o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        Q0();
        requestLayout();
    }

    public void q(@m0 r rVar) {
        this.f9103p.add(rVar);
    }

    public int q0(@m0 View view) {
        d0 d0VarT0 = t0(view);
        if (d0VarT0 != null) {
            return d0VarT0.m();
        }
        return -1;
    }

    public void q1(int i7) {
        int itemDecorationCount = getItemDecorationCount();
        if (i7 >= 0 && i7 < itemDecorationCount) {
            p1(z0(i7));
            return;
        }
        throw new IndexOutOfBoundsException(i7 + " is an invalid index for size " + itemDecorationCount);
    }

    public void r(@m0 s sVar) {
        if (this.J0 == null) {
            this.J0 = new ArrayList();
        }
        this.J0.add(sVar);
    }

    @Deprecated
    public int r0(@m0 View view) {
        return o0(view);
    }

    public void r1(@m0 p pVar) {
        List<p> list = this.C;
        if (list == null) {
            return;
        }
        list.remove(pVar);
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z7) {
        d0 d0VarT0 = t0(view);
        if (d0VarT0 != null) {
            if (d0VarT0.y()) {
                d0VarT0.f();
            } else if (!d0VarT0.K()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + d0VarT0 + X());
            }
        }
        view.clearAnimation();
        J(view);
        super.removeDetachedView(view, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f9100m.s1(this, this.H0, view, view2) && view2 != null) {
            v1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        return this.f9100m.L1(this, view, rect, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        int size = this.f9103p.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f9103p.get(i7).e(z7);
        }
        super.requestDisallowInterceptTouchEvent(z7);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f9109v != 0 || this.f9111x) {
            this.f9110w = true;
        } else {
            super.requestLayout();
        }
    }

    void s(@m0 d0 d0Var, @o0 l.d dVar, @m0 l.d dVar2) {
        d0Var.H(false);
        if (this.M.a(d0Var, dVar, dVar2)) {
            f1();
        }
    }

    public d0 s0(@m0 View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return t0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public void s1(@m0 r rVar) {
        this.f9103p.remove(rVar);
        if (this.f9104q == rVar) {
            this.f9104q = null;
        }
    }

    @Override // android.view.View
    public void scrollBy(int i7, int i8) {
        o oVar = this.f9100m;
        if (oVar == null) {
            Log.e(Y0, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f9111x) {
            return;
        }
        boolean zN = oVar.n();
        boolean zO = this.f9100m.o();
        if (zN || zO) {
            if (!zN) {
                i7 = 0;
            }
            if (!zO) {
                i8 = 0;
            }
            A1(i7, i8, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i7, int i8) {
        Log.w(Y0, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (F1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@o0 androidx.recyclerview.widget.y yVar) {
        this.O0 = yVar;
        n2.B1(this, yVar);
    }

    public void setAdapter(@o0 g gVar) {
        setLayoutFrozen(false);
        D1(gVar, false, true);
        i1(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@o0 j jVar) {
        if (jVar == this.P0) {
            return;
        }
        this.P0 = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z7) {
        if (z7 != this.f9094g) {
            I0();
        }
        this.f9094g = z7;
        super.setClipToPadding(z7);
        if (this.f9108u) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@m0 k kVar) {
        androidx.core.util.w.l(kVar);
        this.H = kVar;
        I0();
    }

    public void setHasFixedSize(boolean z7) {
        this.f9106s = z7;
    }

    public void setItemAnimator(@o0 l lVar) {
        l lVar2 = this.M;
        if (lVar2 != null) {
            lVar2.l();
            this.M.A(null);
        }
        this.M = lVar;
        if (lVar != null) {
            lVar.A(this.M0);
        }
    }

    public void setItemViewCacheSize(int i7) {
        this.f9089b.H(i7);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z7) {
        suppressLayout(z7);
    }

    public void setLayoutManager(@o0 o oVar) {
        if (oVar == this.f9100m) {
            return;
        }
        N1();
        if (this.f9100m != null) {
            l lVar = this.M;
            if (lVar != null) {
                lVar.l();
            }
            this.f9100m.D1(this.f9089b);
            this.f9100m.E1(this.f9089b);
            this.f9089b.d();
            if (this.f9105r) {
                this.f9100m.G(this, this.f9089b);
            }
            this.f9100m.b2(null);
            this.f9100m = null;
        } else {
            this.f9089b.d();
        }
        this.f9092e.o();
        this.f9100m = oVar;
        if (oVar != null) {
            if (oVar.f9201b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f9201b.X());
            }
            oVar.b2(this);
            if (this.f9105r) {
                this.f9100m.F(this);
            }
        }
        this.f9089b.L();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View, androidx.core.view.t1
    public void setNestedScrollingEnabled(boolean z7) {
        getScrollingChildHelper().p(z7);
    }

    public void setOnFlingListener(@o0 q qVar) {
        this.V = qVar;
    }

    @Deprecated
    public void setOnScrollListener(@o0 s sVar) {
        this.I0 = sVar;
    }

    public void setPreserveFocusAfterLayout(boolean z7) {
        this.D0 = z7;
    }

    public void setRecycledViewPool(@o0 u uVar) {
        this.f9089b.F(uVar);
    }

    public void setRecyclerListener(@o0 w wVar) {
        this.f9101n = wVar;
    }

    void setScrollState(int i7) {
        if (i7 == this.N) {
            return;
        }
        this.N = i7;
        if (i7 != 2) {
            O1();
        }
        P(i7);
    }

    public void setScrollingTouchSlop(int i7) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i7 != 0) {
            if (i7 == 1) {
                this.U = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(Y0, "setScrollingTouchSlop(): bad argument constant " + i7 + "; using default value");
        }
        this.U = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@o0 b0 b0Var) {
        this.f9089b.G(b0Var);
    }

    @Override // android.view.View, androidx.core.view.t1
    public boolean startNestedScroll(int i7) {
        return getScrollingChildHelper().r(i7);
    }

    @Override // android.view.View, androidx.core.view.t1
    public void stopNestedScroll() {
        getScrollingChildHelper().t();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z7) {
        if (z7 != this.f9111x) {
            w("Do not suppressLayout in layout or scroll");
            if (z7) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f9111x = true;
                this.f9112y = true;
                N1();
                return;
            }
            this.f9111x = false;
            if (this.f9110w && this.f9100m != null && this.f9099l != null) {
                requestLayout();
            }
            this.f9110w = false;
        }
    }

    public void t1(@m0 s sVar) {
        List<s> list = this.J0;
        if (list != null) {
            list.remove(sVar);
        }
    }

    void u(@m0 d0 d0Var, @m0 l.d dVar, @o0 l.d dVar2) {
        m(d0Var);
        d0Var.H(false);
        if (this.M.c(d0Var, dVar, dVar2)) {
            f1();
        }
    }

    public void u0(@m0 View view, @m0 Rect rect) {
        v0(view, rect);
    }

    void u1() {
        d0 d0Var;
        int iG = this.f9092e.g();
        for (int i7 = 0; i7 < iG; i7++) {
            View viewF = this.f9092e.f(i7);
            d0 d0VarS0 = s0(viewF);
            if (d0VarS0 != null && (d0Var = d0VarS0.f9165i) != null) {
                View view = d0Var.f9157a;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void v(String str) {
        if (M0()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + X());
        }
        throw new IllegalStateException(str + X());
    }

    void w(String str) {
        if (M0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + X());
        }
        if (this.G > 0) {
            Log.w(Y0, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + X()));
        }
    }

    boolean x(d0 d0Var) {
        l lVar = this.M;
        return lVar == null || lVar.g(d0Var, d0Var.p());
    }

    Rect y0(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f9116c) {
            return layoutParams.f9115b;
        }
        if (this.H0.j() && (layoutParams.d() || layoutParams.f())) {
            return layoutParams.f9115b;
        }
        Rect rect = layoutParams.f9115b;
        rect.set(0, 0, 0, 0);
        int size = this.f9102o.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f9096i.set(0, 0, 0, 0);
            this.f9102o.get(i7).g(this.f9096i, view, this, this.H0);
            int i8 = rect.left;
            Rect rect2 = this.f9096i;
            rect.left = i8 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f9116c = false;
        return rect;
    }

    @m0
    public n z0(int i7) {
        int itemDecorationCount = getItemDecorationCount();
        if (i7 >= 0 && i7 < itemDecorationCount) {
            return this.f9102o.get(i7);
        }
        throw new IndexOutOfBoundsException(i7 + " is an invalid index for size " + itemDecorationCount);
    }

    void z1() {
        int iJ = this.f9092e.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            d0 d0VarT0 = t0(this.f9092e.i(i7));
            if (!d0VarT0.K()) {
                d0VarT0.F();
            }
        }
    }

    public RecyclerView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    public RecyclerView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f9088a = new x();
        this.f9089b = new v();
        this.f9093f = new h0();
        this.f9095h = new a();
        this.f9096i = new Rect();
        this.f9097j = new Rect();
        this.f9098k = new RectF();
        this.f9102o = new ArrayList<>();
        this.f9103p = new ArrayList<>();
        this.f9109v = 0;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = new k();
        this.M = new androidx.recyclerview.widget.h();
        this.N = 0;
        this.O = -1;
        this.B0 = Float.MIN_VALUE;
        this.C0 = Float.MIN_VALUE;
        this.D0 = true;
        this.E0 = new c0();
        this.G0 = f9066f1 ? new androidx.recyclerview.widget.l.b() : null;
        this.H0 = new a0();
        this.K0 = false;
        this.L0 = false;
        this.M0 = new m();
        this.N0 = false;
        this.Q0 = new int[2];
        this.S0 = new int[2];
        this.T0 = new int[2];
        this.U0 = new int[2];
        this.V0 = new ArrayList();
        this.W0 = new b();
        this.X0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.U = viewConfiguration.getScaledTouchSlop();
        this.B0 = f4.b(viewConfiguration, context);
        this.C0 = f4.e(viewConfiguration, context);
        this.W = viewConfiguration.getScaledMinimumFlingVelocity();
        this.A0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.M.A(this.M0);
        E0();
        G0();
        F0();
        if (n2.V(this) == 0) {
            n2.R1(this, 1);
        }
        this.B = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.y(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i7, 0);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            saveAttributeDataForStyleable(context, androidx.recyclerview.R.styleable.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f9094g = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
        this.f9107t = z7;
        if (z7) {
            H0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        F(context, string, attributeSet, i7, 0);
        int[] iArr = f9062b1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i7, 0);
        if (i8 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i7, 0);
        }
        boolean z8 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z8);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d0 f9114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Rect f9115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f9116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f9117d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9115b = new Rect();
            this.f9116c = true;
            this.f9117d = false;
        }

        public int a() {
            return this.f9114a.j();
        }

        public int b() {
            return this.f9114a.m();
        }

        @Deprecated
        public int c() {
            return this.f9114a.o();
        }

        public boolean d() {
            return this.f9114a.z();
        }

        public boolean e() {
            return this.f9114a.w();
        }

        public boolean f() {
            return this.f9114a.u();
        }

        public boolean g() {
            return this.f9114a.A();
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
            this.f9115b = new Rect();
            this.f9116c = true;
            this.f9117d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f9115b = new Rect();
            this.f9116c = true;
            this.f9117d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9115b = new Rect();
            this.f9116c = true;
            this.f9117d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f9115b = new Rect();
            this.f9116c = true;
            this.f9117d = false;
        }
    }

    @x0({x0.a.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Parcelable f9118c;

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
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f9118c = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        void b(SavedState savedState) {
            this.f9118c = savedState.f9118c;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeParcelable(this.f9118c, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f9100m;
        if (oVar != null) {
            return oVar.M(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + X());
    }
}
