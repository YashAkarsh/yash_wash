package com.google.common.graph;

import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public interface y0<N, V> extends i<N> {
    Optional<V> E(N n7, N n8);

    @Override // com.google.common.graph.i, com.google.common.graph.r0
    /* bridge */ /* synthetic */ Iterable a(Object obj);

    @Override // com.google.common.graph.i, com.google.common.graph.r0
    Set<N> a(N n7);

    @Override // com.google.common.graph.i, com.google.common.graph.s0
    /* bridge */ /* synthetic */ Iterable b(Object obj);

    @Override // com.google.common.graph.i, com.google.common.graph.s0
    Set<N> b(N n7);

    @Override // com.google.common.graph.i
    int c(N n7);

    @Override // com.google.common.graph.i
    Set<t<N>> d();

    @Override // com.google.common.graph.i
    boolean e(N n7, N n8);

    boolean equals(Object obj);

    @Override // com.google.common.graph.i, com.google.common.graph.z
    boolean f();

    @Override // com.google.common.graph.i, com.google.common.graph.z
    s<N> g();

    @Override // com.google.common.graph.i
    int h(N n7);

    int hashCode();

    @Override // com.google.common.graph.i, com.google.common.graph.z
    boolean i();

    @Override // com.google.common.graph.i, com.google.common.graph.z
    Set<N> j(N n7);

    @Override // com.google.common.graph.i
    Set<t<N>> k(N n7);

    @Override // com.google.common.graph.i, com.google.common.graph.z
    Set<N> l();

    @Override // com.google.common.graph.i
    int m(N n7);

    z<N> q();

    V y(N n7, N n8, V v7);
}
