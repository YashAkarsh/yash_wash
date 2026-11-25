package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.SortedBag;

/* JADX INFO: loaded from: classes3.dex */
public final class CollectionSortedBag<E> extends AbstractSortedBagDecorator<E> {
    private static final long serialVersionUID = -2560033712679053143L;

    public CollectionSortedBag(SortedBag<E> sortedBag) {
        super(sortedBag);
    }

    public static <E> SortedBag<E> collectionSortedBag(SortedBag<E> sortedBag) {
        return new CollectionSortedBag(sortedBag);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e8) {
        return add(e8, 1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (true) {
            boolean z7 = false;
            while (it.hasNext()) {
                boolean zAdd = add(it.next(), 1);
                if (z7 || zAdd) {
                    z7 = true;
                }
            }
            return z7;
        }
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        return remove(obj, 1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            return decorated().removeAll(null);
        }
        while (true) {
            boolean z7 = false;
            for (Object obj : collection) {
                boolean zRemove = remove(obj, getCount(obj));
                if (z7 || zRemove) {
                    z7 = true;
                }
            }
            return z7;
        }
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            return decorated().retainAll(null);
        }
        Iterator<E> it = iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    @Override // org.apache.commons.collections4.bag.AbstractBagDecorator, org.apache.commons.collections4.Bag
    public boolean add(E e8, int i7) {
        decorated().add(e8, i7);
        return true;
    }
}
