package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class pe<T> extends td<T> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f20904d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final td<? super T> f20905c;

    pe(td<? super T> tdVar) {
        this.f20905c = (td) com.google.common.base.e0.E(tdVar);
    }

    @Override // com.google.common.collect.td
    public <S extends T> td<S> F() {
        return this.f20905c;
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    public int compare(T t7, T t8) {
        return this.f20905c.compare(t8, t7);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof pe) {
            return this.f20905c.equals(((pe) obj).f20905c);
        }
        return false;
    }

    public int hashCode() {
        return -this.f20905c.hashCode();
    }

    @Override // com.google.common.collect.td
    public <E extends T> E r(Iterable<E> iterable) {
        return (E) this.f20905c.w(iterable);
    }

    @Override // com.google.common.collect.td
    public <E extends T> E t(E e8, E e9) {
        return (E) this.f20905c.x(e8, e9);
    }

    public String toString() {
        return this.f20905c + ".reverse()";
    }

    @Override // com.google.common.collect.td
    public <E extends T> E u(E e8, E e9, E e10, E... eArr) {
        return (E) this.f20905c.y(e8, e9, e10, eArr);
    }

    @Override // com.google.common.collect.td
    public <E extends T> E v(Iterator<E> it) {
        return (E) this.f20905c.z(it);
    }

    @Override // com.google.common.collect.td
    public <E extends T> E w(Iterable<E> iterable) {
        return (E) this.f20905c.r(iterable);
    }

    @Override // com.google.common.collect.td
    public <E extends T> E x(E e8, E e9) {
        return (E) this.f20905c.t(e8, e9);
    }

    @Override // com.google.common.collect.td
    public <E extends T> E y(E e8, E e9, E e10, E... eArr) {
        return (E) this.f20905c.u(e8, e9, e10, eArr);
    }

    @Override // com.google.common.collect.td
    public <E extends T> E z(Iterator<E> it) {
        return (E) this.f20905c.v(it);
    }
}
