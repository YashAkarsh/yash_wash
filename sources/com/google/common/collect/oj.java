package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface oj<R, C, V> {

    public interface a<R, C, V> {
        C a();

        R b();

        boolean equals(Object obj);

        V getValue();

        int hashCode();
    }

    Set<C> L();

    boolean M(@u1.c("R") Object obj);

    void O(oj<? extends R, ? extends C, ? extends V> ojVar);

    boolean P(@u1.c("R") Object obj, @u1.c("C") Object obj2);

    Map<C, Map<R, V>> S();

    Map<C, V> X(R r7);

    void clear();

    boolean containsValue(@u1.c("V") Object obj);

    boolean equals(Object obj);

    Map<R, Map<C, V>> f();

    Set<R> g();

    int hashCode();

    boolean isEmpty();

    V k(@u1.c("R") Object obj, @u1.c("C") Object obj2);

    boolean m(@u1.c("C") Object obj);

    Map<R, V> n(C c8);

    Set<a<R, C, V>> r();

    @u1.a
    V remove(@u1.c("R") Object obj, @u1.c("C") Object obj2);

    int size();

    @u1.a
    V t(R r7, C c8, V v7);

    Collection<V> values();
}
