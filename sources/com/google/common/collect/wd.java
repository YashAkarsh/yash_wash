package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class wd {
    private wd() {
    }

    @u1.a
    @s1.a
    @s1.c
    public static <E> int a(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i7, long j7, TimeUnit timeUnit) throws InterruptedException {
        com.google.common.base.e0.E(collection);
        long jNanoTime = System.nanoTime() + timeUnit.toNanos(j7);
        int iDrainTo = 0;
        while (iDrainTo < i7) {
            iDrainTo += blockingQueue.drainTo(collection, i7 - iDrainTo);
            if (iDrainTo < i7) {
                E ePoll = blockingQueue.poll(jNanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (ePoll == null) {
                    break;
                }
                collection.add(ePoll);
                iDrainTo++;
            }
        }
        return iDrainTo;
    }

    @s1.a
    @u1.a
    @s1.c
    public static <E> int b(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i7, long j7, TimeUnit timeUnit) {
        E ePoll;
        com.google.common.base.e0.E(collection);
        long jNanoTime = System.nanoTime() + timeUnit.toNanos(j7);
        int iDrainTo = 0;
        boolean z7 = false;
        while (iDrainTo < i7) {
            try {
                iDrainTo += blockingQueue.drainTo(collection, i7 - iDrainTo);
                if (iDrainTo < i7) {
                    while (true) {
                        try {
                            ePoll = blockingQueue.poll(jNanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
                            break;
                        } catch (InterruptedException unused) {
                            z7 = true;
                        }
                    }
                    if (ePoll == null) {
                        break;
                    }
                    collection.add(ePoll);
                    iDrainTo++;
                }
            } finally {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return iDrainTo;
    }

    @s1.c
    public static <E> ArrayBlockingQueue<E> c(int i7) {
        return new ArrayBlockingQueue<>(i7);
    }

    public static <E> ArrayDeque<E> d() {
        return new ArrayDeque<>();
    }

    public static <E> ArrayDeque<E> e(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ArrayDeque<>(h3.b(iterable));
        }
        ArrayDeque<E> arrayDeque = new ArrayDeque<>();
        ma.a(arrayDeque, iterable);
        return arrayDeque;
    }

    @s1.c
    public static <E> ConcurrentLinkedQueue<E> f() {
        return new ConcurrentLinkedQueue<>();
    }

    @s1.c
    public static <E> ConcurrentLinkedQueue<E> g(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ConcurrentLinkedQueue<>(h3.b(iterable));
        }
        ConcurrentLinkedQueue<E> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        ma.a(concurrentLinkedQueue, iterable);
        return concurrentLinkedQueue;
    }

    @s1.c
    public static <E> LinkedBlockingDeque<E> h() {
        return new LinkedBlockingDeque<>();
    }

    @s1.c
    public static <E> LinkedBlockingDeque<E> i(int i7) {
        return new LinkedBlockingDeque<>(i7);
    }

    @s1.c
    public static <E> LinkedBlockingDeque<E> j(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingDeque<>(h3.b(iterable));
        }
        LinkedBlockingDeque<E> linkedBlockingDeque = new LinkedBlockingDeque<>();
        ma.a(linkedBlockingDeque, iterable);
        return linkedBlockingDeque;
    }

    @s1.c
    public static <E> LinkedBlockingQueue<E> k() {
        return new LinkedBlockingQueue<>();
    }

    @s1.c
    public static <E> LinkedBlockingQueue<E> l(int i7) {
        return new LinkedBlockingQueue<>(i7);
    }

    @s1.c
    public static <E> LinkedBlockingQueue<E> m(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingQueue<>(h3.b(iterable));
        }
        LinkedBlockingQueue<E> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ma.a(linkedBlockingQueue, iterable);
        return linkedBlockingQueue;
    }

    @s1.c
    public static <E extends Comparable> PriorityBlockingQueue<E> n() {
        return new PriorityBlockingQueue<>();
    }

    @s1.c
    public static <E extends Comparable> PriorityBlockingQueue<E> o(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityBlockingQueue<>(h3.b(iterable));
        }
        PriorityBlockingQueue<E> priorityBlockingQueue = new PriorityBlockingQueue<>();
        ma.a(priorityBlockingQueue, iterable);
        return priorityBlockingQueue;
    }

    public static <E extends Comparable> PriorityQueue<E> p() {
        return new PriorityQueue<>();
    }

    public static <E extends Comparable> PriorityQueue<E> q(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityQueue<>(h3.b(iterable));
        }
        PriorityQueue<E> priorityQueue = new PriorityQueue<>();
        ma.a(priorityQueue, iterable);
        return priorityQueue;
    }

    @s1.c
    public static <E> SynchronousQueue<E> r() {
        return new SynchronousQueue<>();
    }

    public static <E> Deque<E> s(Deque<E> deque) {
        return dj.i(deque, null);
    }

    public static <E> Queue<E> t(Queue<E> queue) {
        return dj.t(queue, null);
    }
}
