package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class dj {

    private static class b<K, V> extends k<K, Collection<V>> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final long f20129j = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        transient Set<Map.Entry<K, Collection<V>>> f20130h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        transient Collection<Collection<V>> f20131i;

        b(Map<K, Collection<V>> map, Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.dj.k, java.util.Map
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.dj.k, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.f20167b) {
                if (this.f20130h == null) {
                    this.f20130h = new c(o().entrySet(), this.f20167b);
                }
                set = this.f20130h;
            }
            return set;
        }

        @Override // com.google.common.collect.dj.k, java.util.Map
        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.f20167b) {
                if (this.f20131i == null) {
                    this.f20131i = new d(o().values(), this.f20167b);
                }
                collection = this.f20131i;
            }
            return collection;
        }

        @Override // com.google.common.collect.dj.k, java.util.Map
        public Collection<V> get(Object obj) {
            Collection<V> collectionA;
            synchronized (this.f20167b) {
                Collection collection = (Collection) super.get(obj);
                collectionA = collection == null ? null : dj.A(collection, this.f20167b);
            }
            return collectionA;
        }
    }

    private static class d<V> extends f<Collection<V>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f20136e = 0;

        class a extends uj<Collection<V>, Collection<V>> {
            a(Iterator it) {
                super(it);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.uj
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Collection<V> a(Collection<V> collection) {
                return dj.A(collection, d.this.f20167b);
            }
        }

        d(Collection<Collection<V>> collection, Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.dj.f, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            return new a(super.iterator());
        }
    }

    @s1.d
    static class e<K, V> extends k<K, V> implements r0<K, V>, Serializable {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final long f20138j = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private transient Set<V> f20139h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @y1.h
        private transient r0<V, K> f20140i;

        @Override // com.google.common.collect.r0
        public r0<V, K> T() {
            r0<V, K> r0Var;
            synchronized (this.f20167b) {
                if (this.f20140i == null) {
                    this.f20140i = new e(l().T(), this.f20167b, this);
                }
                r0Var = this.f20140i;
            }
            return r0Var;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.k
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public r0<K, V> o() {
            return (r0) super.o();
        }

        @Override // com.google.common.collect.r0
        public V x(K k7, V v7) {
            V vX;
            synchronized (this.f20167b) {
                vX = l().x(k7, v7);
            }
            return vX;
        }

        private e(r0<K, V> r0Var, Object obj, r0<V, K> r0Var2) {
            super(r0Var, obj);
            this.f20140i = r0Var2;
        }

        @Override // com.google.common.collect.dj.k, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.f20167b) {
                if (this.f20139h == null) {
                    this.f20139h = dj.u(l().values(), this.f20167b);
                }
                set = this.f20139h;
            }
            return set;
        }
    }

    @s1.d
    static class f<E> extends p implements Collection<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f20141d = 0;

        @Override // java.util.Collection
        public boolean add(E e8) {
            boolean zAdd;
            synchronized (this.f20167b) {
                zAdd = u().add(e8);
            }
            return zAdd;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            boolean zAddAll;
            synchronized (this.f20167b) {
                zAddAll = u().addAll(collection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.f20167b) {
                u().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean zContains;
            synchronized (this.f20167b) {
                zContains = u().contains(obj);
            }
            return zContains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean zContainsAll;
            synchronized (this.f20167b) {
                zContainsAll = u().containsAll(collection);
            }
            return zContainsAll;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            synchronized (this.f20167b) {
                u().forEach(consumer);
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f20167b) {
                zIsEmpty = u().isEmpty();
            }
            return zIsEmpty;
        }

        public Iterator<E> iterator() {
            return u().iterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.p
        /* JADX INFO: renamed from: o */
        public Collection<E> o() {
            return (Collection) super.o();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            Stream<E> streamParallelStream;
            synchronized (this.f20167b) {
                streamParallelStream = u().parallelStream();
            }
            return streamParallelStream;
        }

        public boolean remove(Object obj) {
            boolean zRemove;
            synchronized (this.f20167b) {
                zRemove = u().remove(obj);
            }
            return zRemove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean zRemoveAll;
            synchronized (this.f20167b) {
                zRemoveAll = u().removeAll(collection);
            }
            return zRemoveAll;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> predicate) {
            boolean zRemoveIf;
            synchronized (this.f20167b) {
                zRemoveIf = u().removeIf(predicate);
            }
            return zRemoveIf;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean zRetainAll;
            synchronized (this.f20167b) {
                zRetainAll = u().retainAll(collection);
            }
            return zRetainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.f20167b) {
                size = u().size();
            }
            return size;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            Spliterator<E> spliterator;
            synchronized (this.f20167b) {
                spliterator = u().spliterator();
            }
            return spliterator;
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            Stream<E> stream;
            synchronized (this.f20167b) {
                stream = u().stream();
            }
            return stream;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.f20167b) {
                array = u().toArray();
            }
            return array;
        }

        private f(Collection<E> collection, Object obj) {
            super(collection, obj);
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.f20167b) {
                tArr2 = (T[]) u().toArray(tArr);
            }
            return tArr2;
        }
    }

    private static final class g<E> extends q<E> implements Deque<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final long f20142f = 0;

        g(Deque<E> deque, Object obj) {
            super(deque, obj);
        }

        @Override // java.util.Deque
        public void addFirst(E e8) {
            synchronized (this.f20167b) {
                o().addFirst(e8);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e8) {
            synchronized (this.f20167b) {
                o().addLast(e8);
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Iterator<E> itDescendingIterator;
            synchronized (this.f20167b) {
                itDescendingIterator = o().descendingIterator();
            }
            return itDescendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.f20167b) {
                first = o().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.f20167b) {
                last = o().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e8) {
            boolean zOfferFirst;
            synchronized (this.f20167b) {
                zOfferFirst = o().offerFirst(e8);
            }
            return zOfferFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e8) {
            boolean zOfferLast;
            synchronized (this.f20167b) {
                zOfferLast = o().offerLast(e8);
            }
            return zOfferLast;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            E ePeekFirst;
            synchronized (this.f20167b) {
                ePeekFirst = o().peekFirst();
            }
            return ePeekFirst;
        }

        @Override // java.util.Deque
        public E peekLast() {
            E ePeekLast;
            synchronized (this.f20167b) {
                ePeekLast = o().peekLast();
            }
            return ePeekLast;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            E ePollFirst;
            synchronized (this.f20167b) {
                ePollFirst = o().pollFirst();
            }
            return ePollFirst;
        }

        @Override // java.util.Deque
        public E pollLast() {
            E ePollLast;
            synchronized (this.f20167b) {
                ePollLast = o().pollLast();
            }
            return ePollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E ePop;
            synchronized (this.f20167b) {
                ePop = o().pop();
            }
            return ePop;
        }

        @Override // java.util.Deque
        public void push(E e8) {
            synchronized (this.f20167b) {
                o().push(e8);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E eRemoveFirst;
            synchronized (this.f20167b) {
                eRemoveFirst = o().removeFirst();
            }
            return eRemoveFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object obj) {
            boolean zRemoveFirstOccurrence;
            synchronized (this.f20167b) {
                zRemoveFirstOccurrence = o().removeFirstOccurrence(obj);
            }
            return zRemoveFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E eRemoveLast;
            synchronized (this.f20167b) {
                eRemoveLast = o().removeLast();
            }
            return eRemoveLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object obj) {
            boolean zRemoveLastOccurrence;
            synchronized (this.f20167b) {
                zRemoveLastOccurrence = o().removeLastOccurrence(obj);
            }
            return zRemoveLastOccurrence;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.q
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Deque<E> u() {
            return (Deque) super.u();
        }
    }

    @s1.c
    private static class h<K, V> extends p implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f20143d = 0;

        h(Map.Entry<K, V> entry, Object obj) {
            super(entry, obj);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean zEquals;
            synchronized (this.f20167b) {
                zEquals = o().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.f20167b) {
                key = o().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.f20167b) {
                value = o().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int iHashCode;
            synchronized (this.f20167b) {
                iHashCode = o().hashCode();
            }
            return iHashCode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.p
        public Map.Entry<K, V> o() {
            return (Map.Entry) super.o();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            V value;
            synchronized (this.f20167b) {
                value = o().setValue(v7);
            }
            return value;
        }
    }

    private static class i<E> extends f<E> implements List<E> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f20144e = 0;

        i(List<E> list, Object obj) {
            super(list, obj);
        }

        @Override // java.util.List
        public void add(int i7, E e8) {
            synchronized (this.f20167b) {
                o().add(i7, e8);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i7, Collection<? extends E> collection) {
            boolean zAddAll;
            synchronized (this.f20167b) {
                zAddAll = o().addAll(i7, collection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f20167b) {
                zEquals = o().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.List
        public E get(int i7) {
            E e8;
            synchronized (this.f20167b) {
                e8 = o().get(i7);
            }
            return e8;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode;
            synchronized (this.f20167b) {
                iHashCode = o().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            synchronized (this.f20167b) {
                iIndexOf = o().indexOf(obj);
            }
            return iIndexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int iLastIndexOf;
            synchronized (this.f20167b) {
                iLastIndexOf = o().lastIndexOf(obj);
            }
            return iLastIndexOf;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return o().listIterator();
        }

        @Override // java.util.List
        public E remove(int i7) {
            E eRemove;
            synchronized (this.f20167b) {
                eRemove = o().remove(i7);
            }
            return eRemove;
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> unaryOperator) {
            synchronized (this.f20167b) {
                o().replaceAll(unaryOperator);
            }
        }

        @Override // java.util.List
        public E set(int i7, E e8) {
            E e9;
            synchronized (this.f20167b) {
                e9 = o().set(i7, e8);
            }
            return e9;
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> comparator) {
            synchronized (this.f20167b) {
                o().sort(comparator);
            }
        }

        @Override // java.util.List
        public List<E> subList(int i7, int i8) {
            List<E> listJ;
            synchronized (this.f20167b) {
                listJ = dj.j(o().subList(i7, i8), this.f20167b);
            }
            return listJ;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.f
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public List<E> u() {
            return (List) super.u();
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i7) {
            return o().listIterator(i7);
        }
    }

    private static class j<K, V> extends l<K, V> implements hb<K, V> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final long f20145j = 0;

        j(hb<K, V> hbVar, Object obj) {
            super(hbVar, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.l
        public hb<K, V> o() {
            return (hb) super.o();
        }

        @Override // com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.hb
        public List<V> a(Object obj) {
            List<V> listA;
            synchronized (this.f20167b) {
                listA = u().a(obj);
            }
            return listA;
        }

        @Override // com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.hb
        public List<V> b(K k7, Iterable<? extends V> iterable) {
            List<V> listB;
            synchronized (this.f20167b) {
                listB = u().b((Object) k7, (Iterable) iterable);
            }
            return listB;
        }

        @Override // com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.hb
        public List<V> get(K k7) {
            List<V> listJ;
            synchronized (this.f20167b) {
                listJ = dj.j(u().get((Object) k7), this.f20167b);
            }
            return listJ;
        }
    }

    private static class l<K, V> extends p implements tc<K, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final long f20150i = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Set<K> f20151d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        transient Collection<V> f20152e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        transient Collection<Map.Entry<K, V>> f20153f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient Map<K, Collection<V>> f20154g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        transient hd<K> f20155h;

        l(tc<K, V> tcVar, Object obj) {
            super(tcVar, obj);
        }

        @Override // com.google.common.collect.tc
        public boolean H(tc<? extends K, ? extends V> tcVar) {
            boolean zH;
            synchronized (this.f20167b) {
                zH = o().H(tcVar);
            }
            return zH;
        }

        @Override // com.google.common.collect.tc
        public boolean W(Object obj, Object obj2) {
            boolean zW;
            synchronized (this.f20167b) {
                zW = o().W(obj, obj2);
            }
            return zW;
        }

        public Collection<V> a(Object obj) {
            Collection<V> collectionA;
            synchronized (this.f20167b) {
                collectionA = o().a(obj);
            }
            return collectionA;
        }

        @Override // com.google.common.collect.tc
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.f20167b) {
                if (this.f20154g == null) {
                    this.f20154g = new b(o().asMap(), this.f20167b);
                }
                map = this.f20154g;
            }
            return map;
        }

        public Collection<V> b(K k7, Iterable<? extends V> iterable) {
            Collection<V> collectionB;
            synchronized (this.f20167b) {
                collectionB = o().b(k7, iterable);
            }
            return collectionB;
        }

        @Override // com.google.common.collect.tc
        public void clear() {
            synchronized (this.f20167b) {
                o().clear();
            }
        }

        @Override // com.google.common.collect.tc
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.f20167b) {
                zContainsKey = o().containsKey(obj);
            }
            return zContainsKey;
        }

        @Override // com.google.common.collect.tc
        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.f20167b) {
                zContainsValue = o().containsValue(obj);
            }
            return zContainsValue;
        }

        @Override // com.google.common.collect.tc, com.google.common.collect.ue
        /* JADX INFO: renamed from: entries */
        public Collection<Map.Entry<K, V>> y() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.f20167b) {
                if (this.f20153f == null) {
                    this.f20153f = dj.A(o().y(), this.f20167b);
                }
                collection = this.f20153f;
            }
            return collection;
        }

        @Override // com.google.common.collect.tc, com.google.common.collect.ue
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f20167b) {
                zEquals = o().equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.tc
        public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            synchronized (this.f20167b) {
                o().forEach(biConsumer);
            }
        }

        public Collection<V> get(K k7) {
            Collection<V> collectionA;
            synchronized (this.f20167b) {
                collectionA = dj.A(o().get(k7), this.f20167b);
            }
            return collectionA;
        }

        @Override // com.google.common.collect.tc
        public int hashCode() {
            int iHashCode;
            synchronized (this.f20167b) {
                iHashCode = o().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.tc
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f20167b) {
                zIsEmpty = o().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // com.google.common.collect.tc
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.f20167b) {
                if (this.f20151d == null) {
                    this.f20151d = dj.B(o().keySet(), this.f20167b);
                }
                set = this.f20151d;
            }
            return set;
        }

        @Override // com.google.common.collect.tc
        public hd<K> keys() {
            hd<K> hdVar;
            synchronized (this.f20167b) {
                if (this.f20155h == null) {
                    this.f20155h = dj.n(o().keys(), this.f20167b);
                }
                hdVar = this.f20155h;
            }
            return hdVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.p
        public tc<K, V> o() {
            return (tc) super.o();
        }

        @Override // com.google.common.collect.tc
        public boolean put(K k7, V v7) {
            boolean zPut;
            synchronized (this.f20167b) {
                zPut = o().put(k7, v7);
            }
            return zPut;
        }

        @Override // com.google.common.collect.tc
        public boolean putAll(K k7, Iterable<? extends V> iterable) {
            boolean zPutAll;
            synchronized (this.f20167b) {
                zPutAll = o().putAll(k7, iterable);
            }
            return zPutAll;
        }

        @Override // com.google.common.collect.tc
        public boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (this.f20167b) {
                zRemove = o().remove(obj, obj2);
            }
            return zRemove;
        }

        @Override // com.google.common.collect.tc
        public int size() {
            int size;
            synchronized (this.f20167b) {
                size = o().size();
            }
            return size;
        }

        @Override // com.google.common.collect.tc
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.f20167b) {
                if (this.f20152e == null) {
                    this.f20152e = dj.h(o().values(), this.f20167b);
                }
                collection = this.f20152e;
            }
            return collection;
        }
    }

    private static class m<E> extends f<E> implements hd<E> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final long f20156g = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        transient Set<E> f20157e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        transient Set<hd.a<E>> f20158f;

        m(hd<E> hdVar, Object obj) {
            super(hdVar, obj);
        }

        @Override // com.google.common.collect.hd
        public boolean E(E e8, int i7, int i8) {
            boolean zE;
            synchronized (this.f20167b) {
                zE = o().E(e8, i7, i8);
            }
            return zE;
        }

        @Override // com.google.common.collect.hd
        public int add(E e8, int i7) {
            int iAdd;
            synchronized (this.f20167b) {
                iAdd = o().add(e8, i7);
            }
            return iAdd;
        }

        @Override // com.google.common.collect.hd
        public Set<E> e() {
            Set<E> set;
            synchronized (this.f20167b) {
                if (this.f20157e == null) {
                    this.f20157e = dj.B(o().e(), this.f20167b);
                }
                set = this.f20157e;
            }
            return set;
        }

        @Override // com.google.common.collect.hd
        public Set<hd.a<E>> entrySet() {
            Set<hd.a<E>> set;
            synchronized (this.f20167b) {
                if (this.f20158f == null) {
                    this.f20158f = dj.B(o().entrySet(), this.f20167b);
                }
                set = this.f20158f;
            }
            return set;
        }

        @Override // java.util.Collection, com.google.common.collect.hd
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f20167b) {
                zEquals = o().equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.hd
        public /* synthetic */ void h0(ObjIntConsumer objIntConsumer) {
            gd.b(this, objIntConsumer);
        }

        @Override // java.util.Collection, com.google.common.collect.hd
        public int hashCode() {
            int iHashCode;
            synchronized (this.f20167b) {
                iHashCode = o().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.hd
        public int l0(Object obj) {
            int iL0;
            synchronized (this.f20167b) {
                iL0 = o().l0(obj);
            }
            return iL0;
        }

        @Override // com.google.common.collect.hd
        public int remove(Object obj, int i7) {
            int iRemove;
            synchronized (this.f20167b) {
                iRemove = o().remove(obj, i7);
            }
            return iRemove;
        }

        @Override // com.google.common.collect.hd
        public int setCount(E e8, int i7) {
            int count;
            synchronized (this.f20167b) {
                count = o().setCount(e8, i7);
            }
            return count;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.f
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public hd<E> u() {
            return (hd) super.u();
        }
    }

    static class p implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @s1.c
        private static final long f20165c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f20166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f20167b;

        p(Object obj, Object obj2) {
            this.f20166a = com.google.common.base.e0.E(obj);
            this.f20167b = obj2 == null ? this : obj2;
        }

        @s1.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.f20167b) {
                objectOutputStream.defaultWriteObject();
            }
        }

        /* JADX INFO: renamed from: l */
        Object o() {
            return this.f20166a;
        }

        public String toString() {
            String string;
            synchronized (this.f20167b) {
                string = this.f20166a.toString();
            }
            return string;
        }
    }

    private static class q<E> extends f<E> implements Queue<E> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f20168e = 0;

        q(Queue<E> queue, Object obj) {
            super(queue, obj);
        }

        @Override // java.util.Queue
        public E element() {
            E eElement;
            synchronized (this.f20167b) {
                eElement = u().element();
            }
            return eElement;
        }

        @Override // java.util.Queue
        public boolean offer(E e8) {
            boolean zOffer;
            synchronized (this.f20167b) {
                zOffer = u().offer(e8);
            }
            return zOffer;
        }

        @Override // java.util.Queue
        public E peek() {
            E ePeek;
            synchronized (this.f20167b) {
                ePeek = u().peek();
            }
            return ePeek;
        }

        @Override // java.util.Queue
        public E poll() {
            E ePoll;
            synchronized (this.f20167b) {
                ePoll = u().poll();
            }
            return ePoll;
        }

        @Override // java.util.Queue
        public E remove() {
            E eRemove;
            synchronized (this.f20167b) {
                eRemove = u().remove();
            }
            return eRemove;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.f
        public Queue<E> u() {
            return (Queue) super.u();
        }
    }

    private static class r<E> extends i<E> implements RandomAccess {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final long f20169f = 0;

        r(List<E> list, Object obj) {
            super(list, obj);
        }
    }

    static class s<E> extends f<E> implements Set<E> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f20170e = 0;

        s(Set<E> set, Object obj) {
            super(set, obj);
        }

        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f20167b) {
                zEquals = u().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int iHashCode;
            synchronized (this.f20167b) {
                iHashCode = u().hashCode();
            }
            return iHashCode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.f
        public Set<E> u() {
            return (Set) super.u();
        }
    }

    private static class t<K, V> extends l<K, V> implements ue<K, V> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final long f20171k = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        transient Set<Map.Entry<K, V>> f20172j;

        t(ue<K, V> ueVar, Object obj) {
            super(ueVar, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.l
        public ue<K, V> o() {
            return (ue) super.o();
        }

        @Override // com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.hb
        public Set<V> a(Object obj) {
            Set<V> setA;
            synchronized (this.f20167b) {
                setA = u().a(obj);
            }
            return setA;
        }

        @Override // com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.hb
        public Set<V> b(K k7, Iterable<? extends V> iterable) {
            Set<V> setB;
            synchronized (this.f20167b) {
                setB = u().b((Object) k7, (Iterable) iterable);
            }
            return setB;
        }

        @Override // com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.ue
        /* JADX INFO: renamed from: entries */
        public Set<Map.Entry<K, V>> y() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.f20167b) {
                if (this.f20172j == null) {
                    this.f20172j = dj.u(u().y(), this.f20167b);
                }
                set = this.f20172j;
            }
            return set;
        }

        @Override // com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.hb
        public Set<V> get(K k7) {
            Set<V> setU;
            synchronized (this.f20167b) {
                setU = dj.u(u().get((Object) k7), this.f20167b);
            }
            return setU;
        }
    }

    static class u<K, V> extends k<K, V> implements SortedMap<K, V> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final long f20173h = 0;

        u(SortedMap<K, V> sortedMap, Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.f20167b) {
                comparator = o().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K kFirstKey;
            synchronized (this.f20167b) {
                kFirstKey = o().firstKey();
            }
            return kFirstKey;
        }

        public SortedMap<K, V> headMap(K k7) {
            SortedMap<K, V> sortedMapW;
            synchronized (this.f20167b) {
                sortedMapW = dj.w(o().headMap(k7), this.f20167b);
            }
            return sortedMapW;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K kLastKey;
            synchronized (this.f20167b) {
                kLastKey = o().lastKey();
            }
            return kLastKey;
        }

        public SortedMap<K, V> subMap(K k7, K k8) {
            SortedMap<K, V> sortedMapW;
            synchronized (this.f20167b) {
                sortedMapW = dj.w(o().subMap(k7, k8), this.f20167b);
            }
            return sortedMapW;
        }

        public SortedMap<K, V> tailMap(K k7) {
            SortedMap<K, V> sortedMapW;
            synchronized (this.f20167b) {
                sortedMapW = dj.w(o().tailMap(k7), this.f20167b);
            }
            return sortedMapW;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.k
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public SortedMap<K, V> o() {
            return (SortedMap) super.o();
        }
    }

    static class v<E> extends s<E> implements SortedSet<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final long f20174f = 0;

        v(SortedSet<E> sortedSet, Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.f20167b) {
                comparator = o().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E eFirst;
            synchronized (this.f20167b) {
                eFirst = o().first();
            }
            return eFirst;
        }

        public SortedSet<E> headSet(E e8) {
            SortedSet<E> sortedSetX;
            synchronized (this.f20167b) {
                sortedSetX = dj.x(o().headSet(e8), this.f20167b);
            }
            return sortedSetX;
        }

        @Override // java.util.SortedSet
        public E last() {
            E eLast;
            synchronized (this.f20167b) {
                eLast = o().last();
            }
            return eLast;
        }

        public SortedSet<E> subSet(E e8, E e9) {
            SortedSet<E> sortedSetX;
            synchronized (this.f20167b) {
                sortedSetX = dj.x(o().subSet(e8, e9), this.f20167b);
            }
            return sortedSetX;
        }

        public SortedSet<E> tailSet(E e8) {
            SortedSet<E> sortedSetX;
            synchronized (this.f20167b) {
                sortedSetX = dj.x(o().tailSet(e8), this.f20167b);
            }
            return sortedSetX;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.s
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public SortedSet<E> u() {
            return (SortedSet) super.u();
        }
    }

    private static final class x<R, C, V> extends p implements oj<R, C, V> {

        class a implements com.google.common.base.s<Map<C, V>, Map<C, V>> {
            a() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<C, V> apply(Map<C, V> map) {
                return dj.l(map, x.this.f20167b);
            }
        }

        class b implements com.google.common.base.s<Map<R, V>, Map<R, V>> {
            b() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<R, V> apply(Map<R, V> map) {
                return dj.l(map, x.this.f20167b);
            }
        }

        x(oj<R, C, V> ojVar, Object obj) {
            super(ojVar, obj);
        }

        @Override // com.google.common.collect.oj
        public Set<C> L() {
            Set<C> setU;
            synchronized (this.f20167b) {
                setU = dj.u(o().L(), this.f20167b);
            }
            return setU;
        }

        @Override // com.google.common.collect.oj
        public boolean M(Object obj) {
            boolean zM;
            synchronized (this.f20167b) {
                zM = o().M(obj);
            }
            return zM;
        }

        @Override // com.google.common.collect.oj
        public void O(oj<? extends R, ? extends C, ? extends V> ojVar) {
            synchronized (this.f20167b) {
                o().O(ojVar);
            }
        }

        @Override // com.google.common.collect.oj
        public boolean P(Object obj, Object obj2) {
            boolean zP;
            synchronized (this.f20167b) {
                zP = o().P(obj, obj2);
            }
            return zP;
        }

        @Override // com.google.common.collect.oj
        public Map<C, Map<R, V>> S() {
            Map<C, Map<R, V>> mapL;
            synchronized (this.f20167b) {
                mapL = dj.l(wb.N0(o().S(), new b()), this.f20167b);
            }
            return mapL;
        }

        @Override // com.google.common.collect.oj
        public Map<C, V> X(R r7) {
            Map<C, V> mapL;
            synchronized (this.f20167b) {
                mapL = dj.l(o().X(r7), this.f20167b);
            }
            return mapL;
        }

        @Override // com.google.common.collect.oj
        public void clear() {
            synchronized (this.f20167b) {
                o().clear();
            }
        }

        @Override // com.google.common.collect.oj
        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.f20167b) {
                zContainsValue = o().containsValue(obj);
            }
            return zContainsValue;
        }

        @Override // com.google.common.collect.oj
        public boolean equals(Object obj) {
            boolean zEquals;
            if (this == obj) {
                return true;
            }
            synchronized (this.f20167b) {
                zEquals = o().equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.oj
        public Map<R, Map<C, V>> f() {
            Map<R, Map<C, V>> mapL;
            synchronized (this.f20167b) {
                mapL = dj.l(wb.N0(o().f(), new a()), this.f20167b);
            }
            return mapL;
        }

        @Override // com.google.common.collect.oj
        public Set<R> g() {
            Set<R> setU;
            synchronized (this.f20167b) {
                setU = dj.u(o().g(), this.f20167b);
            }
            return setU;
        }

        @Override // com.google.common.collect.oj
        public int hashCode() {
            int iHashCode;
            synchronized (this.f20167b) {
                iHashCode = o().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.oj
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f20167b) {
                zIsEmpty = o().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // com.google.common.collect.oj
        public V k(Object obj, Object obj2) {
            V vK;
            synchronized (this.f20167b) {
                vK = o().k(obj, obj2);
            }
            return vK;
        }

        @Override // com.google.common.collect.oj
        public boolean m(Object obj) {
            boolean zM;
            synchronized (this.f20167b) {
                zM = o().m(obj);
            }
            return zM;
        }

        @Override // com.google.common.collect.oj
        public Map<R, V> n(C c8) {
            Map<R, V> mapL;
            synchronized (this.f20167b) {
                mapL = dj.l(o().n(c8), this.f20167b);
            }
            return mapL;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.p
        public oj<R, C, V> o() {
            return (oj) super.o();
        }

        @Override // com.google.common.collect.oj
        public Set<oj.a<R, C, V>> r() {
            Set<oj.a<R, C, V>> setU;
            synchronized (this.f20167b) {
                setU = dj.u(o().r(), this.f20167b);
            }
            return setU;
        }

        @Override // com.google.common.collect.oj
        public V remove(Object obj, Object obj2) {
            V vRemove;
            synchronized (this.f20167b) {
                vRemove = o().remove(obj, obj2);
            }
            return vRemove;
        }

        @Override // com.google.common.collect.oj
        public int size() {
            int size;
            synchronized (this.f20167b) {
                size = o().size();
            }
            return size;
        }

        @Override // com.google.common.collect.oj
        public V t(R r7, C c8, V v7) {
            V vT;
            synchronized (this.f20167b) {
                vT = o().t(r7, c8, v7);
            }
            return vT;
        }

        @Override // com.google.common.collect.oj
        public Collection<V> values() {
            Collection<V> collectionH;
            synchronized (this.f20167b) {
                collectionH = dj.h(o().values(), this.f20167b);
            }
            return collectionH;
        }
    }

    private dj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Collection<E> A(Collection<E> collection, Object obj) {
        if (collection instanceof SortedSet) {
            return x((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return u((Set) collection, obj);
        }
        return collection instanceof List ? j((List) collection, obj) : h(collection, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Set<E> B(Set<E> set, Object obj) {
        return set instanceof SortedSet ? x((SortedSet) set, obj) : u(set, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> r0<K, V> g(r0<K, V> r0Var, Object obj) {
        return ((r0Var instanceof e) || (r0Var instanceof u6)) ? r0Var : new e(r0Var, obj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Collection<E> h(Collection<E> collection, Object obj) {
        return new f(collection, obj);
    }

    static <E> Deque<E> i(Deque<E> deque, Object obj) {
        return new g(deque, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> List<E> j(List<E> list, Object obj) {
        return list instanceof RandomAccess ? new r(list, obj) : new i(list, obj);
    }

    static <K, V> hb<K, V> k(hb<K, V> hbVar, Object obj) {
        return ((hbVar instanceof j) || (hbVar instanceof p0)) ? hbVar : new j(hbVar, obj);
    }

    @s1.d
    static <K, V> Map<K, V> l(Map<K, V> map, Object obj) {
        return new k(map, obj);
    }

    static <K, V> tc<K, V> m(tc<K, V> tcVar, Object obj) {
        return ((tcVar instanceof l) || (tcVar instanceof p0)) ? tcVar : new l(tcVar, obj);
    }

    static <E> hd<E> n(hd<E> hdVar, Object obj) {
        return ((hdVar instanceof m) || (hdVar instanceof p8)) ? hdVar : new m(hdVar, obj);
    }

    @s1.c
    static <K, V> NavigableMap<K, V> o(NavigableMap<K, V> navigableMap) {
        return p(navigableMap, null);
    }

    @s1.c
    static <K, V> NavigableMap<K, V> p(NavigableMap<K, V> navigableMap, Object obj) {
        return new n(navigableMap, obj);
    }

    @s1.c
    static <E> NavigableSet<E> q(NavigableSet<E> navigableSet) {
        return r(navigableSet, null);
    }

    @s1.c
    static <E> NavigableSet<E> r(NavigableSet<E> navigableSet, Object obj) {
        return new o(navigableSet, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @s1.c
    public static <K, V> Map.Entry<K, V> s(Map.Entry<K, V> entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new h(entry, obj);
    }

    static <E> Queue<E> t(Queue<E> queue, Object obj) {
        return queue instanceof q ? queue : new q(queue, obj);
    }

    @s1.d
    static <E> Set<E> u(Set<E> set, Object obj) {
        return new s(set, obj);
    }

    static <K, V> ue<K, V> v(ue<K, V> ueVar, Object obj) {
        return ((ueVar instanceof t) || (ueVar instanceof p0)) ? ueVar : new t(ueVar, obj);
    }

    static <K, V> SortedMap<K, V> w(SortedMap<K, V> sortedMap, Object obj) {
        return new u(sortedMap, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> SortedSet<E> x(SortedSet<E> sortedSet, Object obj) {
        return new v(sortedSet, obj);
    }

    static <K, V> bg<K, V> y(bg<K, V> bgVar, Object obj) {
        return bgVar instanceof w ? bgVar : new w(bgVar, obj);
    }

    static <R, C, V> oj<R, C, V> z(oj<R, C, V> ojVar, Object obj) {
        return new x(ojVar, obj);
    }

    private static class w<K, V> extends t<K, V> implements bg<K, V> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final long f20175l = 0;

        w(bg<K, V> bgVar, Object obj) {
            super(bgVar, obj);
        }

        @Override // com.google.common.collect.bg
        public Comparator<? super V> valueComparator() {
            Comparator<? super V> comparatorValueComparator;
            synchronized (this.f20167b) {
                comparatorValueComparator = u().valueComparator();
            }
            return comparatorValueComparator;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.t
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public bg<K, V> u() {
            return (bg) super.u();
        }

        @Override // com.google.common.collect.dj.t, com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.hb
        public SortedSet<V> a(Object obj) {
            SortedSet<V> sortedSetA;
            synchronized (this.f20167b) {
                sortedSetA = u().a(obj);
            }
            return sortedSetA;
        }

        @Override // com.google.common.collect.dj.t, com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.hb
        public SortedSet<V> b(K k7, Iterable<? extends V> iterable) {
            SortedSet<V> sortedSetB;
            synchronized (this.f20167b) {
                sortedSetB = u().b((Object) k7, (Iterable) iterable);
            }
            return sortedSetB;
        }

        @Override // com.google.common.collect.dj.t, com.google.common.collect.dj.l, com.google.common.collect.tc, com.google.common.collect.hb
        public SortedSet<V> get(K k7) {
            SortedSet<V> sortedSetX;
            synchronized (this.f20167b) {
                sortedSetX = dj.x(u().get((Object) k7), this.f20167b);
            }
            return sortedSetX;
        }
    }

    private static class c<K, V> extends s<Map.Entry<K, Collection<V>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final long f20132f = 0;

        class a extends uj<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: com.google.common.collect.dj$c$a$a, reason: collision with other inner class name */
            class C0242a extends v5<K, Collection<V>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Map.Entry f20134a;

                C0242a(Map.Entry entry) {
                    this.f20134a = entry;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.v5, com.google.common.collect.b6
                /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, Collection<V>> c0() {
                    return this.f20134a;
                }

                @Override // com.google.common.collect.v5, java.util.Map.Entry
                /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
                public Collection<V> getValue() {
                    return dj.A((Collection) this.f20134a.getValue(), c.this.f20167b);
                }
            }

            a(Iterator it) {
                super(it);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.uj
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
                return new C0242a(entry);
            }
        }

        c(Set<Map.Entry<K, Collection<V>>> set, Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.dj.f, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean zU;
            synchronized (this.f20167b) {
                zU = wb.u(u(), obj);
            }
            return zU;
        }

        @Override // com.google.common.collect.dj.f, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean zC;
            synchronized (this.f20167b) {
                zC = h3.c(u(), collection);
            }
            return zC;
        }

        @Override // com.google.common.collect.dj.s, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean zG;
            if (obj == this) {
                return true;
            }
            synchronized (this.f20167b) {
                zG = af.g(u(), obj);
            }
            return zG;
        }

        @Override // com.google.common.collect.dj.f, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new a(super.iterator());
        }

        @Override // com.google.common.collect.dj.f, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean zU0;
            synchronized (this.f20167b) {
                zU0 = wb.u0(u(), obj);
            }
            return zU0;
        }

        @Override // com.google.common.collect.dj.f, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean zV;
            synchronized (this.f20167b) {
                zV = ua.V(u().iterator(), collection);
            }
            return zV;
        }

        @Override // com.google.common.collect.dj.f, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean zX;
            synchronized (this.f20167b) {
                zX = ua.X(u().iterator(), collection);
            }
            return zX;
        }

        @Override // com.google.common.collect.dj.f, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] objArrL;
            synchronized (this.f20167b) {
                objArrL = sd.l(u());
            }
            return objArrL;
        }

        @Override // com.google.common.collect.dj.f, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.f20167b) {
                tArr2 = (T[]) sd.m(u(), tArr);
            }
            return tArr2;
        }
    }

    private static class k<K, V> extends p implements Map<K, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final long f20146g = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Set<K> f20147d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        transient Collection<V> f20148e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        transient Set<Map.Entry<K, V>> f20149f;

        k(Map<K, V> map, Object obj) {
            super(map, obj);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.f20167b) {
                o().clear();
            }
        }

        @Override // java.util.Map
        public V compute(K k7, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            V v7;
            synchronized (this.f20167b) {
                v7 = (V) o().compute(k7, biFunction);
            }
            return v7;
        }

        @Override // java.util.Map
        public V computeIfAbsent(K k7, Function<? super K, ? extends V> function) {
            V v7;
            synchronized (this.f20167b) {
                v7 = (V) o().computeIfAbsent(k7, function);
            }
            return v7;
        }

        @Override // java.util.Map
        public V computeIfPresent(K k7, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            V v7;
            synchronized (this.f20167b) {
                v7 = (V) o().computeIfPresent(k7, biFunction);
            }
            return v7;
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.f20167b) {
                zContainsKey = o().containsKey(obj);
            }
            return zContainsKey;
        }

        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.f20167b) {
                zContainsValue = o().containsValue(obj);
            }
            return zContainsValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.f20167b) {
                if (this.f20149f == null) {
                    this.f20149f = dj.u(o().entrySet(), this.f20167b);
                }
                set = this.f20149f;
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f20167b) {
                zEquals = o().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            synchronized (this.f20167b) {
                o().forEach(biConsumer);
            }
        }

        public V get(Object obj) {
            V v7;
            synchronized (this.f20167b) {
                v7 = o().get(obj);
            }
            return v7;
        }

        @Override // java.util.Map
        public V getOrDefault(Object obj, V v7) {
            V v8;
            synchronized (this.f20167b) {
                v8 = (V) o().getOrDefault(obj, v7);
            }
            return v8;
        }

        @Override // java.util.Map
        public int hashCode() {
            int iHashCode;
            synchronized (this.f20167b) {
                iHashCode = o().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f20167b) {
                zIsEmpty = o().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.f20167b) {
                if (this.f20147d == null) {
                    this.f20147d = dj.u(o().keySet(), this.f20167b);
                }
                set = this.f20147d;
            }
            return set;
        }

        @Override // java.util.Map
        public V merge(K k7, V v7, BiFunction<? super V, ? super V, ? extends V> biFunction) {
            V v8;
            synchronized (this.f20167b) {
                v8 = (V) o().merge(k7, v7, biFunction);
            }
            return v8;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.p
        public Map<K, V> o() {
            return (Map) super.o();
        }

        @Override // java.util.Map
        public V put(K k7, V v7) {
            V vPut;
            synchronized (this.f20167b) {
                vPut = o().put(k7, v7);
            }
            return vPut;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.f20167b) {
                o().putAll(map);
            }
        }

        @Override // java.util.Map
        public V putIfAbsent(K k7, V v7) {
            V v8;
            synchronized (this.f20167b) {
                v8 = (V) o().putIfAbsent(k7, v7);
            }
            return v8;
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            V vRemove;
            synchronized (this.f20167b) {
                vRemove = o().remove(obj);
            }
            return vRemove;
        }

        @Override // java.util.Map
        public boolean replace(K k7, V v7, V v8) {
            boolean zReplace;
            synchronized (this.f20167b) {
                zReplace = o().replace(k7, v7, v8);
            }
            return zReplace;
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
            synchronized (this.f20167b) {
                o().replaceAll(biFunction);
            }
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.f20167b) {
                size = o().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.f20167b) {
                if (this.f20148e == null) {
                    this.f20148e = dj.h(o().values(), this.f20167b);
                }
                collection = this.f20148e;
            }
            return collection;
        }

        @Override // java.util.Map
        public boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (this.f20167b) {
                zRemove = o().remove(obj, obj2);
            }
            return zRemove;
        }

        @Override // java.util.Map
        public V replace(K k7, V v7) {
            V v8;
            synchronized (this.f20167b) {
                v8 = (V) o().replace(k7, v7);
            }
            return v8;
        }
    }

    @s1.c
    @s1.d
    static class n<K, V> extends u<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final long f20159l = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        transient NavigableSet<K> f20160i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        transient NavigableMap<K, V> f20161j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        transient NavigableSet<K> f20162k;

        n(NavigableMap<K, V> navigableMap, Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k7) {
            Map.Entry<K, V> entryS;
            synchronized (this.f20167b) {
                entryS = dj.s(u().ceilingEntry(k7), this.f20167b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k7) {
            K kCeilingKey;
            synchronized (this.f20167b) {
                kCeilingKey = u().ceilingKey(k7);
            }
            return kCeilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.f20167b) {
                NavigableSet<K> navigableSet = this.f20160i;
                if (navigableSet != null) {
                    return navigableSet;
                }
                NavigableSet<K> navigableSetR = dj.r(u().descendingKeySet(), this.f20167b);
                this.f20160i = navigableSetR;
                return navigableSetR;
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.f20167b) {
                NavigableMap<K, V> navigableMap = this.f20161j;
                if (navigableMap != null) {
                    return navigableMap;
                }
                NavigableMap<K, V> navigableMapP = dj.p(u().descendingMap(), this.f20167b);
                this.f20161j = navigableMapP;
                return navigableMapP;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> entryS;
            synchronized (this.f20167b) {
                entryS = dj.s(u().firstEntry(), this.f20167b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k7) {
            Map.Entry<K, V> entryS;
            synchronized (this.f20167b) {
                entryS = dj.s(u().floorEntry(k7), this.f20167b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k7) {
            K kFloorKey;
            synchronized (this.f20167b) {
                kFloorKey = u().floorKey(k7);
            }
            return kFloorKey;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k7, boolean z7) {
            NavigableMap<K, V> navigableMapP;
            synchronized (this.f20167b) {
                navigableMapP = dj.p(u().headMap(k7, z7), this.f20167b);
            }
            return navigableMapP;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k7) {
            Map.Entry<K, V> entryS;
            synchronized (this.f20167b) {
                entryS = dj.s(u().higherEntry(k7), this.f20167b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k7) {
            K kHigherKey;
            synchronized (this.f20167b) {
                kHigherKey = u().higherKey(k7);
            }
            return kHigherKey;
        }

        @Override // com.google.common.collect.dj.k, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> entryS;
            synchronized (this.f20167b) {
                entryS = dj.s(u().lastEntry(), this.f20167b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k7) {
            Map.Entry<K, V> entryS;
            synchronized (this.f20167b) {
                entryS = dj.s(u().lowerEntry(k7), this.f20167b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k7) {
            K kLowerKey;
            synchronized (this.f20167b) {
                kLowerKey = u().lowerKey(k7);
            }
            return kLowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.f20167b) {
                NavigableSet<K> navigableSet = this.f20162k;
                if (navigableSet != null) {
                    return navigableSet;
                }
                NavigableSet<K> navigableSetR = dj.r(u().navigableKeySet(), this.f20167b);
                this.f20162k = navigableSetR;
                return navigableSetR;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> entryS;
            synchronized (this.f20167b) {
                entryS = dj.s(u().pollFirstEntry(), this.f20167b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> entryS;
            synchronized (this.f20167b) {
                entryS = dj.s(u().pollLastEntry(), this.f20167b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k7, boolean z7, K k8, boolean z8) {
            NavigableMap<K, V> navigableMapP;
            synchronized (this.f20167b) {
                navigableMapP = dj.p(u().subMap(k7, z7, k8, z8), this.f20167b);
            }
            return navigableMapP;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k7, boolean z7) {
            NavigableMap<K, V> navigableMapP;
            synchronized (this.f20167b) {
                navigableMapP = dj.p(u().tailMap(k7, z7), this.f20167b);
            }
            return navigableMapP;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.u
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> o() {
            return (NavigableMap) super.o();
        }

        @Override // com.google.common.collect.dj.u, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k7) {
            return headMap(k7, false);
        }

        @Override // com.google.common.collect.dj.u, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k7, K k8) {
            return subMap(k7, true, k8, false);
        }

        @Override // com.google.common.collect.dj.u, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k7) {
            return tailMap(k7, true);
        }
    }

    @s1.c
    @s1.d
    static class o<E> extends v<E> implements NavigableSet<E> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final long f20163h = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient NavigableSet<E> f20164g;

        o(NavigableSet<E> navigableSet, Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e8) {
            E eCeiling;
            synchronized (this.f20167b) {
                eCeiling = o().ceiling(e8);
            }
            return eCeiling;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return o().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.f20167b) {
                NavigableSet<E> navigableSet = this.f20164g;
                if (navigableSet != null) {
                    return navigableSet;
                }
                NavigableSet<E> navigableSetR = dj.r(o().descendingSet(), this.f20167b);
                this.f20164g = navigableSetR;
                return navigableSetR;
            }
        }

        @Override // java.util.NavigableSet
        public E floor(E e8) {
            E eFloor;
            synchronized (this.f20167b) {
                eFloor = o().floor(e8);
            }
            return eFloor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e8, boolean z7) {
            NavigableSet<E> navigableSetR;
            synchronized (this.f20167b) {
                navigableSetR = dj.r(o().headSet(e8, z7), this.f20167b);
            }
            return navigableSetR;
        }

        @Override // java.util.NavigableSet
        public E higher(E e8) {
            E eHigher;
            synchronized (this.f20167b) {
                eHigher = o().higher(e8);
            }
            return eHigher;
        }

        @Override // java.util.NavigableSet
        public E lower(E e8) {
            E eLower;
            synchronized (this.f20167b) {
                eLower = o().lower(e8);
            }
            return eLower;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            E ePollFirst;
            synchronized (this.f20167b) {
                ePollFirst = o().pollFirst();
            }
            return ePollFirst;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            E ePollLast;
            synchronized (this.f20167b) {
                ePollLast = o().pollLast();
            }
            return ePollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e8, boolean z7, E e9, boolean z8) {
            NavigableSet<E> navigableSetR;
            synchronized (this.f20167b) {
                navigableSetR = dj.r(o().subSet(e8, z7, e9, z8), this.f20167b);
            }
            return navigableSetR;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e8, boolean z7) {
            NavigableSet<E> navigableSetR;
            synchronized (this.f20167b) {
                navigableSetR = dj.r(o().tailSet(e8, z7), this.f20167b);
            }
            return navigableSetR;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.dj.v
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<E> o() {
            return (NavigableSet) super.o();
        }

        @Override // com.google.common.collect.dj.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e8) {
            return headSet(e8, false);
        }

        @Override // com.google.common.collect.dj.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e8) {
            return tailSet(e8, true);
        }

        @Override // com.google.common.collect.dj.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e8, E e9) {
            return subSet(e8, true, e9, false);
        }
    }
}
