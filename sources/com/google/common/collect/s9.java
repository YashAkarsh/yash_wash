package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public abstract class s9<E> extends t9<E> implements NavigableSet<E>, qf<E> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final int f21058l = 1301;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final transient Comparator<? super E> f21059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @s1.c
    @v1.b
    transient s9<E> f21060k;

    class a extends Spliterators.AbstractSpliterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ck<E> f21061a;

        a(long j7, int i7) {
            super(j7, i7);
            this.f21061a = s9.this.iterator();
        }

        @Override // java.util.Spliterator
        public Comparator<? super E> getComparator() {
            return s9.this.f21059j;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            if (!this.f21061a.hasNext()) {
                return false;
            }
            consumer.accept(this.f21061a.next());
            return true;
        }
    }

    public static final class b<E> extends u8.a<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Comparator<? super E> f21063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private E[] f21064e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f21065f;

        public b(Comparator<? super E> comparator) {
            super(true);
            this.f21063d = (Comparator) com.google.common.base.e0.E(comparator);
            this.f21064e = (E[]) new Object[4];
            this.f21065f = 0;
        }

        private void v() {
            int i7 = this.f21065f;
            if (i7 == 0) {
                return;
            }
            Arrays.sort(this.f21064e, 0, i7, this.f21063d);
            int i8 = 1;
            int i9 = 1;
            while (true) {
                int i10 = this.f21065f;
                if (i8 >= i10) {
                    Arrays.fill(this.f21064e, i9, i10, (Object) null);
                    this.f21065f = i9;
                    return;
                }
                Comparator<? super E> comparator = this.f21063d;
                E[] eArr = this.f21064e;
                int iCompare = comparator.compare(eArr[i9 - 1], eArr[i8]);
                if (iCompare < 0) {
                    E[] eArr2 = this.f21064e;
                    eArr2[i9] = eArr2[i8];
                    i9++;
                } else if (iCompare > 0) {
                    throw new AssertionError("Comparator " + this.f21063d + " compare method violates its contract");
                }
                i8++;
            }
        }

        @Override // com.google.common.collect.u8.a
        void m() {
            E[] eArr = this.f21064e;
            this.f21064e = (E[]) Arrays.copyOf(eArr, eArr.length);
        }

        @Override // com.google.common.collect.u8.a
        @u1.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e8) {
            com.google.common.base.e0.E(e8);
            n();
            if (this.f21065f == this.f21064e.length) {
                v();
                int i7 = this.f21065f;
                int iF = x6.a.f(i7, i7 + 1);
                E[] eArr = this.f21064e;
                if (iF > eArr.length) {
                    this.f21064e = (E[]) Arrays.copyOf(eArr, iF);
                }
            }
            E[] eArr2 = this.f21064e;
            int i8 = this.f21065f;
            this.f21065f = i8 + 1;
            eArr2[i8] = e8;
            return this;
        }

        @Override // com.google.common.collect.u8.a
        @u1.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public b<E> b(E... eArr) {
            sd.b(eArr);
            for (E e8 : eArr) {
                a(e8);
            }
            return this;
        }

        @Override // com.google.common.collect.u8.a
        @u1.a
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public b<E> c(Iterable<? extends E> iterable) {
            super.c(iterable);
            return this;
        }

        @Override // com.google.common.collect.u8.a
        @u1.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b<E> d(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        @Override // com.google.common.collect.u8.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public s9<E> e() {
            v();
            if (this.f21065f == 0) {
                return s9.m0(this.f21063d);
            }
            this.f21179c = true;
            return new me(d7.l(this.f21064e, this.f21065f), this.f21063d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.u8.a
        @u1.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b<E> l(u8.a<E> aVar) {
            n();
            b bVar = (b) aVar;
            for (int i7 = 0; i7 < bVar.f21065f; i7++) {
                a(bVar.f21064e[i7]);
            }
            return this;
        }
    }

    private static class c<E> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f21066c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Comparator<? super E> f21067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object[] f21068b;

        public c(Comparator<? super E> comparator, Object[] objArr) {
            this.f21067a = comparator;
            this.f21068b = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            return new b(this.f21067a).b(this.f21068b).e();
        }
    }

    s9(Comparator<? super E> comparator) {
        this.f21059j = comparator;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/s9<TE;>; */
    public static s9 A0(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        int length = comparableArr.length + 6;
        Comparable[] comparableArr2 = new Comparable[length];
        comparableArr2[0] = comparable;
        comparableArr2[1] = comparable2;
        comparableArr2[2] = comparable3;
        comparableArr2[3] = comparable4;
        comparableArr2[4] = comparable5;
        comparableArr2[5] = comparable6;
        System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
        return X(td.A(), length, comparableArr2);
    }

    public static <E> b<E> B0(Comparator<E> comparator) {
        return new b<>(comparator);
    }

    public static <E extends Comparable<?>> b<E> C0() {
        return new b<>(Collections.reverseOrder());
    }

    @s1.a
    public static <E> Collector<E, ?, s9<E>> J0(Comparator<? super E> comparator) {
        return e2.t(comparator);
    }

    static int L0(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> s9<E> X(Comparator<? super E> comparator, int i7, E... eArr) {
        if (i7 == 0) {
            return m0(comparator);
        }
        sd.c(eArr, i7);
        Arrays.sort(eArr, 0, i7, comparator);
        int i8 = 1;
        for (int i9 = 1; i9 < i7; i9++) {
            a1.d dVar = (Object) eArr[i9];
            if (comparator.compare(dVar, (Object) eArr[i8 - 1]) != 0) {
                eArr[i8] = dVar;
                i8++;
            }
        }
        Arrays.fill(eArr, i8, i7, (Object) null);
        return new me(d7.l(eArr, i8), comparator);
    }

    public static <E> s9<E> Y(Iterable<? extends E> iterable) {
        return a0(td.A(), iterable);
    }

    public static <E> s9<E> Z(Collection<? extends E> collection) {
        return b0(td.A(), collection);
    }

    public static <E> s9<E> a0(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.e0.E(comparator);
        if (rf.b(comparator, iterable) && (iterable instanceof s9)) {
            s9<E> s9Var = (s9) iterable;
            if (!s9Var.h()) {
                return s9Var;
            }
        }
        Object[] objArrN = ma.N(iterable);
        return X(comparator, objArrN.length, objArrN);
    }

    public static <E> s9<E> b0(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return a0(comparator, collection);
    }

    public static <E> s9<E> c0(Comparator<? super E> comparator, Iterator<? extends E> it) {
        return new b(comparator).d(it).e();
    }

    public static <E> s9<E> d0(Iterator<? extends E> it) {
        return c0(td.A(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/s9<TE;>; */
    public static s9 e0(Comparable[] comparableArr) {
        return X(td.A(), comparableArr.length, (Object[]) comparableArr.clone());
    }

    public static <E> s9<E> f0(SortedSet<E> sortedSet) {
        Comparator comparatorA = rf.a(sortedSet);
        d7 d7VarR = d7.r(sortedSet);
        return d7VarR.isEmpty() ? m0(comparatorA) : new me(d7VarR, comparatorA);
    }

    static <E> me<E> m0(Comparator<? super E> comparator) {
        return td.A().equals(comparator) ? (me<E>) me.f20663n : new me<>(d7.x(), comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> b<E> s0() {
        return new b<>(td.A());
    }

    public static <E> s9<E> t0() {
        return me.f20663n;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/s9<TE;>; */
    public static s9 u0(Comparable comparable) {
        return new me(d7.z(comparable), td.A());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/s9<TE;>; */
    public static s9 w0(Comparable comparable, Comparable comparable2) {
        return X(td.A(), 2, comparable, comparable2);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/s9<TE;>; */
    public static s9 x0(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return X(td.A(), 3, comparable, comparable2, comparable3);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/s9<TE;>; */
    public static s9 y0(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return X(td.A(), 4, comparable, comparable2, comparable3, comparable4);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/s9<TE;>; */
    public static s9 z0(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return X(td.A(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public s9<E> subSet(E e8, E e9) {
        return subSet(e8, true, e9, false);
    }

    @Override // java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public s9<E> subSet(E e8, boolean z7, E e9, boolean z8) {
        com.google.common.base.e0.E(e8);
        com.google.common.base.e0.E(e9);
        com.google.common.base.e0.d(this.f21059j.compare(e8, e9) <= 0);
        return F0(e8, z7, e9, z8);
    }

    abstract s9<E> F0(E e8, boolean z7, E e9, boolean z8);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public s9<E> tailSet(E e8) {
        return tailSet(e8, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public s9<E> tailSet(E e8, boolean z7) {
        return I0(com.google.common.base.e0.E(e8), z7);
    }

    abstract s9<E> I0(E e8, boolean z7);

    int K0(Object obj, Object obj2) {
        return L0(this.f21059j, obj, obj2);
    }

    @s1.c
    public E ceiling(E e8) {
        return (E) ma.v(tailSet(e8, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.qf
    public Comparator<? super E> comparator() {
        return this.f21059j;
    }

    public E first() {
        return iterator().next();
    }

    @s1.c
    public E floor(E e8) {
        return (E) ua.J(headSet(e8, true).descendingIterator(), null);
    }

    @s1.c
    public E higher(E e8) {
        return (E) ma.v(tailSet(e8, false), null);
    }

    @s1.c
    abstract s9<E> i0();

    abstract int indexOf(Object obj);

    @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public abstract ck<E> iterator();

    @Override // java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: j0 */
    public abstract ck<E> descendingIterator();

    @Override // java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public s9<E> descendingSet() {
        s9<E> s9Var = this.f21060k;
        if (s9Var != null) {
            return s9Var;
        }
        s9<E> s9VarI0 = i0();
        this.f21060k = s9VarI0;
        s9VarI0.f21060k = this;
        return s9VarI0;
    }

    public E last() {
        return descendingIterator().next();
    }

    @s1.c
    public E lower(E e8) {
        return (E) ua.J(headSet(e8, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public s9<E> headSet(E e8) {
        return headSet(e8, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public s9<E> headSet(E e8, boolean z7) {
        return q0(com.google.common.base.e0.E(e8), z7);
    }

    @Override // java.util.NavigableSet
    @u1.a
    @s1.c
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @u1.a
    @s1.c
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    abstract s9<E> q0(E e8, boolean z7);

    @Override // com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return new a(size(), 1365);
    }

    @Override // com.google.common.collect.u8, com.google.common.collect.x6
    Object writeReplace() {
        return new c(this.f21059j, toArray());
    }
}
