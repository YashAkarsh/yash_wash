package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    @c.t0(28)
    static class a {
        private a() {
        }

        @c.t
        static void a(Menu menu, boolean z7) {
            menu.setGroupDividerEnabled(z7);
        }
    }

    private u0() {
    }

    public static void a(@c.m0 Menu menu, boolean z7) {
        if (menu instanceof k.a) {
            ((k.a) menu).setGroupDividerEnabled(z7);
        } else if (Build.VERSION.SDK_INT >= 28) {
            a.a(menu, z7);
        }
    }

    @Deprecated
    public static void b(MenuItem menuItem, int i7) {
        menuItem.setShowAsAction(i7);
    }
}
