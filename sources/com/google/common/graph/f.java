package com.google.common.graph;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class f<N, E> implements q0<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Map<E, N> f21622a;

    protected f(Map<E, N> map) {
        this.f21622a = (Map) com.google.common.base.e0.E(map);
    }

    @Override // com.google.common.graph.q0
    public Set<N> b() {
        return a();
    }

    @Override // com.google.common.graph.q0
    public Set<N> c() {
        return a();
    }

    @Override // com.google.common.graph.q0
    public N d(E e8, boolean z7) {
        if (z7) {
            return null;
        }
        return h(e8);
    }

    @Override // com.google.common.graph.q0
    public Set<E> e() {
        return Collections.unmodifiableSet(this.f21622a.keySet());
    }

    @Override // com.google.common.graph.q0
    public N f(E e8) {
        return (N) com.google.common.base.e0.E(this.f21622a.get(e8));
    }

    @Override // com.google.common.graph.q0
    public Set<E> g() {
        return e();
    }

    @Override // com.google.common.graph.q0
    public N h(E e8) {
        return (N) com.google.common.base.e0.E(this.f21622a.remove(e8));
    }

    @Override // com.google.common.graph.q0
    public Set<E> i() {
        return e();
    }

    @Override // com.google.common.graph.q0
    public void j(E e8, N n7) {
        com.google.common.base.e0.g0(this.f21622a.put(e8, n7) == null);
    }

    @Override // com.google.common.graph.q0
    public void l(E e8, N n7, boolean z7) {
        if (z7) {
            return;
        }
        j(e8, n7);
    }
}
