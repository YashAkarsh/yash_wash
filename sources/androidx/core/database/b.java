package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import c.m0;
import c.o0;
import c.t;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    @t0(15)
    static class a {
        private a() {
        }

        @t
        static CursorWindow a(String str) {
            return new CursorWindow(str);
        }
    }

    /* JADX INFO: renamed from: androidx.core.database.b$b, reason: collision with other inner class name */
    @t0(28)
    static class C0061b {
        private C0061b() {
        }

        @t
        static CursorWindow a(String str, long j7) {
            d.a();
            return c.a(str, j7);
        }
    }

    private b() {
    }

    @m0
    public static CursorWindow a(@o0 String str, long j7) {
        return Build.VERSION.SDK_INT >= 28 ? C0061b.a(str, j7) : a.a(str);
    }
}
