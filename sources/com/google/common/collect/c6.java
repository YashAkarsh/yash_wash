package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class c6<E> extends j5<E> implements Queue<E> {
    protected c6() {
    }

    @Override // java.util.Queue
    public E element() {
        return c0().element();
    }

    @Override // java.util.Queue
    @u1.a
    public boolean offer(E e8) {
        return c0().offer(e8);
    }

    @Override // java.util.Queue
    public E peek() {
        return c0().peek();
    }

    @Override // java.util.Queue
    @u1.a
    public E poll() {
        return c0().poll();
    }

    @Override // java.util.Queue
    @u1.a
    public E remove() {
        return c0().remove();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.j5
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract Queue<E> c0();

    protected boolean x0(E e8) {
        try {
            return add(e8);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    protected E y0() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    protected E z0() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
