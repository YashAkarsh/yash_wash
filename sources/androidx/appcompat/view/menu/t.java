package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
class t extends p implements SubMenu {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final k.d f1287p;

    t(Context context, k.d dVar) {
        super(context, dVar);
        this.f1287p = dVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f1287p.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return e(this.f1287p.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i7) {
        this.f1287p.setHeaderIcon(i7);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i7) {
        this.f1287p.setHeaderTitle(i7);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f1287p.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i7) {
        this.f1287p.setIcon(i7);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f1287p.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f1287p.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1287p.setIcon(drawable);
        return this;
    }
}
