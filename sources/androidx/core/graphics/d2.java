package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5781a = "\udfffd";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5782b = "m";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<androidx.core.util.s<Rect, Rect>> f5783c = new ThreadLocal<>();

    @c.t0(23)
    static class a {
        private a() {
        }

        @c.t
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    @c.t0(29)
    static class b {
        private b() {
        }

        @c.t
        static void a(Paint paint, Object obj) {
            paint.setBlendMode(o.a(obj));
        }
    }

    private d2() {
    }

    public static boolean a(@c.m0 Paint paint, @c.m0 String str) {
        return a.a(paint, str);
    }

    private static androidx.core.util.s<Rect, Rect> b() {
        ThreadLocal<androidx.core.util.s<Rect, Rect>> threadLocal = f5783c;
        androidx.core.util.s<Rect, Rect> sVar = threadLocal.get();
        if (sVar == null) {
            androidx.core.util.s<Rect, Rect> sVar2 = new androidx.core.util.s<>(new Rect(), new Rect());
            threadLocal.set(sVar2);
            return sVar2;
        }
        sVar.f6387a.setEmpty();
        sVar.f6388b.setEmpty();
        return sVar;
    }

    public static boolean c(@c.m0 Paint paint, @c.o0 s sVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.a(paint, sVar != null ? t.b.a(sVar) : null);
            return true;
        }
        if (sVar == null) {
            paint.setXfermode(null);
            return true;
        }
        PorterDuff.Mode modeA = t.a(sVar);
        paint.setXfermode(modeA != null ? new PorterDuffXfermode(modeA) : null);
        return modeA != null;
    }
}
