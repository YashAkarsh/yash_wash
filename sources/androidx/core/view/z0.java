package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6944a = "MenuItemCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f6945b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f6946c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f6947d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f6948e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final int f6949f = 8;

    class a implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f6950a;

        a(c cVar) {
            this.f6950a = cVar;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f6950a.onMenuItemActionCollapse(menuItem);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f6950a.onMenuItemActionExpand(menuItem);
        }
    }

    @c.t0(26)
    static class b {
        private b() {
        }

        @c.t
        static int a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        @c.t
        static CharSequence b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        @c.t
        static ColorStateList c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        @c.t
        static PorterDuff.Mode d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        @c.t
        static int e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        @c.t
        static CharSequence f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        @c.t
        static MenuItem g(MenuItem menuItem, char c8, int i7) {
            return menuItem.setAlphabeticShortcut(c8, i7);
        }

        @c.t
        static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        @c.t
        static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        @c.t
        static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        @c.t
        static MenuItem k(MenuItem menuItem, char c8, int i7) {
            return menuItem.setNumericShortcut(c8, i7);
        }

        @c.t
        static MenuItem l(MenuItem menuItem, char c8, char c9, int i7, int i8) {
            return menuItem.setShortcut(c8, c9, i7, i8);
        }

        @c.t
        static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    @Deprecated
    public interface c {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    private z0() {
    }

    @Deprecated
    public static boolean a(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean b(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @c.o0
    public static androidx.core.view.b c(@c.m0 MenuItem menuItem) {
        if (menuItem instanceof k.c) {
            return ((k.c) menuItem).b();
        }
        Log.w(f6944a, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @Deprecated
    public static View d(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int e(@c.m0 MenuItem menuItem) {
        if (menuItem instanceof k.c) {
            return ((k.c) menuItem).getAlphabeticModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.a(menuItem);
        }
        return 0;
    }

    @c.o0
    public static CharSequence f(@c.m0 MenuItem menuItem) {
        if (menuItem instanceof k.c) {
            return ((k.c) menuItem).getContentDescription();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.b(menuItem);
        }
        return null;
    }

    @c.o0
    public static ColorStateList g(@c.m0 MenuItem menuItem) {
        if (menuItem instanceof k.c) {
            return ((k.c) menuItem).getIconTintList();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.c(menuItem);
        }
        return null;
    }

    @c.o0
    public static PorterDuff.Mode h(@c.m0 MenuItem menuItem) {
        if (menuItem instanceof k.c) {
            return ((k.c) menuItem).getIconTintMode();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.d(menuItem);
        }
        return null;
    }

    public static int i(@c.m0 MenuItem menuItem) {
        if (menuItem instanceof k.c) {
            return ((k.c) menuItem).getNumericModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.e(menuItem);
        }
        return 0;
    }

    @c.o0
    public static CharSequence j(@c.m0 MenuItem menuItem) {
        if (menuItem instanceof k.c) {
            return ((k.c) menuItem).getTooltipText();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.f(menuItem);
        }
        return null;
    }

    @Deprecated
    public static boolean k(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    @c.o0
    public static MenuItem l(@c.m0 MenuItem menuItem, @c.o0 androidx.core.view.b bVar) {
        if (menuItem instanceof k.c) {
            return ((k.c) menuItem).a(bVar);
        }
        Log.w(f6944a, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem m(MenuItem menuItem, int i7) {
        return menuItem.setActionView(i7);
    }

    @Deprecated
    public static MenuItem n(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void o(@c.m0 MenuItem menuItem, char c8, int i7) {
        if (menuItem instanceof k.c) {
            ((k.c) menuItem).setAlphabeticShortcut(c8, i7);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.g(menuItem, c8, i7);
        }
    }

    public static void p(@c.m0 MenuItem menuItem, @c.o0 CharSequence charSequence) {
        if (menuItem instanceof k.c) {
            ((k.c) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.h(menuItem, charSequence);
        }
    }

    public static void q(@c.m0 MenuItem menuItem, @c.o0 ColorStateList colorStateList) {
        if (menuItem instanceof k.c) {
            ((k.c) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.i(menuItem, colorStateList);
        }
    }

    public static void r(@c.m0 MenuItem menuItem, @c.o0 PorterDuff.Mode mode) {
        if (menuItem instanceof k.c) {
            ((k.c) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.j(menuItem, mode);
        }
    }

    public static void s(@c.m0 MenuItem menuItem, char c8, int i7) {
        if (menuItem instanceof k.c) {
            ((k.c) menuItem).setNumericShortcut(c8, i7);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.k(menuItem, c8, i7);
        }
    }

    @Deprecated
    public static MenuItem t(MenuItem menuItem, c cVar) {
        return menuItem.setOnActionExpandListener(new a(cVar));
    }

    public static void u(@c.m0 MenuItem menuItem, char c8, char c9, int i7, int i8) {
        if (menuItem instanceof k.c) {
            ((k.c) menuItem).setShortcut(c8, c9, i7, i8);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.l(menuItem, c8, c9, i7, i8);
        }
    }

    @Deprecated
    public static void v(MenuItem menuItem, int i7) {
        menuItem.setShowAsAction(i7);
    }

    public static void w(@c.m0 MenuItem menuItem, @c.o0 CharSequence charSequence) {
        if (menuItem instanceof k.c) {
            ((k.c) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.m(menuItem, charSequence);
        }
    }
}
