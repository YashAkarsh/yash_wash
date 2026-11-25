package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class l1 {

    @c.t0(26)
    static class a {
        private a() {
        }

        @c.t
        static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private l1() {
    }

    public static void a(@c.m0 View view, @c.o0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.a(view, charSequence);
        } else {
            o1.h(view, charSequence);
        }
    }
}
