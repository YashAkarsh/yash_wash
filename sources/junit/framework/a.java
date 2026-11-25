package junit.framework;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class a {
    protected a() {
    }

    public static void A(Object obj, Object obj2) {
        B(null, obj, obj2);
    }

    public static void B(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            M(str);
        }
    }

    public static void C(Object obj) {
        if (obj != null) {
            D("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    public static void D(String str, Object obj) {
        G(str, obj == null);
    }

    public static void E(Object obj, Object obj2) {
        F(null, obj, obj2);
    }

    public static void F(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        L(str, obj, obj2);
    }

    public static void G(String str, boolean z7) {
        if (z7) {
            return;
        }
        J(str);
    }

    public static void H(boolean z7) {
        G(null, z7);
    }

    public static void I() {
        J(null);
    }

    public static void J(String str) {
        if (str != null) {
            throw new b(str);
        }
        throw new b();
    }

    public static void K(String str, Object obj, Object obj2) {
        J(N(str, obj, obj2));
    }

    public static void L(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        J(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    public static void M(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        J(str2 + "expected not same");
    }

    public static String N(String str, Object obj, Object obj2) {
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }

    public static void b(byte b8, byte b9) {
        j(null, b8, b9);
    }

    public static void d(char c8, char c9) {
        k(null, c8, c9);
    }

    public static void e(double d8, double d9, double d10) {
        l(null, d8, d9, d10);
    }

    public static void f(float f8, float f9, float f10) {
        m(null, f8, f9, f10);
    }

    public static void g(int i7, int i8) {
        n(null, i7, i8);
    }

    public static void h(long j7, long j8) {
        o(null, j7, j8);
    }

    public static void i(Object obj, Object obj2) {
        p(null, obj, obj2);
    }

    public static void j(String str, byte b8, byte b9) {
        p(str, Byte.valueOf(b8), Byte.valueOf(b9));
    }

    public static void k(String str, char c8, char c9) {
        p(str, Character.valueOf(c8), Character.valueOf(c9));
    }

    public static void l(String str, double d8, double d9, double d10) {
        if (Double.compare(d8, d9) != 0 && Math.abs(d8 - d9) > d10) {
            K(str, new Double(d8), new Double(d9));
        }
    }

    public static void m(String str, float f8, float f9, float f10) {
        if (Float.compare(f8, f9) != 0 && Math.abs(f8 - f9) > f10) {
            K(str, new Float(f8), new Float(f9));
        }
    }

    public static void n(String str, int i7, int i8) {
        p(str, Integer.valueOf(i7), Integer.valueOf(i8));
    }

    public static void o(String str, long j7, long j8) {
        p(str, Long.valueOf(j7), Long.valueOf(j8));
    }

    public static void p(String str, Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj == null || !obj.equals(obj2)) {
            K(str, obj, obj2);
        }
    }

    public static void q(String str, String str2) {
        r(null, str, str2);
    }

    public static void r(String str, String str2, String str3) {
        if (str2 == null && str3 == null) {
            return;
        }
        if (str2 == null || !str2.equals(str3)) {
            if (str == null) {
                str = "";
            }
            throw new d(str, str2, str3);
        }
    }

    public static void s(String str, short s7, short s8) {
        p(str, Short.valueOf(s7), Short.valueOf(s8));
    }

    public static void t(String str, boolean z7, boolean z8) {
        p(str, Boolean.valueOf(z7), Boolean.valueOf(z8));
    }

    public static void u(short s7, short s8) {
        s(null, s7, s8);
    }

    public static void v(boolean z7, boolean z8) {
        t(null, z7, z8);
    }

    public static void w(String str, boolean z7) {
        G(str, !z7);
    }

    public static void x(boolean z7) {
        w(null, z7);
    }

    public static void y(Object obj) {
        z(null, obj);
    }

    public static void z(String str, Object obj) {
        G(str, obj != null);
    }
}
