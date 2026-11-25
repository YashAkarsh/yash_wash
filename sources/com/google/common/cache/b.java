package com.google.common.cache;

import com.google.common.collect.v7;
import com.google.common.collect.wb;
import com.google.common.util.concurrent.n2;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class b<K, V> extends a<K, V> implements k<K, V> {
    protected b() {
    }

    @Override // com.google.common.cache.k
    public v7<K, V> K(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap linkedHashMapM0 = wb.m0();
        for (K k7 : iterable) {
            if (!linkedHashMapM0.containsKey(k7)) {
                linkedHashMapM0.put(k7, get(k7));
            }
        }
        return v7.g(linkedHashMapM0);
    }

    @Override // com.google.common.cache.k
    public void N(K k7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.k, com.google.common.base.s, java.util.function.Function
    public final V apply(K k7) {
        return o(k7);
    }

    @Override // com.google.common.cache.k
    public V o(K k7) {
        try {
            return get(k7);
        } catch (ExecutionException e8) {
            throw new n2(e8.getCause());
        }
    }
}
