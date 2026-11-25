package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class oe extends td<Comparable> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final oe f20853c = new oe();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f20854d = 0;

    private oe() {
    }

    private Object readResolve() {
        return f20853c;
    }

    @Override // com.google.common.collect.td
    public <S extends Comparable> td<S> F() {
        return td.A();
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        com.google.common.base.e0.E(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.td
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable> E t(E e8, E e9) {
        return (E) pd.f20900e.x(e8, e9);
    }

    @Override // com.google.common.collect.td
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable> E u(E e8, E e9, E e10, E... eArr) {
        return (E) pd.f20900e.y(e8, e9, e10, eArr);
    }

    @Override // com.google.common.collect.td
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable> E r(Iterable<E> iterable) {
        return (E) pd.f20900e.w(iterable);
    }

    @Override // com.google.common.collect.td
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable> E v(Iterator<E> it) {
        return (E) pd.f20900e.z(it);
    }

    @Override // com.google.common.collect.td
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable> E x(E e8, E e9) {
        return (E) pd.f20900e.t(e8, e9);
    }

    @Override // com.google.common.collect.td
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable> E y(E e8, E e9, E e10, E... eArr) {
        return (E) pd.f20900e.u(e8, e9, e10, eArr);
    }

    @Override // com.google.common.collect.td
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable> E w(Iterable<E> iterable) {
        return (E) pd.f20900e.r(iterable);
    }

    @Override // com.google.common.collect.td
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public <E extends Comparable> E z(Iterator<E> it) {
        return (E) pd.f20900e.v(it);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
