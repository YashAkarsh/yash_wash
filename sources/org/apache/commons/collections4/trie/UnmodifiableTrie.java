package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;

/* JADX INFO: loaded from: classes3.dex */
public class UnmodifiableTrie<K, V> implements Trie<K, V>, Serializable, Unmodifiable {
    private static final long serialVersionUID = -7156426030315945159L;
    private final Trie<K, V> delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public UnmodifiableTrie(Trie<K, ? extends V> trie) {
        if (trie == 0) {
            throw new NullPointerException("Trie must not be null");
        }
        this.delegate = trie;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Trie<K, V> unmodifiableTrie(Trie<K, ? extends V> trie) {
        return trie instanceof Unmodifiable ? trie : new UnmodifiableTrie(trie);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return this.delegate.comparator();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        return this.delegate.containsValue(obj);
    }

    @Override // java.util.SortedMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(this.delegate.entrySet());
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return this.delegate.firstKey();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        return this.delegate.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k7) {
        return Collections.unmodifiableSortedMap(this.delegate.headMap(k7));
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.SortedMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return Collections.unmodifiableSet(this.delegate.keySet());
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return this.delegate.lastKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k7) {
        return this.delegate.nextKey(k7);
    }

    @Override // org.apache.commons.collections4.Trie
    public SortedMap<K, V> prefixMap(K k7) {
        return Collections.unmodifiableSortedMap(this.delegate.prefixMap(k7));
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k7) {
        return this.delegate.previousKey(k7);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k7, V v7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k7, K k8) {
        return Collections.unmodifiableSortedMap(this.delegate.subMap(k7, k8));
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k7) {
        return Collections.unmodifiableSortedMap(this.delegate.tailMap(k7));
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.util.SortedMap, java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return Collections.unmodifiableCollection(this.delegate.values());
    }

    @Override // org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(this.delegate.mapIterator());
    }
}
