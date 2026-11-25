package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
class b5<K, V> extends x<K, V> implements d5<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final tc<K, V> f19951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final com.google.common.base.g0<? super K> f19952g;

    static class a<K, V> extends r5<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f19953a;

        a(K k7) {
            this.f19953a = k7;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean add(V v7) {
            add(0, v7);
            return true;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.r5, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0 */
        public List<V> c0() {
            return Collections.emptyList();
        }

        @Override // com.google.common.collect.r5, java.util.List
        public void add(int i7, V v7) {
            com.google.common.base.e0.d0(i7, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f19953a);
        }

        @Override // com.google.common.collect.r5, java.util.List
        @u1.a
        public boolean addAll(int i7, Collection<? extends V> collection) {
            com.google.common.base.e0.E(collection);
            com.google.common.base.e0.d0(i7, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f19953a);
        }
    }

    static class b<K, V> extends d6<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f19954a;

        b(K k7) {
            this.f19954a = k7;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean add(V v7) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f19954a);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends V> collection) {
            com.google.common.base.e0.E(collection);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f19954a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.d6, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0 */
        public Set<V> c0() {
            return Collections.emptySet();
        }
    }

    class c extends j5<Map.Entry<K, V>> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.j5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public Collection<Map.Entry<K, V>> c0() {
            return h3.d(b5.this.f19951f.y(), b5.this.D());
        }

        @Override // com.google.common.collect.j5, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (b5.this.f19951f.containsKey(entry.getKey()) && b5.this.f19952g.apply((Object) entry.getKey())) {
                return b5.this.f19951f.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }
    }

    b5(tc<K, V> tcVar, com.google.common.base.g0<? super K> g0Var) {
        this.f19951f = (tc) com.google.common.base.e0.E(tcVar);
        this.f19952g = (com.google.common.base.g0) com.google.common.base.e0.E(g0Var);
    }

    @Override // com.google.common.collect.d5
    public com.google.common.base.g0<? super Map.Entry<K, V>> D() {
        return wb.Z(this.f19952g);
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    public Collection<V> a(Object obj) {
        return containsKey(obj) ? this.f19951f.a(obj) : m();
    }

    @Override // com.google.common.collect.x
    Map<K, Collection<V>> c() {
        return wb.L(this.f19951f.asMap(), this.f19952g);
    }

    @Override // com.google.common.collect.tc
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.tc
    public boolean containsKey(Object obj) {
        if (this.f19951f.containsKey(obj)) {
            return this.f19952g.apply(obj);
        }
        return false;
    }

    public tc<K, V> d() {
        return this.f19951f;
    }

    @Override // com.google.common.collect.x
    Collection<Map.Entry<K, V>> e() {
        return new c();
    }

    @Override // com.google.common.collect.x
    Set<K> f() {
        return af.i(this.f19951f.keySet(), this.f19952g);
    }

    @Override // com.google.common.collect.x
    hd<K> g() {
        return md.l(this.f19951f.keys(), this.f19952g);
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    public Collection<V> get(K k7) {
        if (this.f19952g.apply(k7)) {
            return this.f19951f.get(k7);
        }
        return this.f19951f instanceof ue ? new b(k7) : new a(k7);
    }

    @Override // com.google.common.collect.x
    Collection<V> h() {
        return new e5(this);
    }

    @Override // com.google.common.collect.x
    Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    Collection<V> m() {
        return this.f19951f instanceof ue ? u8.A() : d7.x();
    }

    @Override // com.google.common.collect.tc
    public int size() {
        Iterator<Collection<V>> it = asMap().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }
}
