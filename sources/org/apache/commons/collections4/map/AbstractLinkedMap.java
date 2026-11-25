package org.apache.commons.collections4.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractLinkedMap<K, V> extends AbstractHashedMap<K, V> implements OrderedMap<K, V> {
    transient LinkEntry<K, V> header;

    protected static class EntrySetIterator<K, V> extends LinkIterator<K, V> implements OrderedIterator<Map.Entry<K, V>>, ResettableIterator<Map.Entry<K, V>> {
        protected EntrySetIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public Map.Entry<K, V> previous() {
            return super.previousEntry();
        }
    }

    protected static class KeySetIterator<K> extends LinkIterator<K, Object> implements OrderedIterator<K>, ResettableIterator<K> {
        protected KeySetIterator(AbstractLinkedMap<K, ?> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }
    }

    protected static class LinkEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        protected LinkEntry<K, V> after;
        protected LinkEntry<K, V> before;

        protected LinkEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i7, Object obj, V v7) {
            super(hashEntry, i7, obj, v7);
        }
    }

    protected static abstract class LinkIterator<K, V> {
        protected int expectedModCount;
        protected LinkEntry<K, V> last;
        protected LinkEntry<K, V> next;
        protected final AbstractLinkedMap<K, V> parent;

        protected LinkIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            this.parent = abstractLinkedMap;
            this.next = abstractLinkedMap.header.after;
            this.expectedModCount = abstractLinkedMap.modCount;
        }

        protected LinkEntry<K, V> currentEntry() {
            return this.last;
        }

        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        public boolean hasPrevious() {
            return this.next.before != this.parent.header;
        }

        protected LinkEntry<K, V> nextEntry() {
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry<K, V> linkEntry = this.next;
            if (linkEntry == abstractLinkedMap.header) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.last = linkEntry;
            this.next = linkEntry.after;
            return linkEntry;
        }

        protected LinkEntry<K, V> previousEntry() {
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry<K, V> linkEntry = this.next.before;
            if (linkEntry == abstractLinkedMap.header) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.next = linkEntry;
            this.last = linkEntry;
            return linkEntry;
        }

        public void remove() {
            LinkEntry<K, V> linkEntry = this.last;
            if (linkEntry == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            abstractLinkedMap.remove(linkEntry.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
        }

        public void reset() {
            this.last = null;
            this.next = this.parent.header.after;
        }

        public String toString() {
            if (this.last == null) {
                return "Iterator[]";
            }
            return "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]";
        }
    }

    protected static class LinkMapIterator<K, V> extends LinkIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        protected LinkMapIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v7) {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.setValue(v7);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    protected static class ValuesIterator<V> extends LinkIterator<Object, V> implements OrderedIterator<V>, ResettableIterator<V> {
        protected ValuesIterator(AbstractLinkedMap<?, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().getValue();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public V previous() {
            return super.previousEntry().getValue();
        }
    }

    protected AbstractLinkedMap() {
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected void addEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i7) {
        LinkEntry<K, V> linkEntry = (LinkEntry) hashEntry;
        LinkEntry<K, V> linkEntry2 = this.header;
        linkEntry.after = linkEntry2;
        linkEntry.before = linkEntry2.before;
        linkEntry2.before.after = linkEntry;
        linkEntry2.before = linkEntry;
        this.data[i7] = linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        super.clear();
        LinkEntry<K, V> linkEntry = this.header;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        if (obj == null) {
            LinkEntry<K, V> linkEntry = this.header;
            do {
                linkEntry = linkEntry.after;
                if (linkEntry == this.header) {
                    return false;
                }
            } while (linkEntry.getValue() != null);
            return true;
        }
        LinkEntry<K, V> linkEntry2 = this.header;
        do {
            linkEntry2 = linkEntry2.after;
            if (linkEntry2 == this.header) {
                return false;
            }
        } while (!isEqualValue(obj, linkEntry2.getValue()));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i7, Object obj, Object obj2) {
        return createEntry((AbstractHashedMap.HashEntry<Object, Object>) hashEntry, i7, obj, obj2);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        return size() == 0 ? EmptyOrderedIterator.emptyOrderedIterator() : new EntrySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Iterator<K> createKeySetIterator() {
        return size() == 0 ? EmptyOrderedIterator.emptyOrderedIterator() : new KeySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Iterator<V> createValuesIterator() {
        return size() == 0 ? EmptyOrderedIterator.emptyOrderedIterator() : new ValuesIterator(this);
    }

    protected LinkEntry<K, V> entryAfter(LinkEntry<K, V> linkEntry) {
        return linkEntry.after;
    }

    protected LinkEntry<K, V> entryBefore(LinkEntry<K, V> linkEntry) {
        return linkEntry.before;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (this.size != 0) {
            return this.header.after.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected void init() {
        LinkEntry<K, V> linkEntryCreateEntry = createEntry((AbstractHashedMap.HashEntry) null, -1, (Object) null, (Object) null);
        this.header = linkEntryCreateEntry;
        linkEntryCreateEntry.after = linkEntryCreateEntry;
        linkEntryCreateEntry.before = linkEntryCreateEntry;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (this.size != 0) {
            return this.header.before.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object obj) {
        LinkEntry<K, V> linkEntry;
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || (linkEntry = entry.after) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object obj) {
        LinkEntry<K, V> linkEntry;
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || (linkEntry = entry.before) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected void removeEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i7, AbstractHashedMap.HashEntry<K, V> hashEntry2) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        LinkEntry<K, V> linkEntry2 = linkEntry.before;
        linkEntry2.after = linkEntry.after;
        linkEntry.after.before = linkEntry2;
        linkEntry.after = null;
        linkEntry.before = null;
        super.removeEntry(hashEntry, i7, hashEntry2);
    }

    protected AbstractLinkedMap(int i7, float f8, int i8) {
        super(i7, f8, i8);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected LinkEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i7, K k7, V v7) {
        return new LinkEntry<>(hashEntry, i7, convertKey(k7), v7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> getEntry(Object obj) {
        return (LinkEntry) super.getEntry(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return this.size == 0 ? EmptyOrderedMapIterator.emptyOrderedMapIterator() : new LinkMapIterator(this);
    }

    protected AbstractLinkedMap(int i7) {
        super(i7);
    }

    protected LinkEntry<K, V> getEntry(int i7) {
        LinkEntry<K, V> linkEntry;
        if (i7 >= 0) {
            int i8 = this.size;
            if (i7 < i8) {
                if (i7 < i8 / 2) {
                    linkEntry = this.header.after;
                    for (int i9 = 0; i9 < i7; i9++) {
                        linkEntry = linkEntry.after;
                    }
                } else {
                    linkEntry = this.header;
                    while (i8 > i7) {
                        linkEntry = linkEntry.before;
                        i8--;
                    }
                }
                return linkEntry;
            }
            throw new IndexOutOfBoundsException("Index " + i7 + " is invalid for size " + this.size);
        }
        throw new IndexOutOfBoundsException("Index " + i7 + " is less than zero");
    }

    protected AbstractLinkedMap(int i7, float f8) {
        super(i7, f8);
    }

    protected AbstractLinkedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }
}
