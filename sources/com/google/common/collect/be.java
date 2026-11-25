package com.google.common.collect;

import java.lang.Comparable;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public interface be<C extends Comparable> {
    boolean a(C c8);

    void b(xd<C> xdVar);

    xd<C> c();

    void clear();

    void d(Iterable<xd<C>> iterable);

    void e(be<C> beVar);

    boolean equals(Object obj);

    void f(Iterable<xd<C>> iterable);

    boolean g(be<C> beVar);

    void h(xd<C> xdVar);

    int hashCode();

    be<C> i();

    boolean isEmpty();

    xd<C> j(C c8);

    boolean k(xd<C> xdVar);

    boolean l(Iterable<xd<C>> iterable);

    be<C> m(xd<C> xdVar);

    Set<xd<C>> n();

    Set<xd<C>> o();

    void p(be<C> beVar);

    boolean q(xd<C> xdVar);

    String toString();
}
