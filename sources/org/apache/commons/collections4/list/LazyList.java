package org.apache.commons.collections4.list;

import java.util.List;
import org.apache.commons.collections4.Factory;

/* JADX INFO: loaded from: classes3.dex */
public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -1708388017160694542L;
    private final Factory<? extends E> factory;

    protected LazyList(List<E> list, Factory<? extends E> factory) {
        super(list);
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        this.factory = factory;
    }

    public static <E> LazyList<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return new LazyList<>(list, factory);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int i7) {
        int size = decorated().size();
        if (i7 < size) {
            E e8 = decorated().get(i7);
            if (e8 != null) {
                return e8;
            }
            E eCreate = this.factory.create();
            decorated().set(i7, eCreate);
            return eCreate;
        }
        while (size < i7) {
            decorated().add(null);
            size++;
        }
        E eCreate2 = this.factory.create();
        decorated().add(eCreate2);
        return eCreate2;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i7, int i8) {
        return new LazyList(decorated().subList(i7, i8), this.factory);
    }
}
