package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class d<E> extends dk<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f20104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20105b;

    protected d(int i7) {
        this(i7, 0);
    }

    protected abstract E a(int i7);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f20105b < this.f20104a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f20105b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f20105b;
        this.f20105b = i7 + 1;
        return a(i7);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f20105b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f20105b - 1;
        this.f20105b = i7;
        return a(i7);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f20105b - 1;
    }

    protected d(int i7, int i8) {
        com.google.common.base.e0.d0(i8, i7);
        this.f20104a = i7;
        this.f20105b = i8;
    }
}
