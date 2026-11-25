package com.google.common.graph;

import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class w<N, E> extends e<N, E> {
    w() {
    }

    @Override // com.google.common.graph.o0
    public s<E> A() {
        return I().A();
    }

    @Override // com.google.common.graph.o0
    public Set<E> C(N n7) {
        return I().C(n7);
    }

    protected abstract o0<N, E> I();

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    public int c(N n7) {
        return I().c(n7);
    }

    @Override // com.google.common.graph.o0
    public Set<E> d() {
        return I().d();
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    public boolean e(N n7, N n8) {
        return I().e(n7, n8);
    }

    @Override // com.google.common.graph.o0
    public boolean f() {
        return I().f();
    }

    @Override // com.google.common.graph.o0
    public s<N> g() {
        return I().g();
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    public int h(N n7) {
        return I().h(n7);
    }

    @Override // com.google.common.graph.o0
    public boolean i() {
        return I().i();
    }

    @Override // com.google.common.graph.o0
    public Set<N> j(N n7) {
        return I().j(n7);
    }

    @Override // com.google.common.graph.o0
    public Set<E> k(N n7) {
        return I().k(n7);
    }

    @Override // com.google.common.graph.o0
    public Set<N> l() {
        return I().l();
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    public int m(N n7) {
        return I().m(n7);
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    public E r(N n7, N n8) {
        return I().r(n7, n8);
    }

    @Override // com.google.common.graph.o0
    public Set<E> s(N n7) {
        return I().s(n7);
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    public Set<E> t(E e8) {
        return I().t(e8);
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    public Set<E> u(N n7, N n8) {
        return I().u(n7, n8);
    }

    @Override // com.google.common.graph.o0
    public boolean v() {
        return I().v();
    }

    @Override // com.google.common.graph.o0
    public t<N> w(E e8) {
        return I().w(e8);
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    public Optional<E> x(N n7, N n8) {
        return I().x(n7, n8);
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0, com.google.common.graph.r0
    public Set<N> a(N n7) {
        return I().a((Object) n7);
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0, com.google.common.graph.s0
    public Set<N> b(N n7) {
        return I().b((Object) n7);
    }
}
