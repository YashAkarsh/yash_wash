package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class ca<R, C, V> extends h0<R, C, V> implements Serializable {

    public static final class b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<oj.a<R, C, V>> f20011a = ib.q();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Comparator<? super R> f20012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Comparator<? super C> f20013c;

        public ca<R, C, V> a() {
            int size = this.f20011a.size();
            if (size != 0) {
                return size != 1 ? ne.i0(this.f20011a, this.f20012b, this.f20013c) : new pf((oj.a) ma.z(this.f20011a));
            }
            return ca.Z();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b<R, C, V> b(b<R, C, V> bVar) {
            this.f20011a.addAll(bVar.f20011a);
            return this;
        }

        @u1.a
        public b<R, C, V> c(Comparator<? super C> comparator) {
            this.f20013c = (Comparator) com.google.common.base.e0.F(comparator, "columnComparator");
            return this;
        }

        @u1.a
        public b<R, C, V> d(Comparator<? super R> comparator) {
            this.f20012b = (Comparator) com.google.common.base.e0.F(comparator, "rowComparator");
            return this;
        }

        @u1.a
        public b<R, C, V> e(oj.a<? extends R, ? extends C, ? extends V> aVar) {
            if (aVar instanceof sj.c) {
                com.google.common.base.e0.F(aVar.b(), "row");
                com.google.common.base.e0.F(aVar.a(), "column");
                com.google.common.base.e0.F(aVar.getValue(), "value");
                this.f20011a.add(aVar);
            } else {
                f(aVar.b(), aVar.a(), aVar.getValue());
            }
            return this;
        }

        @u1.a
        public b<R, C, V> f(R r7, C c8, V v7) {
            this.f20011a.add(ca.z(r7, c8, v7));
            return this;
        }

        @u1.a
        public b<R, C, V> g(oj<? extends R, ? extends C, ? extends V> ojVar) {
            Iterator<oj.a<? extends R, ? extends C, ? extends V>> it = ojVar.r().iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<d<R, C, V>> f20014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final oj<R, C, d<R, C, V>> f20015b;

        private c() {
            this.f20014a = new ArrayList();
            this.f20015b = m6.B();
        }

        c<R, C, V> a(c<R, C, V> cVar, BinaryOperator<V> binaryOperator) {
            for (d<R, C, V> dVar : cVar.f20014a) {
                b(dVar.b(), dVar.a(), dVar.getValue(), binaryOperator);
            }
            return this;
        }

        void b(R r7, C c8, V v7, BinaryOperator<V> binaryOperator) {
            d<R, C, V> dVarK = this.f20015b.k(r7, c8);
            if (dVarK != null) {
                dVarK.c(v7, binaryOperator);
                return;
            }
            d<R, C, V> dVar = new d<>(r7, c8, v7);
            this.f20014a.add(dVar);
            this.f20015b.t(r7, c8, dVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ca<R, C, V> c() {
            return ca.F(this.f20014a);
        }
    }

    private static final class d<R, C, V> extends sj.b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final R f20016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C f20017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private V f20018c;

        d(R r7, C c8, V v7) {
            this.f20016a = (R) com.google.common.base.e0.F(r7, "row");
            this.f20017b = (C) com.google.common.base.e0.F(c8, "column");
            this.f20018c = (V) com.google.common.base.e0.F(v7, "value");
        }

        @Override // com.google.common.collect.oj.a
        public C a() {
            return this.f20017b;
        }

        @Override // com.google.common.collect.oj.a
        public R b() {
            return this.f20016a;
        }

        void c(V v7, BinaryOperator<V> binaryOperator) {
            com.google.common.base.e0.F(v7, "value");
            this.f20018c = (V) com.google.common.base.e0.F(binaryOperator.apply(this.f20018c, v7), "mergeFunction.apply");
        }

        @Override // com.google.common.collect.oj.a
        public V getValue() {
            return this.f20018c;
        }
    }

    static final class e implements Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final long f20019f = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f20020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object[] f20021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f20022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f20023d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f20024e;

        private e(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.f20020a = objArr;
            this.f20021b = objArr2;
            this.f20022c = objArr3;
            this.f20023d = iArr;
            this.f20024e = iArr2;
        }

        static e a(ca<?, ?, ?> caVar, int[] iArr, int[] iArr2) {
            return new e(caVar.g().toArray(), caVar.L().toArray(), caVar.values().toArray(), iArr, iArr2);
        }

        Object readResolve() {
            Object[] objArr = this.f20022c;
            if (objArr.length == 0) {
                return ca.Z();
            }
            int i7 = 0;
            if (objArr.length == 1) {
                return ca.a0(this.f20020a[0], this.f20021b[0], objArr[0]);
            }
            d7.b bVar = new d7.b(objArr.length);
            while (true) {
                Object[] objArr2 = this.f20022c;
                if (i7 >= objArr2.length) {
                    return ne.k0(bVar.e(), u8.t(this.f20020a), u8.t(this.f20021b));
                }
                bVar.a(ca.z(this.f20020a[this.f20023d[i7]], this.f20021b[this.f20024e[i7]], objArr2[i7]));
                i7++;
            }
        }
    }

    ca() {
    }

    public static <R, C, V> ca<R, C, V> E(oj<? extends R, ? extends C, ? extends V> ojVar) {
        return ojVar instanceof ca ? (ca) ojVar : F(ojVar.r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <R, C, V> ca<R, C, V> F(Iterable<? extends oj.a<? extends R, ? extends C, ? extends V>> iterable) {
        b bVarX = x();
        Iterator<? extends oj.a<? extends R, ? extends C, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            bVarX.e(it.next());
        }
        return bVarX.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b K() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void N(Function function, Function function2, Function function3, b bVar, Object obj) {
        bVar.f(function.apply(obj), function2.apply(obj), function3.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c U() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void V(Function function, Function function2, Function function3, BinaryOperator binaryOperator, c cVar, Object obj) {
        cVar.b(function.apply(obj), function2.apply(obj), function3.apply(obj), binaryOperator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c W(BinaryOperator binaryOperator, c cVar, c cVar2) {
        return cVar.a(cVar2, binaryOperator);
    }

    public static <R, C, V> ca<R, C, V> Z() {
        return (ca<R, C, V>) cg.f20098g;
    }

    public static <R, C, V> ca<R, C, V> a0(R r7, C c8, V v7) {
        return new pf(r7, c8, v7);
    }

    @s1.a
    public static <T, R, C, V> Collector<T, ?, ca<R, C, V>> e0(final Function<? super T, ? extends R> function, final Function<? super T, ? extends C> function2, final Function<? super T, ? extends V> function3) {
        com.google.common.base.e0.F(function, "rowFunction");
        com.google.common.base.e0.F(function2, "columnFunction");
        com.google.common.base.e0.F(function3, "valueFunction");
        return Collector.of(new Supplier() { // from class: com.google.common.collect.y9
            @Override // java.util.function.Supplier
            public final Object get() {
                return ca.K();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.z9
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ca.N(function, function2, function3, (ca.b) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.aa
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ca.b) obj).b((ca.b) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.ba
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ca.b) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    public static <T, R, C, V> Collector<T, ?, ca<R, C, V>> f0(final Function<? super T, ? extends R> function, final Function<? super T, ? extends C> function2, final Function<? super T, ? extends V> function3, final BinaryOperator<V> binaryOperator) {
        com.google.common.base.e0.F(function, "rowFunction");
        com.google.common.base.e0.F(function2, "columnFunction");
        com.google.common.base.e0.F(function3, "valueFunction");
        com.google.common.base.e0.F(binaryOperator, "mergeFunction");
        return Collector.of(new Supplier() { // from class: com.google.common.collect.u9
            @Override // java.util.function.Supplier
            public final Object get() {
                return ca.U();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.v9
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ca.V(function, function2, function3, binaryOperator, (ca.c) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.w9
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ca.W(binaryOperator, (ca.c) obj, (ca.c) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.x9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ca.c) obj).c();
            }
        }, new Collector.Characteristics[0]);
    }

    public static <R, C, V> b<R, C, V> x() {
        return new b<>();
    }

    static <R, C, V> oj.a<R, C, V> z(R r7, C c8, V v7) {
        return sj.f(com.google.common.base.e0.F(r7, "rowKey"), com.google.common.base.e0.F(c8, "columnKey"), com.google.common.base.e0.F(v7, "value"));
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public u8<oj.a<R, C, V>> r() {
        return (u8) super.r();
    }

    @Override // com.google.common.collect.oj
    /* JADX INFO: renamed from: B */
    public v7<R, V> n(C c8) {
        com.google.common.base.e0.F(c8, "columnKey");
        return (v7) com.google.common.base.x.a((v7) S().get(c8), v7.y());
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public u8<C> L() {
        return S().keySet();
    }

    @Override // com.google.common.collect.oj
    /* JADX INFO: renamed from: D */
    public abstract v7<C, Map<R, V>> S();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.h0
    /* JADX INFO: renamed from: H */
    public abstract u8<oj.a<R, C, V>> c();

    abstract e I();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.h0
    /* JADX INFO: renamed from: J */
    public abstract x6<V> d();

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean M(Object obj) {
        return super.M(obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    @Deprecated
    public final void O(oj<? extends R, ? extends C, ? extends V> ojVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean P(Object obj, Object obj2) {
        return k(obj, obj2) != null;
    }

    @Override // com.google.common.collect.h0
    final Spliterator<oj.a<R, C, V>> b() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.oj
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public v7<C, V> X(R r7) {
        com.google.common.base.e0.F(r7, "rowKey");
        return (v7) com.google.common.base.x.a((v7) f().get(r7), v7.y());
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public u8<R> g() {
        return f().keySet();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.oj
    /* JADX INFO: renamed from: d0 */
    public abstract v7<R, Map<C, V>> f();

    @Override // com.google.common.collect.h0
    final Iterator<V> e() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public x6<V> values() {
        return (x6) super.values();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Object k(Object obj, Object obj2) {
        return super.k(obj, obj2);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean m(Object obj) {
        return super.m(obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    @Deprecated
    public final V t(R r7, C c8, V v7) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    final Object writeReplace() {
        return I();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.h0
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final ck<oj.a<R, C, V>> a() {
        throw new AssertionError("should never be called");
    }
}
