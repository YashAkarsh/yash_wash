package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayListIterator<E> extends ArrayIterator<E> implements ResettableListIterator<E> {
    private int lastItemIndex;

    public ArrayListIterator(Object obj) {
        super(obj);
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public boolean hasPrevious() {
        return this.index > this.startIndex;
    }

    @Override // org.apache.commons.collections4.iterators.ArrayIterator, java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i7 = this.index;
        this.lastItemIndex = i7;
        Object obj = this.array;
        this.index = i7 + 1;
        return (E) Array.get(obj, i7);
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index - this.startIndex;
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i7 = this.index - 1;
        this.index = i7;
        this.lastItemIndex = i7;
        return (E) Array.get(this.array, i7);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (this.index - this.startIndex) - 1;
    }

    @Override // org.apache.commons.collections4.iterators.ArrayIterator, org.apache.commons.collections4.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        int i7 = this.lastItemIndex;
        if (i7 == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        Array.set(this.array, i7, obj);
    }

    public ArrayListIterator(Object obj, int i7) {
        super(obj, i7);
        this.lastItemIndex = -1;
    }

    public ArrayListIterator(Object obj, int i7, int i8) {
        super(obj, i7, i8);
        this.lastItemIndex = -1;
    }
}
