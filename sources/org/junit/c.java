package org.junit;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    protected c() {
    }

    public static void A(String str, long j7, long j8) {
        if (j7 != j8) {
            f0(str, Long.valueOf(j7), Long.valueOf(j8));
        }
    }

    public static void B(String str, Object obj, Object obj2) {
        if (b0(obj, obj2)) {
            return;
        }
        if (!(obj instanceof String) || !(obj2 instanceof String)) {
            f0(str, obj, obj2);
        } else {
            if (str == null) {
                str = "";
            }
            throw new i(str, (String) obj, (String) obj2);
        }
    }

    @Deprecated
    public static void C(String str, Object[] objArr, Object[] objArr2) {
        g(str, objArr, objArr2);
    }

    @Deprecated
    public static void D(Object[] objArr, Object[] objArr2) {
        p(objArr, objArr2);
    }

    public static void E(String str, boolean z7) {
        Y(str, !z7);
    }

    public static void F(boolean z7) {
        E(null, z7);
    }

    public static void G(double d8, double d9, double d10) {
        K(null, d8, d9, d10);
    }

    public static void H(float f8, float f9, float f10) {
        L(null, f8, f9, f10);
    }

    public static void I(long j7, long j8) {
        M(null, j7, j8);
    }

    public static void J(Object obj, Object obj2) {
        N(null, obj, obj2);
    }

    public static void K(String str, double d8, double d9, double d10) {
        if (a0(d8, d9, d10)) {
            return;
        }
        e0(str, Double.valueOf(d9));
    }

    public static void L(String str, float f8, float f9, float f10) {
        if (j0(f8, f9, f10)) {
            return;
        }
        e0(str, Float.valueOf(f9));
    }

    public static void M(String str, long j7, long j8) {
        if (j7 == j8) {
            e0(str, Long.valueOf(j8));
        }
    }

    public static void N(String str, Object obj, Object obj2) {
        if (b0(obj, obj2)) {
            e0(str, obj2);
        }
    }

    public static void O(Object obj) {
        P(null, obj);
    }

    public static void P(String str, Object obj) {
        Y(str, obj != null);
    }

    public static void Q(Object obj, Object obj2) {
        R(null, obj, obj2);
    }

    public static void R(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            i0(str);
        }
    }

    public static void S(Object obj) {
        T(null, obj);
    }

    public static void T(String str, Object obj) {
        if (obj == null) {
            return;
        }
        g0(str, obj);
    }

    public static void U(Object obj, Object obj2) {
        V(null, obj, obj2);
    }

    public static void V(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        h0(str, obj, obj2);
    }

    public static <T> void W(T t7, org.hamcrest.k<? super T> kVar) {
        X("", t7, kVar);
    }

    public static <T> void X(String str, T t7, org.hamcrest.k<? super T> kVar) {
        org.hamcrest.l.b(str, t7, kVar);
    }

    public static void Y(String str, boolean z7) {
        if (z7) {
            return;
        }
        d0(str);
    }

    public static void Z(boolean z7) {
        Y(null, z7);
    }

    public static void a(String str, byte[] bArr, byte[] bArr2) throws org.junit.internal.a {
        m0(str, bArr, bArr2);
    }

    private static boolean a0(double d8, double d9, double d10) {
        return Double.compare(d8, d9) != 0 && Math.abs(d8 - d9) > d10;
    }

    public static void b(String str, char[] cArr, char[] cArr2) throws org.junit.internal.a {
        m0(str, cArr, cArr2);
    }

    private static boolean b0(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return n0(obj, obj2);
    }

    public static void c(String str, double[] dArr, double[] dArr2, double d8) throws org.junit.internal.a {
        new org.junit.internal.f(d8).a(str, dArr, dArr2);
    }

    public static void c0() {
        d0(null);
    }

    public static void d(String str, float[] fArr, float[] fArr2, float f8) throws org.junit.internal.a {
        new org.junit.internal.f(f8).a(str, fArr, fArr2);
    }

    public static void d0(String str) {
        if (str != null) {
            throw new AssertionError(str);
        }
        throw new AssertionError();
    }

    public static void e(String str, int[] iArr, int[] iArr2) throws org.junit.internal.a {
        m0(str, iArr, iArr2);
    }

    private static void e0(String str, Object obj) {
        String str2;
        if (str != null) {
            str2 = str + ". ";
        } else {
            str2 = "Values should be different. ";
        }
        d0(str2 + "Actual: " + obj);
    }

    public static void f(String str, long[] jArr, long[] jArr2) throws org.junit.internal.a {
        m0(str, jArr, jArr2);
    }

    private static void f0(String str, Object obj, Object obj2) {
        d0(k0(str, obj, obj2));
    }

    public static void g(String str, Object[] objArr, Object[] objArr2) throws org.junit.internal.a {
        m0(str, objArr, objArr2);
    }

    private static void g0(String str, Object obj) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        d0(str2 + "expected null, but was:<" + obj + ">");
    }

    public static void h(String str, short[] sArr, short[] sArr2) throws org.junit.internal.a {
        m0(str, sArr, sArr2);
    }

    private static void h0(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        d0(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    public static void i(String str, boolean[] zArr, boolean[] zArr2) throws org.junit.internal.a {
        m0(str, zArr, zArr2);
    }

    private static void i0(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        d0(str2 + "expected not same");
    }

    public static void j(byte[] bArr, byte[] bArr2) {
        a(null, bArr, bArr2);
    }

    private static boolean j0(float f8, float f9, float f10) {
        return Float.compare(f8, f9) != 0 && Math.abs(f8 - f9) > f10;
    }

    public static void k(char[] cArr, char[] cArr2) {
        b(null, cArr, cArr2);
    }

    static String k0(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str.equals("")) {
            str2 = str + " ";
        }
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        if (strValueOf.equals(strValueOf2)) {
            return str2 + "expected: " + l0(obj, strValueOf) + " but was: " + l0(obj2, strValueOf2);
        }
        return str2 + "expected:<" + strValueOf + "> but was:<" + strValueOf2 + ">";
    }

    public static void l(double[] dArr, double[] dArr2, double d8) {
        c(null, dArr, dArr2, d8);
    }

    private static String l0(Object obj, String str) {
        return (obj == null ? "null" : obj.getClass().getName()) + "<" + str + ">";
    }

    public static void m(float[] fArr, float[] fArr2, float f8) {
        d(null, fArr, fArr2, f8);
    }

    private static void m0(String str, Object obj, Object obj2) throws org.junit.internal.a {
        new org.junit.internal.e().a(str, obj, obj2);
    }

    public static void n(int[] iArr, int[] iArr2) {
        e(null, iArr, iArr2);
    }

    private static boolean n0(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static void o(long[] jArr, long[] jArr2) {
        f(null, jArr, jArr2);
    }

    public static void p(Object[] objArr, Object[] objArr2) {
        g(null, objArr, objArr2);
    }

    public static void q(short[] sArr, short[] sArr2) {
        h(null, sArr, sArr2);
    }

    public static void r(boolean[] zArr, boolean[] zArr2) {
        i(null, zArr, zArr2);
    }

    @Deprecated
    public static void s(double d8, double d9) {
        x(null, d8, d9);
    }

    public static void t(double d8, double d9, double d10) {
        y(null, d8, d9, d10);
    }

    public static void u(float f8, float f9, float f10) {
        z(null, f8, f9, f10);
    }

    public static void v(long j7, long j8) {
        A(null, j7, j8);
    }

    public static void w(Object obj, Object obj2) {
        B(null, obj, obj2);
    }

    @Deprecated
    public static void x(String str, double d8, double d9) {
        d0("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    public static void y(String str, double d8, double d9, double d10) {
        if (a0(d8, d9, d10)) {
            f0(str, Double.valueOf(d8), Double.valueOf(d9));
        }
    }

    public static void z(String str, float f8, float f9, float f10) {
        if (j0(f8, f9, f10)) {
            f0(str, Float.valueOf(f8), Float.valueOf(f9));
        }
    }
}
