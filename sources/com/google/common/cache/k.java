package com.google.common.cache;

import com.google.common.collect.v7;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface k<K, V> extends c<K, V>, com.google.common.base.s<K, V> {
    v7<K, V> K(Iterable<? extends K> iterable) throws ExecutionException;

    void N(K k7);

    @Override // com.google.common.base.s, java.util.function.Function
    @Deprecated
    V apply(K k7);

    @Override // com.google.common.cache.c
    ConcurrentMap<K, V> asMap();

    V get(K k7) throws ExecutionException;

    V o(K k7);
}
