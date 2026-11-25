package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface bg<K, V> extends ue<K, V> {
    @Override // com.google.common.collect.ue, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    /* bridge */ /* synthetic */ Collection a(Object obj);

    @Override // com.google.common.collect.ue, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    /* bridge */ /* synthetic */ Set a(Object obj);

    @Override // com.google.common.collect.ue, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    SortedSet<V> a(Object obj);

    @Override // com.google.common.collect.ue, com.google.common.collect.tc
    Map<K, Collection<V>> asMap();

    @Override // com.google.common.collect.ue, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    /* bridge */ /* synthetic */ Collection b(Object obj, Iterable iterable);

    @Override // com.google.common.collect.ue, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    /* bridge */ /* synthetic */ Set b(Object obj, Iterable iterable);

    @Override // com.google.common.collect.ue, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    SortedSet<V> b(K k7, Iterable<? extends V> iterable);

    @Override // com.google.common.collect.ue, com.google.common.collect.tc, com.google.common.collect.hb
    /* bridge */ /* synthetic */ Collection get(Object obj);

    @Override // com.google.common.collect.ue, com.google.common.collect.tc, com.google.common.collect.hb
    /* bridge */ /* synthetic */ Set get(Object obj);

    @Override // com.google.common.collect.ue, com.google.common.collect.tc, com.google.common.collect.hb
    SortedSet<V> get(K k7);

    Comparator<? super V> valueComparator();
}
