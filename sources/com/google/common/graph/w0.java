package com.google.common.graph;

import com.google.common.collect.n6;
import com.google.common.collect.u6;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class w0<N, E> extends f<N, E> {
    protected w0(Map<E, N> map) {
        super(map);
    }

    static <N, E> w0<N, E> m() {
        return new w0<>(n6.o(2));
    }

    static <N, E> w0<N, E> n(Map<E, N> map) {
        return new w0<>(u6.N(map));
    }

    @Override // com.google.common.graph.q0
    public Set<N> a() {
        return Collections.unmodifiableSet(((com.google.common.collect.r0) this.f21622a).values());
    }

    @Override // com.google.common.graph.q0
    public Set<E> k(N n7) {
        return new r(((com.google.common.collect.r0) this.f21622a).T(), n7);
    }
}
