package com.nostra13.universalimageloader.cache.memory;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface c<K, V> {
    void clear();

    V get(K k7);

    Collection<K> keys();

    boolean put(K k7, V v7);

    void remove(K k7);
}
