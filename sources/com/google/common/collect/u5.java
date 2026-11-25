package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class u5<K, V> extends b6 implements Map<K, V> {

    @s1.a
    protected abstract class a extends wb.t<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.wb.t
        Map<K, V> g() {
            return u5.this;
        }
    }

    @s1.a
    protected class b extends wb.c0<K, V> {
        public b() {
            super(u5.this);
        }
    }

    @s1.a
    protected class c extends wb.r0<K, V> {
        public c() {
            super(u5.this);
        }
    }

    protected u5() {
    }

    public void clear() {
        c0().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return c0().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return c0().containsValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.b6
    /* JADX INFO: renamed from: d0 */
    public abstract Map<K, V> c0();

    protected void e0() {
        ua.h(entrySet().iterator());
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return c0().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || c0().equals(obj);
    }

    @s1.a
    protected boolean f0(Object obj) {
        return wb.v(this, obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return c0().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return c0().hashCode();
    }

    protected boolean i0(Object obj) {
        return wb.w(this, obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return c0().isEmpty();
    }

    protected boolean j0(Object obj) {
        return wb.B(this, obj);
    }

    protected int k0() {
        return af.k(entrySet());
    }

    public Set<K> keySet() {
        return c0().keySet();
    }

    protected boolean m0() {
        return !entrySet().iterator().hasNext();
    }

    protected void n0(Map<? extends K, ? extends V> map) {
        wb.t0(this, map);
    }

    @s1.a
    protected V p0(Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (com.google.common.base.y.a(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    @u1.a
    public V put(K k7, V v7) {
        return c0().put(k7, v7);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        c0().putAll(map);
    }

    protected String q0() {
        return wb.I0(this);
    }

    @u1.a
    public V remove(Object obj) {
        return c0().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return c0().size();
    }

    public Collection<V> values() {
        return c0().values();
    }
}
