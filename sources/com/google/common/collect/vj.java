package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class vj<F, T> extends uj<F, T> implements ListIterator<T> {
    vj(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> b() {
        return ua.f(this.f21250a);
    }

    @Override // java.util.ListIterator
    public void add(T t7) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(T t7) {
        throw new UnsupportedOperationException();
    }
}
