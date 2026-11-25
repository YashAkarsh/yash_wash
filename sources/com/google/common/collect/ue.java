package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface ue<K, V> extends tc<K, V> {
    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    /* bridge */ /* synthetic */ Collection a(Object obj);

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    Set<V> a(Object obj);

    @Override // com.google.common.collect.tc
    Map<K, Collection<V>> asMap();

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    /* bridge */ /* synthetic */ Collection b(Object obj, Iterable iterable);

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    Set<V> b(K k7, Iterable<? extends V> iterable);

    /* bridge */ /* synthetic */ Collection entries();

    @Override // com.google.common.collect.tc, com.google.common.collect.ue
    Set<Map.Entry<K, V>> entries();

    boolean equals(Object obj);

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    /* bridge */ /* synthetic */ Collection get(Object obj);

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    Set<V> get(K k7);
}
