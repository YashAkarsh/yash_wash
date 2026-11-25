package com.google.common.collect;

import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
class de<E> extends t6<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x6<E> f20123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d7<? extends E> f20124d;

    de(x6<E> x6Var, d7<? extends E> d7Var) {
        this.f20123c = x6Var;
        this.f20124d = d7Var;
    }

    @Override // com.google.common.collect.t6
    x6<E> W() {
        return this.f20123c;
    }

    d7<? extends E> X() {
        return this.f20124d;
    }

    @Override // com.google.common.collect.d7, com.google.common.collect.x6
    @s1.c
    int b(Object[] objArr, int i7) {
        return this.f20124d.b(objArr, i7);
    }

    @Override // com.google.common.collect.x6
    Object[] d() {
        return this.f20124d.d();
    }

    @Override // com.google.common.collect.x6
    int f() {
        return this.f20124d.f();
    }

    @Override // com.google.common.collect.d7, java.lang.Iterable
    @s1.c
    public void forEach(Consumer<? super E> consumer) {
        this.f20124d.forEach(consumer);
    }

    @Override // com.google.common.collect.x6
    int g() {
        return this.f20124d.g();
    }

    @Override // java.util.List
    public E get(int i7) {
        return this.f20124d.get(i7);
    }

    @Override // com.google.common.collect.d7, java.util.List
    /* JADX INFO: renamed from: w */
    public dk<E> listIterator(int i7) {
        return this.f20124d.listIterator(i7);
    }

    de(x6<E> x6Var, Object[] objArr) {
        this(x6Var, d7.k(objArr));
    }
}
