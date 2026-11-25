package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
abstract class k0<E> extends l<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16118b;

    protected k0(int i7, int i8) {
        d0.b(i8, i7, "index");
        this.f16117a = i7;
        this.f16118b = i8;
    }

    protected abstract E a(int i7);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f16118b < this.f16117a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f16118b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f16118b;
        this.f16118b = i7 + 1;
        return a(i7);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f16118b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f16118b - 1;
        this.f16118b = i7;
        return a(i7);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f16118b - 1;
    }
}
