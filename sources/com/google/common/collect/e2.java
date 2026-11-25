package com.google.common.collect;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Collector<Object, ?, d7<Object>> f20189a = Collector.of(new Supplier() { // from class: com.google.common.collect.a2
        @Override // java.util.function.Supplier
        public final Object get() {
            return d7.m();
        }
    }, new BiConsumer() { // from class: com.google.common.collect.z0
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((d7.b) obj).a(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.common.collect.a1
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((d7.b) obj).m((d7.b) obj2);
        }
    }, new Function() { // from class: com.google.common.collect.b1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((d7.b) obj).e();
        }
    }, new Collector.Characteristics[0]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Collector<Object, ?, u8<Object>> f20190b = Collector.of(new Supplier() { // from class: com.google.common.collect.c1
        @Override // java.util.function.Supplier
        public final Object get() {
            return u8.k();
        }
    }, new BiConsumer() { // from class: com.google.common.collect.d1
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((u8.a) obj).a(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.common.collect.e1
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((u8.a) obj).l((u8.a) obj2);
        }
    }, new Function() { // from class: com.google.common.collect.f1
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((u8.a) obj).e();
        }
    }, new Collector.Characteristics[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @s1.c
    private static final Collector<xd<Comparable>, ?, t8<Comparable>> f20191c = Collector.of(new Supplier() { // from class: com.google.common.collect.b2
        @Override // java.util.function.Supplier
        public final Object get() {
            return t8.x();
        }
    }, new BiConsumer() { // from class: com.google.common.collect.c2
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((t8.d) obj).a((xd) obj2);
        }
    }, new BinaryOperator() { // from class: com.google.common.collect.d2
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((t8.d) obj).e((t8.d) obj2);
        }
    }, new Function() { // from class: com.google.common.collect.y0
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((t8.d) obj).d();
        }
    }, new Collector.Characteristics[0]);

    e2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Function function, Function function2, u6.a aVar, Object obj) {
        aVar.f(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Function function, Function function2, v7.b bVar, Object obj) {
        bVar.f(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Function function, Function function2, s8.c cVar, Object obj) {
        cVar.c((xd) function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i9.c j(Comparator comparator) {
        return new i9.c(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(Function function, Function function2, i9.c cVar, Object obj) {
        cVar.f(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s9.b l(Comparator comparator) {
        return new s9.b(comparator);
    }

    static <T, K, V> Collector<T, ?, u6<K, V>> m(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.s1
            @Override // java.util.function.Supplier
            public final Object get() {
                return new u6.a();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.x1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                e2.g(function, function2, (u6.a) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.y1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((u6.a) obj).c((u6.a) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.z1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((u6.a) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    static <E> Collector<E, ?, d7<E>> n() {
        return (Collector<E, ?, d7<E>>) f20189a;
    }

    static <T, K, V> Collector<T, ?, v7<K, V>> o(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.k1
            @Override // java.util.function.Supplier
            public final Object get() {
                return new v7.b();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.l1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                e2.h(function, function2, (v7.b) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.m1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((v7.b) obj).c((v7.b) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.n1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((v7.b) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    @s1.c
    static <T, K extends Comparable<? super K>, V> Collector<T, ?, s8<K, V>> p(final Function<? super T, xd<K>> function, final Function<? super T, ? extends V> function2) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.g1
            @Override // java.util.function.Supplier
            public final Object get() {
                return s8.n();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.h1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                e2.i(function, function2, (s8.c) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.i1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((s8.c) obj).b((s8.c) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.j1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((s8.c) obj).a();
            }
        }, new Collector.Characteristics[0]);
    }

    @s1.c
    static <E extends Comparable<? super E>> Collector<xd<E>, ?, t8<E>> q() {
        return (Collector<xd<E>, ?, t8<E>>) f20191c;
    }

    static <E> Collector<E, ?, u8<E>> r() {
        return (Collector<E, ?, u8<E>>) f20190b;
    }

    static <T, K, V> Collector<T, ?, i9<K, V>> s(final Comparator<? super K> comparator, final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        com.google.common.base.e0.E(comparator);
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(function2);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.o1
            @Override // java.util.function.Supplier
            public final Object get() {
                return e2.j(comparator);
            }
        }, new BiConsumer() { // from class: com.google.common.collect.p1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                e2.k(function, function2, (i9.c) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.q1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((i9.c) obj).c((i9.c) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.r1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((i9.c) obj).a();
            }
        }, Collector.Characteristics.UNORDERED);
    }

    static <E> Collector<E, ?, s9<E>> t(final Comparator<? super E> comparator) {
        com.google.common.base.e0.E(comparator);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.t1
            @Override // java.util.function.Supplier
            public final Object get() {
                return e2.l(comparator);
            }
        }, new BiConsumer() { // from class: com.google.common.collect.u1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((s9.b) obj).a(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.v1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((s9.b) obj).l((s9.b) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.w1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((s9.b) obj).e();
            }
        }, new Collector.Characteristics[0]);
    }
}
