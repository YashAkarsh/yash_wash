package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.widget.ActionBarContextView;
import c.m0;
import c.x0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class e extends b implements androidx.appcompat.view.menu.g.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f1016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ActionBarContextView f1017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b.a f1018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference<View> f1019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private androidx.appcompat.view.menu.g f1022i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z7) {
        this.f1016c = context;
        this.f1017d = actionBarContextView;
        this.f1018e = aVar;
        androidx.appcompat.view.menu.g gVarZ = new androidx.appcompat.view.menu.g(actionBarContextView.getContext()).Z(1);
        this.f1022i = gVarZ;
        gVarZ.X(this);
        this.f1021h = z7;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(@m0 androidx.appcompat.view.menu.g gVar, @m0 MenuItem menuItem) {
        return this.f1018e.d(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(@m0 androidx.appcompat.view.menu.g gVar) {
        k();
        this.f1017d.o();
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f1020g) {
            return;
        }
        this.f1020g = true;
        this.f1018e.a(this);
    }

    @Override // androidx.appcompat.view.b
    public View d() {
        WeakReference<View> weakReference = this.f1019f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu e() {
        return this.f1022i;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater f() {
        return new g(this.f1017d.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f1017d.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence i() {
        return this.f1017d.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void k() {
        this.f1018e.c(this, this.f1022i);
    }

    @Override // androidx.appcompat.view.b
    public boolean l() {
        return this.f1017d.s();
    }

    @Override // androidx.appcompat.view.b
    public boolean m() {
        return this.f1021h;
    }

    @Override // androidx.appcompat.view.b
    public void n(View view) {
        this.f1017d.setCustomView(view);
        this.f1019f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void o(int i7) {
        p(this.f1016c.getString(i7));
    }

    @Override // androidx.appcompat.view.b
    public void p(CharSequence charSequence) {
        this.f1017d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void r(int i7) {
        s(this.f1016c.getString(i7));
    }

    @Override // androidx.appcompat.view.b
    public void s(CharSequence charSequence) {
        this.f1017d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void t(boolean z7) {
        super.t(z7);
        this.f1017d.setTitleOptional(z7);
    }

    public void u(androidx.appcompat.view.menu.g gVar, boolean z7) {
    }

    public void v(s sVar) {
    }

    public boolean w(s sVar) {
        if (!sVar.hasVisibleItems()) {
            return true;
        }
        new m(this.f1017d.getContext(), sVar).l();
        return true;
    }
}
