package androidx.core.widget;

import android.widget.ListView;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    @t0(19)
    static class a {
        private a() {
        }

        @c.t
        static boolean a(ListView listView, int i7) {
            return listView.canScrollList(i7);
        }

        @c.t
        static void b(ListView listView, int i7) {
            listView.scrollListBy(i7);
        }
    }

    private q() {
    }

    public static boolean a(@m0 ListView listView, int i7) {
        return a.a(listView, i7);
    }

    public static void b(@m0 ListView listView, int i7) {
        a.b(listView, i7);
    }
}
