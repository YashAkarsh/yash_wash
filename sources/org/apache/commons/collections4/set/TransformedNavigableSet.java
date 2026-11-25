package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes3.dex */
public class TransformedNavigableSet<E> extends TransformedSortedSet<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    protected TransformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        super(navigableSet, transformer);
    }

    public static <E> TransformedNavigableSet<E> transformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        TransformedNavigableSet<E> transformedNavigableSet = new TransformedNavigableSet<>(navigableSet, transformer);
        if (navigableSet.size() > 0) {
            Object[] array = navigableSet.toArray();
            navigableSet.clear();
            for (Object obj : array) {
                transformedNavigableSet.decorated().add(transformer.transform(obj));
            }
        }
        return transformedNavigableSet;
    }

    public static <E> TransformedNavigableSet<E> transformingNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        return new TransformedNavigableSet<>(navigableSet, transformer);
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
        return transformingNavigableSet(decorated().descendingSet(), this.transformer);
    }

    @Override // java.util.NavigableSet
    public E floor(E e8) {
        return decorated().floor(e8);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e8, boolean z7) {
        return transformingNavigableSet(decorated().headSet(e8, z7), this.transformer);
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
        return transformingNavigableSet(decorated().subSet(e8, z7, e9, z8), this.transformer);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e8, boolean z7) {
        return transformingNavigableSet(decorated().tailSet(e8, z7), this.transformer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public NavigableSet<E> decorated() {
        return (NavigableSet) super.decorated();
    }
}
