package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    @t0(19)
    static class a {
        private a() {
        }

        @c.t
        static View.OnTouchListener a(PopupMenu popupMenu) {
            return popupMenu.getDragToOpenListener();
        }
    }

    private r() {
    }

    @o0
    public static View.OnTouchListener a(@m0 Object obj) {
        return a.a((PopupMenu) obj);
    }
}
