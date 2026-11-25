package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class r5<E> extends j5<E> implements List<E> {
    protected r5() {
    }

    @s1.a
    protected int A0() {
        return ib.k(this);
    }

    protected int B0(Object obj) {
        return ib.l(this, obj);
    }

    protected Iterator<E> C0() {
        return listIterator();
    }

    protected int D0(Object obj) {
        return ib.n(this, obj);
    }

    protected ListIterator<E> E0() {
        return listIterator(0);
    }

    @s1.a
    protected ListIterator<E> F0(int i7) {
        return ib.p(this, i7);
    }

    @s1.a
    protected List<E> G0(int i7, int i8) {
        return ib.C(this, i7, i8);
    }

    public void add(int i7, E e8) {
        c0().add(i7, e8);
    }

    @u1.a
    public boolean addAll(int i7, Collection<? extends E> collection) {
        return c0().addAll(i7, collection);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || c0().equals(obj);
    }

    @Override // java.util.List
    public E get(int i7) {
        return c0().get(i7);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return c0().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return c0().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return c0().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return c0().listIterator();
    }

    @Override // java.util.List
    @u1.a
    public E remove(int i7) {
        return c0().remove(i7);
    }

    @Override // java.util.List
    @u1.a
    public E set(int i7, E e8) {
        return c0().set(i7, e8);
    }

    @Override // java.util.List
    public List<E> subList(int i7, int i8) {
        return c0().subList(i7, i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.j5
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public abstract List<E> c0();

    protected boolean x0(E e8) {
        add(size(), e8);
        return true;
    }

    protected boolean y0(int i7, Iterable<? extends E> iterable) {
        return ib.a(this, i7, iterable);
    }

    @s1.a
    protected boolean z0(Object obj) {
        return ib.j(this, obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i7) {
        return c0().listIterator(i7);
    }
}
