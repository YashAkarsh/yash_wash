package com.google.common.graph;

import com.google.common.collect.u8;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
class m<N, E> extends e<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s<N> f21648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s<E> f21649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final h0<N, q0<N, E>> f21650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final h0<E, N> f21651g;

    m(p0<? super N, ? super E> p0Var) {
        this(p0Var, p0Var.f21606c.c(p0Var.f21607d.j(10).intValue()), p0Var.f21673f.c(p0Var.f21674g.j(20).intValue()));
    }

    @Override // com.google.common.graph.o0
    public s<E> A() {
        return this.f21649e;
    }

    @Override // com.google.common.graph.o0
    public Set<E> C(N n7) {
        return I(n7).g();
    }

    protected final q0<N, E> I(N n7) {
        q0<N, E> q0VarF = this.f21650f.f(n7);
        if (q0VarF != null) {
            return q0VarF;
        }
        com.google.common.base.e0.E(n7);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", n7));
    }

    protected final N J(E e8) {
        N nF = this.f21651g.f(e8);
        if (nF != null) {
            return nF;
        }
        com.google.common.base.e0.E(e8);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", e8));
    }

    protected final boolean K(E e8) {
        return this.f21651g.e(e8);
    }

    protected final boolean L(N n7) {
        return this.f21650f.e(n7);
    }

    @Override // com.google.common.graph.o0
    public Set<E> d() {
        return this.f21651g.k();
    }

    @Override // com.google.common.graph.o0
    public boolean f() {
        return this.f21645a;
    }

    @Override // com.google.common.graph.o0
    public s<N> g() {
        return this.f21648d;
    }

    @Override // com.google.common.graph.o0
    public boolean i() {
        return this.f21647c;
    }

    @Override // com.google.common.graph.o0
    public Set<N> j(N n7) {
        return I(n7).a();
    }

    @Override // com.google.common.graph.o0
    public Set<E> k(N n7) {
        return I(n7).e();
    }

    @Override // com.google.common.graph.o0
    public Set<N> l() {
        return this.f21650f.k();
    }

    @Override // com.google.common.graph.o0
    public Set<E> s(N n7) {
        return I(n7).i();
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    public Set<E> u(N n7, N n8) {
        q0<N, E> q0VarI = I(n7);
        if (!this.f21647c && n7 == n8) {
            return u8.A();
        }
        com.google.common.base.e0.u(L(n8), "Node %s is not an element of this graph.", n8);
        return q0VarI.k(n8);
    }

    @Override // com.google.common.graph.o0
    public boolean v() {
        return this.f21646b;
    }

    @Override // com.google.common.graph.o0
    public t<N> w(E e8) {
        N nJ = J(e8);
        return t.j(this, nJ, this.f21650f.f(nJ).f(e8));
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0, com.google.common.graph.r0
    public Set<N> a(N n7) {
        return I(n7).c();
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0, com.google.common.graph.s0
    public Set<N> b(N n7) {
        return I(n7).b();
    }

    m(p0<? super N, ? super E> p0Var, Map<N, q0<N, E>> map, Map<E, N> map2) {
        this.f21645a = p0Var.f21604a;
        this.f21646b = p0Var.f21672e;
        this.f21647c = p0Var.f21605b;
        this.f21648d = (s<N>) p0Var.f21606c.a();
        this.f21649e = (s<E>) p0Var.f21673f.a();
        this.f21650f = map instanceof TreeMap ? new i0<>(map) : new h0<>(map);
        this.f21651g = new h0<>(map2);
    }
}
