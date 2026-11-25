package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class u {

    @c.t0(28)
    static class a {
        private a() {
        }

        @c.t
        static <T> T a(Dialog dialog, int i7) {
            return (T) dialog.requireViewById(i7);
        }
    }

    private u() {
    }

    @c.m0
    public static View a(@c.m0 Dialog dialog, int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) a.a(dialog, i7);
        }
        View viewFindViewById = dialog.findViewById(i7);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    }
}
