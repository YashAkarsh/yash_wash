package junit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f34362a;

    public j() {
        this.f34362a = null;
    }

    public static void A(Object obj, Object obj2) {
        a.A(obj, obj2);
    }

    public static void B(String str, Object obj, Object obj2) {
        a.B(str, obj, obj2);
    }

    public static void C(Object obj) {
        a.C(obj);
    }

    public static void D(String str, Object obj) {
        a.D(str, obj);
    }

    public static void E(Object obj, Object obj2) {
        a.E(obj, obj2);
    }

    public static void F(String str, Object obj, Object obj2) {
        a.F(str, obj, obj2);
    }

    public static void G(String str, boolean z7) {
        a.G(str, z7);
    }

    public static void H(boolean z7) {
        a.H(z7);
    }

    public static void I() {
        a.I();
    }

    public static void J(String str) {
        a.J(str);
    }

    public static void K(String str, Object obj, Object obj2) {
        a.K(str, obj, obj2);
    }

    public static void L(String str, Object obj, Object obj2) {
        a.L(str, obj, obj2);
    }

    public static void M(String str) {
        a.M(str);
    }

    public static String N(String str, Object obj, Object obj2) {
        return a.N(str, obj, obj2);
    }

    public static void b(byte b8, byte b9) {
        a.b(b8, b9);
    }

    public static void d(char c8, char c9) {
        a.d(c8, c9);
    }

    public static void e(double d8, double d9, double d10) {
        a.e(d8, d9, d10);
    }

    public static void f(float f8, float f9, float f10) {
        a.f(f8, f9, f10);
    }

    public static void g(int i7, int i8) {
        a.g(i7, i8);
    }

    public static void h(long j7, long j8) {
        a.h(j7, j8);
    }

    public static void i(Object obj, Object obj2) {
        a.i(obj, obj2);
    }

    public static void j(String str, byte b8, byte b9) {
        a.j(str, b8, b9);
    }

    public static void k(String str, char c8, char c9) {
        a.k(str, c8, c9);
    }

    public static void l(String str, double d8, double d9, double d10) {
        a.l(str, d8, d9, d10);
    }

    public static void m(String str, float f8, float f9, float f10) {
        a.m(str, f8, f9, f10);
    }

    public static void n(String str, int i7, int i8) {
        a.n(str, i7, i8);
    }

    public static void o(String str, long j7, long j8) {
        a.o(str, j7, j8);
    }

    public static void p(String str, Object obj, Object obj2) {
        a.p(str, obj, obj2);
    }

    public static void q(String str, String str2) {
        a.q(str, str2);
    }

    public static void r(String str, String str2, String str3) {
        a.r(str, str2, str3);
    }

    public static void s(String str, short s7, short s8) {
        a.s(str, s7, s8);
    }

    public static void t(String str, boolean z7, boolean z8) {
        a.t(str, z7, z8);
    }

    public static void u(short s7, short s8) {
        a.u(s7, s8);
    }

    public static void v(boolean z7, boolean z8) {
        a.v(z7, z8);
    }

    public static void w(String str, boolean z7) {
        a.w(str, z7);
    }

    public static void x(boolean z7) {
        a.x(z7);
    }

    public static void y(Object obj) {
        a.y(obj);
    }

    public static void z(String str, Object obj) {
        a.z(str, obj);
    }

    protected m O() {
        return new m();
    }

    public String P() {
        return this.f34362a;
    }

    public m Q() {
        m mVarO = O();
        c(mVarO);
        return mVarO;
    }

    public void R() throws Throwable {
        U();
        try {
            S();
            try {
                V();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                V();
            } catch (Throwable unused) {
            }
        }
        if (th != null) {
            throw th;
        }
    }

    protected void S() throws Throwable {
        z("TestCase.fName cannot be null", this.f34362a);
        Method method = null;
        try {
            method = getClass().getMethod(this.f34362a, null);
        } catch (NoSuchMethodException unused) {
            J("Method \"" + this.f34362a + "\" not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            J("Method \"" + this.f34362a + "\" should be public");
        }
        try {
            method.invoke(this, new Object[0]);
        } catch (IllegalAccessException e8) {
            e8.fillInStackTrace();
            throw e8;
        } catch (InvocationTargetException e9) {
            e9.fillInStackTrace();
            throw e9.getTargetException();
        }
    }

    public void T(String str) {
        this.f34362a = str;
    }

    protected void U() throws Exception {
    }

    protected void V() throws Exception {
    }

    @Override // junit.framework.i
    public int a() {
        return 1;
    }

    @Override // junit.framework.i
    public void c(m mVar) {
        mVar.k(this);
    }

    public String toString() {
        return P() + "(" + getClass().getName() + ")";
    }

    public j(String str) {
        this.f34362a = str;
    }
}
