package com.google.common.graph;

import com.google.common.collect.ck;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class h0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<K, V> f21631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Map.Entry<K, V> f21632b;

    class a extends AbstractSet<K> {

        /* JADX INFO: renamed from: com.google.common.graph.h0$a$a, reason: collision with other inner class name */
        class C0274a extends ck<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator f21634a;

            C0274a(Iterator it) {
                this.f21634a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f21634a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry entry = (Map.Entry) this.f21634a.next();
                h0.this.f21632b = entry;
                return (K) entry.getKey();
            }
        }

        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ck<K> iterator() {
            return new C0274a(h0.this.f21631a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h0.this.e(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h0.this.f21631a.size();
        }
    }

    h0(Map<K, V> map) {
        this.f21631a = (Map) com.google.common.base.e0.E(map);
    }

    public void c() {
        d();
        this.f21631a.clear();
    }

    protected void d() {
        this.f21632b = null;
    }

    public final boolean e(Object obj) {
        return g(obj) != null || this.f21631a.containsKey(obj);
    }

    public V f(Object obj) {
        V vG = g(obj);
        return vG != null ? vG : h(obj);
    }

    protected V g(Object obj) {
        Map.Entry<K, V> entry = this.f21632b;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    public final V h(Object obj) {
        return this.f21631a.get(obj);
    }

    @u1.a
    public V i(K k7, V v7) {
        d();
        return this.f21631a.put(k7, v7);
    }

    @u1.a
    public V j(Object obj) {
        d();
        return this.f21631a.remove(obj);
    }

    public final Set<K> k() {
        return new a();
    }
}
