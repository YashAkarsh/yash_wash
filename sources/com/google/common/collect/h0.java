package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class h0<R, C, V> implements oj<R, C, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Set<oj.a<R, C, V>> f20341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Collection<V> f20342b;

    class a extends uj<oj.a<R, C, V>, V> {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.uj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(oj.a<R, C, V> aVar) {
            return aVar.getValue();
        }
    }

    class b extends AbstractSet<oj.a<R, C, V>> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof oj.a)) {
                return false;
            }
            oj.a aVar = (oj.a) obj;
            Map map = (Map) wb.z0(h0.this.f(), aVar.b());
            return map != null && h3.j(map.entrySet(), wb.T(aVar.a(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<oj.a<R, C, V>> iterator() {
            return h0.this.a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof oj.a)) {
                return false;
            }
            oj.a aVar = (oj.a) obj;
            Map map = (Map) wb.z0(h0.this.f(), aVar.b());
            return map != null && h3.k(map.entrySet(), wb.T(aVar.a(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h0.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<oj.a<R, C, V>> spliterator() {
            return h0.this.b();
        }
    }

    class c extends AbstractCollection<V> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            h0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return h0.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return h0.this.e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return h0.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return h0.this.h();
        }
    }

    h0() {
    }

    @Override // com.google.common.collect.oj
    public Set<C> L() {
        return S().keySet();
    }

    @Override // com.google.common.collect.oj
    public boolean M(Object obj) {
        return wb.y0(f(), obj);
    }

    @Override // com.google.common.collect.oj
    public void O(oj<? extends R, ? extends C, ? extends V> ojVar) {
        for (oj.a<? extends R, ? extends C, ? extends V> aVar : ojVar.r()) {
            t(aVar.b(), aVar.a(), aVar.getValue());
        }
    }

    @Override // com.google.common.collect.oj
    public boolean P(Object obj, Object obj2) {
        Map map = (Map) wb.z0(f(), obj);
        return map != null && wb.y0(map, obj2);
    }

    abstract Iterator<oj.a<R, C, V>> a();

    abstract Spliterator<oj.a<R, C, V>> b();

    Set<oj.a<R, C, V>> c() {
        return new b();
    }

    @Override // com.google.common.collect.oj
    public void clear() {
        ua.h(r().iterator());
    }

    @Override // com.google.common.collect.oj
    public boolean containsValue(Object obj) {
        Iterator<Map<C, V>> it = f().values().iterator();
        while (it.hasNext()) {
            if (it.next().containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    Collection<V> d() {
        return new c();
    }

    Iterator<V> e() {
        return new a(r().iterator());
    }

    @Override // com.google.common.collect.oj
    public boolean equals(Object obj) {
        return sj.e(this, obj);
    }

    @Override // com.google.common.collect.oj
    public Set<R> g() {
        return f().keySet();
    }

    Spliterator<V> h() {
        return q2.e(b(), new Function() { // from class: com.google.common.collect.g0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((oj.a) obj).getValue();
            }
        });
    }

    @Override // com.google.common.collect.oj
    public int hashCode() {
        return r().hashCode();
    }

    @Override // com.google.common.collect.oj
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.oj
    public V k(Object obj, Object obj2) {
        Map map = (Map) wb.z0(f(), obj);
        if (map == null) {
            return null;
        }
        return (V) wb.z0(map, obj2);
    }

    @Override // com.google.common.collect.oj
    public boolean m(Object obj) {
        return wb.y0(S(), obj);
    }

    @Override // com.google.common.collect.oj
    public Set<oj.a<R, C, V>> r() {
        Set<oj.a<R, C, V>> set = this.f20341a;
        if (set != null) {
            return set;
        }
        Set<oj.a<R, C, V>> setC = c();
        this.f20341a = setC;
        return setC;
    }

    @Override // com.google.common.collect.oj
    @u1.a
    public V remove(Object obj, Object obj2) {
        Map map = (Map) wb.z0(f(), obj);
        if (map == null) {
            return null;
        }
        return (V) wb.A0(map, obj2);
    }

    @Override // com.google.common.collect.oj
    @u1.a
    public V t(R r7, C c8, V v7) {
        return X(r7).put(c8, v7);
    }

    public String toString() {
        return f().toString();
    }

    @Override // com.google.common.collect.oj
    public Collection<V> values() {
        Collection<V> collection = this.f20342b;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionD = d();
        this.f20342b = collectionD;
        return collectionD;
    }
}
