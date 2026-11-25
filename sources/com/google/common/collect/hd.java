package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface hd<E> extends Collection<E> {

    public interface a<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    @u1.a
    boolean E(E e8, int i7, int i8);

    @u1.a
    int add(E e8, int i7);

    @Override // java.util.Collection
    @u1.a
    boolean add(E e8);

    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    Set<E> e();

    Set<a<E>> entrySet();

    boolean equals(Object obj);

    void forEach(Consumer<? super E> consumer);

    @s1.a
    void h0(ObjIntConsumer<? super E> objIntConsumer);

    int hashCode();

    Iterator<E> iterator();

    int l0(@u1.c("E") Object obj);

    @u1.a
    int remove(@u1.c("E") Object obj, int i7);

    @Override // java.util.Collection
    @u1.a
    boolean remove(Object obj);

    @Override // java.util.Collection
    @u1.a
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection
    @u1.a
    boolean retainAll(Collection<?> collection);

    @u1.a
    int setCount(E e8, int i7);

    int size();

    Spliterator<E> spliterator();

    String toString();
}
