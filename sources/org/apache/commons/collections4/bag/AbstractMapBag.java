package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMapBag<E> implements Bag<E> {
    private transient Map<E, MutableInteger> map;
    private transient int modCount;
    private int size;
    private transient Set<E> uniqueSet;

    static class BagIterator<E> implements Iterator<E> {
        private final Iterator<Map.Entry<E, MutableInteger>> entryIterator;
        private int itemCount;
        private final int mods;
        private final AbstractMapBag<E> parent;
        private Map.Entry<E, MutableInteger> current = null;
        private boolean canRemove = false;

        public BagIterator(AbstractMapBag<E> abstractMapBag) {
            this.parent = abstractMapBag;
            this.entryIterator = ((AbstractMapBag) abstractMapBag).map.entrySet().iterator();
            this.mods = ((AbstractMapBag) abstractMapBag).modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (((AbstractMapBag) this.parent).modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (this.itemCount == 0) {
                Map.Entry<E, MutableInteger> next = this.entryIterator.next();
                this.current = next;
                this.itemCount = next.getValue().value;
            }
            this.canRemove = true;
            this.itemCount--;
            return this.current.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (((AbstractMapBag) this.parent).modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            MutableInteger value = this.current.getValue();
            int i7 = value.value;
            if (i7 > 1) {
                value.value = i7 - 1;
            } else {
                this.entryIterator.remove();
            }
            AbstractMapBag.access$210(this.parent);
            this.canRemove = false;
        }
    }

    protected static class MutableInteger {
        protected int value;

        MutableInteger(int i7) {
            this.value = i7;
        }

        public boolean equals(Object obj) {
            return (obj instanceof MutableInteger) && ((MutableInteger) obj).value == this.value;
        }

        public int hashCode() {
            return this.value;
        }
    }

    protected AbstractMapBag() {
    }

    static /* synthetic */ int access$210(AbstractMapBag abstractMapBag) {
        int i7 = abstractMapBag.size;
        abstractMapBag.size = i7 - 1;
        return i7;
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean add(E e8) {
        return add(e8, 1);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (true) {
            boolean z7 = false;
            while (it.hasNext()) {
                boolean zAdd = add(it.next());
                if (z7 || zAdd) {
                    z7 = true;
                }
            }
            return z7;
        }
    }

    @Override // java.util.Collection
    public void clear() {
        this.modCount++;
        this.map.clear();
        this.size = 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return collection instanceof Bag ? containsAll((Bag<?>) collection) : containsAll((Bag<?>) new HashBag(collection));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void doReadObject(Map<E, MutableInteger> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.map = map;
        int i7 = objectInputStream.readInt();
        for (int i8 = 0; i8 < i7; i8++) {
            Object object = objectInputStream.readObject();
            int i9 = objectInputStream.readInt();
            map.put(object, new MutableInteger(i9));
            this.size += i9;
        }
    }

    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.map.size());
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().value);
        }
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bag)) {
            return false;
        }
        Bag bag = (Bag) obj;
        if (bag.size() != size()) {
            return false;
        }
        for (E e8 : this.map.keySet()) {
            if (bag.getCount(e8) != getCount(e8)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger != null) {
            return mutableInteger.value;
        }
        return 0;
    }

    protected Map<E, MutableInteger> getMap() {
        return this.map;
    }

    @Override // java.util.Collection
    public int hashCode() {
        int iHashCode = 0;
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            E key = entry.getKey();
            iHashCode += entry.getValue().value ^ (key == null ? 0 : key.hashCode());
        }
        return iHashCode;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new BagIterator(this);
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean remove(Object obj) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger == null) {
            return false;
        }
        this.modCount++;
        this.map.remove(obj);
        this.size -= mutableInteger.value;
        return true;
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            return false;
        }
        Iterator<?> it = collection.iterator();
        while (true) {
            boolean z7 = false;
            while (it.hasNext()) {
                boolean zRemove = remove(it.next(), 1);
                if (z7 || zRemove) {
                    z7 = true;
                }
            }
            return z7;
        }
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return collection instanceof Bag ? retainAll((Bag<?>) collection) : retainAll((Bag<?>) new HashBag(collection));
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i7 = 0;
        for (E e8 : this.map.keySet()) {
            int count = getCount(e8);
            while (count > 0) {
                objArr[i7] = e8;
                count--;
                i7++;
            }
        }
        return objArr;
    }

    public String toString() {
        if (size() == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<E> it = uniqueSet().iterator();
        while (it.hasNext()) {
            E next = it.next();
            sb.append(getCount(next));
            sb.append(':');
            sb.append(next);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        if (this.uniqueSet == null) {
            this.uniqueSet = UnmodifiableSet.unmodifiableSet(this.map.keySet());
        }
        return this.uniqueSet;
    }

    protected AbstractMapBag(Map<E, MutableInteger> map) {
        this.map = map;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e8, int i7) {
        this.modCount++;
        if (i7 > 0) {
            MutableInteger mutableInteger = this.map.get(e8);
            this.size += i7;
            if (mutableInteger == null) {
                this.map.put(e8, new MutableInteger(i7));
                return true;
            }
            mutableInteger.value += i7;
        }
        return false;
    }

    boolean containsAll(Bag<?> bag) {
        for (Object obj : bag.uniqueSet()) {
            if (getCount(obj) < bag.getCount(obj)) {
                return false;
            }
        }
        return true;
    }

    boolean retainAll(Bag<?> bag) {
        HashBag hashBag = new HashBag();
        for (E e8 : uniqueSet()) {
            int count = getCount(e8);
            int count2 = bag.getCount(e8);
            if (1 <= count2 && count2 <= count) {
                hashBag.add(e8, count - count2);
            } else {
                hashBag.add(e8, count);
            }
        }
        if (hashBag.isEmpty()) {
            return false;
        }
        return removeAll(hashBag);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i7) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger == null || i7 <= 0) {
            return false;
        }
        this.modCount++;
        int i8 = mutableInteger.value;
        if (i7 < i8) {
            mutableInteger.value = i8 - i7;
            this.size -= i7;
        } else {
            this.map.remove(obj);
            this.size -= mutableInteger.value;
        }
        return true;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        int i7 = 0;
        for (E e8 : this.map.keySet()) {
            int count = getCount(e8);
            while (count > 0) {
                tArr[i7] = e8;
                count--;
                i7++;
            }
        }
        while (i7 < tArr.length) {
            tArr[i7] = null;
            i7++;
        }
        return tArr;
    }
}
