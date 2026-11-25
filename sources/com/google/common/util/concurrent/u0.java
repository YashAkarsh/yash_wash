package com.google.common.util.concurrent;

import com.google.common.collect.c6;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
@s1.c
public abstract class u0<E> extends c6<E> implements BlockingQueue<E> {
    protected u0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.c6
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public abstract BlockingQueue<E> c0();

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i7) {
        return c0().drainTo(collection, i7);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e8, long j7, TimeUnit timeUnit) throws InterruptedException {
        return c0().offer(e8, j7, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j7, TimeUnit timeUnit) throws InterruptedException {
        return c0().poll(j7, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e8) throws InterruptedException {
        c0().put(e8);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return c0().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return c0().take();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return c0().drainTo(collection);
    }
}
