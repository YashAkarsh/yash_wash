package org.apache.commons.collections4.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.SortedBidiMap;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;

/* JADX INFO: loaded from: classes3.dex */
public class DualTreeBidiMap<K, V> extends AbstractDualBidiMap<K, V> implements SortedBidiMap<K, V>, Serializable {
    private static final long serialVersionUID = 721969328361809L;
    private final Comparator<? super K> comparator;
    private final Comparator<? super V> valueComparator;

    protected static class BidiOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private ListIterator<Map.Entry<K, V>> iterator;
        private Map.Entry<K, V> last = null;
        private final AbstractDualBidiMap<K, V> parent;

        protected BidiOrderedMapIterator(AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = new ArrayList(abstractDualBidiMap.entrySet()).listIterator();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            Map.Entry<K, V> entry = this.last;
            if (entry != null) {
                return entry.getKey();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            Map.Entry<K, V> entry = this.last;
            if (entry != null) {
                return entry.getValue();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            Map.Entry<K, V> next = this.iterator.next();
            this.last = next;
            return next.getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            Map.Entry<K, V> entryPrevious = this.iterator.previous();
            this.last = entryPrevious;
            return entryPrevious.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            this.iterator.remove();
            this.parent.remove(this.last.getKey());
            this.last = null;
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.iterator = new ArrayList(this.parent.entrySet()).listIterator();
            this.last = null;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v7) {
            if (this.last == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            }
            if (this.parent.reverseMap.containsKey(v7) && this.parent.reverseMap.get(v7) != this.last.getKey()) {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
            V v8 = (V) this.parent.put(this.last.getKey(), v7);
            this.last.setValue(v7);
            return v8;
        }

        public String toString() {
            if (this.last == null) {
                return "MapIterator[]";
            }
            return "MapIterator[" + getKey() + "=" + getValue() + "]";
        }
    }

    public DualTreeBidiMap() {
        super(new TreeMap(), new TreeMap());
        this.comparator = null;
        this.valueComparator = null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.normalMap = new TreeMap(this.comparator);
        this.reverseMap = new TreeMap(this.valueComparator);
        putAll((Map) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.normalMap);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return ((SortedMap) this.normalMap).comparator();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return (K) ((SortedMap) this.normalMap).firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K k7) {
        return new ViewMap(this, ((SortedMap) this.normalMap).headMap(k7));
    }

    public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
        return inverseBidiMap();
    }

    public SortedBidiMap<V, K> inverseSortedBidiMap() {
        return inverseBidiMap();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return (K) ((SortedMap) this.normalMap).lastKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k7) {
        if (isEmpty()) {
            return null;
        }
        Map<K, V> map = this.normalMap;
        if (map instanceof OrderedMap) {
            return (K) ((OrderedMap) map).nextKey(k7);
        }
        Iterator<K> it = ((SortedMap) map).tailMap(k7).keySet().iterator();
        it.next();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k7) {
        if (isEmpty()) {
            return null;
        }
        Map<K, V> map = this.normalMap;
        if (map instanceof OrderedMap) {
            return (K) ((OrderedMap) map).previousKey(k7);
        }
        SortedMap<K, V> sortedMapHeadMap = ((SortedMap) map).headMap(k7);
        if (sortedMapHeadMap.isEmpty()) {
            return null;
        }
        return sortedMapHeadMap.lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K k7, K k8) {
        return new ViewMap(this, ((SortedMap) this.normalMap).subMap(k7, k8));
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K k7) {
        return new ViewMap(this, ((SortedMap) this.normalMap).tailMap(k7));
    }

    @Override // org.apache.commons.collections4.SortedBidiMap
    public Comparator<? super V> valueComparator() {
        return ((SortedMap) this.reverseMap).comparator();
    }

    protected static class ViewMap<K, V> extends AbstractSortedMapDecorator<K, V> {
        protected ViewMap(DualTreeBidiMap<K, V> dualTreeBidiMap, SortedMap<K, V> sortedMap) {
            super(new DualTreeBidiMap(sortedMap, dualTreeBidiMap.reverseMap, dualTreeBidiMap.inverseBidiMap));
        }

        @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
        public void clear() {
            Iterator<K> it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
        public boolean containsValue(Object obj) {
            return decorated().normalMap.containsValue(obj);
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap<K, V> headMap(K k7) {
            return new ViewMap(decorated(), super.headMap(k7));
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.OrderedMap
        public K nextKey(K k7) {
            return decorated().nextKey(k7);
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.OrderedMap
        public K previousKey(K k7) {
            return decorated().previousKey(k7);
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap<K, V> subMap(K k7, K k8) {
            return new ViewMap(decorated(), super.subMap(k7, k8));
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k7) {
            return new ViewMap(decorated(), super.tailMap(k7));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator
        public DualTreeBidiMap<K, V> decorated() {
            return (DualTreeBidiMap) super.decorated();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap
    public DualTreeBidiMap<V, K> createBidiMap(Map<V, K> map, Map<K, V> map2, BidiMap<K, V> bidiMap) {
        return new DualTreeBidiMap<>(map, map2, bidiMap);
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new BidiOrderedMapIterator(this);
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap, org.apache.commons.collections4.BidiMap
    public SortedBidiMap<V, K> inverseBidiMap() {
        return (SortedBidiMap) super.inverseBidiMap();
    }

    public DualTreeBidiMap(Map<? extends K, ? extends V> map) {
        super(new TreeMap(), new TreeMap());
        putAll(map);
        this.comparator = null;
        this.valueComparator = null;
    }

    public DualTreeBidiMap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator), new TreeMap(comparator2));
        this.comparator = comparator;
        this.valueComparator = comparator2;
    }

    protected DualTreeBidiMap(Map<K, V> map, Map<V, K> map2, BidiMap<V, K> bidiMap) {
        super(map, map2, bidiMap);
        this.comparator = ((SortedMap) map).comparator();
        this.valueComparator = ((SortedMap) map2).comparator();
    }
}
