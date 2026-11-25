package com.google.android.gms.internal.location;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
public abstract class q0<E> extends n0<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t0<Object> f16159b = new o0(r0.f16161e, 0);

    q0() {
    }

    public static <E> q0<E> l() {
        return (q0<E>) r0.f16161e;
    }

    public static <E> q0<E> m(Collection<? extends E> collection) {
        if (collection instanceof n0) {
            q0<E> q0VarG = ((n0) collection).g();
            if (!q0VarG.h()) {
                return q0VarG;
            }
            Object[] array = q0VarG.toArray();
            return n(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (array2[i7] == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i7);
                throw new NullPointerException(sb.toString());
            }
        }
        return n(array2, length);
    }

    static <E> q0<E> n(Object[] objArr, int i7) {
        return i7 == 0 ? (q0<E>) r0.f16161e : new r0(objArr, i7);
    }

    @Override // com.google.android.gms.internal.location.n0
    /* JADX INFO: renamed from: a */
    public final s0<E> iterator() {
        return listIterator(0);
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
    public final boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i7 = 0; i7 < size; i7++) {
                        if (j0.a(get(i7), list.get(i7))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = iterator();
                Iterator<E> it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && j0.a(it.next(), it2.next())) {
                    }
                }
                if (!it2.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.location.n0
    public final q0<E> g() {
        return this;
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
    public final int indexOf(@NullableDecl Object obj) {
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

    @Override // com.google.android.gms.internal.location.n0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.location.n0
    int j(Object[] objArr, int i7) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            objArr[i8] = get(i8);
        }
        return size;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public q0<E> subList(int i7, int i8) {
        k0.c(i7, i8, size());
        int i9 = i8 - i7;
        if (i9 == size()) {
            return this;
        }
        return i9 == 0 ? (q0<E>) r0.f16161e : new p0(this, i7, i9);
    }

    @Override // java.util.List
    public final int lastIndexOf(@NullableDecl Object obj) {
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
    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final t0<E> listIterator(int i7) {
        k0.b(i7, size(), "index");
        return isEmpty() ? (t0<E>) f16159b : new o0(this, i7);
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
}
