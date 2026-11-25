package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public abstract class h8<K, V> extends p0<K, V> implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f20368h = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient v7<K, ? extends x6<V>> f20369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient int f20370g;

    class a extends ck<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<? extends Map.Entry<K, ? extends x6<V>>> f20371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        K f20372b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Iterator<V> f20373c = ua.u();

        a() {
            this.f20371a = h8.this.f20369f.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!this.f20373c.hasNext()) {
                Map.Entry<K, ? extends x6<V>> next = this.f20371a.next();
                this.f20372b = next.getKey();
                this.f20373c = next.getValue().iterator();
            }
            return wb.T(this.f20372b, this.f20373c.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20373c.hasNext() || this.f20371a.hasNext();
        }
    }

    class b extends ck<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Iterator<? extends x6<V>> f20375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Iterator<V> f20376b = ua.u();

        b() {
            this.f20375a = h8.this.f20369f.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20376b.hasNext() || this.f20375a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.f20376b.hasNext()) {
                this.f20376b = this.f20375a.next().iterator();
            }
            return this.f20376b.next();
        }
    }

    public static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<K, Collection<V>> f20378a = vd.h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Comparator<? super K> f20379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Comparator<? super V> f20380c;

        public h8<K, V> a() {
            Collection collectionEntrySet = this.f20378a.entrySet();
            Comparator<? super K> comparator = this.f20379b;
            if (comparator != null) {
                collectionEntrySet = td.i(comparator).D().l(collectionEntrySet);
            }
            return q7.f0(collectionEntrySet, this.f20380c);
        }

        @u1.a
        c<K, V> b(c<K, V> cVar) {
            for (Map.Entry<K, Collection<V>> entry : cVar.f20378a.entrySet()) {
                j(entry.getKey(), entry.getValue());
            }
            return this;
        }

        Collection<V> c() {
            return new ArrayList();
        }

        @u1.a
        public c<K, V> d(Comparator<? super K> comparator) {
            this.f20379b = (Comparator) com.google.common.base.e0.E(comparator);
            return this;
        }

        @u1.a
        public c<K, V> e(Comparator<? super V> comparator) {
            this.f20380c = (Comparator) com.google.common.base.e0.E(comparator);
            return this;
        }

        @u1.a
        public c<K, V> f(K k7, V v7) {
            f2.a(k7, v7);
            Collection<V> collection = this.f20378a.get(k7);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f20378a;
                Collection<V> collectionC = c();
                map.put(k7, collectionC);
                collection = collectionC;
            }
            collection.add(v7);
            return this;
        }

        @u1.a
        public c<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        @u1.a
        public c<K, V> h(tc<? extends K, ? extends V> tcVar) {
            for (Map.Entry<? extends K, Collection<? extends V>> entry : tcVar.asMap().entrySet()) {
                j(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @s1.a
        @u1.a
        public c<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        @u1.a
        public c<K, V> j(K k7, Iterable<? extends V> iterable) {
            if (k7 == null) {
                throw new NullPointerException("null key in entry: null=" + ma.R(iterable));
            }
            Collection<V> collection = this.f20378a.get(k7);
            if (collection != null) {
                for (V v7 : iterable) {
                    f2.a(k7, v7);
                    collection.add(v7);
                }
                return this;
            }
            Iterator<? extends V> it = iterable.iterator();
            if (!it.hasNext()) {
                return this;
            }
            Collection<V> collectionC = c();
            while (it.hasNext()) {
                V next = it.next();
                f2.a(k7, next);
                collectionC.add(next);
            }
            this.f20378a.put(k7, collectionC);
            return this;
        }

        @u1.a
        public c<K, V> k(K k7, V... vArr) {
            return j(k7, Arrays.asList(vArr));
        }
    }

    private static class d<K, V> extends x6<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f20381d = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @y1.i
        final h8<K, V> f20382c;

        d(h8<K, V> h8Var) {
            this.f20382c = h8Var;
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f20382c.W(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return this.f20382c.C();
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public ck<Map.Entry<K, V>> iterator() {
            return this.f20382c.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f20382c.size();
        }
    }

    @s1.c
    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final se.b<h8> f20383a = se.a(h8.class, "map");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final se.b<h8> f20384b = se.a(h8.class, "size");

        e() {
        }
    }

    class f extends p8<K> {
        f() {
        }

        @Override // com.google.common.collect.p8
        hd.a<K> A(int i7) {
            Map.Entry<K, ? extends x6<V>> entry = h8.this.f20369f.entrySet().a().get(i7);
            return md.m(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.common.collect.p8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h8.this.containsKey(obj);
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // com.google.common.collect.hd
        public int l0(Object obj) {
            x6<V> x6Var = h8.this.f20369f.get(obj);
            if (x6Var == null) {
                return 0;
            }
            return x6Var.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
        public int size() {
            return h8.this.size();
        }

        @Override // com.google.common.collect.p8, com.google.common.collect.x6
        @s1.c
        Object writeReplace() {
            return new g(h8.this);
        }

        @Override // com.google.common.collect.p8, com.google.common.collect.hd
        /* JADX INFO: renamed from: x */
        public u8<K> e() {
            return h8.this.keySet();
        }
    }

    @s1.c
    private static final class g implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h8<?, ?> f20386a;

        g(h8<?, ?> h8Var) {
            this.f20386a = h8Var;
        }

        Object readResolve() {
            return this.f20386a.keys();
        }
    }

    private static final class h<K, V> extends x6<V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f20387d = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @y1.i
        private final transient h8<K, V> f20388c;

        h(h8<K, V> h8Var) {
            this.f20388c = h8Var;
        }

        @Override // com.google.common.collect.x6
        @s1.c
        int b(Object[] objArr, int i7) {
            ck<? extends x6<V>> it = this.f20388c.f20369f.values().iterator();
            while (it.hasNext()) {
                i7 = it.next().b(objArr, i7);
            }
            return i7;
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f20388c.containsValue(obj);
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public ck<V> iterator() {
            return this.f20388c.k();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f20388c.size();
        }
    }

    h8(v7<K, ? extends x6<V>> v7Var, int i7) {
        this.f20369f = v7Var;
        this.f20370g = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator I(Map.Entry entry) {
        final Object key = entry.getKey();
        return q2.e(((Collection) entry.getValue()).spliterator(), new Function() { // from class: com.google.common.collect.f8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return wb.T(key, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(final BiConsumer biConsumer, final Object obj, Collection collection) {
        collection.forEach(new Consumer() { // from class: com.google.common.collect.g8
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                biConsumer.accept(obj, obj2);
            }
        });
    }

    public static <K, V> h8<K, V> M() {
        return q7.m0();
    }

    public static <K, V> h8<K, V> N(K k7, V v7) {
        return q7.n0(k7, v7);
    }

    public static <K, V> h8<K, V> O(K k7, V v7, K k8, V v8) {
        return q7.o0(k7, v7, k8, v8);
    }

    public static <K, V> h8<K, V> P(K k7, V v7, K k8, V v8, K k9, V v9) {
        return q7.p0(k7, v7, k8, v8, k9, v9);
    }

    public static <K, V> h8<K, V> R(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return q7.q0(k7, v7, k8, v8, k9, v9, k10, v10);
    }

    public static <K, V> h8<K, V> S(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        return q7.r0(k7, v7, k8, v8, k9, v9, k10, v10, k11, v11);
    }

    public static <K, V> c<K, V> r() {
        return new c<>();
    }

    public static <K, V> h8<K, V> t(tc<? extends K, ? extends V> tcVar) {
        if (tcVar instanceof h8) {
            h8<K, V> h8Var = (h8) tcVar;
            if (!h8Var.C()) {
                return h8Var;
            }
        }
        return q7.c0(tcVar);
    }

    @s1.a
    public static <K, V> h8<K, V> u(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return q7.d0(iterable);
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    /* JADX INFO: renamed from: A */
    public abstract x6<V> get(K k7);

    public abstract h8<V, K> B();

    boolean C() {
        return this.f20369f.r();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public u8<K> keySet() {
        return this.f20369f.keySet();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public p8<K> keys() {
        return (p8) super.keys();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    @Deprecated
    public boolean H(tc<? extends K, ? extends V> tcVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    @Deprecated
    /* JADX INFO: renamed from: T */
    public x6<V> a(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    @Deprecated
    /* JADX INFO: renamed from: U */
    public x6<V> b(K k7, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.x
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public ck<V> k() {
        return new b();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean W(Object obj, Object obj2) {
        return super.W(obj, obj2);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public x6<V> values() {
        return (x6) super.values();
    }

    @Override // com.google.common.collect.x
    Map<K, Collection<V>> c() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.tc
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.tc
    public boolean containsKey(Object obj) {
        return this.f20369f.containsKey(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.x
    Set<K> f() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        asMap().forEach(new BiConsumer() { // from class: com.google.common.collect.d8
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                h8.J(biConsumer, obj, (Collection) obj2);
            }
        });
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.x
    Spliterator<Map.Entry<K, V>> j() {
        return q2.b(asMap().entrySet().spliterator(), new Function() { // from class: com.google.common.collect.e8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return h8.I((Map.Entry) obj);
            }
        }, (this instanceof ue ? 1 : 0) | 64, size());
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    @Deprecated
    public boolean put(K k7, V v7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    @Deprecated
    public boolean putAll(K k7, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public v7<K, Collection<V>> asMap() {
        return this.f20369f;
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.tc
    public int size() {
        return this.f20370g;
    }

    @Override // com.google.common.collect.x
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.x
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public x6<Map.Entry<K, V>> e() {
        return new d(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.x
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public p8<K> g() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.x
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public x6<V> h() {
        return new h(this);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    public x6<Map.Entry<K, V>> y() {
        return (x6) super.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.x
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public ck<Map.Entry<K, V>> i() {
        return new a();
    }
}
