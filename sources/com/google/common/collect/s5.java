package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class s5<E> extends q5<E> implements ListIterator<E> {
    protected s5() {
    }

    @Override // java.util.ListIterator
    public void add(E e8) {
        d0().add(e8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.q5
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract ListIterator<E> c0();

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return d0().hasPrevious();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return d0().nextIndex();
    }

    @Override // java.util.ListIterator
    @u1.a
    public E previous() {
        return d0().previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return d0().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(E e8) {
        d0().set(e8);
    }
}
