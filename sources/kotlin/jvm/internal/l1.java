package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final m1 f34876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f34877b = " (Kotlin reflection is not available)";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.reflect.d[] f34878c;

    static {
        m1 m1Var = null;
        try {
            m1Var = (m1) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (m1Var == null) {
            m1Var = new m1();
        }
        f34876a = m1Var;
        f34878c = new kotlin.reflect.d[0];
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s A(Class cls) {
        return f34876a.s(d(cls), Collections.emptyList(), false);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s B(Class cls, kotlin.reflect.u uVar) {
        return f34876a.s(d(cls), Collections.singletonList(uVar), false);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s C(Class cls, kotlin.reflect.u uVar, kotlin.reflect.u uVar2) {
        return f34876a.s(d(cls), Arrays.asList(uVar, uVar2), false);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s D(Class cls, kotlin.reflect.u... uVarArr) {
        return f34876a.s(d(cls), kotlin.collections.p.kz(uVarArr), false);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s E(kotlin.reflect.g gVar) {
        return f34876a.s(gVar, Collections.emptyList(), false);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.t F(Object obj, String str, kotlin.reflect.v vVar, boolean z7) {
        return f34876a.t(obj, str, vVar, z7);
    }

    public static kotlin.reflect.d a(Class cls) {
        return f34876a.a(cls);
    }

    public static kotlin.reflect.d b(Class cls, String str) {
        return f34876a.b(cls, str);
    }

    public static kotlin.reflect.i c(g0 g0Var) {
        return f34876a.c(g0Var);
    }

    public static kotlin.reflect.d d(Class cls) {
        return f34876a.d(cls);
    }

    public static kotlin.reflect.d e(Class cls, String str) {
        return f34876a.e(cls, str);
    }

    public static kotlin.reflect.d[] f(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f34878c;
        }
        kotlin.reflect.d[] dVarArr = new kotlin.reflect.d[length];
        for (int i7 = 0; i7 < length; i7++) {
            dVarArr[i7] = d(clsArr[i7]);
        }
        return dVarArr;
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.h g(Class cls) {
        return f34876a.f(cls, "");
    }

    public static kotlin.reflect.h h(Class cls, String str) {
        return f34876a.f(cls, str);
    }

    @kotlin.g1(version = i2.a.f34096f)
    public static kotlin.reflect.s i(kotlin.reflect.s sVar) {
        return f34876a.g(sVar);
    }

    public static kotlin.reflect.k j(u0 u0Var) {
        return f34876a.h(u0Var);
    }

    public static kotlin.reflect.l k(w0 w0Var) {
        return f34876a.i(w0Var);
    }

    public static kotlin.reflect.m l(y0 y0Var) {
        return f34876a.j(y0Var);
    }

    @kotlin.g1(version = i2.a.f34096f)
    public static kotlin.reflect.s m(kotlin.reflect.s sVar) {
        return f34876a.k(sVar);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s n(Class cls) {
        return f34876a.s(d(cls), Collections.emptyList(), true);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s o(Class cls, kotlin.reflect.u uVar) {
        return f34876a.s(d(cls), Collections.singletonList(uVar), true);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s p(Class cls, kotlin.reflect.u uVar, kotlin.reflect.u uVar2) {
        return f34876a.s(d(cls), Arrays.asList(uVar, uVar2), true);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s q(Class cls, kotlin.reflect.u... uVarArr) {
        return f34876a.s(d(cls), kotlin.collections.p.kz(uVarArr), true);
    }

    @kotlin.g1(version = "1.4")
    public static kotlin.reflect.s r(kotlin.reflect.g gVar) {
        return f34876a.s(gVar, Collections.emptyList(), true);
    }

    @kotlin.g1(version = i2.a.f34096f)
    public static kotlin.reflect.s s(kotlin.reflect.s sVar, kotlin.reflect.s sVar2) {
        return f34876a.l(sVar, sVar2);
    }

    public static kotlin.reflect.p t(d1 d1Var) {
        return f34876a.m(d1Var);
    }

    public static kotlin.reflect.q u(f1 f1Var) {
        return f34876a.n(f1Var);
    }

    public static kotlin.reflect.r v(h1 h1Var) {
        return f34876a.o(h1Var);
    }

    @kotlin.g1(version = "1.3")
    public static String w(e0 e0Var) {
        return f34876a.p(e0Var);
    }

    @kotlin.g1(version = "1.1")
    public static String x(n0 n0Var) {
        return f34876a.q(n0Var);
    }

    @kotlin.g1(version = "1.4")
    public static void y(kotlin.reflect.t tVar, kotlin.reflect.s sVar) {
        f34876a.r(tVar, Collections.singletonList(sVar));
    }

    @kotlin.g1(version = "1.4")
    public static void z(kotlin.reflect.t tVar, kotlin.reflect.s... sVarArr) {
        f34876a.r(tVar, kotlin.collections.p.kz(sVarArr));
    }
}
