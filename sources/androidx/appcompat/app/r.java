package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.j1;
import androidx.core.util.w;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class r extends ActionBar {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final f0 f850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Window.Callback f851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final AppCompatDelegateImpl.i f852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ArrayList<ActionBar.c> f856o = new ArrayList<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Runnable f857p = new a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Toolbar.e f858q;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.F0();
        }
    }

    class b implements Toolbar.e {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            return r.this.f851j.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements androidx.appcompat.view.menu.n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f861a;

        c() {
        }

        @Override // androidx.appcompat.view.menu.n.a
        public void d(@m0 androidx.appcompat.view.menu.g gVar, boolean z7) {
            if (this.f861a) {
                return;
            }
            this.f861a = true;
            r.this.f850i.m();
            r.this.f851j.onPanelClosed(108, gVar);
            this.f861a = false;
        }

        @Override // androidx.appcompat.view.menu.n.a
        public boolean e(@m0 androidx.appcompat.view.menu.g gVar) {
            r.this.f851j.onMenuOpened(108, gVar);
            return true;
        }
    }

    private final class d implements androidx.appcompat.view.menu.g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(@m0 androidx.appcompat.view.menu.g gVar, @m0 MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(@m0 androidx.appcompat.view.menu.g gVar) {
            if (r.this.f850i.b()) {
                r.this.f851j.onPanelClosed(108, gVar);
            } else if (r.this.f851j.onPreparePanel(0, null, gVar)) {
                r.this.f851j.onMenuOpened(108, gVar);
            }
        }
    }

    private class e implements AppCompatDelegateImpl.i {
        e() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public boolean a(int i7) {
            if (i7 != 0) {
                return false;
            }
            r rVar = r.this;
            if (rVar.f853l) {
                return false;
            }
            rVar.f850i.setMenuPrepared();
            r.this.f853l = true;
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public View onCreatePanelView(int i7) {
            if (i7 == 0) {
                return new View(r.this.f850i.d());
            }
            return null;
        }
    }

    r(@m0 Toolbar toolbar, @o0 CharSequence charSequence, @m0 Window.Callback callback) {
        b bVar = new b();
        this.f858q = bVar;
        w.l(toolbar);
        j1 j1Var = new j1(toolbar, false);
        this.f850i = j1Var;
        this.f851j = (Window.Callback) w.l(callback);
        j1Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        j1Var.setWindowTitle(charSequence);
        this.f852k = new e();
    }

    private Menu E0() {
        if (!this.f854m) {
            this.f850i.F(new c(), new d());
            this.f854m = true;
        }
        return this.f850i.y();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context A() {
        return this.f850i.d();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void A0(CharSequence charSequence) {
        this.f850i.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence B() {
        return this.f850i.getTitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void B0(CharSequence charSequence) {
        this.f850i.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void C() {
        this.f850i.setVisibility(8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void C0() {
        this.f850i.setVisibility(0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean D() {
        this.f850i.G().removeCallbacks(this.f857p);
        n2.p1(this.f850i.G(), this.f857p);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean F() {
        return this.f850i.f() == 0;
    }

    void F0() {
        Menu menuE0 = E0();
        androidx.appcompat.view.menu.g gVar = menuE0 instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menuE0 : null;
        if (gVar != null) {
            gVar.m0();
        }
        try {
            menuE0.clear();
            if (!this.f851j.onCreatePanelMenu(0, menuE0) || !this.f851j.onPreparePanel(0, null, menuE0)) {
                menuE0.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.l0();
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean G() {
        return super.G();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.e H() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void I(Configuration configuration) {
        super.I(configuration);
    }

    @Override // androidx.appcompat.app.ActionBar
    void J() {
        this.f850i.G().removeCallbacks(this.f857p);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean K(int i7, KeyEvent keyEvent) {
        Menu menuE0 = E0();
        if (menuE0 == null) {
            return false;
        }
        menuE0.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE0.performShortcut(i7, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean L(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            M();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean M() {
        return this.f850i.k();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void N() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void O(ActionBar.c cVar) {
        this.f856o.remove(cVar);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void P(ActionBar.e eVar) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void Q(int i7) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean R() {
        ViewGroup viewGroupG = this.f850i.G();
        if (viewGroupG == null || viewGroupG.hasFocus()) {
            return false;
        }
        viewGroupG.requestFocus();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void S(ActionBar.e eVar) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void T(@o0 Drawable drawable) {
        this.f850i.a(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void U(int i7) {
        V(LayoutInflater.from(this.f850i.d()).inflate(i7, this.f850i.G(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void V(View view) {
        W(view, new ActionBar.LayoutParams(-2, -2));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void W(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f850i.O(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void X(boolean z7) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void Y(boolean z7) {
        a0(z7 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    @SuppressLint({"WrongConstant"})
    public void Z(int i7) {
        a0(i7, -1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void a0(int i7, int i8) {
        this.f850i.s((i7 & i8) | ((~i8) & this.f850i.L()));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void b0(boolean z7) {
        a0(z7 ? 16 : 0, 16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void c0(boolean z7) {
        a0(z7 ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void d0(boolean z7) {
        a0(z7 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void e0(boolean z7) {
        a0(z7 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void f0(float f8) {
        n2.N1(this.f850i.G(), f8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void g(ActionBar.c cVar) {
        this.f856o.add(cVar);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void h(ActionBar.e eVar) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i(ActionBar.e eVar, int i7) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void i0(int i7) {
        this.f850i.N(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void j(ActionBar.e eVar, int i7, boolean z7) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void j0(CharSequence charSequence) {
        this.f850i.t(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void k(ActionBar.e eVar, boolean z7) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void k0(int i7) {
        this.f850i.E(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean l() {
        return this.f850i.j();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void l0(Drawable drawable) {
        this.f850i.S(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean m() {
        if (!this.f850i.q()) {
            return false;
        }
        this.f850i.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void m0(boolean z7) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void n(boolean z7) {
        if (z7 == this.f855n) {
            return;
        }
        this.f855n = z7;
        int size = this.f856o.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f856o.get(i7).a(z7);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void n0(int i7) {
        this.f850i.setIcon(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public View o() {
        return this.f850i.n();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void o0(Drawable drawable) {
        this.f850i.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int p() {
        return this.f850i.L();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void p0(SpinnerAdapter spinnerAdapter, ActionBar.d dVar) {
        this.f850i.I(spinnerAdapter, new p(dVar));
    }

    @Override // androidx.appcompat.app.ActionBar
    public float q() {
        return n2.R(this.f850i.G());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void q0(int i7) {
        this.f850i.setLogo(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int r() {
        return this.f850i.e();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void r0(Drawable drawable) {
        this.f850i.p(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void s0(int i7) {
        if (i7 == 2) {
            throw new IllegalArgumentException("Tabs not supported in this configuration");
        }
        this.f850i.D(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int t() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void t0(int i7) {
        if (this.f850i.A() != 1) {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
        this.f850i.x(i7);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int u() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void u0(boolean z7) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public int v() {
        return -1;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void v0(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.e w() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void w0(Drawable drawable) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence x() {
        return this.f850i.K();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void x0(int i7) {
        f0 f0Var = this.f850i;
        f0Var.u(i7 != 0 ? f0Var.d().getText(i7) : null);
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.e y(int i7) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    @Override // androidx.appcompat.app.ActionBar
    public void y0(CharSequence charSequence) {
        this.f850i.u(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int z() {
        return 0;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void z0(int i7) {
        f0 f0Var = this.f850i;
        f0Var.setTitle(i7 != 0 ? f0Var.d().getText(i7) : null);
    }
}
