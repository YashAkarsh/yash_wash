package com.google.common.graph;

import com.google.common.collect.wb;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public abstract class g<N, V> extends com.google.common.graph.a<N> implements y0<N, V> {

    class a extends c<N> {
        a() {
        }

        @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
        public int c(N n7) {
            return g.this.c(n7);
        }

        @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
        public Set<t<N>> d() {
            return g.this.d();
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public boolean f() {
            return g.this.f();
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public s<N> g() {
            return g.this.g();
        }

        @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
        public int h(N n7) {
            return g.this.h(n7);
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public boolean i() {
            return g.this.i();
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public Set<N> j(N n7) {
            return g.this.j(n7);
        }

        @Override // com.google.common.graph.i, com.google.common.graph.z
        public Set<N> l() {
            return g.this.l();
        }

        @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
        public int m(N n7) {
            return g.this.m(n7);
        }

        @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
        public Set<N> a(N n7) {
            return g.this.a((Object) n7);
        }

        @Override // com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
        public Set<N> b(N n7) {
            return g.this.b((Object) n7);
        }
    }

    static class b implements com.google.common.base.s<t<N>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y0 f21628a;

        b(y0 y0Var) {
            this.f21628a = y0Var;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public V apply(t<N> tVar) {
            return (V) this.f21628a.y(tVar.f(), tVar.g(), null);
        }
    }

    private static <N, V> Map<t<N>, V> H(y0<N, V> y0Var) {
        return wb.o(y0Var.d(), new b(y0Var));
    }

    public Optional<V> E(N n7, N n8) {
        return Optional.ofNullable(y(n7, n8, null));
    }

    @Override // com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
    public /* bridge */ /* synthetic */ Iterable a(Object obj) {
        return a(obj);
    }

    @Override // com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
    public /* bridge */ /* synthetic */ Iterable b(Object obj) {
        return b(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ int c(Object obj) {
        return super.c(obj);
    }

    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    @Override // com.google.common.graph.y0
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return f() == y0Var.f() && l().equals(y0Var.l()) && H(this).equals(H(y0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ int h(Object obj) {
        return super.h(obj);
    }

    @Override // com.google.common.graph.y0
    public final int hashCode() {
        return H(this).hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ Set k(Object obj) {
        return super.k(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ int m(Object obj) {
        return super.m(obj);
    }

    @Override // com.google.common.graph.y0
    public z<N> q() {
        return new a();
    }

    public String toString() {
        return "isDirected: " + f() + ", allowsSelfLoops: " + i() + ", nodes: " + l() + ", edges: " + H(this);
    }
}
