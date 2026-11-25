package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.core.view.n2;
import androidx.core.view.n4;
import androidx.core.view.p4;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class j1 implements f0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f1853s = "ToolbarWidgetWrapper";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f1854t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final long f1855u = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Toolbar f1856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f1858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Spinner f1859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f1860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f1861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f1862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f1863h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1864i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    CharSequence f1865j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f1866k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CharSequence f1867l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Window.Callback f1868m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f1869n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ActionMenuPresenter f1870o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1871p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1872q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f1873r;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final androidx.appcompat.view.menu.a f1874a;

        a() {
            this.f1874a = new androidx.appcompat.view.menu.a(j1.this.f1856a.getContext(), 0, R.id.home, 0, 0, j1.this.f1865j);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j1 j1Var = j1.this;
            Window.Callback callback = j1Var.f1868m;
            if (callback == null || !j1Var.f1869n) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1874a);
        }
    }

    class b extends p4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1876a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1877b;

        b(int i7) {
            this.f1877b = i7;
        }

        @Override // androidx.core.view.p4, androidx.core.view.o4
        public void a(View view) {
            this.f1876a = true;
        }

        @Override // androidx.core.view.p4, androidx.core.view.o4
        public void b(View view) {
            if (this.f1876a) {
                return;
            }
            j1.this.f1856a.setVisibility(this.f1877b);
        }

        @Override // androidx.core.view.p4, androidx.core.view.o4
        public void c(View view) {
            j1.this.f1856a.setVisibility(0);
        }
    }

    public j1(Toolbar toolbar, boolean z7) {
        this(toolbar, z7, androidx.appcompat.R.string.abc_action_bar_up_description, androidx.appcompat.R.drawable.abc_ic_ab_back_material);
    }

    private int U() {
        if (this.f1856a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1873r = this.f1856a.getNavigationIcon();
        return 15;
    }

    private void V() {
        if (this.f1859d == null) {
            this.f1859d = new AppCompatSpinner(d(), null, androidx.appcompat.R.attr.actionDropDownStyle);
            this.f1859d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void W(CharSequence charSequence) {
        this.f1865j = charSequence;
        if ((this.f1857b & 8) != 0) {
            this.f1856a.setTitle(charSequence);
            if (this.f1864i) {
                n2.E1(this.f1856a.getRootView(), charSequence);
            }
        }
    }

    private void X() {
        if ((this.f1857b & 4) != 0) {
            if (TextUtils.isEmpty(this.f1867l)) {
                this.f1856a.setNavigationContentDescription(this.f1872q);
            } else {
                this.f1856a.setNavigationContentDescription(this.f1867l);
            }
        }
    }

    private void Y() {
        if ((this.f1857b & 4) == 0) {
            this.f1856a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f1856a;
        Drawable drawable = this.f1863h;
        if (drawable == null) {
            drawable = this.f1873r;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void Z() {
        Drawable drawable;
        int i7 = this.f1857b;
        if ((i7 & 2) == 0) {
            drawable = null;
        } else if ((i7 & 1) == 0 || (drawable = this.f1862g) == null) {
            drawable = this.f1861f;
        }
        this.f1856a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.f0
    public int A() {
        return this.f1871p;
    }

    @Override // androidx.appcompat.widget.f0
    public void B(int i7) {
        n4 n4VarC = C(i7, f1855u);
        if (n4VarC != null) {
            n4VarC.y();
        }
    }

    @Override // androidx.appcompat.widget.f0
    public n4 C(int i7, long j7) {
        return n2.g(this.f1856a).b(i7 == 0 ? 1.0f : 0.0f).s(j7).u(new b(i7));
    }

    @Override // androidx.appcompat.widget.f0
    public void D(int i7) {
        View view;
        int i8 = this.f1871p;
        if (i7 != i8) {
            if (i8 == 1) {
                Spinner spinner = this.f1859d;
                if (spinner != null) {
                    ViewParent parent = spinner.getParent();
                    Toolbar toolbar = this.f1856a;
                    if (parent == toolbar) {
                        toolbar.removeView(this.f1859d);
                    }
                }
            } else if (i8 == 2 && (view = this.f1858c) != null) {
                ViewParent parent2 = view.getParent();
                Toolbar toolbar2 = this.f1856a;
                if (parent2 == toolbar2) {
                    toolbar2.removeView(this.f1858c);
                }
            }
            this.f1871p = i7;
            if (i7 != 0) {
                if (i7 == 1) {
                    V();
                    this.f1856a.addView(this.f1859d, 0);
                    return;
                }
                if (i7 != 2) {
                    throw new IllegalArgumentException("Invalid navigation mode " + i7);
                }
                View view2 = this.f1858c;
                if (view2 != null) {
                    this.f1856a.addView(view2, 0);
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1858c.getLayoutParams();
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                    layoutParams.f628a = BadgeDrawable.f16997t;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void E(int i7) {
        S(i7 != 0 ? e.a.b(d(), i7) : null);
    }

    @Override // androidx.appcompat.widget.f0
    public void F(androidx.appcompat.view.menu.n.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.f1856a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.f0
    public ViewGroup G() {
        return this.f1856a;
    }

    @Override // androidx.appcompat.widget.f0
    public void H(boolean z7) {
    }

    @Override // androidx.appcompat.widget.f0
    public void I(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        V();
        this.f1859d.setAdapter(spinnerAdapter);
        this.f1859d.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.widget.f0
    public void J(SparseArray<Parcelable> sparseArray) {
        this.f1856a.restoreHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.f0
    public CharSequence K() {
        return this.f1856a.getSubtitle();
    }

    @Override // androidx.appcompat.widget.f0
    public int L() {
        return this.f1857b;
    }

    @Override // androidx.appcompat.widget.f0
    public int M() {
        Spinner spinner = this.f1859d;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f0
    public void N(int i7) {
        t(i7 == 0 ? null : d().getString(i7));
    }

    @Override // androidx.appcompat.widget.f0
    public void O(View view) {
        View view2 = this.f1860e;
        if (view2 != null && (this.f1857b & 16) != 0) {
            this.f1856a.removeView(view2);
        }
        this.f1860e = view;
        if (view == null || (this.f1857b & 16) == 0) {
            return;
        }
        this.f1856a.addView(view);
    }

    @Override // androidx.appcompat.widget.f0
    public void P() {
        Log.i(f1853s, "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.f0
    public int Q() {
        Spinner spinner = this.f1859d;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f0
    public void R() {
        Log.i(f1853s, "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.f0
    public void S(Drawable drawable) {
        this.f1863h = drawable;
        Y();
    }

    @Override // androidx.appcompat.widget.f0
    public void T(boolean z7) {
        this.f1856a.setCollapsible(z7);
    }

    @Override // androidx.appcompat.widget.f0
    public void a(Drawable drawable) {
        n2.I1(this.f1856a, drawable);
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return this.f1856a.A();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean c() {
        return this.f1861f != null;
    }

    @Override // androidx.appcompat.widget.f0
    public void collapseActionView() {
        this.f1856a.e();
    }

    @Override // androidx.appcompat.widget.f0
    public Context d() {
        return this.f1856a.getContext();
    }

    @Override // androidx.appcompat.widget.f0
    public int e() {
        return this.f1856a.getHeight();
    }

    @Override // androidx.appcompat.widget.f0
    public int f() {
        return this.f1856a.getVisibility();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean g() {
        return this.f1856a.d();
    }

    @Override // androidx.appcompat.widget.f0
    public CharSequence getTitle() {
        return this.f1856a.getTitle();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean h() {
        return this.f1862g != null;
    }

    @Override // androidx.appcompat.widget.f0
    public boolean i() {
        return this.f1856a.z();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean j() {
        return this.f1856a.w();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean k() {
        return this.f1856a.L();
    }

    @Override // androidx.appcompat.widget.f0
    public void l(int i7) {
        if (i7 == this.f1872q) {
            return;
        }
        this.f1872q = i7;
        if (TextUtils.isEmpty(this.f1856a.getNavigationContentDescription())) {
            N(this.f1872q);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void m() {
        this.f1856a.f();
    }

    @Override // androidx.appcompat.widget.f0
    public View n() {
        return this.f1860e;
    }

    @Override // androidx.appcompat.widget.f0
    public void o(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1858c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1856a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1858c);
            }
        }
        this.f1858c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.f1871p != 2) {
            return;
        }
        this.f1856a.addView(scrollingTabContainerView, 0);
        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1858c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.f628a = BadgeDrawable.f16997t;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.f0
    public void p(Drawable drawable) {
        this.f1862g = drawable;
        Z();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean q() {
        return this.f1856a.v();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean r() {
        return this.f1856a.B();
    }

    @Override // androidx.appcompat.widget.f0
    public void s(int i7) {
        View view;
        int i8 = this.f1857b ^ i7;
        this.f1857b = i7;
        if (i8 != 0) {
            if ((i8 & 4) != 0) {
                if ((i7 & 4) != 0) {
                    X();
                }
                Y();
            }
            if ((i8 & 3) != 0) {
                Z();
            }
            if ((i8 & 8) != 0) {
                if ((i7 & 8) != 0) {
                    this.f1856a.setTitle(this.f1865j);
                    this.f1856a.setSubtitle(this.f1866k);
                } else {
                    this.f1856a.setTitle((CharSequence) null);
                    this.f1856a.setSubtitle((CharSequence) null);
                }
            }
            if ((i8 & 16) == 0 || (view = this.f1860e) == null) {
                return;
            }
            if ((i7 & 16) != 0) {
                this.f1856a.addView(view);
            } else {
                this.f1856a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void setIcon(int i7) {
        setIcon(i7 != 0 ? e.a.b(d(), i7) : null);
    }

    @Override // androidx.appcompat.widget.f0
    public void setLogo(int i7) {
        p(i7 != 0 ? e.a.b(d(), i7) : null);
    }

    @Override // androidx.appcompat.widget.f0
    public void setMenu(Menu menu, androidx.appcompat.view.menu.n.a aVar) {
        if (this.f1870o == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1856a.getContext());
            this.f1870o = actionMenuPresenter;
            actionMenuPresenter.t(androidx.appcompat.R.id.action_menu_presenter);
        }
        this.f1870o.i(aVar);
        this.f1856a.setMenu((androidx.appcompat.view.menu.g) menu, this.f1870o);
    }

    @Override // androidx.appcompat.widget.f0
    public void setMenuPrepared() {
        this.f1869n = true;
    }

    @Override // androidx.appcompat.widget.f0
    public void setTitle(CharSequence charSequence) {
        this.f1864i = true;
        W(charSequence);
    }

    @Override // androidx.appcompat.widget.f0
    public void setVisibility(int i7) {
        this.f1856a.setVisibility(i7);
    }

    @Override // androidx.appcompat.widget.f0
    public void setWindowCallback(Window.Callback callback) {
        this.f1868m = callback;
    }

    @Override // androidx.appcompat.widget.f0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1864i) {
            return;
        }
        W(charSequence);
    }

    @Override // androidx.appcompat.widget.f0
    public void t(CharSequence charSequence) {
        this.f1867l = charSequence;
        X();
    }

    @Override // androidx.appcompat.widget.f0
    public void u(CharSequence charSequence) {
        this.f1866k = charSequence;
        if ((this.f1857b & 8) != 0) {
            this.f1856a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void v(Drawable drawable) {
        if (this.f1873r != drawable) {
            this.f1873r = drawable;
            Y();
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void w(SparseArray<Parcelable> sparseArray) {
        this.f1856a.saveHierarchyState(sparseArray);
    }

    @Override // androidx.appcompat.widget.f0
    public void x(int i7) {
        Spinner spinner = this.f1859d;
        if (spinner == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        spinner.setSelection(i7);
    }

    @Override // androidx.appcompat.widget.f0
    public Menu y() {
        return this.f1856a.getMenu();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean z() {
        return this.f1858c != null;
    }

    public j1(Toolbar toolbar, boolean z7, int i7, int i8) {
        Drawable drawable;
        this.f1871p = 0;
        this.f1872q = 0;
        this.f1856a = toolbar;
        this.f1865j = toolbar.getTitle();
        this.f1866k = toolbar.getSubtitle();
        this.f1864i = this.f1865j != null;
        this.f1863h = toolbar.getNavigationIcon();
        h1 h1VarG = h1.G(toolbar.getContext(), null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        this.f1873r = h1VarG.h(androidx.appcompat.R.styleable.ActionBar_homeAsUpIndicator);
        if (z7) {
            CharSequence charSequenceX = h1VarG.x(androidx.appcompat.R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceX)) {
                setTitle(charSequenceX);
            }
            CharSequence charSequenceX2 = h1VarG.x(androidx.appcompat.R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceX2)) {
                u(charSequenceX2);
            }
            Drawable drawableH = h1VarG.h(androidx.appcompat.R.styleable.ActionBar_logo);
            if (drawableH != null) {
                p(drawableH);
            }
            Drawable drawableH2 = h1VarG.h(androidx.appcompat.R.styleable.ActionBar_icon);
            if (drawableH2 != null) {
                setIcon(drawableH2);
            }
            if (this.f1863h == null && (drawable = this.f1873r) != null) {
                S(drawable);
            }
            s(h1VarG.o(androidx.appcompat.R.styleable.ActionBar_displayOptions, 0));
            int iU = h1VarG.u(androidx.appcompat.R.styleable.ActionBar_customNavigationLayout, 0);
            if (iU != 0) {
                O(LayoutInflater.from(this.f1856a.getContext()).inflate(iU, (ViewGroup) this.f1856a, false));
                s(this.f1857b | 16);
            }
            int iQ = h1VarG.q(androidx.appcompat.R.styleable.ActionBar_height, 0);
            if (iQ > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1856a.getLayoutParams();
                layoutParams.height = iQ;
                this.f1856a.setLayoutParams(layoutParams);
            }
            int iF = h1VarG.f(androidx.appcompat.R.styleable.ActionBar_contentInsetStart, -1);
            int iF2 = h1VarG.f(androidx.appcompat.R.styleable.ActionBar_contentInsetEnd, -1);
            if (iF >= 0 || iF2 >= 0) {
                this.f1856a.setContentInsetsRelative(Math.max(iF, 0), Math.max(iF2, 0));
            }
            int iU2 = h1VarG.u(androidx.appcompat.R.styleable.ActionBar_titleTextStyle, 0);
            if (iU2 != 0) {
                Toolbar toolbar2 = this.f1856a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), iU2);
            }
            int iU3 = h1VarG.u(androidx.appcompat.R.styleable.ActionBar_subtitleTextStyle, 0);
            if (iU3 != 0) {
                Toolbar toolbar3 = this.f1856a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), iU3);
            }
            int iU4 = h1VarG.u(androidx.appcompat.R.styleable.ActionBar_popupTheme, 0);
            if (iU4 != 0) {
                this.f1856a.setPopupTheme(iU4);
            }
        } else {
            this.f1857b = U();
        }
        h1VarG.I();
        l(i7);
        this.f1867l = this.f1856a.getNavigationContentDescription();
        this.f1856a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.f0
    public void setIcon(Drawable drawable) {
        this.f1861f = drawable;
        Z();
    }
}
