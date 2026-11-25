package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;

/* JADX INFO: loaded from: classes.dex */
public final class g2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6566b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6567c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6568d = 1001;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6569e = 1002;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6570f = 1003;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6571g = 1004;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6572h = 1006;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6573i = 1007;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6574j = 1008;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6575k = 1009;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6576l = 1010;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6577m = 1011;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6578n = 1012;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f6579o = 1013;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f6580p = 1014;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f6581q = 1015;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f6582r = 1016;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f6583s = 1017;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f6584t = 1018;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f6585u = 1019;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f6586v = 1020;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f6587w = 1021;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f6588x = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointerIcon f6589a;

    @c.t0(24)
    static class a {
        private a() {
        }

        @c.t
        static PointerIcon a(Bitmap bitmap, float f8, float f9) {
            return PointerIcon.create(bitmap, f8, f9);
        }

        @c.t
        static PointerIcon b(Context context, int i7) {
            return PointerIcon.getSystemIcon(context, i7);
        }

        @c.t
        static PointerIcon c(Resources resources, int i7) {
            return PointerIcon.load(resources, i7);
        }
    }

    private g2(PointerIcon pointerIcon) {
        this.f6589a = pointerIcon;
    }

    @c.m0
    public static g2 a(@c.m0 Bitmap bitmap, float f8, float f9) {
        return Build.VERSION.SDK_INT >= 24 ? new g2(a.a(bitmap, f8, f9)) : new g2(null);
    }

    @c.m0
    public static g2 c(@c.m0 Context context, int i7) {
        return Build.VERSION.SDK_INT >= 24 ? new g2(a.b(context, i7)) : new g2(null);
    }

    @c.m0
    public static g2 d(@c.m0 Resources resources, int i7) {
        return Build.VERSION.SDK_INT >= 24 ? new g2(a.c(resources, i7)) : new g2(null);
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public Object b() {
        return this.f6589a;
    }
}
