package androidx.collection;

import c.m0;
import c.o0;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends i<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    h<K, V> f2255m;

    /* JADX INFO: renamed from: androidx.collection.a$a, reason: collision with other inner class name */
    class C0033a extends h<K, V> {
        C0033a() {
        }

        @Override // androidx.collection.h
        protected void a() {
            a.this.clear();
        }

        @Override // androidx.collection.h
        protected Object b(int i7, int i8) {
            return a.this.f2321b[(i7 << 1) + i8];
        }

        @Override // androidx.collection.h
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // androidx.collection.h
        protected int d() {
            return a.this.f2322c;
        }

        @Override // androidx.collection.h
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // androidx.collection.h
        protected int f(Object obj) {
            return a.this.i(obj);
        }

        @Override // androidx.collection.h
        protected void g(K k7, V v7) {
            a.this.put(k7, v7);
        }

        @Override // androidx.collection.h
        protected void h(int i7) {
            a.this.m(i7);
        }

        @Override // androidx.collection.h
        protected V i(int i7, V v7) {
            return a.this.n(i7, v7);
        }
    }

    public a() {
    }

    private h<K, V> r() {
        if (this.f2255m == null) {
            this.f2255m = new C0033a();
        }
        return this.f2255m;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return r().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return r().m();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f2322c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean q(@m0 Collection<?> collection) {
        return h.j(this, collection);
    }

    public boolean s(@m0 Collection<?> collection) {
        return h.o(this, collection);
    }

    public boolean t(@m0 Collection<?> collection) {
        return h.p(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return r().n();
    }

    public a(int i7) {
        super(i7);
    }

    public a(i iVar) {
        super(iVar);
    }
}
