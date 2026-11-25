package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayIterator<E> implements ResettableIterator<E> {
    final Object array;
    final int endIndex;
    int index;
    final int startIndex;

    public ArrayIterator(Object obj) {
        this(obj, 0);
    }

    protected void checkBound(int i7, int i8, String str) {
        if (i7 > i8) {
            throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + str + "s beyond the end of the array. ");
        }
        if (i7 >= 0) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + str + "s before the start of the array. ");
    }

    public Object getArray() {
        return this.array;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    @Override // java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.array;
        int i7 = this.index;
        this.index = i7 + 1;
        return (E) Array.get(obj, i7);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }

    public ArrayIterator(Object obj, int i7) {
        this(obj, i7, Array.getLength(obj));
    }

    public ArrayIterator(Object obj, int i7, int i8) {
        this.array = obj;
        this.startIndex = i7;
        this.endIndex = i8;
        this.index = i7;
        int length = Array.getLength(obj);
        checkBound(i7, length, "start");
        checkBound(i8, length, "end");
        if (i8 < i7) {
            throw new IllegalArgumentException("End index must not be less than start index.");
        }
    }
}
