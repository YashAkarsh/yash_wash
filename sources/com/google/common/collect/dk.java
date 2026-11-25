package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class dk<E> extends ck<E> implements ListIterator<E> {
    protected dk() {
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e8) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e8) {
        throw new UnsupportedOperationException();
    }
}
