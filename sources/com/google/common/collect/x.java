package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class x<K, V> implements tc<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Collection<Map.Entry<K, V>> f21387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Set<K> f21388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient hd<K> f21389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Collection<V> f21390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient Map<K, Collection<V>> f21391e;

    class a extends cd.f<K, V> {
        a() {
        }

        @Override // com.google.common.collect.cd.f
        tc<K, V> a() {
            return x.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return x.this.i();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return x.this.j();
        }
    }

    class b extends x<K, V>.a implements Set<Map.Entry<K, V>> {
        b() {
            super();
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

    class c extends AbstractCollection<V> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            x.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return x.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return x.this.k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return x.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return x.this.l();
        }
    }

    x() {
    }

    @Override // com.google.common.collect.tc
    @u1.a
    public boolean H(tc<? extends K, ? extends V> tcVar) {
        boolean zPut = false;
        for (Map.Entry<? extends K, ? extends V> entry : tcVar.entries()) {
            zPut |= put(entry.getKey(), entry.getValue());
        }
        return zPut;
    }

    @Override // com.google.common.collect.tc
    public boolean W(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // com.google.common.collect.tc
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.f21391e;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapC = c();
        this.f21391e = mapC;
        return mapC;
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public Collection<V> b(K k7, Iterable<? extends V> iterable) {
        com.google.common.base.e0.E(iterable);
        Collection<V> collectionA = a(k7);
        putAll(k7, iterable);
        return collectionA;
    }

    abstract Map<K, Collection<V>> c();

    @Override // com.google.common.collect.tc
    public boolean containsValue(Object obj) {
        Iterator<Collection<V>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Collection<Map.Entry<K, V>> e();

    @Override // com.google.common.collect.tc, com.google.common.collect.ue
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.f21387a;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> collectionE = e();
        this.f21387a = collectionE;
        return collectionE;
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.ue
    public boolean equals(Object obj) {
        return cd.k(this, obj);
    }

    abstract Set<K> f();

    @Override // com.google.common.collect.tc
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        sc.a(this, biConsumer);
    }

    abstract hd<K> g();

    abstract Collection<V> h();

    @Override // com.google.common.collect.tc
    public int hashCode() {
        return asMap().hashCode();
    }

    abstract Iterator<Map.Entry<K, V>> i();

    @Override // com.google.common.collect.tc
    public boolean isEmpty() {
        return size() == 0;
    }

    Spliterator<Map.Entry<K, V>> j() {
        return Spliterators.spliterator(i(), size(), this instanceof ue ? 1 : 0);
    }

    Iterator<V> k() {
        return wb.a1(entries().iterator());
    }

    @Override // com.google.common.collect.tc
    public Set<K> keySet() {
        Set<K> set = this.f21388b;
        if (set != null) {
            return set;
        }
        Set<K> setF = f();
        this.f21388b = setF;
        return setF;
    }

    @Override // com.google.common.collect.tc
    public hd<K> keys() {
        hd<K> hdVar = this.f21389c;
        if (hdVar != null) {
            return hdVar;
        }
        hd<K> hdVarG = g();
        this.f21389c = hdVarG;
        return hdVarG;
    }

    Spliterator<V> l() {
        return Spliterators.spliterator(k(), size(), 0);
    }

    @Override // com.google.common.collect.tc
    @u1.a
    public boolean put(K k7, V v7) {
        return get(k7).add(v7);
    }

    @Override // com.google.common.collect.tc
    @u1.a
    public boolean putAll(K k7, Iterable<? extends V> iterable) {
        com.google.common.base.e0.E(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k7).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && ua.a(get(k7), it);
    }

    @Override // com.google.common.collect.tc
    @u1.a
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return asMap().toString();
    }

    @Override // com.google.common.collect.tc
    public Collection<V> values() {
        Collection<V> collection = this.f21390d;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionH = h();
        this.f21390d = collectionH;
        return collectionH;
    }
}
