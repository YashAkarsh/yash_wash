package com.google.common.collect;

import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
class he<E> extends d7<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final d7<Object> f20395d = new he(new Object[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @s1.d
    final transient Object[] f20396c;

    he(Object[] objArr) {
        this.f20396c = objArr;
    }

    @Override // com.google.common.collect.d7, com.google.common.collect.x6
    int b(Object[] objArr, int i7) {
        Object[] objArr2 = this.f20396c;
        System.arraycopy(objArr2, 0, objArr, i7, objArr2.length);
        return i7 + this.f20396c.length;
    }

    @Override // com.google.common.collect.x6
    Object[] d() {
        return this.f20396c;
    }

    @Override // com.google.common.collect.x6
    int f() {
        return this.f20396c.length;
    }

    @Override // com.google.common.collect.x6
    int g() {
        return 0;
    }

    @Override // java.util.List
    public E get(int i7) {
        return (E) this.f20396c[i7];
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f20396c.length;
    }

    @Override // com.google.common.collect.d7, com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.f20396c, 1296);
    }

    @Override // com.google.common.collect.d7, java.util.List
    /* JADX INFO: renamed from: w */
    public dk<E> listIterator(int i7) {
        Object[] objArr = this.f20396c;
        return ua.C(objArr, 0, objArr.length, i7);
    }
}
