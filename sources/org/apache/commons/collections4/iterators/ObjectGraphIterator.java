package org.apache.commons.collections4.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectGraphIterator<E> implements Iterator<E> {
    private Iterator<? extends E> currentIterator;
    private E currentValue;
    private boolean hasNext;
    private Iterator<? extends E> lastUsedIterator;
    private E root;
    private final Deque<Iterator<? extends E>> stack;
    private final Transformer<? super E, ? extends E> transformer;

    public ObjectGraphIterator(E e8, Transformer<? super E, ? extends E> transformer) {
        this.stack = new ArrayDeque(8);
        this.hasNext = false;
        if (e8 instanceof Iterator) {
            this.currentIterator = (Iterator) e8;
        } else {
            this.root = e8;
        }
        this.transformer = transformer;
    }

    protected void findNext(E e8) {
        if (e8 instanceof Iterator) {
            findNextByIterator((Iterator) e8);
        } else {
            this.currentValue = e8;
            this.hasNext = true;
        }
    }

    protected void findNextByIterator(Iterator<? extends E> it) {
        Iterator<? extends E> it2 = this.currentIterator;
        if (it != it2) {
            if (it2 != null) {
                this.stack.push(it2);
            }
            this.currentIterator = it;
        }
        while (this.currentIterator.hasNext() && !this.hasNext) {
            E next = this.currentIterator.next();
            Transformer<? super E, ? extends E> transformer = this.transformer;
            if (transformer != null) {
                next = transformer.transform(next);
            }
            findNext(next);
        }
        if (this.hasNext || this.stack.isEmpty()) {
            return;
        }
        Iterator<? extends E> itPop = this.stack.pop();
        this.currentIterator = itPop;
        findNextByIterator(itPop);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        updateCurrentIterator();
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public E next() {
        updateCurrentIterator();
        if (!this.hasNext) {
            throw new NoSuchElementException("No more elements in the iteration");
        }
        this.lastUsedIterator = this.currentIterator;
        E e8 = this.currentValue;
        this.currentValue = null;
        this.hasNext = false;
        return e8;
    }

    @Override // java.util.Iterator
    public void remove() {
        Iterator<? extends E> it = this.lastUsedIterator;
        if (it == null) {
            throw new IllegalStateException("Iterator remove() cannot be called at this time");
        }
        it.remove();
        this.lastUsedIterator = null;
    }

    protected void updateCurrentIterator() {
        if (this.hasNext) {
            return;
        }
        Iterator<? extends E> it = this.currentIterator;
        if (it != null) {
            findNextByIterator(it);
            return;
        }
        E e8 = this.root;
        if (e8 == null) {
            return;
        }
        Transformer<? super E, ? extends E> transformer = this.transformer;
        if (transformer == null) {
            findNext(e8);
        } else {
            findNext(transformer.transform(e8));
        }
        this.root = null;
    }

    public ObjectGraphIterator(Iterator<? extends E> it) {
        this.stack = new ArrayDeque(8);
        this.hasNext = false;
        this.currentIterator = it;
        this.transformer = null;
    }
}
