package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class w5<K, V> extends b6 implements tc<K, V> {
    protected w5() {
    }

    @u1.a
    public boolean H(tc<? extends K, ? extends V> tcVar) {
        return d0().H(tcVar);
    }

    @Override // com.google.common.collect.tc
    public boolean W(Object obj, Object obj2) {
        return d0().W(obj, obj2);
    }

    @u1.a
    public Collection<V> a(Object obj) {
        return d0().a(obj);
    }

    public Map<K, Collection<V>> asMap() {
        return d0().asMap();
    }

    @u1.a
    public Collection<V> b(K k7, Iterable<? extends V> iterable) {
        return d0().b(k7, iterable);
    }

    public void clear() {
        d0().clear();
    }

    @Override // com.google.common.collect.tc
    public boolean containsKey(Object obj) {
        return d0().containsKey(obj);
    }

    @Override // com.google.common.collect.tc
    public boolean containsValue(Object obj) {
        return d0().containsValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.b6
    public abstract tc<K, V> d0();

    public Collection<Map.Entry<K, V>> entries() {
        return d0().entries();
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.ue
    public boolean equals(Object obj) {
        return obj == this || d0().equals(obj);
    }

    @Override // com.google.common.collect.tc
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        sc.a(this, biConsumer);
    }

    public Collection<V> get(K k7) {
        return d0().get(k7);
    }

    @Override // com.google.common.collect.tc
    public int hashCode() {
        return d0().hashCode();
    }

    @Override // com.google.common.collect.tc
    public boolean isEmpty() {
        return d0().isEmpty();
    }

    public Set<K> keySet() {
        return d0().keySet();
    }

    public hd<K> keys() {
        return d0().keys();
    }

    @u1.a
    public boolean put(K k7, V v7) {
        return d0().put(k7, v7);
    }

    @u1.a
    public boolean putAll(K k7, Iterable<? extends V> iterable) {
        return d0().putAll(k7, iterable);
    }

    @u1.a
    public boolean remove(Object obj, Object obj2) {
        return d0().remove(obj, obj2);
    }

    @Override // com.google.common.collect.tc
    public int size() {
        return d0().size();
    }

    public Collection<V> values() {
        return d0().values();
    }
}
