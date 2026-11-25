package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class wb {

    /* JADX INFO: Add missing generic type declarations: [V1, V2] */
    static class a<V1, V2> implements com.google.common.base.s<V1, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f21305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f21306b;

        a(u uVar, Object obj) {
            this.f21305a = uVar;
            this.f21306b = obj;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        public V2 apply(V1 v7) {
            return (V2) this.f21305a.a(this.f21306b, v7);
        }
    }

    private static final class a0<K, V> extends r0<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<K, V> f21307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.google.common.base.g0<? super Map.Entry<K, V>> f21308c;

        a0(Map<K, V> map, Map<K, V> map2, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
            super(map);
            this.f21307b = map2;
            this.f21308c = g0Var;
        }

        @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            Iterator<Map.Entry<K, V>> it = this.f21307b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f21308c.apply(next) && com.google.common.base.y.a(next.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.f21307b.entrySet().iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f21308c.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z7 = true;
                }
            }
            return z7;
        }

        @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.f21307b.entrySet().iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f21308c.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z7 = true;
                }
            }
            return z7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ib.s(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ib.s(iterator()).toArray(tArr);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    static class b<K, V1, V2> implements com.google.common.base.s<Map.Entry<K, V1>, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f21309a;

        b(u uVar) {
            this.f21309a = uVar;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public V2 apply(Map.Entry<K, V1> entry) {
            return (V2) this.f21309a.a(entry.getKey(), entry.getValue());
        }
    }

    static abstract class b0<K, V> extends AbstractMap<K, V> {

        class a extends t<K, V> {
            a() {
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
                b0.this.c(consumer);
            }

            @Override // com.google.common.collect.wb.t
            Map<K, V> g() {
                return b0.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return b0.this.a();
            }

            @Override // java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<Map.Entry<K, V>> spliterator() {
                return b0.this.b();
            }
        }

        b0() {
        }

        abstract Iterator<Map.Entry<K, V>> a();

        Spliterator<Map.Entry<K, V>> b() {
            return Spliterators.spliterator(a(), size(), 65);
        }

        void c(Consumer<? super Map.Entry<K, V>> consumer) {
            a().forEachRemaining(consumer);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            ua.h(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();
    }

    /* JADX INFO: Add missing generic type declarations: [K, V2] */
    static class c<K, V2> extends com.google.common.collect.v<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map.Entry f21311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f21312b;

        c(Map.Entry entry, u uVar) {
            this.f21311a = entry;
            this.f21312b = uVar;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public K getKey() {
            return (K) this.f21311a.getKey();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V2 getValue() {
            return (V2) this.f21312b.a(this.f21311a.getKey(), this.f21311a.getValue());
        }
    }

    static class c0<K, V> extends af.l<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        final Map<K, V> f21313a;

        c0(Map<K, V> map) {
            this.f21313a = (Map) com.google.common.base.e0.E(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            k().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return k().containsKey(obj);
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super K> consumer) {
            com.google.common.base.e0.E(consumer);
            this.f21313a.forEach(new BiConsumer() { // from class: com.google.common.collect.cc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    i2.a(consumer, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return k().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return wb.X(k().entrySet().iterator());
        }

        /* JADX INFO: renamed from: j */
        Map<K, V> k() {
            return this.f21313a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            k().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return k().size();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    static class d<K, V1, V2> implements com.google.common.base.s<Map.Entry<K, V1>, Map.Entry<K, V2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f21314a;

        d(u uVar) {
            this.f21314a = uVar;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return wb.M0(this.f21314a, entry);
        }
    }

    static class d0<K, V> implements mb<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, V> f21315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<K, V> f21316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map<K, V> f21317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Map<K, mb.a<V>> f21318d;

        d0(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, Map<K, mb.a<V>> map4) {
            this.f21315a = wb.W0(map);
            this.f21316b = wb.W0(map2);
            this.f21317c = wb.W0(map3);
            this.f21318d = wb.W0(map4);
        }

        @Override // com.google.common.collect.mb
        public Map<K, V> a() {
            return this.f21315a;
        }

        @Override // com.google.common.collect.mb
        public Map<K, mb.a<V>> b() {
            return this.f21318d;
        }

        @Override // com.google.common.collect.mb
        public Map<K, V> c() {
            return this.f21316b;
        }

        @Override // com.google.common.collect.mb
        public Map<K, V> d() {
            return this.f21317c;
        }

        @Override // com.google.common.collect.mb
        public boolean e() {
            return this.f21315a.isEmpty() && this.f21316b.isEmpty() && this.f21318d.isEmpty();
        }

        @Override // com.google.common.collect.mb
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof mb)) {
                return false;
            }
            mb mbVar = (mb) obj;
            return a().equals(mbVar.a()) && c().equals(mbVar.c()) && d().equals(mbVar.d()) && b().equals(mbVar.b());
        }

        @Override // com.google.common.collect.mb
        public int hashCode() {
            return com.google.common.base.y.b(a(), c(), d(), b());
        }

        public String toString() {
            if (e()) {
                return "equal";
            }
            StringBuilder sb = new StringBuilder("not equal");
            if (!this.f21315a.isEmpty()) {
                sb.append(": only on left=");
                sb.append(this.f21315a);
            }
            if (!this.f21316b.isEmpty()) {
                sb.append(": only on right=");
                sb.append(this.f21316b);
            }
            if (!this.f21318d.isEmpty()) {
                sb.append(": value differences=");
                sb.append(this.f21318d);
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    static class e<K, V> extends uj<Map.Entry<K, V>, K> {
        e(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.uj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @s1.c
    static final class e0<K, V> extends com.google.common.collect.z<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableSet<K> f21319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.common.base.s<? super K, V> f21320b;

        e0(NavigableSet<K> navigableSet, com.google.common.base.s<? super K, V> sVar) {
            this.f21319a = (NavigableSet) com.google.common.base.e0.E(navigableSet);
            this.f21320b = (com.google.common.base.s) com.google.common.base.e0.E(sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Map.Entry g(Object obj) {
            return wb.T(obj, this.f21320b.apply(obj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(BiConsumer biConsumer, Object obj) {
            biConsumer.accept(obj, this.f21320b.apply(obj));
        }

        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<K, V>> a() {
            return wb.r(this.f21319a, this.f21320b);
        }

        @Override // com.google.common.collect.wb.b0
        Spliterator<Map.Entry<K, V>> b() {
            return q2.e(this.f21319a.spliterator(), new Function() { // from class: com.google.common.collect.fc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f20269a.g(obj);
                }
            });
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f21319a.clear();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.f21319a.comparator();
        }

        @Override // com.google.common.collect.z
        Iterator<Map.Entry<K, V>> d() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.z, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return wb.p(this.f21319a.descendingSet(), this.f21320b);
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
            this.f21319a.forEach(new Consumer() { // from class: com.google.common.collect.gc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f20293a.i(biConsumer, obj);
                }
            });
        }

        @Override // com.google.common.collect.z, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return getOrDefault(obj, null);
        }

        @Override // java.util.Map
        public V getOrDefault(Object obj, V v7) {
            return h3.j(this.f21319a, obj) ? this.f21320b.apply(obj) : v7;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k7, boolean z7) {
            return wb.p(this.f21319a.headSet(k7, z7), this.f21320b);
        }

        @Override // com.google.common.collect.z, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return wb.v0(this.f21319a);
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f21319a.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k7, boolean z7, K k8, boolean z8) {
            return wb.p(this.f21319a.subSet(k7, z7, k8, z8), this.f21320b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k7, boolean z7) {
            return wb.p(this.f21319a.tailSet(k7, z7), this.f21320b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    static class f<K, V> extends uj<Map.Entry<K, V>, V> {
        f(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.uj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    @s1.c
    static class f0<K, V> extends h0<K, V> implements NavigableSet<K> {
        f0(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k7) {
            return j().ceilingKey(k7);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return j().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k7) {
            return j().floorKey(k7);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k7, boolean z7) {
            return j().headMap(k7, z7).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k7) {
            return j().higherKey(k7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.wb.h0
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> k() {
            return (NavigableMap) this.f21313a;
        }

        @Override // java.util.NavigableSet
        public K lower(K k7) {
            return j().lowerKey(k7);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) wb.Y(j().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) wb.Y(j().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k7, boolean z7, K k8, boolean z8) {
            return j().subMap(k7, z7, k8, z8).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k7, boolean z7) {
            return j().tailMap(k7, z7).navigableKeySet();
        }

        @Override // com.google.common.collect.wb.h0, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k7) {
            return headSet(k7, false);
        }

        @Override // com.google.common.collect.wb.h0, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k7, K k8) {
            return subSet(k7, true, k8, false);
        }

        @Override // com.google.common.collect.wb.h0, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k7) {
            return tailSet(k7, true);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    static class g<K, V> extends uj<K, Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.s f21321b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Iterator it, com.google.common.base.s sVar) {
            super(it);
            this.f21321b = sVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.uj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k7) {
            return wb.T(k7, this.f21321b.apply(k7));
        }
    }

    private static class g0<K, V> extends p<K, V> implements SortedMap<K, V> {
        g0(SortedSet<K> sortedSet, com.google.common.base.s<? super K, V> sVar) {
            super(sortedSet, sVar);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return e().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return e().first();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.wb.p
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedSet<K> e() {
            return (SortedSet) super.e();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K k7) {
            return wb.q(e().headSet(k7), this.f21341e);
        }

        @Override // com.google.common.collect.wb.s0, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return wb.x0(e());
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return e().last();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K k7, K k8) {
            return wb.q(e().subSet(k7, k8), this.f21341e);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K k7) {
            return wb.q(e().tailSet(k7), this.f21341e);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class h<E> extends d6<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f21322a;

        h(Set set) {
            this.f21322a = set;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean add(E e8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d6, com.google.common.collect.j5
        public Set<E> c0() {
            return this.f21322a;
        }
    }

    static class h0<K, V> extends c0<K, V> implements SortedSet<K> {
        h0(SortedMap<K, V> sortedMap) {
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
            return new h0(k().headMap(k7));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.wb.c0
        public SortedMap<K, V> k() {
            return (SortedMap) super.k();
        }

        @Override // java.util.SortedSet
        public K last() {
            return k().lastKey();
        }

        public SortedSet<K> subSet(K k7, K k8) {
            return new h0(k().subMap(k7, k8));
        }

        public SortedSet<K> tailSet(K k7) {
            return new h0(k().tailMap(k7));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class i<E> extends h6<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SortedSet f21323a;

        i(SortedSet sortedSet) {
            this.f21323a = sortedSet;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean add(E e8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e8) {
            return wb.x0(super.headSet(e8));
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e8, E e9) {
            return wb.x0(super.subSet(e8, e9));
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e8) {
            return wb.x0(super.tailSet(e8));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.h6, com.google.common.collect.d6
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public SortedSet<E> w0() {
            return this.f21323a;
        }
    }

    static class i0<K, V> extends d0<K, V> implements uf<K, V> {
        i0(SortedMap<K, V> sortedMap, SortedMap<K, V> sortedMap2, SortedMap<K, V> sortedMap3, SortedMap<K, mb.a<V>> sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        @Override // com.google.common.collect.wb.d0, com.google.common.collect.mb
        public SortedMap<K, V> a() {
            return (SortedMap) super.a();
        }

        @Override // com.google.common.collect.wb.d0, com.google.common.collect.mb
        public SortedMap<K, mb.a<V>> b() {
            return (SortedMap) super.b();
        }

        @Override // com.google.common.collect.wb.d0, com.google.common.collect.mb
        public SortedMap<K, V> c() {
            return (SortedMap) super.c();
        }

        @Override // com.google.common.collect.wb.d0, com.google.common.collect.mb
        public SortedMap<K, V> d() {
            return (SortedMap) super.d();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class j<E> extends a6<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavigableSet f21324a;

        j(NavigableSet navigableSet) {
            this.f21324a = navigableSet;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.a6, com.google.common.collect.h6
        /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<E> w0() {
            return this.f21324a;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean add(E e8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return wb.v0(super.descendingSet());
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e8) {
            return wb.x0(super.headSet(e8));
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e8, E e9) {
            return wb.x0(super.subSet(e8, e9));
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e8) {
            return wb.x0(super.tailSet(e8));
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public NavigableSet<E> headSet(E e8, boolean z7) {
            return wb.v0(super.headSet(e8, z7));
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public NavigableSet<E> subSet(E e8, boolean z7, E e9, boolean z8) {
            return wb.v0(super.subSet(e8, z7, e9, z8));
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public NavigableSet<E> tailSet(E e8, boolean z7) {
            return wb.v0(super.tailSet(e8, z7));
        }
    }

    static class j0<K, V1, V2> extends b0<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, V1> f21325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final u<? super K, ? super V1, V2> f21326b;

        j0(Map<K, V1> map, u<? super K, ? super V1, V2> uVar) {
            this.f21325a = (Map) com.google.common.base.e0.E(map);
            this.f21326b = (u) com.google.common.base.e0.E(uVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(BiConsumer biConsumer, Object obj, Object obj2) {
            biConsumer.accept(obj, this.f21326b.a(obj, obj2));
        }

        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<K, V2>> a() {
            return ua.c0(this.f21325a.entrySet().iterator(), wb.l(this.f21326b));
        }

        @Override // com.google.common.collect.wb.b0
        Spliterator<Map.Entry<K, V2>> b() {
            return q2.e(this.f21325a.entrySet().spliterator(), wb.l(this.f21326b));
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f21325a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f21325a.containsKey(obj);
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super K, ? super V2> biConsumer) {
            com.google.common.base.e0.E(biConsumer);
            this.f21325a.forEach(new BiConsumer() { // from class: com.google.common.collect.hc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f20393a.e(biConsumer, obj, obj2);
                }
            });
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            return getOrDefault(obj, null);
        }

        @Override // java.util.Map
        public V2 getOrDefault(Object obj, V2 v7) {
            V1 v8 = this.f21325a.get(obj);
            return (v8 != null || this.f21325a.containsKey(obj)) ? this.f21326b.a(obj, v8) : v7;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f21325a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.f21325a.containsKey(obj)) {
                return this.f21326b.a(obj, this.f21325a.remove(obj));
            }
            return null;
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f21325a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new r0(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    static class k<K, V> extends com.google.common.collect.v<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map.Entry f21327a;

        k(Map.Entry entry) {
            this.f21327a = entry;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public K getKey() {
            return (K) this.f21327a.getKey();
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V getValue() {
            return (V) this.f21327a.getValue();
        }
    }

    @s1.c
    private static class k0<K, V1, V2> extends l0<K, V1, V2> implements NavigableMap<K, V2> {
        k0(NavigableMap<K, V1> navigableMap, u<? super K, ? super V1, V2> uVar) {
            super(navigableMap, uVar);
        }

        private Map.Entry<K, V2> m(Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            return wb.M0(this.f21326b, entry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> ceilingEntry(K k7) {
            return m(f().ceilingEntry(k7));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k7) {
            return f().ceilingKey(k7);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return f().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> descendingMap() {
            return wb.K0(f().descendingMap(), this.f21326b);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> firstEntry() {
            return m(f().firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> floorEntry(K k7) {
            return m(f().floorEntry(k7));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k7) {
            return f().floorKey(k7);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.wb.l0
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V1> f() {
            return (NavigableMap) super.f();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> higherEntry(K k7) {
            return m(f().higherEntry(k7));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k7) {
            return f().higherKey(k7);
        }

        @Override // com.google.common.collect.wb.l0, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V2> headMap(K k7) {
            return headMap(k7, false);
        }

        @Override // com.google.common.collect.wb.l0, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V2> subMap(K k7, K k8) {
            return subMap(k7, true, k8, false);
        }

        @Override // com.google.common.collect.wb.l0, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V2> tailMap(K k7) {
            return tailMap(k7, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lastEntry() {
            return m(f().lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lowerEntry(K k7) {
            return m(f().lowerEntry(k7));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k7) {
            return f().lowerKey(k7);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return f().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> pollFirstEntry() {
            return m(f().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> pollLastEntry() {
            return m(f().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> headMap(K k7, boolean z7) {
            return wb.K0(f().headMap(k7, z7), this.f21326b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> subMap(K k7, boolean z7, K k8, boolean z8) {
            return wb.K0(f().subMap(k7, z7, k8, z8), this.f21326b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(K k7, boolean z7) {
            return wb.K0(f().tailMap(k7, z7), this.f21326b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    static class l<K, V> extends ck<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f21328a;

        l(Iterator it) {
            this.f21328a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return wb.T0((Map.Entry) this.f21328a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21328a.hasNext();
        }
    }

    static class l0<K, V1, V2> extends j0<K, V1, V2> implements SortedMap<K, V2> {
        l0(SortedMap<K, V1> sortedMap, u<? super K, ? super V1, V2> uVar) {
            super(sortedMap, uVar);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return f().comparator();
        }

        protected SortedMap<K, V1> f() {
            return (SortedMap) this.f21325a;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return f().firstKey();
        }

        public SortedMap<K, V2> headMap(K k7) {
            return wb.L0(f().headMap(k7), this.f21326b);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return f().lastKey();
        }

        public SortedMap<K, V2> subMap(K k7, K k8) {
            return wb.L0(f().subMap(k7, k8), this.f21326b);
        }

        public SortedMap<K, V2> tailMap(K k7) {
            return wb.L0(f().tailMap(k7), this.f21326b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    static class m<K, V1, V2> implements u<K, V1, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.s f21329a;

        m(com.google.common.base.s sVar) {
            this.f21329a = sVar;
        }

        @Override // com.google.common.collect.wb.u
        public V2 a(K k7, V1 v7) {
            return (V2) this.f21329a.apply(v7);
        }
    }

    private static class m0<K, V> extends u5<K, V> implements com.google.common.collect.r0<K, V>, Serializable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f21330e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, V> f21331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.google.common.collect.r0<? extends K, ? extends V> f21332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @y1.h
        com.google.common.collect.r0<V, K> f21333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Set<V> f21334d;

        m0(com.google.common.collect.r0<? extends K, ? extends V> r0Var, com.google.common.collect.r0<V, K> r0Var2) {
            this.f21331a = Collections.unmodifiableMap(r0Var);
            this.f21332b = r0Var;
            this.f21333c = r0Var2;
        }

        @Override // com.google.common.collect.r0
        public com.google.common.collect.r0<V, K> T() {
            com.google.common.collect.r0<V, K> r0Var = this.f21333c;
            if (r0Var != null) {
                return r0Var;
            }
            m0 m0Var = new m0(this.f21332b.T(), this);
            this.f21333c = m0Var;
            return m0Var;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.u5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public Map<K, V> c0() {
            return this.f21331a;
        }

        @Override // com.google.common.collect.r0
        public V x(K k7, V v7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
        public Set<V> values() {
            Set<V> set = this.f21334d;
            if (set != null) {
                return set;
            }
            Set<V> setUnmodifiableSet = Collections.unmodifiableSet(this.f21332b.values());
            this.f21334d = setUnmodifiableSet;
            return setUnmodifiableSet;
        }
    }

    private static abstract class n<K, V> extends s0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Map<K, V> f21335d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final com.google.common.base.g0<? super Map.Entry<K, V>> f21336e;

        n(Map<K, V> map, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
            this.f21335d = map;
            this.f21336e = g0Var;
        }

        @Override // com.google.common.collect.wb.s0
        Collection<V> c() {
            return new a0(this, this.f21335d, this.f21336e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f21335d.containsKey(obj) && d(obj, this.f21335d.get(obj));
        }

        boolean d(Object obj, V v7) {
            return this.f21336e.apply(wb.T(obj, v7));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            V v7 = this.f21335d.get(obj);
            if (v7 == null || !d(obj, v7)) {
                return null;
            }
            return v7;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k7, V v7) {
            com.google.common.base.e0.d(d(k7, v7));
            return this.f21335d.put(k7, v7);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                com.google.common.base.e0.d(d(entry.getKey(), entry.getValue()));
            }
            this.f21335d.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            if (containsKey(obj)) {
                return this.f21335d.remove(obj);
            }
            return null;
        }
    }

    static class n0<K, V> extends j5<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection<Map.Entry<K, V>> f21337a;

        n0(Collection<Map.Entry<K, V>> collection) {
            this.f21337a = collection;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.j5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public Collection<Map.Entry<K, V>> c0() {
            return this.f21337a;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Iterator<Map.Entry<K, V>> iterator() {
            return wb.U0(this.f21337a.iterator());
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return q0();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) t0(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class o<K extends Enum<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BinaryOperator<V> f21338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private EnumMap<K, V> f21339b = null;

        o(BinaryOperator<V> binaryOperator) {
            this.f21338a = binaryOperator;
        }

        o<K, V> a(o<K, V> oVar) {
            if (this.f21339b == null) {
                return oVar;
            }
            EnumMap<K, V> enumMap = oVar.f21339b;
            if (enumMap == null) {
                return this;
            }
            enumMap.forEach(new BiConsumer() { // from class: com.google.common.collect.xb
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f21410a.b((Enum) obj, obj2);
                }
            });
            return this;
        }

        void b(K k7, V v7) {
            if (this.f21339b == null) {
                this.f21339b = new EnumMap<>(k7.getDeclaringClass());
            }
            this.f21339b.merge(k7, v7, this.f21338a);
        }

        v7<K, V> c() {
            EnumMap<K, V> enumMap = this.f21339b;
            return enumMap == null ? v7.y() : a7.M(enumMap);
        }
    }

    static class o0<K, V> extends n0<K, V> implements Set<Map.Entry<K, V>> {
        o0(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return af.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return af.k(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class p<K, V> extends s0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Set<K> f21340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final com.google.common.base.s<? super K, V> f21341e;

        class a extends t<K, V> {
            a() {
            }

            @Override // com.google.common.collect.wb.t
            Map<K, V> g() {
                return p.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return wb.r(p.this.e(), p.this.f21341e);
            }
        }

        p(Set<K> set, com.google.common.base.s<? super K, V> sVar) {
            this.f21340d = (Set) com.google.common.base.e0.E(set);
            this.f21341e = (com.google.common.base.s) com.google.common.base.e0.E(sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(BiConsumer biConsumer, Object obj) {
            biConsumer.accept(obj, this.f21341e.apply(obj));
        }

        @Override // com.google.common.collect.wb.s0
        protected Set<Map.Entry<K, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.wb.s0
        /* JADX INFO: renamed from: b */
        public Set<K> g() {
            return wb.w0(e());
        }

        @Override // com.google.common.collect.wb.s0
        Collection<V> c() {
            return h3.m(this.f21340d, this.f21341e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return e().contains(obj);
        }

        Set<K> e() {
            return this.f21340d;
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
            com.google.common.base.e0.E(biConsumer);
            e().forEach(new Consumer() { // from class: com.google.common.collect.zb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f21493a.f(biConsumer, obj);
                }
            });
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return getOrDefault(obj, null);
        }

        @Override // java.util.Map
        public V getOrDefault(Object obj, V v7) {
            return h3.j(e(), obj) ? this.f21341e.apply(obj) : v7;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            if (e().remove(obj)) {
                return this.f21341e.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return e().size();
        }
    }

    @s1.c
    static class p0<K, V> extends f6<K, V> implements NavigableMap<K, V>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap<K, ? extends V> f21343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient p0<K, V> f21344b;

        p0(NavigableMap<K, ? extends V> navigableMap) {
            this.f21343a = navigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k7) {
            return wb.Y0(this.f21343a.ceilingEntry(k7));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k7) {
            return this.f21343a.ceilingKey(k7);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return af.P(this.f21343a.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            p0<K, V> p0Var = this.f21344b;
            if (p0Var != null) {
                return p0Var;
            }
            p0<K, V> p0Var2 = new p0<>(this.f21343a.descendingMap(), this);
            this.f21344b = p0Var2;
            return p0Var2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return wb.Y0(this.f21343a.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k7) {
            return wb.Y0(this.f21343a.floorEntry(k7));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k7) {
            return this.f21343a.floorKey(k7);
        }

        @Override // com.google.common.collect.f6, java.util.SortedMap
        public SortedMap<K, V> headMap(K k7) {
            return headMap(k7, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k7) {
            return wb.Y0(this.f21343a.higherEntry(k7));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k7) {
            return this.f21343a.higherKey(k7);
        }

        @Override // com.google.common.collect.u5, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return wb.Y0(this.f21343a.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k7) {
            return wb.Y0(this.f21343a.lowerEntry(k7));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k7) {
            return this.f21343a.lowerKey(k7);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return af.P(this.f21343a.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.f6, java.util.SortedMap
        public SortedMap<K, V> subMap(K k7, K k8) {
            return subMap(k7, true, k8, false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.f6, com.google.common.collect.u5
        /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
        public SortedMap<K, V> c0() {
            return Collections.unmodifiableSortedMap(this.f21343a);
        }

        @Override // com.google.common.collect.f6, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k7) {
            return tailMap(k7, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k7, boolean z7) {
            return wb.X0(this.f21343a.headMap(k7, z7));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k7, boolean z7, K k8, boolean z8) {
            return wb.X0(this.f21343a.subMap(k7, z7, k8, z8));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k7, boolean z7) {
            return wb.X0(this.f21343a.tailMap(k7, z7));
        }

        p0(NavigableMap<K, ? extends V> navigableMap, p0<K, V> p0Var) {
            this.f21343a = navigableMap;
            this.f21344b = p0Var;
        }
    }

    private static final class q<A, B> extends com.google.common.base.i<A, B> implements Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f21345d = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.google.common.collect.r0<A, B> f21346c;

        q(com.google.common.collect.r0<A, B> r0Var) {
            this.f21346c = (com.google.common.collect.r0) com.google.common.base.e0.E(r0Var);
        }

        private static <X, Y> Y l(com.google.common.collect.r0<X, Y> r0Var, X x7) {
            Y y7 = r0Var.get(x7);
            com.google.common.base.e0.u(y7 != null, "No non-null mapping present for input: %s", x7);
            return y7;
        }

        @Override // com.google.common.base.i, com.google.common.base.s
        public boolean equals(Object obj) {
            if (obj instanceof q) {
                return this.f21346c.equals(((q) obj).f21346c);
            }
            return false;
        }

        @Override // com.google.common.base.i
        protected A g(B b8) {
            return (A) l(this.f21346c.T(), b8);
        }

        @Override // com.google.common.base.i
        protected B h(A a8) {
            return (B) l(this.f21346c, a8);
        }

        public int hashCode() {
            return this.f21346c.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.f21346c + ")";
        }
    }

    static class q0<V> implements mb.a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final V f21347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f21348b;

        private q0(V v7, V v8) {
            this.f21347a = v7;
            this.f21348b = v8;
        }

        static <V> mb.a<V> c(V v7, V v8) {
            return new q0(v7, v8);
        }

        @Override // com.google.common.collect.mb.a
        public V a() {
            return this.f21348b;
        }

        @Override // com.google.common.collect.mb.a
        public V b() {
            return this.f21347a;
        }

        @Override // com.google.common.collect.mb.a
        public boolean equals(Object obj) {
            if (!(obj instanceof mb.a)) {
                return false;
            }
            mb.a aVar = (mb.a) obj;
            return com.google.common.base.y.a(this.f21347a, aVar.b()) && com.google.common.base.y.a(this.f21348b, aVar.a());
        }

        @Override // com.google.common.collect.mb.a
        public int hashCode() {
            return com.google.common.base.y.b(this.f21347a, this.f21348b);
        }

        public String toString() {
            return "(" + this.f21347a + ", " + this.f21348b + ")";
        }
    }

    @s1.c
    static abstract class r<K, V> extends u5<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Comparator<? super K> f21349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f21350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private transient NavigableSet<K> f21351c;

        class a extends t<K, V> {
            a() {
            }

            @Override // com.google.common.collect.wb.t
            Map<K, V> g() {
                return r.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return r.this.u0();
            }
        }

        r() {
        }

        private static <T> td<T> x0(Comparator<T> comparator) {
            return td.i(comparator).F();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k7) {
            return w0().floorEntry(k7);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k7) {
            return w0().floorKey(k7);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f21349a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = w0().comparator();
            if (comparator2 == null) {
                comparator2 = td.A();
            }
            td tdVarX0 = x0(comparator2);
            this.f21349a = tdVarX0;
            return tdVarX0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.u5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public final Map<K, V> c0() {
            return w0();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return w0().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return w0();
        }

        @Override // com.google.common.collect.u5, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f21350b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setT0 = t0();
            this.f21350b = setT0;
            return setT0;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return w0().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return w0().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k7) {
            return w0().ceilingEntry(k7);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k7) {
            return w0().ceilingKey(k7);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k7, boolean z7) {
            return w0().tailMap(k7, z7).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k7) {
            return w0().lowerEntry(k7);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k7) {
            return w0().lowerKey(k7);
        }

        @Override // com.google.common.collect.u5, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return w0().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return w0().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k7) {
            return w0().higherEntry(k7);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k7) {
            return w0().higherKey(k7);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f21351c;
            if (navigableSet != null) {
                return navigableSet;
            }
            f0 f0Var = new f0(this);
            this.f21351c = f0Var;
            return f0Var;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return w0().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return w0().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k7, boolean z7, K k8, boolean z8) {
            return w0().subMap(k8, z8, k7, z7).descendingMap();
        }

        Set<Map.Entry<K, V>> t0() {
            return new a();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k7, boolean z7) {
            return w0().headMap(k7, z7).descendingMap();
        }

        @Override // com.google.common.collect.b6
        public String toString() {
            return q0();
        }

        abstract Iterator<Map.Entry<K, V>> u0();

        @Override // com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
        public Collection<V> values() {
            return new r0(this);
        }

        abstract NavigableMap<K, V> w0();

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k7) {
            return headMap(k7, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k7, K k8) {
            return subMap(k7, true, k8, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k7) {
            return tailMap(k7, true);
        }
    }

    static class r0<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        final Map<K, V> f21353a;

        r0(Map<K, V> map) {
            this.f21353a = (Map) com.google.common.base.e0.E(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return d().containsValue(obj);
        }

        final Map<K, V> d() {
            return this.f21353a;
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super V> consumer) {
            com.google.common.base.e0.E(consumer);
            this.f21353a.forEach(new BiConsumer() { // from class: com.google.common.collect.ic
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    i2.a(consumer, obj2);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return d().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return wb.a1(d().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : d().entrySet()) {
                    if (com.google.common.base.y.a(obj, entry.getValue())) {
                        d().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.e0.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetU = af.u();
                for (Map.Entry<K, V> entry : d().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetU.add(entry.getKey());
                    }
                }
                return d().keySet().removeAll(hashSetU);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.e0.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetU = af.u();
                for (Map.Entry<K, V> entry : d().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetU.add(entry.getKey());
                    }
                }
                return d().keySet().retainAll(hashSetU);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return d().size();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class s implements com.google.common.base.s<Map.Entry<?, ?>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f21354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final s f21355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ s[] f21356c;

        static enum a extends s {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        static enum b extends s {
            b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        static {
            a aVar = new a("KEY", 0);
            f21354a = aVar;
            b bVar = new b("VALUE", 1);
            f21355b = bVar;
            f21356c = new s[]{aVar, bVar};
        }

        private s(String str, int i7) {
            super(str, i7);
        }

        public static s valueOf(String str) {
            return (s) Enum.valueOf(s.class, str);
        }

        public static s[] values() {
            return (s[]) f21356c.clone();
        }

        /* synthetic */ s(String str, int i7, e eVar) {
            this(str, i7);
        }
    }

    @s1.b
    static abstract class s0<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f21357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Set<K> f21358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private transient Collection<V> f21359c;

        s0() {
        }

        abstract Set<Map.Entry<K, V>> a();

        /* JADX INFO: renamed from: b */
        Set<K> g() {
            return new c0(this);
        }

        Collection<V> c() {
            return new r0(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f21357a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setA = a();
            this.f21357a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.f21358b;
            if (set != null) {
                return set;
            }
            Set<K> setG = g();
            this.f21358b = setG;
            return setG;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f21359c;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionC = c();
            this.f21359c = collectionC;
            return collectionC;
        }
    }

    static abstract class t<K, V> extends af.l<Map.Entry<K, V>> {
        t() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object objZ0 = wb.z0(g(), key);
            if (com.google.common.base.y.a(objZ0, entry.getValue())) {
                return objZ0 != null || g().containsKey(key);
            }
            return false;
        }

        abstract Map<K, V> g();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return g().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                return g().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.af.l, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.e0.E(collection));
            } catch (UnsupportedOperationException unused) {
                return af.J(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.e0.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetY = af.y(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        hashSetY.add(((Map.Entry) obj).getKey());
                    }
                }
                return g().keySet().retainAll(hashSetY);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g().size();
        }
    }

    @FunctionalInterface
    public interface u<K, V1, V2> {
        V2 a(K k7, V1 v7);
    }

    static final class v<K, V> extends w<K, V> implements com.google.common.collect.r0<K, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @y1.h
        private final com.google.common.collect.r0<V, K> f21360g;

        static class a implements com.google.common.base.g0<Map.Entry<V, K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.google.common.base.g0 f21361a;

            a(com.google.common.base.g0 g0Var) {
                this.f21361a = g0Var;
            }

            @Override // com.google.common.base.g0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Map.Entry<V, K> entry) {
                return this.f21361a.apply(wb.T(entry.getValue(), entry.getKey()));
            }

            @Override // com.google.common.base.g0, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return com.google.common.base.f0.a(this, obj);
            }
        }

        v(com.google.common.collect.r0<K, V> r0Var, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
            super(r0Var, g0Var);
            this.f21360g = new v(r0Var.T(), i(g0Var), this);
        }

        private static <K, V> com.google.common.base.g0<Map.Entry<V, K>> i(com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
            return new a(g0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object k(BiFunction biFunction, Object obj, Object obj2) {
            return this.f21336e.apply(wb.T(obj, obj2)) ? biFunction.apply(obj, obj2) : obj2;
        }

        @Override // com.google.common.collect.r0
        public com.google.common.collect.r0<V, K> T() {
            return this.f21360g;
        }

        com.google.common.collect.r0<K, V> l() {
            return (com.google.common.collect.r0) this.f21335d;
        }

        @Override // java.util.Map
        public void replaceAll(final BiFunction<? super K, ? super V, ? extends V> biFunction) {
            l().replaceAll(new BiFunction() { // from class: com.google.common.collect.ac
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return this.f19865a.k(biFunction, obj, obj2);
                }
            });
        }

        @Override // com.google.common.collect.r0
        public V x(K k7, V v7) {
            com.google.common.base.e0.d(d(k7, v7));
            return l().x(k7, v7);
        }

        @Override // com.google.common.collect.wb.s0, java.util.AbstractMap, java.util.Map
        public Set<V> values() {
            return this.f21360g.keySet();
        }

        private v(com.google.common.collect.r0<K, V> r0Var, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var, com.google.common.collect.r0<V, K> r0Var2) {
            super(r0Var, g0Var);
            this.f21360g = r0Var2;
        }
    }

    static class w<K, V> extends n<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Set<Map.Entry<K, V>> f21362f;

        private class a extends d6<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: com.google.common.collect.wb$w$a$a, reason: collision with other inner class name */
            class C0256a extends uj<Map.Entry<K, V>, Map.Entry<K, V>> {

                /* JADX INFO: renamed from: com.google.common.collect.wb$w$a$a$a, reason: collision with other inner class name */
                class C0257a extends v5<K, V> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Map.Entry f21365a;

                    C0257a(Map.Entry entry) {
                        this.f21365a = entry;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.common.collect.v5, com.google.common.collect.b6
                    /* JADX INFO: renamed from: d0 */
                    public Map.Entry<K, V> c0() {
                        return this.f21365a;
                    }

                    @Override // com.google.common.collect.v5, java.util.Map.Entry
                    public V setValue(V v7) {
                        com.google.common.base.e0.d(w.this.d(getKey(), v7));
                        return (V) super.setValue(v7);
                    }
                }

                C0256a(Iterator it) {
                    super(it);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.uj
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> a(Map.Entry<K, V> entry) {
                    return new C0257a(entry);
                }
            }

            private a() {
            }

            @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public Iterator<Map.Entry<K, V>> iterator() {
                return new C0256a(w.this.f21362f.iterator());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.d6, com.google.common.collect.j5
            public Set<Map.Entry<K, V>> c0() {
                return w.this.f21362f;
            }

            /* synthetic */ a(w wVar, e eVar) {
                this();
            }
        }

        class b extends c0<K, V> {
            b() {
                super(w.this);
            }

            @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!w.this.containsKey(obj)) {
                    return false;
                }
                w.this.f21335d.remove(obj);
                return true;
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                w wVar = w.this;
                return w.e(wVar.f21335d, wVar.f21336e, collection);
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                w wVar = w.this;
                return w.f(wVar.f21335d, wVar.f21336e, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return ib.s(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) ib.s(iterator()).toArray(tArr);
            }
        }

        w(Map<K, V> map, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
            super(map, g0Var);
            this.f21362f = af.i(map.entrySet(), this.f21336e);
        }

        static <K, V> boolean e(Map<K, V> map, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (g0Var.apply(next) && collection.contains(next.getKey())) {
                    it.remove();
                    z7 = true;
                }
            }
            return z7;
        }

        static <K, V> boolean f(Map<K, V> map, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z7 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (g0Var.apply(next) && !collection.contains(next.getKey())) {
                    it.remove();
                    z7 = true;
                }
            }
            return z7;
        }

        @Override // com.google.common.collect.wb.s0
        protected Set<Map.Entry<K, V>> a() {
            return new a(this, null);
        }

        @Override // com.google.common.collect.wb.s0
        /* JADX INFO: renamed from: b */
        Set<K> g() {
            return new b();
        }
    }

    @s1.c
    private static class x<K, V> extends com.google.common.collect.z<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap<K, V> f21368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.common.base.g0<? super Map.Entry<K, V>> f21369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<K, V> f21370c;

        class a extends f0<K, V> {
            a(NavigableMap navigableMap) {
                super(navigableMap);
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return w.e(x.this.f21368a, x.this.f21369b, collection);
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return w.f(x.this.f21368a, x.this.f21369b, collection);
            }
        }

        x(NavigableMap<K, V> navigableMap, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
            this.f21368a = (NavigableMap) com.google.common.base.e0.E(navigableMap);
            this.f21369b = g0Var;
            this.f21370c = new w(navigableMap, g0Var);
        }

        @Override // com.google.common.collect.wb.b0
        Iterator<Map.Entry<K, V>> a() {
            return ua.x(this.f21368a.entrySet().iterator(), this.f21369b);
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f21370c.clear();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.f21368a.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f21370c.containsKey(obj);
        }

        @Override // com.google.common.collect.z
        Iterator<Map.Entry<K, V>> d() {
            return ua.x(this.f21368a.descendingMap().entrySet().iterator(), this.f21369b);
        }

        @Override // com.google.common.collect.z, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return wb.E(this.f21368a.descendingMap(), this.f21369b);
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return this.f21370c.entrySet();
        }

        @Override // com.google.common.collect.z, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return this.f21370c.get(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k7, boolean z7) {
            return wb.E(this.f21368a.headMap(k7, z7), this.f21369b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !ma.c(this.f21368a.entrySet(), this.f21369b);
        }

        @Override // com.google.common.collect.z, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new a(this);
        }

        @Override // com.google.common.collect.z, java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) ma.I(this.f21368a.entrySet(), this.f21369b);
        }

        @Override // com.google.common.collect.z, java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) ma.I(this.f21368a.descendingMap().entrySet(), this.f21369b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k7, V v7) {
            return this.f21370c.put(k7, v7);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.f21370c.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return this.f21370c.remove(obj);
        }

        @Override // com.google.common.collect.wb.b0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f21370c.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k7, boolean z7, K k8, boolean z8) {
            return wb.E(this.f21368a.subMap(k7, z7, k8, z8), this.f21369b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k7, boolean z7) {
            return wb.E(this.f21368a.tailMap(k7, z7), this.f21369b);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection<V> values() {
            return new a0(this, this.f21368a, this.f21369b);
        }
    }

    private static class y<K, V> extends w<K, V> implements SortedMap<K, V> {

        class a extends w<K, V>.b implements SortedSet<K> {
            a() {
                super();
            }

            @Override // java.util.SortedSet
            public Comparator<? super K> comparator() {
                return y.this.k().comparator();
            }

            @Override // java.util.SortedSet
            public K first() {
                return (K) y.this.firstKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> headSet(K k7) {
                return (SortedSet) y.this.headMap(k7).keySet();
            }

            @Override // java.util.SortedSet
            public K last() {
                return (K) y.this.lastKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> subSet(K k7, K k8) {
                return (SortedSet) y.this.subMap(k7, k8).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> tailSet(K k7) {
                return (SortedSet) y.this.tailMap(k7).keySet();
            }
        }

        y(SortedMap<K, V> sortedMap, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
            super(sortedMap, g0Var);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return k().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return keySet().iterator().next();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.wb.w, com.google.common.collect.wb.s0
        public SortedSet<K> g() {
            return new a();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K k7) {
            return new y(k().headMap(k7), this.f21336e);
        }

        @Override // com.google.common.collect.wb.s0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public SortedSet<K> keySet() {
            return (SortedSet) super.keySet();
        }

        SortedMap<K, V> k() {
            return (SortedMap) this.f21335d;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            SortedMap<K, V> sortedMapK = k();
            while (true) {
                K kLastKey = sortedMapK.lastKey();
                if (d(kLastKey, this.f21335d.get(kLastKey))) {
                    return kLastKey;
                }
                sortedMapK = k().headMap(kLastKey);
            }
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K k7, K k8) {
            return new y(k().subMap(k7, k8), this.f21336e);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K k7) {
            return new y(k().tailMap(k7), this.f21336e);
        }
    }

    private static class z<K, V> extends n<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final com.google.common.base.g0<? super K> f21373f;

        z(Map<K, V> map, com.google.common.base.g0<? super K> g0Var, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var2) {
            super(map, g0Var2);
            this.f21373f = g0Var;
        }

        @Override // com.google.common.collect.wb.s0
        protected Set<Map.Entry<K, V>> a() {
            return af.i(this.f21335d.entrySet(), this.f21336e);
        }

        @Override // com.google.common.collect.wb.s0
        /* JADX INFO: renamed from: b */
        Set<K> g() {
            return af.i(this.f21335d.keySet(), this.f21373f);
        }

        @Override // com.google.common.collect.wb.n, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f21335d.containsKey(obj) && this.f21373f.apply(obj);
        }
    }

    private wb() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> void A(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, com.google.common.base.l<? super V> lVar, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, mb.a<V>> map6) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (map2.containsKey(key)) {
                V vRemove = map4.remove(key);
                if (lVar.d(value, vRemove)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, q0.c(value, vRemove));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    static <V> V A0(Map<?, V> map, Object obj) {
        com.google.common.base.e0.E(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean B(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s1.a
    @s1.c
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> B0(NavigableMap<K, V> navigableMap, xd<K> xdVar) {
        if (navigableMap.comparator() != null && navigableMap.comparator() != td.A() && xdVar.r() && xdVar.t()) {
            com.google.common.base.e0.e(navigableMap.comparator().compare(xdVar.A(), xdVar.M()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (xdVar.r() && xdVar.t()) {
            Comparable comparableA = xdVar.A();
            com.google.common.collect.s0 s0VarZ = xdVar.z();
            com.google.common.collect.s0 s0Var = com.google.common.collect.s0.CLOSED;
            return navigableMap.subMap(comparableA, s0VarZ == s0Var, xdVar.M(), xdVar.L() == s0Var);
        }
        if (xdVar.r()) {
            return navigableMap.tailMap(xdVar.A(), xdVar.z() == com.google.common.collect.s0.CLOSED);
        }
        if (xdVar.t()) {
            return navigableMap.headMap(xdVar.M(), xdVar.L() == com.google.common.collect.s0.CLOSED);
        }
        return (NavigableMap) com.google.common.base.e0.E(navigableMap);
    }

    public static <K, V> com.google.common.collect.r0<K, V> C(com.google.common.collect.r0<K, V> r0Var, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        com.google.common.base.e0.E(r0Var);
        com.google.common.base.e0.E(g0Var);
        return r0Var instanceof v ? G((v) r0Var, g0Var) : new v(r0Var, g0Var);
    }

    public static <K, V> com.google.common.collect.r0<K, V> C0(com.google.common.collect.r0<K, V> r0Var) {
        return dj.g(r0Var, null);
    }

    public static <K, V> Map<K, V> D(Map<K, V> map, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        com.google.common.base.e0.E(g0Var);
        return map instanceof n ? H((n) map, g0Var) : new w((Map) com.google.common.base.e0.E(map), g0Var);
    }

    @s1.c
    public static <K, V> NavigableMap<K, V> D0(NavigableMap<K, V> navigableMap) {
        return dj.o(navigableMap);
    }

    @s1.c
    public static <K, V> NavigableMap<K, V> E(NavigableMap<K, V> navigableMap, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        com.google.common.base.e0.E(g0Var);
        return navigableMap instanceof x ? I((x) navigableMap, g0Var) : new x((NavigableMap) com.google.common.base.e0.E(navigableMap), g0Var);
    }

    @s1.a
    public static <T, K extends Enum<K>, V> Collector<T, ?, v7<K, V>> E0(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.pb
            @Override // java.util.function.Supplier
            public final Object get() {
                return wb.b0();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.qb
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                wb.c0(function, function2, (wb.o) obj, obj2);
            }
        }, new rb(), new sb(), Collector.Characteristics.UNORDERED);
    }

    public static <K, V> SortedMap<K, V> F(SortedMap<K, V> sortedMap, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        com.google.common.base.e0.E(g0Var);
        return sortedMap instanceof y ? J((y) sortedMap, g0Var) : new y((SortedMap) com.google.common.base.e0.E(sortedMap), g0Var);
    }

    @s1.a
    public static <T, K extends Enum<K>, V> Collector<T, ?, v7<K, V>> F0(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2, final BinaryOperator<V> binaryOperator) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        com.google.common.base.e0.E(binaryOperator);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.tb
            @Override // java.util.function.Supplier
            public final Object get() {
                return wb.d0(binaryOperator);
            }
        }, new BiConsumer() { // from class: com.google.common.collect.ub
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                wb.e0(function, function2, (wb.o) obj, obj2);
            }
        }, new rb(), new sb(), new Collector.Characteristics[0]);
    }

    private static <K, V> com.google.common.collect.r0<K, V> G(v<K, V> vVar, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        return new v(vVar.l(), com.google.common.base.h0.d(vVar.f21336e, g0Var));
    }

    public static <K, V> v7<K, V> G0(Iterable<K> iterable, com.google.common.base.s<? super K, V> sVar) {
        return H0(iterable.iterator(), sVar);
    }

    private static <K, V> Map<K, V> H(n<K, V> nVar, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        return new w(nVar.f21335d, com.google.common.base.h0.d(nVar.f21336e, g0Var));
    }

    public static <K, V> v7<K, V> H0(Iterator<K> it, com.google.common.base.s<? super K, V> sVar) {
        com.google.common.base.e0.E(sVar);
        LinkedHashMap linkedHashMapM0 = m0();
        while (it.hasNext()) {
            K next = it.next();
            linkedHashMapM0.put(next, sVar.apply(next));
        }
        return v7.g(linkedHashMapM0);
    }

    @s1.c
    private static <K, V> NavigableMap<K, V> I(x<K, V> xVar, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        return new x(((x) xVar).f21368a, com.google.common.base.h0.d(((x) xVar).f21369b, g0Var));
    }

    static String I0(Map<?, ?> map) {
        StringBuilder sbF = h3.f(map.size());
        sbF.append('{');
        boolean z7 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z7) {
                sbF.append(", ");
            }
            sbF.append(entry.getKey());
            sbF.append('=');
            sbF.append(entry.getValue());
            z7 = false;
        }
        sbF.append('}');
        return sbF.toString();
    }

    private static <K, V> SortedMap<K, V> J(y<K, V> yVar, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        return new y(yVar.k(), com.google.common.base.h0.d(yVar.f21336e, g0Var));
    }

    public static <K, V1, V2> Map<K, V2> J0(Map<K, V1> map, u<? super K, ? super V1, V2> uVar) {
        return new j0(map, uVar);
    }

    public static <K, V> com.google.common.collect.r0<K, V> K(com.google.common.collect.r0<K, V> r0Var, com.google.common.base.g0<? super K> g0Var) {
        com.google.common.base.e0.E(g0Var);
        return C(r0Var, Z(g0Var));
    }

    @s1.c
    public static <K, V1, V2> NavigableMap<K, V2> K0(NavigableMap<K, V1> navigableMap, u<? super K, ? super V1, V2> uVar) {
        return new k0(navigableMap, uVar);
    }

    public static <K, V> Map<K, V> L(Map<K, V> map, com.google.common.base.g0<? super K> g0Var) {
        com.google.common.base.e0.E(g0Var);
        com.google.common.base.g0 g0VarZ = Z(g0Var);
        return map instanceof n ? H((n) map, g0VarZ) : new z((Map) com.google.common.base.e0.E(map), g0Var, g0VarZ);
    }

    public static <K, V1, V2> SortedMap<K, V2> L0(SortedMap<K, V1> sortedMap, u<? super K, ? super V1, V2> uVar) {
        return new l0(sortedMap, uVar);
    }

    @s1.c
    public static <K, V> NavigableMap<K, V> M(NavigableMap<K, V> navigableMap, com.google.common.base.g0<? super K> g0Var) {
        return E(navigableMap, Z(g0Var));
    }

    static <V2, K, V1> Map.Entry<K, V2> M0(u<? super K, ? super V1, V2> uVar, Map.Entry<K, V1> entry) {
        com.google.common.base.e0.E(uVar);
        com.google.common.base.e0.E(entry);
        return new c(entry, uVar);
    }

    public static <K, V> SortedMap<K, V> N(SortedMap<K, V> sortedMap, com.google.common.base.g0<? super K> g0Var) {
        return F(sortedMap, Z(g0Var));
    }

    public static <K, V1, V2> Map<K, V2> N0(Map<K, V1> map, com.google.common.base.s<? super V1, V2> sVar) {
        return J0(map, n(sVar));
    }

    public static <K, V> com.google.common.collect.r0<K, V> O(com.google.common.collect.r0<K, V> r0Var, com.google.common.base.g0<? super V> g0Var) {
        return C(r0Var, c1(g0Var));
    }

    @s1.c
    public static <K, V1, V2> NavigableMap<K, V2> O0(NavigableMap<K, V1> navigableMap, com.google.common.base.s<? super V1, V2> sVar) {
        return K0(navigableMap, n(sVar));
    }

    public static <K, V> Map<K, V> P(Map<K, V> map, com.google.common.base.g0<? super V> g0Var) {
        return D(map, c1(g0Var));
    }

    public static <K, V1, V2> SortedMap<K, V2> P0(SortedMap<K, V1> sortedMap, com.google.common.base.s<? super V1, V2> sVar) {
        return L0(sortedMap, n(sVar));
    }

    @s1.c
    public static <K, V> NavigableMap<K, V> Q(NavigableMap<K, V> navigableMap, com.google.common.base.g0<? super V> g0Var) {
        return E(navigableMap, c1(g0Var));
    }

    @u1.a
    public static <K, V> v7<K, V> Q0(Iterable<V> iterable, com.google.common.base.s<? super V, K> sVar) {
        return R0(iterable.iterator(), sVar);
    }

    public static <K, V> SortedMap<K, V> R(SortedMap<K, V> sortedMap, com.google.common.base.g0<? super V> g0Var) {
        return F(sortedMap, c1(g0Var));
    }

    @u1.a
    public static <K, V> v7<K, V> R0(Iterator<V> it, com.google.common.base.s<? super V, K> sVar) {
        com.google.common.base.e0.E(sVar);
        v7.b bVarB = v7.b();
        while (it.hasNext()) {
            V next = it.next();
            bVarB.f(sVar.apply(next), next);
        }
        try {
            return bVarB.a();
        } catch (IllegalArgumentException e8) {
            throw new IllegalArgumentException(e8.getMessage() + ". To index multiple values under a key, use Multimaps.index.");
        }
    }

    @s1.c
    public static v7<String, String> S(Properties properties) {
        v7.b bVarB = v7.b();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String str = (String) enumerationPropertyNames.nextElement();
            bVarB.f(str, properties.getProperty(str));
        }
        return bVarB.a();
    }

    public static <K, V> com.google.common.collect.r0<K, V> S0(com.google.common.collect.r0<? extends K, ? extends V> r0Var) {
        return new m0(r0Var, null);
    }

    @s1.b(serializable = true)
    public static <K, V> Map.Entry<K, V> T(K k7, V v7) {
        return new y6(k7, v7);
    }

    static <K, V> Map.Entry<K, V> T0(Map.Entry<? extends K, ? extends V> entry) {
        com.google.common.base.e0.E(entry);
        return new k(entry);
    }

    @s1.a
    @s1.b(serializable = true)
    public static <K extends Enum<K>, V> v7<K, V> U(Map<K, ? extends V> map) {
        if (map instanceof a7) {
            return (a7) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return v7.y();
        }
        Map.Entry<K, ? extends V> next = it.next();
        K key = next.getKey();
        V value = next.getValue();
        f2.a(key, value);
        EnumMap enumMap = new EnumMap(key.getDeclaringClass());
        enumMap.put((Enum) key, (Object) value);
        while (it.hasNext()) {
            Map.Entry<K, ? extends V> next2 = it.next();
            K key2 = next2.getKey();
            V value2 = next2.getValue();
            f2.a(key2, value2);
            enumMap.put((Enum) key2, (Object) value2);
        }
        return a7.M(enumMap);
    }

    static <K, V> ck<Map.Entry<K, V>> U0(Iterator<Map.Entry<K, V>> it) {
        return new l(it);
    }

    static <E> v7<E, Integer> V(Collection<E> collection) {
        v7.b bVar = new v7.b(collection.size());
        Iterator<E> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            bVar.f(it.next(), Integer.valueOf(i7));
            i7++;
        }
        return bVar.a();
    }

    static <K, V> Set<Map.Entry<K, V>> V0(Set<Map.Entry<K, V>> set) {
        return new o0(Collections.unmodifiableSet(set));
    }

    static <K> com.google.common.base.s<Map.Entry<K, ?>, K> W() {
        return s.f21354a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Map<K, V> W0(Map<K, ? extends V> map) {
        return map instanceof SortedMap ? Collections.unmodifiableSortedMap((SortedMap) map) : Collections.unmodifiableMap(map);
    }

    static <K, V> Iterator<K> X(Iterator<Map.Entry<K, V>> it) {
        return new e(it);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s1.c
    public static <K, V> NavigableMap<K, V> X0(NavigableMap<K, ? extends V> navigableMap) {
        com.google.common.base.e0.E(navigableMap);
        return navigableMap instanceof p0 ? navigableMap : new p0(navigableMap);
    }

    static <K> K Y(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Map.Entry<K, V> Y0(Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return T0(entry);
    }

    static <K> com.google.common.base.g0<Map.Entry<K, ?>> Z(com.google.common.base.g0<? super K> g0Var) {
        return com.google.common.base.h0.h(g0Var, W());
    }

    static <V> com.google.common.base.s<Map.Entry<?, V>, V> Z0() {
        return s.f21355b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a0(Object obj, Object obj2) {
        throw new IllegalArgumentException("Multiple values for key: " + obj + ", " + obj2);
    }

    static <K, V> Iterator<V> a1(Iterator<Map.Entry<K, V>> it) {
        return new f(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o b0() {
        return new o(new BinaryOperator() { // from class: com.google.common.collect.vb
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return wb.a0(obj, obj2);
            }
        });
    }

    static <V> V b1(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(Function function, Function function2, o oVar, Object obj) {
        oVar.b((Enum) com.google.common.base.e0.V(function.apply(obj), "Null key for input %s", obj), com.google.common.base.e0.V(function2.apply(obj), "Null value for input %s", obj));
    }

    static <V> com.google.common.base.g0<Map.Entry<?, V>> c1(com.google.common.base.g0<? super V> g0Var) {
        return com.google.common.base.h0.h(g0Var, Z0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o d0(BinaryOperator binaryOperator) {
        return new o(binaryOperator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(Function function, Function function2, o oVar, Object obj) {
        oVar.b((Enum) com.google.common.base.e0.V(function.apply(obj), "Null key for input %s", obj), com.google.common.base.e0.V(function2.apply(obj), "Null value for input %s", obj));
    }

    public static <K, V> ConcurrentMap<K, V> f0() {
        return new ConcurrentHashMap();
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> g0(Class<K> cls) {
        return new EnumMap<>((Class) com.google.common.base.e0.E(cls));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> h0(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> HashMap<K, V> i0() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> j0(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    @s1.a
    public static <A, B> com.google.common.base.i<A, B> k(com.google.common.collect.r0<A, B> r0Var) {
        return new q(r0Var);
    }

    public static <K, V> HashMap<K, V> k0(int i7) {
        return new HashMap<>(t(i7));
    }

    static <K, V1, V2> com.google.common.base.s<Map.Entry<K, V1>, Map.Entry<K, V2>> l(u<? super K, ? super V1, V2> uVar) {
        com.google.common.base.e0.E(uVar);
        return new d(uVar);
    }

    public static <K, V> IdentityHashMap<K, V> l0() {
        return new IdentityHashMap<>();
    }

    static <K, V1, V2> com.google.common.base.s<Map.Entry<K, V1>, V2> m(u<? super K, ? super V1, V2> uVar) {
        com.google.common.base.e0.E(uVar);
        return new b(uVar);
    }

    public static <K, V> LinkedHashMap<K, V> m0() {
        return new LinkedHashMap<>();
    }

    static <K, V1, V2> u<K, V1, V2> n(com.google.common.base.s<? super V1, V2> sVar) {
        com.google.common.base.e0.E(sVar);
        return new m(sVar);
    }

    public static <K, V> LinkedHashMap<K, V> n0(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> Map<K, V> o(Set<K> set, com.google.common.base.s<? super K, V> sVar) {
        return new p(set, sVar);
    }

    public static <K, V> LinkedHashMap<K, V> o0(int i7) {
        return new LinkedHashMap<>(t(i7));
    }

    @s1.c
    public static <K, V> NavigableMap<K, V> p(NavigableSet<K> navigableSet, com.google.common.base.s<? super K, V> sVar) {
        return new e0(navigableSet, sVar);
    }

    public static <K extends Comparable, V> TreeMap<K, V> p0() {
        return new TreeMap<>();
    }

    public static <K, V> SortedMap<K, V> q(SortedSet<K> sortedSet, com.google.common.base.s<? super K, V> sVar) {
        return new g0(sortedSet, sVar);
    }

    public static <C, K extends C, V> TreeMap<K, V> q0(Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    static <K, V> Iterator<Map.Entry<K, V>> r(Set<K> set, com.google.common.base.s<? super K, V> sVar) {
        return new g(set.iterator(), sVar);
    }

    public static <K, V> TreeMap<K, V> r0(SortedMap<K, ? extends V> sortedMap) {
        return new TreeMap<>((SortedMap) sortedMap);
    }

    static <K, V1, V2> com.google.common.base.s<V1, V2> s(u<? super K, V1, V2> uVar, K k7) {
        com.google.common.base.e0.E(uVar);
        return new a(uVar, k7);
    }

    static <E> Comparator<? super E> s0(Comparator<? super E> comparator) {
        return comparator != null ? comparator : td.A();
    }

    static int t(int i7) {
        if (i7 < 3) {
            f2.b(i7, "expectedSize");
            return i7 + 1;
        }
        if (i7 < 1073741824) {
            return (int) ((i7 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    static <K, V> void t0(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    static <K, V> boolean u(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(T0((Map.Entry) obj));
        }
        return false;
    }

    static <K, V> boolean u0(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(T0((Map.Entry) obj));
        }
        return false;
    }

    static boolean v(Map<?, ?> map, Object obj) {
        return ua.q(X(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @s1.c
    public static <E> NavigableSet<E> v0(NavigableSet<E> navigableSet) {
        return new j(navigableSet);
    }

    static boolean w(Map<?, ?> map, Object obj) {
        return ua.q(a1(map.entrySet().iterator()), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Set<E> w0(Set<E> set) {
        return new h(set);
    }

    public static <K, V> mb<K, V> x(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        return map instanceof SortedMap ? z((SortedMap) map, map2) : y(map, map2, com.google.common.base.l.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> SortedSet<E> x0(SortedSet<E> sortedSet) {
        return new i(sortedSet);
    }

    public static <K, V> mb<K, V> y(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, com.google.common.base.l<? super V> lVar) {
        com.google.common.base.e0.E(lVar);
        LinkedHashMap linkedHashMapM0 = m0();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
        LinkedHashMap linkedHashMapM1 = m0();
        LinkedHashMap linkedHashMapM2 = m0();
        A(map, map2, lVar, linkedHashMapM0, linkedHashMap, linkedHashMapM1, linkedHashMapM2);
        return new d0(linkedHashMapM0, linkedHashMap, linkedHashMapM1, linkedHashMapM2);
    }

    static boolean y0(Map<?, ?> map, Object obj) {
        com.google.common.base.e0.E(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <K, V> uf<K, V> z(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        com.google.common.base.e0.E(sortedMap);
        com.google.common.base.e0.E(map);
        Comparator comparatorS0 = s0(sortedMap.comparator());
        TreeMap treeMapQ0 = q0(comparatorS0);
        TreeMap treeMapQ1 = q0(comparatorS0);
        treeMapQ1.putAll(map);
        TreeMap treeMapQ2 = q0(comparatorS0);
        TreeMap treeMapQ3 = q0(comparatorS0);
        A(sortedMap, map, com.google.common.base.l.c(), treeMapQ0, treeMapQ1, treeMapQ2, treeMapQ3);
        return new i0(treeMapQ0, treeMapQ1, treeMapQ2, treeMapQ3);
    }

    static <V> V z0(Map<?, V> map, Object obj) {
        com.google.common.base.e0.E(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }
}
