package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class s extends g implements SubMenu {
    private g Q;
    private j R;

    public s(Context context, g gVar, j jVar) {
        super(context);
        this.Q = gVar;
        this.R = jVar;
    }

    @Override // androidx.appcompat.view.menu.g
    public g G() {
        return this.Q.G();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean I() {
        return this.Q.I();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean J() {
        return this.Q.J();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean K() {
        return this.Q.K();
    }

    @Override // androidx.appcompat.view.menu.g
    public void X(g.a aVar) {
        this.Q.X(aVar);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean g(j jVar) {
        return this.Q.g(jVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.R;
    }

    @Override // androidx.appcompat.view.menu.g
    boolean i(@m0 g gVar, @m0 MenuItem menuItem) {
        return super.i(gVar, menuItem) || this.Q.i(gVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g
    public void j0(boolean z7) {
        this.Q.j0(z7);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean n(j jVar) {
        return this.Q.n(jVar);
    }

    public Menu n0() {
        return this.Q;
    }

    @Override // androidx.appcompat.view.menu.g, k.a, android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.Q.setGroupDividerEnabled(z7);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.c0(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.f0(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.g0(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.R.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.Q.setQwertyMode(z7);
    }

    @Override // androidx.appcompat.view.menu.g
    public String w() {
        j jVar = this.R;
        int itemId = jVar != null ? jVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.w() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i7) {
        return (SubMenu) super.b0(i7);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i7) {
        return (SubMenu) super.e0(i7);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i7) {
        this.R.setIcon(i7);
        return this;
    }
}
