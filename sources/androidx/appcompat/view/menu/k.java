package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import c.t0;
import c.x0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class k extends androidx.appcompat.view.menu.c implements MenuItem {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final String f1236q = "MenuItemWrapper";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final k.c f1237o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Method f1238p;

    private class a extends androidx.core.view.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final ActionProvider f1239e;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f1239e = actionProvider;
        }

        @Override // androidx.core.view.b
        public boolean b() {
            return this.f1239e.hasSubMenu();
        }

        @Override // androidx.core.view.b
        public View d() {
            return this.f1239e.onCreateActionView();
        }

        @Override // androidx.core.view.b
        public boolean f() {
            return this.f1239e.onPerformDefaultAction();
        }

        @Override // androidx.core.view.b
        public void g(SubMenu subMenu) {
            this.f1239e.onPrepareSubMenu(k.this.f(subMenu));
        }
    }

    @t0(16)
    private class b extends a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private androidx.core.view.b.InterfaceC0079b f1241g;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.b
        public boolean c() {
            return this.f1239e.isVisible();
        }

        @Override // androidx.core.view.b
        public View e(MenuItem menuItem) {
            return this.f1239e.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.b
        public boolean h() {
            return this.f1239e.overridesItemVisibility();
        }

        @Override // androidx.core.view.b
        public void i() {
            this.f1239e.refreshVisibility();
        }

        @Override // androidx.core.view.b
        public void l(androidx.core.view.b.InterfaceC0079b interfaceC0079b) {
            this.f1241g = interfaceC0079b;
            this.f1239e.setVisibilityListener(interfaceC0079b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z7) {
            androidx.core.view.b.InterfaceC0079b interfaceC0079b = this.f1241g;
            if (interfaceC0079b != null) {
                interfaceC0079b.onActionProviderVisibilityChanged(z7);
            }
        }
    }

    static class c extends FrameLayout implements androidx.appcompat.view.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CollapsibleActionView f1243a;

        /* JADX WARN: Multi-variable type inference failed */
        c(View view) {
            super(view.getContext());
            this.f1243a = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f1243a;
        }

        @Override // androidx.appcompat.view.c
        public void b() {
            this.f1243a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.c
        public void c() {
            this.f1243a.onActionViewCollapsed();
        }
    }

    private class d implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f1244a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f1244a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f1244a.onMenuItemActionCollapse(k.this.e(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f1244a.onMenuItemActionExpand(k.this.e(menuItem));
        }
    }

    private class e implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f1246a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f1246a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f1246a.onMenuItemClick(k.this.e(menuItem));
        }
    }

    public k(Context context, k.c cVar) {
        super(context);
        if (cVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1237o = cVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f1237o.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f1237o.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.view.b bVarB = this.f1237o.b();
        if (bVarB instanceof a) {
            return ((a) bVarB).f1239e;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f1237o.getActionView();
        return actionView instanceof c ? ((c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1237o.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1237o.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1237o.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1237o.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1237o.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1237o.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1237o.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1237o.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1237o.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1237o.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1237o.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1237o.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1237o.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return f(this.f1237o.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1237o.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f1237o.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1237o.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1237o.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1237o.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f1237o.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f1237o.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f1237o.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f1237o.isVisible();
    }

    public void j(boolean z7) {
        try {
            if (this.f1238p == null) {
                this.f1238p = this.f1237o.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1238p.invoke(this.f1237o, Boolean.valueOf(z7));
        } catch (Exception e8) {
            Log.w(f1236q, "Error while calling setExclusiveCheckable", e8);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f1141l, actionProvider);
        k.c cVar = this.f1237o;
        if (actionProvider == null) {
            bVar = null;
        }
        cVar.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f1237o.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8) {
        this.f1237o.setAlphabeticShortcut(c8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        this.f1237o.setCheckable(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        this.f1237o.setChecked(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f1237o.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        this.f1237o.setEnabled(z7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1237o.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1237o.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1237o.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1237o.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c8) {
        this.f1237o.setNumericShortcut(c8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1237o.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1237o.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9) {
        this.f1237o.setShortcut(c8, c9);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i7) {
        this.f1237o.setShowAsAction(i7);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i7) {
        this.f1237o.setShowAsActionFlags(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1237o.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1237o.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f1237o.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        return this.f1237o.setVisible(z7);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8, int i7) {
        this.f1237o.setAlphabeticShortcut(c8, i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f1237o.setIcon(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c8, int i7) {
        this.f1237o.setNumericShortcut(c8, i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9, int i7, int i8) {
        this.f1237o.setShortcut(c8, c9, i7, i8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        this.f1237o.setTitle(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i7) {
        this.f1237o.setActionView(i7);
        View actionView = this.f1237o.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f1237o.setActionView(new c(actionView));
        }
        return this;
    }
}
