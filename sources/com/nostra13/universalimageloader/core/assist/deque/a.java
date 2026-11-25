package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public interface a<E> extends BlockingQueue<E>, b<E> {
    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.b
    boolean add(E e8);

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    void addFirst(E e8);

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    void addLast(E e8);

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.b
    boolean contains(Object obj);

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.b
    E element();

    @Override // java.util.Collection, java.lang.Iterable, com.nostra13.universalimageloader.core.assist.deque.b
    Iterator<E> iterator();

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.b
    boolean offer(E e8);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e8, long j7, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    boolean offerFirst(E e8);

    boolean offerFirst(E e8, long j7, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    boolean offerLast(E e8);

    boolean offerLast(E e8, long j7, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.b
    E peek();

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.b
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j7, TimeUnit timeUnit) throws InterruptedException;

    E pollFirst(long j7, TimeUnit timeUnit) throws InterruptedException;

    E pollLast(long j7, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    void push(E e8);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e8) throws InterruptedException;

    void putFirst(E e8) throws InterruptedException;

    void putLast(E e8) throws InterruptedException;

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.b
    E remove();

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.b
    boolean remove(Object obj);

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    boolean removeFirstOccurrence(Object obj);

    @Override // com.nostra13.universalimageloader.core.assist.deque.b
    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.b
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws InterruptedException;

    E takeFirst() throws InterruptedException;

    E takeLast() throws InterruptedException;
}
