package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class j5<E> extends b6 implements Collection<E> {
    protected j5() {
    }

    @u1.a
    public boolean add(E e8) {
        return c0().add(e8);
    }

    @u1.a
    public boolean addAll(Collection<? extends E> collection) {
        return c0().addAll(collection);
    }

    public void clear() {
        c0().clear();
    }

    public boolean contains(Object obj) {
        return c0().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return c0().containsAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public abstract Collection<E> c0();

    protected boolean e0(Collection<? extends E> collection) {
        return ua.a(this, collection.iterator());
    }

    protected void f0() {
        ua.h(iterator());
    }

    protected boolean i0(Object obj) {
        return ua.q(iterator(), obj);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return c0().isEmpty();
    }

    public Iterator<E> iterator() {
        return c0().iterator();
    }

    protected boolean j0(Collection<?> collection) {
        return h3.c(this, collection);
    }

    protected boolean k0() {
        return !iterator().hasNext();
    }

    protected boolean m0(Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (com.google.common.base.y.a(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    protected boolean n0(Collection<?> collection) {
        return ua.V(iterator(), collection);
    }

    protected boolean p0(Collection<?> collection) {
        return ua.X(iterator(), collection);
    }

    protected Object[] q0() {
        return toArray(new Object[size()]);
    }

    @u1.a
    public boolean remove(Object obj) {
        return c0().remove(obj);
    }

    @u1.a
    public boolean removeAll(Collection<?> collection) {
        return c0().removeAll(collection);
    }

    @u1.a
    public boolean retainAll(Collection<?> collection) {
        return c0().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return c0().size();
    }

    protected <T> T[] t0(T[] tArr) {
        return (T[]) sd.m(this, tArr);
    }

    public Object[] toArray() {
        return c0().toArray();
    }

    protected String u0() {
        return h3.l(this);
    }

    @u1.a
    public <T> T[] toArray(T[] tArr) {
        return (T[]) c0().toArray(tArr);
    }
}
