package com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class k5<K, V> extends u5<K, V> implements ConcurrentMap<K, V> {
    protected k5() {
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @u1.a
    public V putIfAbsent(K k7, V v7) {
        return c0().putIfAbsent(k7, v7);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @u1.a
    public boolean remove(Object obj, Object obj2) {
        return c0().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @u1.a
    public V replace(K k7, V v7) {
        return c0().replace(k7, v7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.u5
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public abstract ConcurrentMap<K, V> c0();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @u1.a
    public boolean replace(K k7, V v7, V v8) {
        return c0().replace(k7, v7, v8);
    }
}
