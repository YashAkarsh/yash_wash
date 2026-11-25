package com.google.common.cache;

import com.google.common.collect.v7;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface c<K, V> {
    void B(Iterable<?> iterable);

    v7<K, V> Y(Iterable<?> iterable);

    void Z(@u1.c("K") Object obj);

    h a0();

    ConcurrentMap<K, V> asMap();

    void b0();

    void l();

    void put(K k7, V v7);

    void putAll(Map<? extends K, ? extends V> map);

    long size();

    V u(@u1.c("K") Object obj);

    V z(K k7, Callable<? extends V> callable) throws ExecutionException;
}
