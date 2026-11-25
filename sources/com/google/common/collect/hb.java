package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface hb<K, V> extends tc<K, V> {
    @u1.a
    /* bridge */ /* synthetic */ Collection a(Object obj);

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    List<V> a(Object obj);

    @Override // com.google.common.collect.tc
    Map<K, Collection<V>> asMap();

    @u1.a
    /* bridge */ /* synthetic */ Collection b(Object obj, Iterable iterable);

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    List<V> b(K k7, Iterable<? extends V> iterable);

    @Override // com.google.common.collect.tc, com.google.common.collect.ue
    boolean equals(Object obj);

    /* bridge */ /* synthetic */ Collection get(Object obj);

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    List<V> get(K k7);
}
