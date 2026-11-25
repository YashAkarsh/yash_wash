package com.google.common.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
class y4<K, V> extends x<K, V> implements d5<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final tc<K, V> f21430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final com.google.common.base.g0<? super Map.Entry<K, V>> f21431g;

    class a extends wb.s0<K, Collection<V>> {

        /* JADX INFO: renamed from: com.google.common.collect.y4$a$a, reason: collision with other inner class name */
        class C0258a extends wb.t<K, Collection<V>> {

            /* JADX INFO: renamed from: com.google.common.collect.y4$a$a$a, reason: collision with other inner class name */
            class C0259a extends e<Map.Entry<K, Collection<V>>> {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final Iterator<Map.Entry<K, Collection<V>>> f21434c;

                C0259a() {
                    this.f21434c = y4.this.f21430f.asMap().entrySet().iterator();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.e
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, Collection<V>> a() {
                    while (this.f21434c.hasNext()) {
                        Map.Entry<K, Collection<V>> next = this.f21434c.next();
                        K key = next.getKey();
                        Collection collectionN = y4.n(next.getValue(), new c(key));
                        if (!collectionN.isEmpty()) {
                            return wb.T(key, collectionN);
                        }
                    }
                    return b();
                }
            }

            C0258a() {
            }

            @Override // com.google.common.collect.wb.t
            Map<K, Collection<V>> g() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C0259a();
            }

            @Override // com.google.common.collect.wb.t, com.google.common.collect.af.l, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return y4.this.o(com.google.common.base.h0.n(collection));
            }

            @Override // com.google.common.collect.wb.t, com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return y4.this.o(com.google.common.base.h0.q(com.google.common.base.h0.n(collection)));
            }

            @Override // com.google.common.collect.wb.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return ua.Z(iterator());
            }
        }

        class b extends wb.c0<K, Collection<V>> {
            b() {
                super(a.this);
            }

            @Override // com.google.common.collect.wb.c0, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return a.this.remove(obj) != null;
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return y4.this.o(wb.Z(com.google.common.base.h0.n(collection)));
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return y4.this.o(wb.Z(com.google.common.base.h0.q(com.google.common.base.h0.n(collection))));
            }
        }

        class c extends wb.r0<K, Collection<V>> {
            c() {
                super(a.this);
            }

            @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                if (!(obj instanceof Collection)) {
                    return false;
                }
                Collection collection = (Collection) obj;
                Iterator<Map.Entry<K, Collection<V>>> it = y4.this.f21430f.asMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<K, Collection<V>> next = it.next();
                    Collection collectionN = y4.n(next.getValue(), new c(next.getKey()));
                    if (!collectionN.isEmpty() && collection.equals(collectionN)) {
                        if (collectionN.size() == next.getValue().size()) {
                            it.remove();
                            return true;
                        }
                        collectionN.clear();
                        return true;
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return y4.this.o(wb.c1(com.google.common.base.h0.n(collection)));
            }

            @Override // com.google.common.collect.wb.r0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return y4.this.o(wb.c1(com.google.common.base.h0.q(com.google.common.base.h0.n(collection))));
            }
        }

        a() {
        }

        @Override // com.google.common.collect.wb.s0
        Set<Map.Entry<K, Collection<V>>> a() {
            return new C0258a();
        }

        @Override // com.google.common.collect.wb.s0
        /* JADX INFO: renamed from: b */
        Set<K> g() {
            return new b();
        }

        @Override // com.google.common.collect.wb.s0
        Collection<Collection<V>> c() {
            return new c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            y4.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            Collection<V> collection = y4.this.f21430f.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> collectionN = y4.n(collection, new c(obj));
            if (collectionN.isEmpty()) {
                return null;
            }
            return collectionN;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            Collection<V> collection = y4.this.f21430f.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList arrayListQ = ib.q();
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                V next = it.next();
                if (y4.this.p(obj, next)) {
                    it.remove();
                    arrayListQ.add(next);
                }
            }
            if (arrayListQ.isEmpty()) {
                return null;
            }
            return y4.this.f21430f instanceof ue ? Collections.unmodifiableSet(af.B(arrayListQ)) : Collections.unmodifiableList(arrayListQ);
        }
    }

    class b extends cd.g<K, V> {

        class a extends md.i<K> {

            /* JADX INFO: renamed from: com.google.common.collect.y4$b$a$a, reason: collision with other inner class name */
            class C0260a implements com.google.common.base.g0<Map.Entry<K, Collection<V>>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ com.google.common.base.g0 f21440a;

                C0260a(com.google.common.base.g0 g0Var) {
                    this.f21440a = g0Var;
                }

                @Override // com.google.common.base.g0
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean apply(Map.Entry<K, Collection<V>> entry) {
                    return this.f21440a.apply(md.m(entry.getKey(), entry.getValue().size()));
                }

                @Override // com.google.common.base.g0, java.util.function.Predicate
                public /* synthetic */ boolean test(Object obj) {
                    return com.google.common.base.f0.a(this, obj);
                }
            }

            a() {
            }

            private boolean h(com.google.common.base.g0<? super hd.a<K>> g0Var) {
                return y4.this.o(new C0260a(g0Var));
            }

            @Override // com.google.common.collect.md.i
            hd<K> g() {
                return b.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<hd.a<K>> iterator() {
                return b.this.g();
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return h(com.google.common.base.h0.n(collection));
            }

            @Override // com.google.common.collect.af.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return h(com.google.common.base.h0.q(com.google.common.base.h0.n(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return y4.this.keySet().size();
            }
        }

        b() {
            super(y4.this);
        }

        @Override // com.google.common.collect.y, com.google.common.collect.hd
        public Set<hd.a<K>> entrySet() {
            return new a();
        }

        @Override // com.google.common.collect.cd.g, com.google.common.collect.y, com.google.common.collect.hd
        public int remove(Object obj, int i7) {
            f2.b(i7, "occurrences");
            if (i7 == 0) {
                return l0(obj);
            }
            Collection<V> collection = y4.this.f21430f.asMap().get(obj);
            int i8 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                if (y4.this.p(obj, it.next()) && (i8 = i8 + 1) <= i7) {
                    it.remove();
                }
            }
            return i8;
        }
    }

    final class c implements com.google.common.base.g0<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f21442a;

        c(K k7) {
            this.f21442a = k7;
        }

        @Override // com.google.common.base.g0
        public boolean apply(V v7) {
            return y4.this.p(this.f21442a, v7);
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return com.google.common.base.f0.a(this, obj);
        }
    }

    y4(tc<K, V> tcVar, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        this.f21430f = (tc) com.google.common.base.e0.E(tcVar);
        this.f21431g = (com.google.common.base.g0) com.google.common.base.e0.E(g0Var);
    }

    static <E> Collection<E> n(Collection<E> collection, com.google.common.base.g0<? super E> g0Var) {
        return collection instanceof Set ? af.i((Set) collection, g0Var) : h3.d(collection, g0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(K k7, V v7) {
        return this.f21431g.apply(wb.T(k7, v7));
    }

    @Override // com.google.common.collect.d5
    public com.google.common.base.g0<? super Map.Entry<K, V>> D() {
        return this.f21431g;
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    public Collection<V> a(Object obj) {
        return (Collection) com.google.common.base.x.a(asMap().remove(obj), q());
    }

    @Override // com.google.common.collect.x
    Map<K, Collection<V>> c() {
        return new a();
    }

    @Override // com.google.common.collect.tc
    public void clear() {
        y().clear();
    }

    @Override // com.google.common.collect.tc
    public boolean containsKey(Object obj) {
        return asMap().get(obj) != null;
    }

    @Override // com.google.common.collect.d5
    public tc<K, V> d() {
        return this.f21430f;
    }

    @Override // com.google.common.collect.x
    Collection<Map.Entry<K, V>> e() {
        return n(this.f21430f.y(), this.f21431g);
    }

    @Override // com.google.common.collect.x
    Set<K> f() {
        return asMap().keySet();
    }

    @Override // com.google.common.collect.x
    hd<K> g() {
        return new b();
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    public Collection<V> get(K k7) {
        return n(this.f21430f.get(k7), new c(k7));
    }

    @Override // com.google.common.collect.x
    Collection<V> h() {
        return new e5(this);
    }

    @Override // com.google.common.collect.x
    Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    boolean o(com.google.common.base.g0<? super Map.Entry<K, Collection<V>>> g0Var) {
        Iterator<Map.Entry<K, Collection<V>>> it = this.f21430f.asMap().entrySet().iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            Map.Entry<K, Collection<V>> next = it.next();
            K key = next.getKey();
            Collection collectionN = n(next.getValue(), new c(key));
            if (!collectionN.isEmpty() && g0Var.apply(wb.T(key, collectionN))) {
                if (collectionN.size() == next.getValue().size()) {
                    it.remove();
                } else {
                    collectionN.clear();
                }
                z7 = true;
            }
        }
        return z7;
    }

    Collection<V> q() {
        return this.f21430f instanceof ue ? Collections.emptySet() : Collections.emptyList();
    }

    @Override // com.google.common.collect.tc
    public int size() {
        return y().size();
    }
}
