package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
class q3<E> extends n3<E> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f20967r = -2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private transient int[] f20968n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private transient int[] f20969o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private transient int f20970p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private transient int f20971q;

    q3() {
    }

    public static <E> q3<E> F() {
        return new q3<>();
    }

    public static <E> q3<E> H(Collection<? extends E> collection) {
        q3<E> q3VarJ = J(collection.size());
        q3VarJ.addAll(collection);
        return q3VarJ;
    }

    public static <E> q3<E> I(E... eArr) {
        q3<E> q3VarJ = J(eArr.length);
        Collections.addAll(q3VarJ, eArr);
        return q3VarJ;
    }

    public static <E> q3<E> J(int i7) {
        return new q3<>(i7);
    }

    private void K(int i7, int i8) {
        if (i7 == -2) {
            this.f20970p = i8;
        } else {
            this.f20969o[i7] = i8;
        }
        if (i8 == -2) {
            this.f20971q = i7;
        } else {
            this.f20968n[i8] = i7;
        }
    }

    @Override // com.google.common.collect.n3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        super.clear();
        this.f20970p = -2;
        this.f20971q = -2;
        Arrays.fill(this.f20968n, -1);
        Arrays.fill(this.f20969o, -1);
    }

    @Override // com.google.common.collect.n3
    int f(int i7, int i8) {
        return i7 == size() ? i8 : i7;
    }

    @Override // com.google.common.collect.n3, java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        com.google.common.base.e0.E(consumer);
        int i7 = this.f20970p;
        while (i7 != -2) {
            consumer.accept(this.f20701c[i7]);
            i7 = this.f20969o[i7];
        }
    }

    @Override // com.google.common.collect.n3
    int l() {
        return this.f20970p;
    }

    @Override // com.google.common.collect.n3
    int o(int i7) {
        return this.f20969o[i7];
    }

    @Override // com.google.common.collect.n3
    void r(int i7, float f8) {
        super.r(i7, f8);
        int[] iArr = new int[i7];
        this.f20968n = iArr;
        this.f20969o = new int[i7];
        Arrays.fill(iArr, -1);
        Arrays.fill(this.f20969o, -1);
        this.f20970p = -2;
        this.f20971q = -2;
    }

    @Override // com.google.common.collect.n3, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 17);
    }

    @Override // com.google.common.collect.n3
    void t(int i7, E e8, int i8) {
        super.t(i7, e8, i8);
        K(this.f20971q, i7);
        K(i7, -2);
    }

    @Override // com.google.common.collect.n3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return sd.l(this);
    }

    @Override // com.google.common.collect.n3
    void u(int i7) {
        int size = size() - 1;
        super.u(i7);
        K(this.f20968n[i7], this.f20969o[i7]);
        if (size != i7) {
            K(this.f20968n[size], i7);
            K(i7, this.f20969o[size]);
        }
        this.f20968n[size] = -1;
        this.f20969o[size] = -1;
    }

    @Override // com.google.common.collect.n3
    void x(int i7) {
        super.x(i7);
        int[] iArr = this.f20968n;
        int length = iArr.length;
        this.f20968n = Arrays.copyOf(iArr, i7);
        this.f20969o = Arrays.copyOf(this.f20969o, i7);
        if (length < i7) {
            Arrays.fill(this.f20968n, length, i7, -1);
            Arrays.fill(this.f20969o, length, i7, -1);
        }
    }

    q3(int i7) {
        super(i7);
    }

    @Override // com.google.common.collect.n3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) sd.m(this, tArr);
    }
}
