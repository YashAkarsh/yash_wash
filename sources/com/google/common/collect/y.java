package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class y<E> extends AbstractCollection<E> implements hd<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Set<E> f21424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Set<hd.a<E>> f21425b;

    class a extends md.h<E> {
        a() {
        }

        @Override // com.google.common.collect.md.h
        hd<E> g() {
            return y.this;
        }

        @Override // com.google.common.collect.md.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return y.this.f();
        }
    }

    class b extends md.i<E> {
        b() {
        }

        @Override // com.google.common.collect.md.i
        hd<E> g() {
            return y.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<hd.a<E>> iterator() {
            return y.this.g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return y.this.d();
        }
    }

    y() {
    }

    @u1.a
    public boolean E(E e8, int i7, int i8) {
        return md.B(this, e8, i7, i8);
    }

    Set<E> a() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    @u1.a
    public final boolean add(E e8) {
        add(e8, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @u1.a
    public final boolean addAll(Collection<? extends E> collection) {
        return md.e(this, collection);
    }

    Set<hd.a<E>> b() {
        return new b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public boolean contains(Object obj) {
        return l0(obj) > 0;
    }

    abstract int d();

    public Set<E> e() {
        Set<E> set = this.f21424a;
        if (set != null) {
            return set;
        }
        Set<E> setA = a();
        this.f21424a = setA;
        return setA;
    }

    public Set<hd.a<E>> entrySet() {
        Set<hd.a<E>> set = this.f21425b;
        if (set != null) {
            return set;
        }
        Set<hd.a<E>> setB = b();
        this.f21425b = setB;
        return setB;
    }

    @Override // java.util.Collection, com.google.common.collect.hd
    public final boolean equals(Object obj) {
        return md.k(this, obj);
    }

    abstract Iterator<E> f();

    @Override // java.lang.Iterable, com.google.common.collect.hd
    public /* synthetic */ void forEach(Consumer consumer) {
        gd.a(this, consumer);
    }

    abstract Iterator<hd.a<E>> g();

    public /* synthetic */ void h0(ObjIntConsumer objIntConsumer) {
        gd.b(this, objIntConsumer);
    }

    @Override // java.util.Collection, com.google.common.collect.hd
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    @u1.a
    public final boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    @u1.a
    public final boolean removeAll(Collection<?> collection) {
        return md.u(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    @u1.a
    public final boolean retainAll(Collection<?> collection) {
        return md.x(this, collection);
    }

    @u1.a
    public int setCount(E e8, int i7) {
        return md.A(this, e8, i7);
    }

    @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
    public /* synthetic */ Spliterator spliterator() {
        return gd.c(this);
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.hd
    public final String toString() {
        return entrySet().toString();
    }

    @u1.a
    public int add(E e8, int i7) {
        throw new UnsupportedOperationException();
    }

    @u1.a
    public int remove(Object obj, int i7) {
        throw new UnsupportedOperationException();
    }
}
