package com.nostra13.universalimageloader.core.assist.deque;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> extends d<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f32647i = -4114786347960826192L;

    @Override // com.nostra13.universalimageloader.core.assist.deque.d, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, java.util.concurrent.BlockingQueue, com.nostra13.universalimageloader.core.assist.deque.b
    public boolean offer(T t7) {
        return super.offerFirst(t7);
    }

    @Override // com.nostra13.universalimageloader.core.assist.deque.d, java.util.AbstractQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.a, com.nostra13.universalimageloader.core.assist.deque.b
    public T remove() {
        return (T) super.removeFirst();
    }
}
