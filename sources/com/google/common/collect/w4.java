package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class w4<E> extends c6<E> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f21294c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<E> f21295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.d
    final int f21296b;

    private w4(int i7) {
        com.google.common.base.e0.k(i7 >= 0, "maxSize (%s) must >= 0", i7);
        this.f21295a = new ArrayDeque(i7);
        this.f21296b = i7;
    }

    public static <E> w4<E> A0(int i7) {
        return new w4<>(i7);
    }

    @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
    @u1.a
    public boolean add(E e8) {
        com.google.common.base.e0.E(e8);
        if (this.f21296b == 0) {
            return true;
        }
        if (size() == this.f21296b) {
            this.f21295a.remove();
        }
        this.f21295a.add(e8);
        return true;
    }

    @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
    @u1.a
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.f21296b) {
            return e0(collection);
        }
        clear();
        return ma.a(this, ma.M(collection, size - this.f21296b));
    }

    @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return c0().contains(com.google.common.base.e0.E(obj));
    }

    @Override // com.google.common.collect.c6, java.util.Queue
    @u1.a
    public boolean offer(E e8) {
        return add(e8);
    }

    public int remainingCapacity() {
        return this.f21296b - size();
    }

    @Override // com.google.common.collect.j5, java.util.Collection
    @u1.a
    public boolean remove(Object obj) {
        return c0().remove(com.google.common.base.e0.E(obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.c6, com.google.common.collect.j5
    /* JADX INFO: renamed from: w0 */
    public Queue<E> c0() {
        return this.f21295a;
    }
}
