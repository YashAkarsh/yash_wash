package org.apache.commons.collections4.list;

import com.alibaba.android.arouter.utils.b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;
import org.apache.commons.collections4.OrderedIterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractLinkedList<E> implements List<E> {
    transient Node<E> header;
    transient int modCount;
    transient int size;

    protected static class LinkedListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        protected Node<E> current;
        protected int expectedModCount;
        protected Node<E> next;
        protected int nextIndex;
        protected final AbstractLinkedList<E> parent;

        protected LinkedListIterator(AbstractLinkedList<E> abstractLinkedList, int i7) throws IndexOutOfBoundsException {
            this.parent = abstractLinkedList;
            this.expectedModCount = abstractLinkedList.modCount;
            this.next = abstractLinkedList.getNode(i7, true);
            this.nextIndex = i7;
        }

        @Override // java.util.ListIterator
        public void add(E e8) {
            checkModCount();
            this.parent.addNodeBefore(this.next, e8);
            this.current = null;
            this.nextIndex++;
            this.expectedModCount++;
        }

        protected void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        protected Node<E> getLastNodeReturned() throws IllegalStateException {
            Node<E> node = this.current;
            if (node != null) {
                return node;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.next.previous != this.parent.header;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkModCount();
            if (!hasNext()) {
                throw new NoSuchElementException("No element at index " + this.nextIndex + b.f12515h);
            }
            E value = this.next.getValue();
            Node<E> node = this.next;
            this.current = node;
            this.next = node.next;
            this.nextIndex++;
            return value;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public E previous() {
            checkModCount();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            Node<E> node = this.next.previous;
            this.next = node;
            E value = node.getValue();
            this.current = this.next;
            this.nextIndex--;
            return value;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return nextIndex() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkModCount();
            Node<E> node = this.current;
            Node<E> node2 = this.next;
            if (node == node2) {
                this.next = node2.next;
                this.parent.removeNode(getLastNodeReturned());
            } else {
                this.parent.removeNode(getLastNodeReturned());
                this.nextIndex--;
            }
            this.current = null;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(E e8) {
            checkModCount();
            getLastNodeReturned().setValue(e8);
        }
    }

    protected static class LinkedSubList<E> extends AbstractList<E> {
        int expectedModCount;
        int offset;
        AbstractLinkedList<E> parent;
        int size;

        protected LinkedSubList(AbstractLinkedList<E> abstractLinkedList, int i7, int i8) {
            if (i7 < 0) {
                throw new IndexOutOfBoundsException("fromIndex = " + i7);
            }
            if (i8 > abstractLinkedList.size()) {
                throw new IndexOutOfBoundsException("toIndex = " + i8);
            }
            if (i7 <= i8) {
                this.parent = abstractLinkedList;
                this.offset = i7;
                this.size = i8 - i7;
                this.expectedModCount = abstractLinkedList.modCount;
                return;
            }
            throw new IllegalArgumentException("fromIndex(" + i7 + ") > toIndex(" + i8 + ")");
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i7, E e8) {
            rangeCheck(i7, this.size + 1);
            checkModCount();
            this.parent.add(i7 + this.offset, e8);
            this.expectedModCount = this.parent.modCount;
            this.size++;
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> collection) {
            return addAll(this.size, collection);
        }

        protected void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkModCount();
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i7) {
            rangeCheck(i7, this.size);
            checkModCount();
            return this.parent.get(i7 + this.offset);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            checkModCount();
            return this.parent.createSubListIterator(this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i7) {
            rangeCheck(i7, this.size + 1);
            checkModCount();
            return this.parent.createSubListListIterator(this, i7);
        }

        protected void rangeCheck(int i7, int i8) {
            if (i7 < 0 || i7 >= i8) {
                throw new IndexOutOfBoundsException("Index '" + i7 + "' out of bounds for size '" + this.size + "'");
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int i7) {
            rangeCheck(i7, this.size);
            checkModCount();
            E eRemove = this.parent.remove(i7 + this.offset);
            this.expectedModCount = this.parent.modCount;
            this.size--;
            ((AbstractList) this).modCount++;
            return eRemove;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i7, E e8) {
            rangeCheck(i7, this.size);
            checkModCount();
            return this.parent.set(i7 + this.offset, e8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            checkModCount();
            return this.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int i7, int i8) {
            AbstractLinkedList<E> abstractLinkedList = this.parent;
            int i9 = this.offset;
            return new LinkedSubList(abstractLinkedList, i7 + i9, i8 + i9);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i7, Collection<? extends E> collection) {
            rangeCheck(i7, this.size + 1);
            int size = collection.size();
            if (size == 0) {
                return false;
            }
            checkModCount();
            this.parent.addAll(this.offset + i7, collection);
            this.expectedModCount = this.parent.modCount;
            this.size += size;
            ((AbstractList) this).modCount++;
            return true;
        }
    }

    protected static class LinkedSubListIterator<E> extends LinkedListIterator<E> {
        protected final LinkedSubList<E> sub;

        protected LinkedSubListIterator(LinkedSubList<E> linkedSubList, int i7) {
            super(linkedSubList.parent, i7 + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(E e8) {
            super.add(e8);
            LinkedSubList<E> linkedSubList = this.sub;
            linkedSubList.expectedModCount = this.parent.modCount;
            linkedSubList.size++;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return nextIndex() < this.sub.size;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            LinkedSubList<E> linkedSubList = this.sub;
            linkedSubList.expectedModCount = this.parent.modCount;
            linkedSubList.size--;
        }
    }

    protected AbstractLinkedList() {
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E e8) {
        addLast(e8);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(this.size, collection);
    }

    public boolean addFirst(E e8) {
        addNodeAfter(this.header, e8);
        return true;
    }

    public boolean addLast(E e8) {
        addNodeBefore(this.header, e8);
        return true;
    }

    protected void addNode(Node<E> node, Node<E> node2) {
        node.next = node2;
        node.previous = node2.previous;
        node2.previous.next = node;
        node2.previous = node;
        this.size++;
        this.modCount++;
    }

    protected void addNodeAfter(Node<E> node, E e8) {
        addNode(createNode(e8), node.next);
    }

    protected void addNodeBefore(Node<E> node, E e8) {
        addNode(createNode(e8), node);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        removeAllNodes();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    protected Node<E> createHeaderNode() {
        return new Node<>();
    }

    protected Node<E> createNode(E e8) {
        return new Node<>(e8);
    }

    protected Iterator<E> createSubListIterator(LinkedSubList<E> linkedSubList) {
        return createSubListListIterator(linkedSubList, 0);
    }

    protected ListIterator<E> createSubListListIterator(LinkedSubList<E> linkedSubList, int i7) {
        return new LinkedSubListIterator(linkedSubList, i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        init();
        int i7 = objectInputStream.readInt();
        for (int i8 = 0; i8 < i7; i8++) {
            add(objectInputStream.readObject());
        }
    }

    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != size()) {
            return false;
        }
        ListIterator<E> listIterator = listIterator();
        ListIterator<E> listIterator2 = list.listIterator();
        while (listIterator.hasNext() && listIterator2.hasNext()) {
            E next = listIterator.next();
            E next2 = listIterator2.next();
            if (next == null) {
                if (next2 != null) {
                    return false;
                }
            } else if (!next.equals(next2)) {
                return false;
            }
        }
        return (listIterator.hasNext() || listIterator2.hasNext()) ? false : true;
    }

    @Override // java.util.List
    public E get(int i7) {
        return getNode(i7, false).getValue();
    }

    public E getFirst() {
        Node<E> node = this.header;
        Node<E> node2 = node.next;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        Node<E> node = this.header;
        Node<E> node2 = node.previous;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    protected Node<E> getNode(int i7, boolean z7) throws IndexOutOfBoundsException {
        if (i7 < 0) {
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + i7 + ") less than zero.");
        }
        if (!z7 && i7 == this.size) {
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + i7 + ") is the size of the list.");
        }
        int i8 = this.size;
        if (i7 > i8) {
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + i7 + ") greater than the size of the list (" + this.size + ").");
        }
        if (i7 >= i8 / 2) {
            Node<E> node = this.header;
            while (i8 > i7) {
                node = node.previous;
                i8--;
            }
            return node;
        }
        Node<E> node2 = this.header.next;
        for (int i9 = 0; i9 < i7; i9++) {
            node2 = node2.next;
        }
        return node2;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            E next = it.next();
            iHashCode = (iHashCode * 31) + (next == null ? 0 : next.hashCode());
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i7 = 0;
        for (Node<E> node = this.header.next; node != this.header; node = node.next) {
            if (isEqualValue(node.getValue(), obj)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    protected void init() {
        this.header = createHeaderNode();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    protected boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i7 = this.size - 1;
        Node<E> node = this.header;
        while (true) {
            node = node.previous;
            if (node == this.header) {
                return -1;
            }
            if (isEqualValue(node.getValue(), obj)) {
                return i7;
            }
            i7--;
        }
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new LinkedListIterator(this, 0);
    }

    @Override // java.util.List
    public E remove(int i7) {
        Node<E> node = getNode(i7, false);
        E value = node.getValue();
        removeNode(node);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Iterator<E> it = iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    protected void removeAllNodes() {
        Node<E> node = this.header;
        node.next = node;
        node.previous = node;
        this.size = 0;
        this.modCount++;
    }

    public E removeFirst() {
        Node<E> node = this.header;
        Node<E> node2 = node.next;
        if (node2 == node) {
            throw new NoSuchElementException();
        }
        E value = node2.getValue();
        removeNode(node2);
        return value;
    }

    public E removeLast() {
        Node<E> node = this.header;
        Node<E> node2 = node.previous;
        if (node2 == node) {
            throw new NoSuchElementException();
        }
        E value = node2.getValue();
        removeNode(node2);
        return value;
    }

    protected void removeNode(Node<E> node) {
        Node<E> node2 = node.previous;
        node2.next = node.next;
        node.next.previous = node2;
        this.size--;
        this.modCount++;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
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

    @Override // java.util.List
    public E set(int i7, E e8) {
        Node<E> node = getNode(i7, false);
        E value = node.getValue();
        updateNode(node, e8);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.List
    public List<E> subList(int i7, int i8) {
        return new LinkedSubList(this, i7, i8);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[this.size]);
    }

    public String toString() {
        if (size() == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(size() * 16);
        sb.append('[');
        Iterator<E> it = iterator();
        boolean zHasNext = it.hasNext();
        while (zHasNext) {
            Object next = it.next();
            if (next == this) {
                next = "(this Collection)";
            }
            sb.append(next);
            zHasNext = it.hasNext();
            if (zHasNext) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    protected void updateNode(Node<E> node, E e8) {
        node.setValue(e8);
    }

    protected AbstractLinkedList(Collection<? extends E> collection) {
        init();
        addAll(collection);
    }

    @Override // java.util.List
    public void add(int i7, E e8) {
        addNodeBefore(getNode(i7, true), e8);
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection<? extends E> collection) {
        Node<E> node = getNode(i7, true);
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            addNodeBefore(node, it.next());
        }
        return true;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i7) {
        return new LinkedListIterator(this, i7);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.size));
        }
        Node<E> node = this.header.next;
        int i7 = 0;
        while (node != this.header) {
            tArr[i7] = node.getValue();
            node = node.next;
            i7++;
        }
        int length = tArr.length;
        int i8 = this.size;
        if (length > i8) {
            tArr[i8] = null;
        }
        return tArr;
    }

    protected static class Node<E> {
        protected Node<E> next;
        protected Node<E> previous;
        protected E value;

        protected Node() {
            this.previous = this;
            this.next = this;
        }

        protected Node<E> getNextNode() {
            return this.next;
        }

        protected Node<E> getPreviousNode() {
            return this.previous;
        }

        protected E getValue() {
            return this.value;
        }

        protected void setNextNode(Node<E> node) {
            this.next = node;
        }

        protected void setPreviousNode(Node<E> node) {
            this.previous = node;
        }

        protected void setValue(E e8) {
            this.value = e8;
        }

        protected Node(E e8) {
            this.value = e8;
        }

        protected Node(Node<E> node, Node<E> node2, E e8) {
            this.previous = node;
            this.next = node2;
            this.value = e8;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        Node<E> node = this.header;
        do {
            node = node.next;
            if (node == this.header) {
                return false;
            }
        } while (!isEqualValue(node.getValue(), obj));
        removeNode(node);
        return true;
    }
}
