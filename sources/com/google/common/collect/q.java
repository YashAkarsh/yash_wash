package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class q<K, V> extends x<K, V> implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f20914h = 2447537837011683357L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient Map<K, Collection<V>> f20915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient int f20916g;

    class a extends q<K, V>.d<V> {
        a() {
            super();
        }

        @Override // com.google.common.collect.q.d
        V a(K k7, V v7) {
            return v7;
        }
    }

    class b extends q<K, V>.d<Map.Entry<K, V>> {
        b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k7, V v7) {
            return wb.T(k7, v7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c extends wb.s0<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final transient Map<K, Collection<V>> f20919d;

        class a extends wb.t<K, Collection<V>> {
            a() {
            }

            @Override // com.google.common.collect.wb.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return h3.j(c.this.f20919d.entrySet(), obj);
            }

            @Override // com.google.common.collect.wb.t
            Map<K, Collection<V>> g() {
                return c.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return c.this.new b();
            }

            @Override // com.google.common.collect.wb.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                q.this.N(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<Map.Entry<K, Collection<V>>> spliterator() {
                Spliterator spliterator = c.this.f20919d.entrySet().spliterator();
                final c cVar = c.this;
                return q2.e(spliterator, new Function() { // from class: com.google.common.collect.r
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return cVar.f((Map.Entry) obj);
                    }
                });
            }
        }

        class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f20922a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Collection<V> f20923b;

            b() {
                this.f20922a = c.this.f20919d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f20922a.next();
                this.f20923b = next.getValue();
                return c.this.f(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f20922a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                f2.e(this.f20923b != null);
                this.f20922a.remove();
                q.this.f20916g -= this.f20923b.size();
                this.f20923b.clear();
                this.f20923b = null;
            }
        }

        c(Map<K, Collection<V>> map) {
            this.f20919d = map;
        }

        @Override // com.google.common.collect.wb.s0
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f20919d == q.this.f20915f) {
                q.this.clear();
            } else {
                ua.h(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return wb.y0(this.f20919d, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) wb.z0(this.f20919d, obj);
            if (collection == null) {
                return null;
            }
            return q.this.R(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            Collection<V> collectionRemove = this.f20919d.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionZ = q.this.z();
            collectionZ.addAll(collectionRemove);
            q.this.f20916g -= collectionRemove.size();
            collectionRemove.clear();
            return collectionZ;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f20919d.equals(obj);
        }

        Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return wb.T(key, q.this.R(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f20919d.hashCode();
        }

        @Override // com.google.common.collect.wb.s0, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return q.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f20919d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f20919d.toString();
        }
    }

    private abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f20925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        K f20926b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Collection<V> f20927c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Iterator<V> f20928d = ua.w();

        d() {
            this.f20925a = q.this.f20915f.entrySet().iterator();
        }

        abstract T a(K k7, V v7);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20925a.hasNext() || this.f20928d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f20928d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f20925a.next();
                this.f20926b = next.getKey();
                Collection<V> value = next.getValue();
                this.f20927c = value;
                this.f20928d = value.iterator();
            }
            return a(this.f20926b, this.f20928d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f20928d.remove();
            if (this.f20927c.isEmpty()) {
                this.f20925a.remove();
            }
            q.w(q.this);
        }
    }

    private class e extends wb.c0<K, Collection<V>> {

        class a implements Iterator<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Map.Entry<K, Collection<V>> f20931a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Iterator f20932b;

            a(Iterator it) {
                this.f20932b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f20932b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f20932b.next();
                this.f20931a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                f2.e(this.f20931a != null);
                Collection<V> value = this.f20931a.getValue();
                this.f20932b.remove();
                q.this.f20916g -= value.size();
                value.clear();
                this.f20931a = null;
            }
        }

        e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ua.h(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return k().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || k().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return k().keySet().hashCode();
        }

        @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(k().entrySet().iterator());
        }

        @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection<V> collectionRemove = k().remove(obj);
            if (collectionRemove != null) {
                size = collectionRemove.size();
                collectionRemove.clear();
                q.this.f20916g -= size;
            } else {
                size = 0;
            }
            return size > 0;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            return k().keySet().spliterator();
        }
    }

    class f extends q<K, V>.i implements NavigableMap<K, Collection<V>> {
        f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k7) {
            Map.Entry<K, Collection<V>> entryCeilingEntry = k().ceilingEntry(k7);
            if (entryCeilingEntry == null) {
                return null;
            }
            return f(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k7) {
            return k().ceilingKey(k7);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(k().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> entryFirstEntry = k().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return f(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k7) {
            Map.Entry<K, Collection<V>> entryFloorEntry = k().floorEntry(k7);
            if (entryFloorEntry == null) {
                return null;
            }
            return f(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k7) {
            return k().floorKey(k7);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k7) {
            Map.Entry<K, Collection<V>> entryHigherEntry = k().higherEntry(k7);
            if (entryHigherEntry == null) {
                return null;
            }
            return f(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k7) {
            return k().higherKey(k7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> g() {
            return new g(k());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> entryLastEntry = k().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return f(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k7) {
            Map.Entry<K, Collection<V>> entryLowerEntry = k().lowerEntry(k7);
            if (entryLowerEntry == null) {
                return null;
            }
            return f(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k7) {
            return k().lowerKey(k7);
        }

        @Override // com.google.common.collect.q.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> headMap(K k7) {
            return headMap(k7, false);
        }

        @Override // com.google.common.collect.q.i, com.google.common.collect.q.c, com.google.common.collect.wb.s0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return i();
        }

        Map.Entry<K, Collection<V>> o(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> collectionZ = q.this.z();
            collectionZ.addAll(next.getValue());
            it.remove();
            return wb.T(next.getKey(), q.this.P(collectionZ));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return o(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return o(descendingMap().entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> k() {
            return (NavigableMap) super.k();
        }

        @Override // com.google.common.collect.q.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> subMap(K k7, K k8) {
            return subMap(k7, true, k8, false);
        }

        @Override // com.google.common.collect.q.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> tailMap(K k7) {
            return tailMap(k7, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k7, boolean z7) {
            return new f(k().headMap(k7, z7));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k7, boolean z7, K k8, boolean z8) {
            return new f(k().subMap(k7, z7, k8, z8));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k7, boolean z7) {
            return new f(k().tailMap(k7, z7));
        }
    }

    class g extends q<K, V>.j implements NavigableSet<K> {
        g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k7) {
            return k().ceilingKey(k7);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(k().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K k7) {
            return k().floorKey(k7);
        }

        @Override // java.util.NavigableSet
        public K higher(K k7) {
            return k().higherKey(k7);
        }

        @Override // com.google.common.collect.q.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> headSet(K k7) {
            return headSet(k7, false);
        }

        @Override // java.util.NavigableSet
        public K lower(K k7) {
            return k().lowerKey(k7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q.j
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> k() {
            return (NavigableMap) super.k();
        }

        @Override // com.google.common.collect.q.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> subSet(K k7, K k8) {
            return subSet(k7, true, k8, false);
        }

        @Override // com.google.common.collect.q.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> tailSet(K k7) {
            return tailSet(k7, true);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) ua.U(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) ua.U(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k7, boolean z7) {
            return new g(k().headMap(k7, z7));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k7, boolean z7, K k8, boolean z8) {
            return new g(k().subMap(k7, z7, k8, z8));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k7, boolean z7) {
            return new g(k().tailMap(k7, z7));
        }
    }

    private class h extends q<K, V>.l implements RandomAccess {
        h(K k7, List<V> list, q<K, V>.k kVar) {
            super(k7, list, kVar);
        }
    }

    private class i extends q<K, V>.c implements SortedMap<K, Collection<V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SortedSet<K> f20937f;

        i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return k().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return k().firstKey();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.wb.s0
        public SortedSet<K> g() {
            return new j(k());
        }

        public SortedMap<K, Collection<V>> headMap(K k7) {
            return new i(k().headMap(k7));
        }

        @Override // com.google.common.collect.q.c, com.google.common.collect.wb.s0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: i */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f20937f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetG = g();
            this.f20937f = sortedSetG;
            return sortedSetG;
        }

        SortedMap<K, Collection<V>> k() {
            return (SortedMap) this.f20919d;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return k().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k7, K k8) {
            return new i(k().subMap(k7, k8));
        }

        public SortedMap<K, Collection<V>> tailMap(K k7) {
            return new i(k().tailMap(k7));
        }
    }

    private class j extends q<K, V>.e implements SortedSet<K> {
        j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return k().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return k().firstKey();
        }

        public SortedSet<K> headSet(K k7) {
            return new j(k().headMap(k7));
        }

        SortedMap<K, Collection<V>> k() {
            return (SortedMap) super.k();
        }

        @Override // java.util.SortedSet
        public K last() {
            return k().lastKey();
        }

        public SortedSet<K> subSet(K k7, K k8) {
            return new j(k().subMap(k7, k8));
        }

        public SortedSet<K> tailSet(K k7) {
            return new j(k().tailMap(k7));
        }
    }

    class m extends q<K, V>.o implements NavigableSet<V> {
        m(K k7, NavigableSet<V> navigableSet, q<K, V>.k kVar) {
            super(k7, navigableSet, kVar);
        }

        private NavigableSet<V> l(NavigableSet<V> navigableSet) {
            return new m(this.f20940a, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v7) {
            return j().ceiling(v7);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(j().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return l(j().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v7) {
            return j().floor(v7);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v7, boolean z7) {
            return l(j().headSet(v7, z7));
        }

        @Override // java.util.NavigableSet
        public V higher(V v7) {
            return j().higher(v7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q.o
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableSet<V> j() {
            return (NavigableSet) super.j();
        }

        @Override // java.util.NavigableSet
        public V lower(V v7) {
            return j().lower(v7);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) ua.U(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) ua.U(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v7, boolean z7, V v8, boolean z8) {
            return l(j().subSet(v7, z7, v8, z8));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v7, boolean z7) {
            return l(j().tailSet(v7, z7));
        }
    }

    class n extends q<K, V>.k implements Set<V> {
        n(K k7, Set<V> set) {
            super(k7, set, null);
        }

        @Override // com.google.common.collect.q.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zI = af.I((Set) this.f20941b, collection);
            if (zI) {
                int size2 = this.f20941b.size();
                q.this.f20916g += size2 - size;
                h();
            }
            return zI;
        }
    }

    class o extends q<K, V>.k implements SortedSet<V> {
        o(K k7, SortedSet<V> sortedSet, q<K, V>.k kVar) {
            super(k7, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            g();
            return j().first();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v7) {
            g();
            return new o(f(), j().headSet(v7), b() == null ? this : b());
        }

        SortedSet<V> j() {
            return (SortedSet) d();
        }

        @Override // java.util.SortedSet
        public V last() {
            g();
            return j().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v7, V v8) {
            g();
            return new o(f(), j().subSet(v7, v8), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v7) {
            g();
            return new o(f(), j().tailSet(v7), b() == null ? this : b());
        }
    }

    protected q(Map<K, Collection<V>> map) {
        com.google.common.base.e0.d(map.isEmpty());
        this.f20915f = map;
    }

    private Collection<V> F(K k7) {
        Collection<V> collection = this.f20915f.get(k7);
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionA = A(k7);
        this.f20915f.put(k7, collectionA);
        return collectionA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> I(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator J(Map.Entry entry) {
        final Object key = entry.getKey();
        return q2.e(((Collection) entry.getValue()).spliterator(), new Function() { // from class: com.google.common.collect.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return wb.T(key, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(final BiConsumer biConsumer, final Object obj, Collection collection) {
        collection.forEach(new Consumer() { // from class: com.google.common.collect.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                biConsumer.accept(obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Object obj) {
        Collection collection = (Collection) wb.A0(this.f20915f, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f20916g -= size;
        }
    }

    static /* synthetic */ int v(q qVar) {
        int i7 = qVar.f20916g;
        qVar.f20916g = i7 + 1;
        return i7;
    }

    static /* synthetic */ int w(q qVar) {
        int i7 = qVar.f20916g;
        qVar.f20916g = i7 - 1;
        return i7;
    }

    Collection<V> A(K k7) {
        return z();
    }

    final Map<K, Collection<V>> B() {
        Map<K, Collection<V>> map = this.f20915f;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.f20915f);
        }
        return map instanceof SortedMap ? new i((SortedMap) this.f20915f) : new c(this.f20915f);
    }

    final Set<K> C() {
        Map<K, Collection<V>> map = this.f20915f;
        if (map instanceof NavigableMap) {
            return new g((NavigableMap) this.f20915f);
        }
        return map instanceof SortedMap ? new j((SortedMap) this.f20915f) : new e(this.f20915f);
    }

    Collection<V> E() {
        return (Collection<V>) P(z());
    }

    final void O(Map<K, Collection<V>> map) {
        this.f20915f = map;
        this.f20916g = 0;
        for (Collection<V> collection : map.values()) {
            com.google.common.base.e0.d(!collection.isEmpty());
            this.f20916g += collection.size();
        }
    }

    <E> Collection<E> P(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    Collection<V> R(K k7, Collection<V> collection) {
        return new k(k7, collection, null);
    }

    final List<V> S(K k7, List<V> list, q<K, V>.k kVar) {
        return list instanceof RandomAccess ? new h(k7, list, kVar) : new l(k7, list, kVar);
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    public Collection<V> a(Object obj) {
        Collection<V> collectionRemove = this.f20915f.remove(obj);
        if (collectionRemove == null) {
            return E();
        }
        Collection collectionZ = z();
        collectionZ.addAll(collectionRemove);
        this.f20916g -= collectionRemove.size();
        collectionRemove.clear();
        return (Collection<V>) P(collectionZ);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    public Collection<V> b(K k7, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return a(k7);
        }
        Collection<V> collectionF = F(k7);
        Collection<V> collectionZ = z();
        collectionZ.addAll(collectionF);
        this.f20916g -= collectionF.size();
        collectionF.clear();
        while (it.hasNext()) {
            if (collectionF.add(it.next())) {
                this.f20916g++;
            }
        }
        return (Collection<V>) P(collectionZ);
    }

    @Override // com.google.common.collect.x
    Map<K, Collection<V>> c() {
        return new c(this.f20915f);
    }

    @Override // com.google.common.collect.tc
    public void clear() {
        Iterator<Collection<V>> it = this.f20915f.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f20915f.clear();
        this.f20916g = 0;
    }

    @Override // com.google.common.collect.tc
    public boolean containsKey(Object obj) {
        return this.f20915f.containsKey(obj);
    }

    @Override // com.google.common.collect.x
    Collection<Map.Entry<K, V>> e() {
        return this instanceof ue ? new x.b() : new x.a();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    /* JADX INFO: renamed from: entries */
    public Collection<Map.Entry<K, V>> y() {
        return super.y();
    }

    @Override // com.google.common.collect.x
    Set<K> f() {
        return new e(this.f20915f);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        this.f20915f.forEach(new BiConsumer() { // from class: com.google.common.collect.l
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                q.K(biConsumer, obj, (Collection) obj2);
            }
        });
    }

    @Override // com.google.common.collect.x
    hd<K> g() {
        return new cd.g(this);
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    public Collection<V> get(K k7) {
        Collection<V> collectionA = this.f20915f.get(k7);
        if (collectionA == null) {
            collectionA = A(k7);
        }
        return R(k7, collectionA);
    }

    @Override // com.google.common.collect.x
    Collection<V> h() {
        return new x.c();
    }

    @Override // com.google.common.collect.x
    Iterator<Map.Entry<K, V>> i() {
        return new b();
    }

    @Override // com.google.common.collect.x
    Spliterator<Map.Entry<K, V>> j() {
        return q2.b(this.f20915f.entrySet().spliterator(), new Function() { // from class: com.google.common.collect.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return q.J((Map.Entry) obj);
            }
        }, 64, size());
    }

    @Override // com.google.common.collect.x
    Iterator<V> k() {
        return new a();
    }

    @Override // com.google.common.collect.x
    Spliterator<V> l() {
        return q2.b(this.f20915f.values().spliterator(), new Function() { // from class: com.google.common.collect.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Collection) obj).spliterator();
            }
        }, 64, size());
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public boolean put(K k7, V v7) {
        Collection<V> collection = this.f20915f.get(k7);
        if (collection != null) {
            if (!collection.add(v7)) {
                return false;
            }
            this.f20916g++;
            return true;
        }
        Collection<V> collectionA = A(k7);
        if (!collectionA.add(v7)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f20916g++;
        this.f20915f.put(k7, collectionA);
        return true;
    }

    @Override // com.google.common.collect.tc
    public int size() {
        return this.f20916g;
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public Collection<V> values() {
        return super.values();
    }

    Map<K, Collection<V>> y() {
        return this.f20915f;
    }

    abstract Collection<V> z();

    class k extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f20940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Collection<V> f20941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final q<K, V>.k f20942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Collection<V> f20943d;

        k(K k7, Collection<V> collection, q<K, V>.k kVar) {
            this.f20940a = k7;
            this.f20941b = collection;
            this.f20942c = kVar;
            this.f20943d = kVar == null ? null : kVar.d();
        }

        void a() {
            q<K, V>.k kVar = this.f20942c;
            if (kVar != null) {
                kVar.a();
            } else {
                q.this.f20915f.put(this.f20940a, this.f20941b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v7) {
            g();
            boolean zIsEmpty = this.f20941b.isEmpty();
            boolean zAdd = this.f20941b.add(v7);
            if (zAdd) {
                q.v(q.this);
                if (zIsEmpty) {
                    a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f20941b.addAll(collection);
            if (zAddAll) {
                int size2 = this.f20941b.size();
                q.this.f20916g += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        q<K, V>.k b() {
            return this.f20942c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f20941b.clear();
            q.this.f20916g -= size;
            h();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            g();
            return this.f20941b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            g();
            return this.f20941b.containsAll(collection);
        }

        Collection<V> d() {
            return this.f20941b;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            g();
            return this.f20941b.equals(obj);
        }

        K f() {
            return this.f20940a;
        }

        void g() {
            Collection<V> collection;
            q<K, V>.k kVar = this.f20942c;
            if (kVar != null) {
                kVar.g();
                if (this.f20942c.d() != this.f20943d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f20941b.isEmpty() || (collection = (Collection) q.this.f20915f.get(this.f20940a)) == null) {
                    return;
                }
                this.f20941b = collection;
            }
        }

        void h() {
            q<K, V>.k kVar = this.f20942c;
            if (kVar != null) {
                kVar.h();
            } else if (this.f20941b.isEmpty()) {
                q.this.f20915f.remove(this.f20940a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            g();
            return this.f20941b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            g();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            g();
            boolean zRemove = this.f20941b.remove(obj);
            if (zRemove) {
                q.w(q.this);
                h();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f20941b.removeAll(collection);
            if (zRemoveAll) {
                int size2 = this.f20941b.size();
                q.this.f20916g += size2 - size;
                h();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.e0.E(collection);
            int size = size();
            boolean zRetainAll = this.f20941b.retainAll(collection);
            if (zRetainAll) {
                int size2 = this.f20941b.size();
                q.this.f20916g += size2 - size;
                h();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            g();
            return this.f20941b.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            g();
            return this.f20941b.spliterator();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            g();
            return this.f20941b.toString();
        }

        class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator<V> f20945a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final Collection<V> f20946b;

            a() {
                Collection<V> collection = k.this.f20941b;
                this.f20946b = collection;
                this.f20945a = q.I(collection);
            }

            Iterator<V> a() {
                b();
                return this.f20945a;
            }

            void b() {
                k.this.g();
                if (k.this.f20941b != this.f20946b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f20945a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.f20945a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f20945a.remove();
                q.w(q.this);
                k.this.h();
            }

            a(Iterator<V> it) {
                this.f20946b = k.this.f20941b;
                this.f20945a = it;
            }
        }
    }

    class l extends q<K, V>.k implements List<V> {

        private class a extends q<K, V>.k.a implements ListIterator<V> {
            a() {
                super();
            }

            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(V v7) {
                boolean zIsEmpty = l.this.isEmpty();
                c().add(v7);
                q.v(q.this);
                if (zIsEmpty) {
                    l.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v7) {
                c().set(v7);
            }

            public a(int i7) {
                super(l.this.j().listIterator(i7));
            }
        }

        l(K k7, List<V> list, q<K, V>.k kVar) {
            super(k7, list, kVar);
        }

        @Override // java.util.List
        public void add(int i7, V v7) {
            g();
            boolean zIsEmpty = d().isEmpty();
            j().add(i7, v7);
            q.v(q.this);
            if (zIsEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i7, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = j().addAll(i7, collection);
            if (zAddAll) {
                int size2 = d().size();
                q.this.f20916g += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public V get(int i7) {
            g();
            return j().get(i7);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            g();
            return j().indexOf(obj);
        }

        List<V> j() {
            return (List) d();
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            g();
            return j().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            g();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i7) {
            g();
            V vRemove = j().remove(i7);
            q.w(q.this);
            h();
            return vRemove;
        }

        @Override // java.util.List
        public V set(int i7, V v7) {
            g();
            return j().set(i7, v7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i7, int i8) {
            g();
            return q.this.S(f(), j().subList(i7, i8), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i7) {
            g();
            return new a(i7);
        }
    }
}
