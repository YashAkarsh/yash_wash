package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public abstract class d7<E> extends x6<E> implements List<E>, RandomAccess {

    class a extends com.google.common.collect.d<E> {
        a(int i7, int i8) {
            super(i7, i8);
        }

        @Override // com.google.common.collect.d
        protected E a(int i7) {
            return d7.this.get(i7);
        }
    }

    public static final class b<E> extends x6.a<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @s1.d
        Object[] f20112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f20114d;

        public b() {
            this(4);
        }

        private void i(Object[] objArr, int i7) {
            n(this.f20113c + i7);
            System.arraycopy(objArr, 0, this.f20112b, this.f20113c, i7);
            this.f20113c += i7;
        }

        private void n(int i7) {
            Object[] objArr = this.f20112b;
            if (objArr.length < i7) {
                this.f20112b = Arrays.copyOf(objArr, x6.a.f(objArr.length, i7));
                this.f20114d = false;
            } else if (this.f20114d) {
                this.f20112b = Arrays.copyOf(objArr, objArr.length);
                this.f20114d = false;
            }
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b<E> a(E e8) {
            com.google.common.base.e0.E(e8);
            n(this.f20113c + 1);
            Object[] objArr = this.f20112b;
            int i7 = this.f20113c;
            this.f20113c = i7 + 1;
            objArr[i7] = e8;
            return this;
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b<E> b(E... eArr) {
            sd.b(eArr);
            i(eArr, eArr.length);
            return this;
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public b<E> c(Iterable<? extends E> iterable) {
            com.google.common.base.e0.E(iterable);
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                n(this.f20113c + collection.size());
                if (collection instanceof x6) {
                    this.f20113c = ((x6) collection).b(this.f20112b, this.f20113c);
                    return this;
                }
            }
            super.c(iterable);
            return this;
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public b<E> d(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        @Override // com.google.common.collect.x6.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public d7<E> e() {
            this.f20114d = true;
            return d7.l(this.f20112b, this.f20113c);
        }

        @u1.a
        b<E> m(b<E> bVar) {
            com.google.common.base.e0.E(bVar);
            i(bVar.f20112b, bVar.f20113c);
            return this;
        }

        b(int i7) {
            this.f20112b = new Object[i7];
            this.f20113c = 0;
        }
    }

    private static class c<E> extends d7<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient d7<E> f20115c;

        c(d7<E> d7Var) {
            this.f20115c = d7Var;
        }

        private int W(int i7) {
            return (size() - 1) - i7;
        }

        private int X(int i7) {
            return size() - i7;
        }

        @Override // com.google.common.collect.d7
        public d7<E> O() {
            return this.f20115c;
        }

        @Override // com.google.common.collect.d7, java.util.List
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public d7<E> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            return this.f20115c.subList(X(i8), X(i7)).O();
        }

        @Override // com.google.common.collect.d7, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f20115c.contains(obj);
        }

        @Override // java.util.List
        public E get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return this.f20115c.get(W(i7));
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return this.f20115c.h();
        }

        @Override // com.google.common.collect.d7, java.util.List
        public int indexOf(Object obj) {
            int iLastIndexOf = this.f20115c.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return W(iLastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.d7, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.d7, java.util.List
        public int lastIndexOf(Object obj) {
            int iIndexOf = this.f20115c.indexOf(obj);
            if (iIndexOf >= 0) {
                return W(iIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.d7, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20115c.size();
        }

        @Override // com.google.common.collect.d7, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i7) {
            return super.listIterator(i7);
        }
    }

    static class d implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f20116b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object[] f20117a;

        d(Object[] objArr) {
            this.f20117a = objArr;
        }

        Object readResolve() {
            return d7.u(this.f20117a);
        }
    }

    class e extends d7<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient int f20118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final transient int f20119d;

        e(int i7, int i8) {
            this.f20118c = i7;
            this.f20119d = i8;
        }

        @Override // com.google.common.collect.d7, java.util.List
        /* JADX INFO: renamed from: T */
        public d7<E> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, this.f20119d);
            d7 d7Var = d7.this;
            int i9 = this.f20118c;
            return d7Var.subList(i7 + i9, i8 + i9);
        }

        @Override // java.util.List
        public E get(int i7) {
            com.google.common.base.e0.C(i7, this.f20119d);
            return d7.this.get(i7 + this.f20118c);
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return true;
        }

        @Override // com.google.common.collect.d7, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.d7, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20119d;
        }

        @Override // com.google.common.collect.d7, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i7) {
            return super.listIterator(i7);
        }
    }

    d7() {
    }

    public static <E> d7<E> A(E e8, E e9) {
        return o(e8, e9);
    }

    public static <E> d7<E> B(E e8, E e9, E e10) {
        return o(e8, e9, e10);
    }

    public static <E> d7<E> D(E e8, E e9, E e10, E e11) {
        return o(e8, e9, e10, e11);
    }

    public static <E> d7<E> F(E e8, E e9, E e10, E e11, E e12) {
        return o(e8, e9, e10, e11, e12);
    }

    public static <E> d7<E> H(E e8, E e9, E e10, E e11, E e12, E e13) {
        return o(e8, e9, e10, e11, e12, e13);
    }

    public static <E> d7<E> I(E e8, E e9, E e10, E e11, E e12, E e13, E e14) {
        return o(e8, e9, e10, e11, e12, e13, e14);
    }

    public static <E> d7<E> J(E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15) {
        return o(e8, e9, e10, e11, e12, e13, e14, e15);
    }

    public static <E> d7<E> K(E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        return o(e8, e9, e10, e11, e12, e13, e14, e15, e16);
    }

    public static <E> d7<E> L(E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17) {
        return o(e8, e9, e10, e11, e12, e13, e14, e15, e16, e17);
    }

    public static <E> d7<E> M(E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18) {
        return o(e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18);
    }

    @SafeVarargs
    public static <E> d7<E> N(E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E... eArr) {
        com.google.common.base.e0.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e8;
        objArr[1] = e9;
        objArr[2] = e10;
        objArr[3] = e11;
        objArr[4] = e12;
        objArr[5] = e13;
        objArr[6] = e14;
        objArr[7] = e15;
        objArr[8] = e16;
        objArr[9] = e17;
        objArr[10] = e18;
        objArr[11] = e19;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return o(objArr);
    }

    public static <E extends Comparable<? super E>> d7<E> P(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) ma.P(iterable, new Comparable[0]);
        sd.b(comparableArr);
        Arrays.sort(comparableArr);
        return k(comparableArr);
    }

    public static <E> d7<E> S(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.e0.E(comparator);
        Object[] objArrN = ma.N(iterable);
        sd.b(objArrN);
        Arrays.sort(objArrN, comparator);
        return k(objArrN);
    }

    @s1.a
    public static <E> Collector<E, ?, d7<E>> V() {
        return e2.n();
    }

    static <E> d7<E> k(Object[] objArr) {
        return l(objArr, objArr.length);
    }

    static <E> d7<E> l(Object[] objArr, int i7) {
        if (i7 == 0) {
            return x();
        }
        if (i7 == 1) {
            return z(objArr[0]);
        }
        if (i7 < objArr.length) {
            objArr = Arrays.copyOf(objArr, i7);
        }
        return new he(objArr);
    }

    public static <E> b<E> m() {
        return new b<>();
    }

    @s1.a
    public static <E> b<E> n(int i7) {
        f2.b(i7, "expectedSize");
        return new b<>(i7);
    }

    private static <E> d7<E> o(Object... objArr) {
        return k(sd.b(objArr));
    }

    public static <E> d7<E> p(Iterable<? extends E> iterable) {
        com.google.common.base.e0.E(iterable);
        return iterable instanceof Collection ? r((Collection) iterable) : t(iterable.iterator());
    }

    public static <E> d7<E> r(Collection<? extends E> collection) {
        if (!(collection instanceof x6)) {
            return o(collection.toArray());
        }
        d7<E> d7VarA = ((x6) collection).a();
        return d7VarA.h() ? k(d7VarA.toArray()) : d7VarA;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> d7<E> t(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return x();
        }
        E next = it.next();
        return !it.hasNext() ? z(next) : new b().a(next).d(it).e();
    }

    public static <E> d7<E> u(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            return length != 1 ? o((Object[]) eArr.clone()) : z(eArr[0]);
        }
        return x();
    }

    public static <E> d7<E> x() {
        return (d7<E>) he.f20395d;
    }

    public static <E> d7<E> z(E e8) {
        return new nf(e8);
    }

    public d7<E> O() {
        return size() <= 1 ? this : new c(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: T */
    public d7<E> subList(int i7, int i8) {
        com.google.common.base.e0.f0(i7, i8, size());
        int i9 = i8 - i7;
        if (i9 == size()) {
            return this;
        }
        if (i9 == 0) {
            return x();
        }
        return i9 == 1 ? z(get(i7)) : U(i7, i8);
    }

    d7<E> U(int i7, int i8) {
        return new e(i7, i8 - i7);
    }

    @Override // com.google.common.collect.x6
    public final d7<E> a() {
        return this;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i7, E e8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @u1.a
    @Deprecated
    public final boolean addAll(int i7, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.x6
    int b(Object[] objArr, int i7) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            objArr[i7 + i8] = get(i8);
        }
        return i7 + size;
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return ib.j(this, obj);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        com.google.common.base.e0.E(consumer);
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            consumer.accept(get(i7));
        }
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i7 = 1;
        for (int i8 = 0; i8 < size; i8++) {
            i7 = ~(~((i7 * 31) + get(i8).hashCode()));
        }
        return i7;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return ib.l(this, obj);
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public ck<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return ib.n(this, obj);
    }

    @Override // java.util.List
    @u1.a
    @Deprecated
    public final E remove(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void replaceAll(UnaryOperator<E> unaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @u1.a
    @Deprecated
    public final E set(int i7, E e8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void sort(Comparator<? super E> comparator) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return q2.c(size(), 1296, new c7(this));
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public dk<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public dk<E> listIterator(int i7) {
        return new a(size(), i7);
    }

    @Override // com.google.common.collect.x6
    Object writeReplace() {
        return new d(toArray());
    }
}
