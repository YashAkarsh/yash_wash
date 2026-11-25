package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final int A = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f6427a = 128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f6428b = 256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f6429c = 512;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f6430d = 1024;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f6431e = 2048;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final int f6432f = 4096;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final int f6433g = 8192;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6434h = 16384;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6435i = 32768;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6436j = 65536;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6437k = 131072;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6438l = 262144;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6439m = 524288;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6440n = 1048576;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f6441o = 2097152;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f6442p = 4194304;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f6443q = 8388608;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f6444r = 16777216;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f6445s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f6446t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f6447u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f6448v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f6449w = 8;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f6450x = 16;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f6451y = 32;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f6452z = 64;

    @c.t0(16)
    static class a {
        private a() {
        }

        @c.t
        static int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getAction();
        }

        @c.t
        static int b(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getMovementGranularity();
        }

        @c.t
        static void c(AccessibilityEvent accessibilityEvent, int i7) {
            accessibilityEvent.setAction(i7);
        }

        @c.t
        static void d(AccessibilityEvent accessibilityEvent, int i7) {
            accessibilityEvent.setMovementGranularity(i7);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.accessibility.b$b, reason: collision with other inner class name */
    @c.t0(19)
    static class C0077b {
        private C0077b() {
        }

        @c.t
        static int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        @c.t
        static void b(AccessibilityEvent accessibilityEvent, int i7) {
            accessibilityEvent.setContentChangeTypes(i7);
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    private b() {
    }

    @Deprecated
    public static void a(AccessibilityEvent accessibilityEvent, s0 s0Var) {
        accessibilityEvent.appendRecord((AccessibilityRecord) s0Var.g());
    }

    @Deprecated
    public static s0 b(AccessibilityEvent accessibilityEvent) {
        return new s0(accessibilityEvent);
    }

    public static int c(@c.m0 AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }

    public static int d(@c.m0 AccessibilityEvent accessibilityEvent) {
        return C0077b.a(accessibilityEvent);
    }

    public static int e(@c.m0 AccessibilityEvent accessibilityEvent) {
        return a.b(accessibilityEvent);
    }

    @Deprecated
    public static s0 f(AccessibilityEvent accessibilityEvent, int i7) {
        return new s0(accessibilityEvent.getRecord(i7));
    }

    @Deprecated
    public static int g(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getRecordCount();
    }

    public static void h(@c.m0 AccessibilityEvent accessibilityEvent, int i7) {
        a.c(accessibilityEvent, i7);
    }

    public static void i(@c.m0 AccessibilityEvent accessibilityEvent, int i7) {
        C0077b.b(accessibilityEvent, i7);
    }

    public static void j(@c.m0 AccessibilityEvent accessibilityEvent, int i7) {
        a.d(accessibilityEvent, i7);
    }
}
