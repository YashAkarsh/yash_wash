package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public final class u0 {
    private u0() {
    }

    public static void a(boolean z7) {
        if (!z7) {
            throw new v0();
        }
    }

    public static void b(boolean z7, String str, char c8) {
        if (!z7) {
            throw new v0(o0.e(str, Character.valueOf(c8)));
        }
    }

    public static void c(boolean z7, String str, char c8, char c9) {
        if (!z7) {
            throw new v0(o0.e(str, Character.valueOf(c8), Character.valueOf(c9)));
        }
    }

    public static void d(boolean z7, String str, char c8, int i7) {
        if (!z7) {
            throw new v0(o0.e(str, Character.valueOf(c8), Integer.valueOf(i7)));
        }
    }

    public static void e(boolean z7, String str, char c8, long j7) {
        if (!z7) {
            throw new v0(o0.e(str, Character.valueOf(c8), Long.valueOf(j7)));
        }
    }

    public static void f(boolean z7, String str, char c8, Object obj) {
        if (!z7) {
            throw new v0(o0.e(str, Character.valueOf(c8), obj));
        }
    }

    public static void g(boolean z7, String str, int i7) {
        if (!z7) {
            throw new v0(o0.e(str, Integer.valueOf(i7)));
        }
    }

    public static void h(boolean z7, String str, int i7, char c8) {
        if (!z7) {
            throw new v0(o0.e(str, Integer.valueOf(i7), Character.valueOf(c8)));
        }
    }

    public static void i(boolean z7, String str, int i7, int i8) {
        if (!z7) {
            throw new v0(o0.e(str, Integer.valueOf(i7), Integer.valueOf(i8)));
        }
    }

    public static void j(boolean z7, String str, int i7, long j7) {
        if (!z7) {
            throw new v0(o0.e(str, Integer.valueOf(i7), Long.valueOf(j7)));
        }
    }

    public static void k(boolean z7, String str, int i7, Object obj) {
        if (!z7) {
            throw new v0(o0.e(str, Integer.valueOf(i7), obj));
        }
    }

    public static void l(boolean z7, String str, long j7) {
        if (!z7) {
            throw new v0(o0.e(str, Long.valueOf(j7)));
        }
    }

    public static void m(boolean z7, String str, long j7, char c8) {
        if (!z7) {
            throw new v0(o0.e(str, Long.valueOf(j7), Character.valueOf(c8)));
        }
    }

    public static void n(boolean z7, String str, long j7, int i7) {
        if (!z7) {
            throw new v0(o0.e(str, Long.valueOf(j7), Integer.valueOf(i7)));
        }
    }

    public static void o(boolean z7, String str, long j7, long j8) {
        if (!z7) {
            throw new v0(o0.e(str, Long.valueOf(j7), Long.valueOf(j8)));
        }
    }

    public static void p(boolean z7, String str, long j7, Object obj) {
        if (!z7) {
            throw new v0(o0.e(str, Long.valueOf(j7), obj));
        }
    }

    public static void q(boolean z7, String str, Object obj) {
        if (!z7) {
            throw new v0(o0.e(str, obj));
        }
    }

    public static void r(boolean z7, String str, Object obj, char c8) {
        if (!z7) {
            throw new v0(o0.e(str, obj, Character.valueOf(c8)));
        }
    }

    public static void s(boolean z7, String str, Object obj, int i7) {
        if (!z7) {
            throw new v0(o0.e(str, obj, Integer.valueOf(i7)));
        }
    }

    public static void t(boolean z7, String str, Object obj, long j7) {
        if (!z7) {
            throw new v0(o0.e(str, obj, Long.valueOf(j7)));
        }
    }

    public static void u(boolean z7, String str, Object obj, Object obj2) {
        if (!z7) {
            throw new v0(o0.e(str, obj, obj2));
        }
    }

    public static void v(boolean z7, String str, Object obj, Object obj2, Object obj3) {
        if (!z7) {
            throw new v0(o0.e(str, obj, obj2, obj3));
        }
    }

    public static void w(boolean z7, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z7) {
            throw new v0(o0.e(str, obj, obj2, obj3, obj4));
        }
    }

    public static void x(boolean z7, String str, Object... objArr) {
        if (!z7) {
            throw new v0(o0.e(str, objArr));
        }
    }

    @u1.a
    public static <T> T y(T t7) {
        return (T) z(t7, "expected a non-null reference", new Object[0]);
    }

    @u1.a
    public static <T> T z(T t7, String str, Object... objArr) {
        x(t7 != null, str, objArr);
        return t7;
    }
}
