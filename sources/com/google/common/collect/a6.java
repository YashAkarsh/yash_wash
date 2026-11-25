package com.google.common.collect;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class a6<E> extends h6<E> implements NavigableSet<E> {

    @s1.a
    protected class a extends af.h<E> {
        public a() {
            super(a6.this);
        }
    }

    protected a6() {
    }

    @Override // com.google.common.collect.h6
    protected SortedSet<E> A0(E e8, E e9) {
        return subSet(e8, true, e9, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.h6
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract NavigableSet<E> w0();

    protected E D0(E e8) {
        return (E) ua.J(tailSet(e8, true).iterator(), null);
    }

    protected E E0() {
        return iterator().next();
    }

    protected E F0(E e8) {
        return (E) ua.J(headSet(e8, true).descendingIterator(), null);
    }

    protected SortedSet<E> G0(E e8) {
        return headSet(e8, false);
    }

    protected E H0(E e8) {
        return (E) ua.J(tailSet(e8, false).iterator(), null);
    }

    protected E I0() {
        return descendingIterator().next();
    }

    protected E J0(E e8) {
        return (E) ua.J(headSet(e8, false).descendingIterator(), null);
    }

    protected E K0() {
        return (E) ua.U(iterator());
    }

    protected E L0() {
        return (E) ua.U(descendingIterator());
    }

    @s1.a
    protected NavigableSet<E> M0(E e8, boolean z7, E e9, boolean z8) {
        return tailSet(e8, z7).headSet(e9, z8);
    }

    protected SortedSet<E> N0(E e8) {
        return tailSet(e8, true);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e8) {
        return c0().ceiling(e8);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return c0().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return c0().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E e8) {
        return c0().floor(e8);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e8, boolean z7) {
        return c0().headSet(e8, z7);
    }

    @Override // java.util.NavigableSet
    public E higher(E e8) {
        return c0().higher(e8);
    }

    @Override // java.util.NavigableSet
    public E lower(E e8) {
        return c0().lower(e8);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return c0().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return c0().pollLast();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e8, boolean z7, E e9, boolean z8) {
        return c0().subSet(e8, z7, e9, z8);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e8, boolean z7) {
        return c0().tailSet(e8, z7);
    }
}
