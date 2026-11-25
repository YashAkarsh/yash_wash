package com.google.common.graph;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class l<N, V> extends n<N, V> implements m0<N, V> {
    l(d<? super N> dVar) {
        super(dVar);
    }

    @u1.a
    private b0<N, V> K(N n7) {
        b0<N, V> b0VarL = L();
        com.google.common.base.e0.g0(this.f21655d.i(n7, b0VarL) == null);
        return b0VarL;
    }

    private b0<N, V> L() {
        return f() ? o.p() : u0.i();
    }

    @Override // com.google.common.graph.m0
    @u1.a
    public V D(N n7, N n8, V v7) {
        com.google.common.base.e0.F(n7, "nodeU");
        com.google.common.base.e0.F(n8, "nodeV");
        com.google.common.base.e0.F(v7, "value");
        if (!i()) {
            com.google.common.base.e0.u(!n7.equals(n8), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n7);
        }
        b0<N, V> b0VarF = this.f21655d.f(n7);
        if (b0VarF == null) {
            b0VarF = K(n7);
        }
        V vG = b0VarF.g(n8, v7);
        b0<N, V> b0VarF2 = this.f21655d.f(n8);
        if (b0VarF2 == null) {
            b0VarF2 = K(n8);
        }
        b0VarF2.h(n7, v7);
        if (vG == null) {
            long j7 = this.f21656e + 1;
            this.f21656e = j7;
            d0.e(j7);
        }
        return vG;
    }

    @Override // com.google.common.graph.m0
    @u1.a
    public boolean n(N n7) {
        com.google.common.base.e0.F(n7, "node");
        if (J(n7)) {
            return false;
        }
        K(n7);
        return true;
    }

    @Override // com.google.common.graph.m0
    @u1.a
    public boolean o(N n7) {
        com.google.common.base.e0.F(n7, "node");
        b0<N, V> b0VarF = this.f21655d.f(n7);
        if (b0VarF == null) {
            return false;
        }
        if (i() && b0VarF.d(n7) != null) {
            b0VarF.f(n7);
            this.f21656e--;
        }
        Iterator<N> it = b0VarF.b().iterator();
        while (it.hasNext()) {
            this.f21655d.h(it.next()).f(n7);
            this.f21656e--;
        }
        if (f()) {
            Iterator<N> it2 = b0VarF.c().iterator();
            while (it2.hasNext()) {
                com.google.common.base.e0.g0(this.f21655d.h(it2.next()).d(n7) != null);
                this.f21656e--;
            }
        }
        this.f21655d.j(n7);
        d0.c(this.f21656e);
        return true;
    }

    @Override // com.google.common.graph.m0
    @u1.a
    public V p(N n7, N n8) {
        com.google.common.base.e0.F(n7, "nodeU");
        com.google.common.base.e0.F(n8, "nodeV");
        b0<N, V> b0VarF = this.f21655d.f(n7);
        b0<N, V> b0VarF2 = this.f21655d.f(n8);
        if (b0VarF == null || b0VarF2 == null) {
            return null;
        }
        V vD = b0VarF.d(n8);
        if (vD != null) {
            b0VarF2.f(n7);
            long j7 = this.f21656e - 1;
            this.f21656e = j7;
            d0.c(j7);
        }
        return vD;
    }
}
