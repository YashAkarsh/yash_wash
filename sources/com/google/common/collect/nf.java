package com.google.common.collect;

import java.util.Collections;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
final class nf<E> extends d7<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient E f20767c;

    nf(E e8) {
        this.f20767c = (E) com.google.common.base.e0.E(e8);
    }

    @Override // com.google.common.collect.d7, java.util.List
    /* JADX INFO: renamed from: T */
    public d7<E> subList(int i7, int i8) {
        com.google.common.base.e0.f0(i7, i8, 1);
        return i7 == i8 ? d7.x() : this;
    }

    @Override // java.util.List
    public E get(int i7) {
        com.google.common.base.e0.C(i7, 1);
        return this.f20767c;
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // com.google.common.collect.d7, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<E> iterator() {
        return ua.Y(this.f20767c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.d7, com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return Collections.singleton(this.f20767c).spliterator();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f20767c.toString() + ']';
    }
}
