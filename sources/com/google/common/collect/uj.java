package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class uj<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterator<? extends F> f21250a;

    uj(Iterator<? extends F> it) {
        this.f21250a = (Iterator) com.google.common.base.e0.E(it);
    }

    abstract T a(F f8);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f21250a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f21250a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f21250a.remove();
    }
}
