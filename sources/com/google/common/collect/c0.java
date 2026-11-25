package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class c0<K, V> extends q<K, V> implements ue<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f20001i = 7431625294878419160L;

    protected c0(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.q
    <E> Collection<E> P(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.common.collect.q
    Collection<V> R(K k7, Collection<V> collection) {
        return new q.n(k7, (Set) collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public abstract Set<V> z();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public Set<V> E() {
        return Collections.emptySet();
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
    public Set<V> a(Object obj) {
        return (Set) super.a(obj);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public Set<V> b(K k7, Iterable<? extends V> iterable) {
        return (Set) super.b((Object) k7, (Iterable) iterable);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    public Set<V> get(K k7) {
        return (Set) super.get((Object) k7);
    }
}
