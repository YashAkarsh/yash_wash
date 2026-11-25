package kotlin.jvm.internal;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f34880a = "kotlin.jvm.functions.";

    public kotlin.reflect.d a(Class cls) {
        return new u(cls);
    }

    public kotlin.reflect.d b(Class cls, String str) {
        return new u(cls);
    }

    public kotlin.reflect.i c(g0 g0Var) {
        return g0Var;
    }

    public kotlin.reflect.d d(Class cls) {
        return new u(cls);
    }

    public kotlin.reflect.d e(Class cls, String str) {
        return new u(cls);
    }

    public kotlin.reflect.h f(Class cls, String str) {
        return new b1(cls, str);
    }

    @kotlin.g1(version = i2.a.f34096f)
    public kotlin.reflect.s g(kotlin.reflect.s sVar) {
        v1 v1Var = (v1) sVar;
        return new v1(sVar.c0(), sVar.d(), v1Var.A(), v1Var.y() | 2);
    }

    public kotlin.reflect.k h(u0 u0Var) {
        return u0Var;
    }

    public kotlin.reflect.l i(w0 w0Var) {
        return w0Var;
    }

    public kotlin.reflect.m j(y0 y0Var) {
        return y0Var;
    }

    @kotlin.g1(version = i2.a.f34096f)
    public kotlin.reflect.s k(kotlin.reflect.s sVar) {
        v1 v1Var = (v1) sVar;
        return new v1(sVar.c0(), sVar.d(), v1Var.A(), v1Var.y() | 4);
    }

    @kotlin.g1(version = i2.a.f34096f)
    public kotlin.reflect.s l(kotlin.reflect.s sVar, kotlin.reflect.s sVar2) {
        return new v1(sVar.c0(), sVar.d(), sVar2, ((v1) sVar).y());
    }

    public kotlin.reflect.p m(d1 d1Var) {
        return d1Var;
    }

    public kotlin.reflect.q n(f1 f1Var) {
        return f1Var;
    }

    public kotlin.reflect.r o(h1 h1Var) {
        return h1Var;
    }

    @kotlin.g1(version = "1.3")
    public String p(e0 e0Var) {
        String string = e0Var.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith(f34880a) ? string.substring(21) : string;
    }

    @kotlin.g1(version = "1.1")
    public String q(n0 n0Var) {
        return p(n0Var);
    }

    @kotlin.g1(version = "1.4")
    public void r(kotlin.reflect.t tVar, List<kotlin.reflect.s> list) {
        ((u1) tVar).c(list);
    }

    @kotlin.g1(version = "1.4")
    public kotlin.reflect.s s(kotlin.reflect.g gVar, List<kotlin.reflect.u> list, boolean z7) {
        return new v1(gVar, list, z7);
    }

    @kotlin.g1(version = "1.4")
    public kotlin.reflect.t t(Object obj, String str, kotlin.reflect.v vVar, boolean z7) {
        return new u1(obj, str, vVar, z7);
    }
}
