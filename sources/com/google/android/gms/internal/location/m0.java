package com.google.android.gms.internal.location;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
abstract class m0<E> extends t0<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16149b;

    protected m0(int i7, int i8) {
        k0.b(i8, i7, "index");
        this.f16148a = i7;
        this.f16149b = i8;
    }

    protected abstract E a(int i7);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f16149b < this.f16148a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f16149b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f16149b;
        this.f16149b = i7 + 1;
        return a(i7);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f16149b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f16149b - 1;
        this.f16149b = i7;
        return a(i7);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f16149b - 1;
    }
}
