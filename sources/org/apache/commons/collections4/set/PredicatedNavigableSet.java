package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class PredicatedNavigableSet<E> extends PredicatedSortedSet<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    protected PredicatedNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        super(navigableSet, predicate);
    }

    public static <E> PredicatedNavigableSet<E> predicatedNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        return new PredicatedNavigableSet<>(navigableSet, predicate);
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
        return predicatedNavigableSet(decorated().descendingSet(), this.predicate);
    }

    @Override // java.util.NavigableSet
    public E floor(E e8) {
        return decorated().floor(e8);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e8, boolean z7) {
        return predicatedNavigableSet(decorated().headSet(e8, z7), this.predicate);
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
        return predicatedNavigableSet(decorated().subSet(e8, z7, e9, z8), this.predicate);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e8, boolean z7) {
        return predicatedNavigableSet(decorated().tailSet(e8, z7), this.predicate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.set.PredicatedSortedSet, org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public NavigableSet<E> decorated() {
        return (NavigableSet) super.decorated();
    }
}
