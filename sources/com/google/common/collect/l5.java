package com.google.common.collect;

import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class l5<E> extends c6<E> implements Deque<E> {
    protected l5() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.c6
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract Deque<E> c0();

    @Override // java.util.Deque
    public void addFirst(E e8) {
        d0().addFirst(e8);
    }

    @Override // java.util.Deque
    public void addLast(E e8) {
        d0().addLast(e8);
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return d0().descendingIterator();
    }

    @Override // java.util.Deque
    public E getFirst() {
        return d0().getFirst();
    }

    @Override // java.util.Deque
    public E getLast() {
        return d0().getLast();
    }

    @Override // java.util.Deque
    @u1.a
    public boolean offerFirst(E e8) {
        return d0().offerFirst(e8);
    }

    @Override // java.util.Deque
    @u1.a
    public boolean offerLast(E e8) {
        return d0().offerLast(e8);
    }

    @Override // java.util.Deque
    public E peekFirst() {
        return d0().peekFirst();
    }

    @Override // java.util.Deque
    public E peekLast() {
        return d0().peekLast();
    }

    @Override // java.util.Deque
    @u1.a
    public E pollFirst() {
        return d0().pollFirst();
    }

    @Override // java.util.Deque
    @u1.a
    public E pollLast() {
        return d0().pollLast();
    }

    @Override // java.util.Deque
    @u1.a
    public E pop() {
        return d0().pop();
    }

    @Override // java.util.Deque
    public void push(E e8) {
        d0().push(e8);
    }

    @Override // java.util.Deque
    @u1.a
    public E removeFirst() {
        return d0().removeFirst();
    }

    @Override // java.util.Deque
    @u1.a
    public boolean removeFirstOccurrence(Object obj) {
        return d0().removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    @u1.a
    public E removeLast() {
        return d0().removeLast();
    }

    @Override // java.util.Deque
    @u1.a
    public boolean removeLastOccurrence(Object obj) {
        return d0().removeLastOccurrence(obj);
    }
}
