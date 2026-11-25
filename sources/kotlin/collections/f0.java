package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
class f0 extends e0 {
    @a7.d
    public static final <R> List<R> a1(@a7.d Iterable<?> iterable, @a7.d Class<R> klass) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(klass, "klass");
        return (List) b1(iterable, new ArrayList(), klass);
    }

    @a7.d
    public static final <C extends Collection<? super R>, R> C b1(@a7.d Iterable<?> iterable, @a7.d C destination, @a7.d Class<R> klass) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Comparable c1(Iterable iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return g0.K3(iterable);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double d1(Iterable iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return g0.L3(iterable);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float e1(Iterable iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return g0.M3(iterable);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T f1(Iterable<? extends T> iterable, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R rZ = selector.z(next);
            do {
                T next2 = it.next();
                R rZ2 = selector.z(next2);
                if (rZ.compareTo(rZ2) < 0) {
                    next = next2;
                    rZ = rZ2;
                }
            } while (it.hasNext());
        }
        return (T) next;
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Object g1(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return g0.Q3(iterable, comparator);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Comparable h1(Iterable iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return g0.c4(iterable);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double i1(Iterable iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return g0.d4(iterable);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float j1(Iterable iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return g0.e4(iterable);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T k1(Iterable<? extends T> iterable, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R rZ = selector.z(next);
            do {
                T next2 = it.next();
                R rZ2 = selector.z(next2);
                if (rZ.compareTo(rZ2) > 0) {
                    next = next2;
                    rZ = rZ2;
                }
            } while (it.hasNext());
        }
        return (T) next;
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Object l1(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return g0.i4(iterable, comparator);
    }

    public static <T> void m1(@a7.d List<T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        Collections.reverse(list);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> BigDecimal n1(Iterable<? extends T> iterable, i5.l<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(it.next()));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> BigInteger o1(Iterable<? extends T> iterable, i5.l<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(it.next()));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @a7.d
    public static final <T extends Comparable<? super T>> SortedSet<T> p1(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return (SortedSet) g0.L5(iterable, new TreeSet());
    }

    @a7.d
    public static final <T> SortedSet<T> q1(@a7.d Iterable<? extends T> iterable, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return (SortedSet) g0.L5(iterable, new TreeSet(comparator));
    }
}
