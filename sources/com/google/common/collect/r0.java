package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface r0<K, V> extends Map<K, V> {
    r0<V, K> T();

    @u1.a
    V put(K k7, V v7);

    void putAll(Map<? extends K, ? extends V> map);

    /* bridge */ /* synthetic */ Collection values();

    Set<V> values();

    @u1.a
    V x(K k7, V v7);
}
