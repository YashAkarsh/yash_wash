package org.apache.commons.collections4;

/* JADX INFO: loaded from: classes3.dex */
public interface OrderedMap<K, V> extends IterableMap<K, V> {
    K firstKey();

    K lastKey();

    @Override // org.apache.commons.collections4.IterableGet
    OrderedMapIterator<K, V> mapIterator();

    K nextKey(K k7);

    K previousKey(K k7);
}
