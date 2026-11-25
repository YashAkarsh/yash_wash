package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class d0<K, V> extends f0<K, V> {
    d0(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.c0, com.google.common.collect.x, com.google.common.collect.tc
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public SortedMap<K, Collection<V>> y() {
        return (SortedMap) super.y();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x
    Set<K> f() {
        return C();
    }
}
