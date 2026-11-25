package com.google.common.graph;

import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class x<N, V> extends g<N, V> {
    x() {
    }

    @Override // com.google.common.graph.g, com.google.common.graph.y0
    public Optional<V> E(N n7, N n8) {
        return I().E(n7, n8);
    }

    @Override // com.google.common.graph.a
    protected long G() {
        return I().d().size();
    }

    protected abstract y0<N, V> I();

    @Override // com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i
    public int c(N n7) {
        return I().c(n7);
    }

    @Override // com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i
    public boolean e(N n7, N n8) {
        return I().e(n7, n8);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public boolean f() {
        return I().f();
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public s<N> g() {
        return I().g();
    }

    @Override // com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i
    public int h(N n7) {
        return I().h(n7);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public boolean i() {
        return I().i();
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public Set<N> j(N n7) {
        return I().j(n7);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.z
    public Set<N> l() {
        return I().l();
    }

    @Override // com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i
    public int m(N n7) {
        return I().m(n7);
    }

    public V y(N n7, N n8, V v7) {
        return I().y(n7, n8, v7);
    }

    @Override // com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
    public Set<N> a(N n7) {
        return I().a((Object) n7);
    }

    @Override // com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
    public Set<N> b(N n7) {
        return I().b((Object) n7);
    }
}
