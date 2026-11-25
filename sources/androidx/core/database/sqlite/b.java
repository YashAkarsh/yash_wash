package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import c.m0;
import c.t;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    @t0(28)
    static class a {
        private a() {
        }

        @t
        static void a(SQLiteCursor sQLiteCursor, boolean z7) {
            sQLiteCursor.setFillWindowForwardOnly(z7);
        }
    }

    private b() {
    }

    public static void a(@m0 SQLiteCursor sQLiteCursor, boolean z7) {
        if (Build.VERSION.SDK_INT >= 28) {
            a.a(sQLiteCursor, z7);
        }
    }
}
