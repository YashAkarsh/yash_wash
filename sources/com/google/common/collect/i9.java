package com.google.common.collect;

import com.haier.uhome.account.api.RetInfoContent;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public final class i9<K, V> extends k9<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator<Comparable> f20403i = td.A();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final i9<Comparable, Object> f20404j = new i9<>(s9.m0(td.A()), d7.x());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f20405k = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient me<K> f20406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient d7<V> f20407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient i9<K, V> f20408h;

    static class a implements Comparator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f20409a;

        a(Comparator comparator) {
            this.f20409a = comparator;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<K, V> entry, Map.Entry<K, V> entry2) {
            return this.f20409a.compare(entry.getKey(), entry2.getKey());
        }
    }

    class b extends x7<K, V> {

        class a extends t6<Map.Entry<K, V>> {
            a() {
            }

            @Override // com.google.common.collect.t6
            x6<Map.Entry<K, V>> W() {
                return b.this;
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> get(int i7) {
                return new AbstractMap.SimpleImmutableEntry(i9.this.f20406f.a().get(i7), i9.this.f20407g.get(i7));
            }

            @Override // com.google.common.collect.d7, com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<Map.Entry<K, V>> spliterator() {
                return q2.c(size(), 1297, new IntFunction() { // from class: com.google.common.collect.j9
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i7) {
                        return this.f20467a.get(i7);
                    }
                });
            }
        }

        b() {
        }

        @Override // com.google.common.collect.x7
        v7<K, V> M() {
            return i9.this;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
            a().forEach(consumer);
        }

        @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public ck<Map.Entry<K, V>> iterator() {
            return a().iterator();
        }

        @Override // com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return a().spliterator();
        }

        @Override // com.google.common.collect.u8
        d7<Map.Entry<K, V>> v() {
            return new a();
        }
    }

    public static class c<K, V> extends v7.b<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Comparator<? super K> f20412e;

        public c(Comparator<? super K> comparator) {
            this.f20412e = (Comparator) com.google.common.base.e0.E(comparator);
        }

        @Override // com.google.common.collect.v7.b
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public i9<K, V> a() {
            int i7 = this.f21273c;
            if (i7 != 0) {
                return i7 != 1 ? i9.k0(this.f20412e, false, this.f21272b, i7) : i9.y0(this.f20412e, this.f21272b[0].getKey(), this.f21272b[0].getValue());
            }
            return i9.i0(this.f20412e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.v7.b
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public c<K, V> c(v7.b<K, V> bVar) {
            super.c(bVar);
            return this;
        }

        @Override // com.google.common.collect.v7.b
        @s1.a
        @u1.a
        @Deprecated
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public c<K, V> e(Comparator<? super V> comparator) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @Override // com.google.common.collect.v7.b
        @u1.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public c<K, V> f(K k7, V v7) {
            super.f(k7, v7);
            return this;
        }

        @Override // com.google.common.collect.v7.b
        @u1.a
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public c<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            super.g(entry);
            return this;
        }

        @Override // com.google.common.collect.v7.b
        @s1.a
        @u1.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public c<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.h(iterable);
            return this;
        }

        @Override // com.google.common.collect.v7.b
        @u1.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public c<K, V> i(Map<? extends K, ? extends V> map) {
            super.i(map);
            return this;
        }
    }

    private static class d extends v7.e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f20413e = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Comparator<Object> f20414d;

        d(i9<?, ?> i9Var) {
            super(i9Var);
            this.f20414d = i9Var.comparator();
        }

        @Override // com.google.common.collect.v7.e
        Object readResolve() {
            return a(new c(this.f20414d));
        }
    }

    i9(me<K> meVar, d7<V> d7Var) {
        this(meVar, d7Var, null);
    }

    public static <K, V> c<K, V> A0(Comparator<K> comparator) {
        return new c<>(comparator);
    }

    public static <K extends Comparable<?>, V> c<K, V> B0() {
        return new c<>(td.A().F());
    }

    @s1.a
    public static <T, K, V> Collector<T, ?, i9<K, V>> G0(Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return e2.s(comparator, function, function2);
    }

    @s1.a
    public static <T, K, V> Collector<T, ?, i9<K, V>> H0(final Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        com.google.common.base.e0.E(comparator);
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        com.google.common.base.e0.E(binaryOperator);
        return Collectors.collectingAndThen(Collectors.toMap(function, function2, binaryOperator, new Supplier() { // from class: com.google.common.collect.g9
            @Override // java.util.function.Supplier
            public final Object get() {
                return i9.p0(comparator);
            }
        }), new Function() { // from class: com.google.common.collect.h9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return i9.f0((TreeMap) obj);
            }
        });
    }

    @s1.a
    public static <K, V> i9<K, V> a0(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return b0(iterable, (td) f20403i);
    }

    @s1.a
    public static <K, V> i9<K, V> b0(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return j0((Comparator) com.google.common.base.e0.E(comparator), false, iterable);
    }

    public static <K, V> i9<K, V> c0(Map<? extends K, ? extends V> map) {
        return e0(map, (td) f20403i);
    }

    public static <K, V> i9<K, V> d0(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return e0(map, (Comparator) com.google.common.base.e0.E(comparator));
    }

    private static <K, V> i9<K, V> e0(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean zEquals;
        boolean z7 = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                zEquals = comparator.equals(comparator2);
            } else if (comparator == f20403i) {
                zEquals = true;
            }
            z7 = zEquals;
        }
        if (z7 && (map instanceof i9)) {
            i9<K, V> i9Var = (i9) map;
            if (!i9Var.r()) {
                return i9Var;
            }
        }
        return j0(comparator, z7, map.entrySet());
    }

    public static <K, V> i9<K, V> f0(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = f20403i;
        }
        if (sortedMap instanceof i9) {
            i9<K, V> i9Var = (i9) sortedMap;
            if (!i9Var.r()) {
                return i9Var;
            }
        }
        return j0(comparator, true, sortedMap.entrySet());
    }

    static <K, V> i9<K, V> i0(Comparator<? super K> comparator) {
        return td.A().equals(comparator) ? s0() : new i9<>(s9.m0(comparator), d7.x());
    }

    private static <K, V> i9<K, V> j0(Comparator<? super K> comparator, boolean z7, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) ma.P(iterable, v7.f21264e);
        return k0(comparator, z7, entryArr, entryArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> i9<K, V> k0(Comparator<? super K> comparator, boolean z7, Map.Entry<K, V>[] entryArr, int i7) {
        if (i7 == 0) {
            return i0(comparator);
        }
        if (i7 == 1) {
            return y0(comparator, entryArr[0].getKey(), entryArr[0].getValue());
        }
        Object[] objArr = new Object[i7];
        Object[] objArr2 = new Object[i7];
        if (z7) {
            for (int i8 = 0; i8 < i7; i8++) {
                K key = entryArr[i8].getKey();
                V value = entryArr[i8].getValue();
                f2.a(key, value);
                objArr[i8] = key;
                objArr2[i8] = value;
            }
        } else {
            Arrays.sort(entryArr, 0, i7, new a(comparator));
            Object key2 = entryArr[0].getKey();
            objArr[0] = key2;
            V value2 = entryArr[0].getValue();
            objArr2[0] = value2;
            f2.a(objArr[0], value2);
            int i9 = 1;
            while (i9 < i7) {
                Object key3 = entryArr[i9].getKey();
                V value3 = entryArr[i9].getValue();
                f2.a(key3, value3);
                objArr[i9] = key3;
                objArr2[i9] = value3;
                v7.d(comparator.compare(key2, key3) != 0, RetInfoContent.BindKEY_ISNULL, entryArr[i9 - 1], entryArr[i9]);
                i9++;
                key2 = key3;
            }
        }
        return new i9<>(new me(new he(objArr), comparator), new he(objArr2));
    }

    private i9<K, V> l0(int i7, int i8) {
        if (i7 == 0 && i8 == size()) {
            return this;
        }
        return i7 == i8 ? i0(comparator()) : new i9<>(this.f20406f.M0(i7, i8), this.f20407g.subList(i7, i8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TreeMap p0(Comparator comparator) {
        return new TreeMap(comparator);
    }

    public static <K extends Comparable<?>, V> c<K, V> q0() {
        return new c<>(td.A());
    }

    public static <K, V> i9<K, V> s0() {
        return (i9<K, V>) f20404j;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/i9<TK;TV;>; */
    public static i9 t0(Comparable comparable, Object obj) {
        return y0(td.A(), comparable, obj);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/i9<TK;TV;>; */
    public static i9 u0(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        return z0(v7.n(comparable, obj), v7.n(comparable2, obj2));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/i9<TK;TV;>; */
    public static i9 v0(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        return z0(v7.n(comparable, obj), v7.n(comparable2, obj2), v7.n(comparable3, obj3));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/i9<TK;TV;>; */
    public static i9 w0(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        return z0(v7.n(comparable, obj), v7.n(comparable2, obj2), v7.n(comparable3, obj3), v7.n(comparable4, obj4));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/i9<TK;TV;>; */
    public static i9 x0(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        return z0(v7.n(comparable, obj), v7.n(comparable2, obj2), v7.n(comparable3, obj3), v7.n(comparable4, obj4), v7.n(comparable5, obj5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> i9<K, V> y0(Comparator<? super K> comparator, K k7, V v7) {
        return new i9<>(new me(d7.z(k7), (Comparator) com.google.common.base.e0.E(comparator)), d7.z(v7));
    }

    private static <K extends Comparable<? super K>, V> i9<K, V> z0(Map.Entry<K, V>... entryArr) {
        return k0(td.A(), false, entryArr, entryArr.length);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public i9<K, V> subMap(K k7, K k8) {
        return subMap(k7, true, k8, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public i9<K, V> subMap(K k7, boolean z7, K k8, boolean z8) {
        com.google.common.base.e0.E(k7);
        com.google.common.base.e0.E(k8);
        com.google.common.base.e0.y(comparator().compare(k7, k8) <= 0, "expected fromKey <= toKey but %s > %s", k7, k8);
        return headMap(k8, z8).tailMap(k7, z7);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public i9<K, V> tailMap(K k7) {
        return tailMap(k7, true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public i9<K, V> tailMap(K k7, boolean z7) {
        return l0(this.f20406f.O0((K) com.google.common.base.e0.E(k7), z7), size());
    }

    @Override // com.google.common.collect.v7, java.util.Map, java.util.SortedMap
    /* JADX INFO: renamed from: J */
    public x6<V> values() {
        return this.f20407g;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k7) {
        return tailMap(k7, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k7) {
        return (K) wb.Y(ceilingEntry(k7));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().a().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k7) {
        return headMap(k7, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k7) {
        return (K) wb.Y(floorEntry(k7));
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        d7<K> d7VarA = this.f20406f.a();
        for (int i7 = 0; i7 < size(); i7++) {
            biConsumer.accept(d7VarA.get(i7), this.f20407g.get(i7));
        }
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public s9<K> descendingKeySet() {
        return this.f20406f.descendingSet();
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public V get(Object obj) {
        int iIndexOf = this.f20406f.indexOf(obj);
        if (iIndexOf == -1) {
            return null;
        }
        return this.f20407g.get(iIndexOf);
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public i9<K, V> descendingMap() {
        i9<K, V> i9Var = this.f20408h;
        if (i9Var == null) {
            return isEmpty() ? i0(td.i(comparator()).F()) : new i9<>((me) this.f20406f.descendingSet(), this.f20407g.O(), this);
        }
        return i9Var;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k7) {
        return tailMap(k7, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k7) {
        return (K) wb.Y(higherEntry(k7));
    }

    @Override // com.google.common.collect.v7
    u8<Map.Entry<K, V>> k() {
        return isEmpty() ? u8.A() : new b();
    }

    @Override // com.google.common.collect.v7
    u8<K> l() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().a().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k7) {
        return headMap(k7, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k7) {
        return (K) wb.Y(lowerEntry(k7));
    }

    @Override // com.google.common.collect.v7
    x6<V> m() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public i9<K, V> headMap(K k7) {
        return headMap(k7, false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public i9<K, V> headMap(K k7, boolean z7) {
        return l0(0, this.f20406f.N0((K) com.google.common.base.e0.E(k7), z7));
    }

    @Override // com.google.common.collect.v7, java.util.Map, java.util.SortedMap
    /* JADX INFO: renamed from: o */
    public u8<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.v7
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public s9<K> keySet() {
        return this.f20406f;
    }

    @Override // java.util.NavigableMap
    @u1.a
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @u1.a
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.v7
    boolean r() {
        return this.f20406f.h() || this.f20407g.h();
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public s9<K> navigableKeySet() {
        return this.f20406f;
    }

    @Override // java.util.Map
    public int size() {
        return this.f20407g.size();
    }

    @Override // com.google.common.collect.v7
    Object writeReplace() {
        return new d(this);
    }

    i9(me<K> meVar, d7<V> d7Var, i9<K, V> i9Var) {
        this.f20406f = meVar;
        this.f20407g = d7Var;
        this.f20408h = i9Var;
    }
}
