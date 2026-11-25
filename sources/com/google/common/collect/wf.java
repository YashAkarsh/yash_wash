package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public interface wf<E> extends yf<E>, qf<E> {
    wf<E> C();

    Comparator<? super E> comparator();

    @Override // com.google.common.collect.yf, com.google.common.collect.hd
    NavigableSet<E> e();

    @Override // com.google.common.collect.yf, com.google.common.collect.hd
    /* bridge */ /* synthetic */ Set e();

    @Override // com.google.common.collect.yf, com.google.common.collect.hd
    /* bridge */ /* synthetic */ SortedSet e();

    @Override // com.google.common.collect.hd
    Set<hd.a<E>> entrySet();

    hd.a<E> firstEntry();

    wf<E> g0(E e8, s0 s0Var);

    @Override // com.google.common.collect.hd, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    hd.a<E> lastEntry();

    wf<E> o0(E e8, s0 s0Var);

    hd.a<E> pollFirstEntry();

    hd.a<E> pollLastEntry();

    wf<E> v0(E e8, s0 s0Var, E e9, s0 s0Var2);
}
