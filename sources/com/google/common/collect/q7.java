package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class q7<K, V> extends h8<K, V> implements hb<K, V> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @s1.c
    private static final long f20974j = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @y1.h
    @v1.b
    private transient q7<V, K> f20975i;

    public static final class a<K, V> extends h8.c<K, V> {
        @Override // com.google.common.collect.h8.c
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public q7<K, V> a() {
            return (q7) super.a();
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
            super.h(tcVar);
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
            super.k(k7, vArr);
            return this;
        }
    }

    q7(v7<K, d7<V>> v7Var, int i7) {
        super(v7Var, i7);
    }

    public static <K, V> a<K, V> b0() {
        return new a<>();
    }

    public static <K, V> q7<K, V> c0(tc<? extends K, ? extends V> tcVar) {
        if (tcVar.isEmpty()) {
            return m0();
        }
        if (tcVar instanceof q7) {
            q7<K, V> q7Var = (q7) tcVar;
            if (!q7Var.C()) {
                return q7Var;
            }
        }
        return f0(tcVar.asMap().entrySet(), null);
    }

    @s1.a
    public static <K, V> q7<K, V> d0(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().i(iterable).a();
    }

    @s1.a
    public static <T, K, V> Collector<T, ?, q7<K, V>> e0(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        Function function3 = new Function() { // from class: com.google.common.collect.j7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return q7.j0(function, obj);
            }
        };
        Function function4 = new Function() { // from class: com.google.common.collect.k7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return q7.k0(function2, obj);
            }
        };
        final uc.j<Object, Object> jVarA = uc.f().a();
        jVarA.getClass();
        return Collectors.collectingAndThen(cd.u(function3, function4, new Supplier() { // from class: com.google.common.collect.l7
            @Override // java.util.function.Supplier
            public final Object get() {
                return jVarA.a();
            }
        }), new Function() { // from class: com.google.common.collect.m7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return q7.c0((hb) obj);
            }
        });
    }

    static <K, V> q7<K, V> f0(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return m0();
        }
        v7.b bVar = new v7.b(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            d7 d7VarR = comparator == null ? d7.r(value) : d7.S(comparator, value);
            if (!d7VarR.isEmpty()) {
                bVar.f(key, d7VarR);
                size += d7VarR.size();
            }
        }
        return new q7<>(bVar.a(), size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private q7<V, K> i0() {
        a aVarB0 = b0();
        ck it = y().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVarB0.f(entry.getValue(), entry.getKey());
        }
        q7<V, K> q7VarA = aVarB0.a();
        q7VarA.f20975i = this;
        return q7VarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object j0(Function function, Object obj) {
        return com.google.common.base.e0.E(function.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream k0(Function function, Object obj) {
        return f7.a(function.apply(obj)).peek(new i7());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l0(Function function, Function function2, a aVar, Object obj) {
        aVar.f(function.apply(obj), function2.apply(obj));
    }

    public static <K, V> q7<K, V> m0() {
        return r4.f20998k;
    }

    public static <K, V> q7<K, V> n0(K k7, V v7) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        return aVarB0.a();
    }

    public static <K, V> q7<K, V> o0(K k7, V v7, K k8, V v8) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        aVarB0.f(k8, v8);
        return aVarB0.a();
    }

    public static <K, V> q7<K, V> p0(K k7, V v7, K k8, V v8, K k9, V v9) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        aVarB0.f(k8, v8);
        aVarB0.f(k9, v9);
        return aVarB0.a();
    }

    public static <K, V> q7<K, V> q0(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        aVarB0.f(k8, v8);
        aVarB0.f(k9, v9);
        aVarB0.f(k10, v10);
        return aVarB0.a();
    }

    public static <K, V> q7<K, V> r0(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        a aVarB0 = b0();
        aVarB0.f(k7, v7);
        aVarB0.f(k8, v8);
        aVarB0.f(k9, v9);
        aVarB0.f(k10, v10);
        aVarB0.f(k11, v11);
        return aVarB0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
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
            d7.b bVarM = d7.m();
            for (int i11 = 0; i11 < i10; i11++) {
                bVarM.a(objectInputStream.readObject());
            }
            bVarB.f(object, bVarM.e());
            i8 += i10;
        }
        try {
            h8.e.f20383a.b(this, bVarB.a());
            h8.e.f20384b.a(this, i8);
        } catch (IllegalArgumentException e8) {
            throw ((InvalidObjectException) new InvalidObjectException(e8.getMessage()).initCause(e8));
        }
    }

    @s1.a
    public static <T, K, V> Collector<T, ?, q7<K, V>> u0(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.common.base.e0.F(function, "keyFunction");
        com.google.common.base.e0.F(function2, "valueFunction");
        return Collector.of(new Supplier() { // from class: com.google.common.collect.n7
            @Override // java.util.function.Supplier
            public final Object get() {
                return q7.b0();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.o7
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                q7.l0(function, function2, (q7.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.p7
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((q7.a) obj).b((q7.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.h7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((q7.a) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        se.j(this, objectOutputStream);
    }

    @Override // com.google.common.collect.h8, com.google.common.collect.tc, com.google.common.collect.hb
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public d7<V> get(K k7) {
        d7<V> d7Var = (d7) this.f20369f.get(k7);
        return d7Var == null ? d7.x() : d7Var;
    }

    @Override // com.google.common.collect.h8
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public q7<V, K> B() {
        q7<V, K> q7Var = this.f20975i;
        if (q7Var != null) {
            return q7Var;
        }
        q7<V, K> q7VarI0 = i0();
        this.f20975i = q7VarI0;
        return q7VarI0;
    }

    @Override // com.google.common.collect.h8, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    @Deprecated
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public d7<V> a(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h8, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    @Deprecated
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public d7<V> b(K k7, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }
}
