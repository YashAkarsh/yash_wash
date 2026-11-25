package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes3.dex */
public class TransformedSortedMap<K, V> extends TransformedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = -8751771676410385778L;

    protected TransformedSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        super(sortedMap, transformer, transformer2);
    }

    public static <K, V> TransformedSortedMap<K, V> transformedSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        TransformedSortedMap<K, V> transformedSortedMap = new TransformedSortedMap<>(sortedMap, transformer, transformer2);
        if (sortedMap.size() > 0) {
            Map<K, V> mapTransformMap = transformedSortedMap.transformMap(sortedMap);
            transformedSortedMap.clear();
            transformedSortedMap.decorated().putAll(mapTransformMap);
        }
        return transformedSortedMap;
    }

    public static <K, V> TransformedSortedMap<K, V> transformingSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return new TransformedSortedMap<>(sortedMap, transformer, transformer2);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return getSortedMap().comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return getSortedMap().firstKey();
    }

    protected SortedMap<K, V> getSortedMap() {
        return (SortedMap) this.map;
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k7) {
        return new TransformedSortedMap(getSortedMap().headMap(k7), this.keyTransformer, this.valueTransformer);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return getSortedMap().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k7, K k8) {
        return new TransformedSortedMap(getSortedMap().subMap(k7, k8), this.keyTransformer, this.valueTransformer);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k7) {
        return new TransformedSortedMap(getSortedMap().tailMap(k7), this.keyTransformer, this.valueTransformer);
    }
}
