package com.google.common.graph;

import com.google.common.collect.n6;
import com.google.common.collect.u6;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class q<N, E> extends b<N, E> {
    protected q(Map<E, N> map, Map<E, N> map2, int i7) {
        super(map, map2, i7);
    }

    static <N, E> q<N, E> n() {
        return new q<>(n6.o(2), n6.o(2), 0);
    }

    static <N, E> q<N, E> o(Map<E, N> map, Map<E, N> map2, int i7) {
        return new q<>(u6.N(map), u6.N(map2), i7);
    }

    @Override // com.google.common.graph.q0
    public Set<N> b() {
        return Collections.unmodifiableSet(((com.google.common.collect.r0) this.f21586b).values());
    }

    @Override // com.google.common.graph.q0
    public Set<N> c() {
        return Collections.unmodifiableSet(((com.google.common.collect.r0) this.f21585a).values());
    }

    @Override // com.google.common.graph.q0
    public Set<E> k(N n7) {
        return new r(((com.google.common.collect.r0) this.f21586b).T(), n7);
    }
}
