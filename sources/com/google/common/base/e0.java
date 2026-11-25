package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public final class e0 {
    private e0() {
    }

    public static void A(boolean z7, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, obj, obj2, obj3, obj4));
        }
    }

    public static void A0(boolean z7, String str, Object obj, long j7) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, obj, Long.valueOf(j7)));
        }
    }

    public static void B(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, objArr));
        }
    }

    public static void B0(boolean z7, String str, Object obj, Object obj2) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, obj, obj2));
        }
    }

    @u1.a
    public static int C(int i7, int i8) {
        return D(i7, i8, "index");
    }

    public static void C0(boolean z7, String str, Object obj, Object obj2, Object obj3) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, obj, obj2, obj3));
        }
    }

    @u1.a
    public static int D(int i7, int i8, String str) {
        if (i7 < 0 || i7 >= i8) {
            throw new IndexOutOfBoundsException(a(i7, i8, str));
        }
        return i7;
    }

    public static void D0(boolean z7, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, obj, obj2, obj3, obj4));
        }
    }

    @u1.a
    public static <T> T E(T t7) {
        t7.getClass();
        return t7;
    }

    public static void E0(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, objArr));
        }
    }

    @u1.a
    public static <T> T F(T t7, Object obj) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @u1.a
    public static <T> T G(T t7, String str, char c8) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Character.valueOf(c8)));
    }

    @u1.a
    public static <T> T H(T t7, String str, char c8, char c9) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Character.valueOf(c8), Character.valueOf(c9)));
    }

    @u1.a
    public static <T> T I(T t7, String str, char c8, int i7) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Character.valueOf(c8), Integer.valueOf(i7)));
    }

    @u1.a
    public static <T> T J(T t7, String str, char c8, long j7) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Character.valueOf(c8), Long.valueOf(j7)));
    }

    @u1.a
    public static <T> T K(T t7, String str, char c8, Object obj) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Character.valueOf(c8), obj));
    }

    @u1.a
    public static <T> T L(T t7, String str, int i7) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Integer.valueOf(i7)));
    }

    @u1.a
    public static <T> T M(T t7, String str, int i7, char c8) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Integer.valueOf(i7), Character.valueOf(c8)));
    }

    @u1.a
    public static <T> T N(T t7, String str, int i7, int i8) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Integer.valueOf(i7), Integer.valueOf(i8)));
    }

    @u1.a
    public static <T> T O(T t7, String str, int i7, long j7) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Integer.valueOf(i7), Long.valueOf(j7)));
    }

    @u1.a
    public static <T> T P(T t7, String str, int i7, Object obj) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Integer.valueOf(i7), obj));
    }

    @u1.a
    public static <T> T Q(T t7, String str, long j7) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Long.valueOf(j7)));
    }

    @u1.a
    public static <T> T R(T t7, String str, long j7, char c8) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Long.valueOf(j7), Character.valueOf(c8)));
    }

    @u1.a
    public static <T> T S(T t7, String str, long j7, int i7) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Long.valueOf(j7), Integer.valueOf(i7)));
    }

    @u1.a
    public static <T> T T(T t7, String str, long j7, long j8) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Long.valueOf(j7), Long.valueOf(j8)));
    }

    @u1.a
    public static <T> T U(T t7, String str, long j7, Object obj) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, Long.valueOf(j7), obj));
    }

    @u1.a
    public static <T> T V(T t7, String str, Object obj) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, obj));
    }

    @u1.a
    public static <T> T W(T t7, String str, Object obj, char c8) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, obj, Character.valueOf(c8)));
    }

    @u1.a
    public static <T> T X(T t7, String str, Object obj, int i7) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, obj, Integer.valueOf(i7)));
    }

    @u1.a
    public static <T> T Y(T t7, String str, Object obj, long j7) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, obj, Long.valueOf(j7)));
    }

    @u1.a
    public static <T> T Z(T t7, String str, Object obj, Object obj2) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, obj, obj2));
    }

    private static String a(int i7, int i8, String str) {
        if (i7 < 0) {
            return o0.e("%s (%s) must not be negative", str, Integer.valueOf(i7));
        }
        if (i8 >= 0) {
            return o0.e("%s (%s) must be less than size (%s)", str, Integer.valueOf(i7), Integer.valueOf(i8));
        }
        throw new IllegalArgumentException("negative size: " + i8);
    }

    @u1.a
    public static <T> T a0(T t7, String str, Object obj, Object obj2, Object obj3) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, obj, obj2, obj3));
    }

    private static String b(int i7, int i8, String str) {
        if (i7 < 0) {
            return o0.e("%s (%s) must not be negative", str, Integer.valueOf(i7));
        }
        if (i8 >= 0) {
            return o0.e("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i7), Integer.valueOf(i8));
        }
        throw new IllegalArgumentException("negative size: " + i8);
    }

    @u1.a
    public static <T> T b0(T t7, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, obj, obj2, obj3, obj4));
    }

    private static String c(int i7, int i8, int i9) {
        if (i7 < 0 || i7 > i9) {
            return b(i7, i9, "start index");
        }
        return (i8 < 0 || i8 > i9) ? b(i8, i9, "end index") : o0.e("end index (%s) must not be less than start index (%s)", Integer.valueOf(i8), Integer.valueOf(i7));
    }

    @u1.a
    public static <T> T c0(T t7, String str, Object... objArr) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(o0.e(str, objArr));
    }

    public static void d(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    @u1.a
    public static int d0(int i7, int i8) {
        return e0(i7, i8, "index");
    }

    public static void e(boolean z7, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @u1.a
    public static int e0(int i7, int i8, String str) {
        if (i7 < 0 || i7 > i8) {
            throw new IndexOutOfBoundsException(b(i7, i8, str));
        }
        return i7;
    }

    public static void f(boolean z7, String str, char c8) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Character.valueOf(c8)));
        }
    }

    public static void f0(int i7, int i8, int i9) {
        if (i7 < 0 || i8 < i7 || i8 > i9) {
            throw new IndexOutOfBoundsException(c(i7, i8, i9));
        }
    }

    public static void g(boolean z7, String str, char c8, char c9) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Character.valueOf(c8), Character.valueOf(c9)));
        }
    }

    public static void g0(boolean z7) {
        if (!z7) {
            throw new IllegalStateException();
        }
    }

    public static void h(boolean z7, String str, char c8, int i7) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Character.valueOf(c8), Integer.valueOf(i7)));
        }
    }

    public static void h0(boolean z7, Object obj) {
        if (!z7) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void i(boolean z7, String str, char c8, long j7) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Character.valueOf(c8), Long.valueOf(j7)));
        }
    }

    public static void i0(boolean z7, String str, char c8) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Character.valueOf(c8)));
        }
    }

    public static void j(boolean z7, String str, char c8, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Character.valueOf(c8), obj));
        }
    }

    public static void j0(boolean z7, String str, char c8, char c9) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Character.valueOf(c8), Character.valueOf(c9)));
        }
    }

    public static void k(boolean z7, String str, int i7) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Integer.valueOf(i7)));
        }
    }

    public static void k0(boolean z7, String str, char c8, int i7) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Character.valueOf(c8), Integer.valueOf(i7)));
        }
    }

    public static void l(boolean z7, String str, int i7, char c8) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Integer.valueOf(i7), Character.valueOf(c8)));
        }
    }

    public static void l0(boolean z7, String str, char c8, long j7) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Character.valueOf(c8), Long.valueOf(j7)));
        }
    }

    public static void m(boolean z7, String str, int i7, int i8) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Integer.valueOf(i7), Integer.valueOf(i8)));
        }
    }

    public static void m0(boolean z7, String str, char c8, Object obj) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Character.valueOf(c8), obj));
        }
    }

    public static void n(boolean z7, String str, int i7, long j7) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Integer.valueOf(i7), Long.valueOf(j7)));
        }
    }

    public static void n0(boolean z7, String str, int i7) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Integer.valueOf(i7)));
        }
    }

    public static void o(boolean z7, String str, int i7, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Integer.valueOf(i7), obj));
        }
    }

    public static void o0(boolean z7, String str, int i7, char c8) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Integer.valueOf(i7), Character.valueOf(c8)));
        }
    }

    public static void p(boolean z7, String str, long j7) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Long.valueOf(j7)));
        }
    }

    public static void p0(boolean z7, String str, int i7, int i8) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Integer.valueOf(i7), Integer.valueOf(i8)));
        }
    }

    public static void q(boolean z7, String str, long j7, char c8) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Long.valueOf(j7), Character.valueOf(c8)));
        }
    }

    public static void q0(boolean z7, String str, int i7, long j7) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Integer.valueOf(i7), Long.valueOf(j7)));
        }
    }

    public static void r(boolean z7, String str, long j7, int i7) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Long.valueOf(j7), Integer.valueOf(i7)));
        }
    }

    public static void r0(boolean z7, String str, int i7, Object obj) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Integer.valueOf(i7), obj));
        }
    }

    public static void s(boolean z7, String str, long j7, long j8) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Long.valueOf(j7), Long.valueOf(j8)));
        }
    }

    public static void s0(boolean z7, String str, long j7) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Long.valueOf(j7)));
        }
    }

    public static void t(boolean z7, String str, long j7, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, Long.valueOf(j7), obj));
        }
    }

    public static void t0(boolean z7, String str, long j7, char c8) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Long.valueOf(j7), Character.valueOf(c8)));
        }
    }

    public static void u(boolean z7, String str, Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, obj));
        }
    }

    public static void u0(boolean z7, String str, long j7, int i7) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Long.valueOf(j7), Integer.valueOf(i7)));
        }
    }

    public static void v(boolean z7, String str, Object obj, char c8) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, obj, Character.valueOf(c8)));
        }
    }

    public static void v0(boolean z7, String str, long j7, long j8) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Long.valueOf(j7), Long.valueOf(j8)));
        }
    }

    public static void w(boolean z7, String str, Object obj, int i7) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, obj, Integer.valueOf(i7)));
        }
    }

    public static void w0(boolean z7, String str, long j7, Object obj) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, Long.valueOf(j7), obj));
        }
    }

    public static void x(boolean z7, String str, Object obj, long j7) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, obj, Long.valueOf(j7)));
        }
    }

    public static void x0(boolean z7, String str, Object obj) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, obj));
        }
    }

    public static void y(boolean z7, String str, Object obj, Object obj2) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, obj, obj2));
        }
    }

    public static void y0(boolean z7, String str, Object obj, char c8) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, obj, Character.valueOf(c8)));
        }
    }

    public static void z(boolean z7, String str, Object obj, Object obj2, Object obj3) {
        if (!z7) {
            throw new IllegalArgumentException(o0.e(str, obj, obj2, obj3));
        }
    }

    public static void z0(boolean z7, String str, Object obj, int i7) {
        if (!z7) {
            throw new IllegalStateException(o0.e(str, obj, Integer.valueOf(i7)));
        }
    }
}
