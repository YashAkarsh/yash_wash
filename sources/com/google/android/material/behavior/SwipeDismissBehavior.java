package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.l0;
import androidx.core.view.accessibility.t0;
import androidx.core.view.n2;
import c.g1;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f17052k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f17053l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f17054m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f17055n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f17056o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f17057p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final float f17058q = 0.5f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final float f17059r = 0.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final float f17060s = 0.5f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    androidx.customview.widget.d f17061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    c f17062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17063c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17065e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f17064d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f17066f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f17067g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f17068h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f17069i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final androidx.customview.widget.d.c f17070j = new a();

    class a extends androidx.customview.widget.d.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f17071d = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f17072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f17073b = -1;

        a() {
        }

        private boolean n(@m0 View view, float f8) {
            if (f8 == 0.0f) {
                return Math.abs(view.getLeft() - this.f17072a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f17067g);
            }
            boolean z7 = n2.Z(view) == 1;
            int i7 = SwipeDismissBehavior.this.f17066f;
            if (i7 == 2) {
                return true;
            }
            if (i7 == 0) {
                if (z7) {
                    if (f8 >= 0.0f) {
                        return false;
                    }
                } else if (f8 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i7 != 1) {
                return false;
            }
            if (z7) {
                if (f8 <= 0.0f) {
                    return false;
                }
            } else if (f8 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.d.c
        public int a(@m0 View view, int i7, int i8) {
            int width;
            int width2;
            int width3;
            boolean z7 = n2.Z(view) == 1;
            int i9 = SwipeDismissBehavior.this.f17066f;
            if (i9 == 0) {
                if (z7) {
                    width = this.f17072a - view.getWidth();
                    width2 = this.f17072a;
                } else {
                    width = this.f17072a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i9 != 1) {
                width = this.f17072a - view.getWidth();
                width2 = view.getWidth() + this.f17072a;
            } else if (z7) {
                width = this.f17072a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f17072a - view.getWidth();
                width2 = this.f17072a;
            }
            return SwipeDismissBehavior.I(width, i7, width2);
        }

        @Override // androidx.customview.widget.d.c
        public int b(@m0 View view, int i7, int i8) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.d.c
        public int d(@m0 View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.d.c
        public void i(@m0 View view, int i7) {
            this.f17073b = i7;
            this.f17072a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.d.c
        public void j(int i7) {
            c cVar = SwipeDismissBehavior.this.f17062b;
            if (cVar != null) {
                cVar.b(i7);
            }
        }

        @Override // androidx.customview.widget.d.c
        public void k(@m0 View view, int i7, int i8, int i9, int i10) {
            float width = this.f17072a + (view.getWidth() * SwipeDismissBehavior.this.f17068h);
            float width2 = this.f17072a + (view.getWidth() * SwipeDismissBehavior.this.f17069i);
            float f8 = i7;
            if (f8 <= width) {
                view.setAlpha(1.0f);
            } else if (f8 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.H(0.0f, 1.0f - SwipeDismissBehavior.K(width, width2, f8), 1.0f));
            }
        }

        @Override // androidx.customview.widget.d.c
        public void l(@m0 View view, float f8, float f9) {
            int i7;
            boolean z7;
            c cVar;
            this.f17073b = -1;
            int width = view.getWidth();
            if (n(view, f8)) {
                int left = view.getLeft();
                int i8 = this.f17072a;
                i7 = left < i8 ? i8 - width : i8 + width;
                z7 = true;
            } else {
                i7 = this.f17072a;
                z7 = false;
            }
            if (SwipeDismissBehavior.this.f17061a.V(i7, view.getTop())) {
                n2.p1(view, new d(view, z7));
            } else {
                if (!z7 || (cVar = SwipeDismissBehavior.this.f17062b) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // androidx.customview.widget.d.c
        public boolean m(View view, int i7) {
            int i8 = this.f17073b;
            return (i8 == -1 || i8 == i7) && SwipeDismissBehavior.this.G(view);
        }
    }

    class b implements t0 {
        b() {
        }

        @Override // androidx.core.view.accessibility.t0
        public boolean a(@m0 View view, @o0 t0.a aVar) {
            boolean z7 = false;
            if (!SwipeDismissBehavior.this.G(view)) {
                return false;
            }
            boolean z8 = n2.Z(view) == 1;
            int i7 = SwipeDismissBehavior.this.f17066f;
            if ((i7 == 0 && z8) || (i7 == 1 && !z8)) {
                z7 = true;
            }
            int width = view.getWidth();
            if (z7) {
                width = -width;
            }
            n2.e1(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f17062b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(View view);

        void b(int i7);
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f17076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f17077b;

        d(View view, boolean z7) {
            this.f17076a = view;
            this.f17077b = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            androidx.customview.widget.d dVar = SwipeDismissBehavior.this.f17061a;
            if (dVar != null && dVar.o(true)) {
                n2.p1(this.f17076a, this);
            } else {
                if (!this.f17077b || (cVar = SwipeDismissBehavior.this.f17062b) == null) {
                    return;
                }
                cVar.a(this.f17076a);
            }
        }
    }

    static float H(float f8, float f9, float f10) {
        return Math.min(Math.max(f8, f9), f10);
    }

    static int I(int i7, int i8, int i9) {
        return Math.min(Math.max(i7, i8), i9);
    }

    private void J(ViewGroup viewGroup) {
        if (this.f17061a == null) {
            this.f17061a = this.f17065e ? androidx.customview.widget.d.p(viewGroup, this.f17064d, this.f17070j) : androidx.customview.widget.d.q(viewGroup, this.f17070j);
        }
    }

    static float K(float f8, float f9, float f10) {
        return (f10 - f8) / (f9 - f8);
    }

    private void T(View view) {
        n2.r1(view, 1048576);
        if (G(view)) {
            n2.u1(view, l0.a.f6512z, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean E(CoordinatorLayout coordinatorLayout, V v7, MotionEvent motionEvent) {
        androidx.customview.widget.d dVar = this.f17061a;
        if (dVar == null) {
            return false;
        }
        dVar.M(motionEvent);
        return true;
    }

    public boolean G(@m0 View view) {
        return true;
    }

    public int L() {
        androidx.customview.widget.d dVar = this.f17061a;
        if (dVar != null) {
            return dVar.F();
        }
        return 0;
    }

    @o0
    @g1
    public c M() {
        return this.f17062b;
    }

    public void N(float f8) {
        this.f17067g = H(0.0f, f8, 1.0f);
    }

    public void O(float f8) {
        this.f17069i = H(0.0f, f8, 1.0f);
    }

    public void P(@o0 c cVar) {
        this.f17062b = cVar;
    }

    public void Q(float f8) {
        this.f17064d = f8;
        this.f17065e = true;
    }

    public void R(float f8) {
        this.f17068h = H(0.0f, f8, 1.0f);
    }

    public void S(int i7) {
        this.f17066f = i7;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 MotionEvent motionEvent) {
        boolean zG = this.f17063c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zG = coordinatorLayout.G(v7, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f17063c = zG;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f17063c = false;
        }
        if (!zG) {
            return false;
        }
        J(coordinatorLayout);
        return this.f17061a.W(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, int i7) {
        boolean zM = super.m(coordinatorLayout, v7, i7);
        if (n2.V(v7) == 0) {
            n2.R1(v7, 1);
            T(v7);
        }
        return zM;
    }
}
