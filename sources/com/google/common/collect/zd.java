package com.google.common.collect;

import java.lang.Comparable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public interface zd<K extends Comparable, V> {
    void b(xd<K> xdVar);

    xd<K> c();

    void clear();

    Map.Entry<xd<K>, V> d(K k7);

    zd<K, V> e(xd<K> xdVar);

    boolean equals(Object obj);

    Map<xd<K>, V> f();

    Map<xd<K>, V> g();

    V h(K k7);

    int hashCode();

    void i(zd<K, V> zdVar);

    void j(xd<K> xdVar, V v7);

    void k(xd<K> xdVar, V v7);

    String toString();
}
