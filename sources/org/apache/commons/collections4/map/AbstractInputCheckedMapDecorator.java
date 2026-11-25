package org.apache.commons.collections4.map;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections4.set.AbstractSetDecorator;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractInputCheckedMapDecorator<K, V> extends AbstractMapDecorator<K, V> {

    private class EntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        private final AbstractInputCheckedMapDecorator<K, V> parent;

        protected EntrySetIterator(Iterator<Map.Entry<K, V>> it, AbstractInputCheckedMapDecorator<K, V> abstractInputCheckedMapDecorator) {
            super(it);
            this.parent = abstractInputCheckedMapDecorator;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return new MapEntry(getIterator().next(), this.parent);
        }
    }

    private class MapEntry extends AbstractMapEntryDecorator<K, V> {
        private final AbstractInputCheckedMapDecorator<K, V> parent;

        protected MapEntry(Map.Entry<K, V> entry, AbstractInputCheckedMapDecorator<K, V> abstractInputCheckedMapDecorator) {
            super(entry);
            this.parent = abstractInputCheckedMapDecorator;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public V setValue(V v7) {
            return getMapEntry().setValue(this.parent.checkSetValue(v7));
        }
    }

    protected AbstractInputCheckedMapDecorator() {
    }

    protected abstract V checkSetValue(V v7);

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return isSetValueChecking() ? new EntrySet(this.map.entrySet(), this) : this.map.entrySet();
    }

    protected boolean isSetValueChecking() {
        return true;
    }

    protected AbstractInputCheckedMapDecorator(Map<K, V> map) {
        super(map);
    }

    private class EntrySet extends AbstractSetDecorator<Map.Entry<K, V>> {
        private static final long serialVersionUID = 4354731610923110264L;
        private final AbstractInputCheckedMapDecorator<K, V> parent;

        protected EntrySet(Set<Map.Entry<K, V>> set, AbstractInputCheckedMapDecorator<K, V> abstractInputCheckedMapDecorator) {
            super(set);
            this.parent = abstractInputCheckedMapDecorator;
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntrySetIterator(decorated().iterator(), this.parent);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public Object[] toArray() {
            Object[] array = decorated().toArray();
            for (int i7 = 0; i7 < array.length; i7++) {
                array[i7] = new MapEntry((Map.Entry) array[i7], this.parent);
            }
            return array;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2 = (T[]) decorated().toArray(tArr.length > 0 ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 0) : tArr);
            for (int i7 = 0; i7 < tArr2.length; i7++) {
                tArr2[i7] = new MapEntry((Map.Entry) tArr2[i7], this.parent);
            }
            if (tArr2.length > tArr.length) {
                return tArr2;
            }
            System.arraycopy(tArr2, 0, tArr, 0, tArr2.length);
            if (tArr.length > tArr2.length) {
                tArr[tArr2.length] = null;
            }
            return tArr;
        }
    }
}
