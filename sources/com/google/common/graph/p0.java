package com.google.common.graph;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class p0<N, E> extends d<N> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f21672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    s<? super E> f21673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    com.google.common.base.a0<Integer> f21674g;

    private p0(boolean z7) {
        super(z7);
        this.f21672e = false;
        this.f21673f = s.d();
        this.f21674g = com.google.common.base.a0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N, E1 extends E> p0<N1, E1> d() {
        return this;
    }

    public static p0<Object, Object> e() {
        return new p0<>(true);
    }

    public static <N, E> p0<N, E> i(o0<N, E> o0Var) {
        return new p0(o0Var.f()).a(o0Var.v()).b(o0Var.i()).j(o0Var.g()).f(o0Var.A());
    }

    public static p0<Object, Object> k() {
        return new p0<>(false);
    }

    public p0<N, E> a(boolean z7) {
        this.f21672e = z7;
        return this;
    }

    public p0<N, E> b(boolean z7) {
        this.f21605b = z7;
        return this;
    }

    public <N1 extends N, E1 extends E> l0<N1, E1> c() {
        return new k(this);
    }

    public <E1 extends E> p0<N, E1> f(s<E1> sVar) {
        p0<N, E1> p0Var = (p0<N, E1>) d();
        p0Var.f21673f = (s) com.google.common.base.e0.E(sVar);
        return p0Var;
    }

    public p0<N, E> g(int i7) {
        this.f21674g = com.google.common.base.a0.g(Integer.valueOf(d0.b(i7)));
        return this;
    }

    public p0<N, E> h(int i7) {
        this.f21607d = com.google.common.base.a0.g(Integer.valueOf(d0.b(i7)));
        return this;
    }

    public <N1 extends N> p0<N1, E> j(s<N1> sVar) {
        p0<N1, E> p0Var = (p0<N1, E>) d();
        p0Var.f21606c = (s) com.google.common.base.e0.E(sVar);
        return p0Var;
    }
}
