package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractListDecorator<E> extends AbstractCollectionDecorator<E> implements List<E> {
    private static final long serialVersionUID = 4500739654952315623L;

    protected AbstractListDecorator() {
    }

    @Override // java.util.List
    public void add(int i7, E e8) {
        decorated().add(i7, e8);
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection<? extends E> collection) {
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
        return decorated().listIterator();
    }

    @Override // java.util.List
    public E remove(int i7) {
        return decorated().remove(i7);
    }

    @Override // java.util.List
    public E set(int i7, E e8) {
        return decorated().set(i7, e8);
    }

    @Override // java.util.List
    public List<E> subList(int i7, int i8) {
        return decorated().subList(i7, i8);
    }

    protected AbstractListDecorator(List<E> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public List<E> decorated() {
        return (List) super.decorated();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i7) {
        return decorated().listIterator(i7);
    }
}
