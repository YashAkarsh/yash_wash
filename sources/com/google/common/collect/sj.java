package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class sj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.common.base.s<? extends Map<?, ?>, ? extends Map<?, ?>> f21080a = new a();

    static class a implements com.google.common.base.s<Map<Object, Object>, Map<Object, Object>> {
        a() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    static abstract class b<R, C, V> implements oj.a<R, C, V> {
        b() {
        }

        @Override // com.google.common.collect.oj.a
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof oj.a)) {
                return false;
            }
            oj.a aVar = (oj.a) obj;
            return com.google.common.base.y.a(b(), aVar.b()) && com.google.common.base.y.a(a(), aVar.a()) && com.google.common.base.y.a(getValue(), aVar.getValue());
        }

        @Override // com.google.common.collect.oj.a
        public int hashCode() {
            return com.google.common.base.y.b(b(), a(), getValue());
        }

        public String toString() {
            return "(" + b() + "," + a() + ")=" + getValue();
        }
    }

    static final class c<R, C, V> extends b<R, C, V> implements Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f21081d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final R f21082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C f21083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final V f21084c;

        c(R r7, C c8, V v7) {
            this.f21082a = r7;
            this.f21083b = c8;
            this.f21084c = v7;
        }

        @Override // com.google.common.collect.oj.a
        public C a() {
            return this.f21083b;
        }

        @Override // com.google.common.collect.oj.a
        public R b() {
            return this.f21082a;
        }

        @Override // com.google.common.collect.oj.a
        public V getValue() {
            return this.f21084c;
        }
    }

    private static class d<R, C, V1, V2> extends h0<R, C, V2> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final oj<R, C, V1> f21085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.google.common.base.s<? super V1, V2> f21086d;

        class a implements com.google.common.base.s<oj.a<R, C, V1>, oj.a<R, C, V2>> {
            a() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public oj.a<R, C, V2> apply(oj.a<R, C, V1> aVar) {
                return sj.f(aVar.b(), aVar.a(), d.this.f21086d.apply(aVar.getValue()));
            }
        }

        class b implements com.google.common.base.s<Map<C, V1>, Map<C, V2>> {
            b() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<C, V2> apply(Map<C, V1> map) {
                return wb.N0(map, d.this.f21086d);
            }
        }

        class c implements com.google.common.base.s<Map<R, V1>, Map<R, V2>> {
            c() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<R, V2> apply(Map<R, V1> map) {
                return wb.N0(map, d.this.f21086d);
            }
        }

        d(oj<R, C, V1> ojVar, com.google.common.base.s<? super V1, V2> sVar) {
            this.f21085c = (oj) com.google.common.base.e0.E(ojVar);
            this.f21086d = (com.google.common.base.s) com.google.common.base.e0.E(sVar);
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public Set<C> L() {
            return this.f21085c.L();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public void O(oj<? extends R, ? extends C, ? extends V2> ojVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public boolean P(Object obj, Object obj2) {
            return this.f21085c.P(obj, obj2);
        }

        @Override // com.google.common.collect.oj
        public Map<C, Map<R, V2>> S() {
            return wb.N0(this.f21085c.S(), new c());
        }

        @Override // com.google.common.collect.oj
        public Map<C, V2> X(R r7) {
            return wb.N0(this.f21085c.X(r7), this.f21086d);
        }

        @Override // com.google.common.collect.h0
        Iterator<oj.a<R, C, V2>> a() {
            return ua.c0(this.f21085c.r().iterator(), i());
        }

        @Override // com.google.common.collect.h0
        Spliterator<oj.a<R, C, V2>> b() {
            return q2.e(this.f21085c.r().spliterator(), i());
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public void clear() {
            this.f21085c.clear();
        }

        @Override // com.google.common.collect.h0
        Collection<V2> d() {
            return h3.m(this.f21085c.values(), this.f21086d);
        }

        @Override // com.google.common.collect.oj
        public Map<R, Map<C, V2>> f() {
            return wb.N0(this.f21085c.f(), new b());
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public Set<R> g() {
            return this.f21085c.g();
        }

        com.google.common.base.s<oj.a<R, C, V1>, oj.a<R, C, V2>> i() {
            return new a();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public V2 k(Object obj, Object obj2) {
            if (P(obj, obj2)) {
                return this.f21086d.apply(this.f21085c.k(obj, obj2));
            }
            return null;
        }

        @Override // com.google.common.collect.oj
        public Map<R, V2> n(C c8) {
            return wb.N0(this.f21085c.n(c8), this.f21086d);
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public V2 remove(Object obj, Object obj2) {
            if (P(obj, obj2)) {
                return this.f21086d.apply(this.f21085c.remove(obj, obj2));
            }
            return null;
        }

        @Override // com.google.common.collect.oj
        public int size() {
            return this.f21085c.size();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public V2 t(R r7, C c8, V2 v7) {
            throw new UnsupportedOperationException();
        }
    }

    private static class e<C, R, V> extends h0<C, R, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final com.google.common.base.s<oj.a<?, ?, ?>, oj.a<?, ?, ?>> f21090d = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final oj<R, C, V> f21091c;

        static class a implements com.google.common.base.s<oj.a<?, ?, ?>, oj.a<?, ?, ?>> {
            a() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public oj.a<?, ?, ?> apply(oj.a<?, ?, ?> aVar) {
                return sj.f(aVar.a(), aVar.b(), aVar.getValue());
            }
        }

        e(oj<R, C, V> ojVar) {
            this.f21091c = (oj) com.google.common.base.e0.E(ojVar);
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public Set<R> L() {
            return this.f21091c.g();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public boolean M(Object obj) {
            return this.f21091c.m(obj);
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public void O(oj<? extends C, ? extends R, ? extends V> ojVar) {
            this.f21091c.O(sj.p(ojVar));
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public boolean P(Object obj, Object obj2) {
            return this.f21091c.P(obj2, obj);
        }

        @Override // com.google.common.collect.oj
        public Map<R, Map<C, V>> S() {
            return this.f21091c.f();
        }

        @Override // com.google.common.collect.oj
        public Map<R, V> X(C c8) {
            return this.f21091c.n(c8);
        }

        @Override // com.google.common.collect.h0
        Iterator<oj.a<C, R, V>> a() {
            return ua.c0(this.f21091c.r().iterator(), f21090d);
        }

        @Override // com.google.common.collect.h0
        Spliterator<oj.a<C, R, V>> b() {
            return q2.e(this.f21091c.r().spliterator(), f21090d);
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public void clear() {
            this.f21091c.clear();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public boolean containsValue(Object obj) {
            return this.f21091c.containsValue(obj);
        }

        @Override // com.google.common.collect.oj
        public Map<C, Map<R, V>> f() {
            return this.f21091c.S();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public Set<C> g() {
            return this.f21091c.L();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public V k(Object obj, Object obj2) {
            return this.f21091c.k(obj2, obj);
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public boolean m(Object obj) {
            return this.f21091c.M(obj);
        }

        @Override // com.google.common.collect.oj
        public Map<C, V> n(R r7) {
            return this.f21091c.X(r7);
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public V remove(Object obj, Object obj2) {
            return this.f21091c.remove(obj2, obj);
        }

        @Override // com.google.common.collect.oj
        public int size() {
            return this.f21091c.size();
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public V t(C c8, R r7, V v7) {
            return this.f21091c.t(r7, c8, v7);
        }

        @Override // com.google.common.collect.h0, com.google.common.collect.oj
        public Collection<V> values() {
            return this.f21091c.values();
        }
    }

    static final class f<R, C, V> extends g<R, C, V> implements re<R, C, V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f21092c = 0;

        public f(re<R, ? extends C, ? extends V> reVar) {
            super(reVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.sj.g, com.google.common.collect.j6
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public re<R, C, V> c0() {
            return (re) super.c0();
        }

        @Override // com.google.common.collect.sj.g, com.google.common.collect.j6, com.google.common.collect.oj
        public SortedMap<R, Map<C, V>> f() {
            return Collections.unmodifiableSortedMap(wb.P0(c0().f(), sj.s()));
        }

        @Override // com.google.common.collect.sj.g, com.google.common.collect.j6, com.google.common.collect.oj
        public SortedSet<R> g() {
            return Collections.unmodifiableSortedSet(c0().g());
        }
    }

    private static class g<R, C, V> extends j6<R, C, V> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f21093b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final oj<? extends R, ? extends C, ? extends V> f21094a;

        g(oj<? extends R, ? extends C, ? extends V> ojVar) {
            this.f21094a = (oj) com.google.common.base.e0.E(ojVar);
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public Set<C> L() {
            return Collections.unmodifiableSet(super.L());
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public void O(oj<? extends R, ? extends C, ? extends V> ojVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public Map<C, Map<R, V>> S() {
            return Collections.unmodifiableMap(wb.N0(super.S(), sj.s()));
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public Map<C, V> X(R r7) {
            return Collections.unmodifiableMap(super.X(r7));
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public void clear() {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.j6, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public oj<R, C, V> c0() {
            return this.f21094a;
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public Map<R, Map<C, V>> f() {
            return Collections.unmodifiableMap(wb.N0(super.f(), sj.s()));
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public Set<R> g() {
            return Collections.unmodifiableSet(super.g());
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public Map<R, V> n(C c8) {
            return Collections.unmodifiableMap(super.n(c8));
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public Set<oj.a<R, C, V>> r() {
            return Collections.unmodifiableSet(super.r());
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public V remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public V t(R r7, C c8, V v7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j6, com.google.common.collect.oj
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }
    }

    private sj() {
    }

    static boolean e(oj<?, ?, ?> ojVar, Object obj) {
        if (obj == ojVar) {
            return true;
        }
        if (obj instanceof oj) {
            return ojVar.r().equals(((oj) obj).r());
        }
        return false;
    }

    public static <R, C, V> oj.a<R, C, V> f(R r7, C c8, V v7) {
        return new c(r7, c8, v7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object g(Object obj, Object obj2) {
        throw new IllegalStateException("Conflicting values " + obj + " and " + obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Function function, Function function2, Function function3, BinaryOperator binaryOperator, oj ojVar, Object obj) {
        j(ojVar, function.apply(obj), function2.apply(obj), function3.apply(obj), binaryOperator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ oj i(BinaryOperator binaryOperator, oj ojVar, oj ojVar2) {
        for (oj.a aVar : ojVar2.r()) {
            j(ojVar, aVar.b(), aVar.a(), aVar.getValue(), binaryOperator);
        }
        return ojVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <R, C, V> void j(oj<R, C, V> ojVar, R r7, C c8, V v7, BinaryOperator<V> binaryOperator) {
        com.google.common.base.e0.E(v7);
        Object objK = ojVar.k(r7, c8);
        if (objK == null) {
            ojVar.t(r7, c8, v7);
            return;
        }
        Object objApply = binaryOperator.apply(objK, v7);
        if (objApply == null) {
            ojVar.remove(r7, c8);
        } else {
            ojVar.t(r7, c8, objApply);
        }
    }

    @s1.a
    public static <R, C, V> oj<R, C, V> k(Map<R, Map<C, V>> map, com.google.common.base.p0<? extends Map<C, V>> p0Var) {
        com.google.common.base.e0.d(map.isEmpty());
        com.google.common.base.e0.E(p0Var);
        return new gg(map, p0Var);
    }

    public static <R, C, V> oj<R, C, V> l(oj<R, C, V> ojVar) {
        return dj.z(ojVar, null);
    }

    public static <T, R, C, V, I extends oj<R, C, V>> Collector<T, ?, I> m(final Function<? super T, ? extends R> function, final Function<? super T, ? extends C> function2, final Function<? super T, ? extends V> function3, final BinaryOperator<V> binaryOperator, Supplier<I> supplier) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        com.google.common.base.e0.E(function3);
        com.google.common.base.e0.E(binaryOperator);
        com.google.common.base.e0.E(supplier);
        return Collector.of(supplier, new BiConsumer() { // from class: com.google.common.collect.pj
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                sj.h(function, function2, function3, binaryOperator, (oj) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.qj
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return sj.i(binaryOperator, (oj) obj, (oj) obj2);
            }
        }, new Collector.Characteristics[0]);
    }

    @s1.a
    public static <T, R, C, V, I extends oj<R, C, V>> Collector<T, ?, I> n(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3, Supplier<I> supplier) {
        return m(function, function2, function3, new BinaryOperator() { // from class: com.google.common.collect.rj
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return sj.g(obj, obj2);
            }
        }, supplier);
    }

    @s1.a
    public static <R, C, V1, V2> oj<R, C, V2> o(oj<R, C, V1> ojVar, com.google.common.base.s<? super V1, V2> sVar) {
        return new d(ojVar, sVar);
    }

    public static <R, C, V> oj<C, R, V> p(oj<R, C, V> ojVar) {
        return ojVar instanceof e ? ((e) ojVar).f21091c : new e(ojVar);
    }

    @s1.a
    public static <R, C, V> re<R, C, V> q(re<R, ? extends C, ? extends V> reVar) {
        return new f(reVar);
    }

    public static <R, C, V> oj<R, C, V> r(oj<? extends R, ? extends C, ? extends V> ojVar) {
        return new g(ojVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> com.google.common.base.s<Map<K, V>, Map<K, V>> s() {
        return (com.google.common.base.s<Map<K, V>, Map<K, V>>) f21080a;
    }
}
