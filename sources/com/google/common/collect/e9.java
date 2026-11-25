package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public class e9<K, V> extends h8<K, V> implements ue<K, V> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @s1.c
    private static final long f20196l = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final transient u8<V> f20197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @y1.h
    @v1.b
    private transient e9<V, K> f20198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private transient u8<Map.Entry<K, V>> f20199k;

    public static final class a<K, V> extends h8.c<K, V> {
        @Override // com.google.common.collect.h8.c
        Collection<V> c() {
            return vd.g();
        }

        @Override // com.google.common.collect.h8.c
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public e9<K, V> a() {
            Collection collectionEntrySet = this.f20378a.entrySet();
            Comparator<? super K> comparator = this.f20379b;
            if (comparator != null) {
                collectionEntrySet = td.i(comparator).D().l(collectionEntrySet);
            }
            return e9.i0(collectionEntrySet, this.f20380c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.h8.c
        @u1.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<K, V> b(h8.c<K, V> cVar) {
            super.b(cVar);
            return this;
        }

        @Override // com.google.common.collect.h8.c
        @u1.a
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public a<K, V> d(Comparator<? super K> comparator) {
            super.d(comparator);
            return this;
        }

        @Override // com.google.common.collect.h8.c
        @u1.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<K, V> e(Comparator<? super V> comparator) {
            super.e(comparator);
            return this;
        }

        @Override // com.google.common.collect.h8.c
        @u1.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<K, V> f(K k7, V v7) {
            super.f(k7, v7);
            return this;
        }

        @Override // com.google.common.collect.h8.c
        @u1.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            super.g(entry);
            return this;
        }

        @Override // com.google.common.collect.h8.c
        @u1.a
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a<K, V> h(tc<? extends K, ? extends V> tcVar) {
            for (Map.Entry<? extends K, Collection<? extends V>> entry : tcVar.asMap().entrySet()) {
                j(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @Override // com.google.common.collect.h8.c
        @s1.a
        @u1.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.i(iterable);
            return this;
        }

        @Override // com.google.common.collect.h8.c
        @u1.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public a<K, V> j(K k7, Iterable<? extends V> iterable) {
            super.j(k7, iterable);
            return this;
        }

        @Override // com.google.common.collect.h8.c
        @u1.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public a<K, V> k(K k7, V... vArr) {
            return j(k7, Arrays.asList(vArr));
        }
    }

    private static final class b<K, V> extends u8<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @y1.i
        private final transient e9<K, V> f20200j;

        b(e9<K, V> e9Var) {
            this.f20200j = e9Var;
        }

        @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f20200j.W(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return false;
        }

        @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public ck<Map.Entry<K, V>> iterator() {
            return this.f20200j.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f20200j.size();
        }
    }

    @s1.c
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final se.b<e9> f20201a = se.a(e9.class, "emptySet");

        private c() {
        }
    }

    e9(v7<K, u8<V>> v7Var, int i7, Comparator<? super V> comparator) {
        super(v7Var, i7);
        this.f20197i = f0(comparator);
    }

    public static <K, V> a<K, V> b0() {
        return new a<>();
    }

    public static <K, V> e9<K, V> c0(tc<? extends K, ? extends V> tcVar) {
        return d0(tcVar, null);
    }

    private static <K, V> e9<K, V> d0(tc<? extends K, ? extends V> tcVar, Comparator<? super V> comparator) {
        com.google.common.base.e0.E(tcVar);
        if (tcVar.isEmpty() && comparator == null) {
            return p0();
        }
        if (tcVar instanceof e9) {
            e9<K, V> e9Var = (e9) tcVar;
            if (!e9Var.C()) {
                return e9Var;
            }
        }
        return i0(tcVar.asMap().entrySet(), comparator);
    }

    @s1.a
    public static <K, V> e9<K, V> e0(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().i(iterable).a();
    }

    private static <V> u8<V> f0(Comparator<? super V> comparator) {
        return comparator == null ? u8.A() : s9.m0(comparator);
    }

    @s1.a
    public static <T, K, V> Collector<T, ?, e9<K, V>> h0(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        Function function3 = new Function() { // from class: com.google.common.collect.w8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return e9.m0(function, obj);
            }
        };
        Function function4 = new Function() { // from class: com.google.common.collect.x8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return e9.n0(function2, obj);
            }
        };
        final uc.l<Object, Object> lVarG = uc.f().g();
        lVarG.getClass();
        return Collectors.collectingAndThen(cd.u(function3, function4, new Supplier() { // from class: com.google.common.collect.y8
            @Override // java.util.function.Supplier
            public final Object get() {
                return lVarG.a();
            }
        }), new Function() { // from class: com.google.common.collect.z8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return e9.c0((ue) obj);
            }
        });
    }

    static <K, V> e9<K, V> i0(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return p0();
        }
        v7.b bVar = new v7.b(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            u8 u8VarY0 = y0(comparator, entry.getValue());
            if (!u8VarY0.isEmpty()) {
                bVar.f(key, u8VarY0);
                size += u8VarY0.size();
            }
        }
        return new e9<>(bVar.a(), size, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private e9<V, K> l0() {
        a aVarB0 = b0();
        ck it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVarB0.f(entry.getValue(), entry.getKey());
        }
        e9<V, K> e9VarA = aVarB0.a();
        e9VarA.f20198j = this;
        return e9VarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object m0(Function function, Object obj) {
        return com.google.common.base.e0.E(function.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream n0(Function function, Object obj) {
        return f7.a(function.apply(obj)).peek(new i7());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o0(Function function, Function function2, a aVar, Object obj) {
        aVar.f(function.apply(obj), function2.apply(obj));
    }

    public static <K, V> e9<K, V> p0() {
        return s4.f21039m;
    }

    public static <K, V> e9<K, V> q0(K k7, V v7) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        return aVarB0.a();
    }

    public static <K, V> e9<K, V> r0(K k7, V v7, K k8, V v8) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        aVarB0.f(k8, v8);
        return aVarB0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int i7 = objectInputStream.readInt();
        if (i7 < 0) {
            throw new InvalidObjectException("Invalid key count " + i7);
        }
        v7.b bVarB = v7.b();
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            Object object = objectInputStream.readObject();
            int i10 = objectInputStream.readInt();
            if (i10 <= 0) {
                throw new InvalidObjectException("Invalid value count " + i10);
            }
            u8.a aVarZ0 = z0(comparator);
            for (int i11 = 0; i11 < i10; i11++) {
                aVarZ0.a(objectInputStream.readObject());
            }
            u8 u8VarE = aVarZ0.e();
            if (u8VarE.size() != i10) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + object);
            }
            bVarB.f(object, u8VarE);
            i8 += i10;
        }
        try {
            h8.e.f20383a.b(this, bVarB.a());
            h8.e.f20384b.a(this, i8);
            c.f20201a.b(this, f0(comparator));
        } catch (IllegalArgumentException e8) {
            throw ((InvalidObjectException) new InvalidObjectException(e8.getMessage()).initCause(e8));
        }
    }

    public static <K, V> e9<K, V> s0(K k7, V v7, K k8, V v8, K k9, V v9) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        aVarB0.f(k8, v8);
        aVarB0.f(k9, v9);
        return aVarB0.a();
    }

    public static <K, V> e9<K, V> t0(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        aVarB0.f(k8, v8);
        aVarB0.f(k9, v9);
        aVarB0.f(k10, v10);
        return aVarB0.a();
    }

    public static <K, V> e9<K, V> u0(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        aVarB0.f(k8, v8);
        aVarB0.f(k9, v9);
        aVarB0.f(k10, v10);
        aVarB0.f(k11, v11);
        return aVarB0.a();
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        se.j(this, objectOutputStream);
    }

    @s1.a
    public static <T, K, V> Collector<T, ?, e9<K, V>> x0(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.common.base.e0.F(function, "keyFunction");
        com.google.common.base.e0.F(function2, "valueFunction");
        return Collector.of(new Supplier() { // from class: com.google.common.collect.a9
            @Override // java.util.function.Supplier
            public final Object get() {
                return e9.b0();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.b9
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                e9.o0(function, function2, (e9.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.c9
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((e9.a) obj).b((e9.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.d9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((e9.a) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    private static <V> u8<V> y0(Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? u8.p(collection) : s9.b0(comparator, collection);
    }

    private static <V> u8.a<V> z0(Comparator<? super V> comparator) {
        return comparator == null ? new u8.a<>() : new s9.b(comparator);
    }

    @Override // com.google.common.collect.h8
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public u8<Map.Entry<K, V>> y() {
        u8<Map.Entry<K, V>> u8Var = this.f20199k;
        if (u8Var != null) {
            return u8Var;
        }
        b bVar = new b(this);
        this.f20199k = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.h8, com.google.common.collect.tc, com.google.common.collect.hb
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public u8<V> get(K k7) {
        return (u8) com.google.common.base.x.a((u8) this.f20369f.get(k7), this.f20197i);
    }

    @Override // com.google.common.collect.h8
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public e9<V, K> B() {
        e9<V, K> e9Var = this.f20198j;
        if (e9Var != null) {
            return e9Var;
        }
        e9<V, K> e9VarL0 = l0();
        this.f20198j = e9VarL0;
        return e9VarL0;
    }

    @Override // com.google.common.collect.h8, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    @Deprecated
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public u8<V> a(Object obj) {
        throw new UnsupportedOperationException();
    }

    Comparator<? super V> valueComparator() {
        u8<V> u8Var = this.f20197i;
        if (u8Var instanceof s9) {
            return ((s9) u8Var).comparator();
        }
        return null;
    }

    @Override // com.google.common.collect.h8, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    @Deprecated
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public u8<V> b(K k7, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }
}
