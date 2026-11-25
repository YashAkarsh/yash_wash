package org.apache.commons.collections4.multiset;

import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.collection.SynchronizedCollection;

/* JADX INFO: loaded from: classes3.dex */
public class SynchronizedMultiSet<E> extends SynchronizedCollection<E> implements MultiSet<E> {
    private static final long serialVersionUID = 20150629;

    static class SynchronizedSet<T> extends SynchronizedCollection<T> implements Set<T> {
        private static final long serialVersionUID = 20150629;

        SynchronizedSet(Set<T> set, Object obj) {
            super(set, obj);
        }
    }

    protected SynchronizedMultiSet(MultiSet<E> multiSet) {
        super(multiSet);
    }

    public static <E> SynchronizedMultiSet<E> synchronizedMultiSet(MultiSet<E> multiSet) {
        return new SynchronizedMultiSet<>(multiSet);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int add(E e8, int i7) {
        int iAdd;
        synchronized (this.lock) {
            iAdd = decorated().add(e8, i7);
        }
        return iAdd;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        SynchronizedSet synchronizedSet;
        synchronized (this.lock) {
            synchronizedSet = new SynchronizedSet(decorated().entrySet(), this.lock);
        }
        return synchronizedSet;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            zEquals = decorated().equals(obj);
        }
        return zEquals;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = decorated().getCount(obj);
        }
        return count;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public int hashCode() {
        int iHashCode;
        synchronized (this.lock) {
            iHashCode = decorated().hashCode();
        }
        return iHashCode;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int remove(Object obj, int i7) {
        int iRemove;
        synchronized (this.lock) {
            iRemove = decorated().remove(obj, i7);
        }
        return iRemove;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E e8, int i7) {
        int count;
        synchronized (this.lock) {
            count = decorated().setCount(e8, i7);
        }
        return count;
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        SynchronizedSet synchronizedSet;
        synchronized (this.lock) {
            synchronizedSet = new SynchronizedSet(decorated().uniqueSet(), this.lock);
        }
        return synchronizedSet;
    }

    protected SynchronizedMultiSet(MultiSet<E> multiSet, Object obj) {
        super(multiSet, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.SynchronizedCollection
    public MultiSet<E> decorated() {
        return (MultiSet) super.decorated();
    }
}
