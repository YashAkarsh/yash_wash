package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface tc<K, V> {
    @u1.a
    boolean H(tc<? extends K, ? extends V> tcVar);

    boolean W(@u1.c("K") Object obj, @u1.c("V") Object obj2);

    @u1.a
    Collection<V> a(@u1.c("K") Object obj);

    Map<K, Collection<V>> asMap();

    @u1.a
    Collection<V> b(K k7, Iterable<? extends V> iterable);

    void clear();

    boolean containsKey(@u1.c("K") Object obj);

    boolean containsValue(@u1.c("V") Object obj);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(Object obj);

    void forEach(BiConsumer<? super K, ? super V> biConsumer);

    Collection<V> get(K k7);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    hd<K> keys();

    @u1.a
    boolean put(K k7, V v7);

    @u1.a
    boolean putAll(K k7, Iterable<? extends V> iterable);

    @u1.a
    boolean remove(@u1.c("K") Object obj, @u1.c("V") Object obj2);

    int size();

    Collection<V> values();
}
