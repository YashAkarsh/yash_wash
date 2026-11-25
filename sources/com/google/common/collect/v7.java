package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public abstract class v7<K, V> implements Map<K, V>, Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Map.Entry<?, ?>[] f21264e = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @v1.b
    private transient u8<Map.Entry<K, V>> f21265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @v1.b
    private transient u8<K> f21266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @v1.b
    private transient x6<V> f21267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @v1.b
    private transient e9<K, V> f21268d;

    class a extends ck<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ck f21269a;

        a(ck ckVar) {
            this.f21269a = ckVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21269a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f21269a.next()).getKey();
        }
    }

    public static class b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Comparator<? super V> f21271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map.Entry<K, V>[] f21272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f21274d;

        public b() {
            this(4);
        }

        private void d(int i7) {
            Map.Entry<K, V>[] entryArr = this.f21272b;
            if (i7 > entryArr.length) {
                this.f21272b = (Map.Entry[]) Arrays.copyOf(entryArr, x6.a.f(entryArr.length, i7));
                this.f21274d = false;
            }
        }

        public v7<K, V> a() {
            if (this.f21271a != null) {
                if (this.f21274d) {
                    this.f21272b = (Map.Entry[]) Arrays.copyOf(this.f21272b, this.f21273c);
                }
                Arrays.sort(this.f21272b, 0, this.f21273c, td.i(this.f21271a).E(wb.Z0()));
            }
            int i7 = this.f21273c;
            if (i7 == 0) {
                return v7.y();
            }
            if (i7 == 1) {
                return v7.z(this.f21272b[0].getKey(), this.f21272b[0].getValue());
            }
            this.f21274d = true;
            return ie.M(i7, this.f21272b);
        }

        @s1.d
        v7<K, V> b() {
            com.google.common.base.e0.h0(this.f21271a == null, "buildJdkBacked is only for testing; can't use valueComparator");
            int i7 = this.f21273c;
            if (i7 == 0) {
                return v7.y();
            }
            if (i7 == 1) {
                return v7.z(this.f21272b[0].getKey(), this.f21272b[0].getValue());
            }
            this.f21274d = true;
            return xa.L(i7, this.f21272b);
        }

        @u1.a
        b<K, V> c(b<K, V> bVar) {
            com.google.common.base.e0.E(bVar);
            d(this.f21273c + bVar.f21273c);
            System.arraycopy(bVar.f21272b, 0, this.f21272b, this.f21273c, bVar.f21273c);
            this.f21273c += bVar.f21273c;
            return this;
        }

        @s1.a
        @u1.a
        public b<K, V> e(Comparator<? super V> comparator) {
            com.google.common.base.e0.h0(this.f21271a == null, "valueComparator was already set");
            this.f21271a = (Comparator) com.google.common.base.e0.F(comparator, "valueComparator");
            return this;
        }

        @u1.a
        public b<K, V> f(K k7, V v7) {
            d(this.f21273c + 1);
            Map.Entry<K, V> entryN = v7.n(k7, v7);
            Map.Entry<K, V>[] entryArr = this.f21272b;
            int i7 = this.f21273c;
            this.f21273c = i7 + 1;
            entryArr[i7] = entryN;
            return this;
        }

        @u1.a
        public b<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        @s1.a
        @u1.a
        public b<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                d(this.f21273c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        @u1.a
        public b<K, V> i(Map<? extends K, ? extends V> map) {
            return h(map.entrySet());
        }

        b(int i7) {
            this.f21272b = new Map.Entry[i7];
            this.f21273c = 0;
            this.f21274d = false;
        }
    }

    static abstract class c<K, V> extends v7<K, V> {

        class a extends x7<K, V> {
            a() {
            }

            @Override // com.google.common.collect.x7
            v7<K, V> M() {
                return c.this;
            }

            @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: j */
            public ck<Map.Entry<K, V>> iterator() {
                return c.this.K();
            }
        }

        c() {
        }

        abstract ck<Map.Entry<K, V>> K();

        Spliterator<Map.Entry<K, V>> L() {
            return Spliterators.spliterator(K(), size(), 1297);
        }

        @Override // com.google.common.collect.v7, java.util.Map, java.util.SortedMap
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.v7
        u8<Map.Entry<K, V>> k() {
            return new a();
        }

        @Override // com.google.common.collect.v7, java.util.Map, java.util.SortedMap
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.v7
        u8<K> l() {
            return new z7(this);
        }

        @Override // com.google.common.collect.v7
        x6<V> m() {
            return new c8(this);
        }

        @Override // com.google.common.collect.v7, java.util.Map, java.util.SortedMap
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    private final class d extends c<K, u8<V>> {

        class a extends ck<Map.Entry<K, u8<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator f21277a;

            /* JADX INFO: renamed from: com.google.common.collect.v7$d$a$a, reason: collision with other inner class name */
            class C0255a extends v<K, u8<V>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Map.Entry f21279a;

                C0255a(Map.Entry entry) {
                    this.f21279a = entry;
                }

                @Override // com.google.common.collect.v, java.util.Map.Entry
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public u8<V> getValue() {
                    return u8.B(this.f21279a.getValue());
                }

                @Override // com.google.common.collect.v, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f21279a.getKey();
                }
            }

            a(Iterator it) {
                this.f21277a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, u8<V>> next() {
                return new C0255a((Map.Entry) this.f21277a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f21277a.hasNext();
            }
        }

        private d() {
        }

        @Override // com.google.common.collect.v7.c
        ck<Map.Entry<K, u8<V>>> K() {
            return new a(v7.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.v7, java.util.Map
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public u8<V> get(Object obj) {
            Object obj2 = v7.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return u8.B(obj2);
        }

        @Override // com.google.common.collect.v7, java.util.Map
        public boolean containsKey(Object obj) {
            return v7.this.containsKey(obj);
        }

        @Override // com.google.common.collect.v7, java.util.Map
        public int hashCode() {
            return v7.this.hashCode();
        }

        @Override // com.google.common.collect.v7.c, com.google.common.collect.v7
        u8<K> l() {
            return v7.this.keySet();
        }

        @Override // com.google.common.collect.v7
        boolean q() {
            return v7.this.q();
        }

        @Override // com.google.common.collect.v7
        boolean r() {
            return v7.this.r();
        }

        @Override // java.util.Map
        public int size() {
            return v7.this.size();
        }

        /* synthetic */ d(v7 v7Var, a aVar) {
            this();
        }
    }

    static class e implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f21281c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f21282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object[] f21283b;

        e(v7<?, ?> v7Var) {
            this.f21282a = new Object[v7Var.size()];
            this.f21283b = new Object[v7Var.size()];
            ck<Map.Entry<?, ?>> it = v7Var.entrySet().iterator();
            int i7 = 0;
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                this.f21282a[i7] = next.getKey();
                this.f21283b[i7] = next.getValue();
                i7++;
            }
        }

        Object a(b<Object, Object> bVar) {
            int i7 = 0;
            while (true) {
                Object[] objArr = this.f21282a;
                if (i7 >= objArr.length) {
                    return bVar.a();
                }
                bVar.f(objArr[i7], this.f21283b[i7]);
                i7++;
            }
        }

        Object readResolve() {
            return a(new b<>(this.f21282a.length));
        }
    }

    v7() {
    }

    public static <K, V> v7<K, V> B(K k7, V v7, K k8, V v8) {
        return ie.L(n(k7, v7), n(k8, v8));
    }

    public static <K, V> v7<K, V> C(K k7, V v7, K k8, V v8, K k9, V v9) {
        return ie.L(n(k7, v7), n(k8, v8), n(k9, v9));
    }

    public static <K, V> v7<K, V> D(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return ie.L(n(k7, v7), n(k8, v8), n(k9, v9), n(k10, v10));
    }

    public static <K, V> v7<K, V> E(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        return ie.L(n(k7, v7), n(k8, v8), n(k9, v9), n(k10, v10), n(k11, v11));
    }

    @s1.a
    public static <T, K, V> Collector<T, ?, v7<K, V>> H(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return e2.o(function, function2);
    }

    @s1.a
    public static <T, K, V> Collector<T, ?, v7<K, V>> I(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        com.google.common.base.e0.E(binaryOperator);
        return Collectors.collectingAndThen(Collectors.toMap(function, function2, binaryOperator, new Supplier() { // from class: com.google.common.collect.s7
            @Override // java.util.function.Supplier
            public final Object get() {
                return new LinkedHashMap();
            }
        }), new Function() { // from class: com.google.common.collect.t7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return v7.g((LinkedHashMap) obj);
            }
        });
    }

    public static <K, V> b<K, V> b() {
        return new b<>();
    }

    @s1.a
    public static <K, V> b<K, V> c(int i7) {
        f2.b(i7, "expectedSize");
        return new b<>(i7);
    }

    static void d(boolean z7, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!z7) {
            throw e(str, entry, entry2);
        }
    }

    static IllegalArgumentException e(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    @s1.a
    public static <K, V> v7<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) ma.P(iterable, f21264e);
        int length = entryArr.length;
        if (length == 0) {
            return y();
        }
        if (length != 1) {
            return ie.L(entryArr);
        }
        Map.Entry entry = entryArr[0];
        return z(entry.getKey(), entry.getValue());
    }

    public static <K, V> v7<K, V> g(Map<? extends K, ? extends V> map) {
        if ((map instanceof v7) && !(map instanceof SortedMap)) {
            v7<K, V> v7Var = (v7) map;
            if (!v7Var.r()) {
                return v7Var;
            }
        } else if (map instanceof EnumMap) {
            return i((EnumMap) map);
        }
        return f(map.entrySet());
    }

    private static <K extends Enum<K>, V> v7<K, V> i(EnumMap<K, ? extends V> enumMap) {
        EnumMap enumMap2 = new EnumMap((EnumMap) enumMap);
        for (Map.Entry<K, V> entry : enumMap2.entrySet()) {
            f2.a(entry.getKey(), entry.getValue());
        }
        return a7.M(enumMap2);
    }

    static <K, V> Map.Entry<K, V> n(K k7, V v7) {
        f2.a(k7, v7);
        return new AbstractMap.SimpleImmutableEntry(k7, v7);
    }

    public static <K, V> v7<K, V> y() {
        return (v7<K, V>) ie.f20444i;
    }

    public static <K, V> v7<K, V> z(K k7, V v7) {
        return u6.S(k7, v7);
    }

    @Override // java.util.Map, java.util.SortedMap
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public x6<V> values() {
        x6<V> x6Var = this.f21267c;
        if (x6Var != null) {
            return x6Var;
        }
        x6<V> x6VarM = m();
        this.f21267c = x6VarM;
        return x6VarM;
    }

    public e9<K, V> a() {
        if (isEmpty()) {
            return e9.p0();
        }
        e9<K, V> e9Var = this.f21268d;
        if (e9Var != null) {
            return e9Var;
        }
        e9<K, V> e9Var2 = new e9<>(new d(this, null), size(), null);
        this.f21268d = e9Var2;
        return e9Var2;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V compute(K k7, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfAbsent(K k7, Function<? super K, ? extends V> function) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfPresent(K k7, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return wb.B(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v7) {
        V v8 = get(obj);
        return v8 != null ? v8 : v7;
    }

    @Override // java.util.Map
    public int hashCode() {
        return af.k(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    abstract u8<Map.Entry<K, V>> k();

    abstract u8<K> l();

    abstract x6<V> m();

    @Override // java.util.Map
    @Deprecated
    public final V merge(K k7, V v7, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, java.util.SortedMap
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public u8<Map.Entry<K, V>> entrySet() {
        u8<Map.Entry<K, V>> u8Var = this.f21265a;
        if (u8Var != null) {
            return u8Var;
        }
        u8<Map.Entry<K, V>> u8VarK = k();
        this.f21265a = u8VarK;
        return u8VarK;
    }

    @Override // java.util.Map
    @u1.a
    @Deprecated
    public final V put(K k7, V v7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @u1.a
    @Deprecated
    public final V putIfAbsent(K k7, V v7) {
        throw new UnsupportedOperationException();
    }

    boolean q() {
        return false;
    }

    abstract boolean r();

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean replace(K k7, V v7, V v8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    ck<K> t() {
        return new a(entrySet().iterator());
    }

    public String toString() {
        return wb.I0(this);
    }

    @Override // java.util.Map, java.util.SortedMap
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public u8<K> keySet() {
        u8<K> u8Var = this.f21266b;
        if (u8Var != null) {
            return u8Var;
        }
        u8<K> u8VarL = l();
        this.f21266b = u8VarL;
        return u8VarL;
    }

    Spliterator<K> w() {
        return q2.e(entrySet().spliterator(), new u7());
    }

    Object writeReplace() {
        return new e(this);
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V replace(K k7, V v7) {
        throw new UnsupportedOperationException();
    }
}
