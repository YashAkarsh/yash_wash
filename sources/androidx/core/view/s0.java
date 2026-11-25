package androidx.core.view;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class s0 {

    @c.t0(17)
    static class a {
        private a() {
        }

        @c.t
        static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        @c.t
        static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        @c.t
        static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        @c.t
        static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        @c.t
        static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
            marginLayoutParams.resolveLayoutDirection(i7);
        }

        @c.t
        static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
            marginLayoutParams.setLayoutDirection(i7);
        }

        @c.t
        static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
            marginLayoutParams.setMarginEnd(i7);
        }

        @c.t
        static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
            marginLayoutParams.setMarginStart(i7);
        }
    }

    private s0() {
    }

    public static int a(@c.m0 ViewGroup.MarginLayoutParams marginLayoutParams) {
        int iA = a.a(marginLayoutParams);
        if (iA == 0 || iA == 1) {
            return iA;
        }
        return 0;
    }

    public static int b(@c.m0 ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }

    public static int c(@c.m0 ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.c(marginLayoutParams);
    }

    public static boolean d(@c.m0 ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.d(marginLayoutParams);
    }

    public static void e(@c.m0 ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        a.e(marginLayoutParams, i7);
    }

    public static void f(@c.m0 ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        a.f(marginLayoutParams, i7);
    }

    public static void g(@c.m0 ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        a.g(marginLayoutParams, i7);
    }

    public static void h(@c.m0 ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        a.h(marginLayoutParams, i7);
    }
}
