package org.apache.commons.collections4;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface BidiMap<K, V> extends IterableMap<K, V> {
    K getKey(Object obj);

    BidiMap<V, K> inverseBidiMap();

    @Override // java.util.Map, org.apache.commons.collections4.Put
    V put(K k7, V v7);

    K removeValue(Object obj);

    @Override // java.util.Map, org.apache.commons.collections4.Get
    Set<V> values();
}
