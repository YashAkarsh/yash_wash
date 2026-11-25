package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public interface b<E> extends Queue<E> {
    boolean add(E e8);

    void addFirst(E e8);

    void addLast(E e8);

    boolean contains(Object obj);

    Iterator<E> descendingIterator();

    E element();

    E getFirst();

    E getLast();

    Iterator<E> iterator();

    boolean offer(E e8);

    boolean offerFirst(E e8);

    boolean offerLast(E e8);

    E peek();

    E peekFirst();

    E peekLast();

    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E e8);

    E remove();

    boolean remove(Object obj);

    E removeFirst();

    boolean removeFirstOccurrence(Object obj);

    E removeLast();

    boolean removeLastOccurrence(Object obj);

    int size();
}
