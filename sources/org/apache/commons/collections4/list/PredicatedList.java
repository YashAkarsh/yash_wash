package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

/* JADX INFO: loaded from: classes3.dex */
public class PredicatedList<E> extends PredicatedCollection<E> implements List<E> {
    private static final long serialVersionUID = -5722039223898659102L;

    protected class PredicatedListIterator extends AbstractListIteratorDecorator<E> {
        protected PredicatedListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E e8) {
            PredicatedList.this.validate(e8);
            getListIterator().add(e8);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E e8) {
            PredicatedList.this.validate(e8);
            getListIterator().set(e8);
        }
    }

    protected PredicatedList(List<E> list, Predicate<? super E> predicate) {
        super(list, predicate);
    }

    public static <T> PredicatedList<T> predicatedList(List<T> list, Predicate<? super T> predicate) {
        return new PredicatedList<>(list, predicate);
    }

    @Override // java.util.List
    public void add(int i7, E e8) {
        validate(e8);
        decorated().add(i7, e8);
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            validate(it.next());
        }
        return decorated().addAll(i7, collection);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.List
    public E get(int i7) {
        return decorated().get(i7);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return decorated().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return decorated().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public E remove(int i7) {
        return decorated().remove(i7);
    }

    @Override // java.util.List
    public E set(int i7, E e8) {
        validate(e8);
        return decorated().set(i7, e8);
    }

    @Override // java.util.List
    public List<E> subList(int i7, int i8) {
        return new PredicatedList(decorated().subList(i7, i8), this.predicate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public List<E> decorated() {
        return (List) super.decorated();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i7) {
        return new PredicatedListIterator(decorated().listIterator(i7));
    }
}
