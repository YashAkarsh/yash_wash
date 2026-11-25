package androidx.core.graphics;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class r {

    @c.t0(29)
    static class a {
        private a() {
        }

        @c.t
        static ColorFilter a(int i7, Object obj) {
            q.a();
            return p.a(i7, o.a(obj));
        }
    }

    private r() {
    }

    @c.o0
    public static ColorFilter a(int i7, @c.m0 s sVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object objA = t.b.a(sVar);
            if (objA != null) {
                return a.a(i7, objA);
            }
            return null;
        }
        PorterDuff.Mode modeA = t.a(sVar);
        if (modeA != null) {
            return new PorterDuffColorFilter(i7, modeA);
        }
        return null;
    }
}
