package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

/* JADX INFO: loaded from: classes3.dex */
public class TransformedList<E> extends TransformedCollection<E> implements List<E> {
    private static final long serialVersionUID = 1077193035000013141L;

    protected class TransformedListIterator extends AbstractListIteratorDecorator<E> {
        protected TransformedListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E e8) {
            getListIterator().add(TransformedList.this.transform(e8));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E e8) {
            getListIterator().set(TransformedList.this.transform(e8));
        }
    }

    protected TransformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        super(list, transformer);
    }

    public static <E> TransformedList<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        TransformedList<E> transformedList = new TransformedList<>(list, transformer);
        if (list.size() > 0) {
            Object[] array = list.toArray();
            list.clear();
            for (Object obj : array) {
                transformedList.decorated().add(transformer.transform(obj));
            }
        }
        return transformedList;
    }

    public static <E> TransformedList<E> transformingList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        return new TransformedList<>(list, transformer);
    }

    @Override // java.util.List
    public void add(int i7, E e8) {
        getList().add(i7, transform(e8));
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection<? extends E> collection) {
        return getList().addAll(i7, transform((Collection) collection));
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.List
    public E get(int i7) {
        return getList().get(i7);
    }

    protected List<E> getList() {
        return (List) decorated();
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public E remove(int i7) {
        return getList().remove(i7);
    }

    @Override // java.util.List
    public E set(int i7, E e8) {
        return getList().set(i7, transform(e8));
    }

    @Override // java.util.List
    public List<E> subList(int i7, int i8) {
        return new TransformedList(getList().subList(i7, i8), this.transformer);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i7) {
        return new TransformedListIterator(getList().listIterator(i7));
    }
}
