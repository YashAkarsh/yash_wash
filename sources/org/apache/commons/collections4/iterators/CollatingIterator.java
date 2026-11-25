package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: classes3.dex */
public class CollatingIterator<E> implements Iterator<E> {
    private Comparator<? super E> comparator;
    private List<Iterator<? extends E>> iterators;
    private int lastReturned;
    private BitSet valueSet;
    private List<E> values;

    public CollatingIterator() {
        this((Comparator) null, 2);
    }

    private boolean anyHasNext(List<Iterator<? extends E>> list) {
        Iterator<Iterator<? extends E>> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().hasNext()) {
                return true;
            }
        }
        return false;
    }

    private boolean anyValueSet(BitSet bitSet) {
        for (int i7 = 0; i7 < bitSet.size(); i7++) {
            if (bitSet.get(i7)) {
                return true;
            }
        }
        return false;
    }

    private void checkNotStarted() throws IllegalStateException {
        if (this.values != null) {
            throw new IllegalStateException("Can't do that after next or hasNext has been called.");
        }
    }

    private void clear(int i7) {
        this.values.set(i7, null);
        this.valueSet.clear(i7);
    }

    private int least() {
        Object obj = null;
        int i7 = -1;
        for (int i8 = 0; i8 < this.values.size(); i8++) {
            if (!this.valueSet.get(i8)) {
                set(i8);
            }
            if (this.valueSet.get(i8)) {
                if (i7 == -1) {
                    obj = this.values.get(i8);
                    i7 = i8;
                } else {
                    E e8 = this.values.get(i8);
                    Comparator<? super E> comparator = this.comparator;
                    if (comparator == null) {
                        throw new NullPointerException("You must invoke setComparator() to set a comparator first.");
                    }
                    if (comparator.compare(e8, obj) < 0) {
                        i7 = i8;
                        obj = e8;
                    }
                }
            }
        }
        return i7;
    }

    private boolean set(int i7) {
        Iterator<? extends E> it = this.iterators.get(i7);
        if (it.hasNext()) {
            this.values.set(i7, it.next());
            this.valueSet.set(i7);
            return true;
        }
        this.values.set(i7, null);
        this.valueSet.clear(i7);
        return false;
    }

    private void start() {
        if (this.values == null) {
            this.values = new ArrayList(this.iterators.size());
            this.valueSet = new BitSet(this.iterators.size());
            for (int i7 = 0; i7 < this.iterators.size(); i7++) {
                this.values.add(null);
                this.valueSet.clear(i7);
            }
        }
    }

    public void addIterator(Iterator<? extends E> it) {
        checkNotStarted();
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.iterators.add(it);
    }

    public Comparator<? super E> getComparator() {
        return this.comparator;
    }

    public int getIteratorIndex() {
        int i7 = this.lastReturned;
        if (i7 != -1) {
            return i7;
        }
        throw new IllegalStateException("No value has been returned yet");
    }

    public List<Iterator<? extends E>> getIterators() {
        return UnmodifiableList.unmodifiableList(this.iterators);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        start();
        return anyValueSet(this.valueSet) || anyHasNext(this.iterators);
    }

    @Override // java.util.Iterator
    public E next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int iLeast = least();
        if (iLeast == -1) {
            throw new NoSuchElementException();
        }
        E e8 = this.values.get(iLeast);
        clear(iLeast);
        this.lastReturned = iLeast;
        return e8;
    }

    @Override // java.util.Iterator
    public void remove() {
        int i7 = this.lastReturned;
        if (i7 == -1) {
            throw new IllegalStateException("No value can be removed at present");
        }
        this.iterators.get(i7).remove();
    }

    public void setComparator(Comparator<? super E> comparator) {
        checkNotStarted();
        this.comparator = comparator;
    }

    public void setIterator(int i7, Iterator<? extends E> it) {
        checkNotStarted();
        if (it == null) {
            throw new NullPointerException("Iterator must not be null");
        }
        this.iterators.set(i7, it);
    }

    public CollatingIterator(Comparator<? super E> comparator) {
        this(comparator, 2);
    }

    public CollatingIterator(Comparator<? super E> comparator, int i7) {
        this.comparator = null;
        this.iterators = null;
        this.values = null;
        this.valueSet = null;
        this.lastReturned = -1;
        this.iterators = new ArrayList(i7);
        setComparator(comparator);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E> it, Iterator<? extends E> it2) {
        this(comparator, 2);
        addIterator(it);
        addIterator(it2);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E>[] itArr) {
        this(comparator, itArr.length);
        for (Iterator<? extends E> it : itArr) {
            addIterator(it);
        }
    }

    public CollatingIterator(Comparator<? super E> comparator, Collection<Iterator<? extends E>> collection) {
        this(comparator, collection.size());
        Iterator<Iterator<? extends E>> it = collection.iterator();
        while (it.hasNext()) {
            addIterator(it.next());
        }
    }
}
