package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class h6<E> extends d6<E> implements SortedSet<E> {
    protected h6() {
    }

    private int B0(Object obj, Object obj2) {
        Comparator<? super E> comparator = comparator();
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    @s1.a
    protected SortedSet<E> A0(E e8, E e9) {
        return tailSet(e8).headSet(e9);
    }

    public Comparator<? super E> comparator() {
        return z0().comparator();
    }

    public E first() {
        return z0().first();
    }

    public SortedSet<E> headSet(E e8) {
        return z0().headSet(e8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.j5
    @s1.a
    protected boolean i0(Object obj) {
        try {
            return B0(tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    public E last() {
        return z0().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.j5
    @s1.a
    protected boolean m0(Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (it.hasNext() && B0(it.next(), obj) == 0) {
                it.remove();
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public SortedSet<E> subSet(E e8, E e9) {
        return z0().subSet(e8, e9);
    }

    public SortedSet<E> tailSet(E e8) {
        return z0().tailSet(e8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.d6
    public abstract SortedSet<E> w0();
}
