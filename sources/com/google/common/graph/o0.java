package com.google.common.graph;

import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public interface o0<N, E> extends s0<N>, r0<N> {
    s<E> A();

    Set<E> C(N n7);

    /* bridge */ /* synthetic */ Iterable a(Object obj);

    @Override // com.google.common.graph.r0
    Set<N> a(N n7);

    @Override // com.google.common.graph.s0
    /* bridge */ /* synthetic */ Iterable b(Object obj);

    @Override // com.google.common.graph.s0
    Set<N> b(N n7);

    int c(N n7);

    Set<E> d();

    boolean e(N n7, N n8);

    boolean equals(Object obj);

    boolean f();

    s<N> g();

    int h(N n7);

    int hashCode();

    boolean i();

    Set<N> j(N n7);

    Set<E> k(N n7);

    Set<N> l();

    int m(N n7);

    z<N> q();

    E r(N n7, N n8);

    Set<E> s(N n7);

    Set<E> t(E e8);

    Set<E> u(N n7, N n8);

    boolean v();

    t<N> w(E e8);

    Optional<E> x(N n7, N n8);
}
