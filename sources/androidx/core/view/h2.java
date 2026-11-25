package androidx.core.view;

import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes.dex */
public final class h2 {

    @c.t0(19)
    static class a {
        private a() {
        }

        @c.t
        static boolean a(ScaleGestureDetector scaleGestureDetector) {
            return scaleGestureDetector.isQuickScaleEnabled();
        }

        @c.t
        static void b(ScaleGestureDetector scaleGestureDetector, boolean z7) {
            scaleGestureDetector.setQuickScaleEnabled(z7);
        }
    }

    private h2() {
    }

    public static boolean a(@c.m0 ScaleGestureDetector scaleGestureDetector) {
        return a.a(scaleGestureDetector);
    }

    @Deprecated
    public static boolean b(Object obj) {
        return a((ScaleGestureDetector) obj);
    }

    public static void c(@c.m0 ScaleGestureDetector scaleGestureDetector, boolean z7) {
        a.b(scaleGestureDetector, z7);
    }

    @Deprecated
    public static void d(Object obj, boolean z7) {
        c((ScaleGestureDetector) obj, z7);
    }
}
