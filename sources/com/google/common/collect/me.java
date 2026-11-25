package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
final class me<E> extends s9<E> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final me<Comparable> f20663n = new me<>(d7.x(), td.A());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final transient d7<E> f20664m;

    me(d7<E> d7Var, Comparator<? super E> comparator) {
        super(comparator);
        this.f20664m = d7Var;
    }

    private int P0(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.f20664m, obj, Q0());
    }

    @Override // com.google.common.collect.s9
    s9<E> F0(E e8, boolean z7, E e9, boolean z8) {
        return I0(e8, z7).q0(e9, z8);
    }

    @Override // com.google.common.collect.s9
    s9<E> I0(E e8, boolean z7) {
        return M0(O0(e8, z7), size());
    }

    me<E> M0(int i7, int i8) {
        if (i7 == 0 && i8 == size()) {
            return this;
        }
        return i7 < i8 ? new me<>(this.f20664m.subList(i7, i8), this.f21059j) : s9.m0(this.f21059j);
    }

    int N0(E e8, boolean z7) {
        int iBinarySearch = Collections.binarySearch(this.f20664m, com.google.common.base.e0.E(e8), comparator());
        if (iBinarySearch >= 0) {
            return z7 ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    int O0(E e8, boolean z7) {
        int iBinarySearch = Collections.binarySearch(this.f20664m, com.google.common.base.e0.E(e8), comparator());
        if (iBinarySearch >= 0) {
            return z7 ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }

    Comparator<Object> Q0() {
        return this.f21059j;
    }

    @Override // com.google.common.collect.x6
    int b(Object[] objArr, int i7) {
        return this.f20664m.b(objArr, i7);
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    public E ceiling(E e8) {
        int iO0 = O0(e8, true);
        if (iO0 == size()) {
            return null;
        }
        return this.f20664m.get(iO0);
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return P0(obj) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof hd) {
            collection = ((hd) collection).e();
        }
        if (!rf.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        ck<E> it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int iK0 = K0(next2, next);
                if (iK0 < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iK0 == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iK0 > 0) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    @Override // com.google.common.collect.x6
    Object[] d() {
        return this.f20664m.d();
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!rf.b(this.f21059j, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            ck<E> it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || K0(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.common.collect.x6
    int f() {
        return this.f20664m.f();
    }

    @Override // com.google.common.collect.s9, java.util.SortedSet
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f20664m.get(0);
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    public E floor(E e8) {
        int iN0 = N0(e8, true) - 1;
        if (iN0 == -1) {
            return null;
        }
        return this.f20664m.get(iN0);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        this.f20664m.forEach(consumer);
    }

    @Override // com.google.common.collect.x6
    int g() {
        return this.f20664m.g();
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return this.f20664m.h();
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    public E higher(E e8) {
        int iO0 = O0(e8, false);
        if (iO0 == size()) {
            return null;
        }
        return this.f20664m.get(iO0);
    }

    @Override // com.google.common.collect.s9
    s9<E> i0() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.f21059j);
        return isEmpty() ? s9.m0(comparatorReverseOrder) : new me(this.f20664m.O(), comparatorReverseOrder);
    }

    @Override // com.google.common.collect.s9
    int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int iBinarySearch = Collections.binarySearch(this.f20664m, obj, Q0());
            if (iBinarySearch >= 0) {
                return iBinarySearch;
            }
            return -1;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    @Override // com.google.common.collect.s9, com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<E> iterator() {
        return this.f20664m.iterator();
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public ck<E> descendingIterator() {
        return this.f20664m.O().iterator();
    }

    @Override // com.google.common.collect.s9, java.util.SortedSet
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f20664m.get(size() - 1);
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    public E lower(E e8) {
        int iN0 = N0(e8, false) - 1;
        if (iN0 == -1) {
            return null;
        }
        return this.f20664m.get(iN0);
    }

    @Override // com.google.common.collect.s9
    s9<E> q0(E e8, boolean z7) {
        return M0(0, N0(e8, z7));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f20664m.size();
    }

    @Override // com.google.common.collect.s9, com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return a().spliterator();
    }

    @Override // com.google.common.collect.u8
    d7<E> v() {
        return size() <= 1 ? this.f20664m : new f9(this, this.f20664m);
    }
}
