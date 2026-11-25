package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class f<K, V> extends q<K, V> implements hb<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f20222i = 6588350623831699109L;

    protected f(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.q
    <E> Collection<E> P(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.common.collect.q
    Collection<V> R(K k7, Collection<V> collection) {
        return S(k7, (List) collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public abstract List<V> z();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public List<V> E() {
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public boolean put(K k7, V v7) {
        return super.put(k7, v7);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public List<V> a(Object obj) {
        return (List) super.a(obj);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public List<V> b(K k7, Iterable<? extends V> iterable) {
        return (List) super.b((Object) k7, (Iterable) iterable);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    public List<V> get(K k7) {
        return (List) super.get((Object) k7);
    }
}
