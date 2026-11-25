package k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public interface c extends MenuItem {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f34394g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f34395h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f34396i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f34397j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f34398k = 8;

    @m0
    c a(@o0 androidx.core.view.b bVar);

    @o0
    androidx.core.view.b b();

    boolean c();

    @Override // android.view.MenuItem
    boolean collapseActionView();

    boolean d();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    @o0
    View getActionView();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    @o0
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    @o0
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    @o0
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Override // android.view.MenuItem
    @o0
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    @m0
    MenuItem setActionView(int i7);

    @Override // android.view.MenuItem
    @m0
    MenuItem setActionView(@o0 View view);

    @Override // android.view.MenuItem
    @m0
    MenuItem setAlphabeticShortcut(char c8, int i7);

    @Override // android.view.MenuItem
    @m0
    /* bridge */ /* synthetic */ MenuItem setContentDescription(@o0 CharSequence charSequence);

    @Override // android.view.MenuItem
    @m0
    c setContentDescription(@o0 CharSequence charSequence);

    @Override // android.view.MenuItem
    @m0
    MenuItem setIconTintList(@o0 ColorStateList colorStateList);

    @Override // android.view.MenuItem
    @m0
    MenuItem setIconTintMode(@o0 PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    @m0
    MenuItem setNumericShortcut(char c8, int i7);

    @Override // android.view.MenuItem
    @m0
    MenuItem setShortcut(char c8, char c9, int i7, int i8);

    @Override // android.view.MenuItem
    void setShowAsAction(int i7);

    @Override // android.view.MenuItem
    @m0
    MenuItem setShowAsActionFlags(int i7);

    @Override // android.view.MenuItem
    @m0
    /* bridge */ /* synthetic */ MenuItem setTooltipText(@o0 CharSequence charSequence);

    @Override // android.view.MenuItem
    @m0
    c setTooltipText(@o0 CharSequence charSequence);
}
