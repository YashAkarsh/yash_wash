package org.apache.commons.collections4.set;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* JADX INFO: loaded from: classes3.dex */
public final class UnmodifiableNavigableSet<E> extends AbstractNavigableSetDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = 20150528;

    private UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        super(navigableSet);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return navigableSet instanceof Unmodifiable ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e8) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().descendingIterator());
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return unmodifiableNavigableSet(decorated().descendingSet());
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet<E> headSet(E e8) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(decorated().headSet(e8));
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet<E> subSet(E e8, E e9) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(decorated().subSet(e8, e9));
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet<E> tailSet(E e8) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(decorated().tailSet(e8));
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> headSet(E e8, boolean z7) {
        return unmodifiableNavigableSet(decorated().headSet(e8, z7));
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> subSet(E e8, boolean z7, E e9, boolean z8) {
        return unmodifiableNavigableSet(decorated().subSet(e8, z7, e9, z8));
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> tailSet(E e8, boolean z7) {
        return unmodifiableNavigableSet(decorated().tailSet(e8, z7));
    }
}
