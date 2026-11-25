package com.google.common.graph;

import com.google.common.collect.af;
import com.google.common.collect.ck;
import com.google.common.collect.ma;
import com.google.common.collect.ua;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class b<N, E> implements q0<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Map<E, N> f21585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Map<E, N> f21586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21587c;

    class a extends AbstractSet<E> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ck<E> iterator() {
            return ua.f0((b.this.f21587c == 0 ? ma.f(b.this.f21585a.keySet(), b.this.f21586b.keySet()) : af.O(b.this.f21585a.keySet(), b.this.f21586b.keySet())).iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b.this.f21585a.containsKey(obj) || b.this.f21586b.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.math.d.t(b.this.f21585a.size(), b.this.f21586b.size() - b.this.f21587c);
        }
    }

    protected b(Map<E, N> map, Map<E, N> map2, int i7) {
        this.f21585a = (Map) com.google.common.base.e0.E(map);
        this.f21586b = (Map) com.google.common.base.e0.E(map2);
        this.f21587c = d0.b(i7);
        com.google.common.base.e0.g0(i7 <= map.size() && i7 <= map2.size());
    }

    @Override // com.google.common.graph.q0
    public Set<N> a() {
        return af.O(c(), b());
    }

    @Override // com.google.common.graph.q0
    public N d(E e8, boolean z7) {
        if (z7) {
            int i7 = this.f21587c - 1;
            this.f21587c = i7;
            d0.b(i7);
        }
        return (N) com.google.common.base.e0.E(this.f21585a.remove(e8));
    }

    @Override // com.google.common.graph.q0
    public Set<E> e() {
        return new a();
    }

    @Override // com.google.common.graph.q0
    public N f(E e8) {
        return (N) com.google.common.base.e0.E(this.f21586b.get(e8));
    }

    @Override // com.google.common.graph.q0
    public Set<E> g() {
        return Collections.unmodifiableSet(this.f21585a.keySet());
    }

    @Override // com.google.common.graph.q0
    public N h(E e8) {
        return (N) com.google.common.base.e0.E(this.f21586b.remove(e8));
    }

    @Override // com.google.common.graph.q0
    public Set<E> i() {
        return Collections.unmodifiableSet(this.f21586b.keySet());
    }

    @Override // com.google.common.graph.q0
    public void j(E e8, N n7) {
        com.google.common.base.e0.g0(this.f21586b.put(e8, n7) == null);
    }

    @Override // com.google.common.graph.q0
    public void l(E e8, N n7, boolean z7) {
        if (z7) {
            int i7 = this.f21587c + 1;
            this.f21587c = i7;
            d0.d(i7);
        }
        com.google.common.base.e0.g0(this.f21585a.put(e8, n7) == null);
    }
}
