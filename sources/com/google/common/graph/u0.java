package com.google.common.graph;

import com.google.common.collect.v7;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class u0<N, V> implements b0<N, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<N, V> f21727a;

    private u0(Map<N, V> map) {
        this.f21727a = (Map) com.google.common.base.e0.E(map);
    }

    static <N, V> u0<N, V> i() {
        return new u0<>(new HashMap(2, 1.0f));
    }

    static <N, V> u0<N, V> j(Map<N, V> map) {
        return new u0<>(v7.g(map));
    }

    @Override // com.google.common.graph.b0
    public Set<N> a() {
        return Collections.unmodifiableSet(this.f21727a.keySet());
    }

    @Override // com.google.common.graph.b0
    public Set<N> b() {
        return a();
    }

    @Override // com.google.common.graph.b0
    public Set<N> c() {
        return a();
    }

    @Override // com.google.common.graph.b0
    public V d(N n7) {
        return this.f21727a.remove(n7);
    }

    @Override // com.google.common.graph.b0
    public V e(N n7) {
        return this.f21727a.get(n7);
    }

    @Override // com.google.common.graph.b0
    public void f(N n7) {
        d(n7);
    }

    @Override // com.google.common.graph.b0
    public V g(N n7, V v7) {
        return this.f21727a.put(n7, v7);
    }

    @Override // com.google.common.graph.b0
    public void h(N n7, V v7) {
        g(n7, v7);
    }
}
