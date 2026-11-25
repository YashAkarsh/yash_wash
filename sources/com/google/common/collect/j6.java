package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class j6<R, C, V> extends b6 implements oj<R, C, V> {
    protected j6() {
    }

    @Override // com.google.common.collect.oj
    public Set<C> L() {
        return c0().L();
    }

    @Override // com.google.common.collect.oj
    public boolean M(Object obj) {
        return c0().M(obj);
    }

    @Override // com.google.common.collect.oj
    public void O(oj<? extends R, ? extends C, ? extends V> ojVar) {
        c0().O(ojVar);
    }

    @Override // com.google.common.collect.oj
    public boolean P(Object obj, Object obj2) {
        return c0().P(obj, obj2);
    }

    @Override // com.google.common.collect.oj
    public Map<C, Map<R, V>> S() {
        return c0().S();
    }

    @Override // com.google.common.collect.oj
    public Map<C, V> X(R r7) {
        return c0().X(r7);
    }

    @Override // com.google.common.collect.oj
    public void clear() {
        c0().clear();
    }

    @Override // com.google.common.collect.oj
    public boolean containsValue(Object obj) {
        return c0().containsValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.b6
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public abstract oj<R, C, V> c0();

    @Override // com.google.common.collect.oj
    public boolean equals(Object obj) {
        return obj == this || c0().equals(obj);
    }

    @Override // com.google.common.collect.oj
    public Map<R, Map<C, V>> f() {
        return c0().f();
    }

    @Override // com.google.common.collect.oj
    public Set<R> g() {
        return c0().g();
    }

    @Override // com.google.common.collect.oj
    public int hashCode() {
        return c0().hashCode();
    }

    @Override // com.google.common.collect.oj
    public boolean isEmpty() {
        return c0().isEmpty();
    }

    @Override // com.google.common.collect.oj
    public V k(Object obj, Object obj2) {
        return c0().k(obj, obj2);
    }

    @Override // com.google.common.collect.oj
    public boolean m(Object obj) {
        return c0().m(obj);
    }

    @Override // com.google.common.collect.oj
    public Map<R, V> n(C c8) {
        return c0().n(c8);
    }

    @Override // com.google.common.collect.oj
    public Set<oj.a<R, C, V>> r() {
        return c0().r();
    }

    @Override // com.google.common.collect.oj
    @u1.a
    public V remove(Object obj, Object obj2) {
        return c0().remove(obj, obj2);
    }

    @Override // com.google.common.collect.oj
    public int size() {
        return c0().size();
    }

    @Override // com.google.common.collect.oj
    @u1.a
    public V t(R r7, C c8, V v7) {
        return c0().t(r7, c8, v7);
    }

    @Override // com.google.common.collect.oj
    public Collection<V> values() {
        return c0().values();
    }
}
