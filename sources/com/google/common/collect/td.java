package com.google.common.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class td<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f21133a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f21134b = -1;

    @s1.d
    static class a extends td<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicInteger f21135c = new AtomicInteger(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ConcurrentMap<Object, Integer> f21136d = vd.k(new nb()).i();

        a() {
        }

        private Integer J(Object obj) {
            Integer num = this.f21136d.get(obj);
            if (num != null) {
                return num;
            }
            Integer numValueOf = Integer.valueOf(this.f21135c.getAndIncrement());
            Integer numPutIfAbsent = this.f21136d.putIfAbsent(obj, numValueOf);
            return numPutIfAbsent != null ? numPutIfAbsent : numValueOf;
        }

        int K(Object obj) {
            return System.identityHashCode(obj);
        }

        @Override // com.google.common.collect.td, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int iK = K(obj);
            int iK2 = K(obj2);
            if (iK != iK2) {
                return iK < iK2 ? -1 : 1;
            }
            int iCompareTo = J(obj).compareTo(J(obj2));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final td<Object> f21137a = new a();

        private b() {
        }
    }

    @s1.d
    static class c extends ClassCastException {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f21138b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f21139a;

        c(Object obj) {
            super("Cannot compare value: " + obj);
            this.f21139a = obj;
        }
    }

    protected td() {
    }

    @s1.b(serializable = true)
    public static <C extends Comparable> td<C> A() {
        return pd.f20900e;
    }

    @s1.b(serializable = true)
    public static td<Object> I() {
        return fk.f20273c;
    }

    @s1.b(serializable = true)
    public static td<Object> a() {
        return i0.f20398c;
    }

    public static td<Object> b() {
        return b.f21137a;
    }

    @s1.b(serializable = true)
    public static <T> td<T> d(Iterable<? extends Comparator<? super T>> iterable) {
        return new e4(iterable);
    }

    @s1.b(serializable = true)
    public static <T> td<T> f(T t7, T... tArr) {
        return g(ib.c(t7, tArr));
    }

    @s1.b(serializable = true)
    public static <T> td<T> g(List<T> list) {
        return new x4(list);
    }

    @s1.b(serializable = true)
    @Deprecated
    public static <T> td<T> h(td<T> tdVar) {
        return (td) com.google.common.base.e0.E(tdVar);
    }

    @s1.b(serializable = true)
    public static <T> td<T> i(Comparator<T> comparator) {
        return comparator instanceof td ? (td) comparator : new r3(comparator);
    }

    @s1.b(serializable = true)
    public <S extends T> td<S> B() {
        return new qd(this);
    }

    @s1.b(serializable = true)
    public <S extends T> td<S> C() {
        return new rd(this);
    }

    <T2 extends T> td<Map.Entry<T2, ?>> D() {
        return (td<Map.Entry<T2, ?>>) E(wb.W());
    }

    @s1.b(serializable = true)
    public <F> td<F> E(com.google.common.base.s<F, ? extends T> sVar) {
        return new t0(sVar, this);
    }

    @s1.b(serializable = true)
    public <S extends T> td<S> F() {
        return new pe(this);
    }

    @u1.a
    public <E extends T> List<E> H(Iterable<E> iterable) {
        Object[] objArrN = ma.N(iterable);
        Arrays.sort(objArrN, this);
        return ib.r(Arrays.asList(objArrN));
    }

    @Deprecated
    public int c(List<? extends T> list, T t7) {
        return Collections.binarySearch(list, t7, this);
    }

    @Override // java.util.Comparator
    @u1.a
    public abstract int compare(T t7, T t8);

    @s1.b(serializable = true)
    public <U extends T> td<U> e(Comparator<? super U> comparator) {
        return new e4(this, (Comparator) com.google.common.base.e0.E(comparator));
    }

    public <E extends T> List<E> j(Iterable<E> iterable, int i7) {
        return F().o(iterable, i7);
    }

    public <E extends T> List<E> k(Iterator<E> it, int i7) {
        return F().p(it, i7);
    }

    @u1.a
    public <E extends T> d7<E> l(Iterable<E> iterable) {
        return d7.S(this, iterable);
    }

    public boolean m(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean n(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public <E extends T> List<E> o(Iterable<E> iterable, int i7) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= ((long) i7) * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i7) {
                    array = Arrays.copyOf(array, i7);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return p(iterable.iterator(), i7);
    }

    public <E extends T> List<E> p(Iterator<E> it, int i7) {
        com.google.common.base.e0.E(it);
        f2.b(i7, "k");
        if (i7 == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i7 < 1073741823) {
            tj tjVarE = tj.e(i7, this);
            tjVarE.h(it);
            return tjVarE.k();
        }
        ArrayList arrayListS = ib.s(it);
        Collections.sort(arrayListS, this);
        if (arrayListS.size() > i7) {
            arrayListS.subList(i7, arrayListS.size()).clear();
        }
        arrayListS.trimToSize();
        return Collections.unmodifiableList(arrayListS);
    }

    @s1.b(serializable = true)
    public <S extends T> td<Iterable<S>> q() {
        return new bb(this);
    }

    @u1.a
    public <E extends T> E r(Iterable<E> iterable) {
        return (E) v(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @u1.a
    public <E extends T> E t(E e8, E e9) {
        return compare(e8, e9) >= 0 ? e8 : e9;
    }

    @u1.a
    public <E extends T> E u(E e8, E e9, E e10, E... eArr) {
        E e11 = (E) t(t(e8, e9), e10);
        for (E e12 : eArr) {
            e11 = (E) t(e11, e12);
        }
        return e11;
    }

    @u1.a
    public <E extends T> E v(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) t(next, it.next());
        }
        return next;
    }

    @u1.a
    public <E extends T> E w(Iterable<E> iterable) {
        return (E) z(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @u1.a
    public <E extends T> E x(E e8, E e9) {
        return compare(e8, e9) <= 0 ? e8 : e9;
    }

    @u1.a
    public <E extends T> E y(E e8, E e9, E e10, E... eArr) {
        E e11 = (E) x(x(e8, e9), e10);
        for (E e12 : eArr) {
            e11 = (E) x(e11, e12);
        }
        return e11;
    }

    @u1.a
    public <E extends T> E z(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) x(next, it.next());
        }
        return next;
    }
}
