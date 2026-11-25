package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.appcompat.view.menu.g f1995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f1996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final androidx.appcompat.view.menu.m f1997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    e f1998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    d f1999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View.OnTouchListener f2000g;

    class a implements androidx.appcompat.view.menu.g.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(@c.m0 androidx.appcompat.view.menu.g gVar, @c.m0 MenuItem menuItem) {
            e eVar = v0.this.f1998e;
            if (eVar != null) {
                return eVar.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(@c.m0 androidx.appcompat.view.menu.g gVar) {
        }
    }

    class b implements PopupWindow.OnDismissListener {
        b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            v0 v0Var = v0.this;
            d dVar = v0Var.f1999f;
            if (dVar != null) {
                dVar.a(v0Var);
            }
        }
    }

    class c extends p0 {
        c(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.p0
        public androidx.appcompat.view.menu.q b() {
            return v0.this.f1997d.e();
        }

        @Override // androidx.appcompat.widget.p0
        protected boolean c() {
            v0.this.l();
            return true;
        }

        @Override // androidx.appcompat.widget.p0
        protected boolean d() {
            v0.this.a();
            return true;
        }
    }

    public interface d {
        void a(v0 v0Var);
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public v0(@c.m0 Context context, @c.m0 View view) {
        this(context, view, 0);
    }

    public void a() {
        this.f1997d.dismiss();
    }

    @c.m0
    public View.OnTouchListener b() {
        if (this.f2000g == null) {
            this.f2000g = new c(this.f1996c);
        }
        return this.f2000g;
    }

    public int c() {
        return this.f1997d.c();
    }

    @c.m0
    public Menu d() {
        return this.f1995b;
    }

    @c.m0
    public MenuInflater e() {
        return new androidx.appcompat.view.g(this.f1994a);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    ListView f() {
        if (this.f1997d.f()) {
            return this.f1997d.d();
        }
        return null;
    }

    public void g(@c.k0 int i7) {
        e().inflate(i7, this.f1995b);
    }

    public void h(boolean z7) {
        this.f1997d.i(z7);
    }

    public void i(int i7) {
        this.f1997d.j(i7);
    }

    public void j(@c.o0 d dVar) {
        this.f1999f = dVar;
    }

    public void k(@c.o0 e eVar) {
        this.f1998e = eVar;
    }

    public void l() {
        this.f1997d.l();
    }

    public v0(@c.m0 Context context, @c.m0 View view, int i7) {
        this(context, view, i7, R.attr.popupMenuStyle, 0);
    }

    public v0(@c.m0 Context context, @c.m0 View view, int i7, @c.f int i8, @c.b1 int i9) {
        this.f1994a = context;
        this.f1996c = view;
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        this.f1995b = gVar;
        gVar.X(new a());
        androidx.appcompat.view.menu.m mVar = new androidx.appcompat.view.menu.m(context, gVar, view, false, i8, i9);
        this.f1997d = mVar;
        mVar.j(i7);
        mVar.k(new b());
    }
}
