package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectArrayListIterator<E> extends ObjectArrayIterator<E> implements ResettableListIterator<E> {
    private int lastItemIndex;

    public ObjectArrayListIterator(E... eArr) {
        super(eArr);
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void add(E e8) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public boolean hasPrevious() {
        return this.index > getStartIndex();
    }

    @Override // org.apache.commons.collections4.iterators.ObjectArrayIterator, java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i7 = this.index;
        this.lastItemIndex = i7;
        E[] eArr = this.array;
        this.index = i7 + 1;
        return eArr[i7];
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index - getStartIndex();
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i7 = this.index - 1;
        this.index = i7;
        this.lastItemIndex = i7;
        return this.array[i7];
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (this.index - getStartIndex()) - 1;
    }

    @Override // org.apache.commons.collections4.iterators.ObjectArrayIterator, org.apache.commons.collections4.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void set(E e8) {
        int i7 = this.lastItemIndex;
        if (i7 == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        this.array[i7] = e8;
    }

    public ObjectArrayListIterator(E[] eArr, int i7) {
        super(eArr, i7);
        this.lastItemIndex = -1;
    }

    public ObjectArrayListIterator(E[] eArr, int i7, int i8) {
        super(eArr, i7, i8);
        this.lastItemIndex = -1;
    }
}
