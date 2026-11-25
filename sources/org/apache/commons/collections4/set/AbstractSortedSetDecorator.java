package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSortedSetDecorator<E> extends AbstractSetDecorator<E> implements SortedSet<E> {
    private static final long serialVersionUID = -3462240946294214398L;

    protected AbstractSortedSetDecorator() {
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return decorated().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return decorated().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e8) {
        return decorated().headSet(e8);
    }

    @Override // java.util.SortedSet
    public E last() {
        return decorated().last();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e8, E e9) {
        return decorated().subSet(e8, e9);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e8) {
        return decorated().tailSet(e8);
    }

    protected AbstractSortedSetDecorator(Set<E> set) {
        super(set);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public SortedSet<E> decorated() {
        return (SortedSet) super.decorated();
    }
}
