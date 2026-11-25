package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public abstract class h5<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.common.base.a0<Iterable<E>> f20363a;

    static class a extends h5<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20364b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f20364b = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f20364b.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class b<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20365b;

        b(Iterable iterable) {
            this.f20365b = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ua.i(ua.c0(this.f20365b.iterator(), ma.Q()));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class c<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable[] f20366b;

        class a extends com.google.common.collect.d<Iterator<? extends T>> {
            a(int i7) {
                super(i7);
            }

            @Override // com.google.common.collect.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Iterator<? extends T> a(int i7) {
                return c.this.f20366b[i7].iterator();
            }
        }

        c(Iterable[] iterableArr) {
            this.f20366b = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ua.i(new a(this.f20366b.length));
        }
    }

    private static class d<E> implements com.google.common.base.s<Iterable<E>, h5<E>> {
        private d() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h5<E> apply(Iterable<E> iterable) {
            return h5.v(iterable);
        }
    }

    protected h5() {
        this.f20363a = com.google.common.base.a0.a();
    }

    @s1.a
    public static <E> h5<E> F() {
        return v(d7.x());
    }

    @s1.a
    public static <E> h5<E> G(E e8, E... eArr) {
        return v(ib.c(e8, eArr));
    }

    @s1.a
    public static <T> h5<T> g(Iterable<? extends Iterable<? extends T>> iterable) {
        com.google.common.base.e0.E(iterable);
        return new b(iterable);
    }

    @s1.a
    public static <T> h5<T> h(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return m(iterable, iterable2);
    }

    @s1.a
    public static <T> h5<T> j(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return m(iterable, iterable2, iterable3);
    }

    @s1.a
    public static <T> h5<T> k(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return m(iterable, iterable2, iterable3, iterable4);
    }

    @s1.a
    public static <T> h5<T> l(Iterable<? extends T>... iterableArr) {
        return m((Iterable[]) Arrays.copyOf(iterableArr, iterableArr.length));
    }

    private static <T> h5<T> m(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            com.google.common.base.e0.E(iterable);
        }
        return new c(iterableArr);
    }

    @Deprecated
    public static <E> h5<E> u(h5<E> h5Var) {
        return (h5) com.google.common.base.e0.E(h5Var);
    }

    public static <E> h5<E> v(Iterable<E> iterable) {
        return iterable instanceof h5 ? (h5) iterable : new a(iterable, iterable);
    }

    @s1.a
    public static <E> h5<E> w(E[] eArr) {
        return v(Arrays.asList(eArr));
    }

    private Iterable<E> x() {
        return this.f20363a.j(this);
    }

    @s1.a
    public final String A(com.google.common.base.w wVar) {
        return wVar.k(this);
    }

    public final com.google.common.base.a0<E> B() {
        E next;
        Iterable<E> iterableX = x();
        if (iterableX instanceof List) {
            List list = (List) iterableX;
            return list.isEmpty() ? com.google.common.base.a0.a() : com.google.common.base.a0.g(list.get(list.size() - 1));
        }
        Iterator<E> it = iterableX.iterator();
        if (!it.hasNext()) {
            return com.google.common.base.a0.a();
        }
        if (iterableX instanceof SortedSet) {
            return com.google.common.base.a0.g(((SortedSet) iterableX).last());
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return com.google.common.base.a0.g(next);
    }

    public final h5<E> D(int i7) {
        return v(ma.D(x(), i7));
    }

    public final h5<E> H(int i7) {
        return v(ma.M(x(), i7));
    }

    @s1.c
    public final E[] I(Class<E> cls) {
        return (E[]) ma.O(x(), cls);
    }

    public final d7<E> J() {
        return d7.p(x());
    }

    public final <V> v7<E, V> K(com.google.common.base.s<? super E, V> sVar) {
        return wb.G0(x(), sVar);
    }

    public final p8<E> L() {
        return p8.t(x());
    }

    public final u8<E> M() {
        return u8.o(x());
    }

    public final d7<E> N(Comparator<? super E> comparator) {
        return td.i(comparator).l(x());
    }

    public final s9<E> O(Comparator<? super E> comparator) {
        return s9.a0(comparator, x());
    }

    public final <T> h5<T> P(com.google.common.base.s<? super E, T> sVar) {
        return v(ma.S(x(), sVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> h5<T> Q(com.google.common.base.s<? super E, ? extends Iterable<? extends T>> sVar) {
        return g(P(sVar));
    }

    public final <K> v7<K, E> S(com.google.common.base.s<? super E, K> sVar) {
        return wb.Q0(x(), sVar);
    }

    public final boolean a(com.google.common.base.g0<? super E> g0Var) {
        return ma.b(x(), g0Var);
    }

    public final boolean b(com.google.common.base.g0<? super E> g0Var) {
        return ma.c(x(), g0Var);
    }

    public final boolean contains(Object obj) {
        return ma.k(x(), obj);
    }

    @s1.a
    public final h5<E> d(Iterable<? extends E> iterable) {
        return h(x(), iterable);
    }

    @s1.a
    public final h5<E> f(E... eArr) {
        return h(x(), Arrays.asList(eArr));
    }

    public final E get(int i7) {
        return (E) ma.t(x(), i7);
    }

    public final boolean isEmpty() {
        return !x().iterator().hasNext();
    }

    @u1.a
    public final <C extends Collection<? super E>> C n(C c8) {
        com.google.common.base.e0.E(c8);
        Iterable<E> iterableX = x();
        if (iterableX instanceof Collection) {
            c8.addAll(h3.b(iterableX));
        } else {
            Iterator<E> it = iterableX.iterator();
            while (it.hasNext()) {
                c8.add(it.next());
            }
        }
        return c8;
    }

    public final h5<E> o() {
        return v(ma.l(x()));
    }

    public final h5<E> p(com.google.common.base.g0<? super E> g0Var) {
        return v(ma.o(x(), g0Var));
    }

    @s1.c
    public final <T> h5<T> r(Class<T> cls) {
        return v(ma.p(x(), cls));
    }

    public final com.google.common.base.a0<E> s() {
        Iterator<E> it = x().iterator();
        return it.hasNext() ? com.google.common.base.a0.g(it.next()) : com.google.common.base.a0.a();
    }

    public final int size() {
        return ma.L(x());
    }

    public final Stream<E> stream() {
        return ri.D(x());
    }

    public final com.google.common.base.a0<E> t(com.google.common.base.g0<? super E> g0Var) {
        return ma.T(x(), g0Var);
    }

    public String toString() {
        return ma.R(x());
    }

    public final <K> q7<K, E> z(com.google.common.base.s<? super E, K> sVar) {
        return cd.w(x(), sVar);
    }

    h5(Iterable<E> iterable) {
        com.google.common.base.e0.E(iterable);
        this.f20363a = com.google.common.base.a0.d(this == iterable ? null : iterable);
    }
}
