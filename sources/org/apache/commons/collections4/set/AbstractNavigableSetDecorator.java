package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractNavigableSetDecorator<E> extends AbstractSortedSetDecorator<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    protected AbstractNavigableSetDecorator() {
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e8) {
        return decorated().ceiling(e8);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return decorated().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return decorated().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E e8) {
        return decorated().floor(e8);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e8, boolean z7) {
        return decorated().headSet(e8, z7);
    }

    @Override // java.util.NavigableSet
    public E higher(E e8) {
        return decorated().higher(e8);
    }

    @Override // java.util.NavigableSet
    public E lower(E e8) {
        return decorated().lower(e8);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return decorated().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return decorated().pollLast();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e8, boolean z7, E e9, boolean z8) {
        return decorated().subSet(e8, z7, e9, z8);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e8, boolean z7) {
        return decorated().tailSet(e8, z7);
    }

    protected AbstractNavigableSetDecorator(NavigableSet<E> navigableSet) {
        super(navigableSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public NavigableSet<E> decorated() {
        return (NavigableSet) super.decorated();
    }
}
