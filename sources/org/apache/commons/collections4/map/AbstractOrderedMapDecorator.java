package org.apache.commons.collections4.map;

import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractOrderedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements OrderedMap<K, V> {
    protected AbstractOrderedMapDecorator() {
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return decorated().firstKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return decorated().lastKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k7) {
        return decorated().nextKey(k7);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k7) {
        return decorated().previousKey(k7);
    }

    public AbstractOrderedMapDecorator(OrderedMap<K, V> orderedMap) {
        super(orderedMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public OrderedMap<K, V> decorated() {
        return (OrderedMap) super.decorated();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }
}
