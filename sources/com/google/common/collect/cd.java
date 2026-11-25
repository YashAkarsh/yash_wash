package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class cd {

    static final class a<K, V> extends wb.s0<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @y1.i
        private final tc<K, V> f20052d;

        /* JADX INFO: renamed from: com.google.common.collect.cd$a$a, reason: collision with other inner class name */
        class C0238a extends wb.t<K, Collection<V>> {

            /* JADX INFO: renamed from: com.google.common.collect.cd$a$a$a, reason: collision with other inner class name */
            class C0239a implements com.google.common.base.s<K, Collection<V>> {
                C0239a() {
                }

                @Override // com.google.common.base.s, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Collection<V> apply(K k7) {
                    return a.this.f20052d.get(k7);
                }
            }

            C0238a() {
            }

            @Override // com.google.common.collect.wb.t
            Map<K, Collection<V>> g() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return wb.r(a.this.f20052d.keySet(), new C0239a());
            }

            @Override // com.google.common.collect.wb.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                a.this.g(((Map.Entry) obj).getKey());
                return true;
            }
        }

        a(tc<K, V> tcVar) {
            this.f20052d = (tc) com.google.common.base.e0.E(tcVar);
        }

        @Override // com.google.common.collect.wb.s0
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new C0238a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f20052d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f20052d.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.f20052d.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.f20052d.a(obj);
            }
            return null;
        }

        void g(Object obj) {
            this.f20052d.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f20052d.isEmpty();
        }

        @Override // com.google.common.collect.wb.s0, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f20052d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f20052d.keySet().size();
        }
    }

    private static class b<K, V> extends com.google.common.collect.f<K, V> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @s1.c
        private static final long f20055k = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        transient com.google.common.base.p0<? extends List<V>> f20056j;

        b(Map<K, Collection<V>> map, com.google.common.base.p0<? extends List<V>> p0Var) {
            super(map);
            this.f20056j = (com.google.common.base.p0) com.google.common.base.e0.E(p0Var);
        }

        @s1.c
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f20056j = (com.google.common.base.p0) objectInputStream.readObject();
            O((Map) objectInputStream.readObject());
        }

        @s1.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f20056j);
            objectOutputStream.writeObject(y());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.f, com.google.common.collect.q
        /* JADX INFO: renamed from: T */
        public List<V> z() {
            return this.f20056j.get();
        }

        @Override // com.google.common.collect.q, com.google.common.collect.x
        Map<K, Collection<V>> c() {
            return B();
        }

        @Override // com.google.common.collect.q, com.google.common.collect.x
        Set<K> f() {
            return C();
        }
    }

    private static class c<K, V> extends q<K, V> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @s1.c
        private static final long f20057j = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        transient com.google.common.base.p0<? extends Collection<V>> f20058i;

        c(Map<K, Collection<V>> map, com.google.common.base.p0<? extends Collection<V>> p0Var) {
            super(map);
            this.f20058i = (com.google.common.base.p0) com.google.common.base.e0.E(p0Var);
        }

        @s1.c
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f20058i = (com.google.common.base.p0) objectInputStream.readObject();
            O((Map) objectInputStream.readObject());
        }

        @s1.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f20058i);
            objectOutputStream.writeObject(y());
        }

        @Override // com.google.common.collect.q
        <E> Collection<E> P(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return af.P((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
        }

        @Override // com.google.common.collect.q
        Collection<V> R(K k7, Collection<V> collection) {
            if (collection instanceof List) {
                return S(k7, (List) collection, null);
            }
            if (collection instanceof NavigableSet) {
                return new q.m(k7, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new q.o(k7, (SortedSet) collection, null);
            }
            return collection instanceof Set ? new q.n(k7, (Set) collection) : new q.k(k7, collection, null);
        }

        @Override // com.google.common.collect.q, com.google.common.collect.x
        Map<K, Collection<V>> c() {
            return B();
        }

        @Override // com.google.common.collect.q, com.google.common.collect.x
        Set<K> f() {
            return C();
        }

        @Override // com.google.common.collect.q
        protected Collection<V> z() {
            return this.f20058i.get();
        }
    }

    private static class d<K, V> extends c0<K, V> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @s1.c
        private static final long f20059k = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        transient com.google.common.base.p0<? extends Set<V>> f20060j;

        d(Map<K, Collection<V>> map, com.google.common.base.p0<? extends Set<V>> p0Var) {
            super(map);
            this.f20060j = (com.google.common.base.p0) com.google.common.base.e0.E(p0Var);
        }

        @s1.c
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f20060j = (com.google.common.base.p0) objectInputStream.readObject();
            O((Map) objectInputStream.readObject());
        }

        @s1.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f20060j);
            objectOutputStream.writeObject(y());
        }

        @Override // com.google.common.collect.c0, com.google.common.collect.q
        <E> Collection<E> P(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return af.P((NavigableSet) collection);
            }
            return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.c0, com.google.common.collect.q
        Collection<V> R(K k7, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new q.m(k7, (NavigableSet) collection, null);
            }
            return collection instanceof SortedSet ? new q.o(k7, (SortedSet) collection, null) : new q.n(k7, (Set) collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.c0, com.google.common.collect.q
        /* JADX INFO: renamed from: T */
        public Set<V> z() {
            return this.f20060j.get();
        }

        @Override // com.google.common.collect.q, com.google.common.collect.x
        Map<K, Collection<V>> c() {
            return B();
        }

        @Override // com.google.common.collect.q, com.google.common.collect.x
        Set<K> f() {
            return C();
        }
    }

    private static class e<K, V> extends f0<K, V> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @s1.c
        private static final long f20061m = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        transient com.google.common.base.p0<? extends SortedSet<V>> f20062k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        transient Comparator<? super V> f20063l;

        e(Map<K, Collection<V>> map, com.google.common.base.p0<? extends SortedSet<V>> p0Var) {
            super(map);
            this.f20062k = (com.google.common.base.p0) com.google.common.base.e0.E(p0Var);
            this.f20063l = p0Var.get().comparator();
        }

        @s1.c
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            com.google.common.base.p0<? extends SortedSet<V>> p0Var = (com.google.common.base.p0) objectInputStream.readObject();
            this.f20062k = p0Var;
            this.f20063l = p0Var.get().comparator();
            O((Map) objectInputStream.readObject());
        }

        @s1.c
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f20062k);
            objectOutputStream.writeObject(y());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.f0, com.google.common.collect.c0, com.google.common.collect.q
        /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
        public SortedSet<V> z() {
            return this.f20062k.get();
        }

        @Override // com.google.common.collect.q, com.google.common.collect.x
        Map<K, Collection<V>> c() {
            return B();
        }

        @Override // com.google.common.collect.q, com.google.common.collect.x
        Set<K> f() {
            return C();
        }

        @Override // com.google.common.collect.bg
        public Comparator<? super V> valueComparator() {
            return this.f20063l;
        }
    }

    static abstract class f<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        f() {
        }

        abstract tc<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().W(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    static class g<K, V> extends y<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @y1.i
        final tc<K, V> f20064c;

        class a extends uj<Map.Entry<K, Collection<V>>, hd.a<K>> {

            /* JADX INFO: renamed from: com.google.common.collect.cd$g$a$a, reason: collision with other inner class name */
            class C0240a extends md.f<K> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Map.Entry f20066a;

                C0240a(Map.Entry entry) {
                    this.f20066a = entry;
                }

                @Override // com.google.common.collect.hd.a
                public int getCount() {
                    return ((Collection) this.f20066a.getValue()).size();
                }

                @Override // com.google.common.collect.hd.a
                public K getElement() {
                    return (K) this.f20066a.getKey();
                }
            }

            a(Iterator it) {
                super(it);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.uj
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public hd.a<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0240a(entry);
            }
        }

        g(tc<K, V> tcVar) {
            this.f20064c = tcVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void j(Consumer consumer, Map.Entry entry) {
            consumer.accept(entry.getKey());
        }

        @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f20064c.clear();
        }

        @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
        public boolean contains(Object obj) {
            return this.f20064c.containsKey(obj);
        }

        @Override // com.google.common.collect.y
        int d() {
            return this.f20064c.asMap().size();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.hd
        public Set<K> e() {
            return this.f20064c.keySet();
        }

        @Override // com.google.common.collect.y
        Iterator<K> f() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.y, java.lang.Iterable, com.google.common.collect.hd
        public void forEach(final Consumer<? super K> consumer) {
            com.google.common.base.e0.E(consumer);
            this.f20064c.y().forEach(new Consumer() { // from class: com.google.common.collect.dd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    cd.g.j(consumer, (Map.Entry) obj);
                }
            });
        }

        @Override // com.google.common.collect.y
        Iterator<hd.a<K>> g() {
            return new a(this.f20064c.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
        public Iterator<K> iterator() {
            return wb.X(this.f20064c.y().iterator());
        }

        @Override // com.google.common.collect.hd
        public int l0(Object obj) {
            Collection collection = (Collection) wb.z0(this.f20064c.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.y, com.google.common.collect.hd
        public int remove(Object obj, int i7) {
            f2.b(i7, "occurrences");
            if (i7 == 0) {
                return l0(obj);
            }
            Collection collection = (Collection) wb.z0(this.f20064c.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i7 >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i8 = 0; i8 < i7; i8++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
        public int size() {
            return this.f20064c.size();
        }

        @Override // com.google.common.collect.y, java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
        public Spliterator<K> spliterator() {
            return q2.e(this.f20064c.y().spliterator(), new u7());
        }
    }

    private static class h<K, V> extends x<K, V> implements ue<K, V>, Serializable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final long f20068g = 7845222491160860175L;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Map<K, V> f20069f;

        class a extends af.l<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Object f20070a;

            /* JADX INFO: renamed from: com.google.common.collect.cd$h$a$a, reason: collision with other inner class name */
            class C0241a implements Iterator<V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f20072a;

                C0241a() {
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.f20072a == 0) {
                        a aVar = a.this;
                        if (h.this.f20069f.containsKey(aVar.f20070a)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.f20072a++;
                    a aVar = a.this;
                    return h.this.f20069f.get(aVar.f20070a);
                }

                @Override // java.util.Iterator
                public void remove() {
                    f2.e(this.f20072a == 1);
                    this.f20072a = -1;
                    a aVar = a.this;
                    h.this.f20069f.remove(aVar.f20070a);
                }
            }

            a(Object obj) {
                this.f20070a = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new C0241a();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return h.this.f20069f.containsKey(this.f20070a) ? 1 : 0;
            }
        }

        h(Map<K, V> map) {
            this.f20069f = (Map) com.google.common.base.e0.E(map);
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean H(tc<? extends K, ? extends V> tcVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean W(Object obj, Object obj2) {
            return this.f20069f.entrySet().contains(wb.T(obj, obj2));
        }

        @Override // com.google.common.collect.x
        Map<K, Collection<V>> c() {
            return new a(this);
        }

        @Override // com.google.common.collect.tc
        public void clear() {
            this.f20069f.clear();
        }

        @Override // com.google.common.collect.tc
        public boolean containsKey(Object obj) {
            return this.f20069f.containsKey(obj);
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean containsValue(Object obj) {
            return this.f20069f.containsValue(obj);
        }

        @Override // com.google.common.collect.x
        Collection<Map.Entry<K, V>> e() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.x
        Set<K> f() {
            return this.f20069f.keySet();
        }

        @Override // com.google.common.collect.x
        hd<K> g() {
            return new g(this);
        }

        @Override // com.google.common.collect.x
        Collection<V> h() {
            return this.f20069f.values();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public int hashCode() {
            return this.f20069f.hashCode();
        }

        @Override // com.google.common.collect.x
        Iterator<Map.Entry<K, V>> i() {
            return this.f20069f.entrySet().iterator();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean put(K k7, V v7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean putAll(K k7, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean remove(Object obj, Object obj2) {
            return this.f20069f.entrySet().remove(wb.T(obj, obj2));
        }

        @Override // com.google.common.collect.tc
        public int size() {
            return this.f20069f.size();
        }

        @Override // com.google.common.collect.tc, com.google.common.collect.hb
        public Set<V> a(Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.f20069f.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.f20069f.remove(obj));
            return hashSet;
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
        public Set<V> b(K k7, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
        /* JADX INFO: renamed from: entries */
        public Set<Map.Entry<K, V>> y() {
            return this.f20069f.entrySet();
        }

        @Override // com.google.common.collect.tc, com.google.common.collect.hb
        public Set<V> get(K k7) {
            return new a(k7);
        }
    }

    private static final class i<K, V1, V2> extends j<K, V1, V2> implements hb<K, V2> {
        i(hb<K, V1> hbVar, wb.u<? super K, ? super V1, V2> uVar) {
            super(hbVar, uVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.cd.j
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public List<V2> m(K k7, Collection<V1> collection) {
            return ib.D((List) collection, wb.s(this.f20075g, k7));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.cd.j, com.google.common.collect.tc, com.google.common.collect.hb
        public List<V2> a(Object obj) {
            return m(obj, this.f20074f.a(obj));
        }

        @Override // com.google.common.collect.cd.j, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
        public List<V2> b(K k7, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.cd.j, com.google.common.collect.tc, com.google.common.collect.hb
        public List<V2> get(K k7) {
            return m(k7, this.f20074f.get(k7));
        }
    }

    private static class j<K, V1, V2> extends x<K, V2> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final tc<K, V1> f20074f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final wb.u<? super K, ? super V1, V2> f20075g;

        class a implements wb.u<K, Collection<V1>, Collection<V2>> {
            a() {
            }

            @Override // com.google.common.collect.wb.u
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Collection<V2> a(K k7, Collection<V1> collection) {
                return j.this.m(k7, collection);
            }
        }

        j(tc<K, V1> tcVar, wb.u<? super K, ? super V1, V2> uVar) {
            this.f20074f = (tc) com.google.common.base.e0.E(tcVar);
            this.f20075g = (wb.u) com.google.common.base.e0.E(uVar);
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean H(tc<? extends K, ? extends V2> tcVar) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.tc, com.google.common.collect.hb
        public Collection<V2> a(Object obj) {
            return m(obj, this.f20074f.a(obj));
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
        public Collection<V2> b(K k7, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x
        Map<K, Collection<V2>> c() {
            return wb.J0(this.f20074f.asMap(), new a());
        }

        @Override // com.google.common.collect.tc
        public void clear() {
            this.f20074f.clear();
        }

        @Override // com.google.common.collect.tc
        public boolean containsKey(Object obj) {
            return this.f20074f.containsKey(obj);
        }

        @Override // com.google.common.collect.x
        Collection<Map.Entry<K, V2>> e() {
            return new x.a();
        }

        @Override // com.google.common.collect.x
        Set<K> f() {
            return this.f20074f.keySet();
        }

        @Override // com.google.common.collect.x
        hd<K> g() {
            return this.f20074f.keys();
        }

        @Override // com.google.common.collect.tc, com.google.common.collect.hb
        public Collection<V2> get(K k7) {
            return m(k7, this.f20074f.get(k7));
        }

        @Override // com.google.common.collect.x
        Collection<V2> h() {
            return h3.m(this.f20074f.y(), wb.m(this.f20075g));
        }

        @Override // com.google.common.collect.x
        Iterator<Map.Entry<K, V2>> i() {
            return ua.c0(this.f20074f.y().iterator(), wb.l(this.f20075g));
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean isEmpty() {
            return this.f20074f.isEmpty();
        }

        Collection<V2> m(K k7, Collection<V1> collection) {
            com.google.common.base.s sVarS = wb.s(this.f20075g, k7);
            return collection instanceof List ? ib.D((List) collection, sVarS) : h3.m(collection, sVarS);
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean put(K k7, V2 v7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean putAll(K k7, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.x, com.google.common.collect.tc
        public boolean remove(Object obj, Object obj2) {
            return get(obj).remove(obj2);
        }

        @Override // com.google.common.collect.tc
        public int size() {
            return this.f20074f.size();
        }
    }

    private static class k<K, V> extends l<K, V> implements hb<K, V> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final long f20077h = 0;

        k(hb<K, V> hbVar) {
            super(hbVar);
        }

        @Override // com.google.common.collect.cd.l, com.google.common.collect.w5
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public hb<K, V> d0() {
            return (hb) super.d0();
        }

        @Override // com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public List<V> a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public List<V> b(K k7, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public List<V> get(K k7) {
            return Collections.unmodifiableList(c0().get((Object) k7));
        }
    }

    private static class l<K, V> extends w5<K, V> implements Serializable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final long f20078g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final tc<K, V> f20079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        transient Collection<Map.Entry<K, V>> f20080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient hd<K> f20081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Set<K> f20082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        transient Collection<V> f20083e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        transient Map<K, Collection<V>> f20084f;

        class a implements com.google.common.base.s<Collection<V>, Collection<V>> {
            a() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<V> apply(Collection<V> collection) {
                return cd.Y(collection);
            }
        }

        l(tc<K, V> tcVar) {
            this.f20079a = (tc) com.google.common.base.e0.E(tcVar);
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc
        public boolean H(tc<? extends K, ? extends V> tcVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public Collection<V> a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map = this.f20084f;
            if (map != null) {
                return map;
            }
            Map<K, Collection<V>> mapUnmodifiableMap = Collections.unmodifiableMap(wb.N0(this.f20079a.asMap(), new a()));
            this.f20084f = mapUnmodifiableMap;
            return mapUnmodifiableMap;
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public Collection<V> b(K k7, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc
        public void clear() {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.w5, com.google.common.collect.b6
        public tc<K, V> c0() {
            return this.f20079a;
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.ue
        /* JADX INFO: renamed from: entries */
        public Collection<Map.Entry<K, V>> y() {
            Collection<Map.Entry<K, V>> collection = this.f20080b;
            if (collection != null) {
                return collection;
            }
            Collection<Map.Entry<K, V>> collectionQ = cd.Q(this.f20079a.y());
            this.f20080b = collectionQ;
            return collectionQ;
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public Collection<V> get(K k7) {
            return cd.Y(this.f20079a.get(k7));
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc
        public Set<K> keySet() {
            Set<K> set = this.f20082d;
            if (set != null) {
                return set;
            }
            Set<K> setUnmodifiableSet = Collections.unmodifiableSet(this.f20079a.keySet());
            this.f20082d = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc
        public hd<K> keys() {
            hd<K> hdVar = this.f20081c;
            if (hdVar != null) {
                return hdVar;
            }
            hd<K> hdVarH = md.H(this.f20079a.keys());
            this.f20081c = hdVarH;
            return hdVarH;
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc
        public boolean put(K k7, V v7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc
        public boolean putAll(K k7, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.w5, com.google.common.collect.tc
        public Collection<V> values() {
            Collection<V> collection = this.f20083e;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.f20079a.values());
            this.f20083e = collectionUnmodifiableCollection;
            return collectionUnmodifiableCollection;
        }
    }

    private static class m<K, V> extends l<K, V> implements ue<K, V> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final long f20086h = 0;

        m(ue<K, V> ueVar) {
            super(ueVar);
        }

        @Override // com.google.common.collect.cd.l, com.google.common.collect.w5
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public ue<K, V> d0() {
            return (ue) super.d0();
        }

        @Override // com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public Set<V> a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public Set<V> b(K k7, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.ue
        /* JADX INFO: renamed from: entries */
        public Set<Map.Entry<K, V>> y() {
            return wb.V0(d0().y());
        }

        @Override // com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public Set<V> get(K k7) {
            return Collections.unmodifiableSet(d0().get((Object) k7));
        }
    }

    private cd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ tc A(tc tcVar, tc tcVar2) {
        tcVar.H(tcVar2);
        return tcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(Function function, Function function2, tc tcVar, Object obj) {
        tcVar.put(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ tc C(tc tcVar, tc tcVar2) {
        tcVar.H(tcVar2);
        return tcVar;
    }

    public static <K, V> hb<K, V> D(Map<K, Collection<V>> map, com.google.common.base.p0<? extends List<V>> p0Var) {
        return new b(map, p0Var);
    }

    public static <K, V> tc<K, V> E(Map<K, Collection<V>> map, com.google.common.base.p0<? extends Collection<V>> p0Var) {
        return new c(map, p0Var);
    }

    public static <K, V> ue<K, V> F(Map<K, Collection<V>> map, com.google.common.base.p0<? extends Set<V>> p0Var) {
        return new d(map, p0Var);
    }

    public static <K, V> bg<K, V> G(Map<K, Collection<V>> map, com.google.common.base.p0<? extends SortedSet<V>> p0Var) {
        return new e(map, p0Var);
    }

    public static <K, V> hb<K, V> H(hb<K, V> hbVar) {
        return dj.k(hbVar, null);
    }

    public static <K, V> tc<K, V> I(tc<K, V> tcVar) {
        return dj.m(tcVar, null);
    }

    public static <K, V> ue<K, V> J(ue<K, V> ueVar) {
        return dj.v(ueVar, null);
    }

    public static <K, V> bg<K, V> K(bg<K, V> bgVar) {
        return dj.y(bgVar, null);
    }

    @s1.a
    public static <T, K, V, M extends tc<K, V>> Collector<T, ?, M> L(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2, Supplier<M> supplier) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        com.google.common.base.e0.E(supplier);
        return Collector.of(supplier, new BiConsumer() { // from class: com.google.common.collect.ad
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                cd.B(function, function2, (tc) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.bd
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return cd.C((tc) obj, (tc) obj2);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <K, V1, V2> hb<K, V2> M(hb<K, V1> hbVar, wb.u<? super K, ? super V1, V2> uVar) {
        return new i(hbVar, uVar);
    }

    public static <K, V1, V2> tc<K, V2> N(tc<K, V1> tcVar, wb.u<? super K, ? super V1, V2> uVar) {
        return new j(tcVar, uVar);
    }

    public static <K, V1, V2> hb<K, V2> O(hb<K, V1> hbVar, com.google.common.base.s<? super V1, V2> sVar) {
        com.google.common.base.e0.E(sVar);
        return M(hbVar, wb.n(sVar));
    }

    public static <K, V1, V2> tc<K, V2> P(tc<K, V1> tcVar, com.google.common.base.s<? super V1, V2> sVar) {
        com.google.common.base.e0.E(sVar);
        return N(tcVar, wb.n(sVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Collection<Map.Entry<K, V>> Q(Collection<Map.Entry<K, V>> collection) {
        return collection instanceof Set ? wb.V0((Set) collection) : new wb.n0(Collections.unmodifiableCollection(collection));
    }

    @Deprecated
    public static <K, V> hb<K, V> R(q7<K, V> q7Var) {
        return (hb) com.google.common.base.e0.E(q7Var);
    }

    public static <K, V> hb<K, V> S(hb<K, V> hbVar) {
        return ((hbVar instanceof k) || (hbVar instanceof q7)) ? hbVar : new k(hbVar);
    }

    @Deprecated
    public static <K, V> tc<K, V> T(h8<K, V> h8Var) {
        return (tc) com.google.common.base.e0.E(h8Var);
    }

    public static <K, V> tc<K, V> U(tc<K, V> tcVar) {
        return ((tcVar instanceof l) || (tcVar instanceof h8)) ? tcVar : new l(tcVar);
    }

    @Deprecated
    public static <K, V> ue<K, V> V(e9<K, V> e9Var) {
        return (ue) com.google.common.base.e0.E(e9Var);
    }

    public static <K, V> ue<K, V> W(ue<K, V> ueVar) {
        return ((ueVar instanceof m) || (ueVar instanceof e9)) ? ueVar : new m(ueVar);
    }

    public static <K, V> bg<K, V> X(bg<K, V> bgVar) {
        return bgVar instanceof n ? bgVar : new n(bgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> Collection<V> Y(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    @s1.a
    public static <K, V> Map<K, List<V>> g(hb<K, V> hbVar) {
        return hbVar.asMap();
    }

    @s1.a
    public static <K, V> Map<K, Collection<V>> h(tc<K, V> tcVar) {
        return tcVar.asMap();
    }

    @s1.a
    public static <K, V> Map<K, Set<V>> i(ue<K, V> ueVar) {
        return ueVar.asMap();
    }

    @s1.a
    public static <K, V> Map<K, SortedSet<V>> j(bg<K, V> bgVar) {
        return bgVar.asMap();
    }

    static boolean k(tc<?, ?> tcVar, Object obj) {
        if (obj == tcVar) {
            return true;
        }
        if (obj instanceof tc) {
            return tcVar.asMap().equals(((tc) obj).asMap());
        }
        return false;
    }

    public static <K, V> tc<K, V> l(tc<K, V> tcVar, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        com.google.common.base.e0.E(g0Var);
        if (tcVar instanceof ue) {
            return m((ue) tcVar, g0Var);
        }
        return tcVar instanceof d5 ? n((d5) tcVar, g0Var) : new y4((tc) com.google.common.base.e0.E(tcVar), g0Var);
    }

    public static <K, V> ue<K, V> m(ue<K, V> ueVar, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        com.google.common.base.e0.E(g0Var);
        return ueVar instanceof g5 ? o((g5) ueVar, g0Var) : new z4((ue) com.google.common.base.e0.E(ueVar), g0Var);
    }

    private static <K, V> tc<K, V> n(d5<K, V> d5Var, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        return new y4(d5Var.d(), com.google.common.base.h0.d(d5Var.D(), g0Var));
    }

    private static <K, V> ue<K, V> o(g5<K, V> g5Var, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        return new z4(g5Var.d(), com.google.common.base.h0.d(g5Var.D(), g0Var));
    }

    public static <K, V> hb<K, V> p(hb<K, V> hbVar, com.google.common.base.g0<? super K> g0Var) {
        if (!(hbVar instanceof a5)) {
            return new a5(hbVar, g0Var);
        }
        a5 a5Var = (a5) hbVar;
        return new a5(a5Var.d(), com.google.common.base.h0.d(a5Var.f19952g, g0Var));
    }

    public static <K, V> tc<K, V> q(tc<K, V> tcVar, com.google.common.base.g0<? super K> g0Var) {
        if (tcVar instanceof ue) {
            return r((ue) tcVar, g0Var);
        }
        if (tcVar instanceof hb) {
            return p((hb) tcVar, g0Var);
        }
        if (!(tcVar instanceof b5)) {
            return tcVar instanceof d5 ? n((d5) tcVar, wb.Z(g0Var)) : new b5(tcVar, g0Var);
        }
        b5 b5Var = (b5) tcVar;
        return new b5(b5Var.f19951f, com.google.common.base.h0.d(b5Var.f19952g, g0Var));
    }

    public static <K, V> ue<K, V> r(ue<K, V> ueVar, com.google.common.base.g0<? super K> g0Var) {
        if (!(ueVar instanceof c5)) {
            return ueVar instanceof g5 ? o((g5) ueVar, wb.Z(g0Var)) : new c5(ueVar, g0Var);
        }
        c5 c5Var = (c5) ueVar;
        return new c5(c5Var.d(), com.google.common.base.h0.d(c5Var.f19952g, g0Var));
    }

    public static <K, V> tc<K, V> s(tc<K, V> tcVar, com.google.common.base.g0<? super V> g0Var) {
        return l(tcVar, wb.c1(g0Var));
    }

    public static <K, V> ue<K, V> t(ue<K, V> ueVar, com.google.common.base.g0<? super V> g0Var) {
        return m(ueVar, wb.c1(g0Var));
    }

    @s1.a
    public static <T, K, V, M extends tc<K, V>> Collector<T, ?, M> u(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2, Supplier<M> supplier) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        com.google.common.base.e0.E(supplier);
        return Collector.of(supplier, new BiConsumer() { // from class: com.google.common.collect.yc
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                cd.z(function, function2, (tc) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.zc
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return cd.A((tc) obj, (tc) obj2);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <K, V> ue<K, V> v(Map<K, V> map) {
        return new h(map);
    }

    public static <K, V> q7<K, V> w(Iterable<V> iterable, com.google.common.base.s<? super V, K> sVar) {
        return x(iterable.iterator(), sVar);
    }

    public static <K, V> q7<K, V> x(Iterator<V> it, com.google.common.base.s<? super V, K> sVar) {
        com.google.common.base.e0.E(sVar);
        q7.a aVarB0 = q7.b0();
        while (it.hasNext()) {
            V next = it.next();
            com.google.common.base.e0.F(next, it);
            aVarB0.f(sVar.apply(next), next);
        }
        return aVarB0.a();
    }

    @u1.a
    public static <K, V, M extends tc<K, V>> M y(tc<? extends V, ? extends K> tcVar, M m7) {
        com.google.common.base.e0.E(m7);
        for (Map.Entry<? extends V, ? extends K> entry : tcVar.y()) {
            m7.put(entry.getValue(), entry.getKey());
        }
        return m7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(Function function, Function function2, tc tcVar, Object obj) {
        final Collection collection = tcVar.get(function.apply(obj));
        Stream streamA = f7.a(function2.apply(obj));
        collection.getClass();
        streamA.forEachOrdered(new Consumer() { // from class: com.google.common.collect.xc
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                collection.add(obj2);
            }
        });
    }

    private static class n<K, V> extends m<K, V> implements bg<K, V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final long f20087i = 0;

        n(bg<K, V> bgVar) {
            super(bgVar);
        }

        @Override // com.google.common.collect.cd.m
        /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
        public bg<K, V> d0() {
            return (bg) super.d0();
        }

        @Override // com.google.common.collect.bg
        public Comparator<? super V> valueComparator() {
            return d0().valueComparator();
        }

        @Override // com.google.common.collect.cd.m, com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public SortedSet<V> a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.cd.m, com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public SortedSet<V> b(K k7, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.cd.m, com.google.common.collect.cd.l, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
        public SortedSet<V> get(K k7) {
            return Collections.unmodifiableSortedSet(d0().get((Object) k7));
        }
    }
}
