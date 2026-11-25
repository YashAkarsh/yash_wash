package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.IterableSortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSortedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements IterableSortedMap<K, V> {

    protected static class SortedMapIterator<K, V> extends EntrySetToMapIteratorAdapter<K, V> implements OrderedMapIterator<K, V> {
        protected SortedMapIterator(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return ((ListIterator) this.iterator).hasPrevious();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            this.entry = (Map.Entry) ((ListIterator) this.iterator).previous();
            return getKey();
        }

        @Override // org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter, org.apache.commons.collections4.ResettableIterator
        public synchronized void reset() {
            super.reset();
            this.iterator = new ListIteratorWrapper(this.iterator);
        }
    }

    protected AbstractSortedMapDecorator() {
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return decorated().comparator();
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return decorated().firstKey();
    }

    public SortedMap<K, V> headMap(K k7) {
        return decorated().headMap(k7);
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return decorated().lastKey();
    }

    public K nextKey(K k7) {
        Iterator<K> it = tailMap(k7).keySet().iterator();
        it.next();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public K previousKey(K k7) {
        SortedMap<K, V> sortedMapHeadMap = headMap(k7);
        if (sortedMapHeadMap.isEmpty()) {
            return null;
        }
        return sortedMapHeadMap.lastKey();
    }

    public SortedMap<K, V> subMap(K k7, K k8) {
        return decorated().subMap(k7, k8);
    }

    public SortedMap<K, V> tailMap(K k7) {
        return decorated().tailMap(k7);
    }

    public AbstractSortedMapDecorator(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public SortedMap<K, V> decorated() {
        return (SortedMap) super.decorated();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new SortedMapIterator(entrySet());
    }
}
