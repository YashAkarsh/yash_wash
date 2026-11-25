package androidx.core.widget;

import android.view.View;
import android.widget.ListPopupWindow;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    @t0(19)
    static class a {
        private a() {
        }

        @c.t
        static View.OnTouchListener a(ListPopupWindow listPopupWindow, View view) {
            return listPopupWindow.createDragToOpenListener(view);
        }
    }

    private o() {
    }

    @o0
    public static View.OnTouchListener a(@m0 ListPopupWindow listPopupWindow, @m0 View view) {
        return a.a(listPopupWindow, view);
    }

    @Deprecated
    public static View.OnTouchListener b(Object obj, View view) {
        return a((ListPopupWindow) obj, view);
    }
}
