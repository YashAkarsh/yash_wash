package com.google.common.graph;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class v<N> extends c<N> {
    v() {
    }

    @Override // com.google.common.graph.a
    protected long G() {
        return H().d().size();
    }

    protected abstract i<N> H();

    @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
    public int c(N n7) {
        return H().c(n7);
    }

    @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
    public boolean e(N n7, N n8) {
        return H().e(n7, n8);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public boolean f() {
        return H().f();
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public s<N> g() {
        return H().g();
    }

    @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
    public int h(N n7) {
        return H().h(n7);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public boolean i() {
        return H().i();
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public Set<N> j(N n7) {
        return H().j(n7);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public Set<N> l() {
        return H().l();
    }

    @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
    public int m(N n7) {
        return H().m(n7);
    }

    @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
    public Set<N> a(N n7) {
        return H().a((Object) n7);
    }

    @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
    public Set<N> b(N n7) {
        return H().b((Object) n7);
    }
}
