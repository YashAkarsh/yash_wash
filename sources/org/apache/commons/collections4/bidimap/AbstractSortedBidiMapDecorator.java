package org.apache.commons.collections4.bidimap;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.SortedBidiMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSortedBidiMapDecorator<K, V> extends AbstractOrderedBidiMapDecorator<K, V> implements SortedBidiMap<K, V> {
    public AbstractSortedBidiMapDecorator(SortedBidiMap<K, V> sortedBidiMap) {
        super(sortedBidiMap);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return decorated().comparator();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k7) {
        return decorated().headMap(k7);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k7, K k8) {
        return decorated().subMap(k7, k8);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k7) {
        return decorated().tailMap(k7);
    }

    @Override // org.apache.commons.collections4.SortedBidiMap
    public Comparator<? super V> valueComparator() {
        return decorated().valueComparator();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.BidiMap
    public SortedBidiMap<V, K> inverseBidiMap() {
        return decorated().inverseBidiMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator
    public SortedBidiMap<K, V> decorated() {
        return (SortedBidiMap) super.decorated();
    }
}
