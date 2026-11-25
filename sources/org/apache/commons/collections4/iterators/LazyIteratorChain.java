package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LazyIteratorChain<E> implements Iterator<E> {
    private int callCounter = 0;
    private boolean chainExhausted = false;
    private Iterator<? extends E> currentIterator = null;
    private Iterator<? extends E> lastUsedIterator = null;

    private void updateCurrentIterator() {
        int i7 = this.callCounter;
        if (i7 == 0) {
            int i8 = i7 + 1;
            this.callCounter = i8;
            Iterator<? extends E> itNextIterator = nextIterator(i8);
            this.currentIterator = itNextIterator;
            if (itNextIterator == null) {
                this.currentIterator = EmptyIterator.emptyIterator();
                this.chainExhausted = true;
            }
            this.lastUsedIterator = this.currentIterator;
        }
        while (!this.currentIterator.hasNext() && !this.chainExhausted) {
            int i9 = this.callCounter + 1;
            this.callCounter = i9;
            Iterator<? extends E> itNextIterator2 = nextIterator(i9);
            if (itNextIterator2 != null) {
                this.currentIterator = itNextIterator2;
            } else {
                this.chainExhausted = true;
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.next();
    }

    protected abstract Iterator<? extends E> nextIterator(int i7);

    @Override // java.util.Iterator
    public void remove() {
        if (this.currentIterator == null) {
            updateCurrentIterator();
        }
        this.lastUsedIterator.remove();
    }
}
