package kotlin.sequences;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.b1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.t0;

/* JADX INFO: loaded from: classes2.dex */
class t extends s {

    static final class a extends n0 implements i5.l<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class<R> f35180a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class<R> cls) {
            super(1);
            this.f35180a = cls;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean z(@a7.e Object obj) {
            return Boolean.valueOf(this.f35180a.isInstance(obj));
        }
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Object A(m mVar, Comparator comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        return u.I1(mVar, comparator);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Comparable B(m mVar) {
        l0.p(mVar, "<this>");
        return u.U1(mVar);
    }

    @g1(version = "1.1")
    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double C(m mVar) {
        l0.p(mVar, "<this>");
        return u.V1(mVar);
    }

    @g1(version = "1.1")
    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float D(m mVar) {
        l0.p(mVar, "<this>");
        return u.W1(mVar);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T E(m<? extends T> mVar, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
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

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Object F(m mVar, Comparator comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        return u.a2(mVar, comparator);
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @t0
    @kotlin.internal.f
    private static final <T> BigDecimal G(m<? extends T> mVar, i5.l<? super T, ? extends BigDecimal> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(it.next()));
            l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @t0
    @kotlin.internal.f
    private static final <T> BigInteger H(m<? extends T> mVar, i5.l<? super T, ? extends BigInteger> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        Iterator<? extends T> it = mVar.iterator();
        while (it.hasNext()) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(it.next()));
            l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @a7.d
    public static final <T extends Comparable<? super T>> SortedSet<T> I(@a7.d m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        return (SortedSet) u.a3(mVar, new TreeSet());
    }

    @a7.d
    public static final <T> SortedSet<T> J(@a7.d m<? extends T> mVar, @a7.d Comparator<? super T> comparator) {
        l0.p(mVar, "<this>");
        l0.p(comparator, "comparator");
        return (SortedSet) u.a3(mVar, new TreeSet(comparator));
    }

    @a7.d
    public static final <R> m<R> u(@a7.d m<?> mVar, @a7.d Class<R> klass) {
        l0.p(mVar, "<this>");
        l0.p(klass, "klass");
        m<R> mVarP0 = u.p0(mVar, new a(klass));
        l0.n(mVarP0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return mVarP0;
    }

    @a7.d
    public static final <C extends Collection<? super R>, R> C v(@a7.d m<?> mVar, @a7.d C destination, @a7.d Class<R> klass) {
        l0.p(mVar, "<this>");
        l0.p(destination, "destination");
        l0.p(klass, "klass");
        for (Object obj : mVar) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Comparable w(m mVar) {
        l0.p(mVar, "<this>");
        return u.C1(mVar);
    }

    @g1(version = "1.1")
    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double x(m mVar) {
        l0.p(mVar, "<this>");
        return u.D1(mVar);
    }

    @g1(version = "1.1")
    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float y(m mVar) {
        l0.p(mVar, "<this>");
        return u.E1(mVar);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T z(m<? extends T> mVar, i5.l<? super T, ? extends R> selector) {
        l0.p(mVar, "<this>");
        l0.p(selector, "selector");
        Iterator<? extends T> it = mVar.iterator();
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
}
