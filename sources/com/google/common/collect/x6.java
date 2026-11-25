package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public abstract class x6<E> extends AbstractCollection<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f21400a = 1296;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object[] f21401b = new Object[0];

    public static abstract class a<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f21402a = 4;

        a() {
        }

        static int f(int i7, int i8) {
            if (i8 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i7 + (i7 >> 1) + 1;
            if (iHighestOneBit < i8) {
                iHighestOneBit = Integer.highestOneBit(i8 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        @u1.a
        public abstract a<E> a(E e8);

        @u1.a
        public a<E> b(E... eArr) {
            for (E e8 : eArr) {
                a(e8);
            }
            return this;
        }

        @u1.a
        public a<E> c(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        @u1.a
        public a<E> d(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public abstract x6<E> e();
    }

    x6() {
    }

    public d7<E> a() {
        int size = size();
        if (size != 0) {
            return size != 1 ? new de(this, toArray()) : d7.z(iterator().next());
        }
        return d7.x();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @u1.a
    @Deprecated
    public final boolean add(E e8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @u1.a
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @u1.a
    int b(Object[] objArr, int i7) {
        ck<E> it = iterator();
        while (it.hasNext()) {
            objArr[i7] = it.next();
            i7++;
        }
        return i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    Object[] d() {
        return null;
    }

    int f() {
        throw new UnsupportedOperationException();
    }

    int g() {
        throw new UnsupportedOperationException();
    }

    abstract boolean h();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public abstract ck<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @u1.a
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @u1.a
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    @u1.a
    @Deprecated
    public final boolean removeIf(Predicate<? super E> predicate) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, f21400a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f21401b);
    }

    Object writeReplace() {
        return new d7.d(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @u1.a
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.e0.E(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrD = d();
            if (objArrD != null) {
                return (T[]) vd.a(objArrD, g(), f(), tArr);
            }
            tArr = (T[]) sd.j(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        b(tArr, 0);
        return tArr;
    }
}
