package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.SynchronizedCollection;

/* JADX INFO: loaded from: classes3.dex */
public class SynchronizedBag<E> extends SynchronizedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 8084674570753837109L;

    class SynchronizedBagSet extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 2990565892366827855L;

        SynchronizedBagSet(Set<E> set, Object obj) {
            super(set, obj);
        }
    }

    protected SynchronizedBag(Bag<E> bag) {
        super(bag);
    }

    public static <E> SynchronizedBag<E> synchronizedBag(Bag<E> bag) {
        return new SynchronizedBag<>(bag);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e8, int i7) {
        boolean zAdd;
        synchronized (this.lock) {
            zAdd = getBag().add(e8, i7);
        }
        return zAdd;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            zEquals = getBag().equals(obj);
        }
        return zEquals;
    }

    protected Bag<E> getBag() {
        return (Bag) decorated();
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = getBag().getCount(obj);
        }
        return count;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public int hashCode() {
        int iHashCode;
        synchronized (this.lock) {
            iHashCode = getBag().hashCode();
        }
        return iHashCode;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i7) {
        boolean zRemove;
        synchronized (this.lock) {
            zRemove = getBag().remove(obj, i7);
        }
        return zRemove;
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        SynchronizedBagSet synchronizedBagSet;
        synchronized (this.lock) {
            synchronizedBagSet = new SynchronizedBagSet(getBag().uniqueSet(), this.lock);
        }
        return synchronizedBagSet;
    }

    protected SynchronizedBag(Bag<E> bag, Object obj) {
        super(bag, obj);
    }
}
