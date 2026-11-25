package com.google.common.collect;

import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
@Deprecated
public abstract class i5<E> extends l5<E> implements BlockingDeque<E> {
    protected i5() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.l5, com.google.common.collect.c6
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract BlockingDeque<E> c0();

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return d0().drainTo(collection);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e8, long j7, TimeUnit timeUnit) throws InterruptedException {
        return d0().offer(e8, j7, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E e8, long j7, TimeUnit timeUnit) throws InterruptedException {
        return d0().offerFirst(e8, j7, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E e8, long j7, TimeUnit timeUnit) throws InterruptedException {
        return d0().offerLast(e8, j7, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long j7, TimeUnit timeUnit) throws InterruptedException {
        return d0().poll(j7, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollFirst(long j7, TimeUnit timeUnit) throws InterruptedException {
        return d0().pollFirst(j7, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollLast(long j7, TimeUnit timeUnit) throws InterruptedException {
        return d0().pollLast(j7, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e8) throws InterruptedException {
        d0().put(e8);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E e8) throws InterruptedException {
        d0().putFirst(e8);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E e8) throws InterruptedException {
        d0().putLast(e8);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return d0().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return d0().take();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        return d0().takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        return d0().takeLast();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i7) {
        return d0().drainTo(collection, i7);
    }
}
