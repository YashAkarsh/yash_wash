package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class f0<K, V> extends c0<K, V> implements bg<K, V> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f20223j = 430848587173315748L;

    protected f0(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.q
    Collection<V> R(K k7, Collection<V> collection) {
        return collection instanceof NavigableSet ? new q.m(k7, (NavigableSet) collection, null) : new q.o(k7, (SortedSet) collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0, com.google.common.collect.q
    /* JADX INFO: renamed from: V */
    public abstract SortedSet<V> z();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public SortedSet<V> E() {
        return (SortedSet<V>) P(z());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0, com.google.common.collect.q
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public <E> SortedSet<E> P(Collection<E> collection) {
        return collection instanceof NavigableSet ? af.P((NavigableSet) collection) : Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.x, com.google.common.collect.tc
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public SortedSet<V> a(Object obj) {
        return (SortedSet) super.a(obj);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public SortedSet<V> b(K k7, Iterable<? extends V> iterable) {
        return (SortedSet) super.b((Object) k7, (Iterable) iterable);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    public SortedSet<V> get(K k7) {
        return (SortedSet) super.get((Object) k7);
    }
}
