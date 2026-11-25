package com.google.common.collect;

import java.util.Comparator;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class f9<E> extends de<E> implements qf<E> {
    f9(s9<E> s9Var, d7<E> d7Var) {
        super(s9Var, d7Var);
    }

    @Override // com.google.common.collect.d7
    @s1.c
    d7<E> U(int i7, int i8) {
        return new me(super.U(i7, i8), comparator()).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.de, com.google.common.collect.t6
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public s9<E> W() {
        return (s9) super.W();
    }

    @Override // com.google.common.collect.qf
    public Comparator<? super E> comparator() {
        return W().comparator();
    }

    @Override // com.google.common.collect.t6, com.google.common.collect.d7, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.common.collect.d7, java.util.List
    @s1.c
    public int indexOf(Object obj) {
        int iIndexOf = W().indexOf(obj);
        if (iIndexOf < 0 || !get(iIndexOf).equals(obj)) {
            return -1;
        }
        return iIndexOf;
    }

    @Override // com.google.common.collect.d7, java.util.List
    @s1.c
    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    @Override // com.google.common.collect.d7, com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        int size = size();
        d7<? extends E> d7VarX = X();
        d7VarX.getClass();
        return q2.d(size, 1301, new c7(d7VarX), comparator());
    }
}
