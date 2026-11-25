package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6716a = 8388608;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6717b = 8388611;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6718c = 8388613;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6719d = 8388615;

    @c.t0(17)
    static class a {
        private a() {
        }

        @c.t
        static void a(int i7, int i8, int i9, Rect rect, int i10, int i11, Rect rect2, int i12) {
            Gravity.apply(i7, i8, i9, rect, i10, i11, rect2, i12);
        }

        @c.t
        static void b(int i7, int i8, int i9, Rect rect, Rect rect2, int i10) {
            Gravity.apply(i7, i8, i9, rect, rect2, i10);
        }

        @c.t
        static void c(int i7, Rect rect, Rect rect2, int i8) {
            Gravity.applyDisplay(i7, rect, rect2, i8);
        }
    }

    private n0() {
    }

    public static void a(int i7, int i8, int i9, @c.m0 Rect rect, int i10, int i11, @c.m0 Rect rect2, int i12) {
        a.a(i7, i8, i9, rect, i10, i11, rect2, i12);
    }

    public static void b(int i7, int i8, int i9, @c.m0 Rect rect, @c.m0 Rect rect2, int i10) {
        a.b(i7, i8, i9, rect, rect2, i10);
    }

    public static void c(int i7, @c.m0 Rect rect, @c.m0 Rect rect2, int i8) {
        a.c(i7, rect, rect2, i8);
    }

    public static int d(int i7, int i8) {
        return Gravity.getAbsoluteGravity(i7, i8);
    }
}
