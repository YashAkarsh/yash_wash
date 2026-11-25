package com.google.android.gms.internal.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class h<E> extends d<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l<Object> f16105b = new f(j.f16114e, 0);

    h() {
    }

    static <E> h<E> l(Object[] objArr, int i7) {
        return i7 == 0 ? (h<E>) j.f16114e : new j(objArr, i7);
    }

    public static <E> h<E> m(Iterable<? extends E> iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return n((Collection) iterable);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return (h<E>) j.f16114e;
        }
        E next = it.next();
        if (!it.hasNext()) {
            return p(next);
        }
        e eVar = new e(4);
        eVar.c(next);
        eVar.d(it);
        eVar.f16095c = true;
        return l(eVar.f16093a, eVar.f16094b);
    }

    public static <E> h<E> n(Collection<? extends E> collection) {
        if (!(collection instanceof d)) {
            Object[] array = collection.toArray();
            int length = array.length;
            i.a(array, length);
            return l(array, length);
        }
        h<E> hVarF = ((d) collection).f();
        if (!hVarF.h()) {
            return hVarF;
        }
        Object[] array2 = hVarF.toArray();
        return l(array2, array2.length);
    }

    public static <E> h<E> o() {
        return (h<E>) j.f16114e;
    }

    public static <E> h<E> p(E e8) {
        Object[] objArr = {e8};
        i.a(objArr, 1);
        return l(objArr, 1);
    }

    public static <E> h<E> r(E e8, E e9) {
        Object[] objArr = {e8, e9};
        i.a(objArr, 2);
        return l(objArr, 2);
    }

    @Override // com.google.android.gms.internal.common.d
    int a(Object[] objArr, int i7) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            objArr[i8] = get(i8);
        }
        return size;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i7, E e8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i7, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i7 = 0; i7 < size; i7++) {
                        if (c0.a(get(i7), list.get(i7))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = iterator();
                Iterator<E> it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && c0.a(it.next(), it2.next())) {
                    }
                }
                if (!it2.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.common.d
    @Deprecated
    public final h<E> f() {
        return this;
    }

    @Override // com.google.android.gms.internal.common.d
    /* JADX INFO: renamed from: g */
    public final k<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i7 = 0; i7 < size; i7++) {
            iHashCode = (iHashCode * 31) + get(i7).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            if (obj.equals(get(i7))) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.d, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public h<E> subList(int i7, int i8) {
        d0.c(i7, i8, size());
        int i9 = i8 - i7;
        if (i9 == size()) {
            return this;
        }
        return i9 == 0 ? (h<E>) j.f16114e : new g(this, i7, i9);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i7, E e8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final l<E> listIterator(int i7) {
        d0.b(i7, size(), "index");
        return isEmpty() ? (l<E>) f16105b : new f(this, i7);
    }
}
