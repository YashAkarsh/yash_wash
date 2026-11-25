package androidx.viewpager2.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.l0;
import androidx.core.view.accessibility.t0;
import androidx.core.view.n2;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.x;
import c.e0;
import c.m0;
import c.o0;
import c.r0;
import c.x0;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    static boolean A = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f11167u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f11168v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f11169w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f11170x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f11171y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f11172z = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f11173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f11174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.viewpager2.widget.b f11175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f11176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f11177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RecyclerView.i f11178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinearLayoutManager f11179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Parcelable f11181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    RecyclerView f11182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private x f11183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    androidx.viewpager2.widget.g f11184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private androidx.viewpager2.widget.b f11185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private androidx.viewpager2.widget.d f11186n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private androidx.viewpager2.widget.f f11187o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RecyclerView.l f11188p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f11189q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f11190r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f11191s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    e f11192t;

    class a extends g {
        a() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f11177e = true;
            viewPager2.f11184l.n();
        }
    }

    class b extends j {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void a(int i7) {
            if (i7 == 0) {
                ViewPager2.this.x();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void c(int i7) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f11176d != i7) {
                viewPager2.f11176d = i7;
                viewPager2.f11192t.q();
            }
        }
    }

    class c extends j {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void c(int i7) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f11182j.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.p {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void b(@m0 View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void d(@m0 View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }
    }

    private abstract class e {
        private e() {
        }

        boolean a() {
            return false;
        }

        boolean b(int i7) {
            return false;
        }

        boolean c(int i7, Bundle bundle) {
            return false;
        }

        boolean d() {
            return false;
        }

        void e(@o0 RecyclerView.g<?> gVar) {
        }

        void f(@o0 RecyclerView.g<?> gVar) {
        }

        String g() {
            throw new IllegalStateException("Not implemented.");
        }

        void h(@m0 androidx.viewpager2.widget.b bVar, @m0 RecyclerView recyclerView) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void j(@m0 l0 l0Var) {
        }

        boolean k(int i7) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean l(int i7, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void m() {
        }

        CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        void o(@m0 AccessibilityEvent accessibilityEvent) {
        }

        void p() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }
    }

    class f extends e {
        f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i7) {
            return (i7 == 8192 || i7 == 4096) && !ViewPager2.this.l();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(@m0 l0 l0Var) {
            if (ViewPager2.this.l()) {
                return;
            }
            l0Var.K0(l0.a.f6505s);
            l0Var.K0(l0.a.f6504r);
            l0Var.F1(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i7) {
            if (b(i7)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class g extends RecyclerView.i {
        private g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void b(int i7, int i8) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void c(int i7, int i8, @o0 Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void d(int i7, int i8) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void e(int i7, int i8, int i9) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void f(int i7, int i8) {
            a();
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    private class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean M1(@m0 RecyclerView recyclerView, @m0 View view, @m0 Rect rect, boolean z7, boolean z8) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void e1(@m0 RecyclerView.v vVar, @m0 RecyclerView.a0 a0Var, @m0 l0 l0Var) {
            super.e1(vVar, a0Var, l0Var);
            ViewPager2.this.f11192t.j(l0Var);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void k2(@m0 RecyclerView.a0 a0Var, @m0 int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.k2(a0Var, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public boolean y1(@m0 RecyclerView.v vVar, @m0 RecyclerView.a0 a0Var, int i7, @o0 Bundle bundle) {
            return ViewPager2.this.f11192t.b(i7) ? ViewPager2.this.f11192t.k(i7) : super.y1(vVar, a0Var, i7, bundle);
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @e0(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    public @interface i {
    }

    public static abstract class j {
        public void a(int i7) {
        }

        public void b(int i7, float f8, @r0 int i8) {
        }

        public void c(int i7) {
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    class l extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final t0 f11202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final t0 f11203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RecyclerView.i f11204d;

        class a implements t0 {
            a() {
            }

            @Override // androidx.core.view.accessibility.t0
            public boolean a(@m0 View view, @o0 t0.a aVar) {
                l.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        class b implements t0 {
            b() {
            }

            @Override // androidx.core.view.accessibility.t0
            public boolean a(@m0 View view, @o0 t0.a aVar) {
                l.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        class c extends g {
            c() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.g, androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                l.this.w();
            }
        }

        l() {
            super(ViewPager2.this, null);
            this.f11202b = new a();
            this.f11203c = new b();
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iE;
            int iE2;
            if (ViewPager2.this.getAdapter() == null) {
                iE = 0;
                iE2 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                iE = ViewPager2.this.getAdapter().e();
                iE2 = 0;
            } else {
                iE2 = ViewPager2.this.getAdapter().e();
                iE = 0;
            }
            l0.X1(accessibilityNodeInfo).Y0(l0.b.f(iE, iE2, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int iE;
            RecyclerView.g adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (iE = adapter.e()) == 0 || !ViewPager2.this.l()) {
                return;
            }
            if (ViewPager2.this.f11176d > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.f11176d < iE - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i7, Bundle bundle) {
            return i7 == 8192 || i7 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(@o0 RecyclerView.g<?> gVar) {
            w();
            if (gVar != null) {
                gVar.C(this.f11204d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(@o0 RecyclerView.g<?> gVar) {
            if (gVar != null) {
                gVar.E(this.f11204d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(@m0 androidx.viewpager2.widget.b bVar, @m0 RecyclerView recyclerView) {
            n2.R1(recyclerView, 2);
            this.f11204d = new c();
            if (n2.V(ViewPager2.this) == 0) {
                n2.R1(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i7, Bundle bundle) {
            if (!c(i7, bundle)) {
                throw new IllegalStateException();
            }
            v(i7 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(@m0 AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
        }

        void v(int i7) {
            if (ViewPager2.this.l()) {
                ViewPager2.this.s(i7, true);
            }
        }

        void w() {
            int iE;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i7 = R.id.accessibilityActionPageLeft;
            n2.r1(viewPager2, R.id.accessibilityActionPageLeft);
            n2.r1(viewPager2, R.id.accessibilityActionPageRight);
            n2.r1(viewPager2, R.id.accessibilityActionPageUp);
            n2.r1(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (iE = ViewPager2.this.getAdapter().e()) == 0 || !ViewPager2.this.l()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.f11176d < iE - 1) {
                    n2.u1(viewPager2, new l0.a(R.id.accessibilityActionPageDown, null), null, this.f11202b);
                }
                if (ViewPager2.this.f11176d > 0) {
                    n2.u1(viewPager2, new l0.a(R.id.accessibilityActionPageUp, null), null, this.f11203c);
                    return;
                }
                return;
            }
            boolean zK = ViewPager2.this.k();
            int i8 = zK ? 16908360 : 16908361;
            if (zK) {
                i7 = 16908361;
            }
            if (ViewPager2.this.f11176d < iE - 1) {
                n2.u1(viewPager2, new l0.a(i8, null), null, this.f11202b);
            }
            if (ViewPager2.this.f11176d > 0) {
                n2.u1(viewPager2, new l0.a(i7, null), null, this.f11203c);
            }
        }
    }

    public interface m {
        void a(@m0 View view, float f8);
    }

    private class n extends x {
        n() {
        }

        @Override // androidx.recyclerview.widget.x, androidx.recyclerview.widget.b0
        @o0
        public View h(RecyclerView.o oVar) {
            if (ViewPager2.this.j()) {
                return null;
            }
            return super.h(oVar);
        }
    }

    private class o extends RecyclerView {
        o(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @c.t0(23)
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f11192t.d() ? ViewPager2.this.f11192t.n() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@m0 AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f11176d);
            accessibilityEvent.setToIndex(ViewPager2.this.f11176d);
            ViewPager2.this.f11192t.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.l() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.l() && super.onTouchEvent(motionEvent);
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface p {
    }

    private static class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RecyclerView f11211b;

        q(int i7, RecyclerView recyclerView) {
            this.f11210a = i7;
            this.f11211b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11211b.K1(this.f11210a);
        }
    }

    public ViewPager2(@m0 Context context) {
        super(context);
        this.f11173a = new Rect();
        this.f11174b = new Rect();
        this.f11175c = new androidx.viewpager2.widget.b(3);
        this.f11177e = false;
        this.f11178f = new a();
        this.f11180h = -1;
        this.f11188p = null;
        this.f11189q = false;
        this.f11190r = true;
        this.f11191s = -1;
        h(context, null);
    }

    private RecyclerView.p e() {
        return new d();
    }

    private void h(Context context, AttributeSet attributeSet) {
        this.f11192t = A ? new l() : new f();
        o oVar = new o(context);
        this.f11182j = oVar;
        oVar.setId(n2.D());
        this.f11182j.setDescendantFocusability(131072);
        h hVar = new h(context);
        this.f11179g = hVar;
        this.f11182j.setLayoutManager(hVar);
        this.f11182j.setScrollingTouchSlop(1);
        t(context, attributeSet);
        this.f11182j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f11182j.p(e());
        androidx.viewpager2.widget.g gVar = new androidx.viewpager2.widget.g(this);
        this.f11184l = gVar;
        this.f11186n = new androidx.viewpager2.widget.d(this, gVar, this.f11182j);
        n nVar = new n();
        this.f11183k = nVar;
        nVar.b(this.f11182j);
        this.f11182j.r(this.f11184l);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f11185m = bVar;
        this.f11184l.r(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f11185m.d(bVar2);
        this.f11185m.d(cVar);
        this.f11192t.h(this.f11185m, this.f11182j);
        this.f11185m.d(this.f11175c);
        androidx.viewpager2.widget.f fVar = new androidx.viewpager2.widget.f(this.f11179g);
        this.f11187o = fVar;
        this.f11185m.d(fVar);
        RecyclerView recyclerView = this.f11182j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void m(@o0 RecyclerView.g<?> gVar) {
        if (gVar != null) {
            gVar.C(this.f11178f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r() {
        RecyclerView.g adapter;
        if (this.f11180h == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f11181i;
        if (parcelable != null) {
            if (adapter instanceof androidx.viewpager2.adapter.b) {
                ((androidx.viewpager2.adapter.b) adapter).b(parcelable);
            }
            this.f11181i = null;
        }
        int iMax = Math.max(0, Math.min(this.f11180h, adapter.e() - 1));
        this.f11176d = iMax;
        this.f11180h = -1;
        this.f11182j.C1(iMax);
        this.f11192t.m();
    }

    private void t(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.viewpager2.R.styleable.ViewPager2);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, androidx.viewpager2.R.styleable.ViewPager2, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(androidx.viewpager2.R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void v(@o0 RecyclerView.g<?> gVar) {
        if (gVar != null) {
            gVar.E(this.f11178f);
        }
    }

    public void a(@m0 RecyclerView.n nVar) {
        this.f11182j.n(nVar);
    }

    public void b(@m0 RecyclerView.n nVar, int i7) {
        this.f11182j.o(nVar, i7);
    }

    public boolean c() {
        return this.f11186n.b();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i7) {
        return this.f11182j.canScrollHorizontally(i7);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i7) {
        return this.f11182j.canScrollVertically(i7);
    }

    public boolean d() {
        return this.f11186n.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i7 = ((SavedState) parcelable).f11193a;
            sparseArray.put(this.f11182j.getId(), sparseArray.get(i7));
            sparseArray.remove(i7);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        r();
    }

    public boolean f(@SuppressLint({"SupportAnnotationUsage"}) @r0 float f8) {
        return this.f11186n.e(f8);
    }

    @m0
    public RecyclerView.n g(int i7) {
        return this.f11182j.z0(i7);
    }

    @Override // android.view.ViewGroup, android.view.View
    @c.t0(23)
    public CharSequence getAccessibilityClassName() {
        return this.f11192t.a() ? this.f11192t.g() : super.getAccessibilityClassName();
    }

    @o0
    public RecyclerView.g getAdapter() {
        return this.f11182j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f11176d;
    }

    public int getItemDecorationCount() {
        return this.f11182j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f11191s;
    }

    public int getOrientation() {
        return this.f11179g.Q2();
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f11182j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f11184l.h();
    }

    public void i() {
        this.f11182j.J0();
    }

    public boolean j() {
        return this.f11186n.f();
    }

    boolean k() {
        return this.f11179g.i0() == 1;
    }

    public boolean l() {
        return this.f11190r;
    }

    public void n(@m0 j jVar) {
        this.f11175c.d(jVar);
    }

    public void o(@m0 RecyclerView.n nVar) {
        this.f11182j.p1(nVar);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f11192t.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int measuredWidth = this.f11182j.getMeasuredWidth();
        int measuredHeight = this.f11182j.getMeasuredHeight();
        this.f11173a.left = getPaddingLeft();
        this.f11173a.right = (i9 - i7) - getPaddingRight();
        this.f11173a.top = getPaddingTop();
        this.f11173a.bottom = (i10 - i8) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.f16995r, measuredWidth, measuredHeight, this.f11173a, this.f11174b);
        RecyclerView recyclerView = this.f11182j;
        Rect rect = this.f11174b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f11177e) {
            x();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        measureChild(this.f11182j, i7, i8);
        int measuredWidth = this.f11182j.getMeasuredWidth();
        int measuredHeight = this.f11182j.getMeasuredHeight();
        int measuredState = this.f11182j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i7, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i8, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f11180h = savedState.f11194b;
        this.f11181i = savedState.f11195c;
    }

    @Override // android.view.View
    @o0
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f11193a = this.f11182j.getId();
        int i7 = this.f11180h;
        if (i7 == -1) {
            i7 = this.f11176d;
        }
        savedState.f11194b = i7;
        Parcelable parcelable = this.f11181i;
        if (parcelable != null) {
            savedState.f11195c = parcelable;
        } else {
            Object adapter = this.f11182j.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.b) {
                savedState.f11195c = ((androidx.viewpager2.adapter.b) adapter).a();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public void p(int i7) {
        this.f11182j.q1(i7);
    }

    @Override // android.view.View
    @c.t0(16)
    public boolean performAccessibilityAction(int i7, Bundle bundle) {
        return this.f11192t.c(i7, bundle) ? this.f11192t.l(i7, bundle) : super.performAccessibilityAction(i7, bundle);
    }

    public void q() {
        if (this.f11187o.d() == null) {
            return;
        }
        double dG = this.f11184l.g();
        int i7 = (int) dG;
        float f8 = (float) (dG - ((double) i7));
        this.f11187o.b(i7, f8, Math.round(getPageSize() * f8));
    }

    void s(int i7, boolean z7) {
        RecyclerView.g adapter = getAdapter();
        if (adapter == null) {
            if (this.f11180h != -1) {
                this.f11180h = Math.max(i7, 0);
                return;
            }
            return;
        }
        if (adapter.e() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i7, 0), adapter.e() - 1);
        if (iMin == this.f11176d && this.f11184l.k()) {
            return;
        }
        int i8 = this.f11176d;
        if (iMin == i8 && z7) {
            return;
        }
        double dG = i8;
        this.f11176d = iMin;
        this.f11192t.q();
        if (!this.f11184l.k()) {
            dG = this.f11184l.g();
        }
        this.f11184l.p(iMin, z7);
        if (!z7) {
            this.f11182j.C1(iMin);
            return;
        }
        double d8 = iMin;
        if (Math.abs(d8 - dG) <= 3.0d) {
            this.f11182j.K1(iMin);
            return;
        }
        this.f11182j.C1(d8 > dG ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.f11182j;
        recyclerView.post(new q(iMin, recyclerView));
    }

    public void setAdapter(@o0 RecyclerView.g gVar) {
        RecyclerView.g adapter = this.f11182j.getAdapter();
        this.f11192t.f(adapter);
        v(adapter);
        this.f11182j.setAdapter(gVar);
        this.f11176d = 0;
        r();
        this.f11192t.e(gVar);
        m(gVar);
    }

    public void setCurrentItem(int i7) {
        setCurrentItem(i7, true);
    }

    @Override // android.view.View
    @c.t0(17)
    public void setLayoutDirection(int i7) {
        super.setLayoutDirection(i7);
        this.f11192t.p();
    }

    public void setOffscreenPageLimit(int i7) {
        if (i7 < 1 && i7 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f11191s = i7;
        this.f11182j.requestLayout();
    }

    public void setOrientation(int i7) {
        this.f11179g.j3(i7);
        this.f11192t.r();
    }

    public void setPageTransformer(@o0 m mVar) {
        if (mVar != null) {
            if (!this.f11189q) {
                this.f11188p = this.f11182j.getItemAnimator();
                this.f11189q = true;
            }
            this.f11182j.setItemAnimator(null);
        } else if (this.f11189q) {
            this.f11182j.setItemAnimator(this.f11188p);
            this.f11188p = null;
            this.f11189q = false;
        }
        if (mVar == this.f11187o.d()) {
            return;
        }
        this.f11187o.e(mVar);
        q();
    }

    public void setUserInputEnabled(boolean z7) {
        this.f11190r = z7;
        this.f11192t.s();
    }

    void u() {
        View viewH = this.f11183k.h(this.f11179g);
        if (viewH == null) {
            return;
        }
        int[] iArrC = this.f11183k.c(this.f11179g, viewH);
        int i7 = iArrC[0];
        if (i7 == 0 && iArrC[1] == 0) {
            return;
        }
        this.f11182j.G1(i7, iArrC[1]);
    }

    public void w(@m0 j jVar) {
        this.f11175c.e(jVar);
    }

    void x() {
        x xVar = this.f11183k;
        if (xVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewH = xVar.h(this.f11179g);
        if (viewH == null) {
            return;
        }
        int iS0 = this.f11179g.s0(viewH);
        if (iS0 != this.f11176d && getScrollState() == 0) {
            this.f11185m.c(iS0);
        }
        this.f11177e = false;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f11194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Parcelable f11195c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        @c.t0(24)
        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f11193a = parcel.readInt();
            this.f11194b = parcel.readInt();
            this.f11195c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f11193a);
            parcel.writeInt(this.f11194b);
            parcel.writeParcelable(this.f11195c, i7);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setCurrentItem(int i7, boolean z7) {
        if (j()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        s(i7, z7);
    }

    public ViewPager2(@m0 Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11173a = new Rect();
        this.f11174b = new Rect();
        this.f11175c = new androidx.viewpager2.widget.b(3);
        this.f11177e = false;
        this.f11178f = new a();
        this.f11180h = -1;
        this.f11188p = null;
        this.f11189q = false;
        this.f11190r = true;
        this.f11191s = -1;
        h(context, attributeSet);
    }

    public ViewPager2(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f11173a = new Rect();
        this.f11174b = new Rect();
        this.f11175c = new androidx.viewpager2.widget.b(3);
        this.f11177e = false;
        this.f11178f = new a();
        this.f11180h = -1;
        this.f11188p = null;
        this.f11189q = false;
        this.f11190r = true;
        this.f11191s = -1;
        h(context, attributeSet);
    }

    @c.t0(21)
    public ViewPager2(@m0 Context context, @o0 AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f11173a = new Rect();
        this.f11174b = new Rect();
        this.f11175c = new androidx.viewpager2.widget.b(3);
        this.f11177e = false;
        this.f11178f = new a();
        this.f11180h = -1;
        this.f11188p = null;
        this.f11189q = false;
        this.f11190r = true;
        this.f11191s = -1;
        h(context, attributeSet);
    }
}
