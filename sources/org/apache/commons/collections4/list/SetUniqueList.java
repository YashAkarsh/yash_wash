package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: classes3.dex */
public class SetUniqueList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = 7196982186153478694L;
    private final Set<E> set;

    static class SetListIterator<E> extends AbstractIteratorDecorator<E> {
        private E last;
        private final Set<E> set;

        protected SetListIterator(Iterator<E> it, Set<E> set) {
            super(it);
            this.last = null;
            this.set = set;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E e8 = (E) super.next();
            this.last = e8;
            return e8;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }
    }

    static class SetListListIterator<E> extends AbstractListIteratorDecorator<E> {
        private E last;
        private final Set<E> set;

        protected SetListListIterator(ListIterator<E> listIterator, Set<E> set) {
            super(listIterator);
            this.last = null;
            this.set = set;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E e8) {
            if (this.set.contains(e8)) {
                return;
            }
            super.add(e8);
            this.set.add(e8);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public E next() {
            E e8 = (E) super.next();
            this.last = e8;
            return e8;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public E previous() {
            E e8 = (E) super.previous();
            this.last = e8;
            return e8;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E e8) {
            throw new UnsupportedOperationException("ListIterator does not support set");
        }
    }

    protected SetUniqueList(List<E> list, Set<E> set) {
        super(list);
        if (set == null) {
            throw new NullPointerException("Set must not be null");
        }
        this.set = set;
    }

    public static <E> SetUniqueList<E> setUniqueList(List<E> list) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        if (list.isEmpty()) {
            return new SetUniqueList<>(list, new HashSet());
        }
        ArrayList arrayList = new ArrayList(list);
        list.clear();
        SetUniqueList<E> setUniqueList = new SetUniqueList<>(list, new HashSet());
        setUniqueList.addAll(arrayList);
        return setUniqueList;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e8) {
        int size = size();
        add(size(), e8);
        return size != size();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(size(), collection);
    }

    public Set<E> asSet() {
        return UnmodifiableSet.unmodifiableSet(this.set);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        super.clear();
        this.set.clear();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.set.contains(obj);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean containsAll(Collection<?> collection) {
        return this.set.containsAll(collection);
    }

    protected Set<E> createSetBasedOnList(Set<E> set, List<E> list) {
        Set<E> hashSet;
        if (set.getClass().equals(HashSet.class)) {
            hashSet = new HashSet<>(list.size());
        } else {
            try {
                hashSet = (Set) set.getClass().newInstance();
            } catch (IllegalAccessException unused) {
                hashSet = new HashSet<>();
            } catch (InstantiationException unused2) {
                hashSet = new HashSet<>();
            }
        }
        hashSet.addAll(list);
        return hashSet;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return new SetListIterator(super.iterator(), this.set);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator() {
        return new SetListListIterator(super.listIterator(), this.set);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        boolean zRemove = this.set.remove(obj);
        if (zRemove) {
            super.remove(obj);
        }
        return zRemove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        boolean zRetainAll = this.set.retainAll(collection);
        if (!zRetainAll) {
            return false;
        }
        if (this.set.size() == 0) {
            super.clear();
        } else {
            super.retainAll(this.set);
        }
        return zRetainAll;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int i7, E e8) {
        int iIndexOf = indexOf(e8);
        E e9 = (E) super.set(i7, e8);
        if (iIndexOf != -1 && iIndexOf != i7) {
            super.remove(iIndexOf);
        }
        this.set.remove(e9);
        this.set.add(e8);
        return e9;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i7, int i8) {
        List<E> listSubList = super.subList(i7, i8);
        return ListUtils.unmodifiableList(new SetUniqueList(listSubList, createSetBasedOnList(this.set, listSubList)));
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i7, Collection<? extends E> collection) {
        ArrayList arrayList = new ArrayList();
        for (E e8 : collection) {
            if (this.set.add(e8)) {
                arrayList.add(e8);
            }
        }
        return super.addAll(i7, arrayList);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator(int i7) {
        return new SetListListIterator(super.listIterator(i7), this.set);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E remove(int i7) {
        E e8 = (E) super.remove(i7);
        this.set.remove(e8);
        return e8;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int i7, E e8) {
        if (this.set.contains(e8)) {
            return;
        }
        super.add(i7, e8);
        this.set.add(e8);
    }
}
