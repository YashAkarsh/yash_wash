package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.b2;
import androidx.core.view.accessibility.l0;
import androidx.core.view.accessibility.t0;
import androidx.core.view.n0;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.customview.view.AbsSavedState;
import c.l;
import c.m0;
import c.o0;
import c.u;
import c.x0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup implements androidx.customview.widget.c {
    private static final int A0 = 400;
    private static final boolean B0 = false;
    private static final boolean C0 = true;
    private static final float D0 = 1.0f;
    static final boolean F0;
    private static final boolean G0;
    private static final String H0 = "androidx.drawerlayout.widget.DrawerLayout";
    private static boolean I0 = false;
    private static final String L = "DrawerLayout";
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = 3;
    private static final int U = 64;
    private static final int V = -1728053248;
    private static final int W = 160;
    private CharSequence A;
    private Object B;
    private boolean C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private final ArrayList<View> H;
    private Rect I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private Matrix f7319J;
    private final t0 K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f7320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f7324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f7325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final androidx.customview.widget.d f7326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final androidx.customview.widget.d f7327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g f7328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final g f7329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f7332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7333n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7334o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7335p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f7336q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f7337r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @o0
    private e f7338s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<e> f7339t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f7340u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f7341v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Drawable f7342w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Drawable f7343x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Drawable f7344y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private CharSequence f7345z;
    private static final int[] M = {R.attr.colorPrimaryDark};
    static final int[] E0 = {R.attr.layout_gravity};

    class a implements t0 {
        a() {
        }

        @Override // androidx.core.view.accessibility.t0
        public boolean a(@m0 View view, @o0 t0.a aVar) {
            if (!DrawerLayout.this.D(view) || DrawerLayout.this.r(view) == 2) {
                return false;
            }
            DrawerLayout.this.f(view);
            return true;
        }
    }

    class b implements View.OnApplyWindowInsetsListener {
        b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    class c extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f7360d = new Rect();

        c() {
        }

        private void n(l0 l0Var, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = viewGroup.getChildAt(i7);
                if (DrawerLayout.A(childAt)) {
                    l0Var.c(childAt);
                }
            }
        }

        private void o(l0 l0Var, l0 l0Var2) {
            Rect rect = this.f7360d;
            l0Var2.t(rect);
            l0Var.S0(rect);
            l0Var.V1(l0Var2.B0());
            l0Var.x1(l0Var2.N());
            l0Var.W0(l0Var2.w());
            l0Var.a1(l0Var2.A());
            l0Var.g1(l0Var2.o0());
            l0Var.j1(l0Var2.q0());
            l0Var.O0(l0Var2.g0());
            l0Var.G1(l0Var2.y0());
            l0Var.a(l0Var2.p());
        }

        @Override // androidx.core.view.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewP = DrawerLayout.this.p();
            if (viewP == null) {
                return true;
            }
            CharSequence charSequenceS = DrawerLayout.this.s(DrawerLayout.this.t(viewP));
            if (charSequenceS == null) {
                return true;
            }
            text.add(charSequenceS);
            return true;
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.H0);
        }

        @Override // androidx.core.view.a
        public void g(View view, l0 l0Var) {
            if (DrawerLayout.F0) {
                super.g(view, l0Var);
            } else {
                l0 l0VarF0 = l0.F0(l0Var);
                super.g(view, l0VarF0);
                l0Var.I1(view);
                Object objL0 = n2.l0(view);
                if (objL0 instanceof View) {
                    l0Var.z1((View) objL0);
                }
                o(l0Var, l0VarF0);
                l0VarF0.I0();
                n(l0Var, (ViewGroup) view);
            }
            l0Var.W0(DrawerLayout.H0);
            l0Var.i1(false);
            l0Var.j1(false);
            l0Var.K0(l0.a.f6492f);
            l0Var.K0(l0.a.f6493g);
        }

        @Override // androidx.core.view.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.F0 || DrawerLayout.A(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class d extends androidx.core.view.a {
        d() {
        }

        @Override // androidx.core.view.a
        public void g(View view, l0 l0Var) {
            super.g(view, l0Var);
            if (DrawerLayout.A(view)) {
                return;
            }
            l0Var.z1(null);
        }
    }

    public interface e {
        void a(@m0 View view);

        void b(@m0 View view);

        void c(int i7);

        void d(@m0 View view, float f8);
    }

    public static abstract class f implements e {
        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void a(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void c(int i7) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void d(View view, float f8) {
        }
    }

    private class g extends androidx.customview.widget.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private androidx.customview.widget.d f7363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f7364c = new a();

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.o();
            }
        }

        g(int i7) {
            this.f7362a = i7;
        }

        private void n() {
            View viewN = DrawerLayout.this.n(this.f7362a == 3 ? 5 : 3);
            if (viewN != null) {
                DrawerLayout.this.f(viewN);
            }
        }

        @Override // androidx.customview.widget.d.c
        public int a(View view, int i7, int i8) {
            if (DrawerLayout.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i7, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i7, width));
        }

        @Override // androidx.customview.widget.d.c
        public int b(View view, int i7, int i8) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.d.c
        public int d(View view) {
            if (DrawerLayout.this.E(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.d.c
        public void f(int i7, int i8) {
            View viewN = (i7 & 1) == 1 ? DrawerLayout.this.n(3) : DrawerLayout.this.n(5);
            if (viewN == null || DrawerLayout.this.r(viewN) != 0) {
                return;
            }
            this.f7363b.d(viewN, i8);
        }

        @Override // androidx.customview.widget.d.c
        public boolean g(int i7) {
            return false;
        }

        @Override // androidx.customview.widget.d.c
        public void h(int i7, int i8) {
            DrawerLayout.this.postDelayed(this.f7364c, 160L);
        }

        @Override // androidx.customview.widget.d.c
        public void i(View view, int i7) {
            ((LayoutParams) view.getLayoutParams()).f7351c = false;
            n();
        }

        @Override // androidx.customview.widget.d.c
        public void j(int i7) {
            DrawerLayout.this.V(i7, this.f7363b.z());
        }

        @Override // androidx.customview.widget.d.c
        public void k(View view, int i7, int i8, int i9, int i10) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.c(view, 3) ? i7 + width : DrawerLayout.this.getWidth() - i7) / width;
            DrawerLayout.this.S(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.d.c
        public void l(View view, float f8, float f9) {
            int i7;
            float fU = DrawerLayout.this.u(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i7 = (f8 > 0.0f || (f8 == 0.0f && fU > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f8 < 0.0f || (f8 == 0.0f && fU > 0.5f)) {
                    width2 -= width;
                }
                i7 = width2;
            }
            this.f7363b.V(i7, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.d.c
        public boolean m(View view, int i7) {
            return DrawerLayout.this.E(view) && DrawerLayout.this.c(view, this.f7362a) && DrawerLayout.this.r(view) == 0;
        }

        void o() {
            View viewN;
            int width;
            int iB = this.f7363b.B();
            boolean z7 = this.f7362a == 3;
            if (z7) {
                viewN = DrawerLayout.this.n(3);
                width = (viewN != null ? -viewN.getWidth() : 0) + iB;
            } else {
                viewN = DrawerLayout.this.n(5);
                width = DrawerLayout.this.getWidth() - iB;
            }
            if (viewN != null) {
                if (((!z7 || viewN.getLeft() >= width) && (z7 || viewN.getLeft() <= width)) || DrawerLayout.this.r(viewN) != 0) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) viewN.getLayoutParams();
                this.f7363b.X(viewN, width, viewN.getTop());
                layoutParams.f7351c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f7364c);
        }

        public void q(androidx.customview.widget.d dVar) {
            this.f7363b = dVar;
        }
    }

    static {
        int i7 = Build.VERSION.SDK_INT;
        F0 = true;
        G0 = true;
        I0 = i7 >= 29;
    }

    public DrawerLayout(@m0 Context context) {
        this(context, null);
    }

    static boolean A(View view) {
        return (n2.V(view) == 4 || n2.V(view) == 2) ? false : true;
    }

    private boolean H(float f8, float f9, View view) {
        if (this.I == null) {
            this.I = new Rect();
        }
        view.getHitRect(this.I);
        return this.I.contains((int) f8, (int) f9);
    }

    private void I(Drawable drawable, int i7) {
        if (drawable == null || !androidx.core.graphics.drawable.d.h(drawable)) {
            return;
        }
        androidx.core.graphics.drawable.d.m(drawable, i7);
    }

    private Drawable P() {
        int iZ = n2.Z(this);
        if (iZ == 0) {
            Drawable drawable = this.D;
            if (drawable != null) {
                I(drawable, iZ);
                return this.D;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                I(drawable2, iZ);
                return this.E;
            }
        }
        return this.F;
    }

    private Drawable Q() {
        int iZ = n2.Z(this);
        if (iZ == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                I(drawable, iZ);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.D;
            if (drawable2 != null) {
                I(drawable2, iZ);
                return this.D;
            }
        }
        return this.G;
    }

    private void R() {
        if (G0) {
            return;
        }
        this.f7343x = P();
        this.f7344y = Q();
    }

    private void T(View view) {
        l0.a aVar = l0.a.f6512z;
        n2.r1(view, aVar.b());
        if (!D(view) || r(view) == 2) {
            return;
        }
        n2.u1(view, aVar, null, this.K);
    }

    private void U(View view, boolean z7) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if ((z7 || E(childAt)) && !(z7 && childAt == view)) {
                n2.R1(childAt, 4);
            } else {
                n2.R1(childAt, 1);
            }
        }
    }

    private boolean m(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventV = v(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventV);
            motionEventV.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private MotionEvent v(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f7319J == null) {
                this.f7319J = new Matrix();
            }
            matrix.invert(this.f7319J);
            motionEventObtain.transform(this.f7319J);
        }
        return motionEventObtain;
    }

    static String w(int i7) {
        if ((i7 & 3) == 3) {
            return "LEFT";
        }
        return (i7 & 5) == 5 ? "RIGHT" : Integer.toHexString(i7);
    }

    private static boolean x(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean y() {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            if (((LayoutParams) getChildAt(i7).getLayoutParams()).f7351c) {
                return true;
            }
        }
        return false;
    }

    private boolean z() {
        return p() != null;
    }

    boolean B(View view) {
        return ((LayoutParams) view.getLayoutParams()).f7349a == 0;
    }

    public boolean C(int i7) {
        View viewN = n(i7);
        if (viewN != null) {
            return D(viewN);
        }
        return false;
    }

    public boolean D(@m0 View view) {
        if (E(view)) {
            return (((LayoutParams) view.getLayoutParams()).f7352d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean E(View view) {
        int iD = n0.d(((LayoutParams) view.getLayoutParams()).f7349a, n2.Z(view));
        return ((iD & 3) == 0 && (iD & 5) == 0) ? false : true;
    }

    public boolean F(int i7) {
        View viewN = n(i7);
        if (viewN != null) {
            return G(viewN);
        }
        return false;
    }

    public boolean G(@m0 View view) {
        if (E(view)) {
            return ((LayoutParams) view.getLayoutParams()).f7350b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void J(View view, float f8) {
        float fU = u(view);
        float width = view.getWidth();
        int i7 = ((int) (width * f8)) - ((int) (fU * width));
        if (!c(view, 3)) {
            i7 = -i7;
        }
        view.offsetLeftAndRight(i7);
        S(view, f8);
    }

    public void K(int i7) {
        L(i7, true);
    }

    public void L(int i7, boolean z7) {
        View viewN = n(i7);
        if (viewN != null) {
            N(viewN, z7);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i7));
    }

    public void M(@m0 View view) {
        N(view, true);
    }

    public void N(@m0 View view, boolean z7) {
        if (!E(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f7332m) {
            layoutParams.f7350b = 1.0f;
            layoutParams.f7352d = 1;
            U(view, true);
            T(view);
        } else if (z7) {
            layoutParams.f7352d |= 2;
            if (c(view, 3)) {
                this.f7326g.X(view, 0, view.getTop());
            } else {
                this.f7327h.X(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            J(view, 1.0f);
            V(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void O(@m0 e eVar) {
        List<e> list;
        if (eVar == null || (list = this.f7339t) == null) {
            return;
        }
        list.remove(eVar);
    }

    void S(View view, float f8) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f8 == layoutParams.f7350b) {
            return;
        }
        layoutParams.f7350b = f8;
        l(view, f8);
    }

    void V(int i7, View view) {
        int i8;
        int iF = this.f7326g.F();
        int iF2 = this.f7327h.F();
        if (iF == 1 || iF2 == 1) {
            i8 = 1;
        } else {
            i8 = 2;
            if (iF != 2 && iF2 != 2) {
                i8 = 0;
            }
        }
        if (view != null && i7 == 0) {
            float f8 = ((LayoutParams) view.getLayoutParams()).f7350b;
            if (f8 == 0.0f) {
                j(view);
            } else if (f8 == 1.0f) {
                k(view);
            }
        }
        if (i8 != this.f7330k) {
            this.f7330k = i8;
            List<e> list = this.f7339t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f7339t.get(size).c(i8);
                }
            }
        }
    }

    public void a(@m0 e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.f7339t == null) {
            this.f7339t = new ArrayList();
        }
        this.f7339t.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i7, int i8) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (!E(childAt)) {
                this.H.add(childAt);
            } else if (D(childAt)) {
                childAt.addFocusables(arrayList, i7, i8);
                z7 = true;
            }
        }
        if (!z7) {
            int size = this.H.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.H.get(i10);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i7, i8);
                }
            }
        }
        this.H.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i7, layoutParams);
        if (o() != null || E(view)) {
            n2.R1(view, 4);
        } else {
            n2.R1(view, 1);
        }
        if (F0) {
            return;
        }
        n2.B1(view, this.f7320a);
    }

    void b() {
        if (this.f7337r) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            getChildAt(i7).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.f7337r = true;
    }

    boolean c(View view, int i7) {
        return (t(view) & i7) == i7;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // androidx.customview.widget.c
    public void close() {
        if (q(n0.f6717b) != 2) {
            d(n0.f6717b);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i7 = 0; i7 < childCount; i7++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i7).getLayoutParams()).f7350b);
        }
        this.f7324e = fMax;
        boolean zO = this.f7326g.o(true);
        boolean zO2 = this.f7327h.o(true);
        if (zO || zO2) {
            n2.n1(this);
        }
    }

    public void d(int i7) {
        e(i7, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f7324e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        for (int i7 = childCount - 1; i7 >= 0; i7--) {
            View childAt = getChildAt(i7);
            if (H(x7, y7, childAt) && !B(childAt) && m(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j7) {
        int height = getHeight();
        boolean zB = B(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i7 = 0;
        if (zB) {
            int childCount = getChildCount();
            int i8 = 0;
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt != view && childAt.getVisibility() == 0 && x(childAt) && E(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i8) {
                            i8 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i8, 0, width, getHeight());
            i7 = i8;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j7);
        canvas.restoreToCount(iSave);
        float f8 = this.f7324e;
        if (f8 > 0.0f && zB) {
            int i10 = this.f7323d;
            this.f7325f.setColor((i10 & n2.f6742s) | (((int) ((((-16777216) & i10) >>> 24) * f8)) << 24));
            canvas.drawRect(i7, 0.0f, width, getHeight(), this.f7325f);
        } else if (this.f7343x != null && c(view, 3)) {
            int intrinsicWidth = this.f7343x.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f7326g.B(), 1.0f));
            this.f7343x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f7343x.setAlpha((int) (fMax * 255.0f));
            this.f7343x.draw(canvas);
        } else if (this.f7344y != null && c(view, 5)) {
            int intrinsicWidth2 = this.f7344y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f7327h.B(), 1.0f));
            this.f7344y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f7344y.setAlpha((int) (fMax2 * 255.0f));
            this.f7344y.draw(canvas);
        }
        return zDrawChild;
    }

    public void e(int i7, boolean z7) {
        View viewN = n(i7);
        if (viewN != null) {
            g(viewN, z7);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i7));
    }

    public void f(@m0 View view) {
        g(view, true);
    }

    public void g(@m0 View view, boolean z7) {
        if (!E(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f7332m) {
            layoutParams.f7350b = 0.0f;
            layoutParams.f7352d = 0;
        } else if (z7) {
            layoutParams.f7352d |= 4;
            if (c(view, 3)) {
                this.f7326g.X(view, -view.getWidth(), view.getTop());
            } else {
                this.f7327h.X(view, getWidth(), view.getTop());
            }
        } else {
            J(view, 0.0f);
            V(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (G0) {
            return this.f7321b;
        }
        return 0.0f;
    }

    @o0
    public Drawable getStatusBarBackgroundDrawable() {
        return this.f7342w;
    }

    public void h() {
        i(false);
    }

    void i(boolean z7) {
        int childCount = getChildCount();
        boolean zX = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (E(childAt) && (!z7 || layoutParams.f7351c)) {
                zX |= c(childAt, 3) ? this.f7326g.X(childAt, -childAt.getWidth(), childAt.getTop()) : this.f7327h.X(childAt, getWidth(), childAt.getTop());
                layoutParams.f7351c = false;
            }
        }
        this.f7328i.p();
        this.f7329j.p();
        if (zX) {
            invalidate();
        }
    }

    @Override // androidx.customview.widget.c
    public boolean isOpen() {
        return C(n0.f6717b);
    }

    void j(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f7352d & 1) == 1) {
            layoutParams.f7352d = 0;
            List<e> list = this.f7339t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f7339t.get(size).b(view);
                }
            }
            U(view, false);
            T(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void k(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f7352d & 1) == 0) {
            layoutParams.f7352d = 1;
            List<e> list = this.f7339t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f7339t.get(size).a(view);
                }
            }
            U(view, true);
            T(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void l(View view, float f8) {
        List<e> list = this.f7339t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f7339t.get(size).d(view, f8);
            }
        }
    }

    View n(int i7) {
        int iD = n0.d(i7, n2.Z(this)) & 7;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if ((t(childAt) & 7) == iD) {
                return childAt;
            }
        }
        return null;
    }

    View o() {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if ((((LayoutParams) childAt.getLayoutParams()).f7352d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7332m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7332m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.C || this.f7342w == null) {
            return;
        }
        Object obj = this.B;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f7342w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f7342w.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        View viewV;
        int actionMasked = motionEvent.getActionMasked();
        boolean zW = this.f7326g.W(motionEvent) | this.f7327h.W(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                i(true);
                this.f7337r = false;
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    i(true);
                    this.f7337r = false;
                }
            } else if (this.f7326g.f(3)) {
                this.f7328i.p();
                this.f7329j.p();
            }
            z7 = false;
        } else {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            this.f7340u = x7;
            this.f7341v = y7;
            z7 = this.f7324e > 0.0f && (viewV = this.f7326g.v((int) x7, (int) y7)) != null && B(viewV);
            this.f7337r = false;
        }
        return zW || z7 || y() || this.f7337r;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (i7 != 4 || !z()) {
            return super.onKeyDown(i7, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i7, KeyEvent keyEvent) {
        if (i7 != 4) {
            return super.onKeyUp(i7, keyEvent);
        }
        View viewP = p();
        if (viewP != null && r(viewP) == 0) {
            h();
        }
        return viewP != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        WindowInsets rootWindowInsets;
        float f8;
        int i11;
        boolean z8 = true;
        this.f7331l = true;
        int i12 = i9 - i7;
        int childCount = getChildCount();
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (B(childAt)) {
                    int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i14, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i14, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f9 = measuredWidth;
                        i11 = (-measuredWidth) + ((int) (layoutParams.f7350b * f9));
                        f8 = (measuredWidth + i11) / f9;
                    } else {
                        float f10 = measuredWidth;
                        int i15 = i12 - ((int) (layoutParams.f7350b * f10));
                        f8 = (i12 - i15) / f10;
                        i11 = i15;
                    }
                    boolean z9 = f8 != layoutParams.f7350b ? z8 : false;
                    int i16 = layoutParams.f7349a & 112;
                    if (i16 == 16) {
                        int i17 = i10 - i8;
                        int i18 = (i17 - measuredHeight) / 2;
                        int i19 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i18 < i19) {
                            i18 = i19;
                        } else {
                            int i20 = i18 + measuredHeight;
                            int i21 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i20 > i17 - i21) {
                                i18 = (i17 - i21) - measuredHeight;
                            }
                        }
                        childAt.layout(i11, i18, measuredWidth + i11, measuredHeight + i18);
                    } else if (i16 != 80) {
                        int i22 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i11, i22, measuredWidth + i11, measuredHeight + i22);
                    } else {
                        int i23 = i10 - i8;
                        childAt.layout(i11, (i23 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i11, i23 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z9) {
                        S(childAt, f8);
                    }
                    int i24 = layoutParams.f7350b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i24) {
                        childAt.setVisibility(i24);
                    }
                }
            }
            i13++;
            z8 = true;
        }
        if (I0 && (rootWindowInsets = getRootWindowInsets()) != null) {
            b2 b2VarN = w5.K(rootWindowInsets).n();
            androidx.customview.widget.d dVar = this.f7326g;
            dVar.S(Math.max(dVar.A(), b2VarN.f5777a));
            androidx.customview.widget.d dVar2 = this.f7327h;
            dVar2.S(Math.max(dVar2.A(), b2VarN.f5779c));
        }
        this.f7331l = false;
        this.f7332m = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i7, int i8) {
        int mode = View.MeasureSpec.getMode(i7);
        int mode2 = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i7);
        int size2 = View.MeasureSpec.getSize(i8);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z7 = this.B != null && n2.U(this);
        int iZ = n2.Z(this);
        int childCount = getChildCount();
        boolean z8 = false;
        boolean z9 = false;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z7) {
                    int iD = n0.d(layoutParams.f7349a, iZ);
                    if (n2.U(childAt)) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.B;
                        if (iD == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (iD == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.B;
                        if (iD == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iD == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (B(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else {
                    if (!E(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i9 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (G0) {
                        float fR = n2.R(childAt);
                        float f8 = this.f7321b;
                        if (fR != f8) {
                            n2.N1(childAt, f8);
                        }
                    }
                    int iT = t(childAt) & 7;
                    boolean z10 = iT == 3;
                    if ((z10 && z8) || (!z10 && z9)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + w(iT) + " but this " + L + " already has a drawer view along that edge");
                    }
                    if (z10) {
                        z8 = true;
                    } else {
                        z9 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i7, this.f7322c + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i8, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewN;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i7 = savedState.f7353c;
        if (i7 != 0 && (viewN = n(i7)) != null) {
            M(viewN);
        }
        int i8 = savedState.f7354d;
        if (i8 != 3) {
            setDrawerLockMode(i8, 3);
        }
        int i9 = savedState.f7355e;
        if (i9 != 3) {
            setDrawerLockMode(i9, 5);
        }
        int i10 = savedState.f7356f;
        if (i10 != 3) {
            setDrawerLockMode(i10, n0.f6717b);
        }
        int i11 = savedState.f7357g;
        if (i11 != 3) {
            setDrawerLockMode(i11, n0.f6718c);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i7) {
        R();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i7).getLayoutParams();
            int i8 = layoutParams.f7352d;
            boolean z7 = i8 == 1;
            boolean z8 = i8 == 2;
            if (z7 || z8) {
                savedState.f7353c = layoutParams.f7349a;
                break;
            }
        }
        savedState.f7354d = this.f7333n;
        savedState.f7355e = this.f7334o;
        savedState.f7356f = this.f7335p;
        savedState.f7357g = this.f7336q;
        return savedState;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        View viewO;
        this.f7326g.M(motionEvent);
        this.f7327h.M(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            this.f7340u = x7;
            this.f7341v = y7;
            this.f7337r = false;
        } else if (action == 1) {
            float x8 = motionEvent.getX();
            float y8 = motionEvent.getY();
            View viewV = this.f7326g.v((int) x8, (int) y8);
            if (viewV != null && B(viewV)) {
                float f8 = x8 - this.f7340u;
                float f9 = y8 - this.f7341v;
                int iE = this.f7326g.E();
                z7 = (f8 * f8) + (f9 * f9) >= ((float) (iE * iE)) || (viewO = o()) == null || r(viewO) == 2;
            }
            i(z7);
        } else if (action == 3) {
            i(true);
            this.f7337r = false;
        }
        return true;
    }

    @Override // androidx.customview.widget.c
    public void open() {
        if (q(n0.f6717b) != 1) {
            K(n0.f6717b);
        }
    }

    View p() {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (E(childAt) && G(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int q(int i7) {
        int iZ = n2.Z(this);
        if (i7 == 3) {
            int i8 = this.f7333n;
            if (i8 != 3) {
                return i8;
            }
            int i9 = iZ == 0 ? this.f7335p : this.f7336q;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        }
        if (i7 == 5) {
            int i10 = this.f7334o;
            if (i10 != 3) {
                return i10;
            }
            int i11 = iZ == 0 ? this.f7336q : this.f7335p;
            if (i11 != 3) {
                return i11;
            }
            return 0;
        }
        if (i7 == 8388611) {
            int i12 = this.f7335p;
            if (i12 != 3) {
                return i12;
            }
            int i13 = iZ == 0 ? this.f7333n : this.f7334o;
            if (i13 != 3) {
                return i13;
            }
            return 0;
        }
        if (i7 != 8388613) {
            return 0;
        }
        int i14 = this.f7336q;
        if (i14 != 3) {
            return i14;
        }
        int i15 = iZ == 0 ? this.f7334o : this.f7333n;
        if (i15 != 3) {
            return i15;
        }
        return 0;
    }

    public int r(@m0 View view) {
        if (E(view)) {
            return q(((LayoutParams) view.getLayoutParams()).f7349a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        super.requestDisallowInterceptTouchEvent(z7);
        if (z7) {
            i(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f7331l) {
            return;
        }
        super.requestLayout();
    }

    @o0
    public CharSequence s(int i7) {
        int iD = n0.d(i7, n2.Z(this));
        if (iD == 3) {
            return this.f7345z;
        }
        if (iD == 5) {
            return this.A;
        }
        return null;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void setChildInsets(Object obj, boolean z7) {
        this.B = obj;
        this.C = z7;
        setWillNotDraw(!z7 && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f8) {
        this.f7321b = f8;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (E(childAt)) {
                n2.N1(childAt, this.f7321b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.f7338s;
        if (eVar2 != null) {
            O(eVar2);
        }
        if (eVar != null) {
            a(eVar);
        }
        this.f7338s = eVar;
    }

    public void setDrawerLockMode(int i7) {
        setDrawerLockMode(i7, 3);
        setDrawerLockMode(i7, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i7) {
        if (G0) {
            return;
        }
        if ((i7 & n0.f6717b) == 8388611) {
            this.D = drawable;
        } else if ((i7 & n0.f6718c) == 8388613) {
            this.E = drawable;
        } else if ((i7 & 3) == 3) {
            this.F = drawable;
        } else if ((i7 & 5) != 5) {
            return;
        } else {
            this.G = drawable;
        }
        R();
        invalidate();
    }

    public void setDrawerTitle(int i7, @o0 CharSequence charSequence) {
        int iD = n0.d(i7, n2.Z(this));
        if (iD == 3) {
            this.f7345z = charSequence;
        } else if (iD == 5) {
            this.A = charSequence;
        }
    }

    public void setScrimColor(@l int i7) {
        this.f7323d = i7;
        invalidate();
    }

    public void setStatusBarBackground(@o0 Drawable drawable) {
        this.f7342w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@l int i7) {
        this.f7342w = new ColorDrawable(i7);
        invalidate();
    }

    int t(View view) {
        return n0.d(((LayoutParams) view.getLayoutParams()).f7349a, n2.Z(this));
    }

    float u(View view) {
        return ((LayoutParams) view.getLayoutParams()).f7350b;
    }

    public DrawerLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public DrawerLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f7320a = new d();
        this.f7323d = V;
        this.f7325f = new Paint();
        this.f7332m = true;
        this.f7333n = 3;
        this.f7334o = 3;
        this.f7335p = 3;
        this.f7336q = 3;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.K = new a();
        setDescendantFocusability(262144);
        float f8 = getResources().getDisplayMetrics().density;
        this.f7322c = (int) ((64.0f * f8) + 0.5f);
        float f9 = f8 * 400.0f;
        g gVar = new g(3);
        this.f7328i = gVar;
        g gVar2 = new g(5);
        this.f7329j = gVar2;
        androidx.customview.widget.d dVarP = androidx.customview.widget.d.p(this, 1.0f, gVar);
        this.f7326g = dVarP;
        dVarP.T(1);
        dVarP.U(f9);
        gVar.q(dVarP);
        androidx.customview.widget.d dVarP2 = androidx.customview.widget.d.p(this, 1.0f, gVar2);
        this.f7327h = dVarP2;
        dVarP2.T(2);
        dVarP2.U(f9);
        gVar2.q(dVarP2);
        setFocusableInTouchMode(true);
        n2.R1(this, 1);
        n2.B1(this, new c());
        setMotionEventSplittingEnabled(false);
        if (n2.U(this)) {
            setOnApplyWindowInsetsListener(new b());
            setSystemUiVisibility(f4.e.a.f33921a);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(M);
            try {
                this.f7342w = typedArrayObtainStyledAttributes.getDrawable(0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.R.styleable.DrawerLayout, i7, 0);
        try {
            if (typedArrayObtainStyledAttributes2.hasValue(androidx.drawerlayout.R.styleable.DrawerLayout_elevation)) {
                this.f7321b = typedArrayObtainStyledAttributes2.getDimension(androidx.drawerlayout.R.styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.f7321b = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.H = new ArrayList<>();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void setDrawerLockMode(int i7, int i8) {
        View viewN;
        int iD = n0.d(i8, n2.Z(this));
        if (i8 == 3) {
            this.f7333n = i7;
        } else if (i8 == 5) {
            this.f7334o = i7;
        } else if (i8 == 8388611) {
            this.f7335p = i7;
        } else if (i8 == 8388613) {
            this.f7336q = i7;
        }
        if (i7 != 0) {
            (iD == 3 ? this.f7326g : this.f7327h).c();
        }
        if (i7 != 1) {
            if (i7 == 2 && (viewN = n(iD)) != null) {
                M(viewN);
                return;
            }
            return;
        }
        View viewN2 = n(iD);
        if (viewN2 != null) {
            f(viewN2);
        }
    }

    public void setStatusBarBackground(int i7) {
        this.f7342w = i7 != 0 ? androidx.core.content.d.i(getContext(), i7) : null;
        invalidate();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f7346e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f7347f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f7348g = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f7350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f7351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f7352d;

        public LayoutParams(@m0 Context context, @o0 AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7349a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.E0);
            this.f7349a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
            this.f7349a = 0;
        }

        public LayoutParams(int i7, int i8, int i9) {
            this(i7, i8);
            this.f7349a = i9;
        }

        public LayoutParams(@m0 LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f7349a = 0;
            this.f7349a = layoutParams.f7349a;
        }

        public LayoutParams(@m0 ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7349a = 0;
        }

        public LayoutParams(@m0 ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7349a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f7353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f7354d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f7355e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f7356f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f7357g;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
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

        public SavedState(@m0 Parcel parcel, @o0 ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7353c = 0;
            this.f7353c = parcel.readInt();
            this.f7354d = parcel.readInt();
            this.f7355e = parcel.readInt();
            this.f7356f = parcel.readInt();
            this.f7357g = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f7353c);
            parcel.writeInt(this.f7354d);
            parcel.writeInt(this.f7355e);
            parcel.writeInt(this.f7356f);
            parcel.writeInt(this.f7357g);
        }

        public SavedState(@m0 Parcelable parcelable) {
            super(parcelable);
            this.f7353c = 0;
        }
    }

    public void setDrawerShadow(@u int i7, int i8) {
        setDrawerShadow(androidx.core.content.d.i(getContext(), i7), i8);
    }

    public void setDrawerLockMode(int i7, @m0 View view) {
        if (E(view)) {
            setDrawerLockMode(i7, ((LayoutParams) view.getLayoutParams()).f7349a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }
}
