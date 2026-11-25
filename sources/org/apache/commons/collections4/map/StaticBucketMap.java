package org.apache.commons.collections4.map;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: classes3.dex */
public final class StaticBucketMap<K, V> extends AbstractIterableMap<K, V> {
    private static final int DEFAULT_BUCKETS = 255;
    private final Node<K, V>[] buckets;
    private final Lock[] locks;

    private class BaseIterator {
        private int bucket;
        private final ArrayList<Map.Entry<K, V>> current;
        private Map.Entry<K, V> last;

        private BaseIterator() {
            this.current = new ArrayList<>();
        }

        public boolean hasNext() {
            if (this.current.size() > 0) {
                return true;
            }
            while (this.bucket < StaticBucketMap.this.buckets.length) {
                synchronized (StaticBucketMap.this.locks[this.bucket]) {
                    for (Node<K, V> node = StaticBucketMap.this.buckets[this.bucket]; node != null; node = node.next) {
                        this.current.add(node);
                    }
                    this.bucket++;
                    if (this.current.size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        protected Map.Entry<K, V> nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ArrayList<Map.Entry<K, V>> arrayList = this.current;
            Map.Entry<K, V> entryRemove = arrayList.remove(arrayList.size() - 1);
            this.last = entryRemove;
            return entryRemove;
        }

        public void remove() {
            Map.Entry<K, V> entry = this.last;
            if (entry == null) {
                throw new IllegalStateException();
            }
            StaticBucketMap.this.remove(entry.getKey());
            this.last = null;
        }
    }

    private class EntryIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        StaticBucketMap.this.remove(node.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    private class KeyIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    private class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StaticBucketMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int hash = StaticBucketMap.this.getHash(obj);
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    K key = node.getKey();
                    if (key != obj && (key == null || !key.equals(obj))) {
                    }
                    StaticBucketMap.this.remove(key);
                    return true;
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    private static final class Lock {
        public int size;

        private Lock() {
        }
    }

    private static final class Node<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
        protected K key;
        protected Node<K, V> next;
        protected V value;

        private Node() {
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k7 = this.key;
            if (k7 != null ? k7.equals(entry.getKey()) : entry.getKey() == null) {
                V v7 = this.value;
                Object value = entry.getValue();
                if (v7 == null) {
                    if (value == null) {
                        return true;
                    }
                } else if (v7.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k7 = this.key;
            int iHashCode = k7 == null ? 0 : k7.hashCode();
            V v7 = this.value;
            return iHashCode ^ (v7 != null ? v7.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            V v8 = this.value;
            this.value = v7;
            return v8;
        }
    }

    private class ValueIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    private class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    public StaticBucketMap() {
        this(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHash(Object obj) {
        if (obj == null) {
            return 0;
        }
        int iHashCode = obj.hashCode();
        int i7 = iHashCode + (~(iHashCode << 15));
        int i8 = i7 ^ (i7 >>> 10);
        int i9 = i8 + (i8 << 3);
        int i10 = i9 ^ (i9 >>> 6);
        int i11 = i10 + (~(i10 << 11));
        int length = (i11 ^ (i11 >>> 16)) % this.buckets.length;
        return length < 0 ? length * (-1) : length;
    }

    public void atomic(Runnable runnable) {
        runnable.getClass();
        atomic(runnable, 0);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        for (int i7 = 0; i7 < this.buckets.length; i7++) {
            Lock lock = this.locks[i7];
            synchronized (lock) {
                this.buckets[i7] = null;
                lock.size = 0;
            }
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                K k7 = node.key;
                if (k7 != obj && (k7 == null || !k7.equals(obj))) {
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        for (int i7 = 0; i7 < this.buckets.length; i7++) {
            synchronized (this.locks[i7]) {
                for (Node<K, V> node = this.buckets[i7]; node != null; node = node.next) {
                    V v7 = node.value;
                    if (v7 != obj && (v7 == null || !v7.equals(obj))) {
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                K k7 = node.key;
                if (k7 != obj && (k7 == null || !k7.equals(obj))) {
                }
                return node.value;
            }
            return null;
        }
    }

    @Override // java.util.Map
    public int hashCode() {
        int iHashCode = 0;
        for (int i7 = 0; i7 < this.buckets.length; i7++) {
            synchronized (this.locks[i7]) {
                for (Node<K, V> node = this.buckets[i7]; node != null; node = node.next) {
                    iHashCode += node.hashCode();
                }
            }
        }
        return iHashCode;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return new KeySet();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k7, V v7) {
        int hash = getHash(k7);
        synchronized (this.locks[hash]) {
            Node<K, V> node = this.buckets[hash];
            if (node == null) {
                Node<K, V> node2 = new Node<>();
                node2.key = k7;
                node2.value = v7;
                this.buckets[hash] = node2;
                this.locks[hash].size++;
                return null;
            }
            Node<K, V> node3 = node;
            while (node != null) {
                K k8 = node.key;
                if (k8 != k7 && (k8 == null || !k8.equals(k7))) {
                    node3 = node;
                    node = node.next;
                }
                V v8 = node.value;
                node.value = v7;
                return v8;
            }
            Node<K, V> node4 = new Node<>();
            node4.key = k7;
            node4.value = v7;
            node3.next = node4;
            this.locks[hash].size++;
            return null;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node<K, V> node = null;
            for (Node<K, V> node2 = this.buckets[hash]; node2 != null; node2 = node2.next) {
                K k7 = node2.key;
                if (k7 != obj && (k7 == null || !k7.equals(obj))) {
                    node = node2;
                }
                if (node == null) {
                    this.buckets[hash] = node2.next;
                } else {
                    node.next = node2.next;
                }
                this.locks[hash].size--;
                return node2.value;
            }
            return null;
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        int i7 = 0;
        for (int i8 = 0; i8 < this.buckets.length; i8++) {
            synchronized (this.locks[i8]) {
                i7 += this.locks[i8].size;
            }
        }
        return i7;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return new Values();
    }

    public StaticBucketMap(int i7) {
        int iMax = Math.max(17, i7);
        iMax = iMax % 2 == 0 ? iMax - 1 : iMax;
        this.buckets = new Node[iMax];
        this.locks = new Lock[iMax];
        for (int i8 = 0; i8 < iMax; i8++) {
            this.locks[i8] = new Lock();
        }
    }

    private void atomic(Runnable runnable, int i7) {
        if (i7 >= this.buckets.length) {
            runnable.run();
            return;
        }
        synchronized (this.locks[i7]) {
            atomic(runnable, i7 + 1);
        }
    }
}
