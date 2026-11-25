package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class x5<E> extends j5<E> implements hd<E> {

    @s1.a
    protected class a extends md.h<E> {
        public a() {
        }

        @Override // com.google.common.collect.md.h
        hd<E> g() {
            return x5.this;
        }

        @Override // com.google.common.collect.md.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return md.j(g().entrySet().iterator());
        }
    }

    protected x5() {
    }

    protected int A0() {
        return entrySet().hashCode();
    }

    protected Iterator<E> B0() {
        return md.p(this);
    }

    protected int C0(E e8, int i7) {
        return md.A(this, e8, i7);
    }

    protected boolean D0(E e8, int i7, int i8) {
        return md.B(this, e8, i7, i8);
    }

    @u1.a
    public boolean E(E e8, int i7, int i8) {
        return c0().E(e8, i7, i8);
    }

    protected int E0() {
        return md.t(this);
    }

    @u1.a
    public int add(E e8, int i7) {
        return c0().add(e8, i7);
    }

    public Set<E> e() {
        return c0().e();
    }

    @Override // com.google.common.collect.j5
    @s1.a
    protected boolean e0(Collection<? extends E> collection) {
        return md.e(this, collection);
    }

    public Set<hd.a<E>> entrySet() {
        return c0().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.hd
    public boolean equals(Object obj) {
        return obj == this || c0().equals(obj);
    }

    @Override // com.google.common.collect.j5
    protected void f0() {
        ua.h(entrySet().iterator());
    }

    @Override // java.lang.Iterable, com.google.common.collect.hd
    public /* synthetic */ void forEach(Consumer consumer) {
        gd.a(this, consumer);
    }

    @Override // com.google.common.collect.hd
    public /* synthetic */ void h0(ObjIntConsumer objIntConsumer) {
        gd.b(this, objIntConsumer);
    }

    @Override // java.util.Collection, com.google.common.collect.hd
    public int hashCode() {
        return c0().hashCode();
    }

    @Override // com.google.common.collect.j5
    protected boolean i0(Object obj) {
        return l0(obj) > 0;
    }

    @Override // com.google.common.collect.hd
    public int l0(Object obj) {
        return c0().l0(obj);
    }

    @Override // com.google.common.collect.j5
    protected boolean m0(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // com.google.common.collect.j5
    protected boolean n0(Collection<?> collection) {
        return md.u(this, collection);
    }

    @Override // com.google.common.collect.j5
    protected boolean p0(Collection<?> collection) {
        return md.x(this, collection);
    }

    @u1.a
    public int remove(Object obj, int i7) {
        return c0().remove(obj, i7);
    }

    @u1.a
    public int setCount(E e8, int i7) {
        return c0().setCount(e8, i7);
    }

    @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
    public /* synthetic */ Spliterator spliterator() {
        return gd.c(this);
    }

    @Override // com.google.common.collect.j5
    protected String u0() {
        return entrySet().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.j5
    /* JADX INFO: renamed from: w0 */
    public abstract hd<E> c0();

    protected boolean x0(E e8) {
        add(e8, 1);
        return true;
    }

    @s1.a
    protected int y0(Object obj) {
        for (hd.a<E> aVar : entrySet()) {
            if (com.google.common.base.y.a(aVar.getElement(), obj)) {
                return aVar.getCount();
            }
        }
        return 0;
    }

    protected boolean z0(Object obj) {
        return md.k(this, obj);
    }
}
