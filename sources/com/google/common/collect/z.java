package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
abstract class z<K, V> extends wb.b0<K, V> implements NavigableMap<K, V> {

    private final class b extends wb.r<K, V> {
        private b() {
        }

        @Override // com.google.common.collect.wb.r
        Iterator<Map.Entry<K, V>> u0() {
            return z.this.d();
        }

        @Override // com.google.common.collect.wb.r
        NavigableMap<K, V> w0() {
            return z.this;
        }
    }

    z() {
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k7) {
        return tailMap(k7, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k7) {
        return (K) wb.Y(ceilingEntry(k7));
    }

    abstract Iterator<Map.Entry<K, V>> d();

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return new b();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) ua.J(a(), null);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Map.Entry<K, V> entryFirstEntry = firstEntry();
        if (entryFirstEntry != null) {
            return entryFirstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k7) {
        return headMap(k7, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k7) {
        return (K) wb.Y(floorEntry(k7));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K k7) {
        return headMap(k7, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k7) {
        return tailMap(k7, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k7) {
        return (K) wb.Y(higherEntry(k7));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) ua.J(d(), null);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Map.Entry<K, V> entryLastEntry = lastEntry();
        if (entryLastEntry != null) {
            return entryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k7) {
        return headMap(k7, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k7) {
        return (K) wb.Y(lowerEntry(k7));
    }

    public NavigableSet<K> navigableKeySet() {
        return new wb.f0(this);
    }

    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) ua.U(a());
    }

    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) ua.U(d());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(K k7, K k8) {
        return subMap(k7, true, k8, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(K k7) {
        return tailMap(k7, true);
    }
}
