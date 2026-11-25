package com.google.common.graph;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
class n<N, V> extends g<N, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s<N> f21654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final h0<N, b0<N, V>> f21655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f21656e;

    n(d<? super N> dVar) {
        this(dVar, dVar.f21606c.c(dVar.f21607d.j(10).intValue()), 0L);
    }

    @Override // com.google.common.graph.a
    protected long G() {
        return this.f21656e;
    }

    protected final b0<N, V> I(N n7) {
        b0<N, V> b0VarF = this.f21655d.f(n7);
        if (b0VarF != null) {
            return b0VarF;
        }
        com.google.common.base.e0.E(n7);
        throw new IllegalArgumentException("Node " + n7 + " is not an element of this graph.");
    }

    protected final boolean J(N n7) {
        return this.f21655d.e(n7);
    }

    @Override // com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i
    public boolean e(N n7, N n8) {
        com.google.common.base.e0.E(n7);
        com.google.common.base.e0.E(n8);
        b0<N, V> b0VarF = this.f21655d.f(n7);
        return b0VarF != null && b0VarF.b().contains(n8);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public boolean f() {
        return this.f21652a;
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public s<N> g() {
        return this.f21654c;
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public boolean i() {
        return this.f21653b;
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public Set<N> j(N n7) {
        return I(n7).a();
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public Set<N> l() {
        return this.f21655d.k();
    }

    public V y(N n7, N n8, V v7) {
        com.google.common.base.e0.E(n7);
        com.google.common.base.e0.E(n8);
        b0<N, V> b0VarF = this.f21655d.f(n7);
        V vE = b0VarF == null ? null : b0VarF.e(n8);
        return vE == null ? v7 : vE;
    }

    @Override // com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
    public Set<N> a(N n7) {
        return I(n7).c();
    }

    @Override // com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
    public Set<N> b(N n7) {
        return I(n7).b();
    }

    n(d<? super N> dVar, Map<N, b0<N, V>> map, long j7) {
        this.f21652a = dVar.f21604a;
        this.f21653b = dVar.f21605b;
        this.f21654c = (s<N>) dVar.f21606c.a();
        this.f21655d = map instanceof TreeMap ? new i0<>(map) : new h0<>(map);
        this.f21656e = d0.c(j7);
    }
}
