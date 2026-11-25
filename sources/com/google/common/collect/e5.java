package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class e5<K, V> extends AbstractCollection<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @y1.i
    private final d5<K, V> f20195a;

    e5(d5<K, V> d5Var) {
        this.f20195a = (d5) com.google.common.base.e0.E(d5Var);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f20195a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f20195a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return wb.a1(this.f20195a.y().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        com.google.common.base.g0<? super Map.Entry<K, V>> g0VarD = this.f20195a.D();
        Iterator<Map.Entry<K, V>> it = this.f20195a.d().y().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (g0VarD.apply(next) && com.google.common.base.y.a(next.getValue(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return ma.J(this.f20195a.d().y(), com.google.common.base.h0.d(this.f20195a.D(), wb.c1(com.google.common.base.h0.n(collection))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return ma.J(this.f20195a.d().y(), com.google.common.base.h0.d(this.f20195a.D(), wb.c1(com.google.common.base.h0.q(com.google.common.base.h0.n(collection)))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f20195a.size();
    }
}
