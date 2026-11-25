package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.l0;
import androidx.core.view.accessibility.t0;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.customview.view.AbsSavedState;
import c.a1;
import c.g1;
import c.m0;
import c.o0;
import c.r0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.internal.v;
import com.google.android.material.shape.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int Y = 1;
    public static final int Z = 2;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f17123a0 = 3;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f17124b0 = 4;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f17125c0 = 5;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f17126d0 = 6;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f17127e0 = -1;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f17128f0 = 1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f17129g0 = 2;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f17130h0 = 4;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f17131i0 = 8;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f17132j0 = -1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f17133k0 = 0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final String f17134l0 = "BottomSheetBehavior";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final int f17135m0 = 500;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final float f17136n0 = 0.5f;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static final float f17137o0 = 0.1f;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final int f17138p0 = 500;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final int f17139q0 = -1;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final int f17140r0 = R.style.Widget_Design_BottomSheet_Modal;
    float A;
    int B;
    float C;
    boolean D;
    private boolean E;
    private boolean F;
    int G;

    @o0
    androidx.customview.widget.d H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f17141J;
    private boolean K;
    private int L;
    int M;
    int N;

    @o0
    WeakReference<V> O;

    @o0
    WeakReference<View> P;

    @m0
    private final ArrayList<g> Q;

    @o0
    private VelocityTracker R;
    int S;
    private int T;
    boolean U;

    @o0
    private Map<View, Integer> V;
    private int W;
    private final androidx.customview.widget.d.c X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f17145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f17150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.google.android.material.shape.j f17151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f17152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f17153l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f17154m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17155n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f17156o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f17157p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f17158q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f17159r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f17160s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private o f17161t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f17162u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private BottomSheetBehavior<V>.i f17163v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @o0
    private ValueAnimator f17164w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f17165x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f17166y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f17167z;

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f17168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17169d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f17170e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f17171f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f17172g;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @o0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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

        public SavedState(@m0 Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f17168c);
            parcel.writeInt(this.f17169d);
            parcel.writeInt(this.f17170e ? 1 : 0);
            parcel.writeInt(this.f17171f ? 1 : 0);
            parcel.writeInt(this.f17172g ? 1 : 0);
        }

        public SavedState(@m0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f17168c = parcel.readInt();
            this.f17169d = parcel.readInt();
            this.f17170e = parcel.readInt() == 1;
            this.f17171f = parcel.readInt() == 1;
            this.f17172g = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, @m0 BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f17168c = bottomSheetBehavior.G;
            this.f17169d = ((BottomSheetBehavior) bottomSheetBehavior).f17146e;
            this.f17170e = ((BottomSheetBehavior) bottomSheetBehavior).f17143b;
            this.f17171f = bottomSheetBehavior.D;
            this.f17172g = ((BottomSheetBehavior) bottomSheetBehavior).E;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i7) {
            super(parcelable);
            this.f17168c = i7;
        }
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f17173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f17174b;

        a(View view, ViewGroup.LayoutParams layoutParams) {
            this.f17173a = view;
            this.f17174b = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17173a.setLayoutParams(this.f17174b);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f17176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17177b;

        b(View view, int i7) {
            this.f17176a = view;
            this.f17177b = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.O0(this.f17176a, this.f17177b);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f17151j != null) {
                BottomSheetBehavior.this.f17151j.o0(fFloatValue);
            }
        }
    }

    class d implements v.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f17180a;

        d(boolean z7) {
            this.f17180a = z7;
        }

        @Override // com.google.android.material.internal.v.e
        public w5 a(View view, w5 w5Var, v.f fVar) {
            BottomSheetBehavior.this.f17160s = w5Var.r();
            boolean zJ = v.j(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f17155n) {
                BottomSheetBehavior.this.f17159r = w5Var.o();
                paddingBottom = fVar.f17907d + BottomSheetBehavior.this.f17159r;
            }
            if (BottomSheetBehavior.this.f17156o) {
                paddingLeft = (zJ ? fVar.f17906c : fVar.f17904a) + w5Var.p();
            }
            if (BottomSheetBehavior.this.f17157p) {
                paddingRight = (zJ ? fVar.f17904a : fVar.f17906c) + w5Var.q();
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f17180a) {
                BottomSheetBehavior.this.f17153l = w5Var.h().f5780d;
            }
            if (BottomSheetBehavior.this.f17155n || this.f17180a) {
                BottomSheetBehavior.this.V0(false);
            }
            return w5Var;
        }
    }

    class e extends androidx.customview.widget.d.c {
        e() {
        }

        private boolean n(@m0 View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.N + bottomSheetBehavior.g0()) / 2;
        }

        @Override // androidx.customview.widget.d.c
        public int a(@m0 View view, int i7, int i8) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.d.c
        public int b(@m0 View view, int i7, int i8) {
            int iG0 = BottomSheetBehavior.this.g0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return m.a.e(i7, iG0, bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B);
        }

        @Override // androidx.customview.widget.d.c
        public int e(@m0 View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B;
        }

        @Override // androidx.customview.widget.d.c
        public void j(int i7) {
            if (i7 == 1 && BottomSheetBehavior.this.F) {
                BottomSheetBehavior.this.L0(1);
            }
        }

        @Override // androidx.customview.widget.d.c
        public void k(@m0 View view, int i7, int i8, int i9, int i10) {
            BottomSheetBehavior.this.d0(i8);
        }

        @Override // androidx.customview.widget.d.c
        public void l(@m0 View view, float f8, float f9) {
            int iG0;
            int i7 = 6;
            if (f9 < 0.0f) {
                if (BottomSheetBehavior.this.f17143b) {
                    iG0 = BottomSheetBehavior.this.f17166y;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    int i8 = bottomSheetBehavior.f17167z;
                    if (top > i8) {
                        iG0 = i8;
                    } else {
                        iG0 = bottomSheetBehavior.g0();
                    }
                }
                i7 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.D && bottomSheetBehavior2.Q0(view, f9)) {
                    if ((Math.abs(f8) >= Math.abs(f9) || f9 <= 500.0f) && !n(view)) {
                        if (BottomSheetBehavior.this.f17143b) {
                            iG0 = BottomSheetBehavior.this.f17166y;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.g0()) < Math.abs(view.getTop() - BottomSheetBehavior.this.f17167z)) {
                            iG0 = BottomSheetBehavior.this.g0();
                        } else {
                            iG0 = BottomSheetBehavior.this.f17167z;
                        }
                        i7 = 3;
                    } else {
                        iG0 = BottomSheetBehavior.this.N;
                        i7 = 5;
                    }
                } else if (f9 == 0.0f || Math.abs(f8) > Math.abs(f9)) {
                    int top2 = view.getTop();
                    if (!BottomSheetBehavior.this.f17143b) {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int i9 = bottomSheetBehavior3.f17167z;
                        if (top2 < i9) {
                            if (top2 < Math.abs(top2 - bottomSheetBehavior3.B)) {
                                iG0 = BottomSheetBehavior.this.g0();
                                i7 = 3;
                            } else {
                                iG0 = BottomSheetBehavior.this.f17167z;
                            }
                        } else if (Math.abs(top2 - i9) < Math.abs(top2 - BottomSheetBehavior.this.B)) {
                            iG0 = BottomSheetBehavior.this.f17167z;
                        } else {
                            iG0 = BottomSheetBehavior.this.B;
                            i7 = 4;
                        }
                    } else if (Math.abs(top2 - BottomSheetBehavior.this.f17166y) < Math.abs(top2 - BottomSheetBehavior.this.B)) {
                        iG0 = BottomSheetBehavior.this.f17166y;
                        i7 = 3;
                    } else {
                        iG0 = BottomSheetBehavior.this.B;
                        i7 = 4;
                    }
                } else {
                    if (BottomSheetBehavior.this.f17143b) {
                        iG0 = BottomSheetBehavior.this.B;
                    } else {
                        int top3 = view.getTop();
                        if (Math.abs(top3 - BottomSheetBehavior.this.f17167z) < Math.abs(top3 - BottomSheetBehavior.this.B)) {
                            iG0 = BottomSheetBehavior.this.f17167z;
                        } else {
                            iG0 = BottomSheetBehavior.this.B;
                        }
                    }
                    i7 = 4;
                }
            }
            BottomSheetBehavior.this.R0(view, i7, iG0, true);
        }

        @Override // androidx.customview.widget.d.c
        public boolean m(@m0 View view, int i7) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i8 = bottomSheetBehavior.G;
            if (i8 == 1 || bottomSheetBehavior.U) {
                return false;
            }
            if (i8 == 3 && bottomSheetBehavior.S == i7) {
                WeakReference<View> weakReference = bottomSheetBehavior.P;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.O;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class f implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17183a;

        f(int i7) {
            this.f17183a = i7;
        }

        @Override // androidx.core.view.accessibility.t0
        public boolean a(@m0 View view, @o0 t0.a aVar) {
            BottomSheetBehavior.this.K0(this.f17183a);
            return true;
        }
    }

    public static abstract class g {
        public abstract void a(@m0 View view, float f8);

        public abstract void b(@m0 View view, int i7);
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    private class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f17185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f17186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f17187c;

        i(View view, int i7) {
            this.f17185a = view;
            this.f17187c = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.customview.widget.d dVar = BottomSheetBehavior.this.H;
            if (dVar == null || !dVar.o(true)) {
                BottomSheetBehavior.this.L0(this.f17187c);
            } else {
                n2.p1(this.f17185a, this);
            }
            this.f17186b = false;
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface j {
    }

    public BottomSheetBehavior() {
        this.f17142a = 0;
        this.f17143b = true;
        this.f17144c = false;
        this.f17152k = -1;
        this.f17163v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new e();
    }

    private void N0(@m0 View view) {
        boolean z7 = (Build.VERSION.SDK_INT < 29 || s0() || this.f17147f) ? false : true;
        if (this.f17155n || this.f17156o || this.f17157p || z7) {
            v.d(view, new d(z7));
        }
    }

    private void P0(int i7) {
        V v7 = this.O.get();
        if (v7 == null) {
            return;
        }
        ViewParent parent = v7.getParent();
        if (parent != null && parent.isLayoutRequested() && n2.O0(v7)) {
            v7.post(new b(v7, i7));
        } else {
            O0(v7, i7);
        }
    }

    private void S0() {
        V v7;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null || (v7 = weakReference.get()) == null) {
            return;
        }
        n2.r1(v7, 524288);
        n2.r1(v7, 262144);
        n2.r1(v7, 1048576);
        int i7 = this.W;
        if (i7 != -1) {
            n2.r1(v7, i7);
        }
        if (!this.f17143b && this.G != 6) {
            this.W = T(v7, R.string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.D && this.G != 5) {
            v0(v7, l0.a.f6512z, 5);
        }
        int i8 = this.G;
        if (i8 == 3) {
            v0(v7, l0.a.f6511y, this.f17143b ? 4 : 6);
            return;
        }
        if (i8 == 4) {
            v0(v7, l0.a.f6510x, this.f17143b ? 3 : 6);
        } else {
            if (i8 != 6) {
                return;
            }
            v0(v7, l0.a.f6511y, 4);
            v0(v7, l0.a.f6510x, 3);
        }
    }

    private int T(V v7, @a1 int i7, int i8) {
        return n2.c(v7, v7.getResources().getString(i7), Y(i8));
    }

    private void T0(int i7) {
        ValueAnimator valueAnimator;
        if (i7 == 2) {
            return;
        }
        boolean z7 = i7 == 3;
        if (this.f17162u != z7) {
            this.f17162u = z7;
            if (this.f17151j == null || (valueAnimator = this.f17164w) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.f17164w.reverse();
                return;
            }
            float f8 = z7 ? 0.0f : 1.0f;
            this.f17164w.setFloatValues(1.0f - f8, f8);
            this.f17164w.start();
        }
    }

    private void U0(boolean z7) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z7) {
                if (this.V != null) {
                    return;
                } else {
                    this.V = new HashMap(childCount);
                }
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = coordinatorLayout.getChildAt(i7);
                if (childAt != this.O.get()) {
                    if (z7) {
                        this.V.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f17144c) {
                            n2.R1(childAt, 4);
                        }
                    } else if (this.f17144c && (map = this.V) != null && map.containsKey(childAt)) {
                        n2.R1(childAt, this.V.get(childAt).intValue());
                    }
                }
            }
            if (!z7) {
                this.V = null;
            } else if (this.f17144c) {
                this.O.get().sendAccessibilityEvent(8);
            }
        }
    }

    private void V() {
        int iX = X();
        if (this.f17143b) {
            this.B = Math.max(this.N - iX, this.f17166y);
        } else {
            this.B = this.N - iX;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(boolean z7) {
        V v7;
        if (this.O != null) {
            V();
            if (this.G != 4 || (v7 = this.O.get()) == null) {
                return;
            }
            if (z7) {
                P0(this.G);
            } else {
                v7.requestLayout();
            }
        }
    }

    private void W() {
        this.f17167z = (int) (this.N * (1.0f - this.A));
    }

    private int X() {
        int i7;
        if (this.f17147f) {
            return Math.min(Math.max(this.f17148g, this.N - ((this.M * 9) / 16)), this.L) + this.f17159r;
        }
        return (this.f17154m || this.f17155n || (i7 = this.f17153l) <= 0) ? this.f17146e + this.f17159r : Math.max(this.f17146e, i7 + this.f17149h);
    }

    private t0 Y(int i7) {
        return new f(i7);
    }

    private void Z(@m0 Context context, AttributeSet attributeSet, boolean z7) {
        a0(context, attributeSet, z7, null);
    }

    private void a0(@m0 Context context, AttributeSet attributeSet, boolean z7, @o0 ColorStateList colorStateList) {
        if (this.f17150i) {
            this.f17161t = o.e(context, attributeSet, R.attr.bottomSheetStyle, f17140r0).m();
            com.google.android.material.shape.j jVar = new com.google.android.material.shape.j(this.f17161t);
            this.f17151j = jVar;
            jVar.Y(context);
            if (z7 && colorStateList != null) {
                this.f17151j.n0(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
            this.f17151j.setTint(typedValue.data);
        }
    }

    private void b0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f17164w = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f17164w.addUpdateListener(new c());
    }

    @m0
    public static <V extends View> BottomSheetBehavior<V> f0(@m0 V v7) {
        ViewGroup.LayoutParams layoutParams = v7.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.f) layoutParams).f();
        if (behaviorF instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behaviorF;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private float p0() {
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f17145d);
        return this.R.getYVelocity(this.S);
    }

    private void v0(V v7, l0.a aVar, int i7) {
        n2.u1(v7, aVar, null, Y(i7));
    }

    private void w0() {
        this.S = -1;
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.R = null;
        }
    }

    private void x0(@m0 SavedState savedState) {
        int i7 = this.f17142a;
        if (i7 == 0) {
            return;
        }
        if (i7 == -1 || (i7 & 1) == 1) {
            this.f17146e = savedState.f17169d;
        }
        if (i7 == -1 || (i7 & 2) == 2) {
            this.f17143b = savedState.f17170e;
        }
        if (i7 == -1 || (i7 & 4) == 4) {
            this.D = savedState.f17171f;
        }
        if (i7 == -1 || (i7 & 8) == 8) {
            this.E = savedState.f17172g;
        }
    }

    public void A0(int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f17165x = i7;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean B(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, @m0 View view2, int i7, int i8) {
        this.f17141J = 0;
        this.K = false;
        return (i7 & 2) != 0;
    }

    public void B0(boolean z7) {
        if (this.f17143b == z7) {
            return;
        }
        this.f17143b = z7;
        if (this.O != null) {
            V();
        }
        L0((this.f17143b && this.G == 6) ? 3 : this.G);
        S0();
    }

    public void C0(boolean z7) {
        this.f17154m = z7;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void D(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7) {
        int iG0;
        int i8 = 3;
        if (v7.getTop() == g0()) {
            L0(3);
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (weakReference != null && view == weakReference.get() && this.K) {
            if (this.f17141J > 0) {
                if (this.f17143b) {
                    iG0 = this.f17166y;
                } else {
                    int top = v7.getTop();
                    int i9 = this.f17167z;
                    if (top > i9) {
                        i8 = 6;
                        iG0 = i9;
                    } else {
                        iG0 = g0();
                    }
                }
            } else if (this.D && Q0(v7, p0())) {
                iG0 = this.N;
                i8 = 5;
            } else if (this.f17141J == 0) {
                int top2 = v7.getTop();
                if (!this.f17143b) {
                    int i10 = this.f17167z;
                    if (top2 < i10) {
                        if (top2 < Math.abs(top2 - this.B)) {
                            iG0 = g0();
                        } else {
                            iG0 = this.f17167z;
                        }
                    } else if (Math.abs(top2 - i10) < Math.abs(top2 - this.B)) {
                        iG0 = this.f17167z;
                    } else {
                        iG0 = this.B;
                        i8 = 4;
                    }
                    i8 = 6;
                } else if (Math.abs(top2 - this.f17166y) < Math.abs(top2 - this.B)) {
                    iG0 = this.f17166y;
                } else {
                    iG0 = this.B;
                    i8 = 4;
                }
            } else {
                if (this.f17143b) {
                    iG0 = this.B;
                } else {
                    int top3 = v7.getTop();
                    if (Math.abs(top3 - this.f17167z) < Math.abs(top3 - this.B)) {
                        iG0 = this.f17167z;
                        i8 = 6;
                    } else {
                        iG0 = this.B;
                    }
                }
                i8 = 4;
            }
            R0(v7, i8, iG0, false);
            this.K = false;
        }
    }

    public void D0(@c.v(from = 0.0d, to = 1.0d) float f8) {
        if (f8 <= 0.0f || f8 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.A = f8;
        if (this.O != null) {
            W();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean E(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 MotionEvent motionEvent) {
        if (!v7.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.G == 1 && actionMasked == 0) {
            return true;
        }
        androidx.customview.widget.d dVar = this.H;
        if (dVar != null) {
            dVar.M(motionEvent);
        }
        if (actionMasked == 0) {
            w0();
        }
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        if (this.H != null && actionMasked == 2 && !this.I && Math.abs(this.T - motionEvent.getY()) > this.H.E()) {
            this.H.d(v7, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.I;
    }

    public void E0(boolean z7) {
        if (this.D != z7) {
            this.D = z7;
            if (!z7 && this.G == 5) {
                K0(4);
            }
            S0();
        }
    }

    public void F0(@r0 int i7) {
        this.f17152k = i7;
    }

    public void G0(int i7) {
        H0(i7, false);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    public final void H0(int i7, boolean z7) {
        boolean z8 = true;
        if (i7 == -1) {
            if (this.f17147f) {
                z8 = false;
            } else {
                this.f17147f = true;
            }
        } else if (this.f17147f || this.f17146e != i7) {
            this.f17147f = false;
            this.f17146e = Math.max(0, i7);
        } else {
            z8 = false;
        }
        if (z8) {
            V0(z7);
        }
    }

    public void I0(int i7) {
        this.f17142a = i7;
    }

    public void J0(boolean z7) {
        this.E = z7;
    }

    public void K0(int i7) {
        if (i7 == this.G) {
            return;
        }
        if (this.O != null) {
            P0(i7);
            return;
        }
        if (i7 == 4 || i7 == 3 || i7 == 6 || (this.D && i7 == 5)) {
            this.G = i7;
        }
    }

    void L0(int i7) {
        V v7;
        if (this.G == i7) {
            return;
        }
        this.G = i7;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null || (v7 = weakReference.get()) == null) {
            return;
        }
        if (i7 == 3) {
            U0(true);
        } else if (i7 == 6 || i7 == 5 || i7 == 4) {
            U0(false);
        }
        T0(i7);
        for (int i8 = 0; i8 < this.Q.size(); i8++) {
            this.Q.get(i8).b(v7, i7);
        }
        S0();
    }

    public void M0(boolean z7) {
        this.f17144c = z7;
    }

    void O0(@m0 View view, int i7) {
        int iG0;
        int i8;
        if (i7 == 4) {
            iG0 = this.B;
        } else if (i7 == 6) {
            iG0 = this.f17167z;
            if (this.f17143b && iG0 <= (i8 = this.f17166y)) {
                i7 = 3;
                iG0 = i8;
            }
        } else if (i7 == 3) {
            iG0 = g0();
        } else {
            if (!this.D || i7 != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i7);
            }
            iG0 = this.N;
        }
        R0(view, i7, iG0, false);
    }

    boolean Q0(@m0 View view, float f8) {
        if (this.E) {
            return true;
        }
        if (view.getTop() < this.B) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f8 * 0.1f)) - ((float) this.B)) / ((float) X()) > 0.5f;
    }

    void R0(View view, int i7, int i8, boolean z7) {
        androidx.customview.widget.d dVar = this.H;
        if (!(dVar != null && (!z7 ? !dVar.X(view, view.getLeft(), i8) : !dVar.V(view.getLeft(), i8)))) {
            L0(i7);
            return;
        }
        L0(2);
        T0(i7);
        if (this.f17163v == null) {
            this.f17163v = new i(view, i7);
        }
        if (((i) this.f17163v).f17186b) {
            this.f17163v.f17187c = i7;
            return;
        }
        BottomSheetBehavior<V>.i iVar = this.f17163v;
        iVar.f17187c = i7;
        n2.p1(view, iVar);
        ((i) this.f17163v).f17186b = true;
    }

    public void U(@m0 g gVar) {
        if (this.Q.contains(gVar)) {
            return;
        }
        this.Q.add(gVar);
    }

    @x0({x0.a.LIBRARY_GROUP})
    @g1
    public void c0() {
        this.f17164w = null;
    }

    void d0(int i7) {
        float f8;
        float fG0;
        V v7 = this.O.get();
        if (v7 == null || this.Q.isEmpty()) {
            return;
        }
        int i8 = this.B;
        if (i7 > i8 || i8 == g0()) {
            int i9 = this.B;
            f8 = i9 - i7;
            fG0 = this.N - i9;
        } else {
            int i10 = this.B;
            f8 = i10 - i7;
            fG0 = i10 - g0();
        }
        float f9 = f8 / fG0;
        for (int i11 = 0; i11 < this.Q.size(); i11++) {
            this.Q.get(i11).a(v7, f9);
        }
    }

    @o0
    @g1
    View e0(View view) {
        if (n2.W0(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View viewE0 = e0(viewGroup.getChildAt(i7));
            if (viewE0 != null) {
                return viewE0;
            }
        }
        return null;
    }

    public int g0() {
        if (this.f17143b) {
            return this.f17166y;
        }
        return Math.max(this.f17165x, this.f17158q ? 0 : this.f17160s);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void h(@m0 CoordinatorLayout.f fVar) {
        super.h(fVar);
        this.O = null;
        this.H = null;
    }

    @c.v(from = 0.0d, to = 1.0d)
    public float h0() {
        return this.A;
    }

    com.google.android.material.shape.j i0() {
        return this.f17151j;
    }

    @r0
    public int j0() {
        return this.f17152k;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void k() {
        super.k();
        this.O = null;
        this.H = null;
    }

    public int k0() {
        if (this.f17147f) {
            return -1;
        }
        return this.f17146e;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 MotionEvent motionEvent) {
        androidx.customview.widget.d dVar;
        if (!v7.isShown() || !this.F) {
            this.I = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            w0();
        }
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x7 = (int) motionEvent.getX();
            this.T = (int) motionEvent.getY();
            if (this.G != 2) {
                WeakReference<View> weakReference = this.P;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.G(view, x7, this.T)) {
                    this.S = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.U = true;
                }
            }
            this.I = this.S == -1 && !coordinatorLayout.G(v7, x7, this.T);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.U = false;
            this.S = -1;
            if (this.I) {
                this.I = false;
                return false;
            }
        }
        if (!this.I && (dVar = this.H) != null && dVar.W(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.P;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.I || this.G == 1 || coordinatorLayout.G(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.H == null || Math.abs(((float) this.T) - motionEvent.getY()) <= ((float) this.H.E())) ? false : true;
    }

    @g1
    int l0() {
        return this.f17148g;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, int i7) {
        com.google.android.material.shape.j jVar;
        if (n2.U(coordinatorLayout) && !n2.U(v7)) {
            v7.setFitsSystemWindows(true);
        }
        if (this.O == null) {
            this.f17148g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            N0(v7);
            this.O = new WeakReference<>(v7);
            if (this.f17150i && (jVar = this.f17151j) != null) {
                n2.I1(v7, jVar);
            }
            com.google.android.material.shape.j jVar2 = this.f17151j;
            if (jVar2 != null) {
                float fR = this.C;
                if (fR == -1.0f) {
                    fR = n2.R(v7);
                }
                jVar2.m0(fR);
                boolean z7 = this.G == 3;
                this.f17162u = z7;
                this.f17151j.o0(z7 ? 0.0f : 1.0f);
            }
            S0();
            if (n2.V(v7) == 0) {
                n2.R1(v7, 1);
            }
            int measuredWidth = v7.getMeasuredWidth();
            int i8 = this.f17152k;
            if (measuredWidth > i8 && i8 != -1) {
                ViewGroup.LayoutParams layoutParams = v7.getLayoutParams();
                layoutParams.width = this.f17152k;
                v7.post(new a(v7, layoutParams));
            }
        }
        if (this.H == null) {
            this.H = androidx.customview.widget.d.q(coordinatorLayout, this.X);
        }
        int top = v7.getTop();
        coordinatorLayout.N(v7, i7);
        this.M = coordinatorLayout.getWidth();
        this.N = coordinatorLayout.getHeight();
        int height = v7.getHeight();
        this.L = height;
        int i9 = this.N;
        int i10 = i9 - height;
        int i11 = this.f17160s;
        if (i10 < i11) {
            if (this.f17158q) {
                this.L = i9;
            } else {
                this.L = i9 - i11;
            }
        }
        this.f17166y = Math.max(0, i9 - this.L);
        W();
        V();
        int i12 = this.G;
        if (i12 == 3) {
            n2.f1(v7, g0());
        } else if (i12 == 6) {
            n2.f1(v7, this.f17167z);
        } else if (this.D && i12 == 5) {
            n2.f1(v7, this.N);
        } else if (i12 == 4) {
            n2.f1(v7, this.B);
        } else if (i12 == 1 || i12 == 2) {
            n2.f1(v7, top - v7.getTop());
        }
        this.P = new WeakReference<>(e0(v7));
        return true;
    }

    public int m0() {
        return this.f17142a;
    }

    public boolean n0() {
        return this.E;
    }

    public int o0() {
        return this.G;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean p(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, float f8, float f9) {
        WeakReference<View> weakReference = this.P;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.G != 3 || super.p(coordinatorLayout, v7, view, f8, f9);
    }

    public boolean q0() {
        return this.F;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void r(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7, int i8, @m0 int[] iArr, int i9) {
        if (i9 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v7.getTop();
        int i10 = top - i8;
        if (i8 > 0) {
            if (i10 < g0()) {
                int iG0 = top - g0();
                iArr[1] = iG0;
                n2.f1(v7, -iG0);
                L0(3);
            } else {
                if (!this.F) {
                    return;
                }
                iArr[1] = i8;
                n2.f1(v7, -i8);
                L0(1);
            }
        } else if (i8 < 0 && !view.canScrollVertically(-1)) {
            int i11 = this.B;
            if (i10 > i11 && !this.D) {
                int i12 = top - i11;
                iArr[1] = i12;
                n2.f1(v7, -i12);
                L0(4);
            } else {
                if (!this.F) {
                    return;
                }
                iArr[1] = i8;
                n2.f1(v7, -i8);
                L0(1);
            }
        }
        d0(v7.getTop());
        this.f17141J = i8;
        this.K = true;
    }

    public boolean r0() {
        return this.f17143b;
    }

    public boolean s0() {
        return this.f17154m;
    }

    public boolean t0() {
        return this.D;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void u(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7, int i8, int i9, int i10, int i11, @m0 int[] iArr) {
    }

    public void u0(@m0 g gVar) {
        this.Q.remove(gVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void y(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.y(coordinatorLayout, v7, savedState.a());
        x0(savedState);
        int i7 = savedState.f17168c;
        if (i7 == 1 || i7 == 2) {
            this.G = 4;
        } else {
            this.G = i7;
        }
    }

    @Deprecated
    public void y0(g gVar) {
        Log.w(f17134l0, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.Q.clear();
        if (gVar != null) {
            this.Q.add(gVar);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @m0
    public Parcelable z(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7) {
        return new SavedState(super.z(coordinatorLayout, v7), (BottomSheetBehavior<?>) this);
    }

    public void z0(boolean z7) {
        this.F = z7;
    }

    public BottomSheetBehavior(@m0 Context context, @o0 AttributeSet attributeSet) {
        int i7;
        super(context, attributeSet);
        this.f17142a = 0;
        this.f17143b = true;
        this.f17144c = false;
        this.f17152k = -1;
        this.f17163v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new e();
        this.f17149h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.f17150i = typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            a0(context, attributeSet, zHasValue, com.google.android.material.resources.c.a(context, typedArrayObtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            Z(context, attributeSet, zHasValue);
        }
        b0();
        this.C = typedArrayObtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            F0(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i7 = typedValuePeekValue.data) == -1) {
            G0(i7);
        } else {
            G0(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        E0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        C0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        B0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        J0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        z0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        I0(typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        D0(typedArrayObtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            A0(typedValuePeekValue2.data);
        } else {
            A0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        this.f17155n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f17156o = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f17157p = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f17158q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f17145d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
