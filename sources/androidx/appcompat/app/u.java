package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f0;
import androidx.core.view.n2;
import androidx.core.view.n4;
import androidx.core.view.o4;
import androidx.core.view.p4;
import androidx.core.view.q4;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.v;
import c.m0;
import c.x0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class u extends ActionBar implements ActionBarOverlayLayout.d {
    private static final String N = "WindowDecorActionBar";
    private static final Interpolator O = new AccelerateInterpolator();
    private static final Interpolator P = new DecelerateInterpolator();
    private static final int Q = -1;
    private static final long R = 100;
    private static final long S = 200;
    private boolean A;
    boolean D;
    boolean E;
    private boolean F;
    androidx.appcompat.view.h H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f892J;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Context f893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Activity f895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ActionBarOverlayLayout f896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ActionBarContainer f897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    f0 f898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ActionBarContextView f899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    View f900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ScrollingTabContainerView f901q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private e f903s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    d f906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    androidx.appcompat.view.b f907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    androidx.appcompat.view.b.a f908x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f909y;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ArrayList<e> f902r = new ArrayList<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f904t = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ArrayList<ActionBar.c> f910z = new ArrayList<>();
    private int B = 0;
    boolean C = true;
    private boolean G = true;
    final o4 K = new a();
    final o4 L = new b();
    final q4 M = new c();

    class a extends p4 {
        a() {
        }

        @Override // androidx.core.view.p4, androidx.core.view.o4
        public void b(View view) {
            View view2;
            u uVar = u.this;
            if (uVar.C && (view2 = uVar.f900p) != null) {
                view2.setTranslationY(0.0f);
                u.this.f897m.setTranslationY(0.0f);
            }
            u.this.f897m.setVisibility(8);
            u.this.f897m.setTransitioning(false);
            u uVar2 = u.this;
            uVar2.H = null;
            uVar2.H0();
            ActionBarOverlayLayout actionBarOverlayLayout = u.this.f896l;
            if (actionBarOverlayLayout != null) {
                n2.v1(actionBarOverlayLayout);
            }
        }
    }

    class b extends p4 {
        b() {
        }

        @Override // androidx.core.view.p4, androidx.core.view.o4
        public void b(View view) {
            u uVar = u.this;
            uVar.H = null;
            uVar.f897m.requestLayout();
        }
    }

    class c implements q4 {
        c() {
        }

        @Override // androidx.core.view.q4
        public void a(View view) {
            ((View) u.this.f897m.getParent()).invalidate();
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public class d extends androidx.appcompat.view.b implements androidx.appcompat.view.menu.g.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final androidx.appcompat.view.menu.g f915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private androidx.appcompat.view.b.a f916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WeakReference<View> f917f;

        public d(Context context, androidx.appcompat.view.b.a aVar) {
            this.f914c = context;
            this.f916e = aVar;
            androidx.appcompat.view.menu.g gVarZ = new androidx.appcompat.view.menu.g(context).Z(1);
            this.f915d = gVarZ;
            gVarZ.X(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(@m0 androidx.appcompat.view.menu.g gVar, @m0 MenuItem menuItem) {
            androidx.appcompat.view.b.a aVar = this.f916e;
            if (aVar != null) {
                return aVar.d(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(@m0 androidx.appcompat.view.menu.g gVar) {
            if (this.f916e == null) {
                return;
            }
            k();
            u.this.f899o.o();
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            u uVar = u.this;
            if (uVar.f906v != this) {
                return;
            }
            if (u.F0(uVar.D, uVar.E, false)) {
                this.f916e.a(this);
            } else {
                u uVar2 = u.this;
                uVar2.f907w = this;
                uVar2.f908x = this.f916e;
            }
            this.f916e = null;
            u.this.E0(false);
            u.this.f899o.p();
            u uVar3 = u.this;
            uVar3.f896l.setHideOnContentScrollEnabled(uVar3.f892J);
            u.this.f906v = null;
        }

        @Override // androidx.appcompat.view.b
        public View d() {
            WeakReference<View> weakReference = this.f917f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu e() {
            return this.f915d;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f914c);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return u.this.f899o.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence i() {
            return u.this.f899o.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void k() {
            if (u.this.f906v != this) {
                return;
            }
            this.f915d.m0();
            try {
                this.f916e.c(this, this.f915d);
            } finally {
                this.f915d.l0();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean l() {
            return u.this.f899o.s();
        }

        @Override // androidx.appcompat.view.b
        public void n(View view) {
            u.this.f899o.setCustomView(view);
            this.f917f = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.b
        public void o(int i7) {
            p(u.this.f893i.getResources().getString(i7));
        }

        @Override // androidx.appcompat.view.b
        public void p(CharSequence charSequence) {
            u.this.f899o.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void r(int i7) {
            s(u.this.f893i.getResources().getString(i7));
        }

        @Override // androidx.appcompat.view.b
        public void s(CharSequence charSequence) {
            u.this.f899o.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void t(boolean z7) {
            super.t(z7);
            u.this.f899o.setTitleOptional(z7);
        }

        public boolean u() {
            this.f915d.m0();
            try {
                return this.f916e.b(this, this.f915d);
            } finally {
                this.f915d.l0();
            }
        }

        public void v(androidx.appcompat.view.menu.g gVar, boolean z7) {
        }

        public void w(androidx.appcompat.view.menu.s sVar) {
        }

        public boolean x(androidx.appcompat.view.menu.s sVar) {
            if (this.f916e == null) {
                return false;
            }
            if (!sVar.hasVisibleItems()) {
                return true;
            }
            new androidx.appcompat.view.menu.m(u.this.A(), sVar).l();
            return true;
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public class e extends ActionBar.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ActionBar.f f919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Drawable f921d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f922e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private CharSequence f923f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f924g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private View f925h;

        public e() {
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public CharSequence a() {
            return this.f923f;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public View b() {
            return this.f925h;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public Drawable c() {
            return this.f921d;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public int d() {
            return this.f924g;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public Object e() {
            return this.f920c;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public CharSequence f() {
            return this.f922e;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public void g() {
            u.this.S(this);
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e h(int i7) {
            return i(u.this.f893i.getResources().getText(i7));
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e i(CharSequence charSequence) {
            this.f923f = charSequence;
            int i7 = this.f924g;
            if (i7 >= 0) {
                u.this.f901q.m(i7);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e j(int i7) {
            return k(LayoutInflater.from(u.this.A()).inflate(i7, (ViewGroup) null));
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e k(View view) {
            this.f925h = view;
            int i7 = this.f924g;
            if (i7 >= 0) {
                u.this.f901q.m(i7);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e l(int i7) {
            return m(e.a.b(u.this.f893i, i7));
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e m(Drawable drawable) {
            this.f921d = drawable;
            int i7 = this.f924g;
            if (i7 >= 0) {
                u.this.f901q.m(i7);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e n(ActionBar.f fVar) {
            this.f919b = fVar;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e o(Object obj) {
            this.f920c = obj;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e p(int i7) {
            return q(u.this.f893i.getResources().getText(i7));
        }

        @Override // androidx.appcompat.app.ActionBar.e
        public ActionBar.e q(CharSequence charSequence) {
            this.f922e = charSequence;
            int i7 = this.f924g;
            if (i7 >= 0) {
                u.this.f901q.m(i7);
            }
            return this;
        }

        public ActionBar.f r() {
            return this.f919b;
        }

        public void s(int i7) {
            this.f924g = i7;
        }
    }

    public u(Activity activity, boolean z7) {
        this.f895k = activity;
        View decorView = activity.getWindow().getDecorView();
        Q0(decorView);
        if (z7) {
            return;
        }
        this.f900p = decorView.findViewById(R.id.content);
    }

    static boolean F0(boolean z7, boolean z8, boolean z9) {
        if (z9) {
            return true;
        }
        return (z7 || z8) ? false : true;
    }

    private void G0() {
        if (this.f903s != null) {
            S(null);
        }
        this.f902r.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.f901q;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.k();
        }
        this.f904t = -1;
    }

    private void I0(ActionBar.e eVar, int i7) {
        e eVar2 = (e) eVar;
        if (eVar2.r() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        eVar2.s(i7);
        this.f902r.add(i7, eVar2);
        int size = this.f902r.size();
        while (true) {
            i7++;
            if (i7 >= size) {
                return;
            } else {
                this.f902r.get(i7).s(i7);
            }
        }
    }

    private void L0() {
        if (this.f901q != null) {
            return;
        }
        ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f893i);
        if (this.A) {
            scrollingTabContainerView.setVisibility(0);
            this.f898n.o(scrollingTabContainerView);
        } else {
            if (u() == 2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f896l;
                if (actionBarOverlayLayout != null) {
                    n2.v1(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
            this.f897m.setTabContainer(scrollingTabContainerView);
        }
        this.f901q = scrollingTabContainerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private f0 M0(View view) {
        if (view instanceof f0) {
            return (f0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void P0() {
        if (this.F) {
            this.F = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f896l;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            U0(false);
        }
    }

    private void Q0(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id.decor_content_parent);
        this.f896l = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f898n = M0(view.findViewById(androidx.appcompat.R.id.action_bar));
        this.f899o = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id.action_bar_container);
        this.f897m = actionBarContainer;
        f0 f0Var = this.f898n;
        if (f0Var == null || this.f899o == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f893i = f0Var.d();
        boolean z7 = (this.f898n.L() & 4) != 0;
        if (z7) {
            this.f905u = true;
        }
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(this.f893i);
        m0(aVarB.a() || z7);
        R0(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f893i.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            h0(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            f0(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void R0(boolean z7) {
        this.A = z7;
        if (z7) {
            this.f897m.setTabContainer(null);
            this.f898n.o(this.f901q);
        } else {
            this.f898n.o(null);
            this.f897m.setTabContainer(this.f901q);
        }
        boolean z8 = u() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f901q;
        if (scrollingTabContainerView != null) {
            if (z8) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f896l;
                if (actionBarOverlayLayout != null) {
                    n2.v1(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f898n.T(!this.A && z8);
        this.f896l.setHasNonEmbeddedTabs(!this.A && z8);
    }

    private boolean S0() {
        return n2.U0(this.f897m);
    }

    private void T0() {
        if (this.F) {
            return;
        }
        this.F = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f896l;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        U0(false);
    }

    private void U0(boolean z7) {
        if (F0(this.D, this.E, this.F)) {
            if (this.G) {
                return;
            }
            this.G = true;
            K0(z7);
            return;
        }
        if (this.G) {
            this.G = false;
            J0(z7);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context A() {
        if (this.f894j == null) {
            TypedValue typedValue = new TypedValue();
            this.f893i.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i7 = typedValue.resourceId;
            if (i7 != 0) {
                this.f894j = new ContextThemeWrapper(this.f893i, i7);
            } else {
                this.f894j = this.f893i;
            }
        }
        return this.f894j;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void A0(CharSequence charSequence) {
        this.f898n.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence B() {
        return this.f898n.getTitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void B0(CharSequence charSequence) {
        this.f898n.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void C() {
        if (this.D) {
            return;
        }
        this.D = true;
        U0(false);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void C0() {
        if (this.D) {
            this.D = false;
            U0(false);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public androidx.appcompat.view.b D0(androidx.appcompat.view.b.a aVar) {
        d dVar = this.f906v;
        if (dVar != null) {
            dVar.c();
        }
        this.f896l.setHideOnContentScrollEnabled(false);
        this.f899o.t();
        d dVar2 = new d(this.f899o.getContext(), aVar);
        if (!dVar2.u()) {
            return null;
        }
        this.f906v = dVar2;
        dVar2.k();
        this.f899o.q(dVar2);
        E0(true);
        return dVar2;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean E() {
        return this.f896l.y();
    }

    public void E0(boolean z7) {
        n4 n4VarC;
        n4 n4VarN;
        if (z7) {
            T0();
        } else {
            P0();
        }
        if (!S0()) {
            if (z7) {
                this.f898n.setVisibility(4);
                this.f899o.setVisibility(0);
                return;
            } else {
                this.f898n.setVisibility(0);
                this.f899o.setVisibility(8);
                return;
            }
        }
        if (z7) {
            n4VarN = this.f898n.C(4, R);
            n4VarC = this.f899o.n(0, S);
        } else {
            n4VarC = this.f898n.C(0, S);
            n4VarN = this.f899o.n(8, R);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.d(n4VarN, n4VarC);
        hVar.h();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean F() {
        int iR = r();
        return this.G && (iR == 0 || s() < iR);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean G() {
        f0 f0Var = this.f898n;
        return f0Var != null && f0Var.r();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.e H() {
        return new e();
    }

    void H0() {
        androidx.appcompat.view.b.a aVar = this.f908x;
        if (aVar != null) {
            aVar.a(this.f907w);
            this.f907w = null;
            this.f908x = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void I(Configuration configuration) {
        R0(androidx.appcompat.view.a.b(this.f893i).g());
    }

    public void J0(boolean z7) {
        View view;
        androidx.appcompat.view.h hVar = this.H;
        if (hVar != null) {
            hVar.a();
        }
        if (this.B != 0 || (!this.I && !z7)) {
            this.K.b(null);
            return;
        }
        this.f897m.setAlpha(1.0f);
        this.f897m.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f8 = -this.f897m.getHeight();
        if (z7) {
            int[] iArr = {0, 0};
            this.f897m.getLocationInWindow(iArr);
            f8 -= iArr[1];
        }
        n4 n4VarB = n2.g(this.f897m).B(f8);
        n4VarB.x(this.M);
        hVar2.c(n4VarB);
        if (this.C && (view = this.f900p) != null) {
            hVar2.c(n2.g(view).B(f8));
        }
        hVar2.f(O);
        hVar2.e(250L);
        hVar2.g(this.K);
        this.H = hVar2;
        hVar2.h();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean K(int i7, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f906v;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i7, keyEvent, 0);
    }

    public void K0(boolean z7) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.H;
        if (hVar != null) {
            hVar.a();
        }
        this.f897m.setVisibility(0);
        if (this.B == 0 && (this.I || z7)) {
            this.f897m.setTranslationY(0.0f);
            float f8 = -this.f897m.getHeight();
            if (z7) {
                int[] iArr = {0, 0};
                this.f897m.getLocationInWindow(iArr);
                f8 -= iArr[1];
            }
            this.f897m.setTranslationY(f8);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            n4 n4VarB = n2.g(this.f897m).B(0.0f);
            n4VarB.x(this.M);
            hVar2.c(n4VarB);
            if (this.C && (view2 = this.f900p) != null) {
                view2.setTranslationY(f8);
                hVar2.c(n2.g(this.f900p).B(0.0f));
            }
            hVar2.f(P);
            hVar2.e(250L);
            hVar2.g(this.L);
            this.H = hVar2;
            hVar2.h();
        } else {
            this.f897m.setAlpha(1.0f);
            this.f897m.setTranslationY(0.0f);
            if (this.C && (view = this.f900p) != null) {
                view.setTranslationY(0.0f);
            }
            this.L.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f896l;
        if (actionBarOverlayLayout != null) {
            n2.v1(actionBarOverlayLayout);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void N() {
        G0();
    }

    public boolean N0() {
        return this.f898n.c();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void O(ActionBar.c cVar) {
        this.f910z.remove(cVar);
    }

    public boolean O0() {
        return this.f898n.h();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void P(ActionBar.e eVar) {
        Q(eVar.d());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void Q(int i7) {
        if (this.f901q == null) {
            return;
        }
        e eVar = this.f903s;
        int iD = eVar != null ? eVar.d() : this.f904t;
        this.f901q.l(i7);
        e eVarRemove = this.f902r.remove(i7);
        if (eVarRemove != null) {
            eVarRemove.s(-1);
        }
        int size = this.f902r.size();
        for (int i8 = i7; i8 < size; i8++) {
            this.f902r.get(i8).s(i8);
        }
        if (iD == i7) {
            S(this.f902r.isEmpty() ? null : this.f902r.get(Math.max(0, i7 - 1)));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean R() {
        ViewGroup viewGroupG = this.f898n.G();
        if (viewGroupG == null || viewGroupG.hasFocus()) {
            return false;
        }
        viewGroupG.requestFocus();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void S(ActionBar.e eVar) {
        if (u() != 2) {
            this.f904t = eVar != null ? eVar.d() : -1;
            return;
        }
        v vVarX = (!(this.f895k instanceof FragmentActivity) || this.f898n.G().isInEditMode()) ? null : ((FragmentActivity) this.f895k).getSupportFragmentManager().r().x();
        e eVar2 = this.f903s;
        if (eVar2 != eVar) {
            this.f901q.setTabSelected(eVar != null ? eVar.d() : -1);
            e eVar3 = this.f903s;
            if (eVar3 != null) {
                eVar3.r().b(this.f903s, vVarX);
            }
            e eVar4 = (e) eVar;
            this.f903s = eVar4;
            if (eVar4 != null) {
                eVar4.r().a(this.f903s, vVarX);
            }
        } else if (eVar2 != null) {
            eVar2.r().c(this.f903s, vVarX);
            this.f901q.c(eVar.d());
        }
        if (vVarX == null || vVarX.B()) {
            return;
        }
        vVarX.r();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void T(Drawable drawable) {
        this.f897m.setPrimaryBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void U(int i7) {
        V(LayoutInflater.from(A()).inflate(i7, this.f898n.G(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void V(View view) {
        this.f898n.O(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void W(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f898n.O(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void X(boolean z7) {
        if (this.f905u) {
            return;
        }
        Y(z7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void Y(boolean z7) {
        a0(z7 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void Z(int i7) {
        if ((i7 & 4) != 0) {
            this.f905u = true;
        }
        this.f898n.s(i7);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.E) {
            this.E = false;
            U0(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a0(int i7, int i8) {
        int iL = this.f898n.L();
        if ((i8 & 4) != 0) {
            this.f905u = true;
        }
        this.f898n.s((i7 & i8) | ((~i8) & iL));
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b0(boolean z7) {
        a0(z7 ? 16 : 0, 16);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z7) {
        this.C = z7;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c0(boolean z7) {
        a0(z7 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.E) {
            return;
        }
        this.E = true;
        U0(true);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void d0(boolean z7) {
        a0(z7 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        androidx.appcompat.view.h hVar = this.H;
        if (hVar != null) {
            hVar.a();
            this.H = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void e0(boolean z7) {
        a0(z7 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f(int i7) {
        this.B = i7;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void f0(float f8) {
        n2.N1(this.f897m, f8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void g(ActionBar.c cVar) {
        this.f910z.add(cVar);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void g0(int i7) {
        if (i7 != 0 && !this.f896l.z()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.f896l.setActionBarHideOffset(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void h(ActionBar.e eVar) {
        k(eVar, this.f902r.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void h0(boolean z7) {
        if (z7 && !this.f896l.z()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f892J = z7;
        this.f896l.setHideOnContentScrollEnabled(z7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i(ActionBar.e eVar, int i7) {
        j(eVar, i7, this.f902r.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i0(int i7) {
        this.f898n.N(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void j(ActionBar.e eVar, int i7, boolean z7) {
        L0();
        this.f901q.a(eVar, i7, z7);
        I0(eVar, i7);
        if (z7) {
            S(eVar);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void j0(CharSequence charSequence) {
        this.f898n.t(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void k(ActionBar.e eVar, boolean z7) {
        L0();
        this.f901q.b(eVar, z7);
        I0(eVar, this.f902r.size());
        if (z7) {
            S(eVar);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void k0(int i7) {
        this.f898n.E(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void l0(Drawable drawable) {
        this.f898n.S(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean m() {
        f0 f0Var = this.f898n;
        if (f0Var == null || !f0Var.q()) {
            return false;
        }
        this.f898n.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m0(boolean z7) {
        this.f898n.H(z7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void n(boolean z7) {
        if (z7 == this.f909y) {
            return;
        }
        this.f909y = z7;
        int size = this.f910z.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f910z.get(i7).a(z7);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void n0(int i7) {
        this.f898n.setIcon(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public View o() {
        return this.f898n.n();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void o0(Drawable drawable) {
        this.f898n.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int p() {
        return this.f898n.L();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void p0(SpinnerAdapter spinnerAdapter, ActionBar.d dVar) {
        this.f898n.I(spinnerAdapter, new p(dVar));
    }

    @Override // androidx.appcompat.app.ActionBar
    public float q() {
        return n2.R(this.f897m);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void q0(int i7) {
        this.f898n.setLogo(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int r() {
        return this.f897m.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void r0(Drawable drawable) {
        this.f898n.p(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int s() {
        return this.f896l.getActionBarHideOffset();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s0(int i7) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int iA = this.f898n.A();
        if (iA == 2) {
            this.f904t = v();
            S(null);
            this.f901q.setVisibility(8);
        }
        if (iA != i7 && !this.A && (actionBarOverlayLayout = this.f896l) != null) {
            n2.v1(actionBarOverlayLayout);
        }
        this.f898n.D(i7);
        boolean z7 = false;
        if (i7 == 2) {
            L0();
            this.f901q.setVisibility(0);
            int i8 = this.f904t;
            if (i8 != -1) {
                t0(i8);
                this.f904t = -1;
            }
        }
        this.f898n.T(i7 == 2 && !this.A);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f896l;
        if (i7 == 2 && !this.A) {
            z7 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int t() {
        int iA = this.f898n.A();
        if (iA == 1) {
            return this.f898n.Q();
        }
        if (iA != 2) {
            return 0;
        }
        return this.f902r.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t0(int i7) {
        int iA = this.f898n.A();
        if (iA == 1) {
            this.f898n.x(i7);
        } else {
            if (iA != 2) {
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            }
            S(this.f902r.get(i7));
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public int u() {
        return this.f898n.A();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void u0(boolean z7) {
        androidx.appcompat.view.h hVar;
        this.I = z7;
        if (z7 || (hVar = this.H) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int v() {
        e eVar;
        int iA = this.f898n.A();
        if (iA == 1) {
            return this.f898n.M();
        }
        if (iA == 2 && (eVar = this.f903s) != null) {
            return eVar.d();
        }
        return -1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void v0(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.e w() {
        return this.f903s;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void w0(Drawable drawable) {
        this.f897m.setStackedBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence x() {
        return this.f898n.K();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void x0(int i7) {
        y0(this.f893i.getString(i7));
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.e y(int i7) {
        return this.f902r.get(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void y0(CharSequence charSequence) {
        this.f898n.u(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int z() {
        return this.f902r.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void z0(int i7) {
        A0(this.f893i.getString(i7));
    }

    public u(Dialog dialog) {
        Q0(dialog.getWindow().getDecorView());
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public u(View view) {
        Q0(view);
    }
}
