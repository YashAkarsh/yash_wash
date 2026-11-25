package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class c4 {
    private c4() {
    }

    @s1.a
    public static <T> Comparator<Optional<T>> d(Comparator<? super T> comparator) {
        com.google.common.base.e0.E(comparator);
        return Comparator.comparing(new Function() { // from class: com.google.common.collect.w3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return c4.i((Optional) obj);
            }
        }, Comparator.nullsFirst(comparator));
    }

    @s1.a
    public static <T> Comparator<Optional<T>> e(Comparator<? super T> comparator) {
        com.google.common.base.e0.E(comparator);
        return Comparator.comparing(new Function() { // from class: com.google.common.collect.x3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return c4.j((Optional) obj);
            }
        }, Comparator.nullsLast(comparator));
    }

    public static <T> Collector<T, ?, List<T>> f(int i7, Comparator<? super T> comparator) {
        return l(i7, comparator.reversed());
    }

    public static <T> boolean g(Iterable<? extends T> iterable, Comparator<T> comparator) {
        com.google.common.base.e0.E(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> boolean h(Iterable<? extends T> iterable, Comparator<T> comparator) {
        com.google.common.base.e0.E(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object i(Optional optional) {
        return optional.orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object j(Optional optional) {
        return optional.orElse(null);
    }

    public static <T> Collector<T, ?, List<T>> l(final int i7, final Comparator<? super T> comparator) {
        f2.b(i7, "k");
        com.google.common.base.e0.E(comparator);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.y3
            @Override // java.util.function.Supplier
            public final Object get() {
                return tj.e(i7, comparator);
            }
        }, new BiConsumer() { // from class: com.google.common.collect.z3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((tj) obj).f(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.a4
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((tj) obj).a((tj) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.b4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((tj) obj).k();
            }
        }, Collector.Characteristics.UNORDERED);
    }

    public static <T, S extends T> Comparator<Iterable<S>> m(Comparator<T> comparator) {
        return new bb((Comparator) com.google.common.base.e0.E(comparator));
    }
}
